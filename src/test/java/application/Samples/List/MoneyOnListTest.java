package application.Samples.List;

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
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static io.qameta.allure.SeverityLevel.CRITICAL;
import static io.qameta.allure.SeverityLevel.MINOR;
import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("List. Checking the basic functions for the Money in the widget List")
@Epic("Samples")
@Tag("Samples")
@Tag("List")
public class MoneyOnListTest extends BaseTestForSamples {

	@Disabled("Checked at filtration and sorting")
	@Test
	@Severity(CRITICAL)
	@Tag("Positive")
	@DisplayName("A test for checking a value in a field")
	@Description("The test gets the value in the field, and then checks the value in the field with what should be.")
	void read() {
//        BigDecimal value = new BigDecimal("27000.78");
//        PlatformApp.screen("Money basic")
//              .secondLevelView("List")
//              .listInline("List title")
//              .rows().row(0).money("Custom Field")
//              .checkValue(av->assertThat(av).isEqualTo(value));
	}

	@Disabled
	@Test
	@Severity(MINOR)
	@Tag("Negative")
	@DisplayName("Currency test")
	@Description("Currency by the specified column.")
	void currency() {
//        MainPages.click("Money currency const");
//        MainPages.FirstLevelMenu.click("List");
//        var list = $box.findListWidgetByTitle("List constant currency money");
//        assertThat(list.getListRows().get(0)).contains("₽");
	}

	@Test
	@Tag("Positive")
	@DisplayName("Test for getting the Placeholder value")
	@Description("The test gets the value from the placeholder attribute and returns it in String format")
	void placeholder() {
		var list = PlatformApp.screen("Money placeholder")
				.secondLevelView("List")
				.listInline("List title");
		var row = list.rows().clickRow(0);
		row.money("Custom Field")
				.checkPlaceholder(av -> assertThat(av).isEqualTo("100000.00"));
	}

	@Test
	@Tag("Positive")
	@DisplayName("A test to get the field color value in Hex format")
	@Description("The test gets the value from the style attribute in RGB format, and then converts it to Hex format")
	void color() {
		var list = PlatformApp.screen("Money color")
				.secondLevelView("List")
				.listInline("List title");
		var row = list.rows().row(0);
		row.money("Custom Field")
				.checkColor(ac -> assertThat(ac).isEqualTo("#EDA6A6"));
	}

	@Test
	@Tag("Positive")
	@DisplayName("A test to check the field for \"Read-only\"")
	@Description("The test checks for the disabled attribute.")
	void readonly() {
		var list = PlatformApp.screen("Money readonly")
				.secondLevelView("List")
				.listInline("List title");
		var row = list.rows().clickRow(0);
		row.money("Custom Field")
				.checkReadOnly(ro -> assertThat(ro).isTrue());
	}

	@Test
	@Severity(CRITICAL)
	@Tag("Positive")
	@DisplayName("A test for setting a value in a field")
	@Description("The test sets the value in the field, and then checks the value in the field with what should be set.")
	void edit() {
		BigDecimal number = new BigDecimal("131343.23");
		var list = PlatformApp.screen("Money basic")
				.secondLevelView("List")
				.listInline("List title");
		var row = list.rows().clickRow(0);
		row.money("Custom Field")
				.setValue(number)
				.checkValue(av -> assertThat(av).isEqualTo(number));
	}

	@Test
	@Severity(MINOR)
	@Tag("Negative")
	@DisplayName("Filtering test")
	@Description("Filtering by the specified column.")
	void filtration() {
		BigDecimal from = new BigDecimal("34000.00");
		BigDecimal to = new BigDecimal("35567.00");
		var list = PlatformApp.screen("Money filtration")
				.secondLevelView("List")
				.listInline("List title");
		list.headers().filter(fb -> fb.moneyFromTo("Custom Field", from, to));
		var actualValue = list.rows().streamAllPages()
				.map(row -> row.money("Custom Field").getValue())
				.collect(Collectors.toList());
		assertThat(actualValue).isEqualTo(List.of(new BigDecimal("34567.00")));
	}

	@Test
	@Tag("Positive")
	@DisplayName("The DrillDown test")
	@Description("Checking the url before the transition and after the transition/click on a special element")
	void drillDown() {
		var list = PlatformApp.screen("Money drilldown")
				.secondLevelView("List")
				.listInline("List title");
		var row = list.rows().row(0);
		row.money("Custom Field")
				.drilldown(url -> assertThat(url).contains("myexample62/view/myexample62form/myExampleBc62"));
	}

	@Test
	@Severity(CRITICAL)
	@Tag("Negative")
	@DisplayName("Business Exception Validation Test")
	@Description("The test sets the value in the field. After approval, the popup window, the title, the text in it, and the buttons are validated.")
	void businessException() {
		BigDecimal number = new BigDecimal("34567.00");
		var list = PlatformApp.screen("Money validation business exception")
				.secondLevelView("List")
				.listInline("List title");
		var row = list.rows().clickRow(0);
		row.money("Custom Field").setValue(number);
		list.errorPopup()
				.checkTitleAndMessage(
						title -> assertThat(title).isEqualTo(Constants.ErrorPopup.TITLE),
						message -> assertThat(message).isEqualTo(Constants.InvalidNumberDigits))
				.close();
	}

