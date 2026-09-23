package application.Samples.Form;

import static io.qameta.allure.SeverityLevel.CRITICAL;
import static org.assertj.core.api.Assertions.assertThat;

import application.config.BaseTestForSamples;
import core.config.Constants;
import core.element.PlatformApp;
import core.element.widget.field.type.richtext.RichTextAction;
import core.util.DocShots;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

/** The properties of the RichText field on a Form, as the article shows them. Formatting cases are in {@link RichTextOnFormTest}. */
@DisplayName("Form. Checking the basic functions for the RichText in the widget Form")
@Epic("Samples")
@Feature(RichTextFieldOnFormTest.ARTICLE)
@Tag("Samples")
@Tag("Form")
public class RichTextFieldOnFormTest extends BaseTestForSamples {

	static final String ARTICLE = "widget/fields/field/richtext";

	static final String MAX_50_CHARACTERS = "The field can contain no more than 50 characters, formatting marks included.";

	static final String LONG_TEXT = "This note is longer than fifty characters, so it is rejected.";

	@Test
	@Severity(CRITICAL)
	@Tag("Positive")
	@DisplayName("A test for checking a value in a field")
	@Description("The field opens the stored markdown and shows it formatted.")
	void read() {
		var form = PlatformApp.screen("RichText basic")
				.secondLevelView("Form")
				.form("Form title");
		form.richText("Custom Field")
				.checkValue(value -> assertThat(value).startsWith("# Rich text").contains("A **bold** word"));
		DocShots.png(form.element(), ARTICLE, "img_form.png", 1200, 800);
	}

	@Test
	@Severity(CRITICAL)
	@Tag("Positive")
	@DisplayName("A test for setting a value in a field")
	@Description("The user types text and formats it with the toolbar; the field stores markdown. The value is not saved.")
	void edit() {
		var form = PlatformApp.screen("RichText basic")
				.secondLevelView("Form")
				.form("Form title");
		DocShots.png(form.element(), ARTICLE, "img_edit_form.png", 1200, 800);
		form.richText("Custom Field")
				.userInput("A new note.", f -> f.bold(2, 5))
				.checkValue(value -> assertThat(value).isEqualTo("A **new** note."));
	}

	@Test
	@Tag("Positive")
	@DisplayName("Formatting with the toolbar")
	@Description("The user types three paragraphs, makes the first a heading, the other two a bulleted list, one word bold and one word green. The value is not saved.")
	void formatting() {
		var form = PlatformApp.screen("RichText basic")
				.secondLevelView("Form")
				.form("Form title");
		var field = form.richText("Custom Field");
		field.userInput("Agenda\n\nPrepare the contract\n\nAgree the schedule", f -> f
				.heading(2, 0, 6)
				.bulletList(7, 46)
				.bold(19, 27)
				.color("green", 38, 46));
		field.checkValue(value -> assertThat(value)
				.isEqualTo("## Agenda\n\n- Prepare the **contract**\n- Agree the {green}(schedule)"));
	}

	@Test
	@Tag("Positive")
	@DisplayName("Switching between the visual editor and the markdown markup")
	@Description("Settings - Markdown markup shows the stored markdown, Settings - Visual Editor goes back. The value is not changed.")
	void markdownMode() {
		var form = PlatformApp.screen("RichText basic")
				.secondLevelView("Form")
				.form("Form title");
		var field = form.richText("Custom Field");
		DocShots.png(form.element(), ARTICLE, "img_visual_mode.png", 1200, 800);
		field.click(RichTextAction.MARKDOWN_SOURCE);
		DocShots.png(form.element(), ARTICLE, "img_markdown_mode.png", 1200, 800);
		field.click(RichTextAction.VISUAL_EDITOR);
		field.checkValue(value -> assertThat(value).startsWith("# Rich text"));
	}

	@Test
	@Tag("Positive")
	@DisplayName("Test for getting the Placeholder value")
	@Description("The empty field shows the placeholder that the meta sets.")
	void placeholder() {
		var form = PlatformApp.screen("RichText placeholder")
				.secondLevelView("Form")
				.form("Form title");
		form.richText("Custom Field")
				.checkPlaceholder(pl -> assertThat(pl).isEqualTo("Placeholder text"));
		DocShots.png(form.element(), ARTICLE, "img_plchldr_form.png", 1200, 800);
	}

	@Test
	@Tag("Positive")
	@DisplayName("A test to check the field for \"Read-only\"")
	@Description("The field of the readonly sample cannot be edited.")
	void readonly() {
		var form = PlatformApp.screen("RichText readonly")
				.secondLevelView("Form")
				.form("Form title");
		form.richText("Custom Field")
				.checkReadOnly(ro -> assertThat(ro).isTrue());
		DocShots.png(form.element(), ARTICLE, "img_ro_form.png", 1200, 800);
	}

