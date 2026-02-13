package application.Samples.Form;

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

import java.util.Map;
import java.util.Set;

import static io.qameta.allure.SeverityLevel.CRITICAL;
import static io.qameta.allure.SeverityLevel.MINOR;
import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("Form. Checking the basic functions for the MultipleSelect in the widget Form")
@Epic("application/Samples")
@Tag("application/Samples")
@Tag("Form")
public class MultipleSelectOnFormTest extends BaseTestForSamples {

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

	@Disabled
	@Test
	@Severity(MINOR)
	@Tag("Negative")
	@DisplayName("Sorting test")
	@Description("Sorting is not available for the Form widget")
	void sorting() {
	}

	@Test
	@Tag("Positive")
	@DisplayName("Test for getting the Placeholder value")
	@Description("The test gets the value from the placeholder attribute and returns it in String format")
	void placeholder() {
		var form = PlatformApp
				.screen("MultipleSelect placeholder")
				.secondLevelView("Form")
				.form("Form title");
		form.multipleSelect("Custom Field")
				.checkPlaceholder(pl -> assertThat(pl).isEqualTo("Placeholder text"));
	}

	@Test
	@Tag("Positive")
	@DisplayName("A test to get the field color value in Hex format")
	@Description("The test gets the value from the style attribute in RGB format, and then converts it to Hex format")
	void color() {
		var form = PlatformApp
				.screen("MultipleSelect color")
				.secondLevelView("Form")
				.form("Form title");
		form.multipleSelect("Custom Field")
				.checkColor(color -> assertThat(color).isNull());
	}

	@Test
	@Tag("Positive")
	@DisplayName("A test to check the field for \"Read-only\"")
	@Description("The test checks for the disabled attribute")
	void readonly() {
		var form = PlatformApp
				.screen("MultipleSelect readonly")
				.secondLevelView("Form")
				.form("Form title");
		form.multipleSelect("Custom Field")
				.checkReadOnly(readonly -> assertThat(readonly).isTrue());
	}

	@Test
	@Severity(CRITICAL)
	@Tag("Positive")
	@DisplayName("A test for setting a value in a field")
	@Description("The test sets the value in the field, and then checks the value in the field with what should be set. Предварительной очистки поля нет")
	void edit() {
		var form = PlatformApp.screen("MultipleSelect basic")
				.secondLevelView("Form")
				.form("Form title");
		var multipleSelect = form.multipleSelect("Custom Field");
		multipleSelect.clear()
				.addValue(Set.of("Low"));
		form.actions().click("Save");
		multipleSelect.checkValue(value -> assertThat(value).isEqualTo(Set.of("Low")));
	}

	@Test
	@Severity(CRITICAL)
	@Tag("Negative")
	@DisplayName("Business Exception Validation Test")
	@Description("The test sets the value in the field. After approval, the popup window, the title, the text in it, and the buttons are validated")
	void businessException() {
		var form = PlatformApp.screen("MultipleSelect business error")
				.secondLevelView("Form")
				.form("Form title");
		var multipleSelect = form.multipleSelect("Custom Field");
		multipleSelect.addValue(Set.of("Middle"));
		form.errorPopup()
				.checkTitleAndMessage(
						title -> assertThat(title).isEqualTo(Constants.ErrorPopup.TITLE),
						message -> assertThat(message).isEqualTo("The field  can contain 'High'"))
				.close();
	}

	@Test
	@Severity(CRITICAL)
	@Tag("Negative")
	@DisplayName("Run-time exception validation test")
	@Description("The test sets the value in the field. After approval, the popup window, the title, the text in it, and the buttons are validated")
	void runtimeException() {
		var form = PlatformApp.screen("MultipleSelect runtime error")
				.secondLevelView("Form")
				.form("Form title");
		var multipleSelect = form.multipleSelect("Custom Field");
		multipleSelect.addValue(Set.of("Middle"));
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
		var form = PlatformApp.screen("MultipleSelect validation confirm")
				.secondLevelView("Form")
				.form("Form title");
		var multipleSelect = form.multipleSelect("Custom Field");
		multipleSelect.setValue(Set.of("Low"));
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
		var form = PlatformApp.screen("MultipleSelect validation field level annotation")
				.secondLevelView("Form")
				.form("Form title");
		var multipleSelect = form.multipleSelect("Custom Field");
		multipleSelect.clear();
		form.actions().click("Save");
		multipleSelect.checkRequired(rm -> assertThat(rm).isEqualTo(Constants.MessageAboutError));
	}

