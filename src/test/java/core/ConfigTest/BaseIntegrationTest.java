package core.ConfigTest;

import com.codeborne.selenide.FileDownloadMode;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideConfig;
import com.codeborne.selenide.logevents.SelenideLogger;
import core.LoginPage;
import core.WidgetPage;
import io.qameta.allure.Step;
import io.qameta.allure.selenide.AllureSelenide;
import lombok.NonNull;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.openqa.selenium.chrome.ChromeOptions;


@DisplayName("Setup for Demo Tests")
public abstract class BaseIntegrationTest {
    public static WidgetPage page;

    @BeforeAll
    @Step("Launching the browser...")
    public static void setUpAll() {
        SelenideConfig selenideConfig = new SelenideConfig();
        SelenideLogger.addListener("AllureSelenide",
                new AllureSelenide()
                        .includeSelenideSteps(false) // Настройка отключена для исключения из отчета подробных шагов с проверкой локаторов
                        .screenshots(true)
                        .savePageSource(false)
        );
        selenideConfig.browser("chrome")
                .browserVersion("131.0.6778.109")
                .headless(false)
                .fileDownload(FileDownloadMode.FOLDER)
                .timeout(10000)
                .pageLoadTimeout(60000)
                .browserCapabilities(getChromeOptions());

        Selenide.open(System.getProperty("app.url"));
        page = new LoginPage().loginKeyCloak("demo", "demo");
    }

    private static @NonNull ChromeOptions getChromeOptions() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--enable-automation");
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--disable-features=InsecureDownloadWarnings");
        options.addArguments("--unsafely-treat-insecure-origin-as-secure=http://demo.cxbox.org/");
        options.addArguments("--disable-popup-blocking");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--remote-debugging-port=9222");
        options.addArguments("--disable-gpu");
        System.setProperty("chromeoptions.prefs", "credentials_enable_service=false, password_manager_enabled=false"); // Выключение Проверки пароля хромом
        return options;
    }


    @AfterAll
    @Step("...Closing the browser window")
    public static void tearDown() {
        Selenide.closeWebDriver();
    }

}
