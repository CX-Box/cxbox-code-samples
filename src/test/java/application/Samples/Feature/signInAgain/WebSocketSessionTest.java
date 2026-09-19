package application.Samples.Feature.signInAgain;

import application.config.BaseTestForSamples;
import application.config.props.Env;
import com.codeborne.selenide.Selenide;
import core.config.OidcProvider;
import core.config.selenide.BrowserDevTools;
import core.element.PlatformApp;
import io.qameta.allure.Allure;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import java.time.Duration;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.EnabledIfEnvironmentVariable;

import static core.element.widget.modal.SignInAgainPopup.Reason.SESSION_EXPIRED;
import static com.codeborne.selenide.Selenide.switchTo;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * CXBOX-1250. The websocket of notifications carries the access token in its handshake. Before every connect it takes the token
 * the way a request does ({@code authorizeWebSocketUrl} of {@code ui/src/auth/platformSession.ts}, no separate signinSilent,
 * https://github.com/authts/oidc-client-ts/issues/1618). Without a valid token no handshake is sent: the popup, then a retry after
 * a growing delay, so the client comes back by itself once a token is available.
 * <p>
 * <b>The build constants of {@code ui/src/constants/index.ts} this class is written for</b> (the defaults). They are compiled into
 * the frontend, so a test cannot switch them:
 * <ul>
 *     <li>{@code USER_MANAGER = 'rotationSafe'}. With {@code 'original'} an expired token is not renewed before the handshake:
 *     {@code expiredToken_reconnectsWithRenewedToken} ends in the popup.</li>
 *     <li>{@code AUTH_ERROR_MODE}: any value, no test here closes the popup.</li>
 *     <li>{@code SIGN_IN_CALLBACK_DETECTION}: any value.</li>
 * </ul>
 * <p>
 * The reconnect is provoked by freezing the tab the way Chrome freezes background tabs: the websocket of a frozen tab dies, the
 * token ends meanwhile; once unfrozen the client reconnects. The test does not wait the lifetime of the token out:
 * {@link #accessTokenEndsIn} brings its end closer, and the tokens stay real.
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
	 * Long enough for the websocket of the frozen tab to die: both sides expect a heartbeat every 4 seconds
	 */
	private static final Duration FROZEN_FOR = Duration.ofSeconds(20);

	@BeforeEach
	@Override
	public void beforeEach() {
		super.beforeEach();
		BrowserDevTools.grantClipboardPermission(Env.uri());
	}

	/**
	 * The browser is shared by the tests of a fork, so nothing of this test may outlive it, even a failed one: neither the freeze
	 * nor the extra tabs, and least of all the closed session. The logout leaves the browser in the one state the next test
	 * expects from {@link BaseTestForSamples#beforeEach()}: signed out, storage and cookies empty.
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
		logout();
	}

	@Test
	@DisplayName("The token expired while the tab was frozen: the websocket reconnects with a renewed token, no popup")
	public void expiredToken_reconnectsWithRenewedToken() {
		PlatformApp.screen(SCREEN_A);
		freezeTabUntilTokenExpires();

		Selenide.Wait().withTimeout(RECONNECT_WAIT).withMessage("the websocket has not reconnected")
				.until(driver -> notificationHandshakes().contains(SWITCHING_PROTOCOLS));
		PlatformApp.signInAgainPopup().shouldNotBeShown();
		assertThat(refreshTokensSent()).as("one renewal for the reconnect").hasSize(1);
		assertNoRefreshTokenSentTwice();
		PlatformApp.screen(SCREEN_B);
	}

	@Test
	@DisplayName("The session ended in another tab: the websocket does not knock with the dead token, shows the popup, keeps trying with a growing delay")
	@Description("The other tab has logged out, so there is no signed-in user when the websocket reconnects: no handshake, the popup "
			+ "names the websocket request. The client asks for a token again after a doubling delay and never sends a handshake "
			+ "without a token, so it comes back by itself once a token is available again.")
	public void sessionOver_showsPopupAndRetriesWithoutKnocking() {
		PlatformApp.screen(SCREEN_A);
		ssoLoginAndLogoutInAnotherTab();
		freezeTabUntilTokenExpires();

		// the client reconnects after its delay, which has doubled by the close: more than a default wait allows
		assertThat(PlatformApp.signInAgainPopup().isShown(RECONNECT_WAIT))
				.as("the popup was offered once the renewal on reconnect had failed")
				.isTrue();
		PlatformApp.signInAgainPopup()
				.checkReason(reason -> assertThat(reason).isEqualTo(SESSION_EXPIRED))
				.checkDetails(cp -> assertThat(cp.request().url()).contains(WEBSOCKET_ENDPOINT))
				.checkDetails(cp -> assertThat(cp.request().method()).isEqualTo("CONNECT"));
		assertThat(notificationHandshakes()).as("no handshake with the dead token").isEmpty();

		BrowserDevTools.clearNetworkLog();
		BrowserDevTools.clearConsoleLog();
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
		Allure.step("Freeze the tab for " + FROZEN_FOR.toSeconds() + " s, the token ends meanwhile", () -> {
			BrowserDevTools.clearNetworkLog();
			if (OidcProvider.isUserStored()) {
				accessTokenEndsIn(ABOUT_TO_END);
			}
			BrowserDevTools.freezeTab();
			Selenide.sleep(FROZEN_FOR.toMillis());
			BrowserDevTools.clearNetworkLog();
			BrowserDevTools.unfreezeTab();
		});
	}

}
