package core.ConfigTest;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideConfig;
import com.codeborne.selenide.logevents.SelenideLogger;
import core.LoginPage;
import core.WidgetPage;
import io.qameta.allure.Step;
import io.qameta.allure.junit5.AllureJunit5;
import io.qameta.allure.selenide.AllureSelenide;
import lombok.NonNull;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.chrome.ChromeOptions;


@ExtendWith({AllureJunit5.class})
@DisplayName("Setup for Samples Tests")
public class BaseTestForSamples {
    public static WidgetPage page;

    @BeforeEach
    @Step("Launching the browser...")
    public void setUp() {
        SelenideConfig selenideConfig = new SelenideConfig();
        SelenideLogger.addListener("AllureSelenide",
                new AllureSelenide()
                        .includeSelenideSteps(false) // Настройка отключена для исключения из отчета подробных шагов с проверкой локаторов
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

        String url = System.getenv("APP_URL");
        if (url == null || url.isEmpty()) {
            url = "http://localhost:81/ui/#/";
        }

        Selenide.open(url);
        page = new LoginPage().loginKeyCloak("demo", "demo");
    }

    private static @NonNull ChromeOptions getChromeOptions() {

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless"); // Disable chrome window
        options.addArguments("--enable-automation");
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--disable-features=InsecureDownloadWarnings");
        options.addArguments("--unsafely-treat-insecure-origin-as-secure=http://demo.cxbox.org/");
        options.addArguments("--disable-popup-blocking");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--remote-debugging-port=9222");
        options.addArguments("--disable-gpu");
        options.addArguments("--disable-web-security");
        options.addArguments("--disable-notifications");
        System.setProperty("chromeoptions.prefs", "credentials_enable_service=false, password_manager_enabled=false"); // Выключение Проверки пароля хромом
        return options;
    }

    @AfterEach
    @Step("...Closing the browser window")
    public void tearDown() {
        Selenide.closeWebDriver();
    }
}
