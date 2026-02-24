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

@DisplayName("Form. Checking the basic functions for the Text in the widget Form")
@Epic("application/Samples")
@Tag("application/Samples")
@Tag("Form")
public class TextOnFormTest extends BaseTestForSamples {

	@Disabled
	@Test
	@Severity(MINOR)
	@Tag("Negative")
	@DisplayName("Filtering test")
	@Description("Filtering is not available for the Form widget")
	void filtration() {
//        var form = PlatformApp.screen("Text filtration")
//              .secondLevelView("Form")
//              .form("Form title");
//        var customField = form.text("Custom Field");
//        assertThatThrownBy(customField::setFiltration).isInstanceOf(UnsupportedOperationException.class);
	}

	@Disabled
	@Test
	@Tag("Positive")
	@DisplayName("The DrillDown test")
	@Description("Checking the url before the transition and after the transition/click on a special element")
	void drillDown() {
//        var form = PlatformApp.screen("Text drilldown")
//              .secondLevelView("Form")
//              .form("Form title");
//        var customField = form.text("Custom Field");
//        assertThatThrownBy(customField::drillDown).isInstanceOf(UnsupportedOperationException.class);
	}

	@Disabled
	@Test
	@Severity(MINOR)
	@Tag("Negative")
	@DisplayName("Sorting test")
	@Description("Sorting is not available for the Form widget")
	void sorting() {
//        var form = PlatformApp.screen("Text sorting")
//              .secondLevelView("Form")
//              .form("Form title");
//        var customField = form.text("Custom Field");
//        assertThatThrownBy(customField::setSorting).isInstanceOf(UnsupportedOperationException.class);
	}

	@Test
	@Tag("Positive")
	@DisplayName("Test for getting the Placeholder value")
	@Description("The test gets the value from the placeholder attribute and returns it in String format")
	void placeholder() {
		var form = PlatformApp.screen("Text placeholder")
				.secondLevelView("Form")
				.form("Form title");
		form.text("Custom Field")
				.checkPlaceholder(pl -> assertThat(pl).isEqualTo("Placeholder text"));
	}

	@Test
	@Tag("Positive")
	@DisplayName("A test to get the field color value in Hex format")
	@Description("The test gets the value from the style attribute in RGB format, and then converts it to Hex format")
	void color() {
		var form = PlatformApp.screen("Text color")
				.secondLevelView("Form")
				.form("Form title");
		form.text("Custom Field")
				.checkColor(color -> assertThat(color).isNull());
	}

	@Test
	@Tag("Positive")
	@DisplayName("A test to check the field for \"Read-only\"")
	@Description("The test checks for the disabled attribute")
	void readonly() {
		var form = PlatformApp.screen("Text readonly")
				.secondLevelView("Form")
				.form("Form title");
		form.text("Custom Field")
				.checkReadOnly(ro -> assertThat(ro).isTrue());
	}

	@Test
	@Severity(CRITICAL)
	@Tag("Positive")
	@DisplayName("A test for setting a value in a field")
	@Description("The test sets the value in the field, and then checks the value in the field with what should be set")
	void edit() {
		var form = PlatformApp.screen("Text basic")
				.secondLevelView("Form")
				.form("Form title");
		form.text("Custom Field")
				.setValue("Text")
				.checkValue(value -> assertThat(value).isEqualTo("Text"));
		form.text("Custom Field").setValue("Unlike a digital typeface, a metal font would not include a single definition of each character, but commonly used characters (such as vowels and periods) would have more physical type-pieces included.");
	}

	@Test
	@Severity(CRITICAL)
	@Tag("Negative")
	@DisplayName("Business Exception Validation Test")
	@Description("The test sets the value in the field. After approval, the popup window, the title, the text in it, and the buttons are validated")
	void businessException() {
		var form = PlatformApp.screen("Text validation business exception")
				.secondLevelView("Form")
				.form("Form title");
		form.text("Custom Field").setValue("1234");
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
		var form = PlatformApp.screen("Text validation runtime exception")
				.secondLevelView("Form")
				.form("Form title");
		form.text("Custom Field").setValue("Test");
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
		var form = PlatformApp.screen("Text validation confirm")
				.secondLevelView("Form")
				.form("Form title");
		form.text("Custom Field").setValue("Test");
		form.actions().action("save").click();
		form.confirmPopup()
				.checkTitleAndMessage(
						title -> assertThat(title).isEqualTo(Constants.ConfirmPopup.TITLE),
						message -> assertThat(message).isEqualTo(Constants.SaveValue))
				.clickOk();
		form.text("Custom Field").setValue("Unlike a digital typeface, a metal font would not include a single definition of each character, but commonly used characters (such as vowels and periods) would have more physical type-pieces included.");
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
		var form = PlatformApp.screen("Text validation field level annotation")
				.secondLevelView("Form")
				.form("Form title");
		form.text("Custom Field").setValue("123");
		form.actions().action("Save").click();
		form.text("Custom Field")
				.checkRequired(message -> assertThat(message).isEqualTo(Constants.OnlyLetters));
	}

	@Test
	@Severity(CRITICAL)
	@Tag("Negative")
	@DisplayName("Required Message validation test for multiple fields")
	@Description("The test sets a value with the wrong data type in several fields for different widgets. After approval, it checks the text under the field, which informs about the correctness of the type of data entered")
	void fieldLevelValidation() {
		var form = PlatformApp.screen("Text validation field level dynamic")
				.secondLevelView("Form")
				.form("Form title");
		var customField = form.text("Custom Field");
		var customFieldAdditional = form.text("Custom FieldAdditional");
		customField.setValue("123");
		customFieldAdditional.setValue("123");
		form.actions().action("Save").click();
		customField.checkRequired(message -> assertThat(message).isEqualTo(Text.textOnlyLetters("customField")));
		customFieldAdditional.checkRequired(message -> assertThat(message).isEqualTo(Text.textOnlyLetters("customFieldAdditional")));
	}

	@Test
	@Severity(CRITICAL)
	@Tag("Negative")
	@DisplayName("Required Message text Verification field test")
	@Description("The test clears the field and clicks the Save button. Then validates the message that the field is required")
	void required() {
		var form = PlatformApp.screen("Text required")
				.secondLevelView("Form")
				.form("Form title");
		form.text("Custom Field").clear();
		form.actions().action("Save").click();
		form.text("Custom Field")
				.checkRequired(message -> assertThat(message).isEqualTo(Constants.RequiredMessage));
	}
}
