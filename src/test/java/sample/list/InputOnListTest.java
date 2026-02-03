package sample.list;

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

import java.util.List;
import java.util.stream.Collectors;

import static io.qameta.allure.SeverityLevel.CRITICAL;
import static io.qameta.allure.SeverityLevel.MINOR;
import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("List. Checking the basic functions for the Input in the widget List")
@Epic("Samples")
@Tag("Samples")
@Tag("List")
public class InputOnListTest extends BaseTestForSamples {

	@Disabled("Checked at filtration and sorting")
	@Test
	@Severity(CRITICAL)
	@Tag("Positive")
	@DisplayName("A test for checking a value in a field")
	@Description("The test gets the value in the field, and then checks the value in the field with what should be.")
	void read() {
//        MainPages.click("Input basic");
//        MainPages.FirstLevelMenu.click("List");
//        var list = $box.findListWidgetByTitle("List");
//        List<String> listRows = list.getNoFocusValues("customField");
//        var customField = list.findRowSegmentByValue("customField", listRows.get(0)).input();
//        assertThat(customField.compareRows("test data")).isTrue();
		var list = PlatformApp.screen("Input basic")
				.secondLevelView("List")
				.listInline("List");
		var customField = list.rows().row(0).input("customField");
		customField.checkValue(value -> assertThat(value).isEqualTo("test data"));
	}

	@Test
	@Tag("Positive")
	@DisplayName("Test for getting the Placeholder value")
	@Description("The test gets the value from the placeholder attribute and returns it in String format")
	void placeholder() {
		var list = PlatformApp.screen("Input placeholder")
				.secondLevelView("List")
				.listInline("List");
		var row = list.rows().clickRow(0);
		row.input("customField")
				.checkPlaceholder(pl -> assertThat(pl).isEqualTo("Placeholder text"));
	}

	@Test
	@Tag("Positive")
	@DisplayName("A test to get the field color value in Hex format")
	@Description("The test gets the value from the style attribute in RGB format, and then converts it to Hex format")
	void color() {
		var list = PlatformApp.screen("Input color")
				.secondLevelView("List")
				.listInline("List");
		var row = list.rows().row(0);
		row.input("customField")
				.checkColor(color -> assertThat(color).isEqualTo("#EDA6A6"));
	}

	@Test
	@Tag("Positive")
	@DisplayName("A test to check the field for \"Read-only\"")
	@Description("The test checks for the disabled attribute.")
	void readonly() {
		var list = PlatformApp.screen("Input readonly")
				.secondLevelView("List")
				.listInline("List");
		var row = list.rows().clickRow(0);
		row.input("customField")
				.checkReadOnly(ro -> assertThat(ro).isTrue());
	}

	@Test
	@Severity(CRITICAL)
	@Tag("Positive")
	@DisplayName("A test for setting a value in a field")
	@Description("The test sets the value in the field, and then checks the value in the field with what should be set.")
	void edit() {
		var list = PlatformApp.screen("Input basic")
				.secondLevelView("List")
				.listInline("List");
		var row = list.rows().clickRow(0);
		row.input("customField")
				.setValue("57")
				.checkValue(val -> assertThat(val).isEqualTo("57"));
	}

	@Test
	@Severity(MINOR)
	@Tag("Negative")
	@DisplayName("Filtering test")
	@Description("Filtering by the specified column.")
	void filtration() {
		var list = PlatformApp.screen("Input filtration")
				.secondLevelView("List")
				.listInline("List");
		list.headers().filter(fb -> fb.input("customField", "Test data2"));
		var actualData = list.rows().streamAllPages()
				.map(r -> r.input("customField").getValue())
				.collect(Collectors.toList());
		assertThat(actualData).isEqualTo(List.of("Test data2"));
	}

	@Test
	@Tag("Positive")
	@DisplayName("The DrillDown test")
	@Description("Checking the url before the transition and after the transition/click on a special element")
	void drillDown() {
		var list = PlatformApp.screen("Input drilldown")
				.secondLevelView("List")
				.listInline("List");
		var row = list.rows().row(0);
		row.input("customField")
				.drilldown(url -> assertThat(url).contains("/screen/InputDrilldown/view/InputDrilldownform/InputDrilldown/"));
	}

	@Test
	@Severity(CRITICAL)
	@Tag("Negative")
	@DisplayName("Business Exception Validation Test")
	@Description("The test sets the value in the field. After approval, the popup window, the title, the text in it, and the buttons are validated.")
	void businessException() {
		var list = PlatformApp.screen("Input validation business exception")
				.secondLevelView("List")
				.listInline("List");
		var row = list.rows().clickRow(0);
		row.input("customField").setValue("5700");
		list.errorPopup()
				.checkTitleAndMessage(
						title -> assertThat(title).isEqualTo(Constants.ErrorPopup.TITLE),
						message -> assertThat(message).isEqualTo(Constants.OnlyLetters))
				.close();
	}

