package application.Samples.List;

import application.common.Text;
import application.config.BaseTestForSamples;
import core.config.Constants;
import core.element.PlatformApp;
import core.element.widget.field.type.inlinePickList.InlinePickList;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Severity;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static io.qameta.allure.SeverityLevel.CRITICAL;
import static io.qameta.allure.SeverityLevel.MINOR;
import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("List. Checking the basic functions for the InlinePickList in the widget List")
@Epic("Samples")
@Tag("Samples")
@Tag("List")
public class InlinePickListOnListTest extends BaseTestForSamples {

	@Test
	@Tag("Positive")
	@DisplayName("Test for getting the Placeholder value")
	@Description("The test gets the value from the placeholder attribute and returns it in String format")
	void placeholder() {
		PlatformApp.screen("InlinePickList placeholder")
				.secondLevelView("List")
				.listInline("List title")
				.rows().clickRow(0)
				.inlinePickList("Custom Field")
				.checkPlaceholder(placeholder -> assertThat(placeholder).isEqualTo("Placeholder text"));
	}

	@Test
	@Tag("Positive")
	@DisplayName("A test to get the field color value in Hex format")
	@Description("The test gets the value from the style attribute in RGB format, and then converts it to Hex format")
	void color() {

		PlatformApp.screen("InlinePickList color")
				.secondLevelView("List")
				.listInline("List title")
				.rows().row(0)
				.inlinePickList("Custom Field")
				.checkColor(color -> assertThat(color).isEqualTo("#EDA6A6"));
	}

	@Test
	@Tag("Positive")
	@DisplayName("A test to check the field for \"Read-only\"")
	@Description("The test checks for the disabled attribute.")
	void readonly() {
//        MainPages.click("InlinePickList readonly");
//        MainPages.FirstLevelMenu.click("List");
//        var list = $box.findListWidgetByTitle("List title");
//        List<String> listRows = list.getNoFocusValues("Custom Field");
//        var customField = list.findRowSegmentByValue("Custom Field", listRows.get(0)).inlinePickList();
//        assertThat(customField.getReadOnly()).isTrue();

		var platformListWidgetInline = PlatformApp.screen("InlinePickList readonly")
				.secondLevelView("List")
				.listInline("List title");
		var rows = platformListWidgetInline.rows();

		rows.clickRow(0)
				.inlinePickList("Custom Field")
				.checkReadOnly(readonly -> assertThat(readonly).isTrue());
	}


	@Test
	@Severity(CRITICAL)
	@Tag("Positive")
	@DisplayName("A test for checking a value in a field")
	@Description("The test gets the value in the field, and then checks the value in the field with what should be.")
	@Disabled("Checked at filtration and sorting")
	void read() {
		PlatformApp.screen("InlinePickList basic")
				.secondLevelView("List")
				.listInline("List title")
				.rows().clickRow(0)
				.inlinePickList("Custom Field")
				.checkValue(value -> assertThat(value).isEqualTo("Abs data"));
	}

	@Test
	@Severity(CRITICAL)
	@Tag("Positive")
	@DisplayName("A test for setting a value in a field")
	@Description("The test sets the value in the field, and then checks the value in the field with what should be set.")
	void edit() {
//        MainPages.click("InlinePickList basic");
//        MainPages.FirstLevelMenu.click("List");
//        var list = $box.findListWidgetByTitle("List title");
//        List<String> listRows = list.getNoFocusValues("Custom Field");
//        var customField = list.findRowSegmentByValue("Custom Field", listRows.get(0)).inlinePickList();
//        customField.setValue("39 Test data new information");
//        assertThat(customField.getValue()).isEqualTo("39 Test data new information");

		PlatformApp.screen("InlinePickList basic")
				.secondLevelView("List")
				.listInline("List title")
				.rows().clickRow(0)
				.inlinePickList("Custom Field")
				.setValue("39 Test data new information")
				.checkValue(value -> assertThat(value).isEqualTo("39 Test data new information"));
	}

	@Test
	@Severity(MINOR)
	@Tag("Negative")
	@DisplayName("Filtering test")
	@Description("Filtering by the specified column.")
	void filtration() {
//        MainPages.click("InlinePickList filtration");
//        MainPages.FirstLevelMenu.click("List");
//        var list = $box.findListWidgetByTitle("List title");
//        list.findFilterColumn("Custom Field").inlinePickListFilter().setFilter("Test");
//        assertThat(list.getNoFocusValues("Custom Field")).isEqualTo(List.of("Test12 data", "Test data"));

		List<String> actualData = PlatformApp.screen("InlinePickList filtration")
				.secondLevelView("List")
				.listInline("List title")
				.headers().filter(fb -> fb.inlinePickList("Custom Field", "Test"))
				.widget().rows().streamAllPages()
				.map(r -> r.inlinePickList("Custom Field"))
				.map(InlinePickList::getValue)
				.toList();
		assertThat(actualData).isEqualTo(List.of("Test12 data", "Test data"));
	}

