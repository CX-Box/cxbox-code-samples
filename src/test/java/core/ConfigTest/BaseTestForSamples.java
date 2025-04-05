package core.ConfigTest;

import com.browserup.bup.BrowserUpProxy;
import com.browserup.bup.proxy.CaptureType;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.logevents.SelenideLogger;
import core.TestApplicationContext;
import core.LoginPage;
import core.widget.TestingTools.AppChecks;
import io.qameta.allure.Allure;
import io.qameta.allure.junit5.AllureJunit5;
import io.qameta.allure.selenide.AllureSelenide;
import io.qameta.allure.selenide.LogType;
import java.util.function.Consumer;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.logging.LoggingPreferences;

import java.time.Duration;
import java.util.logging.Level;

import org.selenide.videorecorder.core.RecordingMode;
import org.selenide.videorecorder.junit5.VideoRecorderExtension;

import static core.ConfigTest.BrowserLogsUtil.allureAttachNetworkLog;
import static core.widget.TestingTools.CellProcessor.logTime;

@ExtendWith({AllureJunit5.class})
@DisplayName("Setup for Samples Tests")
@ExtendWith({VideoRecorderExtension.class})
@Slf4j
public abstract class BaseTestForSamples {

	/**
	 * singleton with whole cxbox-test-dsl context. thread-safe. immutable
	 */
	public static final TestApplicationContext $box = new TestApplicationContext();

	@BeforeAll
	public static void setUpAllure() {
		SelenideLogger.addListener(
				"AllureSelenide", new AllureSelenide()
						.enableLogs(LogType.BROWSER, Env.logEnabled() ? Level.ALL : Level.OFF)
						.includeSelenideSteps(false)
						.screenshots(true)
						.savePageSource(true)
		);
		Allure.step(
				"Configuring the browser...", step -> {
					logTime(step);
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
						System.setProperty("selenide.video.directory", "target/videos");
						System.setProperty("selenide.video.enabled", String.valueOf(true));
						System.setProperty("selenide.video.mode", RecordingMode.ALL.name());
						System.setProperty("selenide.video.fps", String.valueOf(10));
						//CRF operates on a scale from 0 (lossless) to 51 (the lowest quality)
						System.setProperty("selenide.video.crf", String.valueOf(25));
					}
					Configuration.browserCapabilities = getChromeOptions();
				}
		);
		AppChecks.waitAppLoginPageReady(Env.uri(), Duration.ofMinutes(5), Duration.ofSeconds(5));
	}

	@AfterAll
	public static void afterAll() {
		Allure.step(
				"Clean up resources", step -> {
				}
		);
	}

	private static void ifProxyEnabled(@NonNull Consumer<BrowserUpProxy> proxyConsumer) {
		if (Configuration.proxyEnabled) {
			proxyConsumer.accept(WebDriverRunner.getSelenideProxy().getProxy());
		}
	}

	@NonNull
	private static ChromeOptions getChromeOptions() {
		var options = new ChromeOptions()
				.addArguments(
						"--headless",
						"--enable-automation",
						"--remote-allow-origins=*",
						"--disable-features=InsecureDownloadWarnings",
						"--unsafely-treat-insecure-origin-as-secure=http://demo.cxbox.org/",
						"--unsafely-treat-insecure-origin-as-secure=http://code-samples.cxbox.org/ui/#",
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
						"--disable-translate"
				);
		options.setAcceptInsecureCerts(true);
		if (Env.logEnabled()) {
			var pref = new LoggingPreferences();
			pref.enable(LogType.BROWSER.toString(), Level.ALL);
			options.setCapability("goog:loggingPrefs", pref);
		}
		System.setProperty("chromeoptions.prefs", "credentials_enable_service=false, password_manager_enabled=false");
		return options;
	}

	@BeforeEach
	public void setUp() {
		Allure.step(
				"Launching the browser log session", step -> {
					logTime(step);
					Selenide.open(AppChecks.logoutAndRedirectToLoginPageUri(Env.uri()));
					ifProxyEnabled(proxy -> {
						var capture = CaptureType.getNonBinaryContentCaptureTypes();
						capture.addAll(CaptureType.getHeaderCaptureTypes());
						proxy.setHarCaptureTypes(capture);
						proxy.enableHarCaptureTypes(capture);
						proxy.newHar("Proxy start");
					});
					LoginPage.keycloakLogin("demo", "demo", Env.uri());
				}
		);
	}

	@AfterEach
	public void afterEach() {
		Allure.step(
				"Attaching test results", step -> {
					logTime(step);
					if (!Env.logEnabled()) {
						ifProxyEnabled(proxy -> {
							allureAttachNetworkLog(proxy.getHar(true));
							proxy.endHar();
						});
					}
					if (Env.videoEnabled()) {
						VideoRecorderExtension.getRecordedVideo().ifPresent(video ->
								Allure.addAttachment(
										"Video", "video/webm",
										FileUtil.newInputStreamSneaky(video), ".webm"
								));
					}
				}
		);
	}

}
