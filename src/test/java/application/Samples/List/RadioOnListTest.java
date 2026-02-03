package application.Samples.List;

import application.common.Text;
import application.config.BaseTestForSamples;
import core.config.Constants;
import core.element.PlatformApp;
import io.qameta.allure.Description;
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

public class RadioOnListTest extends BaseTestForSamples {

	@Disabled("Checked at filtration and sorting")
	@Test
	@Severity(CRITICAL)
	@Tag("Positive")
	@DisplayName("A test for checking a value in a field")
	@Description("The test gets the value in the field, and then checks the value in the field with what should be.")
	void read() {
//        var list = PlatformApp.screen("Radio basic")
//              .secondLevelView("List")
//              .listInline("List title");
//        var row = list.rows().row(0);
//        row.radio("Custom Field")
//              .checkValue(value -> assertThat(value).isEqualTo("Low"));
	}

	@Disabled
	@Test
	@Severity(CRITICAL)
	@Tag("Negative")
	@DisplayName("Required Message text Verification field test")
	@Description("The test clears the field and clicks the Save button. Then validates the message that the field is required.")
	void required() {
//        var list = PlatformApp.screen("Radio required")
//              .secondLevelView("List")
//              .listInline("List title");
//        var row = list.rows().clickRow(0);
//        row.burgerAction("Save").click();
//        list.rows().row(0)
//              .radio("Custom Field")
//              .checkRequired(message -> assertThat(message).isEqualTo(Constants.RequiredMessage));
	}

	@Test
	@Tag("Positive")
	@DisplayName("Test for getting the Placeholder value")
	@Description("The test gets the value from the placeholder attribute and returns it in String format")
	void placeholder() {
		var list = PlatformApp.screen("Radio placeholder")
				.secondLevelView("List")
				.listInline("List title");
		var row = list.rows().clickRow(0);
		row.radio("Custom Field")
				.checkPlaceholder(pl -> assertThat(pl).isEmpty());
	}

	@Test
	@Tag("Positive")
	@DisplayName("A test to get the field color value in Hex format")
	@Description("The test gets the value from the style attribute in RGB format, and then converts it to Hex format")
	void color() {
		var list = PlatformApp.screen("Radio color")
				.secondLevelView("List")
				.listInline("List title");
		var row = list.rows().row(0);
		row.radio("Custom Field")
				.checkColor(color -> assertThat(color).isEqualTo("#EDA6A6"));
	}

	@Test
	@Tag("Positive")
	@DisplayName("A test to check the field for \"Read-only\"")
	@Description("The test checks for the disabled attribute.")
	void readonly() {
		var list = PlatformApp.screen("Radio readonly")
				.secondLevelView("List")
				.listInline("List title");
		var row = list.rows().clickRow(0);
		row.radio("Custom Field")
				.checkReadOnly(ro -> assertThat(ro).isTrue());
	}

	@Test
	@Severity(CRITICAL)
	@Tag("Positive")
	@DisplayName("A test for setting a value in a field")
	@Description("The test sets the value in the field, and then checks the value in the field with what should be set.")
	void edit() {
		var list = PlatformApp.screen("Radio basic")
				.secondLevelView("List")
				.listInline("List title");
		var row = list.rows().clickRow(0);
		row.radio("Custom Field")
				.setValue("Low")
				.checkValue(value -> assertThat(value).isEqualTo("Low"));
	}

	@Test
	@Severity(MINOR)
	@Tag("Negative")
	@DisplayName("Filtering test")
	@Description("Filtering by the specified column.")
	void filtration() {
		var list = PlatformApp.screen("Radio filtration")
				.secondLevelView("List")
				.listInline("List title");
		list.headers().filter(fb -> fb.radio("Custom Field", "Middle"));
		var values = list.rows().streamCurrentPage()
				.map(r -> r.radio("Custom Field").getValue())
				.collect(Collectors.toList());
		assertThat(values).isEqualTo(List.of("Middle", "Middle"));
	}

	@Test
	@Tag("Positive")
	@DisplayName("The DrillDown test")
	@Description("Checking the url before the transition and after the transition/click on a special element")
	void drillDown() {
		var list = PlatformApp.screen("Radio drilldown")
				.secondLevelView("List")
				.listInline("List title");
		var row = list.rows().row(0);
		row.radio("Custom Field")
				.checkDrillDownSupported(ro -> assertThat(ro).isTrue());
	}

