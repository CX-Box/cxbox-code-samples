package Samples.List;

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

@DisplayName("List. Checking the basic functions for the MultipleSelect in the widget List")
@Epic("Samples")
@Tag("Samples")
@Tag("List")
public class MultipleSelectOnListTest extends BaseTestForSamples {

	@Disabled("Checked at filtration and sorting")
	@Test
	@Severity(CRITICAL)
	@Tag("Positive")
	@DisplayName("A test for checking a value in a field")
	@Description("The test gets the value in the field, and then checks the value in the field with what should be.")
	void read() {
//        PlatformApp.screen("MultipleSelect basic")
//              .secondLevelView("List")
//              .listInline("List title")
//              .rows().row(0)
//              .multipleSelect("Custom Field").checkValue(values -> assertThat(values).isEqualTo(Set.of("Low")))
//              .widget().rows().row(0)
//              .multipleSelect("Custom Field").checkValue(values -> assertThat(values).isEqualTo(Set.of("Low")));
	}

	@Disabled
	@Test
	@Tag("Positive")
	@DisplayName("The DrillDown test")
	@Description("Checking the url before the transition and after the transition/click on a special element")
	void drillDown() {
//        MainPages.click("MultipleSelect drilldown");
//        MainPages.FirstLevelMenu.click("List");
//        var list = $box.findListWidgetByTitle("List title");
//        List<String> listRows = list.getNoFocusValues("Custom Field");
//        var customField = list.findRowSegmentByValue("Custom Field", listRows.get(0)).multipleSelect();
//        assertThatThrownBy(customField::drillDown).isInstanceOf(UnsupportedOperationException.class);
	}

	@Test
	@Tag("Positive")
	@DisplayName("Test for getting the Placeholder value")
	@Description("The test gets the value from the placeholder attribute and returns it in String format")
	void placeholder() {
		var list = PlatformApp.screen("MultipleSelect placeholder")
				.secondLevelView("List")
				.listInline("List title");
		var row = list.rows().clickRow(0);
		row.multipleSelect("Custom Field")
				.checkPlaceholder(pt -> assertThat(pt).isEqualTo("Placeholder text"));
	}

	@Test
	@Tag("Positive")
	@DisplayName("A test to get the field color value in Hex format")
	@Description("The test gets the value from the style attribute in RGB format, and then converts it to Hex format")
	void color() {
		var list = PlatformApp.screen("MultipleSelect color")
				.secondLevelView("List")
				.listInline("List title");
		var row = list.rows().row(0);
		row.multipleSelect("Custom Field")
				.checkColor(color -> assertThat(color).isNull());
	}

	@Test
	@Tag("Positive")
	@DisplayName("A test to check the field for \"Read-only\"")
	@Description("The test checks for the disabled attribute.")
	void readonly() {
		var list = PlatformApp.screen("MultipleSelect readonly")
				.secondLevelView("List")
				.listInline("List title");
		var row = list.rows().clickRow(0);
		row.multipleSelect("Custom Field")
				.checkReadOnly(ro -> assertThat(ro).isTrue());
	}

	@Test
	@Severity(CRITICAL)
	@Tag("Positive")
	@DisplayName("A test for setting a value in a field")
	@Description("Тест устанавливает значение в поле, а после проверяет значение в поле с тем, что должно быть установлено. Предварительной очистки поля ")
	void edit() {
		var list = PlatformApp.screen("MultipleSelect basic")
				.secondLevelView("List")
				.listInline("List title");
		var row = list.rows().clickRow(0);
		row.multipleSelect("Custom Field")
				.setValue(Set.of("High"))
				.checkValue(values -> assertThat(values).isEqualTo(Set.of("High")));
	}

	@Test
	@Severity(MINOR)
	@Tag("Negative")
	@DisplayName("Filtering test")
	@Description("Filtering by the specified column.")
	void filtration() {
		var list = PlatformApp.screen("MultipleSelect filtration")
				.secondLevelView("List")
				.listInline("List title");
		list.headers().filter(fb -> fb.multipleSelect("Custom Field", Set.of("Middle")));
		var allMatch = list.rows().streamAllPages()
				.allMatch(r -> r.multipleSelect("Custom Field").getValue().contains("Middle"));
		assertThat(allMatch).isTrue();
	}

	@Test
	@Severity(CRITICAL)
	@Tag("Negative")
	@DisplayName("Business Exception Validation Test")
	@Description("The test sets the value in the field. After approval, the popup window, the title, the text in it, and the buttons are validated.")
	void businessException() {
		var list = PlatformApp.screen("MultipleSelect business error")
				.secondLevelView("List")
				.listInline("List title");
		var row = list.rows().clickRow(0);
		row.multipleSelect("Custom Field").addValue(Set.of("Middle"));
		list.errorPopup()
				.checkTitleAndMessage(
						title -> assertThat(title).isEqualTo(Constants.ErrorPopup.TITLE),
						message -> assertThat(message).isEqualTo("The field  can contain 'High'"))
				.close();
		list.rows().clickRow(0)
				.multipleSelect("Custom Field")
				.addValue(Set.of("High"))
				.checkValue(values -> assertThat(values).isEqualTo(Set.of("Low", "High")));
	}

