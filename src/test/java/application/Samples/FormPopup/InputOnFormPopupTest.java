package application.Samples.FormPopup;

import static io.qameta.allure.SeverityLevel.CRITICAL;
import static org.assertj.core.api.Assertions.assertThat;

import application.config.BaseTestForSamples;
import core.config.Constants;
import core.element.PlatformApp;
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

	@Test
	@Tag("Positive")
	@DisplayName("Test for getting the Placeholder value")
	@Description("The test gets the value from the placeholder attribute in FormPopup")
	void placeholder() {
		var formPopup = PlatformApp.screen("Input placeholder")
				.secondLevelView("FormPopup")
				.form("Activate FormPopup")
				.actions().click("Activate FormPopup")
				.confirmWithWidgetPopup();
		formPopup.input("customField")
				.checkPlaceholder(actualText -> assertThat(actualText).isEqualTo("Placeholder text"));
		formPopup.clickOk();
	}

	@Test
	@Tag("Positive")
	@DisplayName("A test to get the field color value in Hex format")
	void color() {
		PlatformApp.screen("Input color")
				.secondLevelView("FormPopup")
				.form("Activate FormPopup")
				.actions().click("Activate FormPopup");
		var formPopup = PlatformApp.currentScreen().view().formPopup("FormPopup");
		formPopup.input("customField")
				.checkColor(actualColor -> assertThat(actualColor).isNull());
		formPopup.clickOk();
	}

	@Test
	@Tag("Positive")
	@DisplayName("A test to check the field for \"Read-only\"")
	void readonly() {
		var formPopup = PlatformApp.screen("Input readonly")
				.secondLevelView("FormPopup")
				.form("Activate FormPopup")
				.actions().click("Activate FormPopup")
				.confirmWithWidgetPopup();
		formPopup.input("customField")
				.checkReadOnly(ro -> assertThat(ro).isTrue());
		formPopup.clickOk();
	}

	@Test
	@Severity(CRITICAL)
	@Tag("Positive")
	@DisplayName("A test for setting a value in a field")
	void edit() {
		PlatformApp.screen("Input basic")
				.secondLevelView("FormPopup")
				.form("Activate FormPopup")
				.actions().click("Activate FormPopup");
		var formPopup = PlatformApp.currentScreen().view().formPopupByName("InputBasicFormPopup");
		formPopup.input("customField")
				.setValue("5700")
				.checkValue(value -> assertThat(value).isEqualTo("5700"))
				.setValue("200")
				.checkValue(value -> assertThat(value).isEqualTo("200"));
		formPopup.clickOk();
	}

	@Test
	@Severity(CRITICAL)
	@Tag("Negative")
	@DisplayName("Business Exception Validation Test")
	void businessException() {
		var form = PlatformApp.screen("Input validation business exception")
				.secondLevelView("FormPopup")
				.form("Activate FormPopup");
		var formPopup = form.actions().click("Activate FormPopup").confirmWithWidgetPopup();
		formPopup.expectErrorPopup(() -> {
					formPopup.input("customField").setValue("5700");
					formPopup.clickOk();
				})
				.checkTitleAndMessage(
						title -> assertThat(title).isEqualTo(Constants.ErrorPopup.TITLE),
						message -> assertThat(message).isEqualTo(Constants.OnlyLetters))
				.close();
	}

	@Test
	@Severity(CRITICAL)
	@Tag("Negative")
	@DisplayName("Run-time exception validation test")
	void runtimeException() {
		var form = PlatformApp.screen("Input validation runtime exception")
				.secondLevelView("FormPopup")
				.form("Activate FormPopup");
		var formPopup = form.actions().click("Activate FormPopup").confirmWithWidgetPopup();
		formPopup.expectErrorPopup(() -> {
					formPopup.input("customField").setValue("1234");
					formPopup.clickOk();
				})
				.checkTitleAndMessage(
						title -> assertThat(title).isEqualTo(Constants.ErrorPopup.TITLE),
						message -> assertThat(message).isEqualTo(Constants.SystemError))
				.close();
	}

	@Test
	@Severity(CRITICAL)
	@Tag("Positive")
	@DisplayName("Confirmation Popup Validation Test")
	void confirm() {
		var formPopup = PlatformApp.screen("Input basic")
				.secondLevelView("FormPopup")
				.form("Activate FormPopup")
				.actions().click("Activate FormPopup")
				.confirmWithWidgetPopup();
		formPopup.input("customField").setValue("5700");
		formPopup.checkTitle(title -> assertThat(title).isEqualTo("CustomTitleText"))
				.checkOkText(text -> assertThat(text).isEqualTo("CustomYesText"))
				.checkCancelText(text -> assertThat(text).isEqualTo("CustomNoText"))
				.clickOk();
	}

	@Test
	@Tag("Positive")
	@DisplayName("A window without a title")
	@Description("The pre action and the widget have no title: the window is found by the widget of the action, its title is empty")
	void noTitle() {
		var formPopup = PlatformApp.screen("Input basic")
				.secondLevelView("FormPopup")
				.form("Activate FormPopup")
				.actions().click("Activate FormPopup without title")
				.confirmWithWidgetPopup();
		formPopup.checkTitle(title -> assertThat(title).isEmpty());
		formPopup.input("customField").setValue("5700");
		formPopup.clickOk();
	}

	@Test
	@Severity(CRITICAL)
	@Tag("Negative")
	@DisplayName("Required Message validation test for one field")
	void fieldLevelValidationAnnotation() {
		var formPopup = PlatformApp.screen("Input validation field level annotation")
				.secondLevelView("FormPopup")
				.form("Activate FormPopup")
				.actions().click("Activate FormPopup")
				.confirmWithWidgetPopup();
		var input = formPopup.input("Custom Field");
		input.setValue("123");
		formPopup.clickOk();
		input.checkRequired(rt -> assertThat(rt).isEqualTo(Constants.OnlyLetters));
	}

	@Test
	@Severity(CRITICAL)
	@Tag("Negative")
	@DisplayName("Required Message text Verification field test")
	void required() {
		var formPopup = PlatformApp.screen("Input required")
				.secondLevelView("FormPopup")
				.form("Activate FormPopup")
				.actions().click("Activate FormPopup")
				.confirmWithWidgetPopup();
		var input = formPopup.input("customField");
		input.clear();
		formPopup.clickOk();
		input.checkRequired(rt -> assertThat(rt).isEqualTo(Constants.RequiredMessage));
	}

}
