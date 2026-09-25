package application.config;


import application.config.props.Env;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import com.codeborne.selenide.proxy.SelenideProxyServerFactory;
import com.google.auto.service.AutoService;
import core.config.AppChecks;
import core.config.OidcProvider;
import core.config.TestApplicationContext;
import core.config.allure.AbstractAllureDescAppender;
import core.config.junit.AllurePerTestLog;
import core.config.selenide.AbstractLoggingProxyServer;
import core.config.selenide.AllureScreenshotExtension;
import core.config.selenide.AllureVideoRecorder;
import core.config.selenide.BrowserDevTools;
import core.element.PlatformApp;
import core.page.auth.keycloak.KeycloackAuthPage;
import core.util.DocShots;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Allure;
import io.qameta.allure.junit5.AllureJunit5;
import io.qameta.allure.listener.TestLifecycleListener;
import io.qameta.allure.selenide.AllureSelenide;
import io.qameta.allure.selenide.LogType;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.extension.RegisterExtension;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.logging.LoggingPreferences;
import org.selenide.videorecorder.core.RecordingMode;
import org.selenide.videorecorder.core.VideoSaveMode;

import java.time.Duration;
import java.util.Map;
import java.util.logging.Level;
import java.util.List;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.executeJavaScript;
import static core.element.widget.AbstractWidget.logTime;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Use @ExtendWith({JvmStatsPerTest.class.class}) to see CPU/RAM after each test. Turn off after debugging
 */
@Slf4j
@ExtendWith({AllureJunit5.class})
@DisplayName("Setup for Samples Tests")
@ExtendWith({AllureVideoRecorder.class, AllureScreenshotExtension.class})
public abstract class BaseTestForSamples {

	/**
	 * singleton with whole cxbox-test-dsl context. thread-safe. immutable
	 */
	public static final TestApplicationContext $box = new TestApplicationContext();

	@RegisterExtension
	private static final AllurePerTestLog apiLogNoLogin = new AllurePerTestLog(
			"Network logs (except login)",
			"API_NO_LOGIN_LOGGER"
	);

	@BeforeAll
	public static void setUpAllure() {
		WebDriverManager.chromedriver().setup();
		Configuration.browser = "chrome";
		Configuration.headless = false;
		Configuration.timeout = 10000;
		Configuration.browserSize = DocShots.enabled() ? DocShots.browserSize() : "1280x800";
		Configuration.pageLoadTimeout = 60000;
		Configuration.webdriverLogsEnabled = false;
		Configuration.reportsFolder = "target/videos";
		if (Env.logEnabled()) {
			Configuration.proxyEnabled = true;
		}
		if (Env.videoEnabled()) {
			System.setProperty("selenide.video.enabled", String.valueOf(true));
			System.setProperty("selenide.video.save.mode", VideoSaveMode.FAILED_ONLY.name());
			System.setProperty("selenide.video.directory", "target/videos");
			System.setProperty("selenide.video.mode", RecordingMode.ALL.name());
			System.setProperty("selenide.video.fps", String.valueOf(10));
			//0 (lossless) to 51 (the lowest quality)
			System.setProperty("selenide.video.crf", String.valueOf(0));
		}
		Configuration.browserCapabilities = getChromeOptions().addArguments(DocShots.chromeArguments());

		SelenideLogger.addListener(
				AllureSelenide.class.getName(),
				new AllureSelenide()
						.enableLogs(LogType.BROWSER, Env.logEnabled() ? Level.ALL : Level.OFF)
						.includeSelenideSteps(false)
						.screenshots(true)
						.savePageSource(true)
		);
		// Disabled  ( catch error in debug running mod)
		// Highlight current  element on page orange border
//		SelenideHighlightSetup.registerAllHighlightedCommands();
		AppChecks.waitAppStarted(Env.uri(), Duration.ofMinutes(5), Duration.ofSeconds(5));
	}


