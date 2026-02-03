package sample.form;

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
import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("Form. Checking the basic functions for the DateTimeWithSeconds in the widget Form")
@Epic("application/Samples")
@Tag("application/Samples")
@Tag("Form")
public class DateTimeWithSecondsTest extends BaseTestForSamples {

	@Test
	@Tag("Positive")
	@DisplayName("Test for getting the Placeholder value")
	@Description("The test gets the value from the placeholder attribute and returns it in String format")
	void placeholder() {
		var form = PlatformApp
				.screen("DateTimeWithSeconds placeholder")
				.secondLevelView("Form")
				.form("Form title");
		form.dateTimeWithSecond("custom Field")
				.checkPlaceholder(pd -> assertThat(pd).isEqualTo("29.05.2023 11:25:58"));
	}

	@Test
	@Tag("Positive")
	@DisplayName("A test to get the field color value in Hex format")
	@Description("The test gets the value from the style attribute in RGB format, and then converts it to Hex format")
	void color() {
		var form = PlatformApp
				.screen("DateTimeWithSeconds color")
				.secondLevelView("Form")
				.form("Form title");
		form.dateTimeWithSecond("custom Field")
				.checkColor(color -> assertThat(color).isNull());
	}

	@Test
	@Tag("Positive")
	@DisplayName("A test to check the field for \"Read-only\"")
	@Description("The test checks for the disabled attribute")
	void readonly() {
		var form = PlatformApp
				.screen("DateTimeWithSeconds readonly")
				.secondLevelView("Form")
				.form("Form title");
		form.dateTimeWithSecond("custom Field")
				.checkReadOnly(ro -> assertThat(ro).isTrue());
	}

	@Test
	@Severity(CRITICAL)
	@Tag("Positive")
	@DisplayName("A test for setting a value in a field")
	@Description("The test sets the value in the field, and then checks the value in the field with what should be set")
	void edit() {
		LocalDateTime dateTime = LocalDateTime.of(2020, 11, 10, 10, 10, 10);
		var form = PlatformApp.screen("DateTimeWithSeconds basic")
				.secondLevelView("Form")
				.form("Form title");
		var dateTimeField = form.dateTimeWithSecond("custom Field");
		dateTimeField.setValue(dateTime)
				.checkValue(date -> assertThat(date).isEqualTo(dateTime));
	}

	@Test
	@Tag("Positive")
	@DisplayName("The DrillDown test")
	@Description("Checking the url before the transition and after the transition/click on a special element")
	void drillDown() {
		var form = PlatformApp
				.screen("DateTimeWithSeconds drillDown")
				.secondLevelView("Form")
				.form("Form title");
		form.dateTimeWithSecond("custom Field")
				.checkDrillDownSupported(ro -> assertThat(ro).isFalse());
	}

	@Test
	@Severity(CRITICAL)
	@Tag("Negative")
	@DisplayName("Business Exception Validation Test")
	@Description("The test sets the value in the field. After approval, the popup window, the title, the text in it, and the buttons are validated")
	void businessException() {
		LocalDateTime dateTime = LocalDateTime.of(2020, 9, 10, 10, 10, 10);
		var form = PlatformApp.screen("DateTimeWithSeconds validation business exception")
				.secondLevelView("Form")
				.form("Form title");
		var dateTimeField = form.dateTimeWithSecond("Custom Field");
		dateTimeField.setValue(dateTime);
		form.actions().action("Save").click();
		form.errorPopup()
				.checkTitle(title -> assertThat(title).isEqualTo(Constants.ErrorPopup.TITLE))
				.checkMessage(title -> assertThat(title).isEqualTo(Constants.MoreThatCurrentDate));
	}

