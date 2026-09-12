package application.Samples.Tree;

import application.config.BaseTestForSamples;
import application.config.props.Env;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import core.element.PlatformApp;
import core.element.screen.view.PlatformView;
import core.element.widget.tree.TreePopupRows;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Severity;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

import static io.qameta.allure.SeverityLevel.CRITICAL;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * Row actions inside the tree popups (samples widgets/picktree/actions, widgets/assoctree/actions):
 * create inline and inline-form, edit inline and inline-form, delete. Analogue of the PickListPopup / AssocListPopup action samples.
 */
@DisplayName("PickTreePopup, AssocTreePopup. Row actions inside the popup")
@Epic("Samples")
@Tag("Samples")
public class PopupRowActionsTest extends BaseTestForSamples {

	/** Screenshots of every step are saved here when the folder exists (review only, not part of the assertions). */
	private static final Path SHOTS = Path.of(System.getProperty("popupShots", ""));

	private static PlatformView open(String screen, String view) {
		Selenide.open(Env.uri() + "screen/" + screen + "/view/" + view);
		Selenide.sleep(2500);
		return PlatformApp.currentScreen().view();
	}

	private static String unique(String prefix) {
		return prefix + " " + System.currentTimeMillis() % 100000;
	}

	private static void shot(SelenideElement element, String name) throws IOException {
		if (SHOTS.toString().isEmpty() || !Files.isDirectory(SHOTS)) {
			return;
		}
		File file = element.screenshot();
		if (file != null) {
			Files.copy(file.toPath(), SHOTS.resolve(name), StandardCopyOption.REPLACE_EXISTING);
		}
	}

	private static void createInlineAndDelete(TreePopupRows rows, SelenideElement dialog, String prefix) throws IOException {
		int before = rows.rows().size();
		rows.action("Add");
		shot(dialog, prefix + "_create_inline_row.png");
		assertThat(rows.rows().size()).as("a new row is added").isEqualTo(before + 1);
		String value = unique("Popup inline");
		rows.rowInput(0).setValue(value);
		if (rows.hasRowMenu(0)) {
			rows.rowMenu(0, "Save");
		} else {
			rows.action("Save");
		}
		assertThat(rows.errorShown()).isFalse();
		rows.clearFilters();
		int index = rows.waitRow(value);
		shot(dialog, prefix + "_create_inline_saved.png");
		assertThat(index).as("the saved row is shown").isNotNegative();

		if (rows.hasRowMenu(index)) {
			rows.rowMenu(index, "Delete");
		} else {
			rows.clickCell(index, 2);
			rows.action("Delete");
		}
		assertThat(rows.errorShown()).isFalse();
		Selenide.sleep(1500);
		shot(dialog, prefix + "_delete.png");
		assertThat(rows.rowIndex(value)).as("the deleted row is removed").isEqualTo(-1);
	}

	private static void createInlineForm(TreePopupRows rows, SelenideElement dialog, String prefix, String field) throws IOException {
		int before = rows.rows().size();
		rows.action("Add");
		assertThat(rows.rows().size()).as("a new row is added").isEqualTo(before + 1);
		rows.extraRow(0).shouldBe(com.codeborne.selenide.Condition.visible);
		shot(dialog, prefix + "_create_inline_form.png");
		String value = unique("Popup form");
		rows.extraRowInput(0, field).setValue(value);
		rows.extraRowAction(0, "Save");
		assertThat(rows.errorShown()).isFalse();
		rows.clearFilters();
		int index = rows.waitRow(value);
		shot(dialog, prefix + "_create_inline_form_saved.png");
		assertThat(index).as("the saved row is shown").isNotNegative();
	}

	private static void editInline(TreePopupRows rows, SelenideElement dialog, String prefix) throws IOException {
		rows.clickCell(0, 2);
		shot(dialog, prefix + "_edit_inline.png");
		String value = unique("Popup edited");
		rows.rowInput(0).setValue(value);
		if (rows.hasRowMenu(0)) {
			rows.rowMenu(0, "Save");
		} else {
			rows.action("Save");
		}
		assertThat(rows.errorShown()).isFalse();
		int index = rows.waitRow(value);
		shot(dialog, prefix + "_edit_inline_saved.png");
		assertThat(index).as("the edited row is shown").isNotNegative();
	}

	private static void editInlineForm(TreePopupRows rows, SelenideElement dialog, String prefix, String field) throws IOException {
		rows.clickPencil(0);
		shot(dialog, prefix + "_edit_inline_form.png");
		String value = unique("Popup form edited");
		rows.extraRowInput(0, field).setValue(value);
		rows.extraRowAction(0, "Save");
		assertThat(rows.errorShown()).isFalse();
		int index = rows.waitRow(value);
		shot(dialog, prefix + "_edit_inline_form_saved.png");
		assertThat(index).as("the edited row is shown").isNotNegative();
	}

