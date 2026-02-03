package sample.list;

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
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static io.qameta.allure.SeverityLevel.CRITICAL;
import static io.qameta.allure.SeverityLevel.MINOR;
import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("List. Checking the basic functions for the Number in the widget List")
@Epic("Samples")
@Tag("Samples")
@Tag("List")
@Tag("NumberList")
public class NumberOnListTest extends BaseTestForSamples {

	@Disabled("Checked at filtration and sorting")
	@Test
	@Severity(CRITICAL)
	@Tag("Positive")
	@DisplayName("A test for checking a value in a field")
	@Description("The test gets the value in the field, and then checks the value in the field with what should be.")
	void read() {
//        var list = PlatformApp.screen("Number basic")
//              .secondLevelView("List")
//              .listInline("List title");
//        var row = list.rows().row(0);
//        row.number("custom Field")
//              .checkValue(value -> assertThat(value).isEqualTo(123456));
	}

	@Test
	@Tag("Positive")
	@DisplayName("Test for getting the Placeholder value")
	@Description("The test gets the value from the placeholder attribute and returns it in String format")
	void placeholder() {
		var list = PlatformApp.screen("Number placeholder")
				.secondLevelView("List")
				.listInline("List title");
		var row = list.rows().clickRow(0);
		row.number("custom Field")
				.checkPlaceholder(pl -> assertThat(pl).isEqualTo("123456"));
	}

	@Test
	@Tag("Positive")
	@DisplayName("A test to get the field color value in Hex format")
	@Description("The test gets the value from the style attribute in RGB format, and then converts it to  Hex format")
	void color() {
		var list = PlatformApp.screen("Number color")
				.secondLevelView("List")
				.listInline("List title");
		var row = list.rows().row(0);
		row.number("custom Field")
				.checkColor(color -> assertThat(color).isEqualTo("#EDA6A6"));
	}

	@Test
	@Tag("Positive")
	@DisplayName("A test to check the field for \"Read-only\"")
	@Description("The test checks for the disabled attribute.")
	void readonly() {
		var list = PlatformApp.screen("Number readonly")
				.secondLevelView("List")
				.listInline("List title");
		var row = list.rows().clickRow(0);
		row.number("custom Field")
				.checkReadOnly(ro -> assertThat(ro).isTrue());
	}

	@Test
	@Severity(CRITICAL)
	@Tag("Positive")
	@DisplayName("A test for setting a value in a field")
	@Description("The test sets the value in the field, and then checks the value in the field with what should be set.")
	void edit() {
		BigDecimal number = new BigDecimal(1234);
		var list = PlatformApp.screen("Number basic")
				.secondLevelView("List")
				.listInline("List title");
		var row = list.rows().clickRow(0);
		row.number("custom Field")
				.setValue(number)
				.checkValue(value -> assertThat(value).isEqualTo(number));
	}

	@Test
	@Severity(MINOR)
	@Tag("Negative")
	@DisplayName("Filtering test")
	@Description("Filtering by the specified column.")
	void filtration() {
		var list = PlatformApp.screen("Number filtration")
				.secondLevelView("List")
				.listInline("List title");
		list.headers().filter(fb -> fb.numberFromTo("custom Field", new BigDecimal(234000), new BigDecimal(235000)));

		var values = list.rows().streamCurrentPage()
				.map(r -> r.number("custom Field").getValue())
				.collect(Collectors.toList());
		assertThat(values).isEqualTo(List.of(new BigDecimal(234567), new BigDecimal(234567)));
	}

	@Test
	@Tag("Positive")
	@DisplayName("The DrillDown test")
	@Description("Checking the url before the transition and after the transition/click on a special element")
	void drillDown() {
		var list = PlatformApp.screen("Number drilldown")
				.secondLevelView("List")
				.listInline("List title");
		var row = list.rows().row(0);
		row.number("custom Field")
				.checkDrillDownSupported(ro -> assertThat(ro).isTrue());
	}

	@Test
	@Severity(CRITICAL)
	@Tag("Negative")
	@DisplayName("Business Exception Validation Test")
	@Description("The test sets the value in the field. After approval, the popup window, the title, the text in it, and the buttons are validated.")
	void businessException() {
		var list = PlatformApp.screen("Number validation business exception")
				.secondLevelView("List")
				.listInline("List title");
		var row = list.rows().clickRow(0);
		row.number("custom Field").setValue(new BigDecimal(1234));
		list.errorPopup()
				.checkTitleAndMessage(
						title -> assertThat(title).isEqualTo(Constants.ErrorPopup.TITLE),
						message -> assertThat(message).isEqualTo(Constants.MoreThatNumber))
				.close();
	}

	@Test
	@Severity(CRITICAL)
	@Tag("Negative")
	@DisplayName("Run-time exception validation test")
	@Description("The test sets the value in the field. After approval, the popup window, the title, the text in it, and the buttons are validated.")
	void runtimeException() {
		var list = PlatformApp.screen("Number validation runtime exception")
				.secondLevelView("List")
				.listInline("List title");
		var row = list.rows().clickRow(0);
		row.number("custom Field").clear();
		row.burgerActionClick("Save");
		list.errorPopup()
				.checkTitleAndMessage(
						title -> assertThat(title).isEqualTo(Constants.ErrorPopup.TITLE),
						message -> assertThat(message).isEqualTo(Constants.SystemError))
				.close();
	}