	@Test
	@Tag("Positive")
	@DisplayName("The DrillDown test")
	@Description("Checking the url before the transition and after the transition/click on a special element")
	void drillDown() {
//        MainPages.click("InlinePickList drilldown");
//        MainPages.FirstLevelMenu.click("List");
//        var list = $box.findListWidgetByTitle("List title");
//        List<String> listRows = list.getNoFocusValues("Custom Field");
//        var customField = list.findRowSegmentByValue("Custom Field", listRows.get(0)).inlinePickList();
//        assertThat(customField.drillDown("/screen/myexample140/view/myexample140form/myExampleBc140")).isTrue();

		PlatformApp.screen("InlinePickList drillDown")
				.secondLevelView("List")
				.listInline("List title")
				.rows().row(0)
				.inlinePickList("Custom Field")
				.checkDrillDownSupported(ds -> assertThat(ds).isTrue());
	}

	@Test
	@Severity(CRITICAL)
	@Tag("Negative")
	@DisplayName("Business Exception Validation Test")
	@Description("The test sets the value in the field. After approval, the popup window, the title, the text in it, and the buttons are validated.")
	void businessException() {
//        MainPages.click("InlinePickList validation business exception");
//        MainPages.FirstLevelMenu.click("List");
//        var list = $box.findListWidgetByTitle("List title");
//        List<String> listRows = list.getNoFocusValues("Custom Field");
//        var customField = list.findRowSegmentByValue("Custom Field", listRows.get(0)).inlinePickList();
//        customField.setValue("Test data");
//        var popup = $box.findPopup("error");
//        assertThat(popup).isPresent();
//        assertThat(popup.get().errorPopup().getTitle()).isEqualTo(Constants.ErrorPopup.ErrorTitle);
//        assertThat(popup.get().errorPopup().getMessage()).isEqualTo(Constants.OnlyLetters);
//        popup.get().errorPopup().close();
		PlatformApp.screen("InlinePickList validation business exception")
				.secondLevelView("List")
				.listInline("List title")
				.rows().clickRow(0)
				.inlinePickList("Custom Field")
				.setValue("Test data")
				.widget().errorPopup()
				.checkTitleAndMessage(
						title -> assertThat(title).isEqualTo(Constants.ErrorPopup.TITLE),
						message -> assertThat(message).isEqualTo(Constants.OnlyLetters)
				).close();
	}

	@Test
	@Severity(CRITICAL)
	@Tag("Negative")
	@DisplayName("Run-time exception validation test")
	@Description("The test sets the value in the field. After approval, the popup window, the title, the text in it, and the buttons are validated.")
	void runtimeException() {
		PlatformApp.screen("InlinePickList validation runtime exception")
				.secondLevelView("List")
				.listInline("List title")
				.rows().clickRow(0)
				.inlinePickList("Custom Field")
				.clear()
				.widget().errorPopup()
				.checkTitleAndMessage(
						title -> assertThat(title).isEqualTo(Constants.ErrorPopup.TITLE),
						message -> assertThat(message).isEqualTo(Constants.SystemError)
				).close();
	}

	@Test
	@Severity(CRITICAL)
	@Tag("Positive")
	@DisplayName("Confirmation Popup Validation Test")
	@Description("The test sets the value in the field. After approval, by clicking on the save button, the popup window, the title, the text in it, and the buttons are validated.")
	void confirm() {
		PlatformApp.screen("InlinePickList validation confirm")
				.secondLevelView("List")
				.listInline("List title")
				.rows().clickRow(0)
				.inlinePickList("Custom Field")
				.setValue("Test data")
				.widget().rows().row(0).burgerActionClick("save")
				.widget().confirmPopup()
				.checkTitleAndMessage(
						title -> assertThat(title).isEqualTo(Constants.ConfirmPopup.TITLE),
						message -> assertThat(message).isEqualTo(Constants.SaveValue)
				).close();
	}