	@Test
	@Severity(CRITICAL)
	@Tag("Negative")
	@DisplayName("Run-time exception validation test")
	@Description("The test sets the value in the field. After approval, the popup window, the title, the text in it, and the buttons are validated.")
	void runtimeException() {
		BigDecimal number = new BigDecimal("34567.00");
		var list = PlatformApp.screen("Money validation runtime exception")
				.secondLevelView("List")
				.listInline("List title");
		var row = list.rows().clickRow(0);
		row.money("Custom Field").setValue(number);
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
		BigDecimal number = new BigDecimal("12313.12");
		var list = PlatformApp.screen("Money validation confirm")
				.secondLevelView("List")
				.listInline("List title");
		var row = list.rows().clickRow(0);
		row.money("Custom Field").setValue(number);
		row.burgerAction("save").click();
		list.confirmPopup()
				.checkTitleAndMessage(
						title -> assertThat(title).isEqualTo(Constants.ConfirmPopup.TITLE),
						message -> assertThat(message).isEqualTo(Constants.SaveValue))
				.close();
	}

	@Test
	@Severity(CRITICAL)
	@Tag("Negative")
	@DisplayName("Required Message validation test for one field")
	@Description("The test sets the value with the wrong data type in the field. After approval, it checks the text under the field, which informs about the correctness of the type of data entered.")
	void fieldLevelValidationAnnotation() {
		BigDecimal number = new BigDecimal("1343.23");
		var list = PlatformApp.screen("Money validation field level annotation")
				.secondLevelView("List")
				.listInline("List title");
		var row = list.rows().clickRow(0);
		row.money("Custom Field").setValue(number);
		row.burgerAction("Save").click();
		list.rows().row(0)
				.money("Custom Field")
				.checkRequired(rm -> assertThat(rm).isEqualTo(Constants.InvalidNumberDigits));
	}

	@Test
	@Severity(CRITICAL)
	@Tag("Negative")
	@DisplayName("Required Message validation test for multiple fields")
	@Description("The test sets a value with the wrong data type in several fields for different widgets. After approval, it checks the text under the field, which informs about the correctness of the type of data entered")
	void fieldLevelValidation() {
		BigDecimal number = new BigDecimal("1343.23");
		var list = PlatformApp.screen("Money validation field level dynamic")
				.secondLevelView("List")
				.listInline("List title");
		var row = list.rows().clickRow(0);
		var customField = row.money("Custom Field");
		var customFieldAdditional = row.money("Custom Field Additional");
		customField.setValue(number);
		customFieldAdditional.setValue(number);
		row.burgerAction("Save").click();
		customField.checkRequired(rm -> assertThat(rm).isEqualTo(Text.textInvalidMoney("customField")));
		customFieldAdditional.checkRequired(rm -> assertThat(rm).isEqualTo(Text.textInvalidMoney("customFieldAdditional")));
	}

	@Test
	@Severity(MINOR)
	@Tag("Negative")
	@DisplayName("Sorting test")
	@Description("Sorting by the specified column.")
	void sorting() {
		List<BigDecimal> expectedValue = Stream.of("11001.00", "89000.22", "45500.00", "27000.78")
				.map(BigDecimal::new)
				.collect(Collectors.toList());
		var list = PlatformApp.screen("Money sorting")
				.secondLevelView("List")
				.listInline("List title");
		var headers = list.headers();
		var actualData = list.rows().streamAllPages()
				.map(r -> r.money("Custom Field").getValue())
				.collect(Collectors.toList());
		assertThat(actualData).isEqualTo(expectedValue);

		headers.sort(sb -> sb.sort("Custom Field"));
		expectedValue.sort(Comparator.reverseOrder());
		assertThat(list.rows().streamAllPages()
				.map(r -> r.money("Custom Field").getValue())
				.collect(Collectors.toList())).isEqualTo(expectedValue);

		headers.sort(sb -> sb.sort("Custom Field"));
		expectedValue.sort(Comparator.naturalOrder());
		assertThat(list.rows().streamAllPages()
				.map(r -> r.money("Custom Field").getValue())
				.collect(Collectors.toList())).isEqualTo(expectedValue);
	}

	@Test
	@Severity(CRITICAL)
	@Tag("Negative")
	@DisplayName("Required Message text Verification field test")
	@Description("The test clears the field and clicks the Save button. Then validates the message that the field is required.")
	void required() {
		var list = PlatformApp.screen("Money required")
				.secondLevelView("List")
				.listInline("List title");
		var row = list.rows().clickRow(0);
		row.money("Custom Field").clear();
		row.burgerAction("Save").click();
		list.rows().row(0)
				.money("Custom Field")
				.checkRequired(rm -> assertThat(rm).isEqualTo(Constants.RequiredMessage));
	}

	@Test
	@Severity(MINOR)
	@Tag("Negative")
	@DisplayName("A test for checking the possibility of an empty field")
	@Description("The test clear the value in the field , and then checks the value in the field, it must be null.")
	void nullable() {
		BigDecimal number = new BigDecimal("1343.23");
		var list = PlatformApp.screen("Money nullable")
				.secondLevelView("List")
				.listInline("List title");
		var row = list.rows().clickRow(0);
		var money = row.money("Custom Field");
		money.setValue(number);
		row.burgerAction("Save").click();
		list.rows().clickRow(0);
		money.clear();
		row.burgerAction("Save").click();
		list.rows().row(0)
				.money("Custom Field")
				.checkValue(val -> assertThat(val).isNull());
		list.rows().clickRow(0);
		money.setValue(number);
		row.burgerAction("Save").click();
	}
}