	@Test
	@Severity(CRITICAL)
	@Tag("Negative")
	@DisplayName("Run-time exception validation test")
	@Description("The test sets the value in the field. After approval, the popup window, the title, the text in it, and the buttons are validated.")
	void runtimeException() {
		var list = PlatformApp.screen("MultipleSelect runtime error")
				.secondLevelView("List")
				.listInline("List title");
		var row = list.rows().clickRow(0);
		row.multipleSelect("Custom Field").addValue(Set.of("Middle"));
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
		var list = PlatformApp.screen("MultipleSelect validation confirm")
				.secondLevelView("List")
				.listInline("List title");
		var row = list.rows().clickRow(0);
		row.multipleSelect("Custom Field").addValue(Set.of("Low"));
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
		var list = PlatformApp.screen("MultipleSelect validation field level annotation")
				.secondLevelView("List")
				.listInline("List title");
		var row = list.rows().clickRow(0);
		row.multipleSelect("Custom Field").clear();
		row.burgerAction("Save").click();
		list.rows().clickRow(0)
				.multipleSelect("Custom Field")
				.checkRequired(rm -> assertThat(rm).isEqualTo(Constants.MessageAboutError));
	}

	@Test
	@Severity(CRITICAL)
	@Tag("Negative")
	@DisplayName("Required Message validation test for multiple fields")
	@Description("The test sets a value with the wrong data type in several fields for different widgets. After approval, it checks the text under the field, which informs about the correctness of the type of data entered")
	void fieldLevelValidation() {
		var list = PlatformApp.screen("MultipleSelect validation field level dynamic")
				.secondLevelView("List")
				.listInline("List title");
		var row = list.rows().clickRow(0);
		row.burgerAction("Save").click();
		var editRow = list.rows().row(0).editRow();
		var customField = editRow.multipleSelect("Custom Field");
		var customFieldAdditional = editRow.multipleSelect("Custom Field Additional");
		customField.checkRequired(rm -> assertThat(rm).isEqualTo(Constants.MessageAboutError));
		customFieldAdditional.checkRequired(rm -> assertThat(rm).isEqualTo(Constants.MessageAboutError));
	}

	@Test
	@Severity(CRITICAL)
	@Tag("Negative")
	@DisplayName("Required Message text Verification field test")
	@Description("The test clears the field and clicks the Save button. Then validates the message that the field is required.")
	void required() {
		var list = PlatformApp.screen("MultipleSelect required")
				.secondLevelView("List")
				.listInline("List title");
		var row = list.rows().clickRow(0);
		var multipleSelect = row.multipleSelect("Custom Field");
		multipleSelect.setValue(Set.of("Low"))
				.checkValue(values -> assertThat(values).isEqualTo(Set.of("Low")))
				.clear()
				.checkValue(values -> assertThat(values).isEqualTo(Set.of()));
		row.burgerAction("Save").click();
		list.rows().row(0)
				.multipleSelect("Custom Field")
				.checkRequired(rm -> assertThat(rm).isEqualTo(Constants.RequiredMessage));
	}

	@Test
	@Severity(MINOR)
	@Tag("Positive")
	@DisplayName("Test to get a list of options")
	@Description("The test checks the list of options that the method returns, with the expected result.")
	void getListOptions() {
		var list = PlatformApp.screen("MultipleSelect basic")
				.secondLevelView("List")
				.listInline("List title");
		var row = list.rows().clickRow(0);
		row.multipleSelect("Custom Field")
				.setValue(Set.of("Middle"))
				.checkValue(values -> assertThat(values).isEqualTo(Set.of("Middle")))
				.checkOptions(values -> assertThat(values).isEqualTo(Set.of("Low", "Middle", "High")));
	}

	@Test
	@Severity(MINOR)
	@Tag("Positive")
	@DisplayName("A test to check the status of one option")
	@Description("The test checks the status of one option, whether it is selected or not.")
	void statusOption() {
		var list = PlatformApp.screen("MultipleSelect basic")
				.secondLevelView("List")
				.listInline("List title");
		var row = list.rows().clickRow(0);
		row.multipleSelect("Custom Field")
				.addValue(Set.of("Low"))
				.checkStatusOption("Low", isSelected -> assertThat(isSelected).isTrue())
				.setValue(Set.of("Middle"))
				.checkStatusOption("Low", isSelected -> assertThat(isSelected).isFalse())
				.checkStatusOption("Middle", isSelected -> assertThat(isSelected).isTrue());
	}

	@Test
	@Severity(MINOR)
	@Tag("Positive")
	@DisplayName("Test to check the status of all options")
	@Description("The method returns Option-Status pairs, for all. The test checks each pair.")
	void statusOptions() {
		var list = PlatformApp.screen("MultipleSelect basic")
				.secondLevelView("List")
				.listInline("List title");
		var row = list.rows().clickRow(0);
		row.multipleSelect("Custom Field")
				.setValue(Set.of("Middle"))
				.checkStatusOptions(Map.of(
						"High", isSelected -> assertThat(isSelected).isFalse(),
						"Middle", isSelected -> assertThat(isSelected).isTrue(),
						"Low", isSelected -> assertThat(isSelected).isFalse()));
	}
}
