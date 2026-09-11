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
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Allure;
import io.qameta.allure.junit5.AllureJunit5;
import io.qameta.allure.listener.TestLifecycleListener;
import io.qameta.allure.selenide.AllureSelenide;
import io.qameta.allure.selenide.LogType;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.AfterEach;
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

import static com.codeborne.selenide.Selenide.executeJavaScript;
import static core.element.widget.AbstractWidget.logTime;

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
		Configuration.browserSize = "1280x800";
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
		Configuration.browserCapabilities = getChromeOptions();

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
				"--headless",
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
		login("demo", "demo");
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

	@AfterEach
	public void afterEach() {
		logout();
	}

	/**
	 * Ends the session through the OIDC end-session link and wipes the browser state: the cleanup between tests, and the way
	 * to sign in as somebody else within a test. About three times faster than the "Log out" button; a scenario about the user
	 * logging out clicks the button instead: {@code PlatformApp.userMenu().logout()}.
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
	 * Console messages of the application about the token renewal (ui/src/auth/tokenRenewal.ts), the tests look for them
	 */
	protected static final String RENEWAL_FAILED = "Failed to refresh the token, or the session has expired";

	protected static final String RENEWED_BY_ANOTHER_TAB = "The token has already been renewed by another tab";

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
							url -> url.contains("api/v1/") && !url.contains("api/v1/login"),
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
