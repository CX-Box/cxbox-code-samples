package Samples.Form;

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

import java.math.BigDecimal;

import static io.qameta.allure.SeverityLevel.CRITICAL;
import static io.qameta.allure.SeverityLevel.MINOR;
import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("Form. Checking the basic functions for the Money in the widget Form")
@Epic("application/Samples")
@Tag("application/Samples")
@Tag("Form")
public class MoneyOnFormTest extends BaseTestForSamples {

	@Test
	@Tag("Positive")
	@DisplayName("Test for getting the Placeholder value")
	@Description("The test gets the value from the placeholder attribute and returns it in String format")
	void placeholder() {
		var form = PlatformApp
				.screen("Money placeholder")
				.secondLevelView("Form")
				.form("Form title");
		form.money("Custom Field")
				.checkPlaceholder(ap -> assertThat(ap).isEqualTo("100000.00"));
	}

	@Test
	@Tag("Positive")
	@DisplayName("A test to get the field color value in Hex format")
	@Description("The test gets the value from the style attribute in RGB format, and then converts it to Hex format")
	void color() {
		var form = PlatformApp
				.screen("Money color")
				.secondLevelView("Form")
				.form("Form title");
		form.money("Custom Field")
				.checkColor(color -> assertThat(color).isNull());
	}

	@Test
	@Tag("Positive")
	@DisplayName("A test to check the field for \"Read-only\"")
	@Description("The test checks for the disabled attribute")
	void readonly() {
		var form = PlatformApp
				.screen("Money readonly")
				.secondLevelView("Form")
				.form("Form title");
		form.money("Custom Field")
				.checkReadOnly(ro -> assertThat(ro).isTrue());
	}

	@Test
	@Severity(CRITICAL)
	@Tag("Positive")
	@DisplayName("A test for setting a value in a field")
	@Description("The test sets the value in the field, and then checks the value in the field with what should be set")
	void edit() {
		BigDecimal number = new BigDecimal("131343.23");
		var form = PlatformApp.screen("Money Basic")
				.secondLevelView("Form")
				.form("Form title");
		var money = form.money("Custom Field");
		money.setValue(number);
		money.checkValue(an -> assertThat(an).isEqualTo(number));

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
		var form = PlatformApp.screen("Money validation business exception")
				.secondLevelView("Form")
				.form("Form title");
		var money = form.money("Custom Field");
		money.clear();
		form.actions().action("Save").click();
		form.errorPopup()
				.checkTitleAndMessage(
						title -> assertThat(title).isEqualTo(Constants.ErrorPopup.TITLE),
						message -> assertThat(message).isEqualTo(Constants.InvalidNumberDigits))
				.close();
	}

	@Test
	@Severity(CRITICAL)
	@Tag("Negative")
	@DisplayName("Run-time exception validation test")
	@Description("The test sets the value in the field. After approval, the popup window, the title, the text in it, and the buttons are validated")
	void runtimeException() {
		var form = PlatformApp.screen("Money validation runtime exception")
				.secondLevelView("Form")
				.form("Form title");
		var money = form.money("Custom Field");
		money.clear();
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
		BigDecimal number = new BigDecimal("131343.23");
		var form = PlatformApp.screen("Money validation confirm")
				.secondLevelView("Form")
				.form("Form title");
		var money = form.money("Custom Field");
		money.setValue(number);
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
		BigDecimal number = new BigDecimal("1343.23");
		var form = PlatformApp.screen("Money validation field level annotation")
				.secondLevelView("Form")
				.form("Form title");
		var money = form.money("Custom Field");
		money.setValue(number);
		form.actions().action("Save").click();
		money.checkRequired(message -> assertThat(message).isEqualTo(Constants.InvalidNumberDigits));
	}

	@Test
	@Severity(CRITICAL)
	@Tag("Negative")
	@DisplayName("Required Message validation test for multiple fields")
	@Description("The test sets a value with the wrong data type in several fields for different widgets. After approval, it checks the text under the field, which informs about the correctness of the type of data entered")
	void fieldLevelValidation() {
		BigDecimal number = new BigDecimal("1343.23");
		var form = PlatformApp.screen("Money validation field level dynamic")
				.secondLevelView("Form")
				.form("Form title");
		var customField = form.money("Custom Field");
		var customFieldAdditional = form.money("Custom Field Additional");
		customField.setValue(number);
		customFieldAdditional.setValue(number);
		form.actions().action("Save").click();
		customField.checkRequired(message -> assertThat(message).isEqualTo(Text.textInvalidMoney("customField")));
		customFieldAdditional.checkRequired(message -> assertThat(message).isEqualTo(Text.textInvalidMoney("customFieldAdditional")));
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
		var form = PlatformApp.screen("Money required")
				.secondLevelView("Form")
				.form("Form title");
		var money = form.money("Custom Field");
		money.clear();
		form.actions().action("Save").click();
		money.checkRequired(message -> assertThat(message).isEqualTo(Constants.RequiredMessage));
	}

	@Test
	@Severity(MINOR)
	@Tag("Negative")
	@DisplayName("Currency test")
	@Description("Currency check at the field")
	void currency() {
		var form = PlatformApp.screen("Money currency const")
				.secondLevelView("Form")
				.form("Form constant currency money");
		form.money("Custom Field")
				.checkCurrencyValue(currency -> assertThat(currency).isEqualTo("₽"));
	}

	@Test
	@Severity(CRITICAL)
	@Tag("Positive")
	@DisplayName("A test for checking the possibility of an empty field")
	@Description("The test clear the value in the field , and then checks the value in the field, it must be null.")
	void nullable() {
		var form = PlatformApp.screen("Money nullable")
				.secondLevelView("Form")
				.form("Form title");
		assertThat(form.money("Custom Field")
				.clear()
				.element().getValue()).isNull();
	}
}
