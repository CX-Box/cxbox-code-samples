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

import java.util.List;
import java.util.stream.Collectors;

import static io.qameta.allure.SeverityLevel.CRITICAL;
import static io.qameta.allure.SeverityLevel.MINOR;
import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("List. Checking the basic functions for the Dictionary in the widget List")
@Epic("Samples")
@Tag("Samples")
@Tag("List")
public class DictionaryOnListTest extends BaseTestForSamples {

	@Test
	@Severity(CRITICAL)
	@Tag("Positive")
	@DisplayName("A test for checking a value in a field")
	@Description("The test gets the value in the field, and then checks the value in the field with what should be.")
	void read() {
		var list = PlatformApp.screen("Dictionary enum basic")
				.secondLevelView("List")
				.listInline("List title");
		var customField = list.rows().row(0).dictionary("Custom Field");
		assertThat(customField.getValue()).isEqualTo("Kostroma region");
	}

	@Test
	@Tag("Positive")
	@DisplayName("The DrillDown test")
	@Description("Checking the url before the transition and after the transition/click on a special element")
	void drillDown() {
		var list = PlatformApp.screen("Dictionary enum drilldown")
				.secondLevelView("List")
				.listInline("List title");
		var customField = list.rows().row(0).dictionary("Custom Field");
		customField.checkDrillDownSupported(ds -> assertThat(ds).isTrue());
	}

	@Test
	@Tag("Positive")
	@DisplayName("Test for getting the Placeholder value")
	@Description("The test gets the value from the placeholder attribute and returns it in String format")
	void placeholder() {
		var list = PlatformApp.screen("Dictionary enum placeholder")
				.secondLevelView("List")
				.listInline("List title");
		var row = list.rows().row(0);
		row.editRow()
				.dictionary("Custom Field")
				.checkPlaceholder(pl -> assertThat(pl).isEqualTo("Placeholder text"));
	}

	@Test
	@Tag("Positive")
	@DisplayName("A test to get the field color value in Hex format")
	@Description("The test gets the value from the style attribute in RGB format, and then converts it to Hex format")
	void color() {
		var list = PlatformApp.screen("Dictionary enum color")
				.secondLevelView("List")
				.listInline("List title");
		var row = list.rows().row(0);
		row.dictionary("Custom Field")
				.checkColor(color -> assertThat(color).isEqualTo("#EDA6A6"));
	}

	@Test
	@Tag("Positive")
	@DisplayName("A test to check the field for \"Read-only\"")
	@Description("The test checks for the disabled attribute.")
	void readonly() {
		var list = PlatformApp.screen("Dictionary enum readonly")
				.secondLevelView("List")
				.listInline("List title");
		var row = list.rows().clickRow(0);
		row.dictionary("Custom Field")
				.checkReadOnly(ro -> assertThat(ro).isTrue());
	}

	@Test
	@Severity(CRITICAL)
	@Tag("Positive")
	@DisplayName("A test for setting a value in a field")
	@Description("The test sets the value in the field, and then checks the value in the field with what should be set.")
	void edit() {
		var list = PlatformApp.screen("Dictionary enum basic")
				.secondLevelView("List")
				.listInline("List title");
		var row = list.rows().clickRow(0);
		row.dictionary("Custom Field")
				.setValue("Tver region")
				.checkValue(val -> assertThat(val).isEqualTo("Tver region"));
		row.dictionary("Custom Field")
				.setValue("Kostroma region");
	}

	@Test
	@Severity(MINOR)
	@Tag("Negative")
	@DisplayName("Filtering test")
	@Description("Filtering by the specified column.")
	void filtration() {
		var list = PlatformApp.screen("Dictionary enum filtration")
				.secondLevelView("List")
				.listInline("List title");
		list.headers().filter(fb -> fb.dictionary("Custom Field", "Low"));
		var actualData = list.rows().streamAllPages()
				.map(r -> r.dictionary("Custom Field").getValue())
				.collect(Collectors.toList());
		assertThat(actualData).isEqualTo(List.of("Low", "Low", "Low", "Low"));
	}

	@Test
	@Severity(CRITICAL)
	@Tag("Negative")
	@DisplayName("Business Exception Validation Test")
	@Description("The test sets the value in the field. After approval, the popup window, the title, the text in it, and the buttons are validated.")
	void businessException() {
		var list = PlatformApp.screen("Dictionary enum validation business exception")
				.secondLevelView("List")
				.listInline("List title");
		var row = list.rows().clickRow(0);
		row.dictionary("Custom Field").setValue("Middle");
		list.errorPopup()
				.checkTitleAndMessage(
						title -> assertThat(title).isEqualTo(Constants.ErrorPopup.TITLE),
						message -> assertThat(message).isEqualTo(Text.textOnly("'High'")))
				.close();
	}

