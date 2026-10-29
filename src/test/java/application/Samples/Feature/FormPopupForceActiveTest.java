package application.Samples.Feature;

import static io.qameta.allure.SeverityLevel.CRITICAL;
import static org.assertj.core.api.Assertions.assertThat;

import application.config.BaseTestForSamples;
import com.codeborne.selenide.Selenide;
import core.config.selenide.BrowserDevTools;
import core.element.PlatformApp;
import io.qameta.allure.Epic;
import io.qameta.allure.Severity;
import java.time.Duration;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

@DisplayName("FormPopup. Fields stay mounted while forceActive refreshes row meta")
@Epic("application/Samples")
@Tag("application/Samples")
@Tag("FormPopup")
public class FormPopupForceActiveTest extends BaseTestForSamples {

	@Test
	@Severity(CRITICAL)
	@Tag("Positive")
	@DisplayName("The field stays mounted while forceActive refreshes row meta")
	void forceActiveKeepsFieldMounted() {
		PlatformApp.screen("Input basic")
				.secondLevelView("FormPopup")
				.form("Activate FormPopup")
				.actions().click("Activate FormPopup");
		var formPopup = PlatformApp.currentScreen().view().formPopupByName("InputBasicFormPopup");
		var input = formPopup.input("customField");
		var inputElement = input.element().$(input.valueTag()).getWrappedElement();
		long requestsBefore = BrowserDevTools.networkRequests().stream()
				.filter(request -> request.url().contains("/row-meta/"))
				.count();
		BrowserDevTools.delayNetwork(Duration.ofSeconds(10));
		try {
			input.setValue("5700");
			Selenide.Wait().withTimeout(formPopup.getExpectations().getTimeout())
					.until(driver -> BrowserDevTools.networkRequests().stream()
							.filter(request -> request.url().contains("/row-meta/"))
							.count() > requestsBefore);
			assertThat(inputElement.isDisplayed()).isTrue();
		} finally {
			BrowserDevTools.delayNetwork(Duration.ZERO);
		}
		input.checkValue(value -> assertThat(value).isEqualTo("5700"));
		formPopup.clickOk();
	}

}
