package core.config.selenide;

import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Allure;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.extension.AfterTestExecutionCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import java.io.ByteArrayInputStream;
import java.util.Set;

@Slf4j
public class AllureScreenshotExtension implements AfterTestExecutionCallback {

    private final static Set<Class<? extends Throwable>> SCREENSHOT_EXCEPTION = Set.of(
            AssertionError.class
    );

    @Override
    public void afterTestExecution(ExtensionContext context) {
        context.getExecutionException()
                .filter(ex-> SCREENSHOT_EXCEPTION.stream().anyMatch(th-> th.isInstance(ex)))
                .ifPresent(ex -> {
                    try {
                        byte[] screenshot = ((TakesScreenshot) WebDriverRunner.getWebDriver())
                                .getScreenshotAs(OutputType.BYTES);
                        Allure.addAttachment("Screenshot on Failure",
                                new ByteArrayInputStream(screenshot));
                    } catch (Exception e) {
                        log.error("Failed to make screenshot on failure", e);
                    }
                });
    }

}