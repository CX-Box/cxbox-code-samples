package application.Samples.Form;

import application.common.Text;
import application.config.BaseTestForSamples;
import core.config.Constants;
import core.element.PlatformApp;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Severity;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.SeverityLevel.CRITICAL;
import static io.qameta.allure.SeverityLevel.MINOR;
import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("Form. Checking the basic functions for the InlinePickList in the widget Form")
@Epic("application/Samples")
@Tag("application/Samples")
@Tag("Form")
public class InlinePickListOnFormTest extends BaseTestForSamples {

	@Test
	@Tag("Positive")
	@DisplayName("Test for getting the Placeholder value")
	@Description("The test gets the value from the placeholder attribute and returns it in String format")
	void placeholder() {
		var form = PlatformApp
				.screen("InlinePickList placeholder")
				.secondLevelView("Form")
				.form("Form title");
		form.inlinePickList("Custom Field")
				.checkPlaceholder(pl -> assertThat(pl).isEqualTo("Placeholder text"));
	}

	@Test
	@Tag("Positive")
	@DisplayName("A test to get the field color value in Hex format")
	@Description("The test gets the value from the style attribute in RGB format, and then converts it to Hex format")
	void color() {
		var form = PlatformApp
				.screen("InlinePickList color")
				.secondLevelView("Form")
				.form("Form title");
		form.inlinePickList("Custom Field")
				.checkColor(color -> assertThat(color).isNull());
	}

	@Test
	@Tag("Positive")
	@DisplayName("A test to check the field for \"Read-only\"")
	@Description("The test checks for the disabled attribute")
	void readonly() {
		var form = PlatformApp
				.screen("InlinePickList readonly")
				.secondLevelView("Form")
				.form("Form title");
		form.inlinePickList("Custom Field")
				.checkReadOnly(readonly -> assertThat(readonly).isTrue());
	}

	@Test
	@Severity(CRITICAL)
	@Tag("Positive")
	@DisplayName("A test for setting a value in a field")
	@Description("The test sets the value in the field, and then checks the value in the field with what should be set")
	void edit() {
		var form = PlatformApp.screen("InlinePickList basic")
				.secondLevelView("Form")
				.form("Form title");
		var inlinePickList = form.inlinePickList("Custom Field");
		inlinePickList.setValue("39 Test data new information")
				.checkValue(val -> assertThat(val).isEqualTo("39 Test data new information"));
	}

	@Disabled
	@Test
	@Severity(MINOR)
	@Tag("Negative")
	@DisplayName("Filtering test")
	@Description("Filtering is not available for the Form widget")
	void filtration() {
	}

	@Disabled
	@Test
	@Tag("Positive")
	@DisplayName("The DrillDown test")
	@Description("Checking the url before the transition and after the transition/click on a special element")
	void drillDown() {
	}

	@Test
	@Severity(CRITICAL)
	@Tag("Negative")
	@DisplayName("Business Exception Validation Test")
	@Description("The test sets the value in the field. After approval, the popup window, the title, the text in it, and the buttons are validated")
	void businessException() {
		var form = PlatformApp.screen("InlinePickList validation business exception")
				.secondLevelView("Form")
				.form("Form title");
		var inlinePickList = form.inlinePickList("Custom Field");
		inlinePickList.setValue("Test data");
		form.errorPopup()
				.checkTitleAndMessage(
						title -> assertThat(title).isEqualTo(Constants.ErrorPopup.TITLE),
						message -> assertThat(message).isEqualTo(Constants.OnlyLetters))
				.close();
	}

	@Test
	@Severity(CRITICAL)
	@Tag("Negative")
	@DisplayName("Run-time exception validation test")
	@Description("The test sets the value in the field. After approval, the popup window, the title, the text in it, and the buttons are validated")
	void runtimeException() {
		var form = PlatformApp.screen("InlinePickList validation runtime exception")
				.secondLevelView("Form")
				.form("Form title");
		var inlinePickList = form.inlinePickList("Custom Field");
		inlinePickList.clear();
		form.errorPopup()
				.checkTitleAndMessage(
						title -> assertThat(title).isEqualTo(Constants.ErrorPopup.TITLE),
						message -> assertThat(message).isEqualTo(Constants.SystemError))
				.close();
	}

