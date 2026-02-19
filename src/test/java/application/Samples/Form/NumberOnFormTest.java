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

import java.math.BigDecimal;

import static io.qameta.allure.SeverityLevel.CRITICAL;
import static io.qameta.allure.SeverityLevel.MINOR;
import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("Form. Checking the basic functions for the Number in the widget Form")
@Epic("application/Samples")
@Tag("application/Samples")
@Tag("Form")

@Tag("NumberForm")
public class NumberOnFormTest extends BaseTestForSamples {

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
				.screen("Number placeholder")
				.secondLevelView("Form")
				.form("Form title");
		form.number("custom Field")
				.checkPlaceholder(pl -> assertThat(pl).isEqualTo("123456"));
	}

	@Test
	@Tag("Positive")
	@DisplayName("A test to get the field color value in Hex format")
	@Description("The test gets the value from the style attribute in RGB format, and then converts it to Hex format")
	void color() {
		var form = PlatformApp
				.screen("Number color")
				.secondLevelView("Form")
				.form("Form title");
		form.number("custom Field")
				.checkColor(color -> assertThat(color).isEqualTo("#EDA6A6"));
	}

	@Test
	@Tag("Positive")
	@DisplayName("A test to check the field for \"Read-only\"")
	@Description("The test checks for the disabled attribute")
	void readonly() {
		var form = PlatformApp
				.screen("Number readonly")
				.secondLevelView("Form")
				.form("Form title");
		form.number("custom Field")
				.checkReadOnly(ro -> assertThat(ro).isTrue());
	}

	@Test
	@Severity(CRITICAL)
	@Tag("Positive")
	@DisplayName("A test for setting a value in a field")
	@Description("The test sets the value in the field, and then checks the value in the field with what should be set")
	void edit() {
		BigDecimal number = new BigDecimal("1234.00");
		BigDecimal defaultNumber = new BigDecimal("123456.00");
		var form = PlatformApp.screen("Number basic")
				.secondLevelView("Form")
				.form("Form title");
		var numberField = form.number("custom Field");
		numberField.setValue(number)
				.checkValue(val -> assertThat(val).isEqualTo(number));
		numberField.setValue(defaultNumber);

	}

	@Test
	@Severity(CRITICAL)
	@Tag("Negative")
	@DisplayName("Business Exception Validation Test")
	@Description("The test sets the value in the field. After approval, the popup window, the title, the text in it, and the buttons are validated")
	void businessException() {
		var form = PlatformApp.screen("Number validation business exception")
				.secondLevelView("Form")
				.form("Form title");
		var numberField = form.number("custom Field");
		numberField.setValue(new BigDecimal("1234"));
		form.errorPopup()
				.checkTitle(title -> assertThat(title).isEqualTo(Constants.ErrorPopup.TITLE))
				.checkMessage(message -> assertThat(message).isEqualTo(Constants.MoreThatNumber))
				.close();
	}

	@Test
	@Severity(CRITICAL)
	@Tag("Negative")
	@DisplayName("Run-time exception validation test")
	@Description("The test sets the value in the field. After approval, the popup window, the title, the text in it, and the buttons are validated")
	void runtimeException() {
		var form = PlatformApp.screen("Number validation runtime exception")
				.secondLevelView("Form")
				.form("Form title");
		var numberField = form.number("custom Field");
		numberField.clear();
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
		var form = PlatformApp.screen("Number validation confirm")
				.secondLevelView("Form")
				.form("Form title");
		var numberField = form.number("custom Field");
		numberField.setValue(new BigDecimal("500"));
		form.actions().action("save").click();
		form.confirmPopup()
				.checkTitle(title -> assertThat(title).isEqualTo(Constants.ConfirmPopup.TITLE))
				.checkMessage(message -> assertThat(message).isEqualTo(Constants.SaveValue))
				.clickOk();
		numberField.setValue(new BigDecimal("123456"));
	}

	@Test
	@Severity(CRITICAL)
	@Tag("Negative")
	@DisplayName("Required Message validation test for one field")
	@Description("The test sets the value with the wrong data type in the field. After approval, it checks the text under the field, which informs about the correctness of the type of data entered")
	void fieldLevelValidationAnnotation() {
		var form = PlatformApp.screen("Number validation field level annotation")
				.secondLevelView("Form")
				.form("Form title");
		var numberField = form.number("Customer Field");
		numberField.setValue(new BigDecimal("123"));
		form.actions().action("Save").click();
		numberField.checkRequired(rm -> assertThat(rm).isEqualTo(Text.textInvalidNumber()));
	}

	@Test
	@Severity(CRITICAL)
	@Tag("Negative")
	@DisplayName("Required Message validation test for multiple fields")
	@Description("The test sets a value with the wrong data type in several fields for different widgets. After approval, it checks the text under the field, which informs about the correctness of the type of data entered")
	void fieldLevelValidation() {
		var form = PlatformApp.screen("Number validation field level dynamic")
				.secondLevelView("Form")
				.form("Form title");
		var customField = form.number("Custom Field");
		var customFieldAdditional = form.number("Custom Field Additional");
		customField.setValue(new BigDecimal("123"));
		customFieldAdditional.setValue(new BigDecimal("123"));
		form.actions().action("Save").click();
		customField.checkRequired(rm -> assertThat(rm).isEqualTo("The field 'customField' cannot be less than 100 000."));
		customFieldAdditional.checkRequired(rm -> assertThat(rm).isEqualTo("The field 'customFieldAdditional' cannot be less than 100 000."));
	}

	@Test
	@Severity(CRITICAL)
	@Tag("Negative")
	@DisplayName("Required Message text Verification field test")
	@Description("The test clears the field and clicks the Save button. Then validates the message that the field is required")
	void required() {
		var form = PlatformApp.screen("Number required")
				.secondLevelView("Form")
				.form("Form title");
		var numberField = form.number("custom Field");
		numberField.clear();
		form.actions().action("Save").click();
		numberField.checkRequired(rm -> assertThat(rm).isEqualTo(Constants.RequiredMessage));
	}

	@Test
	@DisplayName("Test for getting the digits value")
	void digits() {
		var form = PlatformApp.screen("Number digits")
				.secondLevelView("Form")
				.form("Form title");
//        form.field("custom Field")
//                .checkDigits(d -> assertThat(d).isEqualTo(2));
	}

	@Test
	@DisplayName("Test for checking nullable field")
	void nullable() {
		var form = PlatformApp.screen("Number nullable")
				.secondLevelView("Form")
				.form("Form title");
		form.number("Custom Field")
				.clear()
				.checkValue(val -> assertThat(val).isNull());
		form.number("Custom Field").setValue(new BigDecimal("27000"));
	}
}

