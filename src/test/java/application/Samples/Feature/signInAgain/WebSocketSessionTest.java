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
import java.time.Duration;
import java.util.List;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.EnabledIfEnvironmentVariable;

import static core.element.widget.modal.SignInAgainPopup.Reason.SESSION_EXPIRED;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * CXBOX-1250. The websocket of notifications carries the access token in its handshake. Before every connect it takes the token
 * the way a request does (the shared renewal of {@code ui/src/auth/tokenRenewal.ts}, no separate signinSilent,
 * https://github.com/authts/oidc-client-ts/issues/1618). Without a valid token no handshake is sent: the popup, then a retry after
 * a growing delay, so the client comes back by itself once a token is available.
 * <p>
 * The reconnect is provoked by freezing the tab the way Chrome freezes background tabs: the browser closes the websocket of a frozen
 * tab, the token expires meanwhile; once unfrozen the client reconnects.
 */
@DisplayName("Authorization: websocket after the token expired or the session ended")
@Epic("Samples")
@Tag("Samples")
@Tag("Slow")
@EnabledIfEnvironmentVariable(named = "KEYCLOAK_ADMIN_USER", matches = ".+", disabledReason = "reads the realm settings, needs the admin account")
public class WebSocketSessionTest extends BaseTestForSamples {

	private static final String SCREEN_A = "Input basic";

	private static final String SCREEN_B = "Picklist basic";

	private static final String WEBSOCKET_ENDPOINT = "websocketnotification";

	private static final int SWITCHING_PROTOCOLS = 101;

	/**
	 * Reconnect delay (doubled after the close) plus the renewal, with a reserve for a slow CI runner
	 */
	private static final Duration RECONNECT_WAIT = Duration.ofSeconds(60);

	private static final String HANDSHAKE_SKIPPED = "Websocket handshake skipped";

	/**
	 * Within the 30 seconds "No" keeps the popup closed
	 */
	private static final Duration SNOOZE_WAIT = Duration.ofSeconds(25);

	/**
	 * The token expires while the tab is frozen
	 */
	private static Duration frozenFor;

	@BeforeAll
	static void readTokenLifetime() {
		frozenFor = KeycloakAdmin.forApp(Env.uri()).getAccessTokenLifespan().plusSeconds(15);
	}

	@BeforeEach
	@Override
	public void beforeEach() {
		super.beforeEach();
		BrowserDevTools.grantClipboardPermission(Env.uri());
	}

	@Test
	@DisplayName("The token expired while the tab was frozen: the websocket reconnects with a renewed token, no popup")
	public void expiredToken_reconnectsWithRenewedToken() {
		PlatformApp.screen(SCREEN_A);
		freezeTabUntilTokenExpires();

		Selenide.Wait().withTimeout(RECONNECT_WAIT).withMessage("the websocket has not reconnected")
				.until(driver -> notificationHandshakes().contains(SWITCHING_PROTOCOLS));
		PlatformApp.signInAgainPopup().shouldNotBeShown();
		assertThat(countTokenRequests()).as("one renewal for the reconnect").isEqualTo(1);
		PlatformApp.screen(SCREEN_B);
	}

	@Test
	@DisplayName("The session ended in another tab: the websocket does not knock with the dead token, shows the popup, keeps trying with a growing delay")
	@Description("The renewal on reconnect fails (the OIDC provider answers that the session is over): no handshake, the popup names "
			+ "the websocket request. \"No\" keeps the popup closed for a while; the client retries the renewal after a doubling delay "
			+ "and never a handshake without a token, so it comes back by itself once a token is available again.")
	public void sessionOver_showsPopupAndRetriesWithoutKnocking() {
		PlatformApp.screen(SCREEN_A);
		ssoLoginAndLogoutInAnotherTab();
		freezeTabUntilTokenExpires();

		PlatformApp.signInAgainPopup()
				.checkReason(reason -> assertThat(reason).isEqualTo(SESSION_EXPIRED))
				.checkDetails(cp -> assertThat(cp.request().url()).contains(WEBSOCKET_ENDPOINT))
				.checkDetails(cp -> assertThat(cp.request().method()).isEqualTo("CONNECT"))
				.clickNo();
		assertThat(notificationHandshakes()).as("no handshake with the dead token").isEmpty();
		assertThat(BrowserDevTools.consoleLog()).as("the renewal on reconnect failed").anyMatch(message -> message.contains(RENEWAL_FAILED));

		BrowserDevTools.clearNetworkLog();
		BrowserDevTools.clearConsoleLog();
		PlatformApp.signInAgainPopup().shouldNotBeShown(SNOOZE_WAIT);
		Selenide.Wait().withTimeout(RECONNECT_WAIT).withMessage("no retry logged")
				.until(driver -> BrowserDevTools.consoleLog().stream().anyMatch(message -> message.contains(HANDSHAKE_SKIPPED)));
		assertThat(notificationHandshakes()).as("still no handshake with the dead token").isEmpty();
	}

	// helpers --------------------------------------------------------------------------------------------------------------

	/**
	 * Statuses of the handshakes of the notification websocket (a dev server may have websockets of its own)
	 */
	private static List<Integer> notificationHandshakes() {
		return BrowserDevTools.webSocketHandshakes().stream()
				.filter(handshake -> handshake.url().contains(WEBSOCKET_ENDPOINT))
				.map(BrowserDevTools.WebSocketHandshake::status)
				.toList();
	}

	private static void freezeTabUntilTokenExpires() {
		Allure.step("Freeze the tab for " + frozenFor.toSeconds() + " s, until the token has expired", () -> {
			BrowserDevTools.clearNetworkLog();
			BrowserDevTools.freezeTab();
			Selenide.sleep(frozenFor.toMillis());
			BrowserDevTools.clearNetworkLog();
			BrowserDevTools.unfreezeTab();
		});
	}

}