	@Test
	@Severity(CRITICAL)
	@Tag("Negative")
	@DisplayName("Business Exception Validation Test")
	@Description("The test sets the value in the field. After approval, the popup window, the title, the text in it, and the buttons are validated.")
	void businessException() {
		var list = PlatformApp.screen("Radio validation business exception")
				.secondLevelView("List")
				.listInline("List title");
		var row = list.rows().clickRow(0);
		row.radio("Custom Field").setValue("Low");
		list.errorPopup()
				.checkTitleAndMessage(
						title -> assertThat(title).isEqualTo(Constants.ErrorPopup.TITLE),
						message -> assertThat(message).isEqualTo(Text.textRadioContains("High")))
				.close();
	}

	@Test
	@Severity(CRITICAL)
	@Tag("Negative")
	@DisplayName("Run-time exception validation test")
	@Description("The test sets the value in the field. After approval, the popup window, the title, the text in it, and the buttons are validated.")
	void runtimeException() {
		var list = PlatformApp.screen("Radio validation runtime exception")
				.secondLevelView("List")
				.listInline("List title");
		var row = list.rows().clickRow(0);
		row.radio("Custom Field").setValue("Low");
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
		var list = PlatformApp.screen("Radio validation confirm")
				.secondLevelView("List")
				.listInline("List title");
		var row = list.rows().clickRow(0);
		row.radio("Custom Field").setValue("Middle");
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
		var list = PlatformApp.screen("Radio validation field level annotation")
				.secondLevelView("List")
				.listInline("List title");
		var row = list.rows().clickRow(0);
		row.radio("Custom Field").setValue("Low");
		row.burgerAction("Save").click();
		list.rows().row(0)
				.radio("Custom Field")
				.checkRequired(message -> assertThat(message).isEqualTo(Constants.MessageAboutError));
	}

	@Test
	@Severity(CRITICAL)
	@Tag("Negative")
	@DisplayName("Required Message validation test for multiple fields")
	@Description("The test sets a value with the wrong data type in several fields for different widgets. After approval, it checks the text under the field, which informs about the correctness of the type of data entered")
	void fieldLevelValidation() {
		var list = PlatformApp.screen("Radio validation field level dynamic")
				.secondLevelView("List")
				.listInline("List title");
		var row = list.rows().clickRow(0);
		var customField = row.radio("Custom Field");
		var customFieldAdditional = row.radio("Custom Field Additional");
		customField.setValue("Low");
		customFieldAdditional.setValue("Low");
		row.burgerAction("Save").click();
		var editRow = list.rows().row(0);
		editRow.radio("Custom Field")
				.checkRequired(message -> assertThat(message).isEqualTo(Constants.MessageAboutError));
		editRow.radio("Custom Field Additional")
				.checkRequired(message -> assertThat(message).isEqualTo(Constants.MessageAboutError));
	}

	@Test
	@Severity(MINOR)
	@Tag("Negative")
	@DisplayName("Sorting test")
	@Description("Sorting by the specified column.")
	void sorting() {
		var list = PlatformApp.screen("Radio sorting")
				.secondLevelView("List")
				.listInline("List title");
		list.headers().sort(sb -> sb.sort("Custom Field"));
		var valuesFirstSort = list.rows().streamCurrentPage()
				.map(r -> r.radio("Custom Field").getValue())
				.collect(Collectors.toList());
		assertThat(valuesFirstSort).isEqualTo(List.of("Middle", "Low", "High"));
		list.headers().sort(sb -> sb.sort("Custom Field"));
		var valuesSecondSort = list.rows().streamCurrentPage()
				.map(r -> r.radio("Custom Field").getValue())
				.collect(Collectors.toList());
		assertThat(valuesSecondSort).isEqualTo(List.of("High", "Low", "Middle"));
	}

	@Test
	@Severity(MINOR)
	@Tag("Positive")
	@DisplayName("Test to get all values with the status")
	@Description("The test sets the value, after which the method returns the full list of value-status")
	void getValues() {
		var list = PlatformApp.screen("Radio basic")
				.secondLevelView("List")
				.listInline("List title");
		var row = list.rows().clickRow(0);
		row.radio("Custom Field").setValue("Middle");
		row.burgerAction("Save").click();
		list.rows().row(0)
				.radio("Custom Field")
				.checkValue(value -> assertThat(value).isEqualTo("Middle"));
	}
}
