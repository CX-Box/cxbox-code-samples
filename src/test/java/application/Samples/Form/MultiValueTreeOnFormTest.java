package application.Samples.Form;

import application.config.BaseTestForSamples;
import application.custom.Position;
import core.config.Constants;
import core.element.PlatformApp;
import core.element.widget.field.type.multivalueTree.MultivalueTree;
import core.util.DocShots;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.util.List;

import static io.qameta.allure.SeverityLevel.CRITICAL;
import static io.qameta.allure.SeverityLevel.MINOR;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DisplayName("Form. Checking the basic functions for the MultiValueTree in the widget Form")
@Epic("Samples")
@Feature(MultiValueTreeOnFormTest.ARTICLE)
@Tag("Samples")
@Tag("Form")
@Slf4j
public class MultiValueTreeOnFormTest extends BaseTestForSamples {

	static final String ARTICLE = "widget/fields/field/multivalueTree";

	@Disabled
	@Test
	@Severity(MINOR)
	@Tag("Negative")
	@DisplayName("Filtering test")
	@Description("Filtering is not available for the Form widget")
	void filtration() {
	}

	@Disabled
	@Test
	@Tag("Positive")
	@DisplayName("The DrillDown test")
	@Description("Checking the url before the transition and after the transition/click on a special element")
	void drillDown() {
	}

	@Disabled
	@Test
	@Severity(MINOR)
	@Tag("Negative")
	@DisplayName("Sorting test")
	@Description("Sorting is not available for the Form widget")
	void sorting() {
	}

	@Disabled
	@Test
	@Severity(CRITICAL)
	@Tag("Negative")
	@DisplayName("A test for checking values by column heading in a modal window")
	@Description("The test calls a modal window, after which the method returns Status-Value pairs depending on the column header.")
	void test_status() {
	}

	@Test
	@Tag("Positive")
	@DisplayName("Test for getting the Placeholder value")
	@Description("The test gets the value from the placeholder attribute and returns it in String format")
	void placeholder() {
		var form = PlatformApp
				.screen("MultivalueTree placeholder")
				.secondLevelView("Form")
				.form("Form title");
		form.field((w) -> new MultivalueTree<>(w, "Custom Field"))
				.checkPlaceholder(ph -> assertThat(ph).isEqualTo("Placeholder text"));
		DocShots.png(form.element(), ARTICLE, "img_plchldr_form.png", 1600, 1000);
	}

	@Test
	@Tag("Positive")
	@DisplayName("Test for getting the Placeholder value of a read-only field")
	@Description("The placeholder is shown for a field that is not enabled in the meta as well")
	void placeholderReadOnly() {
		var form = PlatformApp
				.screen("MultivalueTree placeholder")
				.secondLevelView("Form")
				.form("Form title");
		form.field((w) -> new MultivalueTree<>(w, "Custom Field RO"))
				.checkPlaceholder(ph -> assertThat(ph).isEqualTo("Placeholder text"));
	}

	@Test
	@Tag("Positive")
	@DisplayName("A test to get the field color value in Hex format")
	@Description("The test gets the value from the style attribute in RGB format, and then converts it to Hex format")
	void color() {
		var form = PlatformApp
				.screen("MultivalueTree color")
				.secondLevelView("Form")
				.form("Form title");
		form.field((w) -> new MultivalueTree<>(w, "Custom Field"))
				.checkColor(color -> assertThat(color).isNull());
	}

	@Test
	@Severity(CRITICAL)
	@Tag("Positive")
	@DisplayName("A test for setting a value in a field")
	@Description("The test sets the value in the field, and then checks the value in the field with what should be set.")
	void edit() {
		var form = PlatformApp.screen("MultivalueTree basic")
				.secondLevelView("Form")
				.form("Form title");
		DocShots.png(form.element(), ARTICLE, "img_form.png", 1600, 1000);
		form.field((w) -> new MultivalueTree<>(w, "Custom Field"))
				.setValue(List.of("Information7 data", "Information9 data", "Abs data"))
				.checkValue(val -> assertThat(val).isEqualTo(List.of("Abs data", "Information7 data", "Information9 data")));
		form.field((w) -> new MultivalueTree<>(w, "Custom Field"))
				.setValue(List.of("Abs data", "Test data", "Information data", "Information2 data",
						"Information3 data", "Information4 data", "Information5 data",
						"Information6 data", "Information7 data", "Information8 data",
						"Information9 data", "Information10 data"));
	}