	@Test
	@Severity(CRITICAL)
	@Tag("Negative")
	@DisplayName("Run-time exception validation test")
	@Description("The test sets the value in the field. After approval, the popup window, the title, the text in it, and the buttons are validated.")
	void runtimeException() {
		var list = PlatformApp.screen("Input validation runtime exception")
				.secondLevelView("List")
				.listInline("List");
		var row = list.rows().clickRow(0);
		row.input("customField").setValue("1234");
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
		var list = PlatformApp.screen("Input validation confirm")
				.secondLevelView("List")
				.listInline("List");
		var row = list.rows().clickRow(0);
		row.input("customField").setValue("5700");
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
		var list = PlatformApp.screen("Input validation field level annotation")
				.secondLevelView("List")
				.listInline("List title");
		var row = list.rows().clickRow(0);
		row.input("Custom Field ").setValue("123");
		row.burgerAction("Save").click();
		list.rows().row(0)
				.input("Custom Field ")
				.checkRequired(message -> assertThat(message).isEqualTo(Constants.OnlyLetters));
	}

	@Test
	@Severity(CRITICAL)
	@Tag("Negative")
	@DisplayName("Required Message validation test for multiple fields")
	@Description("The test sets a value with the wrong data type in several fields for different widgets. After approval, it checks the text under the field, which informs about the correctness of the type of data entered")
	void fieldLevelValidation() {
		var list = PlatformApp.screen("Input validation field level dynamic")
				.secondLevelView("List")
				.listInline("List title");
		var row = list.rows().clickRow(0);
		var customField = row.input("Custom Field");
		var customFieldAdditional = row.input("Custom Field Additional");
		customField.setValue("123");
		customFieldAdditional.setValue("123");
		row.burgerAction("Save").click();
		customField.checkRequired(rm -> assertThat(rm).isEqualTo(Text.textOnlyLetters("customField")));
		customFieldAdditional.checkRequired(rm -> assertThat(rm).isEqualTo(Text.textOnlyLetters("customFieldAdditional")));
	}

	@Test
	@Severity(MINOR)
	@Tag("Negative")
	@DisplayName("Sorting test")
	@Description("Sorting by the specified column.")
	void sorting() {
		List<String> expectedValue = List.of("A2 row", "A1 row", "Acb row", "Abc row", "2 row", "1 row");
		var list = PlatformApp.screen("Input sorting")
				.secondLevelView("List")
				.listInline("List");
		var headers = list.headers();
		var actualData = list.rows().streamAllPages()
				.map(r -> r.input("customField").getValue())
				.collect(Collectors.toList());
		assertThat(actualData).isEqualTo(expectedValue);

		headers.sort(sb -> sb.sort("customField"));
		expectedValue = List.of("Acb row", "Abc row", "A2 row", "A1 row", "2 row", "1 row");
		assertThat(list.rows().streamAllPages()
				.map(r -> r.input("customField").getValue())
				.collect(Collectors.toList())).isEqualTo(expectedValue);

		headers.sort(sb -> sb.sort("customField"));
		expectedValue = List.of("1 row", "2 row", "A1 row", "A2 row", "Abc row", "Acb row");
		assertThat(list.rows().streamAllPages()
				.map(r -> r.input("customField").getValue())
				.collect(Collectors.toList())).isEqualTo(expectedValue);
	}


	@Test
	void checkFilterOrSort() {
//		var list = PlatformApp.screen("Input filtration")
//				.secondLevelView("List")
//				.listInline("List");
//		assertThat(list.checkFilterColumn("customField")).isTrue();
//		assertThat(list.checkSorting("brand")).isFalse();
	}

	@Test
	@Severity(CRITICAL)
	@Tag("Negative")
	@DisplayName("Required Message text Verification field test")
	@Description("The test clears the field and clicks the Save button. Then validates the message that the field is required.")
	void required() {
		var list = PlatformApp.screen("Input required")
				.secondLevelView("List")
				.listInline("List");
		var row = list.rows().clickRow(0);
		var customField = row.input("customField");
		customField.clear();
		row.burgerAction("Save").click();
		customField.checkRequired(rm -> assertThat(rm).isEqualTo(Constants.RequiredMessage));
	}

	@Test
	@Severity(MINOR)
	@Tag("Positive")
	@DisplayName("Max input test")
	@Description("Test check max input at the field")
	void maxInput() {
		var list = PlatformApp.screen("Input maxInput")
				.secondLevelView("List")
				.listInline("List title");
		var row = list.rows().clickRow(0);
		var input = row.input("Custom Field");
		input.clear();
		input.setValue("td");
		input.checkMaxInput(maxLen -> assertThat(maxLen).isEqualTo(2));
	}
}
