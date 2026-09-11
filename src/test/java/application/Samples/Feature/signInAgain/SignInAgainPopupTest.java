package application.Samples.Feature.signInAgain;

import application.config.BaseTestForSamples;
import application.config.oidc.keycloak.KeycloakAdmin;
import application.config.props.Env;
import com.codeborne.selenide.CollectionCondition;
import core.config.selenide.BrowserDevTools;
import core.element.PlatformApp;
import core.element.widget.modal.SignInAgainPopup;
import io.qameta.allure.Allure;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import java.time.Duration;
import java.time.Instant;
import java.util.List;
import java.util.UUID;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.EnabledIfEnvironmentVariable;

import static com.codeborne.selenide.Selenide.open;
import static core.element.widget.modal.SignInAgainPopup.Reason.INSUFFICIENT_PERMISSIONS;
import static core.element.widget.modal.SignInAgainPopup.Reason.SESSION_EXPIRED;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * CXBOX-1250. Authorization errors in the UI, {@code AUTH_ERROR_MODE = 'soft'} (the default): the "Sign in again?" popup
 * on 401/403, access token renewal before every request, "Copy details" in error popups.
 * <p>
 * Real UI, real OIDC provider, nothing injected into the page. Checks use {@code data-test} attributes and the copied JSON,
 * never displayed texts, so the UI language does not matter.
 * <p>
 * The Keycloak may be shared with other runs: every run creates its own users with a random suffix and deletes them at the end,
 * nothing else is changed. The scenarios that need an expired token wait the real access token lifetime out (tagged {@code Slow}).
 * The tests run only when {@code KEYCLOAK_ADMIN_USER} is set.
 */
