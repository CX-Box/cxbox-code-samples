package application.Samples.List;

import application.config.BaseTestForSamples;
import core.config.Constants;
import core.element.PlatformApp;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Severity;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;

import static io.qameta.allure.SeverityLevel.CRITICAL;
import static io.qameta.allure.SeverityLevel.MINOR;
import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("List. Checking the basic functions for the PickList in the widget List")
@Epic("Samples")
@Tag("Samples")
@Tag("List")
public class PickListOnListTest extends BaseTestForSamples {

	@Test
	@Tag("Positive")
	@DisplayName("Test for getting the Placeholder value")
	@Description("The test gets the value from the placeholder attribute and returns it in String format")
	void placeholder() {
		var list = PlatformApp.screen("Picklist placeholder")
				.secondLevelView("List")
				.listInline("List title");
		var row = list.rows().clickRow(0);
		row.pickList("Custom Field")
				.checkPlaceholder(pl -> assertThat(pl).isEqualTo("Placeholder text"));
	}

	@Test
	@Tag("Positive")
	@DisplayName("A test to get the field color value in Hex format")
	@Description("The test gets the value from the style attribute in RGB format, and then converts it to Hex format")
	void color() {
		var list = PlatformApp.screen("Picklist color")
				.secondLevelView("List")
				.listInline("List title");
		var row = list.rows().row(0);
		row.pickList("Custom Field")
				.checkColor(color -> assertThat(color).isEqualTo("#EDA6A6"));
	}

	@Test
	@Tag("Positive")
	@DisplayName("A test to check the field for \"Read-only\"")
	@Description("The test checks for the disabled attribute.")
	void readonly() {
		var list = PlatformApp.screen("Picklist readonly")
				.secondLevelView("List")
				.listInline("List title");
		var row = list.rows().clickRow(0);
		row.pickList("Custom Field")
				.checkReadOnly(ro -> assertThat(ro).isTrue());
	}

	@Test
	@Severity(CRITICAL)
	@Tag("Positive")
	@DisplayName("A test for checking a value in a field")
	@Description("The test gets the value in the field, and then checks the value in the field with what should be.")
	void read() {
		var list = PlatformApp.screen("Picklist basic")
				.secondLevelView("List")
				.listInline("List title");
		var row = list.rows().row(0);
		row.pickList("Custom Field")
				.checkValue(value -> assertThat(value).isEqualTo("New data"));
	}

	@Test
	@Severity(CRITICAL)
	@Tag("Positive")
	@DisplayName("A test for setting a value in a field")
	@Description("The test sets the value in the field via Popup using a unique id, and then checks the value in the field with what needs to be set.")
	void edit() {
		var list = PlatformApp.screen("Picklist basic")
				.secondLevelView("List")
				.listInline("List title");
		var row = list.rows().clickRow(0);
		row.pickList("Custom Field")
				.setValue("New data")
				.checkValue(value -> assertThat(value).isEqualTo("New data"));
	}

	@Test
	void test_1() {
//        var list = PlatformApp.screen("Picklist basic")
//                .secondLevelView("List")
//                .listInline("List title");
//        var row = list.rows().clickRow(0);
//        var customField = row.pickList("Custom Field");
//        .clickRow(0).openModal();
//        var columns = .clickRow(0).modal().getColumnNames();
//        assertThat(columns).isEqualTo(List.of("Custom Field", "id"));
//        .clickRow(0).modal().close();
	}

	@Test
	void test_2() {
		var list = PlatformApp.screen("Picklist basic")
				.secondLevelView("List")
				.listInline("List title");
		var row = list.rows().clickRow(0);
		row.pickList("Custom Field")
				.setValue("Test data")
				.checkValue(value -> assertThat(value).isEqualTo("Test data"));
	}

	@Test
	@Severity(MINOR)
	@Tag("Negative")
	@DisplayName("Filtering test")
	@Description("Filtering by the specified column.")
	void filtration() {
		var list = PlatformApp.screen("Picklist filtration")
				.secondLevelView("List")
				.listInline("List title");
		list.headers().filter(fb -> fb.input("Custom Field", "Abs"));
		var values = list.rows().streamCurrentPage()
				.map(r -> r.pickList("Custom Field").getValue())
				.collect(Collectors.toList());
		assertThat(values).isEqualTo(List.of("Abs data"));
	}