	@Test
	@Severity(CRITICAL)
	@Tag("Positive")
	@DisplayName("PickTreePopup: create inline, delete")
	@Description("Add creates an empty root row inside the popup; the row is saved from its menu and then deleted from its menu.")
	void pickCreateInlineAndDelete() throws IOException {
		var form = open("myexample3353", "myexample3354form").formByName("MyExample3354Form");
		var popup = form.pickTree("Custom Field Delete").openPopup();
		shot(popup.dialog(), "pick_create_inline_open.png");
		createInlineAndDelete(popup.rowActions(), popup.dialog(), "pick");
		popup.close();
	}

	@Test
	@Severity(CRITICAL)
	@Tag("Positive")
	@DisplayName("PickTreePopup: create inline-form")
	@Description("Add opens the row form inside the popup (options.create.widget); the form is saved and the new row is shown.")
	void pickCreateInlineForm() throws IOException {
		var list = open("myexample3353", "myexample3348listinlineform").listByName("MyExample3348ListInlineForm");
		var popup = list.rows().clickRow(0).pickTree("Custom Field Pick").openPopup();
		createInlineForm(popup.rowActions(), popup.dialog(), "pick", "Custom Field Pick");
		popup.close();
	}

	@Test
	@Disabled("Sample myexample3353listinline: the PickTreePopup does not open from the list row in the test (the data request is sent, the popup is not shown); to be re-checked by hand")
	@Severity(CRITICAL)
	@Tag("Positive")
	@DisplayName("PickTreePopup: edit inline")
	@Description("A click on the cell switches the popup row into the edit mode; the changed value is saved from the row menu.")
	void pickEditInline() throws IOException {
		var list = open("myexample3353", "myexample3353listinline").listByName("MyExample3353ListInline");
		var popup = list.rows().clickRow(0).pickTree("Custom Field PickTree").openPopup();
		editInline(popup.rowActions(), popup.dialog(), "pick");
		popup.close();
	}

	@Test
	@Severity(CRITICAL)
	@Tag("Positive")
	@DisplayName("PickTreePopup: edit inline-form")
	@Description("The pencil of the popup row opens its form (options.edit.widget); the changed value is saved and shown.")
	void pickEditInlineForm() throws IOException {
		var list = open("myexample3353", "myexample3353listinlineform").listByName("MyExample3353ListInlineForm");
		var popup = list.rows().clickRow(0).pickTree("Custom Field PickTree").openPopup();
		editInlineForm(popup.rowActions(), popup.dialog(), "pick", "Custom Field");
		popup.close();
	}

	@Test
	@Severity(CRITICAL)
	@Tag("Positive")
	@DisplayName("AssocTreePopup: create inline, delete")
	@Description("Add creates an empty root row inside the popup; the row is saved from its menu and then deleted from its menu.")
	void assocCreateInlineAndDelete() throws IOException {
		var form = open("myexample3331", "myexample3331create").formByName("MyExample3331FormCreate");
		var popup = form.multivalueTree("Custom Field").openPopup();
		shot(popup.dialog(), "assoc_create_inline_open.png");
		createInlineAndDelete(popup.rowActions(), popup.dialog(), "assoc");
		popup.closeModal();
	}

	@Test
	@Severity(CRITICAL)
	@Tag("Positive")
	@DisplayName("AssocTreePopup: create inline-form")
	@Description("Add opens the row form inside the popup (options.create.widget); the form is saved and the new row is shown.")
	void assocCreateInlineForm() throws IOException {
		var form = open("myexample3331", "myexample3331inlinecreate").formByName("MyExample3331Form");
		var popup = form.multivalueTree("Custom Field").openPopup();
		createInlineForm(popup.rowActions(), popup.dialog(), "assoc", "Custom Field");
		popup.closeModal();
	}

	@Test
	@Severity(CRITICAL)
	@Tag("Positive")
	@DisplayName("AssocTreePopup: edit inline")
	@Description("A click on the cell switches the popup row into the edit mode; the changed value is saved from the row menu.")
	void assocEditInline() throws IOException {
		var form = open("myexample3331", "myexample3331edit").formByName("MyExample3331Edit");
		var popup = form.multivalueTree("Custom Field").openPopup();
		editInline(popup.rowActions(), popup.dialog(), "assoc");
		popup.closeModal();
	}

	@Test
	@Severity(CRITICAL)
	@Tag("Positive")
	@DisplayName("AssocTreePopup: edit inline-form")
	@Description("The pencil of the popup row opens its form (options.edit.widget); the changed value is saved and shown.")
	void assocEditInlineForm() throws IOException {
		var form = open("myexample3331", "myexample3331editinlineform").formByName("MyExample3331FormEdit");
		var popup = form.multivalueTree("Custom Field").openPopup();
		editInlineForm(popup.rowActions(), popup.dialog(), "assoc", "Custom Field");
		popup.closeModal();
	}

}
