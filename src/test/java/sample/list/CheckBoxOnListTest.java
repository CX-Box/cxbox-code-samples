package sample.list;


import application.common.Text;
import application.config.BaseTestForSamples;
import core.config.Constants;
import core.element.PlatformApp;
import core.element.widget.field.type.checkbox.CheckBox;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Severity;
import io.qameta.allure.Story;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static io.qameta.allure.SeverityLevel.CRITICAL;
import static io.qameta.allure.SeverityLevel.MINOR;
import static org.assertj.core.api.Assertions.assertThat;


@DisplayName("List. Checking the basic functions for the CheckBox")
@Epic("Samples")
@Story("List")
@Tag("Samples")
@Tag("List")
public class CheckBoxOnListTest extends BaseTestForSamples {

	@Test
	@Tag("Positive")
	@DisplayName("Test for getting the Placeholder value")
	@Description("The test gets the value from the placeholder attribute and returns it in String format")
	void placeholder() {
		var list = PlatformApp.screen("Checkbox placeholder")
				.secondLevelView("List")
				.listInline("List title");
		var row = list
				.rows()
				.row(0);
		row.checkBox("Custom Field")
				.checkPlaceholder(placeholder -> assertThat(placeholder).isEmpty());

	}

	@Test
	@Tag("Positive")
	@DisplayName("A test to get the field color value in Hex format")
	@Description("The test gets the value from the style attribute in RGB format, and then converts it to Hex format")
	void color() {
		var list = PlatformApp.screen("Checkbox color ")
				.secondLevelView("List")
				.listInline("List title");
		var row = list
				.rows()
				.row(0);
		row.checkBox("Custom Field")
				.checkColor(color -> assertThat(color).isNull());
	}

	@Test
	@Tag("Positive")
	@DisplayName("A test to check the field for \"Read-only\"")
	@Description("The test checks for the disabled attribute.")
	void readonly() {
		var form = PlatformApp.screen("Checkbox readonly")
				.secondLevelView("List")
				.listInline("List title");
		var row = form
				.rows()
				.row(0);
		row.checkBox("Custom Field")
				.checkReadOnly(ro -> assertThat(ro).isTrue());
	}

	@Test
	@Severity(CRITICAL)
	@Tag("Positive")
	@DisplayName("A test for checking a value in a field")
	@Description("The test gets the value in the field, and then checks the value in the field with what should be.")
	void read() {
		var row = PlatformApp.screen("Checkbox basic")
				.secondLevelView("List")
				.listInline("List title")
				.rows()
				.row(0);
		row
				.checkBox("Custom Field")
				.checkValue(value -> assertThat(value).isTrue());
	}

	@Test
	@Severity(CRITICAL)
	@Tag("Positive")
	@DisplayName("A test for setting a value in a field")
	@Description("The test sets the value to false in the field, and then checks the value in the field with what should be set.")
	void edit() {
		var list = PlatformApp.screen("Checkbox basic")
				.secondLevelView("List")
				.listInline("List title");
		var row = list
				.rows()
				.clickRow(0);
		var checkBox = row
				.checkBox("Custom Field");
		checkBox.setValue(false);
		checkBox.setValue(true);
		checkBox.setValue(false);
		checkBox.checkValue(value -> assertThat(value).isFalse());

	}

	@Test
	@Severity(CRITICAL)
	@Tag("Positive")
	@DisplayName("A test for setting a value in a field")
	@Description("The test sets the value to true in the field, and then checks the value in the field with what should be set.")
	void edit2() {
		var list = PlatformApp.screen("Checkbox basic")
				.secondLevelView("List")
				.listInline("List title");
		var row = list
				.rows()
				.row(0);
		var checkBox = row
				.checkBox("Custom Field");
		checkBox
				.setValue(true)
				.checkValue(value -> assertThat(value).isTrue());
	}

	@Test
	@Severity(MINOR)
	@Tag("Negative")
	@DisplayName("Filtering test")
	@Description("Filtering by the specified column.")
	void filtration() {
		var list = PlatformApp.screen("Checkbox filtration")
				.secondLevelView("List")
				.listInline("List title");
		list.headers().filter(fb -> fb.checkbox("Custom Field", true));
		var actualData = list.rows().streamAllPages()
				.map(r -> r.checkBox("Custom Field").getValue())
				.collect(Collectors.toList());
		assertThat(actualData).isEqualTo(List.of(true));
	}


	@Test
	@Tag("Positive")
	@DisplayName("The DrillDown test")
	@Description("Checking the url before the transition and after the transition/click on a special element")
	void drillDown() {
		var list = PlatformApp.screen("Checkbox drilldown")
				.secondLevelView("List")
				.listInline("List title");
		var row = list.rows().row(0);
		var checkBox = row.checkBox("Custom Field");
		checkBox.checkDrillDownSupported(isDrilldown -> assertThat(isDrilldown).isFalse());
	}

