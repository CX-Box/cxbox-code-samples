package core.ConfigTest;

import com.browserup.bup.BrowserUpProxy;
import com.browserup.bup.proxy.CaptureType;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.logevents.SelenideLogger;
import core.LoginPage;
import core.WidgetPage;
import core.widget.TestingTools.TestStatusExtension;
import de.sstoehr.harreader.model.HarEntry;
import io.qameta.allure.Allure;
import io.qameta.allure.junit5.AllureJunit5;
import io.qameta.allure.selenide.AllureSelenide;
import io.qameta.allure.selenide.LogType;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LoggingPreferences;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Date;
import java.util.EnumSet;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.logging.Level;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import org.openqa.selenium.logging.Logs;
import org.selenide.videorecorder.junit5.VideoRecorderExtension;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static core.widget.TestingTools.CellProcessor.logTime;


@ExtendWith({AllureJunit5.class})
@DisplayName("Setup for Samples Tests")
@ExtendWith({VideoRecorderExtension.class, TestStatusExtension.class})
@Slf4j
public class BaseTestForSamples {
    public static WidgetPage page;
    private BrowserUpProxy bmp = null;
    private static final ConcurrentLinkedQueue<String>  loginLog = new ConcurrentLinkedQueue<>();


    @BeforeAll
    public static void setUpAllure() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide()
                        .includeSelenideSteps(false)
                .screenshots(true)
                .savePageSource(true));
    }

    @BeforeEach
    public void setUp() {
        Allure.step("Launching the browser...", step -> {
            logTime(step);
            Configuration.browser = "chrome";
            Configuration.headless = false;
            Configuration.timeout = 10000;
            Configuration.browserSize = "1280x800";
            Configuration.pageLoadTimeout = 60000;
            Configuration.browserCapabilities = getChromeOptions();
            Configuration.webdriverLogsEnabled = false;
            Configuration.reportsFolder = "target/videos";
            Configuration.proxyEnabled = true;

            log.info(getUrlEnv());
            Selenide.open(getUrlEnv());

            if (getLogEnv()) {
                bmp = WebDriverRunner.getSelenideProxy().getProxy();


                EnumSet<CaptureType> nonBinaryContentCaptureTypes = CaptureType.getNonBinaryContentCaptureTypes();
                nonBinaryContentCaptureTypes.addAll(CaptureType.getHeaderCaptureTypes());

                bmp.setHarCaptureTypes(nonBinaryContentCaptureTypes);
                bmp.enableHarCaptureTypes(nonBinaryContentCaptureTypes);
                Selenide.sleep(2000);
                bmp.newHar("Proxy start");
            }

            page = new LoginPage().loginKeyCloak("demo", "demo");
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
        //options.addArguments("--remote-debugging-port=9222");
        options.addArguments("--disable-gpu");
        options.addArguments("--disable-web-security");
        options.addArguments("--disable-notifications");
        options.setAcceptInsecureCerts(true);

        if (getLogEnv()) {
            LoggingPreferences logPrefs = new LoggingPreferences();
            logPrefs.enable(LogType.BROWSER.toString(), Level.ALL);
            logPrefs.enable(LogType.PERFORMANCE.toString(), Level.ALL);
            options.setCapability("goog:loggingPrefs", logPrefs);
        }


        System.setProperty("chromeoptions.prefs", "credentials_enable_service=false, password_manager_enabled=false");
        return options;
    }

    @AfterEach
    public void printLogs(){
        if (getLogEnv()) {
            Allure.step("Print browser logs and response...", step -> {
                logTime(step);

                Logs logs = getWebDriver().manage().logs();
                printConsoleLog(logs.get(LogType.BROWSER.toString()));
                printNetworkLog();

                Path logFile = Paths.get("logLoginFile");

                try (BufferedWriter writer = Files.newBufferedWriter(logFile, StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING)) {
                    writer.append(loginLog.toString());
                    createZipLog();
                    loginLog.clear();
                } catch (IOException e) {
                    log.error("Error writing log file ", e);
                }
            });
        }
    }

    @AfterEach
    public void tearDown() {
        Allure.step("Closing the browser window", step -> {
            logTime(step);
            Selenide.closeWebDriver();
        });
    }


    public void createZipLog() throws IOException {
        if (getLogEnv()) {
            Path logFile = Paths.get("logLoginFile");
            Path zipFile = Paths.get("logLoginZip.zip");


            try (ZipOutputStream zipOut = new ZipOutputStream(new FileOutputStream(zipFile.toFile()))) {
                zipOut.putNextEntry(new ZipEntry("logLoginFile"));
                Files.copy(logFile, zipOut);
                zipOut.closeEntry();
            }

            Files.delete(logFile);
            Allure.addAttachment("Login network logs", "application/zip", Files.newInputStream(zipFile), ".zip");
            Files.delete(zipFile);
        }
    }

    void printNetworkLog() {
        StringBuilder stringBuilder = new StringBuilder();
        bmp.getHar().getLog().getEntries().stream().filter(x ->
                (  x.getResponse().getHeaders().stream().anyMatch( y -> ("application/json").equals(y.getValue())) ||
                        x.getRequest().getHeaders().stream().anyMatch( y -> ("application/json").equals(y.getValue())) ) &&
                        !x.getRequest().getUrl().contains(getUrlEnv().replace("/ui/#/", "")+"/api/v1/login")
        ).forEach(x -> stringBuilder.append(printNetworkLog(x)));

        bmp.getHar().getLog().getEntries().stream().filter( x ->
                (x.getResponse().getHeaders().stream().anyMatch( y -> ("application/json").equals(y.getValue())) ||
                        x.getRequest().getHeaders().stream().anyMatch( y -> ("application/json").equals(y.getValue())) ) &&
                        x.getRequest().getUrl().contains(getUrlEnv().replace("/ui/#/", "")+"/api/v1/login")
        ).forEach(x -> loginLog.add(printNetworkLog(x)));

        Allure.addAttachment("Browser network", stringBuilder.toString());
    }

    void printConsoleLog(LogEntries entries) {
        log.info("{} log entries found", entries.getAll().size());
        for (LogEntry entry : entries) {
            log.info("{} {} {}",
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

        Allure.addAttachment("Browser Logs", logContent.toString());
    }

    private String getUrlEnv() {
        String url = System.getenv("APP_URL");
        if (url == null || url.isEmpty()) {
            url = "http://code-samples.cxbox.org/ui/#/";
        }
        return url;
    }

    private static boolean getLogEnv() {
        String recorder = System.getenv("CXBOX_LOGGER");
        return recorder != null && recorder.equalsIgnoreCase("true");
    }

    private static String printNetworkLog(HarEntry entry) {
        return entry.getStartedDateTime() + "\n" +
                entry.getRequest().getMethod().name() + "\n" +
                entry.getRequest().getUrl() + "\n" +
                "Request: " + entry.getRequest().getPostData().getText() + "\n" +
                entry.getResponse().getStatus() + "\n" +
                "Response: " + entry.getResponse().getContent().getText() + "\n\n";
    }
}
