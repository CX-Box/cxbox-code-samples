package application.Samples.List;

import static io.qameta.allure.SeverityLevel.CRITICAL;
import static io.qameta.allure.SeverityLevel.MINOR;
import static org.assertj.core.api.Assertions.assertThat;

import application.config.BaseTestForSamples;
import core.config.Constants;
import core.element.PlatformApp;
import core.util.DocShots;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

@DisplayName("List. Checking the basic functions for the RichText in the widget List")
@Epic("Samples")
@Feature(RichTextOnListTest.ARTICLE)
@Tag("Samples")
@Tag("List")
public class RichTextOnListTest extends BaseTestForSamples {

	static final String ARTICLE = "widget/fields/field/richtext";

	static final String MAX_50_CHARACTERS = "The field can contain no more than 50 characters, formatting marks included.";

	static final String LONG_TEXT = "This note is longer than fifty characters, so it is rejected.";

	@Test
	@Severity(CRITICAL)
	@Tag("Positive")
	@DisplayName("A test for checking a value in a field")
	@Description("The cell opens the stored markdown and shows it formatted.")
	void read() {
		var list = PlatformApp.screen("RichText basic")
				.secondLevelView("List")
				.listInline("List title");
		list.rows().row(0).richText("Custom Field")
				.checkValue(value -> assertThat(value).startsWith("# Rich text").contains("A **bold** word"));
		DocShots.png(list.element(), ARTICLE, "img_list.png", 1200, 800);
	}

	@Test
	@Severity(CRITICAL)
	@Tag("Positive")
	@DisplayName("A test for setting a value in a field")
	@Description("The user opens the row for editing, types text and formats it with the toolbar; the field stores markdown. The value is not saved.")
	void edit() {
		var list = PlatformApp.screen("RichText basic")
				.secondLevelView("List")
				.listInline("List title");
		var row = list.rows().clickRow(0);
		DocShots.png(list.element(), ARTICLE, "img_edit_list.png", 1200, 800);
		row.richText("Custom Field")
				.userInput("A new note.", f -> f.bold(2, 5))
				.checkValue(value -> assertThat(value).isEqualTo("A **new** note."));
	}

	@Test
	@Tag("Positive")
	@DisplayName("Test for getting the Placeholder value")
	@Description("The empty field shows the placeholder that the meta sets.")
	void placeholder() {
		var list = PlatformApp.screen("RichText placeholder")
				.secondLevelView("List")
				.listInline("List title");
		var row = list.rows().clickRow(0);
		row.richText("Custom Field")
				.checkPlaceholder(pl -> assertThat(pl).isEqualTo("Placeholder text"));
		DocShots.png(list.element(), ARTICLE, "img_plchldr_list.png", 1200, 800);
	}

	@Test
	@Tag("Positive")
	@DisplayName("A test to check the field for \"Read-only\"")
	@Description("The field of the readonly sample cannot be edited.")
	void readonly() {
		var list = PlatformApp.screen("RichText readonly")
				.secondLevelView("List")
				.listInline("List title");
		var row = list.rows().clickRow(0);
		row.richText("Custom Field")
				.checkReadOnly(ro -> assertThat(ro).isTrue());
		DocShots.png(list.element(), ARTICLE, "img_ro_list.png", 1200, 800);
	}

	@Test
	@Severity(MINOR)
	@Tag("Positive")
	@DisplayName("Filtering test")
	@Description("The filter compares only letters and digits of the value and of the typed text: \"metal type\" finds \"Some metal type characters\" and \"**Metal** type\".")
	void filtration() {
		var list = PlatformApp.screen("RichText filtration by plain text")
				.secondLevelView("List")
				.listInline("List title");
		DocShots.gif(ARTICLE, "img_filtr_list.gif", 1660, 760, DocShots.Frame.WITHOUT_SIDEBAR);
		list.headers().filter(fb -> fb.text("Custom Field", "metal type"));
		var values = list.rows().streamCurrentPage()
				.map(r -> r.richText("Custom Field").getValue())
				.toList();
		DocShots.stop();
		assertThat(values).containsExactlyInAnyOrder(
				"**Metal** type: a font would not include a single definition of each character.",
				"Some metal type characters, such as ~~dashes~~ and spaces, were generic pieces.");
		list.headers().clearFilters();
	}

	@Test
	@Severity(MINOR)
	@Tag("Positive")
	@DisplayName("Filtering test, default: the stored markdown")
	@Description("The default filter searches the stored markdown: \"metal type\" finds \"Some metal type characters\", but not \"**Metal** type\", where the bold marks stand between the words.")
	void filtrationDefault() {
		var list = PlatformApp.screen("RichText filtration")
				.secondLevelView("List")
				.listInline("List title");
		DocShots.gif(ARTICLE, "img_filtr_default_list.gif", 1660, 760, DocShots.Frame.WITHOUT_SIDEBAR);
		list.headers().filter(fb -> fb.text("Custom Field", "metal type"));
		var values = list.rows().streamCurrentPage()
				.map(r -> r.richText("Custom Field").getValue())
				.toList();
		DocShots.stop();
		assertThat(values).isEqualTo(List.of("Some metal type characters, such as ~~dashes~~ and spaces, were generic pieces."));
		list.headers().clearFilters();
	}

	@Test
	@Severity(MINOR)
	@Tag("Positive")
	@DisplayName("Sorting test")
	@Description("Sorting by the specified column.")
	void sorting() {
		var list = PlatformApp.screen("RichText sorting")
				.secondLevelView("List")
				.listInline("List title");
		list.headers().sort(sb -> sb.sort("Custom Field"));
		var values = list.rows().streamCurrentPage()
				.map(r -> r.richText("Custom Field").getValue())
				.toList();
		assertThat(values).isEqualTo(List.of(
				"The rest of the characters would be provided in *quantities* appropriate for the language.",
				"Some metal type characters, such as ~~dashes~~ and spaces, were generic pieces.",
				"**Metal** type: a font would not include a single definition of each character.",
				"A typeface may come in fonts of many {blue}(weights), from ultra-light to extra-bold."
		));
		DocShots.png(list.element(), ARTICLE, "img_sort_list.png", 1200, 800);
	}

