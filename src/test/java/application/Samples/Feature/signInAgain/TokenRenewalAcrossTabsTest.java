package application.Samples.Feature.signInAgain;

import application.config.BaseTestForSamples;
import application.config.oidc.keycloak.KeycloakAdmin;
import application.config.props.Env;
import com.codeborne.selenide.Selenide;
import core.config.OidcProvider;
import core.config.selenide.BrowserDevTools;
import core.element.PlatformApp;
import io.qameta.allure.Allure;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import java.net.URI;
import java.time.Duration;
import java.time.Instant;
import java.util.Collections;
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
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import org.openqa.selenium.WindowType;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.switchTo;
import static core.element.widget.modal.SignInAgainPopup.Reason.SESSION_EXPIRED;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * CXBOX-1250. Two tabs of one browser share the stored user and its refresh token. With refresh token rotation in the OIDC
 * provider a refresh token works once, and a second use reads as theft. The invariant of {@code ui/src/auth/rotationSafeUserManager}:
 * one refresh token is sent to the provider at most once - by all the tabs, and through every reload of the page. The tests read
 * the tokens out of the requests the browser really sent, see {@link #refreshTokensSent()}.
 * <p>
 * <b>The build constants of {@code ui/src/constants/index.ts} this class is written for.</b> They are compiled into the frontend;
 * only {@code USER_MANAGER} can be switched by a test, see {@link #useUserManager}:
 * <ul>
 *     <li>{@code USER_MANAGER}: <b>both values</b>. The tests with the parameter run the same scenario with {@code 'rotationSafe'}
 *     and with {@code 'original'}, and the expected result differs: it is what the class {@code RotationSafeUserManager} is
 *     for. The tests without the parameter are about {@code 'rotationSafe'} only and say so in their names.</li>
 *     <li>{@code AUTH_ERROR_MODE}: any value, no test here closes the popup.</li>
 *     <li>{@code SIGN_IN_CALLBACK_DETECTION}: any value.</li>
 * </ul>
 * <p>
 * The races are provoked, not hoped for: the network of a tab is held or slowed down through the DevTools protocol, a tab is
 * frozen the way Chrome freezes background tabs, the page is reloaded in the middle of a renewal, and a token is spent from the
 * test itself. Nothing in the application is switched off to make it happen. No test waits the lifetime of an access token
 * out: {@link #accessTokenEndsIn} brings its end closer, and the tokens stay real.
 * Known and unfixed in oidc-client-ts: https://github.com/authts/oidc-client-ts/issues/430.
 */
@DisplayName("Authorization: a refresh token is sent once for all tabs and through F5")
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

	/**
	 * Longer than the gap between the expiry timers of two tabs (oidc-client-ts polls every 5 seconds)
	 */
	private static final Duration RENEWAL_HOLD = Duration.ofSeconds(6);

	/**
	 * The answer of the provider with new tokens is a few kilobytes: at this speed it is on its way for a good ten seconds, which
	 * is the time the test has to press F5 in the middle of it
	 */
	private static final long SLOW_ANSWER_BYTES_PER_SECOND = 200;

	private static final Duration POLL = Duration.ofSeconds(2);

	/**
	 * A request that needs a token waits for the renewal first, up to 30 seconds for the hidden iframe. Only then the popup comes up
	 */
	private static final Duration RENEWAL_GIVES_UP = Duration.ofSeconds(45);

	private static KeycloakAdmin keycloakAdmin;

	/**
	 * When the renewal ahead of expiry must have started after {@link #renewalAheadStartsSoon}: a few seconds to the end of the
	 * token, the timer of oidc-client-ts that polls every 5 seconds, and a reserve for a slow CI runner
	 */
	private static final Duration renewalDeadline = Duration.ofSeconds(40);

	/**
	 * When a tab that could not renew with the refresh token must have renewed by the SSO cookie: it waits for the tab that sent
	 * the token for almost a minute, then asks through the hidden iframe. And when a tab that cannot renew at all must have shown
	 * the popup
	 */
	private static final Duration recoveryDeadline = Duration.ofSeconds(120);

	@BeforeAll
	static void createTestUser() {
		keycloakAdmin = KeycloakAdmin.forApp(Env.uri());
		keycloakAdmin.createUser(USER_LOGIN, USER_PASSWORD, keycloakAdmin.getClientRoles(DEMO_LOGIN));
		Runtime.getRuntime().addShutdownHook(new Thread(TokenRenewalAcrossTabsTest::deleteTestUser));
	}

	@AfterAll
	static void deleteTestUser() {
		keycloakAdmin.deleteUser(USER_LOGIN);
	}

	/**
	 * Every test signs in by itself, see {@link #signIn}: the user manager is chosen before the application loads
	 */
	@BeforeEach
	@Override
	public void beforeEach() {
		super.beforeEach();
		super.logout();
	}

	/**
	 * The browser is shared by the tests of a fork, so nothing of this test may outlive it, even a failed one: neither the network
	 * hold and the freeze nor the session of its own user. The logout leaves the browser in the one state the next test expects
	 * from {@link BaseTestForSamples#beforeEach()}: signed out, storage and cookies empty - the chosen user manager goes with them.
	 */
	@AfterEach
	public void cleanUpBrowser() {
		while (switchTo().window(0).getWindowHandles().size() > 1) {
			switchTo().window(1);
			BrowserDevTools.unfreezeTab();
			Selenide.closeWindow();
		}
		switchTo().window(0);
		BrowserDevTools.unfreezeTab();
		BrowserDevTools.delayNetwork(Duration.ZERO);
		logout();
	}

	// the same scenario, USER_MANAGER = 'rotationSafe' and 'original': the expected result differs ---------------------------------

	@ParameterizedTest(name = "USER_MANAGER = {0}")
	@EnumSource(UserManager.class)
	@DisplayName("Two tabs, the token is about to expire")
	@Description("Both tabs get the \"expiring\" event within seconds of each other, and the network holds every request for a while. "
			+ "Expected with 'rotationSafe': the first tab locks the refresh token and sends it, the second one finds the token "
			+ "locked, sends nothing and takes the tokens the first one stored; one request, one SSO session, both tabs work. "
			+ "Expected with 'original': every tab sends the shared refresh token on its own, the same token goes to the provider "
			+ "twice (oidc-client-ts #430).")
	public void expiringToken_twoTabs(UserManager userManager) {
		signIn(userManager);
		var expiring = OidcProvider.storedRefreshToken();
		openSecondTab(Env.uri());
		waitForRenewal();

		switch (userManager) {
			case ROTATION_SAFE -> {
				assertThat(refreshTokensSent()).as("one request with the refresh token for both tabs").containsExactly(expiring);
				workInBothTabs();
				assertThat(keycloakAdmin.countSessions(USER_LOGIN)).as("SSO sessions of the user").isEqualTo(1);
				assertNoRefreshTokenSentTwice();
			}
			case ORIGINAL -> assertThat(Collections.frequency(refreshTokensSent(), expiring))
					.as("oidc-client-ts as it is: both tabs sent the same refresh token")
					.isGreaterThanOrEqualTo(2);
		}
	}

	@ParameterizedTest(name = "USER_MANAGER = {0}")
	@EnumSource(UserManager.class)
	@DisplayName("F5 in the middle of a renewal")
	@Description("The provider is slow: the request with the refresh token has left, the provider has rotated the token, and the "
			+ "answer crawls back. The user sees nothing happening and presses F5. The new tokens are lost with the old page, and the "
			+ "old refresh token is spent. "
			+ "Expected with 'rotationSafe': the loaded page finds that token locked - it was sent, and no new one has come, so it is "
			+ "burnt and never sent again. The renewal goes on with the SSO cookie through the hidden iframe, no popup and no login page. "
			+ "Expected with 'original': the loaded page sends the same refresh token again - the second use that a provider with "
			+ "rotation reads as theft.")
	public void f5DuringRenewal(UserManager userManager) {
		signIn(userManager);
		var onItsWay = OidcProvider.storedRefreshToken();
		renewalAheadStartsSoon();
		BrowserDevTools.throttleDownload(SLOW_ANSWER_BYTES_PER_SECOND);
		waitUntilRefreshTokenSent();

		Allure.step("F5 while the answer of the provider is on its way", () -> {
			// no script on the page: the driver does not get its answer while the download is slow
			BrowserDevTools.reload();
			BrowserDevTools.throttleDownload(-1);
		});

		switch (userManager) {
			case ROTATION_SAFE -> {
				waitUntilRefreshTokenReplaced(onItsWay, recoveryDeadline);
				PlatformApp.screen(SCREEN_B);
				PlatformApp.signInAgainPopup().shouldNotBeShown(POLL);
				PlatformApp.userMenu().shouldBeDisplayed();
				assertThat(refreshTokensSent()).as("the token that was on its way during F5 was sent once").containsOnlyOnce(onItsWay);
				assertNoRefreshTokenSentTwice();
			}
			case ORIGINAL -> {
				Allure.step("Wait for the second request with the same refresh token (up to " + renewalDeadline.toSeconds() + " s)", () -> {
					var deadline = Instant.now().plus(renewalDeadline);
					while (Collections.frequency(refreshTokensSent(), onItsWay) < 2 && Instant.now().isBefore(deadline)) {
						Selenide.sleep(POLL.toMillis());
					}
				});
				assertThat(Collections.frequency(refreshTokensSent(), onItsWay))
						.as("oidc-client-ts as it is: the page loaded by F5 sent the same refresh token again")
						.isGreaterThanOrEqualTo(2);
			}
		}
	}

	@ParameterizedTest(name = "USER_MANAGER = {0}")
	@EnumSource(UserManager.class)
	@DisplayName("The refresh token was spent outside the browser")
	@Description("The test takes the refresh token the application keeps in the browser and spends it once itself, without touching "
			+ "the application at all. The renewal of the application is then a second use of the same token, and the provider refuses it. "
			+ "Expected with 'rotationSafe': the token is burnt instead of being presented again, and the renewal goes on through the "
			+ "hidden iframe, which asks with the SSO session cookie. The user sees nothing, and a fresh refresh token appears in the "
			+ "storage. (Where the browser keeps its cookie out of the iframe the popup comes instead.) "
			+ "Expected with 'original': nothing else is tried, and when the access token is over the popup \"Session has expired\" opens.")
	public void refreshTokenSpentElsewhere(UserManager userManager) {
		signIn(userManager);
		var spent = OidcProvider.storedRefreshToken();
		assertThat(spent).as("the application keeps a refresh token").isNotBlank();
		assertThat(oidc().spendRefreshToken(spent)).as("the provider accepted the token used from outside").isTrue();
		renewalAheadStartsSoon();

		switch (userManager) {
			case ROTATION_SAFE -> {
				// the request leaving the browser is not the answer coming back. Waiting for the one and asking about the other is
				// a race: on a slower machine the provider had not refused yet when the console was read
				var refusal = consoleUntil(TOKEN_BURNT);
				assertThat(refusal).as("the renewal with the spent token was refused and the token was burnt; console: " + refusal).isNotEmpty();

				waitUntilRefreshTokenReplaced(spent, recoveryDeadline);
				PlatformApp.screen(SCREEN_B);
				PlatformApp.signInAgainPopup().shouldNotBeShown(POLL);
				PlatformApp.userMenu().shouldBeDisplayed();
				assertNoRefreshTokenSentTwice();
			}
			case ORIGINAL -> {
				accessTokenEndsIn(ABOUT_TO_END);
				workUntilSignInAgainPopupShows();
				PlatformApp.signInAgainPopup().checkReason(reason -> assertThat(reason).isEqualTo(SESSION_EXPIRED));
				assertThat(OidcProvider.storedRefreshToken()).as("oidc-client-ts as it is: the session was not restored").isEqualTo(spent);
			}
		}
	}

	// USER_MANAGER = 'rotationSafe' only: there is nothing to compare with, 'original' has no notion of a locked token ---------------

	@Test
	@DisplayName("USER_MANAGER = rotationSafe. A tab frozen by the browser through the renewal: after waking up it uses the token the other tab renewed")
	@Description("The second tab is frozen the way Chrome freezes background tabs: no timers, no code. The first tab renews alone. "
			+ "Once unfrozen, the second tab finds the renewed token in the storage and works on without a renewal of its own.")
	public void frozenTab_usesTheTokenRenewedByTheOtherTab() {
		signIn(UserManager.ROTATION_SAFE);
		var renewedByTheFirstTab = OidcProvider.storedRefreshToken();
		openSecondTab(Env.uri());
		switchTo().window(1);
		BrowserDevTools.freezeTab();
		switchTo().window(0);
		renewalAheadStartsSoon();
		waitUntilRefreshTokenReplaced(renewedByTheFirstTab, renewalDeadline);

		BrowserDevTools.clearNetworkLog();
		switchTo().window(1);
		BrowserDevTools.unfreezeTab();
		PlatformApp.screen(SCREEN_B);
		PlatformApp.signInAgainPopup().shouldNotBeShown();
		assertThat(refreshTokensSent()).as("refresh tokens sent by the woken tab").isEmpty();
	}

	@Test
	@DisplayName("USER_MANAGER = rotationSafe. The tab that sent the refresh token hangs for ever: the other tab never sends the same token, it renews by the cookie")
	@Description("The first tab locks the refresh token, starts a request that does not finish, and is frozen: it will never store new "
			+ "tokens and never say that it failed. The second tab finds the token locked. It waits for the sender for a while, and "
			+ "then the one thing it must not do is send the same refresh token, because that second use is what ends the whole "
			+ "session. It asks with the SSO cookie through the hidden iframe instead, and both the wait and the renewal are invisible "
			+ "to the user.")
	public void senderHangs_theOtherTabRenewsByTheCookie() {
		signIn(UserManager.ROTATION_SAFE);
		var locked = OidcProvider.storedRefreshToken();
		openSecondTab(Env.uri());
		try {
			Allure.step("The first tab sends the refresh token, the request hangs, and the tab is frozen", () -> {
				// only this tab has read the new end of the token, so it is the one that sends the refresh token
				renewalAheadStartsSoon();
				BrowserDevTools.delayNetwork(Duration.ofSeconds(40));
				waitUntilRefreshTokenSent();
				// the renewal of that tab would give up on its own timeout, and its page would say so. Frozen, the tab runs no code
				// at all: this is a sender that is neither done nor dead
				BrowserDevTools.freezeTab();
			});

			switchTo().window(1);
			BrowserDevTools.clearNetworkLog();
			// a request: the second tab reads the end of the token too, and starts its own renewal
			PlatformApp.screen(SCREEN_B);
			waitUntilRefreshTokenReplaced(locked, recoveryDeadline);

			PlatformApp.signInAgainPopup().shouldNotBeShown(POLL);
			assertThat(refreshTokensSent()).as("the second tab never sent the token the first tab had locked").doesNotContain(locked);
			assertNoRefreshTokenSentTwice();
		} finally {
			// the freeze must not outlive this test: the browser is shared by every test of the fork
			switchTo().window(0);
			BrowserDevTools.unfreezeTab();
			forBothTabs(() -> BrowserDevTools.delayNetwork(Duration.ZERO));
		}
	}

	// helpers --------------------------------------------------------------------------------------------------------------

	/**
	 * Signs in with the user manager chosen for this browser, and leaves the logs empty for the scenario
	 */
	private void signIn(UserManager userManager) {
		useUserManager(userManager);
		super.login(USER_LOGIN, USER_PASSWORD);
		PlatformApp.screen(SCREEN_A);
		BrowserDevTools.clearNetworkLog();
		BrowserDevTools.clearConsoleLog();
	}

	/**
	 * The renewal ahead of expiry starts in a few seconds instead of a minute: the token ends a little later than
	 * {@link #RENEWAL_AHEAD}, and a request lets the application of the current tab read it and set its timer
	 */
	private static void renewalAheadStartsSoon() {
		accessTokenEndsIn(RENEWAL_AHEAD.plusSeconds(8));
		PlatformApp.screen(SCREEN_B);
	}

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
	 * Both tabs learn that the token is about to end, every request of both is held for {@link #RENEWAL_HOLD}, the renewal ahead
	 * of expiry starts in both, the hold is lifted. The requests with a refresh token stay in the network log for the caller.
	 */
	private static void waitForRenewal() {
		Allure.step("Wait for the renewal ahead of expiry (up to " + renewalDeadline.toSeconds() + " s)", () -> {
			accessTokenEndsIn(RENEWAL_AHEAD.plusSeconds(8));
			// a request in each tab: both read the new end of the token and set their timers
			forBothTabs(() -> PlatformApp.screen(SCREEN_B));
			forBothTabs(() -> BrowserDevTools.delayNetwork(RENEWAL_HOLD));
			waitUntilRefreshTokenSent();
			// the other tab's request, if any, is in flight for RENEWAL_HOLD at most
			Selenide.sleep(RENEWAL_HOLD.plus(POLL).toMillis());
			forBothTabs(() -> BrowserDevTools.delayNetwork(Duration.ZERO));
		});
	}

	/**
	 * Collects the console until the message appears in it, or the deadline passes. Reading the browser log takes the messages
	 * out of it, so whoever waits for one has to keep what has already been read.
	 */
	private static List<String> consoleUntil(String marker) {
		return Allure.step("Wait for \"" + marker + "\" in the console (up to " + renewalDeadline.toSeconds() + " s)", () -> {
			var collected = new java.util.ArrayList<String>();
			var deadline = Instant.now().plus(renewalDeadline);
			while (collected.stream().noneMatch(message -> message.contains(marker))) {
				if (Instant.now().isAfter(deadline)) {
					return List.<String>of();
				}
				collected.addAll(BrowserDevTools.consoleLog());
				Selenide.sleep(POLL.toMillis());
			}
			return List.copyOf(collected);
		});
	}

	private static void waitUntilRefreshTokenSent() {
		Allure.step("Wait for the first request with a refresh token (up to " + renewalDeadline.toSeconds() + " s)", () -> {
			var deadline = Instant.now().plus(renewalDeadline);
			while (refreshTokensSent().isEmpty()) {
				assertThat(Instant.now()).as("no refresh token was sent before the deadline").isBefore(deadline);
				Selenide.sleep(POLL.toMillis());
			}
		});
	}

	/**
	 * Waits until the refresh token in the storage is no longer the one given: the application has renewed some other way and put
	 * a fresh pair there. Nothing is clicked meanwhile: the renewal ahead of expiry starts by a timer, not by a request.
	 */
	private static void waitUntilRefreshTokenReplaced(String old, Duration within) {
		Allure.step("Wait until the application has another refresh token (up to " + within.toSeconds() + " s)", () -> {
			var deadline = Instant.now().plus(within);
			while (old.equals(OidcProvider.storedRefreshToken())) {
				assertThat(Instant.now()).as("the application never replaced the refresh token").isBefore(deadline);
				Selenide.sleep(POLL.toMillis());
			}
		});
	}

	/**
	 * Works in the application (opens the two screens in turn, each is a request that needs a token) until the popup shows up,
	 * or the access token lifetime runs out.
	 */
	private static void workUntilSignInAgainPopupShows() {
		Allure.step("Work until the popup shows (up to " + recoveryDeadline.toSeconds() + " s)", () -> {
			var deadline = Instant.now().plus(recoveryDeadline);
			var screens = List.of(SCREEN_A, SCREEN_B);
			for (int i = 0; !PlatformApp.signInAgainPopup().isShown(POLL); i++) {
				assertThat(Instant.now()).as("the popup did not show within the token lifetime").isBefore(deadline);
				try {
					PlatformApp.screen(screens.get(i % screens.size()));
				} catch (RuntimeException | AssertionError clickFailed) {
					// between the check above and this click the popup may have come up and taken the click for itself, which is
					// the very thing being waited for - anything else is a real failure
					if (!PlatformApp.signInAgainPopup().isShown(RENEWAL_GIVES_UP)) {
						throw clickFailed;
					}
					break;
				}
			}
		});
	}

	private static void workInBothTabs() {
		Allure.step("Work in both tabs", () -> forBothTabs(() -> {
			PlatformApp.screen(SCREEN_A);
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

}