//public class NumberOnFormTest extends BaseTestForSamples {
//
//    @Test
//    @Tag("Positive")
//    @DisplayName("Test for getting the Placeholder value")
//    @Description("The test gets the value from the placeholder attribute and returns it in String format")
//    void placeholder() {
//        PlatformApp.screen("Number placeholder")
//                .secondLevelView("Form")
//                .form("Form title")
//                .number("custom Field")
//                .checkPlaceholder(pl->assertThat(pl).isEqualTo("123456"));
//    }
//
//    @Test
//    @Tag("Positive")
//    @DisplayName("A test to get the field color value in Hex format")
//    @Description("The test gets the value from the style attribute in RGB format, and then converts it to Hex format")
//    void color() {
//        PlatformApp.screen("Number color")
//                .secondLevelView("Form")
//                .form("Form title")
//                .number("custom Field")
//                .checkColor(color->assertThat(color).isEqualTo("#EDA6A6"));
//    }
//
//    @Test
//    @Tag("Positive")
//    @DisplayName("A test to check the field for \"Read-only\"")
//    @Description("The test checks for the disabled attribute")
//    void readonly() {
//        PlatformApp.screen("Number readonly")
//                .secondLevelView("Form")
//                .form("Form title")
//                .number("custom Field")
//                .checkReadOnly(ro->assertThat(ro).isTrue());
//    }
//
//    @Test
//    @Severity(CRITICAL)
//    @Tag("Positive")
//    @DisplayName("A test for setting a value in a field")
//    @Description("The test sets the value in the field, and then checks the value in the field with what should be set")
//    void edit() {
//        Integer number = 1234;
//        PlatformApp.screen("Number basic")
//                .secondLevelView("Form")
//                .form("Form title")
//                .number("custom Field")
//                .setValue(number)
//                .checkValue(value->assertThat(value).isEqualTo(number));
//    }
//
//    @Disabled
//    @Test
//    @Severity(MINOR)
//    @Tag("Negative")
//    @DisplayName("Filtering test")
//    @Description("Filtering is not available for the Form widget")
//    void filtration() {
/// /        MainPages.click("Number filtration");
/// /        MainPages.FirstLevelMenu.click("Form");
/// /        FormWidget form = $box.findFormWidgetByTitle("Form title");
/// /        var customField = form.number("custom Field");
/// /        assertThatThrownBy(customField::setFiltration).isInstanceOf(UnsupportedOperationException.class);
//    }
//
//    @Disabled
//    @Test
//    @Tag("Positive")
//    @DisplayName("The DrillDown test")
//    @Description("Checking the url before the transition and after the transition/click on a special element")
//    void drillDown() {
/// /        MainPages.click("Number drilldown");
/// /        MainPages.FirstLevelMenu.click("Form");
/// /        FormWidget form = $box.findFormWidgetByTitle("Form title");
/// /        var customField = form.number("custom Field");
/// /        assertThatThrownBy(customField::drillDown).isInstanceOf(UnsupportedOperationException.class);
//    }
//
//    @Test
//    @Severity(CRITICAL)
//    @Tag("Negative")
//    @DisplayName("Business Exception Validation Test")
//    @Description("The test sets the value in the field. After approval, the popup window, the title, the text in it, and the buttons are validated")
//    void businessException() {
//        PlatformApp.screen("Number validation business exception")
//                .secondLevelView("Form")
//                .form("Form title")
//                .number("custom Field")
//                .setValue(1234).widget()
//                .errorPopup().checkTitleAndMessage(
//                        title->assertThat(title).isEqualTo(Constants.ErrorPopup.TITLE),
//                message->assertThat(message).isEqualTo(Constants.MoreThatNumber)
//                ).close();
//    }
//
//    @Test
//    @Severity(CRITICAL)
//    @Tag("Negative")
//    @DisplayName("Run-time exception validation test")
//    @Description("The test sets the value in the field. After approval, the popup window, the title, the text in it, and the buttons are validated")
//    void runtimeException() {
//        PlatformApp.screen("Number validation runtime exception")
//                .secondLevelView("Form")
//                .form("Form title")
//                .number("custom Field")
//                .clear()
//                .widget().actions().click("Save")
//                .errorPopup().checkTitleAndMessage(
//                        title->assertThat(title).isEqualTo(Constants.ErrorPopup.TITLE),
//                message->assertThat(message).isEqualTo(Constants.SystemError)
//                ).close();
//    }
//
//    @Test
//    @Severity(CRITICAL)
//    @Tag("Positive")
//    @DisplayName("Confirmation Popup Validation Test")
//    @Description("The test sets the value in the field. After approval, by clicking on the save button, the popup window, the title, the text in it, and the buttons are validated")
//    void confirm() {
//        PlatformApp.screen("Number validation confirm")
//                .secondLevelView("Form")
//                .form("Form title")
//                .number("custom Field")
//                .setValue(500)
//                .widget().actions().click("save")
//                .confirmPopup().checkTitleAndMessage(
//                        title->assertThat(title).isEqualTo(Constants.ConfirmPopup.TITLE),
//                message->assertThat(message).isEqualTo(Constants.SaveValue)
//                ).clickOk();
//    }
//
//    @Test
//    @Severity(CRITICAL)
//    @Tag("Negative")
//    @DisplayName("Required Message validation test for one field")
//    @Description("The test sets the value with the wrong data type in the field. After approval, it checks the text under the field, which informs about the correctness of the type of data entered")
//    void fieldLevelValidationAnnotation() {
//        PlatformApp.screen("Number validation field level annotation")
//                .secondLevelView("Form")
//                .form("Form title")
//                .number("Customer Field")
//                .setValue(123)
//                .widget().actions().click("Save")
//                .number("Customer Field").checkRequired(rm->assertThat(rm).isEqualTo(Text.textInvalidNumber()));
//    }
//
//    @Test
//    @Severity(CRITICAL)
//    @Tag("Negative")
//    @DisplayName("Required Message validation test for multiple fields")
//    @Description("The test sets a value with the wrong data type in several fields for different widgets. After approval, it checks the text under the field, which informs about the correctness of the type of data entered")
//    void fieldLevelValidation() {
//        PlatformApp.screen("Number validation field level dynamic")
//                .secondLevelView("Form")
//                .form("Form title")
//                .number("Custom Field").setValue(123)
//                .widget()
//                .number("Custom Field Additional").setValue(123)
//                .widget().actions().click("Save")
//                .number("Custom Field").checkRequired(rm->assertThat(rm).isEqualTo("The field 'customField' cannot be less than 100 000."))
//                .widget()
//                .number("Custom Field Additional").checkRequired(rm->assertThat(rm).isEqualTo("The field 'customFieldAdditional' cannot be less than 100 000."));
//
//        ;
//    }
//
//    @Disabled
//    @Test
//    @Severity(MINOR)
//    @Tag("Negative")
//    @DisplayName("Sorting test")
//    @Description("Sorting is not available for the Form widget")
//    void sorting() {
/// /        MainPages.click("Number sorting");
/// /        MainPages.FirstLevelMenu.click("Form");
/// /        FormWidget form = $box.findFormWidgetByTitle("Form title");
/// /        var customField = form.number("custom Field");
/// /        assertThatThrownBy(customField::setSorting).isInstanceOf(UnsupportedOperationException.class);
//    }
//
//    @Test
//    @Severity(CRITICAL)
//    @Tag("Negative")
//    @DisplayName("Required Message text Verification field test")
//    @Description("The test clears the field and clicks the Save button. Then validates the message that the field is required")
//    void required() {
//        PlatformApp.screen("Number required")
//                .secondLevelView("Form")
//                .form("Form title")
//                .number("custom Field")
//                .clear()
//                .widget().actions().click("Save")
//                .number("custom Field").checkRequired(rm->assertThat(rm).isEqualTo(Constants.RequiredMessage));
//    }
//
//@Disabled
//    @Test
//    void digits() {
/// /        MainPages.click("Number digits");
/// /        MainPages.FirstLevelMenu.click("Form");
/// /        FormWidget form = $box.findFormWidgetByTitle("Form title");
/// /        var customField = form.numberDigits("custom Field");
/// /        assertThat(customField.getDigits()).isEqualTo(2);
/// /        PlatformApp.screen("Number digits")
/// /                .secondLevelView("Form")
/// /                .form("Form title")
/// /                .number("custom Field")
/// /                .
//    }
//
//    @Disabled
//    @Test
//    void nullable() {
////        MainPages.click("Number nullable");
////        MainPages.FirstLevelMenu.click("Form");
////        FormWidget form = $box.findFormWidgetByTitle("Form title");
////        var customField = form.number("Custom Field");
////        customField.clear();
////        assertThat(customField.getStrValue()).isBlank();
//    }
//}