	@Test
	@Severity(CRITICAL)
	@Tag("Negative")
	@DisplayName("Run-time exception validation test")
	@Description("The test sets the value in the field. After approval, the popup window, the title, the text in it, and the buttons are validated.")
	void runtimeException() {
		var list = PlatformApp.screen("Dictionary enum validation runtime exception")
				.secondLevelView("List")
				.listInline("List title");
		var row = list.rows().clickRow(0);
		row.dictionary("Custom Field").setValue("Middle");
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
		var list = PlatformApp.screen("Dictionary enum validation confirm")
				.secondLevelView("List")
				.listInline("List title");
		var row = list.rows().clickRow(0);
		row.dictionary("Custom Field").setValue("Low");
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
		var list = PlatformApp.screen("Dictionary enum validation field level annotation")
				.secondLevelView("List")
				.listInline("List title");
		var row = list.rows().clickRow(0);
		row.dictionary("Custom Field");
		row.burgerAction("Save").click();
		list.rows().row(0)
				.dictionary("Custom Field")
				.checkRequired(message -> assertThat(message).isEqualTo(Constants.MessageAboutError));
	}

	@Test
	@Severity(CRITICAL)
	@Tag("Negative")
	@DisplayName("Required Message validation test for multiple fields")
	@Description("The test sets a value with the wrong data type in several fields for different widgets. After approval, it checks the text under the field, which informs about the correctness of the type of data entered")
	void fieldLevelValidation() {
		var list = PlatformApp.screen("Dictionary enum validation field level dynamic")
				.secondLevelView("List")
				.listInline("List title");
		var row = list.rows().clickRow(0);
		var customField = row.dictionary("Custom Field");
		var customFieldAdditional = row.dictionary("Custom Field Additional");
		row.burgerAction("Save").click();
		customField.checkRequired(rm -> assertThat(rm).isEqualTo(Constants.MessageAboutError));
		customFieldAdditional.checkRequired(rm -> assertThat(rm).isEqualTo(Constants.MessageAboutError));
	}

	@Test
	@Severity(MINOR)
	@Tag("Negative")
	@DisplayName("Sorting test")
	@Description("Sorting by the specified column.")
	void sorting() {
		var list = PlatformApp.screen("Dictionary enum sorting")
				.secondLevelView("List")
				.listInline("List Dictionary enum sorting");
		var headers = list.headers();
		var actualData = list.rows().streamAllPages()
				.map(r -> r.dictionary("Custom Field Dictionary").getValue())
				.collect(Collectors.toList());
		assertThat(actualData).isEqualTo(List.of("Low", "Middle", "High"));

		headers.sort(sb -> sb.sort("Custom Field Dictionary"));
		assertThat(list.rows().streamAllPages()
				.map(r -> r.dictionary("Custom Field Dictionary").getValue())
				.collect(Collectors.toList())).isEqualTo(List.of("Middle", "Low", "High"));
	}

	@Test
	@Severity(CRITICAL)
	@Tag("Negative")
	@DisplayName("Required Message text Verification field test")
	@Description("The test clears the field and clicks the Save button. Then validates the message that the field is required.")
	void required() {
		var list = PlatformApp.screen("Dictionary enum required")
				.secondLevelView("List")
				.listInline("List title");
		var row = list.rows().clickRow(0);
		row.dictionary("Custom Field").clear();
		row.burgerAction("Save").click();
		list.rows().row(0)
				.dictionary("Custom Field")
				.checkRequired(rm -> assertThat(rm).isEqualTo(Constants.RequiredMessage));
	}

	@Test
	@Severity(MINOR)
	@Tag("Positive")
	@DisplayName("A test to check the options of the drop-down list")
	void options() {
		var list = PlatformApp.screen("Dictionary enum basic")
				.secondLevelView("List")
				.listInline("List title");
		var row = list.rows().clickRow(0);
		row.dictionary("Custom Field")
				.checkOptions(opts -> assertThat(opts).isEqualTo(List.of("Belgorod region",
						"Bryansk region",
						"Vladimir region",
						"Voronezh region",
						"Ivanovo region",
						"Kaluga region",
						"Kostroma region",
						"Kursk region",
						"Moscow region",
						"Oryol region",
						"Ryazan region",
						"Smolensk region",
						"Tambov region",
						"Tver region")));
	}

	@Disabled
	@Test
	@Severity(CRITICAL)
	@Tag("Positive")
	@DisplayName("A test for checking the icon")
	@Description("The test check icon's name from the drop-down list ")
	void icon() {
		var list = PlatformApp.screen("Dictionary enum icon")
				.secondLevelView("List")
				.listInline("List Mode default");
		var actualData = list.rows().streamAllPages()
				.map(r -> r.dictionary("Custom Field").getValue())
				.collect(Collectors.toList());
		assertThat(actualData).isEqualTo(List.of("High", "Low", "Low", "Middle"));

		var list2 = PlatformApp.screen("Dictionary enum icon")
				.secondLevelView("List")
				.listInline("List Mode icon");
		var actualData2 = list2.rows().streamAllPages()
				.map(r -> r.dictionary("Custom Field").getValue())
				.collect(Collectors.toList());
		assertThat(actualData2).isEqualTo(List.of("High", "Low", "Low", "Middle"));
	}
}