	@NonNull
	private static ChromeOptions getChromeOptions() {
		String envApp = String.valueOf(Env.uri());

		var options = new ChromeOptions().addArguments(
				Boolean.getBoolean("headed") ? "--start-maximized" : "--headless",
//				"--auto-open-devtools-for-tabs", // show devtools on start browser
				"--enable-automation",
				"--remote-allow-origins=*",
				"--disable-features=InsecureDownloadWarnings",
				"--unsafely-treat-insecure-origin-as-secure=" + envApp,
				"--disable-popup-blocking",
				"--no-sandbox",
				"--disable-dev-shm-usage",
				"--disable-software-rasterizer",
				"--disable-gpu",
				"--disable-web-security",
				"--disable-notifications",
				"--disable-background-networking",
				"--disable-component-update",
				"--disable-default-apps",
				"--disable-sync",
				"--metrics-recording-only",
				"--safebrowsing-disable-auto-update",
				"--no-first-run",
				"--no-default-browser-check",
				"--disable-translate",
				"--disable-features=OptimizationHints,OptimizationGuideModelDownloading,HttpsUpgrades,HttpsFirstBalancedModeAutoEnable"
		);
		options.setAcceptInsecureCerts(true);
		// the browser console is always collected (a driver-side buffer, read on demand: BrowserDevTools.consoleLog());
		// CXBOX_LOGGER only decides whether it is attached to the Allure report
		var pref = new LoggingPreferences();
		pref.enable(LogType.BROWSER.toString(), Level.ALL);
		// network events for BrowserDevTools.networkRequests() / webSocketHandshakes()
		pref.enable(org.openqa.selenium.logging.LogType.PERFORMANCE, Level.ALL);
		options.setCapability("goog:loggingPrefs", pref);
		System.setProperty("chromeoptions.prefs", "credentials_enable_service=false, password_manager_enabled=false");
		return options;
	}

	@BeforeEach
	public void beforeEach() {
		// the browser is shared by the tests of a fork: the logs of the previous test are dropped, they would pile up otherwise
		BrowserDevTools.clearNetworkLog();
		BrowserDevTools.clearConsoleLog();
		// the session of the same user is kept, another user is logged out first: the sign in happens once per browser
		new KeycloackAuthPage().checkUserOrElseAuthWithUsernameAndPassword("demo", "demo", Env.uri());
	}

	/**
	 * Opens the application, signs in on the login page it redirects to and waits until the application has stored the user:
	 * only then the sign in is complete and the browser state is consistent for whatever comes next (a {@link #logout()} in particular).
	 */
	protected void login(String login, String password) {
		Allure.step(
				"Login", step -> {
					logTime(step);
					Selenide.open(Env.uri().toString());
					new KeycloackAuthPage().authWithUsernameAndPassword(login, password, Env.uri());
					Selenide.Wait().withMessage("the application has not stored the signed-in user").until(driver -> OidcProvider.isUserStored());
				}
		);
	}

	/**
	 * Ends the session through the OIDC end-session link and wipes the browser state: the way to sign in as somebody else
	 * within a test. About three times faster than the "Log out" button; a scenario about the user logging out clicks the
	 * button instead: {@code PlatformApp.userMenu().logout()}. There is no logout after every test: the next test signs in
	 * through {@link KeycloackAuthPage#checkUserOrElseAuthWithUsernameAndPassword}, which keeps the session of the same user
	 * and logs out another one.
	 */
	protected void logout() {
		Allure.step(
				"Logout", step -> {
					logTime(step);
					String logoutUrl = oidc().logoutUrl(Env.uri());
					executeJavaScript("sessionStorage.clear(); localStorage.clear();");
					Selenide.open(logoutUrl);
					Selenide.clearBrowserCookies();
				}
		);
	}

	/**
	 * The browser is on the login page (after a logout, or the sign in of a user the application does not let in).
	 * Not to be confused with {@link AppChecks#waitAppStarted}: that one polls the application over HTTP before the browser is opened.
	 */
	protected void shouldBeOnLoginPage() {
		KeycloackAuthPage.login.shouldBe(Condition.visible);
	}

	/**
	 * A second tab of the same browser opens the application, gets signed in by the SSO session without a login page, and logs out.
	 * The first tab shares that session and the stored user, so it is left with a closed session.
	 */
	protected static void ssoLoginAndLogoutInAnotherTab() {
		Allure.step("SSO login and logout in another tab of the same browser", () -> {
			Selenide.switchTo().newWindow(WindowType.TAB);
			Selenide.open(Env.uri().toString());
			PlatformApp.userMenu().logout();
			Selenide.closeWindow();
			Selenide.switchTo().window(0);
		});
	}

