package application.Samples.Form;

import application.common.Text;
import application.config.BaseTestForSamples;
import core.config.Constants;
import core.element.PlatformApp;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Severity;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static io.qameta.allure.SeverityLevel.CRITICAL;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DisplayName("Form. Checking the basic functions for the DateTime in the widget Form")
@Epic("application/Samples")
@Tag("application/Samples")
@Tag("Form")
public class DateTimeOnFormTest extends BaseTestForSamples {

	@Test
	@Tag("Positive")
	@DisplayName("Test for getting the Placeholder value")
	@Description("The test gets the value from the placeholder attribute and returns it in String format")
	void placeholder() {
		var form = PlatformApp
				.screen("Datetime placeholder")
				.secondLevelView("Form")
				.form("Form title");
		form.dateTime("custom Field")
				.checkPlaceholder(val -> assertThat(val).isEqualTo("29.05.2023 11:25"));
	}

	@Test
	@Tag("Positive")
	@DisplayName("A test to get the field color value in Hex format")
	@Description("The test gets the value from the style attribute in RGB format, and then converts it to Hex format")
	void color() {
		var form = PlatformApp
				.screen("Datetime color")
				.secondLevelView("Form")
				.form("Form title");
		form.dateTime("custom Field")
				.checkColor(color -> assertThat(color).isNull());
	}

	@Test
	@Tag("Positive")
	@DisplayName("A test to check the field for \"Read-only\"")
	@Description("The test checks for the disabled attribute")
	void readonly() {
		var form = PlatformApp
				.screen("Datetime readonly")
				.secondLevelView("Form")
				.form("Form title");
		form.dateTime("custom Field")
				.checkReadOnly(ro -> assertThat(ro).isTrue());
	}

	@Test
	@Severity(CRITICAL)
	@Tag("Positive")
	@DisplayName("A test for setting a value in a field")
	@Description("The test sets the value in the field, and then checks the value in the field with what should be set")
	void edit() {
		LocalDateTime dateTime = LocalDateTime.of(220, 10, 10, 10, 10);
		var form = PlatformApp.screen("Datetime basic")
				.secondLevelView("Form")
				.form("Form title");
		var dateTimeField = form.dateTime("custom Field");
		dateTimeField.setValue(dateTime)
				.checkValue(val -> assertThat(val).isEqualTo(dateTime));
	}

	@Test
	@Severity(CRITICAL)
	@Tag("Negative")
	@DisplayName("Business Exception Validation Test")
	@Description("The test sets the value in the field. After approval, the popup window, the title, the text in it, and the buttons are validated")
	void businessException() {
		LocalDateTime dateTime = LocalDateTime.of(1999, 4, 7, 17, 35);
		var form = PlatformApp.screen("Datetime validation business exception")
				.secondLevelView("Form")
				.form("Form title");
		var dateTimeField = form.dateTime("custom Field");
		dateTimeField.setValue(dateTime);
		form.errorPopup()
				.checkTitleAndMessage(
						title -> assertThat(title).isEqualTo(Constants.ErrorPopup.TITLE),
						message -> assertThat(message).isEqualTo(Constants.MoreThatCurrentDate))
				.close();
	}

	@Test
	@Severity(CRITICAL)
	@Tag("Negative")
	@DisplayName("Run-time exception validation test")
	@Description("The test sets the value in the field. After approval, the popup window, the title, the text in it, and the buttons are validated")
	void runtimeException() {
		var form = PlatformApp.screen("Datetime validation runtime exception")
				.secondLevelView("Form")
				.form("Form title");
		var dateTimeField = form.dateTime("custom Field");
		dateTimeField.clear();
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
		LocalDateTime dateTime = LocalDateTime.of(1999, 4, 7, 17, 35);
		var form = PlatformApp.screen("Datetime validation confirm")
				.secondLevelView("Form")
				.form("Form title");
		var dateTimeField = form.dateTime("custom Field");
		dateTimeField.setValue(dateTime);
		form.actions().click("save");
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
		LocalDateTime dateTime = LocalDateTime.of(1999, 4, 7, 17, 35);
		var form = PlatformApp.screen("Datetime validation field level annotation")
				.secondLevelView("Form")
				.form("Form title");
		var dateTimeField = form.dateTime("Custom Field");
		dateTimeField.setValue(dateTime);
		form.actions().click("Save");
		dateTimeField.checkRequired(required -> assertThat(required).isEqualTo(Constants.MoreThatCurrentDate));
	}

	@Test
	@Severity(CRITICAL)
	@Tag("Negative")
	@DisplayName("Required Message validation test for multiple fields")
	@Description("The test sets a value with the wrong data type in several fields for different widgets. After approval, it checks the text under the field, which informs about the correctness of the type of data entered")
	void fieldLevelValidation() {
		LocalDateTime dateTime = LocalDateTime.of(1999, 4, 7, 17, 35);
		var form = PlatformApp.screen("Datetime validation field level dynamic")
				.secondLevelView("Form")
				.form("Form title");
		var customField = form.dateTime("Custom Field");
		var customFieldAdditional = form.dateTime("Custom Field Additional");
		customField.setValue(dateTime);
		customFieldAdditional.setValue(dateTime);
		form.actions().click("Save");
		customField.checkRequired(rm -> assertThat(rm).isEqualTo(Text.textMoreThatCurrentDate("customField")));
		customFieldAdditional.checkRequired(rm -> assertThat(rm).isEqualTo(Text.textMoreThatCurrentDate("customFieldAdditional")));
	}

	@Test
	@Severity(CRITICAL)
	@Tag("Negative")
	@DisplayName("Required Message text Verification field test")
	@Description("The test clears the field and clicks the Save button. Then validates the message that the field is required")
	void required() {
		var form = PlatformApp.screen("Datetime required")
				.secondLevelView("Form")
				.form("Form title");
		form.dateTime("custom Field")
				.clear()
				.checkRequired(rm -> assertThat(rm).isEqualTo(Constants.RequiredMessage));
	}
}