	@Test
	@Severity(CRITICAL)
	@Tag("Negative")
	@DisplayName("Business Exception Validation Test")
	@Description("The test sets the value in the field. After approval, the popup window, the title, the text in it, and the buttons are validated.")
	void businessException() {
		var list = PlatformApp.screen("Checkbox validation business exception")
				.secondLevelView("List")
				.listInline("List title");
		var row = list
				.rows()
				.clickRow(0);
		var checkBox = row
				.checkBox("Custom Field");
		checkBox.setValue(true);
		checkBox.setValue(false);
		checkBox.checkValue(value -> assertThat(value).isFalse());
		list.errorPopup()
				.checkTitleAndMessage(
						title -> assertThat(title).isEqualTo(Constants.ErrorPopup.TITLE),
						message -> assertThat(message).isEqualTo(Text.textOnly("'True'")))
				.close();
	}

	@Test
	@Severity(CRITICAL)
	@Tag("Negative")
	@DisplayName("Run-time exception validation test")
	@Description("The test sets the value in the field. After approval, the popup window, the title, the text in it, and the buttons are validated.")
	void runtimeException() {
		var list = PlatformApp.screen("Checkbox validation runtime exception")
				.secondLevelView("List")
				.listInline("List title");
		var row = list
				.rows()
				.clickRow(0);
		var checkBox = row
				.checkBox("Custom Field");
		checkBox.setValue(true);
		checkBox.setValue(false);
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
		var list = PlatformApp.screen("Checkbox validation confirm")
				.secondLevelView("List")
				.listInline("List title");
		var row = list
				.rows()
				.clickRow(0);
		row
				.checkBox("Custom Field")
				.setValue(true);
		list
				.rows()
				.row(0)
				.burgerAction("save")
				.click();

		list
				.confirmPopup()
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

		var list = PlatformApp.screen("Checkbox validation field level annotation")
				.secondLevelView("List")
				.listInline("List title");
		var row = list
				.rows()
				.row(0).editRow();
		var checkBox = row
				.checkBox("Custom Field");
		checkBox.setValue(false);
		checkBox.setValue(true);
		checkBox.setValue(false);
		row.burgerAction("Save").click();
		checkBox.checkRequired(rt -> assertThat(rt).isEqualTo(Text.textOnly("'True'")));
	}

	@Test
	@Severity(CRITICAL)
	@Tag("Negative")
	@DisplayName("Required Message validation test for multiple fields")
	@Description("The test sets a value with the wrong data type in several fields for different widgets. After approval, it checks the text under the field, which informs about the correctness of the type of data entered")
	void fieldLevelValidation() {

		var list = PlatformApp.screen("Checkbox validation field level dynamic")
				.secondLevelView("List")
				.listInline("List title");
		var row = list
				.rows()
				.clickRow(0);
		var customField = row
				.checkBox("Custom Field");
		var customFieldAdditional = row.checkBox("Custom Field Additional");

		customField.setValue(false);
		customField.setValue(true);
		customField.setValue(false);
		customField.setValue(true);
		customField.setValue(false);
		customFieldAdditional.setValue(false);
		customFieldAdditional.setValue(true);
		customFieldAdditional.setValue(false);
		customFieldAdditional.setValue(true);
		customFieldAdditional.setValue(false);
		row.burgerAction("Save").click();
		customField
				.checkRequired(rt -> assertThat(rt).isEqualTo(Text.textOnlyTrue("customField")));
		customFieldAdditional
				.checkRequired(rt -> assertThat(rt).isEqualTo(Text.textOnlyTrue("customFieldAdditional")));
	}

	/**
	 * strange sort > check in back and front
	 */
	@Disabled(value = "strange sort > TODO  check in back and front")
	@Test
	@Severity(MINOR)
	@Tag("Negative")
	@DisplayName("Sorting test")
	@Description("Sorting by the specified column.")
	void sorting() {
		var expectedValues = new ArrayList<Boolean>(List.of(false, false, true, false));
		var list = PlatformApp.screen("Checkbox sorting")
				.secondLevelView("List")
				.listInline("List title");
		var headers = list.headers();
		var rows = list.rows();

		var actualData = rows.streamAllPages()
				.map(r -> r.checkBox("Custom Field"))
				.map(CheckBox::getValue)
				.toList();
		assertThat(actualData).isEqualTo(expectedValues);

		headers.sort(sb -> sb.sort("Custom Field"));
		actualData = rows.streamAllPages()
				.map(r -> r.checkBox("Custom Field"))
				.map(CheckBox::getValue)
				.toList();
		expectedValues.sort(Comparator.reverseOrder());
		assertThat(actualData).isEqualTo(expectedValues);

		headers.sort(sb -> sb.sort("Custom Field"));
		actualData = rows.streamAllPages()
				.map(r -> r.checkBox("Custom Field"))
				.map(CheckBox::getValue)
				.toList();

		expectedValues.sort(Comparator.naturalOrder());
		assertThat(actualData).isEqualTo(expectedValues);
	}

	@Test
	@Severity(CRITICAL)
	@Tag("Negative")
	@DisplayName("Required Message text Verification field test")
	@Description("The test clears the field and clicks the Save button. Then validates the message that the field is required.")
	void required() {
		var list = PlatformApp.screen("Checkbox required")
				.secondLevelView("List")
				.listInline("List title");
		var row = list
				.rows()
				.row(0);
		row.burgerAction("Save").click();

		row.checkBox("Custom Field")
				.checkRequired(rt -> assertThat(rt).isEqualTo(Constants.RequiredMessage));

	}
}
