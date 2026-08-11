package application.Samples.FormPopup;

import static io.qameta.allure.SeverityLevel.CRITICAL;
import static org.assertj.core.api.Assertions.assertThat;

import application.config.BaseTestForSamples;
import core.config.Constants;
import core.element.PlatformApp;
import core.element.widget.form.PlatformFormWidget;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Severity;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

@DisplayName("FormPopup. Checking the basic functions for the Input in the widget FormPopup")
@Epic("application/Samples")
@Tag("application/Samples")
@Tag("FormPopup")
public class InputOnFormPopupTest extends BaseTestForSamples {

	private static PlatformFormWidget activateFormPopupByScreen(String screenName) {
		return PlatformApp.screen(screenName)
				.secondLevelView("FormPopup")
				.form("Activate FormPopup")
				.actions()
				.action("Activate FormPopup")
				.click();
	}

	@Test
	@Tag("Positive")
	@DisplayName("Test for getting the Placeholder value")
	@Description("The test gets the value from the placeholder attribute in FormPopup")
	void placeholder() {
		var clicked = activateFormPopupByScreen("Input placeholder");
		var formPopup = PlatformApp.currentScreen().view().formPopup();

		formPopup.input("customField")
				.checkPlaceholder(actualText -> assertThat(actualText).isEqualTo("Placeholder text"));

		clicked.confirmWithWidgetPopup(formPopup).click("CustomYesText");
	}

	@Test
	@Tag("Positive")
	@DisplayName("A test to get the field color value in Hex format")
	void color() {
		var clicked = activateFormPopupByScreen("Input color");
		var formPopup = PlatformApp.currentScreen().view().formPopup();

		formPopup.input("customField")
				.checkColor(actualColor -> assertThat(actualColor).isNull());

		clicked.confirmWithWidgetPopup(formPopup).click("CustomYesText");
	}

	@Test
	@Tag("Positive")
	@DisplayName("A test to check the field for \"Read-only\"")
	void readonly() {
		var clicked = activateFormPopupByScreen("Input readonly");
		var formPopup = PlatformApp.currentScreen().view().formPopup();

		formPopup.input("customField")
				.checkReadOnly(ro -> assertThat(ro).isTrue());

		clicked.confirmWithWidgetPopup(formPopup).click("CustomYesText");
	}

	@Test
	@Severity(CRITICAL)
	@Tag("Positive")
	@DisplayName("A test for setting a value in a field")
	void edit() {
		var clicked = activateFormPopupByScreen("Input basic");
		var formPopup = PlatformApp.currentScreen().view().formPopup();

		var input = formPopup.input("customField");
		input.setValue("5700")
				.checkValue(value -> assertThat(value).isEqualTo("5700"))
				.setValue("200")
				.checkValue(value -> assertThat(value).isEqualTo("200"));

		clicked.confirmWithWidgetPopup(formPopup).click("CustomYesText");
	}

	@Test
	@Severity(CRITICAL)
	@Tag("Negative")
	@DisplayName("Business Exception Validation Test")
	void businessException() {
		var clicked = activateFormPopupByScreen("Input validation business exception");
		var formPopup = PlatformApp.currentScreen().view().formPopup();

		var input = formPopup.input("customField");
		input.setValue("5700");
		clicked.errorPopup()
				.checkTitle(title -> assertThat(title).isEqualTo(Constants.ErrorPopup.TITLE))
				.checkMessage(message -> assertThat(message).isEqualTo(Constants.OnlyLetters))
				.close();

		clicked.confirmWithWidgetPopup(formPopup).click("CustomYesText");
	}

	@Test
	@Severity(CRITICAL)
	@Tag("Negative")
	@DisplayName("Run-time exception validation test")
	void runtimeException() {
		var clicked = activateFormPopupByScreen("Input validation runtime exception");
		var formPopup = PlatformApp.currentScreen().view().formPopup();

		var input = formPopup.input("customField");
		input.setValue("1234");
		clicked.errorPopup()
				.checkTitle(title -> assertThat(title).isEqualTo(Constants.ErrorPopup.TITLE))
				.checkMessage(message -> assertThat(message).isEqualTo(Constants.SystemError))
				.close();
		clicked
				.confirmWithWidgetPopup(formPopup)
				.click("CustomYesText");
	}

	@Test
	@Severity(CRITICAL)
	@Tag("Positive")
	@DisplayName("Confirmation Popup Validation Test")
	void confirm() {
		var clicked = activateFormPopupByScreen("Input basic");
		var formPopup = PlatformApp.currentScreen().view().formPopup();

		var input = formPopup.input("customField");
		input.setValue("5700");

		clicked.confirmWithWidgetPopup(formPopup)
				.checkTitle(title -> assertThat(title).isEqualTo("CustomTitleText"))
				.click("CustomYesText");
	}

	@Test
	@Severity(CRITICAL)
	@Tag("Negative")
	@DisplayName("Required Message validation test for one field")
	void fieldLevelValidationAnnotation() {
		var clicked = activateFormPopupByScreen("Input validation field level annotation");
		var formPopup = PlatformApp.currentScreen().view().formPopup();

		var input = formPopup.input("Custom Field");
		input.setValue("123");

		clicked.confirmWithWidgetPopup(formPopup).click("CustomYesText");
		input.checkRequired(rt -> assertThat(rt).isEqualTo(Constants.OnlyLetters));
	}

	@Test
	@Severity(CRITICAL)
	@Tag("Negative")
	@DisplayName("Required Message text Verification field test")
	void required() {
		var clicked = activateFormPopupByScreen("Input required");
		var formPopup = PlatformApp.currentScreen().view().formPopup();

		var input = formPopup.input("customField");
		input.clear();

		clicked.confirmWithWidgetPopup(formPopup).click("CustomYesText");
		input.checkRequired(rt -> assertThat(rt).isEqualTo(Constants.RequiredMessage));
	}

}