package core.config;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.LogEvent;
import com.codeborne.selenide.logevents.LogEvent.EventStatus;
import com.codeborne.selenide.logevents.LogEventListener;
import com.codeborne.selenide.logevents.SelenideLogger;
import core.TestApplicationContext;
import core.LoginPage;
import core.config.junit.JvmStatsConfig;
import core.config.junit.LogPerTestConfig;
import core.util.FileUtil;
import core.widget.TestingTools.AppChecks;
import io.qameta.allure.Allure;
import io.qameta.allure.junit5.AllureJunit5;
import io.qameta.allure.selenide.AllureSelenide;
import io.qameta.allure.selenide.LogType;
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

import static core.widget.TestingTools.CellProcessor.logTime;

@ExtendWith({AllureJunit5.class})
@DisplayName("Setup for Samples Tests")
@ExtendWith({VideoRecorderExtension.class, LogPerTestConfig.class, JvmStatsConfig.class})
@Slf4j
public abstract class BaseTestForSamples {

	/**
	 * singleton with whole cxbox-test-dsl context. thread-safe. immutable
	 */
	public static final TestApplicationContext $box = new TestApplicationContext();


	@BeforeAll
	public static void setUpAllure() {
		SelenideLogger.addListener(
				"AllureSelenide",
				new AllureSelenide()
						.enableLogs(LogType.BROWSER, Env.logEnabled() ? Level.ALL : Level.OFF)
						.includeSelenideSteps(false)
						.screenshots(true)
						.savePageSource(true)
		);
		SelenideLogger.addListener(
				"AllureSelenideExt", new LogEventListener() {

					@Override
					public void beforeEvent(@NonNull LogEvent currentLog) {
					}

					@Override
					public void afterEvent(@NonNull LogEvent event) {
						var lifecycle = Allure.getLifecycle();
						if (event.getStatus().equals(EventStatus.FAIL)) {
							lifecycle.getCurrentTestCaseOrStep().ifPresent(parentUuid -> {
								if (Env.videoEnabled()) {
									VideoRecorderExtension.getRecordedVideo().ifPresent(video -> Allure.addAttachment(
											"Video",
											"video/webm",
											FileUtil.newInputStreamSneaky(video),
											".webm"
									));
								}
							});
						}
					}
				}
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
		Selenide.open(AppChecks.logoutAndRedirectToLoginPageUri(Env.uri()));
		LoginPage.keycloakLogin("demo", "demo", Env.uri());
	}

	@AfterAll
	public static void afterAll() {
		SelenideLogger.removeListener("AllureSelenide");
		SelenideLogger.removeListener("AllureSelenideExt");
	}

	@NonNull
	private static ChromeOptions getChromeOptions() {
		var options = new ChromeOptions().addArguments(
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
	public void beforeEach() {
		Allure.step(
				"Logout and login from scratch", step -> {
					logTime(step);
					Selenide.open(AppChecks.logoutAndRedirectToLoginPageUri(Env.uri()));
					LoginPage.keycloakLogin("demo", "demo", Env.uri());
				}
		);
	}

}