	@Test
	@Tag("Positive")
	@DisplayName("A test to check the field for \"Read-only\"")
	@Description("The test checks for the disabled attribute.")
	void readonly() {
		var form = PlatformApp
				.screen("MultivalueTree readonly")
				.secondLevelView("Form")
				.form("Form title");
		form.field((w) -> new MultivalueTree<>(w, "Custom Field"))
				.checkReadOnly(iro -> assertThat(iro).isTrue());
		DocShots.png(form.element(), ARTICLE, "img_ro_form.png", 1600, 1000);
	}

	@Test
	@Severity(CRITICAL)
	@Tag("Negative")
	@DisplayName("Business Exception Validation Test")
	@Description("The test sets the value in the field. After approval, the popup window, the title, the text in it, and the buttons are validated.")
	void businessException() {
		var form = PlatformApp.screen("MultivalueTree validation business exception")
				.secondLevelView("Form")
				.form("Form title");
		var multivalue = form.field((w) -> new MultivalueTree<>(w, "Custom Field"));
		multivalue.clear();
		var error = form.errorPopup()
				.checkTitle(title -> assertThat(title).isEqualTo(Constants.ErrorPopup.TITLE))
				.checkMessage(message -> assertThat(message).isEqualTo(Constants.OnlyLetters));
		DocShots.png(ARTICLE, "img_business_error.png", 1600, 1000);
		error.close();
	}

	@Test
	@Severity(CRITICAL)
	@Tag("Negative")
	@DisplayName("Run-time exception validation test")
	@Description("The test sets the value in the field. After approval, the popup window, the title, the text in it, and the buttons are validated.")
	void runtimeException() {
		var form = PlatformApp.screen("MultivalueTree validation runtime exception")
				.secondLevelView("Form")
				.form("Form title");
		var multivalue = form.field((w) -> new MultivalueTree<>(w, "Custom Field"));
		multivalue.clearValue("Test data", false);
		var error = form.errorPopup()
				.checkTitle(title -> assertThat(title).isEqualTo(Constants.ErrorPopup.TITLE))
				.checkMessage(message -> assertThat(message).isEqualTo(Constants.SystemError));
		DocShots.png(ARTICLE, "img_runtime_error.png", 1600, 1000);
		error.close();
	}

	@Test
	@Severity(CRITICAL)
	@Tag("Positive")
	@DisplayName("Confirmation Popup Validation Test")
	@Description("The test sets the value in the field. After approval, by clicking on the save button, the popup window, the title, the text in it, and the buttons are validated.")
	void confirm() {
		var form = PlatformApp.screen("MultivalueTree validation confirm")
				.secondLevelView("Form")
				.form("Form title");
		var multivalue = form.field((w) -> new MultivalueTree<>(w, "Custom Field"));
		multivalue.setValue(List.of("Abs data"));
		form.actions().action("save").click();
		var confirm = form.confirmPopup()
				.checkTitle(title -> assertThat(title).isEqualTo(Constants.ConfirmPopup.TITLE))
				.checkMessage(message -> assertThat(message).isEqualTo(Constants.SaveValue));
		DocShots.png(ARTICLE, "confirm_form.png", 1600, 1000);
		confirm.close();
	}

	@Test
	@Severity(CRITICAL)
	@Tag("Negative")
	@DisplayName("Required Message validation test for one field")
	@Description("The test sets the value with the wrong data type in the field. After approval, it checks the text under the field, which informs about the correctness of the type of data entered.")
	void fieldLevelValidationAnnotation() {
		var form = PlatformApp.screen("MultivalueTree validation field level annotation")
				.secondLevelView("Form")
				.form("Form title");
		form.actions().action("Save").click();
		form.field((w) -> new MultivalueTree<>(w, "Custom Field"))
				.checkRequired(rm -> assertThat(rm).isEqualTo(Constants.MessageAboutError));
	}