	/**
	 * Console warnings of the token renewal ({@code ui/src/auth/rotationSafeUserManager}). The tests read them to tell which way a
	 * renewal went; what they PROVE is proved by the network log and the storage, see {@link #refreshTokensSent()}.
	 * <p>
	 * This one: the refresh token has been sent and no new one has come - a refusal, a timeout, a lost answer, F5 of the page that
	 * sent it. Or somebody else has sent it. It is never sent again, the session goes on by the SSO cookie
	 */
	protected static final String TOKEN_BURNT = "Token renewal: the refresh token is burnt";

	/**
	 * The renewal by the SSO cookie through the hidden iframe did not work out either: the session is lost
	 */
	protected static final String IFRAME_FAILED = "Token renewal: the hidden iframe with the SSO cookie failed";

	/**
	 * {@code USER_MANAGER} of {@code ui/src/constants/index.ts}: the class that works with the OIDC provider
	 */
	protected enum UserManager {
		/**
		 * {@code RotationSafeUserManager}, the default: a refresh token is sent once
		 */
		ROTATION_SAFE("rotationSafe"),
		/**
		 * Plain {@code UserManager} of oidc-client-ts: the fallback
		 */
		ORIGINAL("original");

		private final String value;

		UserManager(String value) {
			this.value = value;
		}

		public String value() {
			return value;
		}
	}

	/**
	 * {@code SIGN_IN_CALLBACK_DETECTION} of {@code ui/src/constants/index.ts}: how the page learns at load that the OIDC provider
	 * returned the browser to it
	 */
	protected enum SignInCallbackDetection {
		/**
		 * By the response of the provider in the address, {@code state} with {@code code} or {@code error}: the default
		 */
		OIDC_RESPONSE("oidcResponse"),
		/**
		 * By our parameter {@code sign_in_callback} of {@code redirect_uri}: the fallback
		 */
		SIGN_IN_CALLBACK_PARAM("signInCallbackParam");

		private final String value;

		SignInCallbackDetection(String value) {
			this.value = value;
		}

		public String value() {
			return value;
		}
	}

	/**
	 * Chooses the user manager for this browser: the key {@code cxbox.userManager} of localStorage overrides the build constant
	 * {@code USER_MANAGER}. It works from the next page load. {@link #logout()} removes it with the rest of the storage, so the
	 * next test gets the build constant again.
	 */
	protected static void useUserManager(UserManager userManager) {
		overrideForThisBrowser("USER_MANAGER", "cxbox.userManager", userManager.value());
	}

	/**
	 * The same for {@code SIGN_IN_CALLBACK_DETECTION}: the key {@code cxbox.signInCallbackDetection} of localStorage
	 */
	protected static void useSignInCallbackDetection(SignInCallbackDetection detection) {
		overrideForThisBrowser("SIGN_IN_CALLBACK_DETECTION", "cxbox.signInCallbackDetection", detection.value());
	}

	private static void overrideForThisBrowser(String constant, String key, String value) {
		Allure.step(constant + " = '" + value + "' for this browser", () -> {
			// a page of the application's origin that does not start the application
			Selenide.open(Env.uri().resolve("/api/v1/auth/oidc.json").toString());
			executeJavaScript("localStorage.setItem(arguments[0], arguments[1]);", key, value);
		});
	}

	/**
	 * oidc-client-ts starts the renewal this long before the access token ends
	 * ({@code accessTokenExpiringNotificationTimeInSeconds}, the library default)
	 */
	protected static final Duration RENEWAL_AHEAD = Duration.ofSeconds(60);

	/**
	 * The application renews a token that ends within 5 seconds before it sends a request ({@code MIN_VALIDITY_SECONDS} of
	 * {@code RotationSafeUserManager}). A token with this much left is inside that window and is still valid
	 */
	protected static final Duration ABOUT_TO_END = Duration.ofSeconds(4);

	/**
	 * Makes the application believe that its access token ends in the given time, so a test does not wait the real lifetime out.
	 * <p>
	 * Only {@code expires_at} changes: a note that oidc-client-ts keeps NEXT TO the tokens in localStorage, counted from the answer
	 * of the provider. The tokens themselves are not touched: the provider signed them, the backend checks the signature and the
	 * {@code exp} inside the token and goes on accepting it, and the refresh token is as good as it was. So everything the
	 * application does next is real: the request to the provider, the rotation, the answer.
	 * <p>
	 * The application reads the new time at its next request.
	 */
	protected static void accessTokenEndsIn(Duration left) {
		Allure.step("The application believes that its access token ends in " + left.toSeconds() + " s", () -> executeJavaScript("""
				const key = Object.keys(localStorage).find(k => k.startsWith('oidc.user:'));
				const user = JSON.parse(localStorage.getItem(key));
				user.expires_at = Math.floor(Date.now() / 1000) + arguments[0];
				localStorage.setItem(key, JSON.stringify(user));
				""", left.toSeconds()));
	}

