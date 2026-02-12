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

@DisplayName("Form. Checking the basic functions for the Input in the widget Form")
@Epic("application/Samples")
@Tag("application/Samples")
@Tag("Form")
public class InputTest extends BaseTestForSamples {

	@Test
	@Tag("Positive")
	@DisplayName("Test for getting the Placeholder value")
	@Description("The test gets the value from the placeholder attribute and returns it in String format")
	void placeholder() {
		var form = PlatformApp
				.screen("Input placeholder")
				.secondLevelView("Form")
				.form("Form");
		form.input("customField")
				.checkPlaceholder(actualText -> assertThat(actualText).isEqualTo("Placeholder text"));
	}

	@Test
	@Tag("Positive")
	@DisplayName("A test to get the field color value in Hex format")
	@Description("The test gets the value from the style attribute in RGB format, and then converts it to Hex format")
	void color() {
		var form = PlatformApp
				.screen("Input color")
				.secondLevelView("Form")
				.form("Form");
		form.input("customField")
				.checkColor(actualColor -> assertThat(actualColor).isNull());
	}

	@Test
	@Tag("Positive")
	@DisplayName("A test to check the field for \"Read-only\"")
	@Description("The test checks for the disabled attribute")
	void readonly() {
		var form = PlatformApp
				.screen("Input readonly")
				.secondLevelView("Form")
				.form("Form");
		form.input("customField")
				.checkReadOnly(ro -> assertThat(ro).isTrue());
	}

	@Test
	@Severity(CRITICAL)
	@Tag("Positive")
	@DisplayName("A test for setting a value in a field")
	@Description("The test sets the value in the field, and then checks the value in the field with what should be set")
	void edit() {
		var form = PlatformApp.screen("Input basic")
				.secondLevelView("Form")
				.form("Form");
		var input = form.input("customField");
		input.setValue("5700")
				.checkValue(value -> assertThat(value).isEqualTo("5700"))
				.setValue("200")
				.checkValue(value -> assertThat(value).isEqualTo("200"));
	}

	@Disabled
	@Test
	@Severity(MINOR)
	@Tag("Negative")
	@DisplayName("Filtering test")
	@Description("Filtering is not available for the Form widget")
	void filtration() {
	}

	@Test
	@Tag("Positive")
	@DisplayName("The DrillDown test")
	@Description("Checking the url before the transition and after the transition/click on a special element")
	void drillDown() {
		var form = PlatformApp
				.screen("Input drilldown")
				.secondLevelView("Form")
				.form("Form");
		form.input("customField2")
				.drilldown(url -> assertThat(url).contains("/screen/InputDrilldown/view/InputDrilldowninfo/InputDrilldown"));
	}

	@Test
	@Severity(CRITICAL)
	@Tag("Negative")
	@DisplayName("Business Exception Validation Test")
	@Description("The test sets the value in the field. After approval, the popup window, the title, the text in it, and the buttons are validated")
	void businessException() {
		var form = PlatformApp.screen("Input validation business exception ")
				.secondLevelView("Form")
				.form("Form");
		var input = form.input("customField");
		input.setValue("5700");
		form.errorPopup()
				.checkTitle(title -> assertThat(title).isEqualTo(Constants.ErrorPopup.TITLE))
				.checkMessage(message -> assertThat(message).isEqualTo(Constants.OnlyLetters))
				.close();
	}

	@Test
	@Severity(CRITICAL)
	@Tag("Negative")
	@DisplayName("Run-time exception validation test")
	@Description("The test sets the value in the field. After approval, the popup window, the title, the text in it, and the buttons are validated")
	void runtimeException() {
		var form = PlatformApp.screen("Input validation runtime exception")
				.secondLevelView("Form")
				.form("Form");
		var input = form.input("customField");
		input.setValue("1234");
		form.errorPopup()
				.checkTitle(title -> assertThat(title).isEqualTo(Constants.ErrorPopup.TITLE))
				.checkMessage(message -> assertThat(message).isEqualTo(Constants.SystemError))
				.close();
	}

	@Test
	@Severity(CRITICAL)
	@Tag("Positive")
	@DisplayName("Confirmation Popup Validation Test")
	@Description("The test sets the value in the field. After approval, by clicking on the save button, the popup window, the title, the text in it, and the buttons are validated")
	void confirm() {
		var form = PlatformApp.screen("Input validation confirm")
				.secondLevelView("Form")
				.form("Form");
		var input = form.input("customField");
		input.setValue("5700");
		form.actions().action("save").click();
		form.confirmPopup()
				.checkTitle(title -> assertThat(title).isEqualTo(Constants.ConfirmPopup.TITLE))
				.checkMessage(message -> assertThat(message).isEqualTo(Constants.SaveValue))
				.clickOk();
	}

	@Test
	@Severity(CRITICAL)
	@Tag("Negative")
	@DisplayName("Required Message validation test for one field")
	@Description("The test sets the value with the wrong data type in the field. After approval, it checks the text under the field, which informs about the correctness of the type of data entered")
	void fieldLevelValidationAnnotation() {
		var form = PlatformApp.screen("Input validation field level annotation")
				.secondLevelView("Form")
				.form("Form title");
		var input = form.input("Custom Field");
		input.setValue("123");
		form.actions().action("Save").click();
		input.checkRequired(rt -> assertThat(rt).isEqualTo(Constants.OnlyLetters));
	}

	@Test
	@Severity(CRITICAL)
	@Tag("Negative")
	@DisplayName("Required Message validation test for multiple fields")
	@Description("The test sets a value with the wrong data type in several fields for different widgets. After approval, it checks the text under the field, which informs about the correctness of the type of data entered")
	void fieldLevelValidation() {
		var form = PlatformApp.screen("Input validation field level dynamic")
				.secondLevelView("Form")
				.form("Form title");
		var customField = form.input("Custom Field");
		var customFieldAdditional = form.input("Custom Field Additional");
		customField.setValue("123");
		customFieldAdditional.setValue("123");
		form.actions().action("Save").click();
		customField.checkRequired(rt -> assertThat(rt).isEqualTo(Text.textOnlyLetters("customField")));
		customFieldAdditional.checkRequired(rt -> assertThat(rt).isEqualTo(Text.textOnlyLetters("customFieldAdditional")));
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
		var form = PlatformApp.screen("Input required")
				.secondLevelView("Form")
				.form("Form");
		var input = form.input("customField");
		input.clear();
		form.actions().action("Save").click();
		input.checkRequired(rt -> assertThat(rt).isEqualTo(Constants.RequiredMessage));
	}

	@Test
	@Severity(MINOR)
	@Tag("Positive")
	@DisplayName("Required Message text Verification field test")
	@Description("The test checks the value of the digits attributes")
	void maxInput() {
		var form = PlatformApp.screen("Input maxInput")
				.secondLevelView("Form")
				.form("Form title");
		form.input("custom Field")
				.clear()
				.setValue("td")
				.checkMaxInput(mi -> assertThat(mi).isEqualTo(2));
	}

	@Test
	@Severity(MINOR)
	@Tag("Positive")
	@DisplayName("Test getting all widget buttons")
	@Description("The test checks the list of buttons")
	void getButtons() {
		var form = PlatformApp.screen("Input basic")
				.secondLevelView("Form")
				.form("Form");
		form.actions().checkExistButtons();
		form.input("customField")
				.checkValue(val -> assertThat(val).isEqualTo("test data"));
	}
}