@DisplayName("Authorization: \"Sign in again?\" popup, token renewal, Copy details")
@Epic("Samples")
@Tag("Samples")
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

	private static final String SCREEN_A = "Input basic";

	private static final String SCREEN_B = "Picklist basic";

	/**
	 * A form view: the last url segment is the record id the backend has to load
	 */
	private static final String FORM_VIEW_URL = "screen/InputDrilldown/view/InputDrilldownform/InputDrilldown/";

	private static final String MISSING_RECORD_ID = "999999999";

	private static final Duration TOKEN_LIFETIME_POLL = Duration.ofSeconds(10);

	private static final Duration SNOOZE_WAIT = Duration.ofSeconds(5);

	private static KeycloakAdmin keycloakAdmin;

	/**
	 * The access token lifetime of the realm plus a margin for the renewal and the request that follows it
	 */
	private static Duration tokenLifetimeWait;

	@BeforeAll
	static void createTestUsers() {
		keycloakAdmin = KeycloakAdmin.forApp(Env.uri());
		tokenLifetimeWait = keycloakAdmin.getAccessTokenLifespan().plusSeconds(90);
		Allure.step("Create the users of this run", () -> {
			keycloakAdmin.createUser(USER_WITHOUT_ROLES.login(), USER_WITHOUT_ROLES.password(), List.of());
			keycloakAdmin.createUser(USER_LOSING_ROLES.login(), USER_LOSING_ROLES.password(), keycloakAdmin.getClientRoles(DEMO_USER.login()));
		});
		// a killed run must not leave its users behind either
		Runtime.getRuntime().addShutdownHook(new Thread(SignInAgainPopupTest::deleteTestUsers));
	}

	@AfterAll
	static void deleteTestUsers() {
		keycloakAdmin.deleteUser(USER_WITHOUT_ROLES.login());
		keycloakAdmin.deleteUser(USER_LOSING_ROLES.login());
	}

	@BeforeEach
	@Override
	public void beforeEach() {
		super.beforeEach();
		BrowserDevTools.grantClipboardPermission(Env.uri());
		BrowserDevTools.blockUrls(List.of());
	}

	// 401: the session was closed outside the tab -----------------------------------------------------------------------

	@Test
	@DisplayName("401: after Log out in another tab the next request shows the popup, the widgets stay on screen")
	@Description("The user logs out in a second tab of the same browser. Back in the first tab a screen change makes the app renew "
			+ "the token, the OIDC provider answers that the session is over and the popup is shown with \"No (30s)\" and \"Yes\".")
	public void sessionExpired_popupIsShown() {
		PlatformApp.screen(SCREEN_A);
		ssoLoginAndLogoutInAnotherTab();
		PlatformApp.screen(SCREEN_B);

		PlatformApp.signInAgainPopup()
				.checkReason(reason -> assertThat(reason).isEqualTo(SESSION_EXPIRED))
				.checkTitleAndMessage(title -> assertThat(title).isNotBlank(), message -> assertThat(message).isNotBlank());
		PlatformApp.currentScreen().element().shouldBe(CollectionCondition.sizeGreaterThan(0));
	}

	@Test
	@DisplayName("401: \"No\" closes the popup and further failing requests do not reopen it while the answer is remembered")
	public void sessionExpired_cancelSnoozesThePopup() {
		PlatformApp.screen(SCREEN_A);
		ssoLoginAndLogoutInAnotherTab();
		PlatformApp.screen(SCREEN_B);

		PlatformApp.signInAgainPopup()
				.checkReason(reason -> assertThat(reason).isEqualTo(SESSION_EXPIRED))
				.clickNo();

		PlatformApp.screen(SCREEN_A);
		PlatformApp.screen(SCREEN_B);
		PlatformApp.signInAgainPopup().shouldNotBeShown(SNOOZE_WAIT);
	}

	@Test
	@DisplayName("401: \"Yes\" logs out and opens the login page, signing in again restores the application")
	public void sessionExpired_okGoesToLoginPage() {
		PlatformApp.screen(SCREEN_A);
		ssoLoginAndLogoutInAnotherTab();
		PlatformApp.screen(SCREEN_B);

		PlatformApp.signInAgainPopup()
				.checkReason(reason -> assertThat(reason).isEqualTo(SESSION_EXPIRED))
				.clickYes();

		super.login(DEMO_USER.login(), DEMO_USER.password());
		PlatformApp.userMenu().shouldBeDisplayed();
		PlatformApp.signInAgainPopup().shouldNotBeShown();
	}

	// 403: no roles ----------------------------------------------------------------------------------------------------

	@Test
	@DisplayName("403: sign in of a user without roles shows the popup on the start page instead of an endless spinner")
	public void userWithoutRoles_loginShowsPopup() {
		super.logout();
		super.login(USER_WITHOUT_ROLES.login(), USER_WITHOUT_ROLES.password());

		PlatformApp.signInAgainPopup()
				.checkReason(reason -> assertThat(reason).isEqualTo(INSUFFICIENT_PERMISSIONS))
				.clickYes();
		shouldBeOnLoginPage();
	}

	@Test
	@Tag("Slow")
	@DisplayName("403: roles removed in the OIDC provider while the user works; the next token renewal ends in the popup, roles given back are active again after sign in")
	@Description("The administrator removes every client role of the user. The next token the application receives has no roles, "
			+ "the backend answers 403 and the popup is shown. With the roles back a new sign in works: the roles are reactivated "
			+ "in the database (CXBOX-1250 user_roles sync fix).")
	public void rolesRemovedDuringSession_popupThenRolesReactivated() {
		var demoUserRoles = keycloakAdmin.getClientRoles(DEMO_USER.login());
		super.logout();
		super.login(USER_LOSING_ROLES.login(), USER_LOSING_ROLES.password());
		PlatformApp.screen(SCREEN_A);
		keycloakAdmin.revokeAllClientRoles(USER_LOSING_ROLES.login());

		workUntilSignInAgainPopupShows();
		var signInAgainPopup = PlatformApp.signInAgainPopup()
				.checkReason(reason -> assertThat(reason).isEqualTo(INSUFFICIENT_PERMISSIONS));

		keycloakAdmin.grantClientRoles(USER_LOSING_ROLES.login(), demoUserRoles);
		signInAgainPopup.clickYes();
		super.login(USER_LOSING_ROLES.login(), USER_LOSING_ROLES.password());
		PlatformApp.screen(SCREEN_A);
		PlatformApp.signInAgainPopup().shouldNotBeShown(SNOOZE_WAIT);
	}

	// Token renewal before every request ---------------------------------------------------------------------------------

	@Test
	@Tag("Slow")
	@DisplayName("OIDC provider unreachable: 3 attempts ahead of expiry, 3 attempts before the request shared by the screen, then the popup")
	@Description("The token endpoint of the OIDC provider is unreachable. The renewal ahead of expiry fails (3 attempts 1 second apart), "
			+ "the token expires, the next screen change makes the application renew the token before the request: 3 attempts again, "
			+ "one renewal for all widgets of the screen, then the popup \"Session has expired\". With the provider back, \"Yes\" leads to the login page.")
	public void providerUnreachable_threeSharedAttemptsThenPopup() {
		SignInAgainPopup signInAgainPopup;
		try {
			PlatformApp.screen(SCREEN_A);
			BrowserDevTools.clearConsoleLog();
			BrowserDevTools.blockUrls(List.of(oidc().getTokenEndpoint() + "*"));

			workUntilSignInAgainPopupShows();
			signInAgainPopup = PlatformApp.signInAgainPopup()
					.checkReason(reason -> assertThat(reason).isEqualTo(SESSION_EXPIRED));

			assertThat(BrowserDevTools.consoleLog())
					.as("2 retries and the final failure ahead of expiry, the same before the request: one renewal shared by all widgets of the screen")
					.filteredOn(message -> message.contains("Failed to refresh the token"))
					.satisfiesExactly(
							ahead1 -> assertThat(ahead1).contains("attempt 1 of 3"),
							ahead2 -> assertThat(ahead2).contains("attempt 2 of 3"),
							aheadLast -> assertThat(aheadLast).contains("or the session has expired"),
							first -> assertThat(first).contains("attempt 1 of 3"),
							second -> assertThat(second).contains("attempt 2 of 3"),
							last -> assertThat(last).contains("or the session has expired")
					);
		} finally {
			BrowserDevTools.blockUrls(List.of());
		}

		signInAgainPopup.clickYes();
		super.login(DEMO_USER.login(), DEMO_USER.password());
		PlatformApp.userMenu().shouldBeDisplayed();
	}

	// Copy details ---------------------------------------------------------------------------------------------------------

	@Test
	@DisplayName("Copy details on the \"Sign in again?\" popup: the JSON has session, screen, view, request, status and timings")
	public void signInAgainPopup_copyDetails() {
		PlatformApp.screen(SCREEN_A);
		ssoLoginAndLogoutInAnotherTab();
		PlatformApp.screen(SCREEN_B);

		PlatformApp.signInAgainPopup()
				.checkReason(reason -> assertThat(reason).isEqualTo(SESSION_EXPIRED))
				.checkDetails((cp, exp) -> assertThat(exp).isEqualTo(cp.request()))
				.checkDetails(cp -> assertThat(cp.request().statusCode()).isEqualTo(401))
				.checkDetails(cp -> assertThat(cp.request().method()).isEqualTo("GET"))
				.checkDetails(cp -> assertThat(cp.request().url()).contains("/api/v1/"))
				.checkDetails(cp -> assertThat(cp.request().sessionId()).isNotBlank())
				.checkDetails(cp -> assertThat(cp.request().startedAt()).isNotBlank())
				.checkDetails(cp -> assertThat(cp.request().finishedAt()).isNotBlank())
				.checkDetails(cp -> assertThat(cp.location()).contains("/screen/"))
				.checkDetails(cp -> assertThat(cp.screen()).isNotBlank())
				.checkDetails(cp -> assertThat(cp.view()).isNotBlank())
				.clickNo();
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
	 * Works in the application (opens the two screens in turn, each is a request that renews the token) until the
	 * "Sign in again?" popup shows up, or the access token lifetime runs out.
	 */
	private static void workUntilSignInAgainPopupShows() {
		Allure.step("Work until the popup shows (up to " + tokenLifetimeWait.toMinutes() + " minutes)", () -> {
			var deadline = Instant.now().plus(tokenLifetimeWait);
			var screens = List.of(SCREEN_A, SCREEN_B);
			for (int i = 0; !PlatformApp.signInAgainPopup().isShown(TOKEN_LIFETIME_POLL); i++) {
				assertThat(Instant.now()).as("the popup did not show within the token lifetime").isBefore(deadline);
				PlatformApp.screen(screens.get(i % screens.size()));
			}
		});
	}

}