	@Test
	@Severity(CRITICAL)
	@Tag("Positive")
	@DisplayName("Confirmation Popup Validation Test")
	@Description("The test sets the value in the field. After approval, by clicking on the save button, the popup window, the title, the text in it, and the buttons are validated.")
	void confirm() {
		var list = PlatformApp.screen("Number validation confirm")
				.secondLevelView("List")
				.listInline("List title");
		var row = list.rows().clickRow(0);
		row.burgerAction("save").click();
		list.confirmPopup()
				.checkTitleAndMessage(
						title -> assertThat(title).isEqualTo(Constants.ConfirmPopup.TITLE),
						message -> assertThat(message).isEqualTo(Constants.SaveValue))
				.clickOk();
	}

	@Test
	@Severity(CRITICAL)
	@Tag("Negative")
	@DisplayName("Required Message validation test for one field")
	@Description("The test sets the value with the wrong data type in the field. After approval, it checks the text under the field, which informs about the correctness of the type of data entered.")
	void fieldLevelValidationAnnotation() {
		var list = PlatformApp.screen("Number validation field level annotation")
				.secondLevelView("List")
				.listInline("List title");
		var row = list.rows().clickRow(0);
		row.number("Customer Field").setValue(new BigDecimal(123));
		row.burgerAction("Save").click();
		list.rows().row(0)
				.number("Customer Field")
				.checkRequired(message -> assertThat(message).isEqualTo(Constants.InvalidNumber));
	}

	@Test
	@Severity(CRITICAL)
	@Tag("Negative")
	@DisplayName("Required Message validation test for multiple fields")
	@Description("The test sets a value with the wrong data type in several fields for different widgets. After approval, it checks the text under the field, which informs about the correctness of the type of data entered")
	void fieldLevelValidation() {
		var list = PlatformApp.screen("Number validation field level dynamic")
				.secondLevelView("List")
				.listInline("List title");
		var row = list.rows().clickRow(0);
		var customField = row.number("Custom Field");
		var customFieldAdditional = row.number("Custom Field Additional");
		customField.setValue(new BigDecimal(123));
		customFieldAdditional.setValue(new BigDecimal(123));
		row.burgerAction("Save").click();
		var editRow = list.rows().row(0);
		editRow.number("Custom Field")
				.checkRequired(message -> assertThat(message).isEqualTo("The field 'customField' cannot be less than 100 000."));
		editRow.number("Custom Field Additional")
				.checkRequired(message -> assertThat(message).isEqualTo("The field 'customFieldAdditional' cannot be less than 100 000."));
	}

	@Test
	@Severity(MINOR)
	@Tag("Negative")
	@DisplayName("Sorting test")
	@Description("Sorting by the specified column.")
	void sorting() {
		var list = PlatformApp.screen("Number sorting")
				.secondLevelView("List")
				.listInline("List title");
		var valuesBefore = list.rows().streamCurrentPage()
				.map(r -> r.number("custom Field").getValue())
				.collect(Collectors.toList());
		var expected = new ArrayList<>(List.of(new BigDecimal(456789), new BigDecimal(123456), new BigDecimal(234567)));
		assertThat(valuesBefore).isEqualTo(expected);
		list.headers().sort(sb -> sb.sort("custom Field"));
		var valuesDesc = list.rows().streamCurrentPage()
				.map(r -> r.number("custom Field").getValue())
				.collect(Collectors.toList());
		expected.sort(Comparator.reverseOrder());
		assertThat(valuesDesc).isEqualTo(expected);

		list.headers().sort(sb -> sb.sort("custom Field"));
		var valuesAsc = list.rows().streamCurrentPage()
				.map(r -> r.number("custom Field").getValue())
				.collect(Collectors.toList());
		expected.sort(Comparator.naturalOrder());
		assertThat(valuesAsc).isEqualTo(expected);
	}

	@Test
	@Severity(CRITICAL)
	@Tag("Negative")
	@DisplayName("Required Message text Verification field test")
	@Description("The test clears the field and clicks the Save button. Then validates the message that the field is required.")
	void required() {
		var list = PlatformApp.screen("Number required")
				.secondLevelView("List")
				.listInline("List title");
		var row = list.rows().clickRow(0);
		row.number("custom Field").clear();
		row.burgerAction("Save").click();
		list.rows().row(0)
				.number("custom Field")
				.checkRequired(message -> assertThat(message).isEqualTo(Constants.RequiredMessage));
	}

	@Test
	@Severity(MINOR)
	@Tag("Positive")
	@DisplayName("A test for setting a number with a fractional part in a field")
	@Description("The test sets the value in the field, and then checks the value in the field with what should be set.")
	void digits() {
		var list = PlatformApp.screen("Number digits")
				.secondLevelView("List")
				.listInline("List title");
		var row = list.rows().clickRow(0);
		row.number("custom Field")
				.checkDigits(digits -> assertThat(digits).isEqualTo(2));
	}

	@Test
	@Severity(MINOR)
	@Tag("Negative")
	@DisplayName("A test for checking the possibility of an empty field")
	@Description("The test clear the value in the field , and then checks the value in the field, it must be null.")
	void nullable() {
		var list = PlatformApp.screen("Number nullable")
				.secondLevelView("List")
				.listInline("List title");
		var row = list.rows().clickRow(0);
		row.number("Custom Field")
				.setValue(null)
				.checkValue(value -> assertThat(value).isNull());
	}
}
