package core.ConfigTest;

import com.browserup.bup.BrowserUpProxy;
import com.browserup.bup.proxy.CaptureType;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.logevents.SelenideLogger;
import core.LoginPage;
import core.WidgetPage;
import io.qameta.allure.Allure;
import io.qameta.allure.junit5.AllureJunit5;
import io.qameta.allure.selenide.AllureSelenide;
import io.qameta.allure.selenide.LogType;
import lombok.NonNull;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.logging.LoggingPreferences;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.EnumSet;
import java.util.logging.Level;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import static core.widget.TestingTools.CellProcessor.logTime;


@ExtendWith({AllureJunit5.class})
@DisplayName("Setup for Samples Tests")
public class BaseTestForSamples {
    public static WidgetPage page;
    private BrowserUpProxy bmp = null;
    private static StringBuilder loginBuilder = new StringBuilder();

    @BeforeAll
    public static void setUpAllure() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide()
                .screenshots(true)
                .savePageSource(true));
    }

    @BeforeEach
    public void setUp() {
        Allure.step("Launching the browser...", step -> {
            logTime(step);
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
            Configuration.proxyEnabled = true;



            Selenide.open(getEnv());

            bmp = WebDriverRunner.getSelenideProxy().getProxy();

            EnumSet<CaptureType> nonBinaryContentCaptureTypes = CaptureType.getNonBinaryContentCaptureTypes();
            nonBinaryContentCaptureTypes.addAll(CaptureType.getHeaderCaptureTypes());

            bmp.setHarCaptureTypes(nonBinaryContentCaptureTypes);
            bmp.enableHarCaptureTypes(nonBinaryContentCaptureTypes);
            bmp.newHar("Proxy start");

            page = new LoginPage().loginKeyCloak("demo", "demo");
            System.out.println("QQQAAAWWWEEERRR");



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
            printLog();
        });
    }

    @AfterEach
    public void tearDown() {
        Allure.step("Closing the browser window", step -> {
            logTime(step);
            Selenide.closeWebDriver();
        });
    }

    @AfterAll
    public static void createZipLog() throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter("logLoginFile"));
        writer.write((loginBuilder.toString()));

        try (
                 FileOutputStream fos = new FileOutputStream("logLoginZip.zip");
                 ZipOutputStream zipOut = new ZipOutputStream(fos)) {
                 ZipEntry zipEntry = new ZipEntry("logLoginFile");
                 zipOut.putNextEntry(zipEntry);
                 Files.copy(Paths.get("logLoginFile"), zipOut);
                 zipOut.closeEntry();
        }
        writer.close();
        Files.delete(Paths.get("logLoginFile"));
        Allure.addAttachment("TestZip", "application/zip", Files.newInputStream(Paths.get("logLoginZip.zip")), ".zip");
    }

    void printLog() {

        StringBuilder stringBuilder = new StringBuilder();
        bmp.getHar().getLog().getEntries().stream().filter(x ->
                (  x.getResponse().getHeaders().stream().anyMatch( y -> ("application/json").equals(y.getValue())) ||
                        x.getRequest().getHeaders().stream().anyMatch( y -> ("application/json").equals(y.getValue())) ) &&
                        !x.getRequest().getUrl().contains("http://code-samples.cxbox.org/api/v1/login")
        ).forEach(x -> {
            stringBuilder.append(x.getStartedDateTime()).append("\n")
                    .append(x.getRequest().getMethod().name()).append("\n")
                    .append(x.getRequest().getUrl()).append("\n")
                    .append("Body: ").append(x.getRequest().getPostData().getText()).append("\n")
                    .append(x.getResponse().getStatus()).append("\n")
                    .append("Content").append(x.getResponse().getContent().getText()).append("\n\n");   //фильтрация. Убирать не content-type:  application/json. Добавить переменную среды для включения фильтрацию
        });

        bmp.getHar().getLog().getEntries().stream().filter( x ->
                (x.getResponse().getHeaders().stream().anyMatch( y -> ("application/json").equals(y.getValue())) ||
                        x.getRequest().getHeaders().stream().anyMatch( y -> ("application/json").equals(y.getValue())) ) &&
                        x.getRequest().getUrl().contains("http://code-samples.cxbox.org/api/v1/login")
        ).forEach(x -> {
            loginBuilder.append(x.getStartedDateTime()).append("\n")
                    .append(x.getRequest().getMethod().name()).append("\n")
                    .append(x.getRequest().getUrl()).append("\n")
                    .append("Body: ").append(x.getRequest().getPostData().getText()).append("\n")
                    .append(x.getResponse().getStatus()).append("\n")
                    .append("Content").append(x.getResponse().getContent().getText()).append("\n\n");
        });


        Allure.addAttachment("Browser network", stringBuilder.toString());
        Allure.addAttachment("Login network", loginBuilder.toString());
    }

    private String getEnv() {
        String url = System.getenv("APP_URL");
        if (url == null || url.isEmpty()) {
            url = "http://code-samples.cxbox.org/ui/#/";
        }
        return url;
    }
}
