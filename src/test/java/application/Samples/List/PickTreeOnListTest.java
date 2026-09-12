package application.Samples.List;

import application.config.BaseTestForSamples;
import application.custom.Position;
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
import static org.junit.jupiter.api.Assertions.assertTrue;

@DisplayName("List. Checking the basic functions for the PickTree in the widget List")
@Epic("Samples")
@Tag("Samples")
@Tag("List")
public class PickTreeOnListTest extends BaseTestForSamples {

	@Test
	@Tag("Positive")
	@DisplayName("Test for getting the Placeholder value")
	@Description("The test gets the value from the placeholder attribute and returns it in String format")
	void placeholder() {
		var list = PlatformApp.screen("Picktree placeholder")
				.secondLevelView("List")
				.listInline("List title");
		var row = list.rows().clickRow(0);
		row.pickTree("Custom Field")
				.checkPlaceholder(pl -> assertThat(pl).isEqualTo("Placeholder text"));
	}

	@Test
	@Tag("Positive")
	@DisplayName("A test to get the field color value in Hex format")
	@Description("The test gets the value from the style attribute in RGB format, and then converts it to Hex format")
	void color() {
		var list = PlatformApp.screen("Picktree color")
				.secondLevelView("List")
				.listInline("List title");
		var row = list.rows().row(0);
		row.pickTree("Custom Field")
				.checkColor(color -> assertThat(color).isEqualTo("#EDA6A6"));
	}

	@Test
	@Tag("Positive")
	@DisplayName("A test to check the field for \"Read-only\"")
	@Description("The test checks for the disabled attribute.")
	void readonly() {
		var list = PlatformApp.screen("Picktree readonly")
				.secondLevelView("List")
				.listInline("List title");
		var row = list.rows().clickRow(0);
		row.pickTree("Custom Field")
				.checkReadOnly(ro -> assertThat(ro).isTrue());
	}

	@Test
	@Severity(CRITICAL)
	@Tag("Positive")
	@DisplayName("A test for checking a value in a field")
	@Description("The test gets the value in the field, and then checks the value in the field with what should be.")
	void read() {
		var list = PlatformApp.screen("Picktree basic")
				.secondLevelView("List")
				.listInline("List title");
		var row = list.rows().row(0);
		row.pickTree("Custom Field")
				.checkValue(value -> assertThat(value).isEqualTo("New data"));
	}

	@Test
	@Severity(CRITICAL)
	@Tag("Positive")
	@DisplayName("A test for setting a value in a field")
	@Description("The test sets the value in the field via Popup using a unique id, and then checks the value in the field with what needs to be set.")
	void edit() {
		var list = PlatformApp.screen("Picktree basic")
				.secondLevelView("List")
				.listInline("List title");
		var row = list.rows().clickRow(0);
		row.pickTree("Custom Field")
				.setValue("New data")
				.checkValue(value -> assertThat(value).isEqualTo("New data"));
	}

	@Test
	void test_1() {
//        var list = PlatformApp.screen("Picktree basic")
//                .secondLevelView("List")
//                .listInline("List title");
//        var row = list.rows().clickRow(0);
//        var customField = row.pickTree("Custom Field");
//        .clickRow(0).openModal();
//        var columns = .clickRow(0).modal().getColumnNames();
//        assertThat(columns).isEqualTo(List.of("Custom Field", "id"));
//        .clickRow(0).modal().close();
	}

	@Test
	void test_2() {
		var list = PlatformApp.screen("Picktree basic")
				.secondLevelView("List")
				.listInline("List title");
		var row = list.rows().clickRow(0);
		row.pickTree("Custom Field")
				.setValue("Test data")
				.checkValue(value -> assertThat(value).isEqualTo("Test data"));
	}

	@Test
	@Severity(MINOR)
	@Tag("Negative")
	@DisplayName("Filtering test")
	@Description("Filtering by the specified column.")
	void filtration() {
		var list = PlatformApp.screen("Picktree filtration")
				.secondLevelView("List")
				.listInline("List title");
		list.headers().filter(fb -> fb.input("Custom Field", "Abs"));
		var values = list.rows().streamCurrentPage()
				.map(r -> r.pickTree("Custom Field").getValue())
				.collect(Collectors.toList());
		assertThat(values).isEqualTo(List.of("Abs data"));
	}

	@Test
	@Tag("Positive")
	@DisplayName("The filtration by popup test")
	@Description("The \"...\" button of the column filter opens the PickTreePopup; the chosen record filters the list by id.")
	void filtrationPopup() {
		var list = PlatformApp.screen("Picktree filtration")
				.secondLevelView("List")
				.listInline("List title");
		list.headers().filter(fb -> fb.pickTree("Custom Field", List.of("Abs data")));
		var values = list.rows().streamCurrentPage()
				.map(r -> r.pickTree("Custom Field").getValue())
				.collect(Collectors.toList());
		assertThat(values).isEqualTo(List.of("Abs data"));
	}