	@Test
	@Severity(CRITICAL)
	@Tag("Negative")
	@DisplayName("Required Message validation test for multiple fields")
	@Description("The test sets a value with the wrong data type in several fields for different widgets. After approval, it checks the text under the field, which informs about the correctness of the type of data entered")
	void fieldLevelValidation() {
		var form = PlatformApp.screen("MultivalueTree validation field level dynamic")
				.secondLevelView("Form")
				.form("Form title");
		form.actions().action("Save").click();
		form.field((w) -> new MultivalueTree<>(w, "Custom Field"))
				.checkRequired(rm -> assertThat(rm).isEqualTo(Constants.RequiredField));
		form.field((w) -> new MultivalueTree<>(w, "Custom Field Additional"))
				.checkRequired(rm -> assertThat(rm).isEqualTo(Constants.RequiredField));
		DocShots.png(form.element(), ARTICLE, "img_javax_stat_form.png", 1600, 1000);
	}

	@Test
	@Severity(CRITICAL)
	@Tag("Negative")
	@DisplayName("Required Message text Verification field test")
	@Description("The test clears the field and clicks the Save button. Then validates the message that the field is required.")
	void required() {
		var form = PlatformApp.screen("MultivalueTree required")
				.secondLevelView("Form")
				.form("Form title");
		var multivalue = form.field((w) -> new MultivalueTree<>(w, "Custom Field"));
		multivalue.clear(true);
		form.actions().action("Save").click();
		multivalue.checkRequired(rm -> assertThat(rm).isEqualTo(Constants.RequiredMessage));
		DocShots.png(form.element(), ARTICLE, "img_req_form.png", 1600, 1000);
	}

	@Test
	@Severity(CRITICAL)
	@Tag("Negative")
	@DisplayName("Required Message text Verification field test")
	@Description("The test opens a modal window, clears the field, closes the window, and then checks the message under the field.")
	void required_2() {
		var form = PlatformApp.screen("MultivalueTree required")
				.secondLevelView("Form")
				.form("Form title");
		var multivalue = form.field((w) -> new MultivalueTree<>(w, "Custom Field"));
		multivalue.clear(true);
		form.actions().action("Save").click();
		multivalue.checkRequired(rm -> assertThat(rm).isEqualTo(Constants.RequiredMessage));
	}

	@Test
	@Severity(CRITICAL)
	@Tag("Negative")
	@DisplayName("Test to set all values in the field")
	@Description("The test sets all the values in the field, then checks the list with the expected value.")
	void test_set_all() {
		List<String> expected = List.of("Information10 data",
				"Information9 data",
				"Information8 data",
				"Information7 data",
				"Information6 data",
				"Information5 data",
				"Information4 data",
				"Information3 data",
				"Information2 data",
				"Information data",
				"Test data",
				"Abs data"
		);
		var form = PlatformApp.screen("MultivalueTree basic")
				.secondLevelView("Form")
				.form("Form title");
		// a tree popup has no "select all": every value is picked explicitly
		form.field((w) -> new MultivalueTree<>(w, "Custom Field"))
				.setValue(expected)
				.checkValue(v -> assertThat(v).containsExactlyInAnyOrderElementsOf(expected));
	}

	@Test
	@Severity(CRITICAL)
	@Tag("Negative")
	@DisplayName("A test for setting multiple values in a field")
	@Description("The test sets several values in the field, then checks the list with the expected value.")
	void test_set() {
		List<String> value = List.of("Information7 data", "Information9 data", "Abs data");
		List<String> expected = List.of("Abs data", "Information7 data", "Information9 data");
		var form = PlatformApp.screen("MultivalueTree basic")
				.secondLevelView("Form")
				.form("Form title");
		form.field((w) -> new MultivalueTree<>(w, "Custom Field"))
				.setValue(value)
				.checkValue(v -> assertThat(v).isEqualTo(expected));
	}

	@Test
	@Severity(CRITICAL)
	@Tag("Negative")
	@DisplayName("A test for setting a single value in a field")
	@Description("The test sets one value in the field, then checks the list with the expected value.")
	void test_once() {
		var form = PlatformApp.screen("MultivalueTree basic")
				.secondLevelView("Form")
				.form("Form title");
		form.field((w) -> new MultivalueTree<>(w, "Custom Field"))
				.setValue(List.of("Abs data"))
				.checkValue(v -> assertThat(v).isEqualTo(List.of("Abs data")));
	}

	@Test
	void position() {
		assertTrue(Position.checkPosition(302, 95, PlatformApp.screen("MultivalueTree basic").secondLevelView("Form").form("Form title").element()));
	}
}