	@Test
	@Severity(CRITICAL)
	@Tag("Positive")
	@DisplayName("Confirmation Popup Validation Test")
	@Description("The test sets the value in the field. After approval, by clicking on the save button, the popup window, the title, the text in it, and the buttons are validated")
	void confirm() {
		var form = PlatformApp.screen("InlinePickList validation confirm")
				.secondLevelView("Form")
				.form("Form title");
		var inlinePickList = form.inlinePickList("Custom Field");
		inlinePickList.setValue("Test data");
		form.actions().action("save").click();
		form.confirmPopup()
				.checkTitleAndMessage(
						title -> assertThat(title).isEqualTo(Constants.ConfirmPopup.TITLE),
						message -> assertThat(message).isEqualTo(Constants.SaveValue))
				.clickOk();
	}

	@Test
	@Severity(CRITICAL)
	@Tag("Negative")
	@DisplayName("Required Message validation test for one field")
	@Description("The test sets the value with the wrong data type in the field. After approval, it checks the text under the field, which informs about the correctness of the type of data entered")
	void fieldLevelValidationAnnotation() {
		var form = PlatformApp.screen("InlinePickList validation field level annotation")
				.secondLevelView("Form")
				.form("Form title");
		var inlinePickList = form.inlinePickList("Custom Field");
		inlinePickList.setValue("Test123 data");
		form.actions().action("Save").click();
		inlinePickList.checkRequired(rm -> assertThat(rm).isEqualTo(Constants.OnlyLetters));
	}

	@Test
	@Severity(CRITICAL)
	@Tag("Negative")
	@DisplayName("Required Message validation test for multiple fields")
	@Description("The test sets a value with the wrong data type in several fields for different widgets. After approval, it checks the text under the field, which informs about the correctness of the type of data entered")
	void fieldLevelValidation() {
		var form = PlatformApp.screen("InlinePickList validation field level dynamic")
				.secondLevelView("Form")
				.form("Form title");
		var customField = form.inlinePickList("Custom Field");
		var customFieldAdditional = form.inlinePickList("Custom Field Additional");
		customField.setValue("Test data 123");
		customFieldAdditional.setValue("Test data 123");
		form.actions().action("Save").click();
		customField.checkRequired(rm -> assertThat(rm).isEqualTo(Text.textOnlyLetters("customField")));
		customFieldAdditional.checkRequired(rm -> assertThat(rm).isEqualTo(Text.textOnlyLetters("customFieldAdditional")));
	}

	@Disabled
	@Test
	@Severity(MINOR)
	@Tag("Negative")
	@DisplayName("Sorting test")
	@Description("Sorting is not available for the Form widget")
	void sorting() {
	}

	@Test
	@Severity(CRITICAL)
	@Tag("Negative")
	@DisplayName("Required Message text Verification field test")
	@Description("The test clears the field and clicks the Save button. Then validates the message that the field is required")
	void required() {
		var form = PlatformApp.screen("InlinePickList required")
				.secondLevelView("Form")
				.form("Form title");
		form.inlinePickList("Custom Field")
				.clear()
				.checkRequired(message -> assertThat(message).isEqualTo(Constants.RequiredMessage));
	}

	@Disabled("Remake")
	@Test
	@Severity(MINOR)
	@Tag("Positive")
	@DisplayName("Character Matching test")
	@Description("The test sets the characters in the field, and then returns a list of values that match or contain characters")
	void valuesInList() {
//		var form = PlatformApp.screen("InlinePickList basic")
//				.secondLevelView("Form")
//				.form("Form title");
//		assertThat(form.inlinePickList("Custom Field")
//				.setValue(" ")
//				.getOptions("1").get(0))
//				.isEqualTo("49 Test data new information");
//		assertThat(form.inlinePickList("Custom Field")
//				.setValue(" ")
//				.getOptions("2").get(0))
//				.isEqualTo("42 Test data new information");
	}
}