	@Test
	@Tag("Positive")
	@DisplayName("The DrillDown test")
	@Description("Checking the url before the transition and after the transition/click on a special element")
	void drillDown() {
		var list = PlatformApp.screen("Picktree drilldown")
				.secondLevelView("List")
				.listInline("List title");
		var row = list.rows().row(0);
		row.pickTree("Custom Field")
				.checkDrillDownSupported(ro -> assertThat(ro).isTrue());
	}

	@Test
	@Severity(CRITICAL)
	@Tag("Negative")
	@DisplayName("Business Exception Validation Test")
	@Description("The test sets the value in the field. After approval, the popup window, the title, the text in it, and the buttons are validated.")
	void businessException() {
		var list = PlatformApp.screen("Picktree validation business exception")
				.secondLevelView("List")
				.listInline("List title");
		var row = list.rows().clickRow(0);
		row.pickTree("Custom Field").setValue("1234");
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
		var list = PlatformApp.screen("Picktree runtime")
				.secondLevelView("List")
				.listInline("List title");
		var row = list.rows().clickRow(0);
		row.pickTree("Custom Field").setValue("Test data");
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
		var list = PlatformApp.screen("Picktree validation confirm")
				.secondLevelView("List")
				.listInline("List title");
		var row = list.rows().clickRow(0);
		row.pickTree("Custom Field").setValue("Test data");
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
		var list = PlatformApp.screen("Picktree validation field level dynamic")
				.secondLevelView("List")
				.listInline("List title");
		var row = list.rows().clickRow(0);
		var customField = row.pickTree("Custom Field");
		customField.setValue("Test data 123");
		row.burgerAction("Save").click();
		row.editRow();// TODO >> front bag >> set value picklist break edit mode
		customField
				.checkRequired(message -> assertThat(message).isEqualTo("The field 'customField' can contain only letters."));
	}

	@Test
	void fieldLevelValidation() {
		var list = PlatformApp.screen("Picktree validation field level dynamic")
				.secondLevelView("List")
				.listInline("List title");
		var row = list.rows().clickRow(0);
		row.burgerAction("Save").click();
		row.pickTree("Custom Field")
				.checkRequired(message -> assertThat(message).isEqualTo("The field 'customField' can contain only letters."));
		row.pickTree("Custom Field Additional")
				.checkRequired(message -> assertThat(message).isEqualTo("The field 'customFieldAdditional' can contain only letters."));
	}

	@Test
	@Severity(MINOR)
	@Tag("Negative")
	@DisplayName("Sorting test")
	@Description("Sorting by the specified column.")
	void sorting() {
		var list = PlatformApp.screen("Picktree sorting")
				.secondLevelView("List")
				.listInline("List title");
		var valuesBefore = list.rows().streamCurrentPage()
				.map(r -> r.pickTree("Custom Field").getValue())
				.collect(Collectors.toList());
		assertThat(valuesBefore).isEqualTo(List.of("Abs data", "Test data"));
		list.headers().sort(sb -> sb.sort("Custom Field"));
		var valuesAfter = list.rows().streamCurrentPage()
				.map(r -> r.pickTree("Custom Field").getValue())
				.collect(Collectors.toList());
		assertThat(valuesAfter).isEqualTo(List.of("Test data", "Abs data"));
	}

	@Test
	@Severity(CRITICAL)
	@Tag("Negative")
	@DisplayName("Required Message text Verification field test")
	@Description("The test clears the field and clicks the Save button. Then validates the message that the field is required.")
	void required() {
		var list = PlatformApp.screen("Picktree required")
				.secondLevelView("List")
				.listInline("List title");
		var row = list.rows().clickRow(0);
		var customField = row.pickTree("Custom Field").clear();
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
		var list = PlatformApp.screen("PickTreePopup widget picktree create with parent")
				.view().listInline("List");
		list.actions().action("Create").click();

		var form = PlatformApp.screen("PickTreePopup widget picktree create with parent").secondLevelView("Picktree With Required Fields").form("Form Requred field");
		form.pickTree("Custom Field").setValue("Custom Field", "test data");

		var row = list.rows().clickRow(0);
		row.burgerAction("Save").click();
	}


	@Test
	void position() {
		assertTrue(Position.checkPosition(302, 95, PlatformApp.screen("Picktree basic").secondLevelView("List").listInline("List title").element()));
	}
}

