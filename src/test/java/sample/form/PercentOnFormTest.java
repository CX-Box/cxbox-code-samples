package sample.form;

import application.common.Text;
import application.config.BaseTestForSamples;
import core.config.Constants;
import core.element.PlatformApp;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static io.qameta.allure.SeverityLevel.CRITICAL;
import static io.qameta.allure.SeverityLevel.MINOR;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class PercentOnFormTest extends BaseTestForSamples {

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
				.screen("Percent placeholder")
				.secondLevelView("Form")
				.form("Form title");
		form.percent("custom Field")
				.checkPlaceholder(pl -> assertThat(pl).isEqualTo("17"));
	}

	@Test
	@Tag("Positive")
	@DisplayName("A test to get the field color value in Hex format")
	@Description("The test gets the value from the style attribute in RGB format, and then converts it to Hex format")
	void color() {
		var form = PlatformApp
				.screen("Percent color")
				.secondLevelView("Form")
				.form("Form title");
		form.percent("Custom Field")
				.checkColor(color -> assertThat(color).isEqualTo("#EDA6A6"));
	}

	@Test
	@Tag("Positive")
	@DisplayName("A test to check the field for \"Read-only\"")
	@Description("The test checks for the disabled attribute")
	void readonly() {
		var form = PlatformApp
				.screen("Percent readonly")
				.secondLevelView("Form")
				.form("Form title");
		form.percent("custom Field")
				.checkReadOnly(ro -> assertThat(ro).isTrue());
	}

	@Test
	@Severity(CRITICAL)
	@Tag("Positive")
	@DisplayName("A test for setting a value in a field")
	@Description("The test sets the value in the field, and then checks the value in the field with what should be set")
	void edit() {
		BigDecimal percent = new BigDecimal("57");
		var form = PlatformApp.screen("Percent basic")
				.secondLevelView("Form")
				.form("Form title");
		var percentField = form.percent("custom Field");
		percentField.setValue(percent)
				.checkValue(val -> assertThat(val).isEqualTo(percent));
	}

	@Test
	@Severity(CRITICAL)
	@Tag("Negative")
	@DisplayName("Business Exception Validation Test")
	@Description("The test sets the value in the field. After approval, the popup window, the title, the text in it, and the buttons are validated")
	void businessException() {
		var form = PlatformApp.screen("Percent validation business exception")
				.secondLevelView("Form")
				.form("Form title");
		var percentField = form.percent("custom Field");
		percentField.setValue(new BigDecimal("3"));
		form.actions().action("Save").click();
		form.errorPopup()
				.checkTitle(title -> assertThat(title).isEqualTo(Constants.ErrorPopup.TITLE))
				.checkMessage(message -> assertThat(message).isEqualTo(Constants.MoreThatPercent))
				.close();
	}

	@Test
	@Severity(CRITICAL)
	@Tag("Negative")
	@DisplayName("Run-time exception validation test")
	@Description("The test sets the value in the field. After approval, the popup window, the title, the text in it, and the buttons are validated")
	void runtimeException() {
		var form = PlatformApp.screen("Percent validation runtime exception")
				.secondLevelView("Form")
				.form("Form title");
		var percentField = form.percent("custom Field");
		percentField.clear();
		form.actions().action("Save").click();
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
		var form = PlatformApp.screen("Percent validation confirm")
				.secondLevelView("Form")
				.form("Form title");
		var percentField = form.percent("custom Field");
		percentField.setValue(new BigDecimal("57"));
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
		var form = PlatformApp.screen("Percent validation field level annotation")
				.secondLevelView("Form")
				.form("Form title");
		var percentField = form.percent("Custom Field");
		percentField.setValue(new BigDecimal("3"));
		form.actions().action("Save").click();
		percentField.checkRequired(rm -> assertThat(rm).isEqualTo(Text.textInvalidPercent("5%.")));
	}

	@Test
	@Severity(CRITICAL)
	@Tag("Negative")
	@DisplayName("Required Message validation test for multiple fields")
	@Description("The test sets a value with the wrong data type in several fields for different widgets. After approval, it checks the text under the field, which informs about the correctness of the type of data entered")
	void fieldLevelValidation() {
		var form = PlatformApp.screen("Percent validation field level dynamic")
				.secondLevelView("Form")
				.form("Form title");
		var customField = form.percent("Custom Field");
		var customFieldAdditional = form.percent("Custom Field Additional");
		customField.setValue(new BigDecimal("3"));
		customFieldAdditional.setValue(new BigDecimal("3"));
		form.actions().action("Save").click();
		customField.checkRequired(rm -> assertThat(rm).isEqualTo(Text.textInvalidPercent("5%")));
		customFieldAdditional.checkRequired(rm -> assertThat(rm).isEqualTo(Text.textInvalidPercent("5%")));
	}

	@Test
	@Severity(CRITICAL)
	@Tag("Negative")
	@DisplayName("Required Message text Verification field test")
	@Description("The test clears the field and clicks the Save button. Then validates the message that the field is required")
	void required() {
		var form = PlatformApp.screen("Percent required")
				.secondLevelView("Form")
				.form("Form title");
		var percentField = form.percent("custom Field");
		percentField.clear();
		form.actions().action("Save").click();
		percentField.checkRequired(rm -> assertThat(rm).isEqualTo(Constants.RequiredMessage));
	}

	@Test
	@Severity(CRITICAL)
	@Tag("Positive")
	@DisplayName("A test for entering numbers with a fractional part using the PercentDigits class")
	@Description("The test sets the value in the field, and then checks the value in the field with what should be set. The Number Digits class is used for numbers with a fractional part.")
	void digits() {
		BigDecimal number = new BigDecimal("131343.00");
		var form = PlatformApp.screen("Percent digits")
				.secondLevelView("Form")
				.form("Form title");
//        var percentField = form.percentDigits("Custom Field");
//        percentField.setValue(number)
//              .checkValue(val -> assertThat(val).isEqualTo(number));
	}

	@Test
	@Tag("Positive")
	@DisplayName("Auto-completion test after cleaning")
	@Description("The test deletes the value by checking the autocomplete in a blank field")
	void nullable() {
		BigDecimal value = new BigDecimal("123");
		var form = PlatformApp.screen("Percent nullable")
				.secondLevelView("Form")
				.form("Form title");
		var percentField = form.percent("Custom Field");
		percentField.setValue(value)
				.checkValue(val -> assertThat(val).isEqualTo(value));
	}
}
