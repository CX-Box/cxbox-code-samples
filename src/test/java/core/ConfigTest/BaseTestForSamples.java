package core.ConfigTest;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideConfig;
import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.logevents.SelenideLogger;
import core.LoginPage;
import core.WidgetPage;
import io.qameta.allure.Allure;
import io.qameta.allure.junit5.AllureJunit5;
import io.qameta.allure.selenide.AllureSelenide;
import io.qameta.allure.selenide.LogType;
import lombok.NonNull;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v133.network.Network;
import org.openqa.selenium.devtools.v133.network.model.Response;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.logging.Logs;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;
import java.util.Optional;
import java.util.logging.Level;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static core.widget.TestingTools.CellProcessor.logTime;


@ExtendWith({AllureJunit5.class})
@DisplayName("Setup for Samples Tests")
public class BaseTestForSamples {
    public static WidgetPage page;
    private static final Logger logger = LoggerFactory.getLogger(BaseTestForSamples.class);
    private DevTools devTools = null;
    StringBuilder resContent = new StringBuilder();

    @BeforeAll
    public static void setUpAllure(){
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide()
                .screenshots(true)
                .savePageSource(true));
    }

    @BeforeEach
    public void setUp() {
        Allure.step("Launching the browser...", step -> {
            logTime(step);
            SelenideConfig selenideConfig = new SelenideConfig();
            SelenideLogger.addListener("AllureSelenide",
                    new AllureSelenide()
                            .includeSelenideSteps(false)
                            .screenshots(true)
                            .savePageSource(false)
            );

            Configuration.browser = "chrome";
            Configuration.headless = false;
            Configuration.timeout = 10000;
            Configuration.browserSize = "1280x800";
            Configuration.pageLoadTimeout = 60000;
            Configuration.browserCapabilities = getChromeOptions();
            Configuration.webdriverLogsEnabled = false;


            Selenide.open(getEnv());
            page = new LoginPage().loginKeyCloak("demo", "demo");

            ChromeDriver driver = (ChromeDriver) WebDriverRunner.getWebDriver();
            devTools = driver.getDevTools();

            devTools.createSession();
            devTools.send(Network.enable(Optional.empty(), Optional.empty(), Optional.empty()));

            devTools.addListener(Network.responseReceived(), response -> {
                Response res = response.getResponse();
                resContent.append(" URL: ").append(res.getUrl())
                        .append("\n Status: ").append(res.getStatus())
                        .append("\n Headers: ").append(res.getHeaders())
                        .append("\n Timing:").append(res.getTiming().map(e -> e.getSendEnd()).orElse(null))
                        .append("\n\n");
            });
        });
    }

    private static @NonNull ChromeOptions getChromeOptions() {

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless"); // Disable chrome window
        options.addArguments("--enable-automation");
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--disable-features=InsecureDownloadWarnings");
        options.addArguments("--unsafely-treat-insecure-origin-as-secure=http://demo.cxbox.org/");
        options.addArguments("--unsafely-treat-insecure-origin-as-secure=http://code-samples.cxbox.org/ui/#");
        options.addArguments("--disable-popup-blocking");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--remote-debugging-port=9222");
        options.addArguments("--disable-gpu");
        options.addArguments("--disable-web-security");
        options.addArguments("--disable-notifications");

        LoggingPreferences logPrefs = new LoggingPreferences();
        logPrefs.enable(LogType.BROWSER.toString(), Level.ALL);
        logPrefs.enable(LogType.PERFORMANCE.toString(), Level.ALL);
        options.setCapability("goog:loggingPrefs", logPrefs);

        System.setProperty("chromeoptions.prefs", "credentials_enable_service=false, password_manager_enabled=false");
        return options;
    }

    @AfterEach
    public void printLogs(){
        Allure.step("Print browser logs and response...", step -> {
            logTime(step);
            Logs logs = getWebDriver().manage().logs();
            printLog(logs.get(LogType.BROWSER.toString()));
        });
    }

    @AfterEach
    public void tearDown() {
        Allure.step("Closing the browser window", step -> {
            logTime(step);
            Selenide.closeWebDriver();
        });
    }

    void printLog(LogEntries entries) {
        logger.info("{} log entries found", entries.getAll().size());
        for (LogEntry entry : entries) {
            logger.info("{} {} {}",
                    new Date(entry.getTimestamp()), entry.getLevel(), entry.getMessage()
            );
        }

        StringBuilder logContent = new StringBuilder();
        logContent.append("Log entries found: ").append(entries.getAll().size()).append("\n\n");
        for (LogEntry entry : entries) {
            logContent.append(new Date(entry.getTimestamp()))
                    .append(" ").append(entry.getLevel())
                    .append(" ").append(entry.getMessage())
                    .append("\n\n");
        }
        Allure.addAttachment("Browser Res", resContent.toString());
        Allure.addAttachment("Browser Logs", logContent.toString());
    }



    private String getEnv() {
        String url = System.getenv("APP_URL");
        if (url == null || url.isEmpty()) {
            url = "http://code-samples.cxbox.org/ui/#/";
        }
        return url;
    }
}