	@Test
	@Severity(CRITICAL)
	@Tag("Negative")
	@DisplayName("Required Message validation test for one field")
	@Description("The test sets the value with the wrong data type in the field. After approval, it checks the text under the field, which informs about the correctness of the type of data entered.")
	void fieldLevelValidationAnnotation() {
//        MainPages.click("InlinePickList validation field level annotation");
//        MainPages.FirstLevelMenu.click("List");
//        var list = $box.findListWidgetByTitle("List title");
//        List<String> listRows = list.getNoFocusValues("Custom Field");
//        var row = list.findRowSegmentByValue("Custom Field", listRows.get(0));
//        row.inlinePickList().setValue("Test123 data");
//        Optional<MenuRow> menuRow = row.findMenuRow();
//        assertThat(menuRow).isPresent();
//        menuRow.get().clickOption("Save");
//        assertThat(row.inlinePickList().getRequiredMessage()).isEqualTo(Constants.OnlyLetters);

		PlatformApp.screen("InlinePickList validation field level annotation")
				.secondLevelView("List")
				.listInline("List title")
				.rows().clickRow(0)
				.inlinePickList("Custom Field")
				.setValue("Test123 data")
				.widget().rows().row(0).burgerActionClick("Save")
				.row(0).inlinePickList("Custom Field").checkRequired(rm -> assertThat(rm).isEqualTo(Constants.OnlyLetters));
	}

	@Test
	@Severity(CRITICAL)
	@Tag("Negative")
	@DisplayName("Required Message validation test for multiple fields")
	@Description("The test sets a value with the wrong data type in several fields for different widgets. After approval, it checks the text under the field, which informs about the correctness of the type of data entered")
	void fieldLevelValidation() {
//        MainPages.click("InlinePickList validation field level dynamic");
//        MainPages.FirstLevelMenu.click("List");
//        var list = $box.findListWidgetByTitle("List title");
//        List<String> listRows = list.getNoFocusValues("Custom Field");
//        var row = list.findRowSegmentByValue("Custom Field", listRows.get(0));
//        List<String> listRows2 = list.getNoFocusValues("Custom Field Additional");
//        var row2 = list.findRowSegmentByValue("Custom Field Additional", listRows.get(0));
//        Optional<MenuRow> menuRow = row.findMenuRow();
//        assertThat(menuRow).isPresent();
//        menuRow.get().clickOption("Save");
//        assertThat(row.inlinePickList().getRequiredMessage()).isEqualTo(Text.textOnlyLetters("customField"));
//        assertThat(row2.inlinePickList().getRequiredMessage()).isEqualTo(Text.textOnlyLetters("customFieldAdditional"));

		PlatformApp.screen("InlinePickList validation field level dynamic")
				.secondLevelView("List")
				.listInline("List title")
				.rows().row(0).burgerActionClick("Save")
				.row(0).editRow().inlinePickList("Custom Field").checkRequired(rm -> assertThat(rm).isEqualTo(Text.textOnlyLetters("customField")))
				.widget().rows().row(0).inlinePickList("Custom Field Additional").checkRequired(rm -> assertThat(rm).isEqualTo(Text.textOnlyLetters("customFieldAdditional")));
	}

	@Test
	@Severity(MINOR)
	@Tag("Negative")
	@DisplayName("Sorting test")
	@Description("Sorting by the specified column.")
	void sorting() {

		List<String> expectedValue = new ArrayList<>(List.of("Abs data", "123 data", "Test data"));
		assertThat(PlatformApp.screen("InlinePickList sorting").secondLevelView("List")
				.listInline("List title")
				.rows().streamAllPages().map(r -> r.inlinePickList("Custom Field")).map(InlinePickList::getValue).toList()).isEqualTo(expectedValue);

		PlatformApp.screen("InlinePickList sorting").secondLevelView("List")
				.listInline("List title").headers().sort(sb -> sb.sort("Custom Field"));
		expectedValue.sort(Comparator.reverseOrder());
		assertThat(PlatformApp.screen("InlinePickList sorting").secondLevelView("List")
				.listInline("List title")
				.rows().streamAllPages().map(r -> r.inlinePickList("Custom Field")).map(InlinePickList::getValue).toList()).isEqualTo(expectedValue);

		PlatformApp.screen("InlinePickList sorting").secondLevelView("List")
				.listInline("List title").headers().sort(sb -> sb.sort("Custom Field"));
		expectedValue.sort(Comparator.naturalOrder());
		assertThat(PlatformApp.screen("InlinePickList sorting").secondLevelView("List")
				.listInline("List title")
				.rows().streamAllPages().map(r -> r.inlinePickList("Custom Field")).map(InlinePickList::getValue).toList()).isEqualTo(expectedValue);
	}

	@Test
	@Severity(CRITICAL)
	@Tag("Negative")
	@DisplayName("Required Message text Verification field test")
	@Description("The test clears the field and clicks the Save button. Then validates the message that the field is required.")
	void required() {

		PlatformApp.screen("InlinePickList required")
				.secondLevelView("List").listInline("List title")
				.rows().clickRow(0).inlinePickList("Custom Field").clear()
				.checkRequired(rm -> assertThat(rm).isEqualTo(Constants.RequiredMessage))
				.widget().rows().row(0).burgerActionClick("Save")
				.row(0).inlinePickList("Custom Field").checkRequired(rm -> assertThat(rm).isEqualTo(Constants.RequiredMessage));
	}
/*












    }









*/

}
