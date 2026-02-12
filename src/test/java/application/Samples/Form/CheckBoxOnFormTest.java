package application.Samples.Form;

import application.common.Text;
import application.config.BaseTestForSamples;
import core.config.Constants;
import core.element.PlatformApp;
import core.element.widget.form.PlatformFormWidget;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Severity;
import io.qameta.allure.Story;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.SeverityLevel.CRITICAL;
import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("Form. Checking the basic functions for the CheckBox")
@Epic("application/Samples")
@Story("Form")
@Tag("application/Samples")
@Tag("Form")
@Slf4j
public class CheckBoxOnFormTest extends BaseTestForSamples {

	@Test
	@Tag("Positive")
	@DisplayName("Test for getting the Placeholder value")
	@Description("The test gets the value from the placeholder attribute and returns it in String format")
	void placeholder() {
		var form = PlatformApp
				.screen("Checkbox placeholder")
				.secondLevelView("Form")
				.form("Form title");
		form.checkbox("Custom Field")
				.checkPlaceholder(act -> assertThat(act).isEmpty());
	}

	@Test
	@Tag("Positive")
	@DisplayName("A test to get the field color value in Hex format")
	@Description("The test gets the value from the style attribute in RGB format, and then converts it to Hex format")
	void color() {
		var form = PlatformApp
				.screen("Checkbox color")
				.secondLevelView("Form")
				.form("Form title");
		form.checkbox("Custom Field")
				.checkColor(act -> assertThat(act).isNull());
	}

	@Test
	@Tag("Positive")
	@DisplayName("A test to check the field for \"Read-only\"")
	@Description("The test checks for the disabled attribute")
	void readonly() {
		var form = PlatformApp
				.screen("Checkbox readonly")
				.secondLevelView("Form")
				.form("Form title");
		form
				.checkbox("Custom Field")
				.checkReadOnly(act -> assertThat(act).isTrue());
	}

	@Test
	@Severity(CRITICAL)
	@Tag("Positive")
	@DisplayName("A test for setting a value in a field")
	@Description("The test sets the value in the field, and then checks the value in the field with what should be set")
	void edit() {
		var form = PlatformApp.screen("Checkbox basic")
				.secondLevelView("Form")
				.form("Form title");
		var checkbox = form.checkbox("Custom Field");
		checkbox.checkValue(act -> assertThat(act).isTrue());
		checkbox.setValue(false)
				.checkValue(act -> assertThat(act).isFalse());
	}

	@Test
	@Severity(CRITICAL)
	@Tag("Negative")
	@DisplayName("Business Exception Validation Test")
	@Description("The test sets the value in the field. After approval, the popup window, the title, the text in it, and the buttons are validated")
	void businessException() {
		var form = PlatformApp.screen("Checkbox validation business exception")
				.secondLevelView("Form")
				.form("Form title");
		var checkbox = form.checkbox("Custom Field");
		checkbox.checkValue(act -> assertThat(act).isFalse());
		checkbox.setValue(true).setValue(false);
		form.errorPopup()
				.checkTitleAndMessage(
						title -> assertThat(title).isEqualTo(Constants.ErrorPopup.TITLE),
						message -> assertThat(message).isEqualTo("The field can contain only 'True'"))
				.close();
		form.checkbox("Custom Field")
				.checkValue(act -> assertThat(act).isFalse());

	}

	@Test
	@Severity(CRITICAL)
	@Tag("Negative")
	@DisplayName("Run-time exception validation test")
	@Description("The test sets the value in the field. After approval, the popup window, the title, the text in it, and the buttons are validated")
	void runtimeException() {
		var form = PlatformApp.screen("Checkbox validation runtime exception")
				.secondLevelView("Form")
				.form("Form title");
		var checkbox = form.checkbox("Custom Field");
		checkbox.setValue(true);
		form.errorPopup()
				.checkTitleAndMessage(title -> assertThat(title).isEqualTo(Constants.ErrorPopup.TITLE),
						message -> assertThat(message).isEqualTo(Constants.SystemError))
				.close();
		checkbox.checkValue(act -> assertThat(act).isFalse());
	}

	@Test
	@Severity(CRITICAL)
	@Tag("Positive")
	@DisplayName("Confirmation Popup Validation Test")
	@Description("The test sets the value in the field. After approval, by clicking on the save button, the popup window, the title, the text in it, and the buttons are validated")
	void confirm() {
		var form = PlatformApp.screen("Checkbox validation confirm")
				.secondLevelView("Form")
				.form("Form title");
		var checkbox = form.checkbox("Custom Field");
		checkbox.setValue(true);
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
		PlatformFormWidget form = PlatformApp.screen("Checkbox validation field level annotation")
				.secondLevelView("Form")
				.form("Form title");
		var checkbox = form
				.checkbox("Custom Field");
		checkbox.setValue(false)
				.setValue(true)
				.setValue(false);
		form.actions()
				.action("Save")
				.click();
		checkbox.checkRequired(message -> assertThat(message).isEqualTo(Text.textOnly("'True'")));
	}


	@Test
	@Severity(CRITICAL)
	@Tag("Negative")
	@DisplayName("Required Message validation test for multiple fields")
	@Description("The test sets a value with the wrong data type in several fields for different widgets. After approval, it checks the text under the field, which informs about the correctness of the type of data entered")
	void fieldLevelValidation() {
		var form = PlatformApp.screen("Checkbox validation field level dynamic")
				.secondLevelView("Form")
				.form("Form title");
		var customField = form
				.checkbox("Custom Field");
		var customFieldAdditional = form
				.checkbox("Custom Field Additional");
		customField.setValue(true)
				.setValue(false)
				.setValue(true)
				.setValue(false);
		customFieldAdditional.setValue(true)
				.setValue(false)
				.setValue(true)
				.setValue(false);
		form.actions().action("Save").click();
		customFieldAdditional.checkRequired(message -> assertThat(message).isEqualTo(Text.textOnlyWithTitle("'customFieldAdditional'", "'True")));
		customField.checkRequired(message -> assertThat(message).isEqualTo(Text.textOnlyWithTitle("'customField'", "'True")));
	}

	@Test
	@Severity(CRITICAL)
	@Tag("Negative")
	@DisplayName("Required Message text Verification field test")
	@Description("The test clears the field and clicks the Save button. Then validates the message that the field is required")
	void required() {
		var form = PlatformApp.screen("Checkbox required")
				.secondLevelView("Form")
				.form("Form title");
		form.actions().action("Save").click();
		form.checkbox("Custom Field").checkRequired(message -> assertThat(message).isEqualTo(Constants.RequiredMessage));
	}
}