	@Test
	@Severity(CRITICAL)
	@Tag("Negative")
	@DisplayName("Run-time exception validation test")
	@Description("The test sets the value in the field. After approval, the popup window, the title, the text in it, and the buttons are validated")
	void runtimeException() {
		var form = PlatformApp.screen("DateTimeWithSeconds validation runtime exception")
				.secondLevelView("Form")
				.form("Form title");
		var dateTimeField = form.dateTimeWithSecond("custom Field");
		dateTimeField.clear();
		form.errorPopup()
				.checkTitle(title -> assertThat(title).isEqualTo(Constants.ErrorPopup.TITLE))
				.checkMessage(title -> assertThat(title).isEqualTo(Constants.SystemError))
				.close();
	}

	@Test
	@Severity(CRITICAL)
	@Tag("Positive")
	@DisplayName("Confirmation Popup Validation Test")
	@Description("The test sets the value in the field. After approval, by clicking on the save button, the popup window, the title, the text in it, and the buttons are validated")
	void confirm() {
		LocalDateTime dateTime = LocalDateTime.of(2020, 9, 10, 10, 10, 10);
		var form = PlatformApp.screen("DateTimeWithSeconds validation confirm")
				.secondLevelView("Form")
				.form("Form title");
		var dateTimeField = form.dateTimeWithSecond("custom Field");
		dateTimeField.setValue(dateTime);
		form.actions().action("save").click();
		form.confirmPopup()
				.checkTitle(title -> assertThat(title).isEqualTo(Constants.ConfirmPopup.TITLE))
				.checkMessage(message -> assertThat(message).isEqualTo(Constants.SaveValue))
				.close();
	}

	@Test
	@Severity(CRITICAL)
	@Tag("Negative")
	@DisplayName("Required Message validation test for one field")
	@Description("The test sets the value with the wrong data type in the field. After approval, it checks the text under the field, which informs about the correctness of the type of data entered")
	void fieldLevelValidationAnnotation() {
		LocalDateTime dateTime = LocalDateTime.of(2020, 11, 10, 10, 10, 10);
		var form = PlatformApp.screen("DateTimeWithSeconds validation field level annotation")
				.secondLevelView("Form")
				.form("Form title");
		var dateTimeField = form.dateTimeWithSecond("Custom Field");
		dateTimeField.setValue(dateTime);
		form.actions().action("Save").click();
		dateTimeField.checkRequired(message -> assertThat(message).isEqualTo(Constants.MoreThatCurrentDate));
	}

	@Test
	@Severity(CRITICAL)
	@Tag("Negative")
	@DisplayName("Required Message validation test for multiple fields")
	@Description("The test sets a value with the wrong data type in several fields for different widgets. After approval, it checks the text under the field, which informs about the correctness of the type of data entered")
	void fieldLevelValidation() {
		LocalDateTime dateTime = LocalDateTime.of(1999, 11, 10, 10, 10, 10);
		var form = PlatformApp.screen("DateTimeWithSeconds validation field level dynamic")
				.secondLevelView("Form")
				.form("Form title");
		var customField = form.dateTimeWithSecond("Custom Field");
		var customFieldAdditional = form.dateTimeWithSecond("Custom Field Additional");
		customField.setValue(dateTime);
		customFieldAdditional.setValue(dateTime);
		form.actions().action("Save").click();
		customField.checkRequired(message -> assertThat(message).isEqualTo(Text.textMoreThatCurrentDate("customField")));
		customFieldAdditional.checkRequired(message -> assertThat(message).isEqualTo(Text.textMoreThatCurrentDate("customFieldAdditional")));
	}

	@Test
	@Severity(CRITICAL)
	@Tag("Negative")
	@DisplayName("Required Message text Verification field test")
	@Description("The test clears the field and clicks the Save button. Then validates the message that the field is required")
	void required() {
		var form = PlatformApp.screen("DateTimeWithSeconds required")
				.secondLevelView("Form")
				.form("Form title");
		form.dateTimeWithSecond("custom Field")
				.clear()
				.checkRequired(message -> assertThat(message).isEqualTo(Constants.RequiredMessage));
	}
}
