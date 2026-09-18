package application.Samples.Feature.signInAgain;

import application.config.BaseTestForSamples;
import application.config.oidc.keycloak.KeycloakAdmin;
import application.config.props.Env;
import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import core.config.OidcProvider;
import core.config.selenide.BrowserDevTools;
import core.element.PlatformApp;
import core.element.widget.modal.SignInAgainPopup;
import core.page.auth.keycloak.KeycloackAuthPage;
import core.util.DocShots;
import io.qameta.allure.Allure;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
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
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import org.openqa.selenium.WindowType;

import static com.codeborne.selenide.Selenide.open;
import static core.element.widget.modal.SignInAgainPopup.Reason.INSUFFICIENT_PERMISSIONS;
import static core.element.widget.modal.SignInAgainPopup.Reason.SESSION_EXPIRED;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * CXBOX-1250. Authorization errors in the UI: the popup on 401/403 with "Sign in again" and "Sign out", the access token
 * renewal before a request, the sign in that survives F5, "Copy details" in error popups.
 * <p>
 * <b>The build constants of {@code ui/src/constants/index.ts} this class is written for</b> (the defaults). They are compiled into
 * the frontend, so a test cannot switch them:
 * <ul>
 *     <li>{@code USER_MANAGER = 'rotationSafe'}. With {@code 'original'} nothing guards the refresh token and no token is burnt:
 *     {@code providerUnreachable_*} and {@code burntToken_*} fail. The two values are compared in {@link TokenRenewalAcrossTabsTest}.</li>
 *     <li>{@code AUTH_ERROR_MODE}: any value. The tests use what {@code 'soft'} and {@code 'strict'} share, the two buttons. The
 *     one exception is {@code sessionExpired_closingSnoozesThePopup}: the cross exists in {@code 'soft'} only.</li>
 *     <li>{@code SIGN_IN_CALLBACK_DETECTION}: <b>both values</b> in the tests of the sign in, which have the parameter: the same
 *     scenario, and where the expected result differs the test says how. The other tests pass with any value.</li>
 * </ul>
 * The values the stand really runs with are in "Copy details" of the popup, see {@code signInAgainPopup_copyDetails}.
 * <p>
 * Real UI, real OIDC provider, nothing injected into the page. Checks use {@code data-test} attributes and the copied JSON,
 * never displayed texts, so the UI language does not matter.
 * <p>
 * The Keycloak may be shared with other runs: every run creates its own users with a random suffix and deletes them at the end,
 * nothing else is changed. The whole class is tagged {@code Slow} and runs apart from the ordinary tests, in the second
 * surefire process: every one of its scenarios ends the session on purpose, so a neighbour sharing the browser of the fork
 * would be left to sign in again. {@link #accessTokenEndsIn} brings the end of the access token closer, and the tokens stay
 * real, so the tests do not wait its lifetime out. One test does, on purpose: {@code backendAnswers401_popupIsShown}, where
 * the token must be over for the backend too.
 * The tests run only when {@code KEYCLOAK_ADMIN_USER} is set.
 */
@DisplayName("Authorization: the popup on 401/403, token renewal, sign in through F5, Copy details")
@Epic("Samples")
@Tag("Samples")
@Tag("Slow")
@EnabledIfEnvironmentVariable(named = "KEYCLOAK_ADMIN_USER", matches = ".+", disabledReason = "creates users in the OIDC provider, needs its admin account")
public class SignInAgainPopupTest extends BaseTestForSamples {

	private record TestUser(String login, String password) {

		/**
		 * A user of this run only: parallel runs against the same Keycloak never meet
		 */
		static TestUser unique(String prefix) {
			var suffix = UUID.randomUUID().toString().substring(0, 8);
			return new TestUser(prefix + "-" + suffix, UUID.randomUUID().toString());
		}

	}

	/**
	 * The standard user of the samples with all client roles; only signed in and out, never changed
	 */
	private static final TestUser DEMO_USER = new TestUser("demo", "demo");

	private static final TestUser USER_WITHOUT_ROLES = TestUser.unique("noroles");

	/**
	 * A copy of the demo user whose roles get revoked during the test
	 */
	private static final TestUser USER_LOSING_ROLES = TestUser.unique("rolestest");

	/**
	 * A copy of the demo user for the test with two tabs: the test counts its sessions, and the sessions of demo are not ours
	 * alone - other forks and other people sign in as demo on the same provider
	 */
	private static final TestUser USER_TWO_TABS = TestUser.unique("twotabs");

	/**
	 * The pictures of the release article, taken when the tests run with {@code -DdocShots=<docs folder of cxbox-doc>}
	 */
	private static final String ARTICLE = "new/v3.0.2";

	private static final String SCREEN_A = "Input basic";

	private static final String SCREEN_B = "Picklist basic";

	/**
	 * A form view: the last url segment is the record id the backend has to load
	 */
	private static final String FORM_VIEW_URL = "screen/InputDrilldown/view/InputDrilldownform/InputDrilldown/";

	private static final String MISSING_RECORD_ID = "999999999";

	private static final Duration POLL = Duration.ofSeconds(2);

	private static final Duration SNOOZE_WAIT = Duration.ofSeconds(5);

	/**
	 * A request that needs a token waits for the renewal first: the refresh token, a second for another tab, then up to 30 seconds
	 * for the hidden iframe where it gets no answer. Only then the popup comes up
	 */
	private static final Duration RENEWAL_GIVES_UP = Duration.ofSeconds(45);

	/**
	 * The sign in restarts itself this many times in a row, then the popup is shown: {@code MAX_SIGN_IN_RESTARTS} of
	 * {@code ui/src/auth/platformSession.ts}
	 */
	private static final int MAX_SIGN_IN_RESTARTS = 2;

	private static KeycloakAdmin keycloakAdmin;

	/**
	 * The access token lifetime of the realm plus a margin for the renewal and the request that follows it
	 */
	private static Duration tokenLifetimeWait;

	@BeforeAll
	static void createTestUsers() {
		keycloakAdmin = KeycloakAdmin.forApp(Env.uri());
		// the backend accepts a token for a minute after its end (the clock skew of Spring Security)
		tokenLifetimeWait = keycloakAdmin.getAccessTokenLifespan().plusSeconds(150);
		Allure.step("Create the users of this run", () -> {
			var demoRoles = keycloakAdmin.getClientRoles(DEMO_USER.login());
			keycloakAdmin.createUser(USER_WITHOUT_ROLES.login(), USER_WITHOUT_ROLES.password(), List.of());
			keycloakAdmin.createUser(USER_LOSING_ROLES.login(), USER_LOSING_ROLES.password(), demoRoles);
			keycloakAdmin.createUser(USER_TWO_TABS.login(), USER_TWO_TABS.password(), demoRoles);
		});
		// a killed run must not leave its users behind either
		Runtime.getRuntime().addShutdownHook(new Thread(SignInAgainPopupTest::deleteTestUsers));
	}

	@AfterAll
	static void deleteTestUsers() {
		keycloakAdmin.deleteUser(USER_WITHOUT_ROLES.login());
		keycloakAdmin.deleteUser(USER_LOSING_ROLES.login());
		keycloakAdmin.deleteUser(USER_TWO_TABS.login());
	}

	@BeforeEach
	@Override
	public void beforeEach() {
		super.beforeEach();
		BrowserDevTools.grantClipboardPermission(Env.uri());
		BrowserDevTools.blockUrls(List.of());
	}

	/**
	 * The browser is shared by the tests of a fork, so nothing of this test may outlive it, even a failed one: neither a url block
	 * nor the closed session. Most of these tests end the session on purpose; the logout leaves the browser in the one state the
	 * next test expects from {@link BaseTestForSamples#beforeEach()}: signed out, storage and cookies empty.
	 */
	@AfterEach
	public void cleanUpBrowser() {
		BrowserDevTools.blockUrls(List.of());
		// a test that opened tabs of its own must not leave them behind: the browser belongs to every test of the fork
		while (Selenide.switchTo().window(0).getWindowHandles().size() > 1) {
			Selenide.switchTo().window(1);
			Selenide.closeWindow();
		}
		Selenide.switchTo().window(0);
		logout();
	}

	// 401: the session was closed outside the tab -----------------------------------------------------------------------

	@Test
	@DisplayName("401: after Log out in another tab the next request shows the popup, the widgets stay on screen")
	@Description("The user logs out in a second tab of the same browser. Back in the first tab a screen change needs a token, there "
			+ "is no signed-in user any more, and the popup is shown with \"Sign in again\" and \"Sign out\".")
	public void sessionExpired_popupIsShown() {
		PlatformApp.screen(SCREEN_A);
		ssoLoginAndLogoutInAnotherTab();
		provokePopupWithAScreenChange();

		PlatformApp.signInAgainPopup()
				.checkReason(reason -> assertThat(reason).isEqualTo(SESSION_EXPIRED))
				.checkTitleAndMessage(title -> assertThat(title).isNotBlank(), message -> assertThat(message).isNotBlank());
		PlatformApp.currentScreen().element().shouldBe(CollectionCondition.sizeGreaterThan(0));
		DocShots.png(ARTICLE, "CXBOX-1384_401_after.png", 1600, 1000);
	}

	@Test
	@DisplayName("401 from the backend: the access token is over for real, the backend refuses it, the popup is shown")
	@Description("The backend checks the exp inside the token, and a test that only brings the end of the token closer in the "
			+ "browser never gets there: that token is still good for the backend. Here it is the other way round. The application "
			+ "is made to believe that its token lives for an hour more, so it renews nothing and sends the token as it is, and "
			+ "the test waits the real lifetime out. The backend answers 401 by itself, and the popup is shown for that request.")
	public void backendAnswers401_popupIsShown() {
		PlatformApp.screen(SCREEN_A);
		accessTokenEndsIn(Duration.ofHours(1));
		PlatformApp.screen(SCREEN_B);
		BrowserDevTools.clearNetworkLog();

		workUntilSignInAgainPopupShows();

		PlatformApp.signInAgainPopup()
				.checkReason(reason -> assertThat(reason).isEqualTo(SESSION_EXPIRED))
				.checkDetails(cp -> assertThat(cp.request().statusCode()).isEqualTo(401))
				.checkDetails(cp -> assertThat(cp.request().url()).contains("/api/v1/"));
		assertThat(refreshTokensSent()).as("the application believed its token and renewed nothing: the 401 came from the backend").isEmpty();
	}

	@Test
	@DisplayName("AUTH_ERROR_MODE = soft. 401: the cross closes the popup, and further failing requests do not reopen it for a while")
	public void sessionExpired_closingSnoozesThePopup() {
		PlatformApp.screen(SCREEN_A);
		ssoLoginAndLogoutInAnotherTab();
		provokePopupWithAScreenChange();

		PlatformApp.signInAgainPopup()
				.checkReason(reason -> assertThat(reason).isEqualTo(SESSION_EXPIRED))
				.close();

		PlatformApp.screen(SCREEN_A);
		PlatformApp.screen(SCREEN_B);
		PlatformApp.signInAgainPopup().shouldNotBeShown(SNOOZE_WAIT);
	}

	@Test
	@DisplayName("401: with the SSO session over, \"Sign in again\" opens the login page, signing in restores the application")
	public void sessionExpired_signInAgainGoesToLoginPage() {
		PlatformApp.screen(SCREEN_A);
		DocShots.gif(ARTICLE, "CXBOX-1250_401.gif", 1200, 760, DocShots.Frame.WITH_SIDEBAR);
		ssoLoginAndLogoutInAnotherTab();
		provokePopupWithAScreenChange();

		PlatformApp.signInAgainPopup()
				.checkReason(reason -> assertThat(reason).isEqualTo(SESSION_EXPIRED))
				.clickSignInAgain();

		shouldBeOnLoginPage();
		new KeycloackAuthPage().authWithUsernameAndPassword(DEMO_USER.login(), DEMO_USER.password(), Env.uri());
		PlatformApp.userMenu().shouldBeDisplayed();
		PlatformApp.screen(SCREEN_A);
		DocShots.stop();
		PlatformApp.signInAgainPopup().shouldNotBeShown();
	}

	@Test
	@DisplayName("401 in two tabs: after signing in through one of them, \"Sign in again\" in the other needs no password and keeps that session")
	@Description("Both tabs are left with a closed session and both show the popup, and the user signs in again through the first one. "
			+ "The popup of the second tab stays: its request failed and the data on its screen is not valid. \"Sign in again\" there "
			+ "goes to the provider and back without a login page, because the SSO session of the first tab is alive, and that "
			+ "session is not ended by it.")
	public void signedInElsewhere_signInAgainNeedsNoPassword() {
		super.logout();
		super.login(USER_TWO_TABS.login(), USER_TWO_TABS.password());
		PlatformApp.screen(SCREEN_A);
		Allure.step("Open the application in a second tab of the same browser", () -> {
			Selenide.switchTo().newWindow(WindowType.TAB);
			open(Env.uri().toString());
			PlatformApp.screen(SCREEN_A);
		});

		ssoLoginAndLogoutInAnotherTab();

		Allure.step("Both tabs find the session closed and offer to sign in again", () -> {
			Selenide.switchTo().window(1);
			provokePopupWithAScreenChange();
			PlatformApp.signInAgainPopup().checkReason(reason -> assertThat(reason).isEqualTo(SESSION_EXPIRED));
			Selenide.switchTo().window(0);
			provokePopupWithAScreenChange();
			PlatformApp.signInAgainPopup()
					.checkReason(reason -> assertThat(reason).isEqualTo(SESSION_EXPIRED))
					.clickSignInAgain();
		});
		super.login(USER_TWO_TABS.login(), USER_TWO_TABS.password());
		PlatformApp.userMenu().shouldBeDisplayed();
		var sessionsAfterSignIn = keycloakAdmin.countSessions(USER_TWO_TABS.login());

		Selenide.switchTo().window(1);
		PlatformApp.signInAgainPopup()
				.checkReason(reason -> assertThat(reason).isEqualTo(SESSION_EXPIRED))
				.clickSignInAgain();

		PlatformApp.userMenu().shouldBeDisplayed();
		PlatformApp.signInAgainPopup().shouldNotBeShown();
		assertThat(keycloakAdmin.countSessions(USER_TWO_TABS.login()))
				.as("the session the first tab has just signed in to is still open, and no other one was started")
				.isEqualTo(sessionsAfterSignIn);
	}

	// 403: no roles ----------------------------------------------------------------------------------------------------

	@Test
	@DisplayName("403: sign in of a user without roles shows the popup on the start page instead of an endless spinner, \"Sign out\" leads to the login page")
	public void userWithoutRoles_loginShowsPopup() {
		super.logout();
		super.login(USER_WITHOUT_ROLES.login(), USER_WITHOUT_ROLES.password());

		var signInAgainPopup = PlatformApp.signInAgainPopup()
				.checkReason(reason -> assertThat(reason).isEqualTo(INSUFFICIENT_PERMISSIONS));
		DocShots.png(ARTICLE, "CXBOX-1384_login_without_roles_after.png", 1600, 1000);
		signInAgainPopup.clickSignOut();
		shouldBeOnLoginPage();
	}

	@Test
	@DisplayName("403: roles removed in the OIDC provider while the user works; the next token renewal ends in the popup, with the roles back \"Sign in again\" restores the work without a password")
	@Description("The administrator removes every client role of the user. The next token the application receives has no roles, "
			+ "the backend answers 403 and the popup is shown. With the roles back \"Sign in again\" goes to the provider and back: "
			+ "the SSO session is alive, so there is no login page, the new token carries the roles, and the roles are reactivated "
			+ "in the database (CXBOX-1250 user_roles sync fix).")
	public void rolesRemovedDuringSession_popupThenRolesReactivated() {
		var demoUserRoles = keycloakAdmin.getClientRoles(DEMO_USER.login());
		super.logout();
		super.login(USER_LOSING_ROLES.login(), USER_LOSING_ROLES.password());
		PlatformApp.screen(SCREEN_A);
		keycloakAdmin.revokeAllClientRoles(USER_LOSING_ROLES.login());

		accessTokenEndsIn(ABOUT_TO_END);
		DocShots.gif(ARTICLE, "CXBOX-1250_403.gif", 1200, 760, DocShots.Frame.WITH_SIDEBAR);
		workUntilSignInAgainPopupShows();
		var signInAgainPopup = PlatformApp.signInAgainPopup()
				.checkReason(reason -> assertThat(reason).isEqualTo(INSUFFICIENT_PERMISSIONS));
		DocShots.png(ARTICLE, "CXBOX-1384_403_after.png", 1600, 1000);

		keycloakAdmin.grantClientRoles(USER_LOSING_ROLES.login(), demoUserRoles);
		signInAgainPopup.clickSignInAgain();

		PlatformApp.userMenu().shouldBeDisplayed();
		PlatformApp.screen(SCREEN_A);
		DocShots.stop();
		PlatformApp.signInAgainPopup().shouldNotBeShown(SNOOZE_WAIT);
	}

	// Token renewal: the refresh token is sent once, whatever happens to the answer ----------------------------------------------

	@Test
	@DisplayName("OIDC provider unreachable: the refresh token is sent once and never again, the popup comes up, \"Sign in again\" needs no password")
	@Description("The token endpoint of the OIDC provider is unreachable. The renewal sends the refresh token once: a lost answer does "
			+ "not say whether the provider took the token, and sending the same one again is what ends the whole session, so the "
			+ "token is burnt. The renewal goes on with the SSO cookie through the hidden iframe, whose exchange of a code is "
			+ "unreachable as well, so the popup \"Session has expired\" comes up once the access token is over. With the provider "
			+ "back, \"Sign in again\" returns to the application without a login page: the SSO session has been alive all along.")
	public void providerUnreachable_theTokenIsSentOnceThenPopup() {
		SignInAgainPopup signInAgainPopup;
		try {
			PlatformApp.screen(SCREEN_A);
			BrowserDevTools.clearNetworkLog();
			BrowserDevTools.clearConsoleLog();
			BrowserDevTools.blockUrls(List.of(oidc().getTokenEndpoint() + "*"));

			renewalAheadStartsSoon();
			// collected while it is being written: reading the browser log empties it, and a click that lands under the popup
			// makes Selenide build an error, which reads the log too - what the renewal did would be gone by then
			var console = consoleUntil(IFRAME_FAILED);
			assertThat(console).as("the refresh token was sent and burnt; console: " + console).anyMatch(message -> message.contains(TOKEN_BURNT));
			assertThat(console).as("then the hidden iframe was tried; console: " + console).anyMatch(message -> message.contains(IFRAME_FAILED));

			accessTokenEndsIn(ABOUT_TO_END);
			workUntilSignInAgainPopupShows();
			signInAgainPopup = PlatformApp.signInAgainPopup()
					.checkReason(reason -> assertThat(reason).isEqualTo(SESSION_EXPIRED));
			assertThat(refreshTokensSent()).as("the refresh token was sent once, the renewals that followed did not send it").hasSizeLessThanOrEqualTo(1);
			assertNoRefreshTokenSentTwice();
		} finally {
			BrowserDevTools.blockUrls(List.of());
		}

		signInAgainPopup.clickSignInAgain();
		PlatformApp.userMenu().shouldBeDisplayed();
		PlatformApp.signInAgainPopup().shouldNotBeShown();
	}

	@Test
	@DisplayName("OIDC provider is down: \"Sign in again\" and \"Sign out\" keep the popup open and say so, what is on the screen is not lost")
	@Description("The page was loaded with a stored user, so it has not talked to the provider yet, and the whole provider is "
			+ "unreachable. The token cannot be renewed, the popup comes up. Both buttons need the provider: the redirect does not "
			+ "start, the popup stays with a message, and the screen behind it is as it was. With the provider back, "
			+ "\"Sign in again\" returns to the application without a login page.")
	public void providerDown_bothButtonsKeepThePopup() {
		SignInAgainPopup signInAgainPopup;
		try {
			PlatformApp.screen(SCREEN_A);
			Selenide.refresh();
			PlatformApp.screen(SCREEN_B);
			BrowserDevTools.blockUrls(List.of(oidc().getTokenEndpoint().replace("/protocol/openid-connect/token", "") + "/*"));

			accessTokenEndsIn(ABOUT_TO_END);
			workUntilSignInAgainPopupShows();
			signInAgainPopup = PlatformApp.signInAgainPopup()
					.checkReason(reason -> assertThat(reason).isEqualTo(SESSION_EXPIRED));

			DocShots.gif(ARTICLE, "CXBOX-1250_provider_not_reachable.gif", 1200, 760, DocShots.Frame.WITH_SIDEBAR);
			signInAgainPopup.clickSignInAgain();
			signInAgainPopup.checkProviderNotReachable(message -> assertThat(message).isNotBlank());
			signInAgainPopup.clickSignOut();
			signInAgainPopup.checkProviderNotReachable(message -> assertThat(message).isNotBlank());
			DocShots.stop();
			DocShots.png(ARTICLE, "CXBOX-1384_401_provider_not_reachable.png", 1600, 1000);
			PlatformApp.currentScreen().element().shouldBe(CollectionCondition.sizeGreaterThan(0));
		} finally {
			BrowserDevTools.blockUrls(List.of());
		}

		signInAgainPopup.clickSignInAgain();
		PlatformApp.userMenu().shouldBeDisplayed();
		PlatformApp.signInAgainPopup().shouldNotBeShown();
	}

	// The way through the iframe: available and not ------------------------------------------------------------------------

	@Test
	@DisplayName("The refresh token is burnt but the cookie is good: the iframe picks the renewal up and the user sees nothing")
	@Description("The token endpoint is unreachable for one renewal, so the request with the refresh token fails and the token is "
			+ "burnt - it might have been spent, and nobody can tell. With the endpoint reachable again the burnt token is not sent, "
			+ "and the renewal asks with the SSO cookie through the hidden iframe instead. That is the way that exists for a provider "
			+ "on the same site as the application: the session carries on and no popup is shown.")
	public void burntToken_iframeRecoversSilently() {
		PlatformApp.screen(SCREEN_A);
		var burnt = OidcProvider.storedRefreshToken();
		BrowserDevTools.clearNetworkLog();
		BrowserDevTools.clearConsoleLog();
		BrowserDevTools.blockUrls(List.of(oidc().getTokenEndpoint() + "*"));

		renewalAheadStartsSoon();
		var console = consoleUntil(TOKEN_BURNT);
		assertThat(console).as("the renewal with the token failed and the token was burnt; console: " + console).isNotEmpty();

		BrowserDevTools.blockUrls(List.of());
		accessTokenEndsIn(ABOUT_TO_END);
		// what is checked here is the fact, not a line about it: with the endpoint reachable again the application asks with the
		// SSO cookie through the iframe, and a fresh pair lands in the storage. A console message would have been the easier
		// thing to look for, and the wrong one - it may be read away by anything that builds an error meanwhile
		Allure.step("Wait until another refresh token is in the storage (up to " + tokenLifetimeWait.toMinutes() + " minutes)", () -> {
			var deadline = Instant.now().plus(tokenLifetimeWait);
			var screens = List.of(SCREEN_A, SCREEN_B);
			for (int i = 0; burnt.equals(OidcProvider.storedRefreshToken()); i++) {
				assertThat(Instant.now()).as("the application never renewed by the cookie").isBefore(deadline);
				PlatformApp.screen(screens.get(i % screens.size()));
				Selenide.sleep(POLL.toMillis());
			}
		});
		PlatformApp.signInAgainPopup().shouldNotBeShown(SNOOZE_WAIT);
		PlatformApp.userMenu().shouldBeDisplayed();
		assertNoRefreshTokenSentTwice();
	}

	@Test
	@DisplayName("The same without the iframe: the popup is offered, the burnt token is never sent a second time, \"Sign in again\" needs no password")
	@Description("The silent renewal is told apart from an ordinary sign in by prompt=none, and here it is made unreachable: this is "
			+ "the application at a customer whose provider sits on another site, where the browser keeps its cookie out of the iframe. "
			+ "The renewal has then no way left: the refresh token is burnt after its one failure and the popup is offered. What must "
			+ "not happen is a second request with that same token - the reuse that ends the whole session. \"Sign in again\" is a "
			+ "full page redirect, the cookie goes with it, and the user is back without a login page.")
	public void burntToken_withoutIframe_popupThenSignInAgainWithoutPassword() {
		SignInAgainPopup signInAgainPopup;
		try {
			PlatformApp.screen(SCREEN_A);
			BrowserDevTools.clearNetworkLog();
			BrowserDevTools.clearConsoleLog();
			BrowserDevTools.blockUrls(List.of(oidc().getTokenEndpoint() + "*", "*prompt=none*"));

			renewalAheadStartsSoon();
			var console = consoleUntil(TOKEN_BURNT);
			assertThat(console).as("the refresh token was sent and burnt; console: " + console).isNotEmpty();

			accessTokenEndsIn(ABOUT_TO_END);
			workUntilSignInAgainPopupShows();
			signInAgainPopup = PlatformApp.signInAgainPopup()
					.checkReason(reason -> assertThat(reason).isEqualTo(SESSION_EXPIRED));
			assertThat(refreshTokensSent()).as("the burnt refresh token was not sent again").hasSizeLessThanOrEqualTo(1);
			assertNoRefreshTokenSentTwice();
		} finally {
			BrowserDevTools.blockUrls(List.of());
		}

		signInAgainPopup.clickSignInAgain();
		PlatformApp.userMenu().shouldBeDisplayed();
		PlatformApp.signInAgainPopup().shouldNotBeShown();
	}

	/**
	 * Collects the console until the marker shows up in it, or the access token lifetime runs out. Reading the browser log takes
	 * the messages out of it, so a test that watches for something has to keep what it has read.
	 */
	private static List<String> consoleUntil(String marker) {
		return Allure.step("Wait for \"" + marker + "\" in the console (up to " + tokenLifetimeWait.toMinutes() + " minutes)", () -> {
			var collected = new java.util.ArrayList<String>();
			var deadline = Instant.now().plus(tokenLifetimeWait);
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

	// Sign in: F5 during the return from the provider ------------------------------------------------------------------------------

	@ParameterizedTest(name = "SIGN_IN_CALLBACK_DETECTION = {0}")
	@EnumSource(SignInCallbackDetection.class)
	@DisplayName("F5 during the sign in: the page with the used code in its address signs in again by itself, without a password")
	@Description("The provider is slow, the user sees a spinner and presses F5 while the code is being exchanged for tokens. The page "
			+ "loads with the same address: the code in it is used, oidc-client-ts refuses it, and before CXBOX-1250 every reload "
			+ "ended in the same spinner. Now the sign in starts over: to the provider and back with a new code, no login page "
			+ "because the SSO session is alive. The test opens exactly that address - the return of its own sign in - with no user "
			+ "in the storage, as the interrupted exchange leaves it. "
			+ "Expected with 'oidcResponse' and with 'signInCallbackParam': the same, the address has both the response of the "
			+ "provider and our parameter.")
	public void f5DuringSignIn_theSignInRestartsWithoutPassword(SignInCallbackDetection detection) {
		super.logout();
		useSignInCallbackDetection(detection);
		BrowserDevTools.clearNetworkLog();
		super.login(DEMO_USER.login(), DEMO_USER.password());
		PlatformApp.userMenu().shouldBeDisplayed();
		var returns = returnsFromProvider();
		assertThat(returns).as("the sign in came back from the provider with a code").isNotEmpty();

		forgetStoredUser();
		BrowserDevTools.clearNetworkLog();
		open(returns.get(returns.size() - 1) + "#/?sign_in_callback=redirect");

		PlatformApp.userMenu().shouldBeDisplayed();
		PlatformApp.signInAgainPopup().shouldNotBeShown();
		assertThat(OidcProvider.isUserStored()).as("the user is signed in again").isTrue();
		assertThat(returnsFromProvider()).as("the used code, then one return with a new code").hasSize(2);
	}

	@ParameterizedTest(name = "SIGN_IN_CALLBACK_DETECTION = {0}")
	@EnumSource(SignInCallbackDetection.class)
	@DisplayName("The provider returns without our sign_in_callback parameter")
	@Description("Our parameter stands after # in redirect_uri, and a provider may drop that part: a redirect address must not have "
			+ "it (RFC 6749). The test makes such a return itself: the page of the real return loads without the scripts of the "
			+ "application, so the code in its address stays fresh, and then the test opens that address without the part after #. "
			+ "Expected with 'oidcResponse': the page sees the response of the provider in the address and finishes the sign in, "
			+ "one trip to the provider. "
			+ "Expected with 'signInCallbackParam': the page does not notice the return, drops the fresh code and goes to the provider "
			+ "again. Keycloak keeps the parameter, so the second return is noticed; with a provider that drops it every time the "
			+ "redirects never end.")
	public void returnWithoutSignInCallbackParam(SignInCallbackDetection detection) {
		super.logout();
		useSignInCallbackDetection(detection);
		String returnAddress;
		try {
			BrowserDevTools.clearNetworkLog();
			Allure.step("Sign in on the login page; the page of the return loads without the scripts of the application", () -> {
				open(Env.uri().toString());
				KeycloackAuthPage.login.shouldBe(Condition.enabled).setValue(DEMO_USER.login());
				KeycloackAuthPage.password.shouldBe(Condition.enabled).setValue(DEMO_USER.password());
				// a block of the address of the return itself does not work: a redirect of the provider is not checked against it
				BrowserDevTools.blockUrls(List.of("*/static/js/*"));
				KeycloackAuthPage.signInButton.shouldBe(Condition.visible).click();
				Selenide.Wait().withMessage("the provider has not returned").until(driver -> !returnsFromProvider().isEmpty());
			});
			// the address of a request has no part after #: exactly what a provider that drops it would return to
			returnAddress = returnsFromProvider().get(0);
			open("about:blank");
		} finally {
			BrowserDevTools.blockUrls(List.of());
		}

		BrowserDevTools.clearNetworkLog();
		open(returnAddress);

		PlatformApp.userMenu().shouldBeDisplayed();
		PlatformApp.signInAgainPopup().shouldNotBeShown();
		switch (detection) {
			case OIDC_RESPONSE -> assertThat(returnsFromProvider())
					.as("the return was noticed and its code was used: one trip to the provider")
					.hasSize(1);
			case SIGN_IN_CALLBACK_PARAM -> assertThat(returnsFromProvider())
					.as("the return was not noticed: the fresh code was dropped, and the page went to the provider again")
					.hasSize(2);
		}
	}

	@Test
	@DisplayName("The provider is broken during the sign in: the sign in restarts " + MAX_SIGN_IN_RESTARTS + " times and stops at the popup, no endless redirects")
	@Description("The token endpoint is unreachable, so every return from the provider fails at the exchange of the code. The sign "
			+ "in restarts itself, and the SSO cookie brings the browser back at once - a loop, if nothing stopped it. The counter "
			+ "does: after the restarts the popup is shown. With the provider back, \"Sign in again\" returns to the application "
			+ "without a login page.")
	public void providerBrokenDuringSignIn_restartsThenPopup() {
		SignInAgainPopup signInAgainPopup;
		super.logout();
		try {
			BrowserDevTools.clearNetworkLog();
			BrowserDevTools.blockUrls(List.of(oidc().getTokenEndpoint() + "*"));
			Allure.step("Sign in on the login page; the application cannot finish it", () -> {
				open(Env.uri().toString());
				KeycloackAuthPage.login.shouldBe(Condition.enabled).setValue(DEMO_USER.login());
				KeycloackAuthPage.password.shouldBe(Condition.enabled).setValue(DEMO_USER.password());
				KeycloackAuthPage.signInButton.shouldBe(Condition.visible).click();
			});

			signInAgainPopup = PlatformApp.signInAgainPopup()
					.checkReason(reason -> assertThat(reason).isEqualTo(SESSION_EXPIRED));
			assertThat(returnsFromProvider())
					.as("the first return and " + MAX_SIGN_IN_RESTARTS + " restarts, then the redirects stop")
					.hasSize(1 + MAX_SIGN_IN_RESTARTS);
		} finally {
			BrowserDevTools.blockUrls(List.of());
		}

		signInAgainPopup.clickSignInAgain();
		PlatformApp.userMenu().shouldBeDisplayed();
		PlatformApp.signInAgainPopup().shouldNotBeShown();
	}

	// Copy details ---------------------------------------------------------------------------------------------------------

	@Test
	@DisplayName("Copy details on the popup: the JSON has session, screen, view, request, status and timings")
	public void signInAgainPopup_copyDetails() {
		PlatformApp.screen(SCREEN_A);
		ssoLoginAndLogoutInAnotherTab();
		provokePopupWithAScreenChange();

		PlatformApp.signInAgainPopup()
				.checkReason(reason -> assertThat(reason).isEqualTo(SESSION_EXPIRED))
				.checkDetails((cp, exp) -> assertThat(exp).isEqualTo(cp.request()))
				.checkDetails(cp -> assertThat(cp.request().statusCode()).isEqualTo(401))
				// whichever request ran into the closed session is the one named here: a screen request, or the handshake of the
				// websocket, which asks for a token of its own and is refused just the same
				.checkDetails(cp -> assertThat(cp.request().method()).isIn("GET", "CONNECT"))
				.checkDetails(cp -> assertThat(cp.request().url()).contains("/api/v1/"))
				.checkDetails(cp -> assertThat(cp.request().sessionId()).isNotBlank())
				.checkDetails(cp -> assertThat(cp.request().startedAt()).isNotBlank())
				.checkDetails(cp -> assertThat(cp.request().finishedAt()).isNotBlank())
				.checkDetails(cp -> assertThat(cp.location()).contains("/screen/"))
				.checkDetails(cp -> assertThat(cp.screen()).isNotBlank())
				.checkDetails(cp -> assertThat(cp.view()).isNotBlank())
				// support reads these before anything else: without IndexedDB the refresh token is never sent and every renewal
				// goes by the SSO cookie, without Web Locks a tab does not wait for the tab that is renewing
				.checkDetails(cp -> assertThat(cp.userAgent()).isNotBlank())
				.checkDetails(cp -> assertThat(cp.webLocks()).isNotNull())
				.checkDetails(cp -> assertThat(cp.indexedDb()).isNotNull())
				// and the three build constants of the authorization, as this browser runs them
				.checkDetails(cp -> assertThat(cp.userManager()).isEqualTo(UserManager.ROTATION_SAFE.value()))
				.checkDetails(cp -> assertThat(cp.authErrorMode()).isIn("soft", "strict"))
				.checkDetails(cp -> assertThat(cp.signInCallbackDetection()).isIn("oidcResponse", "signInCallbackParam"));
	}

	@Test
	@DisplayName("Copy details on a business error popup (a record that does not exist)")
	public void businessError_copyDetails() {
		open(Env.uri() + FORM_VIEW_URL + MISSING_RECORD_ID);

		PlatformApp.errorPopup()
				.checkMessage(message -> assertThat(message).isNotBlank())
				.checkDetails((cp, exp) -> assertThat(exp).isEqualTo(cp.request()))
				.checkDetails(cp -> assertThat(cp.errorType()).isEqualTo("BusinessError"))
				.checkDetails(cp -> assertThat(cp.message()).isNotBlank())
				.checkDetails(cp -> assertThat(cp.request().statusCode()).isEqualTo(418))
				.checkDetails(cp -> assertThat(cp.request().url()).contains(MISSING_RECORD_ID))
				.checkDetails(cp -> assertThat(cp.request().sessionId()).isNotBlank())
				.close();
	}

	@Test
	@DisplayName("Copy details on a system error popup (500): the response body is shown in the expanded details")
	public void systemError_copyDetails() {
		var form = PlatformApp.screen("Input validation runtime exception")
				.secondLevelView("Form")
				.form("Form");
		form.input("customField").setValue("1234");

		form.errorPopup()
				.checkMessage(message -> assertThat(message).isNotBlank())
				.checkDetails((cp, exp) -> assertThat(exp).isEqualTo(cp.request()))
				.checkDetails(cp -> assertThat(cp.errorType()).isEqualTo("SystemError"))
				.checkDetails(cp -> assertThat(cp.request().statusCode()).isEqualTo(500))
				.checkDetails(cp -> assertThat(cp.request().method()).isEqualTo("POST"))
				.checkDetails(cp -> assertThat(cp.request().sessionId()).isNotBlank())
				.close();
	}

	// helpers --------------------------------------------------------------------------------------------------------------

	/**
	 * The renewal ahead of expiry starts in a few seconds instead of a minute: the token ends a little later than
	 * {@link #RENEWAL_AHEAD}, and a request lets the application read it and set its timer
	 */
	private static void renewalAheadStartsSoon() {
		accessTokenEndsIn(RENEWAL_AHEAD.plusSeconds(5));
		PlatformApp.screen(SCREEN_B);
	}

	/**
	 * A screen change to provoke the popup, which the popup itself is allowed to interrupt.
	 *
	 * The tab may have run a request into the closed session already and put the popup up on its own. Then the menu is behind a
	 * modal and the click lands on the popup instead of the item - and that is the state this provocation was after anyway.
	 */
	private static void provokePopupWithAScreenChange() {
		try {
			PlatformApp.screen(SCREEN_B);
		} catch (RuntimeException | AssertionError clickFailed) {
			if (!PlatformApp.signInAgainPopup().isShown(RENEWAL_GIVES_UP)) {
				throw clickFailed;
			}
		}
	}

	/**
	 * Works in the application (opens the two screens in turn, each is a request that needs a token) until the popup shows up,
	 * or the access token lifetime runs out.
	 */
	private static void workUntilSignInAgainPopupShows() {
		Allure.step("Work until the popup shows (up to " + tokenLifetimeWait.toMinutes() + " minutes)", () -> {
			var deadline = Instant.now().plus(tokenLifetimeWait);
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

}
