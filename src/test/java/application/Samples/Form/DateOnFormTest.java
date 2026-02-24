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

import java.time.LocalDate;

import static io.qameta.allure.SeverityLevel.CRITICAL;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DisplayName("Form. Checking the basic functions for the Date in the widget Form")
@Epic("application/Samples")
@Tag("application/Samples")
@Tag("Form")
public class DateOnFormTest extends BaseTestForSamples {

	@Test
	@Tag("Positive")
	@DisplayName("Test for getting the Placeholder value")
	@Description("The test gets the value from the placeholder attribute and returns it in String format")
	void placeholder() {
		var form = PlatformApp
				.screen("Date placeholder")
				.secondLevelView("Form")
				.form("Form title");
		form.date("custom Field")
				.checkPlaceholder(value -> assertThat(value).isEqualTo("29.05.2023"));
	}

	@Test
	@Tag("Positive")
	@DisplayName("A test to get the field color value in Hex format")
	@Description("The test gets the value from the style attribute in RGB format, and then converts it to Hex format")
	void color() {
		var form = PlatformApp
				.screen("Date color")
				.secondLevelView("Form")
				.form("Form title");
		form.date("custom Field")
				.checkColor(color -> assertThat(color).isNull());
	}

	@Test
	@Tag("Positive")
	@DisplayName("A test to check the field for \"Read-only\"")
	@Description("The test checks for the disabled attribute")
	void readonly() {
		var form = PlatformApp
				.screen("Date readonly")
				.secondLevelView("Form")
				.form("Form title");
		form.date("custom Field")
				.checkReadOnly(ro -> assertThat(ro).isTrue());
	}

	@Test
	@Severity(CRITICAL)
	@Tag("Positive")
	@DisplayName("A test for setting a value in a field")
	@Description("The test sets the value in the field, and then checks the value in the field with what should be set")
	void edit() {
		LocalDate date = LocalDate.of(2024, 12, 5);
		var form = PlatformApp.screen("Date basic")
				.secondLevelView("Form")
				.form("Form title");
		var dateField = form.date("custom Field");
		LocalDate defaultDate = dateField.getValue();
		dateField.setValue(date)
				.checkValue(av -> assertThat(av).isEqualTo(date));
		dateField.setValue(defaultDate);
	}

	@Test
	@Severity(CRITICAL)
	@Tag("Negative")
	@DisplayName("Business Exception Validation Test")
	@Description("The test sets the value in the field. After approval, the popup window, the title, the text in it, and the buttons are validated")
	void businessException() {
		LocalDate date = LocalDate.of(2020, 12, 5);
		var form = PlatformApp.screen("Date validation business exception")
				.secondLevelView("Form")
				.form("Form title");
		var dateField = form.date("custom Field");
		dateField.setValue(date);
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
		LocalDate date = LocalDate.of(2024, 12, 5);
		var form = PlatformApp.screen("Date validation runtime exception")
				.secondLevelView("Form")
				.form("Form title");
		var dateField = form.date("custom Field");
		dateField.setValue(date);
		form.actions().action("Save").click();
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
		LocalDate date = LocalDate.of(2024, 12, 5);
		var form = PlatformApp.screen("Date confirm")
				.secondLevelView("Form")
				.form("Form title");
		var dateField = form.date("custom Field");
		LocalDate defaultDate = dateField.getValue();
		dateField.setValue(date);
		form.actions().action("save").click();
		form.confirmPopup()
				.checkTitleAndMessage(
						title -> assertThat(title).isEqualTo(Constants.ConfirmPopup.TITLE),
						message -> assertThat(message).isEqualTo(Constants.SaveValue))
				.clickOk();

		dateField.setValue(defaultDate);
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
		LocalDate date = LocalDate.of(2010, 2, 5);
		var form = PlatformApp.screen("Date validation field level annotation")
				.secondLevelView("Form")
				.form("Form title");
		var dateField = form.date("Custom Field");
		dateField.setValue(date);
		form.actions().action("Save").click();
		dateField.checkRequired(required -> assertThat(required).isEqualTo(Constants.MoreThatCurrentDate));
	}

	@Test
	@Severity(CRITICAL)
	@Tag("Negative")
	@DisplayName("Required Message validation test for one field")
	@Description("The test sets the value with the wrong data type in the field. After approval, it checks the text under the field, which informs about the correctness of the type of data entered")
	void fieldLevelValidationAnnotationAlternative() {
		LocalDate date = LocalDate.of(2010, 2, 5);
		var form = PlatformApp.screen("Date validation field level annotation")
				.secondLevelView("Form")
				.form("Form title");
		var dateField = form.date("Custom Field");
		dateField.setValue(date);
		form.actions().action("Save").click();
		dateField.checkRequired(required -> assertThat(required).isEqualTo(Constants.MoreThatCurrentDate));
	}

	@Test
	@Severity(CRITICAL)
	@Tag("Negative")
	@DisplayName("Required Message validation test for multiple fields")
	@Description("The test sets a value with the wrong data type in several fields for different widgets. After approval, it checks the text under the field, which informs about the correctness of the type of data entered")
	void fieldLevelValidation() {
		LocalDate date = LocalDate.of(2010, 2, 5);
		var form = PlatformApp.screen("Date validation field level dynamic")
				.secondLevelView("Form")
				.form("Form title");
		var customField = form.date("Custom Field");
		var customFieldAdditional = form.date("Custom Field Additional");
		customField.setValue(date);
		customFieldAdditional.setValue(date);
		form.actions().action("Save").click();
		customField.checkRequired(required -> assertThat(required).isEqualTo(Text.textMoreThatCurrentDate("customField")));
		customFieldAdditional.checkRequired(required -> assertThat(required).isEqualTo(Text.textMoreThatCurrentDate("customFieldAdditional")));
	}

	@Test
	@Severity(CRITICAL)
	@Tag("Negative")
	@DisplayName("Required Message text Verification field test")
	@Description("The test clears the field and clicks the Save button. Then validates the message that the field is required")
	void required() {
		var form = PlatformApp.screen("Date required")
				.secondLevelView("Form")
				.form("Form title");
		form.date("custom Field")
				.clear()
				.checkRequired(requried -> assertThat(requried).isEqualTo(Constants.RequiredMessage));
	}
}