	/**
	 * Takes the signed-in user out of the storage of the application, as if its sign in had never finished. The SSO session in the
	 * provider stays
	 */
	protected static void forgetStoredUser() {
		executeJavaScript("Object.keys(localStorage).filter(key => key.startsWith('oidc.user:')).forEach(key => localStorage.removeItem(key));");
	}

	/**
	 * The addresses of the page loads that were a return from the OIDC provider with an authorization code, since
	 * {@link BrowserDevTools#clearNetworkLog()}, in order
	 */
	protected static List<String> returnsFromProvider() {
		var application = Env.uri().getScheme() + "://" + Env.uri().getAuthority();
		return BrowserDevTools.networkRequests().stream()
				.filter(request -> "GET".equals(request.method()) && request.url().startsWith(application))
				.map(BrowserDevTools.NetworkRequest::url)
				.filter(url -> url.matches(".*[?&]code=.*") && url.matches(".*[?&]state=.*"))
				.toList();
	}

	/**
	 * The values of the refresh tokens the browser has sent to the token endpoint since {@link BrowserDevTools#clearNetworkLog()},
	 * from every tab, in order. The exchange of a code at sign in goes to the same endpoint and is not counted
	 */
	protected static List<String> refreshTokensSent() {
		return BrowserDevTools.networkRequests().stream()
				.filter(request -> "POST".equals(request.method()) && request.url().startsWith(oidc().getTokenEndpoint()))
				.map(BrowserDevTools.NetworkRequest::body)
				.filter(body -> body != null && body.contains("grant_type=refresh_token"))
				.map(body -> java.util.Arrays.stream(body.split("&"))
						.filter(parameter -> parameter.startsWith("refresh_token="))
						.map(parameter -> parameter.substring("refresh_token=".length()))
						.findFirst()
						.orElse(""))
				.toList();
	}

	/**
	 * THE invariant of the token renewal: one refresh token is sent to the provider at most once, by all the tabs and through
	 * every reload of the page. The provider rotates refresh tokens and reads a second use as theft
	 */
	protected static void assertNoRefreshTokenSentTwice() {
		assertThat(refreshTokensSent())
				.as("every refresh token is sent to the provider at most once")
				.doesNotHaveDuplicates();
	}

	/**
	 * Renewal requests to the token endpoint of the OIDC provider since {@link BrowserDevTools#clearNetworkLog()}, from every tab
	 */
	protected static long countTokenRequests() {
		return BrowserDevTools.networkRequests().stream()
				.filter(request -> "POST".equals(request.method()) && request.url().startsWith(oidc().getTokenEndpoint()))
				.count();
	}

	private static OidcProvider oidcProvider;

	/**
	 * The OIDC provider of the application, read once per JVM
	 */
	protected static OidcProvider oidc() {
		if (oidcProvider == null) {
			oidcProvider = OidcProvider.ofApp(Env.uri());
		}
		return oidcProvider;
	}

	@SuppressWarnings("unused")
	@AutoService(SelenideProxyServerFactory.class)
	public static class LoggingProxyServer extends AbstractLoggingProxyServer {

		public LoggingProxyServer() {
			super(Map.of(
					"1", new ProxyLogFilter(
							// the requests to the OIDC provider are here as well: without them the log says nothing about a sign in
							// that the provider refused, and that is exactly what has to be read when it answers invalid_code
							url -> (url.contains("api/v1/") && !url.contains("api/v1/login")) || url.contains("/auth/realms/"),
							apiLogNoLogin.getPerTestLogger()::trace
					)
			));
		}

	}

	@SuppressWarnings("unused")
	@AutoService(TestLifecycleListener.class)
	public static class AllureDescAppender extends AbstractAllureDescAppender {

		public AllureDescAppender() {
			super("""
					into <a href="https://github.com/CX-Box/cxbox-code-samples/actions/workflows/build_button_qa.yml" target="_blank">GitHub Actions</a> 
					→ <strong>Run Workflow</strong> 
					→ <strong>include PATH</strong>
					""");
		}

	}

}
