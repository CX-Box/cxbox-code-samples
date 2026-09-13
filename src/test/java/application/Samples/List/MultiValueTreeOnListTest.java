package application.Samples.List;

import application.config.BaseTestForSamples;
import application.custom.Position;
import core.config.Constants;
import core.element.PlatformApp;
import core.util.DocShots;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
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
import static org.junit.jupiter.api.Assertions.assertTrue;

@DisplayName("List. Checking the basic functions for the MultiValueTree in the widget List")
@Epic("Samples")
@Feature(MultiValueTreeOnListTest.ARTICLE)
@Tag("Samples")
@Tag("List")
public class MultiValueTreeOnListTest extends BaseTestForSamples {

	static final String ARTICLE = "widget/fields/field/multivalueTree";

	@Disabled("Checked at filtration and sorting")
	@Test
	@Severity(CRITICAL)
	@Tag("Positive")
	@DisplayName("A test for checking a value in a field")
	@Description("The test gets the value in the field, and then checks the value in the field with what should be.")
	void read() {
//        PlatformApp.screen("MultivalueTree basic")
//              .secondLevelView("List")
//              .listInline("List title")
//              .rows().row(1)
//              .multivalueTree("Custom Field")
//              .checkValue(value->assertThat(value).isEqualTo("Abs data,..."));
	}

	@Test
	@Severity(MINOR)
	@Tag("Positive")
	@DisplayName("Filtering test")
	@Description("Filtering by the specified column.")
	void filtration() {
		var list = PlatformApp.screen("MultivalueTree filtration")
				.secondLevelView("List")
				.listInline("List title");
		list.headers().filter(fb -> fb.multivalueTree("Custom Field", List.of("Test3 data")));
		var values = list.rows().streamCurrentPage()
				.map(r -> r.multivalueTree("Custom Field").getValue())
				.collect(Collectors.toList());
		assertThat(values).isNotEmpty();
		assertThat(values).allMatch(v -> v.contains("Test3 data"));
		DocShots.png(list.element(), ARTICLE, "img_filtr_list.png", 1600, 1000);
	}

	@Test
	@Tag("Positive")
	@DisplayName("Test for getting the Placeholder value")
	@Description("The test gets the value from the placeholder attribute and returns it in String format")
	void placeholder() {
		var list = PlatformApp.screen("MultivalueTree placeholder")
				.secondLevelView("List")
				.listInline("List title");
		var row = list.rows().clickRow(0);
		row.multivalueTree("Custom Field")
				.checkPlaceholder(pl -> assertThat(pl).isEqualTo("Placeholder text"));
	}

	@Test
	@Tag("Positive")
	@DisplayName("A test to get the field color value in Hex format")
	@Description("The test gets the value from the style attribute in RGB format, and then converts it to Hex format")
	void color() {
		var list = PlatformApp.screen("MultivalueTree color")
				.secondLevelView("List")
				.listInline("List title");
		var row = list.rows().row(0);
		row.multivalueTree("Custom Field")
				.checkColor(color -> assertThat(color).isEqualTo("#EDA6A6"));
		DocShots.png(list.element(), ARTICLE, "img_color_list.png", 1600, 1000);
	}

	@Test
	@Tag("Positive")
	@DisplayName("A test to check the field for \"Read-only\"")
	@Description("The test checks for the disabled attribute.")
	void readonly() {
		var list = PlatformApp.screen("MultivalueTree readonly")
				.secondLevelView("List")
				.listInline("List title");
		var row = list.rows().clickRow(0);
		row.multivalueTree("Custom Field")
				.checkReadOnly(ro -> assertThat(ro).isTrue());
		DocShots.png(list.element(), ARTICLE, "img_ro_list.png", 1600, 1000);
	}

	@Test
	@Severity(CRITICAL)
	@Tag("Positive")
	@DisplayName("A test for setting a value in a field")
	@Description("The test sets the value in the field, and then checks the value in the field with what should be set.")
	void edit() {
		var list = PlatformApp.screen("MultivalueTree basic")
				.secondLevelView("List")
				.listInline("List title");
		var row = list.rows().clickRow(0);
		DocShots.png(list.element(), ARTICLE, "img_list.png", 1600, 1000);
		row.multivalueTree("Custom Field")
				.setValue(List.of("Information7 data", "Information9 data", "Abs data"))
				.checkValue(val -> assertThat(val).isEqualTo(List.of("Information9 data", "Information7 data", "Abs data")));
		row.multivalueTree("Custom Field")
				.setValue(List.of("Abs data", "Test data", "Information data", "Information2 data",
						"Information3 data", "Information4 data", "Information5 data",
						"Information6 data", "Information7 data", "Information8 data",
						"Information9 data", "Information10 data"));
	}

	@Test
	@Severity(CRITICAL)
	@Tag("Negative")
	@DisplayName("Business Exception Validation Test")
	@Description("The test sets the value in the field. After approval, the popup window, the title, the text in it, and the buttons are validated.")
	void businessException() {
		var list = PlatformApp.screen("MultivalueTree validation business exception")
				.secondLevelView("List")
				.listInline("List title");
		var row = list.rows().clickRow(0);
		row.multivalueTree("Custom Field").clearWithModal();
		var error = list.errorPopup()
				.checkTitleAndMessage(
						title -> assertThat(title).isEqualTo(Constants.ErrorPopup.TITLE),
						message -> assertThat(message).isEqualTo(Constants.OnlyLetters));
		DocShots.png(ARTICLE, "img_business_error_list.png", 1600, 1000);
		error.close();
	}