	@Test
	@Severity(CRITICAL)
	@Tag("Negative")
	@DisplayName("Business Exception Validation Test")
	@Description("The user types a value longer than 50 characters. The error popup, its title and its message are validated.")
	void businessException() {
		var form = PlatformApp.screen("RichText validation business exception")
				.secondLevelView("Form")
				.form("Form title");
		form.richText("Custom Field").userInput(LONG_TEXT, f -> {
		});
		var popup = form.errorPopup()
				.checkTitleAndMessage(
						title -> assertThat(title).isEqualTo(Constants.ErrorPopup.TITLE),
						message -> assertThat(message).isEqualTo(MAX_50_CHARACTERS));
		DocShots.png(ARTICLE, "img_business_error.png", 1200, 800);
		popup.close();
	}

	@Test
	@Severity(CRITICAL)
	@Tag("Negative")
	@DisplayName("Run-time exception validation test")
	@Description("The user types a value. The error popup, its title and its message are validated.")
	void runtimeException() {
		var form = PlatformApp.screen("RichText validation runtime exception")
				.secondLevelView("Form")
				.form("Form title");
		form.richText("Custom Field").userInput("A new note.", f -> {
		});
		var popup = form.errorPopup()
				.checkTitleAndMessage(
						title -> assertThat(title).isEqualTo(Constants.ErrorPopup.TITLE),
						message -> assertThat(message).isEqualTo(Constants.SystemError));
		DocShots.png(ARTICLE, "img_runtime_error.png", 1200, 800);
		popup.close();
	}

	@Test
	@Severity(CRITICAL)
	@Tag("Positive")
	@DisplayName("Confirmation Popup Validation Test")
	@Description("The user types a value and clicks Save. The confirm popup, its title and its message are validated. The value is then set back.")
	void confirm() {
		var form = PlatformApp.screen("RichText validation confirm")
				.secondLevelView("Form")
				.form("Form title");
		var field = form.richText("Custom Field");
		field.userInput("A new note.", f -> {
		});
		form.actions().action("save").click();
		form.confirmPopup()
				.checkTitleAndMessage(
						title -> assertThat(title).isEqualTo(Constants.ConfirmPopup.TITLE),
						message -> assertThat(message).isEqualTo(Constants.SaveValue));
		DocShots.png(ARTICLE, "img_confirm_form.png", 1200, 800);
		form.confirmPopup().clickOk();
		field.userInput("A short note.", f -> f.bold(2, 7));
		form.actions().action("save").click();
		form.confirmPopup().clickOk();
	}

	@Test
	@Severity(CRITICAL)
	@Tag("Negative")
	@DisplayName("Required Message validation test for one field")
	@Description("The user types a value longer than 50 characters and clicks Save. The message under the field is validated.")
	void fieldLevelValidationAnnotation() {
		var form = PlatformApp.screen("RichText validation field level annotation")
				.secondLevelView("Form")
				.form("Form title");
		var field = form.richText("Custom Field");
		field.userInput(LONG_TEXT, f -> {
		});
		form.actions().action("Save").click();
		field.checkRequired(message -> assertThat(message).isEqualTo(MAX_50_CHARACTERS));
		DocShots.png(form.element(), ARTICLE, "img_javax_stat_form.png", 1200, 800);
	}

	@Test
	@Severity(CRITICAL)
	@Tag("Negative")
	@DisplayName("Required Message validation test for multiple fields")
	@Description("The user types values longer than 50 characters in two fields and clicks Save. The messages under both fields are validated.")
	void fieldLevelValidation() {
		var form = PlatformApp.screen("RichText validation field level dynamic")
				.secondLevelView("Form")
				.form("Form title");
		var customField = form.richText("Custom Field");
		var customFieldAdditional = form.richText("Custom FieldAdditional");
		customField.userInput(LONG_TEXT, f -> {
		});
		customFieldAdditional.userInput(LONG_TEXT, f -> {
		});
		form.actions().action("Save").click();
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
		var form = PlatformApp.screen("RichText required")
				.secondLevelView("Form")
				.form("Form title");
		var field = form.richText("Custom Field");
		field.clear();
		form.actions().action("Save").click();
		field.checkRequired(message -> assertThat(message).isEqualTo(Constants.RequiredMessage));
		DocShots.png(form.element(), ARTICLE, "img_req_form.png", 1200, 800);
	}

	@Test
	@Tag("Positive")
	@DisplayName("The height of the field")
	@Description("Two forms of the same record: with the default editor height and with editMinRows 3, editMaxRows 6.")
	void height() {
		var view = PlatformApp.screen("RichText height")
				.secondLevelView("Form");
		var byDefault = view.form("Default: editMinRows 5, editMaxRows 10");
		byDefault.richText("Custom Field")
				.checkValue(value -> assertThat(value).startsWith("# Meeting notes"));
		DocShots.png(byDefault.element(), ARTICLE, "img_height_form_default.png", 1200, 800);
		var widget = view.form("editMinRows 3, editMaxRows 6");
		widget.richText("Custom Field")
				.checkValue(value -> assertThat(value).startsWith("# Meeting notes"));
		DocShots.png(widget.element(), ARTICLE, "img_height_form.png", 1200, 800);
	}

}