	@Test
	@Severity(CRITICAL)
	@Tag("Negative")
	@DisplayName("Required Message validation test for multiple fields")
	@Description("The test sets a value with the wrong data type in several fields for different widgets. After approval, it checks the text under the field, which informs about the correctness of the type of data entered")
	void fieldLevelValidation() {
		var form = PlatformApp.screen("MultipleSelect validation field level dynamic")
				.secondLevelView("Form")
				.form("Form title");
		form.actions().click("Save");
		form.multipleSelect("Custom Field")
				.checkRequired(rm -> assertThat(rm).isEqualTo(Constants.MessageAboutError));
		form.multipleSelect("Custom Field Additional")
				.checkRequired(rm -> assertThat(rm).isEqualTo(Constants.MessageAboutError));
	}

	@Test
	@Severity(CRITICAL)
	@Tag("Negative")
	@DisplayName("Required Message text Verification field test")
	@Description("The test clears the field and clicks the Save button. Then validates the message that the field is required")
	void required() {
		var form = PlatformApp.screen("MultipleSelect required")
				.secondLevelView("Form")
				.form("Form title");
		var multipleSelect = form.multipleSelect("Custom Field");
		multipleSelect.setValue(Set.of("Low", "Middle"))
				.checkValue(value -> assertThat(value).isEqualTo(Set.of("Low", "Middle")))
				.clear();
		form.actions().click("Save");
		multipleSelect.checkRequired(rm -> assertThat(rm).isEqualTo(Constants.RequiredMessage));
	}

	@Test
	@Severity(MINOR)
	@Tag("Positive")
	@DisplayName("Test to get a list of options")
	@Description("The test checks the list of options that the method returns, with the expected result")
	void getListOptions() {
		var form = PlatformApp.screen("MultipleSelect basic")
				.secondLevelView("Form")
				.form("Form title");
		form.multipleSelect("Custom Field")
				.setValue(Set.of("Middle"))
				.checkValue(value -> assertThat(value).isEqualTo(Set.of("Middle")))
				.checkOptions(value -> assertThat(value).isEqualTo(Set.of("High", "Middle", "Low")));
	}

	@Test
	@Severity(MINOR)
	@Tag("Positive")
	@DisplayName("A test to check the status of one option")
	@Description("The test checks the status of one option, whether it is selected or not")
	void statusOption() {
		var form = PlatformApp.screen("MultipleSelect basic")
				.secondLevelView("Form")
				.form("Form title");
		form.multipleSelect("Custom Field")
				.setValue(Set.of("Low"))
				.checkStatusOption("Low", isSelected -> assertThat(isSelected).isTrue());
				//.checkStatusOption("Middle", isSelected -> assertThat(isSelected).isFalse());
	}

	@Test
	@Severity(MINOR)
	@Tag("Positive")
	@DisplayName("Test to check the status of all options")
	@Description("The method returns Option-Status pairs, for all. The test checks each pair.")
	void statusOptions() {
		var form = PlatformApp.screen("MultipleSelect basic")
				.secondLevelView("Form")
				.form("Form title");
		form.multipleSelect("Custom Field")
				.checkStatusOptions(Map.of(
						"High", val -> assertThat(val).isFalse(),
						"Middle", val -> assertThat(val).isFalse(),
						"Low", val -> assertThat(val).isTrue()));
	}

	@Test
	@Severity(MINOR)
	@Tag("Positive")
	@DisplayName("Value setting test with field clearing")
	@Description("The test adds a value after removing all previous values.")
	void setValue() {
		var form = PlatformApp.screen("MultipleSelect basic")
				.secondLevelView("Form")
				.form("Form title");
		var customField = form.multipleSelect("Custom Field");
		customField.setValue(Set.of())
				.checkValue(val -> assertThat(val).isEmpty());
		customField.setValue(Set.of("Middle"))
				.checkValue(val -> assertThat(val).isEqualTo(Set.of("Middle")));
		customField.setValue(Set.of("Low"))
				.checkValue(val -> assertThat(val).isEqualTo(Set.of("Low")));
		customField.setValue(Set.of("Middle", "Low"))
				.checkValue(val -> assertThat(val).isEqualTo(Set.of("Middle", "Low")));
		customField.setValue(Set.of("Low"));
	}
}
