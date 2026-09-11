package application.Samples.Feature.signInAgain;

import application.config.BaseTestForSamples;
import application.config.oidc.keycloak.KeycloakAdmin;
import application.config.props.Env;
import com.codeborne.selenide.Selenide;
import core.config.selenide.BrowserDevTools;
import core.element.PlatformApp;
import io.qameta.allure.Allure;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import java.net.URI;
import java.time.Duration;
import java.time.Instant;
import java.util.List;
import java.util.UUID;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.EnabledIfEnvironmentVariable;
import org.openqa.selenium.WindowType;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.switchTo;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * CXBOX-1250. Two tabs of one browser share the stored user and its refresh token. With refresh token rotation in the OIDC
 * provider a refresh token works once, so the renewal must happen once for both tabs: a Web Lock in {@code ui/src/auth/tokenRenewal.ts}.
 * <p>
 * The race is provoked, not hoped for: every request of both tabs is delayed by {@link #RENEWAL_HOLD}, so the renewal the first tab
 * starts 60 seconds before expiry is still in flight when the second tab's timer fires. Then the lock is switched off with the QA hook
 * ({@code ?token_renew_lock=off}) and the same scenario is shown to break, which is what the lock is there for.
 * Known and unfixed in oidc-client-ts: https://github.com/authts/oidc-client-ts/issues/430.
 */
@DisplayName("Authorization: one token renewal for all tabs of the browser")
@Epic("Samples")
@Tag("Samples")
@Tag("Slow")
@EnabledIfEnvironmentVariable(named = "KEYCLOAK_ADMIN_USER", matches = ".+", disabledReason = "reads the realm settings, needs the admin account")
public class TokenRenewalAcrossTabsTest extends BaseTestForSamples {

	private static final String DEMO_LOGIN = "demo";

	/**
	 * A user of this run only: parallel runs against the same Keycloak never meet, and the SSO sessions counted are all ours
	 */
	private static final String USER_LOGIN = "tabs-" + UUID.randomUUID().toString().substring(0, 8);

	private static final String USER_PASSWORD = UUID.randomUUID().toString();

	private static final String SCREEN_A = "Input basic";

	private static final String SCREEN_B = "Picklist basic";

	private static final String LOCK_OFF_QUERY = "token_renew_lock=off";

	/**
	 * Longer than the gap between the expiry timers of two tabs (oidc-client-ts polls every 5 seconds), shorter than the lock wait
	 */
	private static final Duration RENEWAL_HOLD = Duration.ofSeconds(6);

	private static final Duration POLL = Duration.ofSeconds(2);

	private static KeycloakAdmin keycloakAdmin;

	/**
	 * When the renewal ahead of expiry must have happened: the lifetime minus the 60 seconds margin of the library, plus a reserve
	 */
	private static Duration renewalDeadline;

	@BeforeAll
	static void createTestUser() {
		keycloakAdmin = KeycloakAdmin.forApp(Env.uri());
		renewalDeadline = keycloakAdmin.getAccessTokenLifespan().minusSeconds(60).plusSeconds(30);
		keycloakAdmin.createUser(USER_LOGIN, USER_PASSWORD, keycloakAdmin.getClientRoles(DEMO_LOGIN));
		Runtime.getRuntime().addShutdownHook(new Thread(TokenRenewalAcrossTabsTest::deleteTestUser));
	}

	@AfterAll
	static void deleteTestUser() {
		keycloakAdmin.deleteUser(USER_LOGIN);
	}

	@BeforeEach
	@Override
	public void beforeEach() {
		super.beforeEach();
		super.logout();
		super.login(USER_LOGIN, USER_PASSWORD);
		PlatformApp.screen(SCREEN_A);
	}

	/**
	 * The browser is shared by the tests of a fork: the network hold and the freeze must not outlive the test, even a failed one
	 */
	@AfterEach
	public void closeOtherTabs() {
		while (switchTo().window(0).getWindowHandles().size() > 1) {
			switchTo().window(1);
			BrowserDevTools.unfreezeTab();
			Selenide.closeWindow();
		}
		switchTo().window(0);
		BrowserDevTools.delayNetwork(Duration.ZERO);
	}

	@Test
	@DisplayName("Two tabs, the token is about to expire: one renewal request, both tabs go on working")
	@Description("Both tabs get the \"expiring\" event within a second of each other. The first one holds the lock while its request is in flight, "
			+ "the second one waits, finds the renewed token in the storage and sends nothing. The session in the OIDC provider stays alive.")
	public void expiringToken_oneRenewalForBothTabs() {
		openSecondTab(Env.uri());
		var console = waitForRenewal();

		assertThat(countTokenRequests()).as("one renewal for both tabs; console: " + renewalLog(console)).isEqualTo(1);
		assertThat(console).anyMatch(message -> message.contains(RENEWED_BY_ANOTHER_TAB));
		workInBothTabs();
		assertThat(keycloakAdmin.countSessions(USER_LOGIN)).as("SSO sessions of the user").isEqualTo(1);
	}

	@Test
	@DisplayName("The same without the lock (QA hook): both tabs send the same refresh token, the second one gets invalid_grant")
	@Description("Shows the race the lock removes. With \"Revoke Refresh Token\" in the realm the reuse also revokes the refresh token "
			+ "the first tab has just received: the next renewal fails in both tabs and the \"Sign in again?\" popup is shown while the user did nothing wrong.")
	public void expiringToken_withoutLock_bothTabsSendTheSameRefreshToken() {
		open(withQuery(Env.uri(), LOCK_OFF_QUERY).toString());
		PlatformApp.screen(SCREEN_A);
		openSecondTab(withQuery(Env.uri(), LOCK_OFF_QUERY));
		var console = waitForRenewal();

		assertThat(countTokenRequests()).as("both tabs sent their own renewal; console: " + renewalLog(console)).isEqualTo(2);
		assertThat(console).as("the second one was refused").anyMatch(message -> message.contains(RENEWAL_FAILED));
	}

	@Test
	@DisplayName("A tab frozen by the browser through the renewal: after waking up it uses the token the other tab renewed")
	@Description("The second tab is frozen the way Chrome freezes background tabs: no timers, no code. The first tab renews alone. "
			+ "Once unfrozen, the second tab finds the renewed token in the storage and works on without a renewal of its own.")
	public void frozenTab_usesTheTokenRenewedByTheOtherTab() {
		openSecondTab(Env.uri());
		BrowserDevTools.freezeTab();
		switchTo().window(0);
		waitUntilTokenRequested();

		BrowserDevTools.clearNetworkLog();
		BrowserDevTools.clearConsoleLog();
		switchTo().window(1);
		BrowserDevTools.unfreezeTab();
		PlatformApp.screen(SCREEN_B);
		PlatformApp.signInAgainPopup().shouldNotBeShown();
		assertThat(countTokenRequests()).as("token requests of the woken tab").isZero();
	}

	// helpers --------------------------------------------------------------------------------------------------------------

	/**
	 * Opens the application in a second tab (signed in by the SSO session, no login page) on the first screen
	 */
	private static void openSecondTab(URI url) {
		Allure.step("Open a second tab", () -> {
			switchTo().newWindow(WindowType.TAB);
			open(url.toString());
			PlatformApp.screen(SCREEN_A);
			switchTo().window(0);
			BrowserDevTools.clearNetworkLog();
			BrowserDevTools.clearConsoleLog();
		});
	}

	/**
	 * Holds every request of both tabs for {@link #RENEWAL_HOLD}, waits for the renewal ahead of expiry, lifts the hold.
	 * Returns the console written meanwhile; the token requests stay in the network log for the caller to count.
	 */
	private static List<String> waitForRenewal() {
		return Allure.step("Wait for the renewal ahead of expiry (up to " + renewalDeadline.toSeconds() + " s)", () -> {
			forBothTabs(() -> BrowserDevTools.delayNetwork(RENEWAL_HOLD));
			waitUntilTokenRequested();
			// the other tab's request, if any, is in flight for RENEWAL_HOLD at most
			Selenide.sleep(RENEWAL_HOLD.plus(POLL).toMillis());
			forBothTabs(() -> BrowserDevTools.delayNetwork(Duration.ZERO));
			return BrowserDevTools.consoleLog();
		});
	}

	private static void waitUntilTokenRequested() {
		Allure.step("Wait for the first renewal request", () -> {
			var deadline = Instant.now().plus(renewalDeadline);
			while (countTokenRequests() == 0) {
				assertThat(Instant.now()).as("no token request before the deadline").isBefore(deadline);
				Selenide.sleep(POLL.toMillis());
			}
		});
	}

	/**
	 * What the application wrote about the renewal, for the failure message
	 */
	private static List<String> renewalLog(List<String> console) {
		return console.stream().filter(message -> message.contains("token") || message.contains("lock")).toList();
	}

	private static void workInBothTabs() {
		Allure.step("Work in both tabs", () -> forBothTabs(() -> {
			PlatformApp.screen(SCREEN_B);
			PlatformApp.signInAgainPopup().shouldNotBeShown();
		}));
	}

	private static void forBothTabs(Runnable action) {
		for (int tab = 0; tab < 2; tab++) {
			switchTo().window(tab);
			action.run();
		}
		switchTo().window(0);
	}

	/**
	 * The query goes before the hash: {@code http://host/ui/?token_renew_lock=off#/}
	 */
	private static URI withQuery(URI url, String query) {
		var text = url.toString();
		int hash = text.indexOf('#');
		return URI.create(hash < 0 ? text + "?" + query : text.substring(0, hash) + "?" + query + text.substring(hash));
	}

}