	@Test
	@Severity(CRITICAL)
	@Tag("Negative")
	@DisplayName("Business Exception Validation Test")
	@Description("The user types a value longer than 50 characters. The error popup, its title and its message are validated.")
	void businessException() {
		var list = PlatformApp.screen("RichText validation business exception")
				.secondLevelView("List")
				.listInline("List title");
		var row = list.rows().clickRow(0);
		row.richText("Custom Field").userInput(LONG_TEXT, f -> {
		});
		list.errorPopup()
				.checkTitleAndMessage(
						title -> assertThat(title).isEqualTo(Constants.ErrorPopup.TITLE),
						message -> assertThat(message).isEqualTo(MAX_50_CHARACTERS))
				.close();
	}

	@Test
	@Severity(CRITICAL)
	@Tag("Negative")
	@DisplayName("Run-time exception validation test")
	@Description("The user types a value. The error popup, its title and its message are validated.")
	void runtimeException() {
		var list = PlatformApp.screen("RichText validation runtime exception")
				.secondLevelView("List")
				.listInline("List title");
		var row = list.rows().clickRow(0);
		row.richText("Custom Field").userInput("A new note.", f -> {
		});
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
	@Description("The user types a value and clicks Save. The confirm popup, its title and its message are validated. The value is then set back.")
	void confirm() {
		var list = PlatformApp.screen("RichText validation confirm")
				.secondLevelView("List")
				.listInline("List title");
		var row = list.rows().clickRow(0);
		row.richText("Custom Field").userInput("A new note.", f -> {
		});
		row.burgerAction("save").click();
		list.confirmPopup()
				.checkTitleAndMessage(
						title -> assertThat(title).isEqualTo(Constants.ConfirmPopup.TITLE),
						message -> assertThat(message).isEqualTo(Constants.SaveValue))
				.clickOk();
		row = list.rows().clickRow(0);
		row.richText("Custom Field").userInput("A short note.", f -> f.bold(2, 7));
		row.burgerAction("save").click();
		list.confirmPopup().clickOk();
	}

	@Test
	@Severity(CRITICAL)
	@Tag("Negative")
	@DisplayName("Required Message validation test for one field")
	@Description("The user types a value longer than 50 characters and clicks Save. The message of the field is validated.")
	void fieldLevelValidationAnnotation() {
		var list = PlatformApp.screen("RichText validation field level annotation")
				.secondLevelView("List")
				.listInline("List title");
		var row = list.rows().clickRow(0);
		var field = row.richText("Custom Field");
		field.userInput(LONG_TEXT, f -> {
		});
		row.burgerAction("Save").click();
		field.checkRequired(message -> assertThat(message).isEqualTo(MAX_50_CHARACTERS));
	}

	@Test
	@Severity(CRITICAL)
	@Tag("Negative")
	@DisplayName("Required Message validation test for multiple fields")
	@Description("The user types values longer than 50 characters in two fields and clicks Save. The messages of both fields are validated.")
	void fieldLevelValidation() {
		var list = PlatformApp.screen("RichText validation field level dynamic")
				.secondLevelView("List")
				.listInline("List title");
		var row = list.rows().clickRow(0);
		var customField = row.richText("Custom Field");
		var customFieldAdditional = row.richText("Custom FieldAdditional");
		customField.userInput(LONG_TEXT, f -> {
		});
		customFieldAdditional.userInput(LONG_TEXT, f -> {
		});
		row.burgerAction("Save").click();
		customField.checkRequired(message -> assertThat(message)
				.isEqualTo("The field 'customField' can contain no more than 50 characters."));
		customFieldAdditional.checkRequired(message -> assertThat(message)
				.isEqualTo("The field 'customFieldAdditional' can contain no more than 50 characters."));
	}

	@Test
	@Severity(CRITICAL)
	@Tag("Negative")
	@DisplayName("Required Message text Verification field test")
	@Description("The user empties the field and clicks Save. The message that the field is required is validated.")
	void required() {
		var list = PlatformApp.screen("RichText required")
				.secondLevelView("List")
				.listInline("List title");
		var row = list.rows().clickRow(0);
		var field = row.richText("Custom Field");
		field.clear();
		row.burgerAction("Save").click();
		field.checkRequired(message -> assertThat(message).isEqualTo(Constants.RequiredMessage));
		DocShots.png(list.element(), ARTICLE, "img_req_list.png", 1200, 800);
	}

	@Test
	@Tag("Positive")
	@DisplayName("The height of the field")
	@Description("Two lists of the same record: with the default height and with maxRows 2, where the value is cut and shows \"...\".")
	void height() {
		var view = PlatformApp.screen("RichText height")
				.secondLevelView("List");
		var byDefault = view.listInline("Default: minRows 1, maxRows 10");
		byDefault.rows().row(0).richText("Custom Field")
				.checkValue(value -> assertThat(value).startsWith("# Meeting notes"));
		DocShots.png(byDefault.element(), ARTICLE, "img_height_list_default.png", 1200, 800);
		var widget = view.listInline("maxRows 2, editMinRows 3, editMaxRows 6");
		widget.rows().row(0).richText("Custom Field")
				.checkTruncated(truncated -> assertThat(truncated).isTrue());
		DocShots.png(widget.element(), ARTICLE, "img_height_list.png", 1200, 800);
	}

}