	@Test
	@Tag("Positive")
	@DisplayName("The DrillDown test")
	@Description("Checking the url before the transition and after the transition/click on a special element")
	void drillDown() {
		var list = PlatformApp.screen("Picklist drilldown")
				.secondLevelView("List")
				.listInline("List title");
		var row = list.rows().row(0);
		row.pickList("Custom Field")
				.checkDrillDownSupported(ro -> assertThat(ro).isTrue());
	}

	@Test
	@Severity(CRITICAL)
	@Tag("Negative")
	@DisplayName("Business Exception Validation Test")
	@Description("The test sets the value in the field. After approval, the popup window, the title, the text in it, and the buttons are validated.")
	void businessException() {
		var list = PlatformApp.screen("Picklist validation business exception")
				.secondLevelView("List")
				.listInline("List title");
		var row = list.rows().clickRow(0);
		row.pickList("Custom Field").setValue("1234");
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
		var list = PlatformApp.screen("Picklist runtime")
				.secondLevelView("List")
				.listInline("List title");
		var row = list.rows().clickRow(0);
		row.pickList("Custom Field").setValue("Test data");
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
		var list = PlatformApp.screen("Picklist validation confirm")
				.secondLevelView("List")
				.listInline("List title");
		var row = list.rows().clickRow(0);
		row.pickList("Custom Field").setValue("Test data");
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
		var list = PlatformApp.screen("Picklist validation field level dynamic")
				.secondLevelView("List")
				.listInline("List title");
		var row = list.rows().clickRow(0);
		var customField = row.pickList("Custom Field");
		customField.setValue("Test data 123");
		row.burgerAction("Save").click();
		row.editRow();// TODO >> front bag >> set value picklist break edit mode
		customField
				.checkRequired(message -> assertThat(message).isEqualTo("The field 'customField' can contain only letters."));
	}

	@Test
	void fieldLevelValidation() {
		var list = PlatformApp.screen("Picklist validation field level dynamic")
				.secondLevelView("List")
				.listInline("List title");
		var row = list.rows().clickRow(0);
		row.burgerAction("Save").click();
		row.pickList("Custom Field")
				.checkRequired(message -> assertThat(message).isEqualTo("The field 'customField' can contain only letters."));
		row.pickList("Custom Field Additional")
				.checkRequired(message -> assertThat(message).isEqualTo("The field 'customFieldAdditional' can contain only letters."));
	}

	@Test
	@Severity(MINOR)
	@Tag("Negative")
	@DisplayName("Sorting test")
	@Description("Sorting by the specified column.")
	void sorting() {
		var list = PlatformApp.screen("Picklist sorting")
				.secondLevelView("List")
				.listInline("List title");
		var valuesBefore = list.rows().streamCurrentPage()
				.map(r -> r.pickList("Custom Field").getValue())
				.collect(Collectors.toList());
		assertThat(valuesBefore).isEqualTo(List.of("Abs data", "Test data"));
		list.headers().sort(sb -> sb.sort("Custom Field"));
		var valuesAfter = list.rows().streamCurrentPage()
				.map(r -> r.pickList("Custom Field").getValue())
				.collect(Collectors.toList());
		assertThat(valuesAfter).isEqualTo(List.of("Test data", "Abs data"));
	}

	@Test
	@Severity(CRITICAL)
	@Tag("Negative")
	@DisplayName("Required Message text Verification field test")
	@Description("The test clears the field and clicks the Save button. Then validates the message that the field is required.")
	void required() {
		var list = PlatformApp.screen("Picklist required")
				.secondLevelView("List")
				.listInline("List title");
		var row = list.rows().clickRow(0);
		var customField = row.pickList("Custom Field").clear();
		row.burgerAction("Save").click();
		customField
				.checkRequired(message -> assertThat(message).isEqualTo(Constants.RequiredMessage));
	}

	@Test
	@Severity(CRITICAL)
	@Tag("Positive")
	@DisplayName("Open Picklist With RequiredFields")
	@Description("Checking the picklist behavior when required fields are present on the widget: the picklist should open.")
	void openPicklistWithRequiredFields() {
		var list = PlatformApp.screen("PickListPopup widget picklist create with parent")
				.view().listInline("List");
		list.actions().action("Create").click();

		var form = PlatformApp.screen("PickListPopup widget picklist create with parent").secondLevelView("Picklist With Required Fields").form("Form Requred field");
		form.pickList("Custom Field").setValue("Custom Field", "test data");

		var row = list.rows().clickRow(0);
		row.burgerAction("Save").click();
	}

}