	@Test
	@Severity(CRITICAL)
	@Tag("Negative")
	@DisplayName("Run-time exception validation test")
	@Description("The test sets the value in the field. After approval, the popup window, the title, the text in it, and the buttons are validated.")
	void runtimeException() {
		var list = PlatformApp.screen("MultivalueTree validation runtime exception")
				.secondLevelView("List")
				.listInline("List title");
		var row = list.rows().clickRow(0);
		row.multivalueTree("Custom Field").deleteValueFromField();
		var error = list.errorPopup()
				.checkTitleAndMessage(
						title -> assertThat(title).isEqualTo(Constants.ErrorPopup.TITLE),
						message -> assertThat(message).isEqualTo(Constants.SystemError));
		DocShots.png(ARTICLE, "img_runtime_error_list.png", 1600, 1000);
		error.close();
	}

	@Test
	@Severity(CRITICAL)
	@Tag("Positive")
	@DisplayName("Confirmation Popup Validation Test")
	@Description("The test sets the value in the field. After approval, by clicking on the save button, the popup window, the title, the text in it, and the buttons are validated.")
	void confirm() {
		var list = PlatformApp.screen("MultivalueTree validation confirm")
				.secondLevelView("List")
				.listInline("List title");
		var row = list.rows().clickRow(0);
		row.multivalueTree("Custom Field").setValue(List.of("Abs data"));
		row.burgerAction("save").click();
		var confirm = list.confirmPopup()
				.checkTitleAndMessage(
						title -> assertThat(title).isEqualTo(Constants.ConfirmPopup.TITLE),
						message -> assertThat(message).isEqualTo(Constants.SaveValue));
		DocShots.png(ARTICLE, "confirm_list.png", 1600, 1000);
		confirm.close();
	}

	@Test
	@Severity(CRITICAL)
	@Tag("Negative")
	@DisplayName("Required Message validation test for one field")
	@Description("The test sets the value with the wrong data type in the field. After approval, it checks the text under the field, which informs about the correctness of the type of data entered.")
	void fieldLevelValidationAnnotation() {
		var list = PlatformApp.screen("MultivalueTree validation field level annotation")
				.secondLevelView("List")
				.listInline("List title");
		var row = list.rows().clickRow(0);
		row.burgerAction("Save").click();
		list.rows().row(0)
				.multivalueTree("Custom Field")
				.checkRequired(message -> assertThat(message).isEqualTo(Constants.MessageAboutError));
	}

	@Test
	@Severity(CRITICAL)
	@Tag("Negative")
	@DisplayName("Required Message validation test for multiple fields")
	@Description("The test sets a value with the wrong data type in several fields for different widgets. After approval, it checks the text under the field, which informs about the correctness of the type of data entered")
	void fieldLevelValidation() {
		var list = PlatformApp.screen("MultivalueTree validation field level dynamic")
				.secondLevelView("List")
				.listInline("List title");
		var row = list.rows().clickRow(0);
		row.burgerAction("Save").click();
		var editRow = list.rows().row(0);
		var customField = editRow.multivalueTree("Custom Field");
		var customFieldAdditional = editRow.multivalueTree("Custom Field Additional");
		customField.checkRequired(message -> assertThat(message).isEqualTo(Constants.RequiredField));
		customFieldAdditional.checkRequired(message -> assertThat(message).isEqualTo(Constants.RequiredField));
		DocShots.png(list.element(), ARTICLE, "img_javax_stat_list.png", 1600, 1000);
	}

	@Test
	@Severity(CRITICAL)
	@Tag("Negative")
	@DisplayName("Required Message text Verification field test")
	@Description("The test clears the field and clicks the Save button. Then validates the message that the field is required.")
	void required() {
		var list = PlatformApp.screen("MultivalueTree required")
				.secondLevelView("List")
				.listInline("List title");
		var row = list.rows().clickRow(0);
		row.multivalueTree("Custom Field").clear();
		row.burgerAction("Save").click();
		list.rows().row(0)
				.multivalueTree("Custom Field")
				.checkRequired(message -> assertThat(message).isEqualTo(Constants.RequiredMessage));
		DocShots.png(list.element(), ARTICLE, "img_req_list.png", 1600, 1000);
	}

	@Test
	@Severity(CRITICAL)
	@Tag("Negative")
	@DisplayName("Required Message text Verification field test")
	@Description("The test opens a modal window, clears the field, closes the window, and then checks the message under the field.")
	void required_2() {
		var list = PlatformApp.screen("MultivalueTree required")
				.secondLevelView("List")
				.listInline("List title");
		var row = list.rows().clickRow(0);
		row.multivalueTree("Custom Field").clearWithModal(true);
		row.burgerAction("Save").click();
		list.rows().row(0)
				.multivalueTree("Custom Field")
				.checkRequired(message -> assertThat(message).isEqualTo(Constants.RequiredMessage));
	}

	@Test
	void position() {

		assertTrue(Position.checkPosition(302, 94, PlatformApp.screen("Multifield basic").secondLevelView("List").listInline("List title").element()));
	}
}
