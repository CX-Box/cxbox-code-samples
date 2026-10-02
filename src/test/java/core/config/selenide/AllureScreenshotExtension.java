package core.config.selenide;

import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Allure;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.extension.AfterTestExecutionCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.LifecycleMethodExecutionExceptionHandler;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import java.io.ByteArrayInputStream;
import java.util.Set;

@Slf4j
public class AllureScreenshotExtension implements AfterTestExecutionCallback, LifecycleMethodExecutionExceptionHandler {

    private final static Set<Class<? extends Throwable>> SCREENSHOT_EXCEPTION = Set.of(
            AssertionError.class
    );

    @Override
    public void afterTestExecution(ExtensionContext context) {
        context.getExecutionException()
                .filter(ex-> SCREENSHOT_EXCEPTION.stream().anyMatch(th-> th.isInstance(ex)))
                .ifPresent(ex -> takeScreenshot());
    }

    /**
     * A @BeforeEach that fails never reaches afterTestExecution: the test body does not run, so the hook above is not called
     * at all, whatever the exception is. This one is called at the moment of the failure, before the @AfterEach methods
     * (which close the tabs and end the session) have had a chance to change what is on the screen.
     */
    @Override
    public void handleBeforeEachMethodExecutionException(ExtensionContext context, Throwable throwable) throws Throwable {
        takeScreenshot();
        throw throwable;
    }

    private void takeScreenshot() {
        try {
            byte[] screenshot = ((TakesScreenshot) WebDriverRunner.getWebDriver())
                    .getScreenshotAs(OutputType.BYTES);
            // the type and the extension are what makes the report show it as a picture instead of a file to download
            Allure.addAttachment("Screenshot on Failure", "image/png",
                    new ByteArrayInputStream(screenshot), ".png");
        } catch (Exception e) {
            log.error("Failed to make screenshot on failure", e);
        }
    }

}