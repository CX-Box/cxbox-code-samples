package application.Samples.Tree;

import application.config.BaseTestForSamples;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverConditions;
import com.codeborne.selenide.WebDriverRunner;
import core.element.PlatformApp;
import core.element.widget.list.ListWidget;
import core.element.widget.list.realization.form.tree.PlatformTreePopupWidgetInlineForm;
import core.element.widget.list.realization.inline.tree.PlatformTreePopupWidgetInline;
import core.element.widget.tree.TreeNavigation;
import core.util.DocShots;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.SeverityLevel.CRITICAL;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * Row actions inside the tree popups (samples widgets/picktree/actions, widgets/assoctree/actions):
 * create inline and inline-form, edit inline (assoc only: a click in a pick popup picks the value) and inline-form, delete, cancel.
 * The tree of the popup is driven with the standard Tree API ({@code popup.tree()}), as in {@link TreeActionsTest}.
 */
@DisplayName("PickTreePopup, AssocTreePopup. Row actions inside the popup")
@Epic("Samples")
@Tag("Samples")
public class PopupRowActionsTest extends BaseTestForSamples {

	static final String PICK = "widget/type/picktreepopup";

	static final String ASSOC = "widget/type/assoctreepopup";

	private static final String FIELD = "Custom Field";


	private static String unique(String prefix) {
		return prefix + " " + System.currentTimeMillis() % 100000;
	}

	/** Index of the row with the value on the current page, -1 when there is no such row. */
	private static int rowIndex(ListWidget<?, ?, ?> tree, String value) {
		TreeNavigation.waitLoaded(tree.element(), tree.getExpectations());
		var texts = tree.rows().element().texts();
		for (int i = 0; i < texts.size(); i++) {
			if (texts.get(i).contains(value)) {
				return i;
			}
		}
		return -1;
	}

	/** After save the popup is refreshed; an assoc popup opens filtered by the selected values, so the filter is cleared first. */
	private static int savedRowIndex(ListWidget<?, ?, ?> tree, String value) {
		tree.headers().clearFilters();
		return rowIndex(tree, value);
	}

	/** Add, fill the row, save from the row menu, delete from the row menu; the GIFs: the creation with the save, the delete. */
	private static void createInlineAndDelete(PlatformTreePopupWidgetInline tree, String article, String created, String deleted, int width, int height) {
		DocShots.gif(article, created, width, height, DocShots.Frame.WITH_SIDEBAR);
		tree.actions().click("Add");
		var row = tree.rows().row(0);
		String value = unique("Popup inline");
		row.input(FIELD).setValue(value);
		row.burgerAction("Save").click();
		int index = savedRowIndex(tree, value);
		DocShots.stop();
		assertThat(index).as("the saved row is shown").isNotNegative();

		DocShots.gif(article, deleted, width, height, DocShots.Frame.WITH_SIDEBAR);
		tree.rows().row(index).burgerAction("Delete").click();
		DocShots.stop();
		assertThat(rowIndex(tree, value)).as("the deleted row is removed").isEqualTo(-1);
	}

	/** Add opens the inline form of the new row (options.create.widget); the form is saved and the row is shown. */
	private static void createInlineForm(PlatformTreePopupWidgetInlineForm tree, String article, String picture, String field, int width, int height) {
		DocShots.gif(article, picture, width, height, DocShots.Frame.WITH_SIDEBAR);
		tree.actions().click("Add");
		var form = tree.rows().row(0).clickPencil();
		String value = unique("Popup form");
		form.input(field).setValue(value);
		form.actions().action("Save").click();
		int index = savedRowIndex(tree, value);
		DocShots.stop();
		assertThat(index).as("the saved row is shown").isNotNegative();
		tree.rows().row(index).burgerAction("Delete").click();
		assertThat(rowIndex(tree, value)).as("the created row is removed").isEqualTo(-1);
	}

	/** Add, then Cancel from the row menu; what happens next is checked by the test (the onCancel action of a sample may close the popup). */
	private static void createAndCancel(PlatformTreePopupWidgetInline tree, String article, String picture, int width, int height) {
		DocShots.gif(article, picture, width, height, DocShots.Frame.WITH_SIDEBAR);
		tree.actions().click("Add");
		tree.rows().row(0).burgerAction("Cancel").click();
		DocShots.stop();
	}

	/** A click on the row switches it into the edit mode (assoc popups only); the value is saved from the row menu. */
	private static void editInline(PlatformTreePopupWidgetInline tree, String article, String picture, int width, int height) {
		DocShots.gif(article, picture, width, height, DocShots.Frame.WITH_SIDEBAR);
		String original = tree.rows().row(0).input(FIELD).getValue();
		var row = tree.rows().clickRow(0);
		String value = unique("Popup edited");
		row.input(FIELD).setValue(value);
		row.burgerAction("Save").click();
		int index = rowIndex(tree, value);
		DocShots.stop();
		assertThat(index).as("the edited row is shown").isNotNegative();
		// the sample data is restored
		row = tree.rows().clickRow(index);
		row.input(FIELD).setValue(original);
		row.burgerAction("Save").click();
		assertThat(rowIndex(tree, original)).as("the original value is restored").isNotNegative();
	}

	/** The pencil of the row opens its inline form (options.edit.widget); the value is saved and shown. */
	private static void editInlineForm(PlatformTreePopupWidgetInlineForm tree, String article, String picture, String field, int width, int height) {
		DocShots.gif(article, picture, width, height, DocShots.Frame.WITH_SIDEBAR);
		var form = tree.rows().row(0).clickPencil();
		String original = form.input(field).getValue();
		String value = unique("Popup form edited");
		form.input(field).setValue(value);
		form.actions().action("Save").click();
		int index = rowIndex(tree, value);
		DocShots.stop();
		assertThat(index).as("the edited row is shown").isNotNegative();
		// the sample data is restored
		form = tree.rows().row(index).clickPencil();
		form.input(field).setValue(original);
		form.actions().action("Save").click();
		assertThat(rowIndex(tree, original)).as("the original value is restored").isNotNegative();
	}

	@Test
	@Feature(PopupRowActionsTest.PICK)
	@Severity(CRITICAL)
	@Tag("Positive")
	@DisplayName("PickTreePopup: create inline, save, delete")
	@Description("Add creates an empty root row inside the popup; the row is saved from its menu and then deleted from its menu.")
	void pickCreateInlineAndDelete() {
		var form = PlatformApp
				.screen("PickTreePopup widget action")
				.secondLevelView("Delete")
				.checkUrl(url -> assertThat(url).contains("#/screen/myexample3353/view/myexample3354form"))
				.formByName("MyExample3354Form");
		var popup = form.pickTree("Custom Field Delete").openPopup();
		createInlineAndDelete(popup.tree(), PICK, "create_inline.gif", "actiondelete.gif", 1200, 760);
		popup.close();
	}

	@Test
	@Feature(PopupRowActionsTest.PICK)
	@Severity(CRITICAL)
	@Tag("Positive")
	@DisplayName("PickTreePopup: create inline-form")
	@Description("Add opens the row form inside the popup (options.create.widget); the form is saved and the new row is shown.")
	void pickCreateInlineForm() {
		var screen = PlatformApp.screen("PickTreePopup widget action");
		screen.secondLevelView("Create");
		var list = screen.thirdLevelView("Inline-form")
				.checkUrl(url -> assertThat(url).contains("#/screen/myexample3353/view/myexample3348listinlineform"))
				.listByName("MyExample3348ListInlineForm");
		var popup = list.rows().clickRow(0).pickTree("Custom Field Pick").openPopup();
		createInlineForm(popup.treeInlineForm(), PICK, "create_with_widget.gif", "Custom Field Pick", 1200, 900);
		popup.close();
	}

	@Test
	@Feature(PopupRowActionsTest.PICK)
	@Severity(CRITICAL)
	@Tag("Positive")
	@DisplayName("PickTreePopup: cancel of the created row")
	@Description("Cancel (cancel-create) removes the row added by Add.")
	void pickCreateAndCancel() {
		var form = PlatformApp
				.screen("PickTreePopup widget action")
				.secondLevelView("CancelCreate")
				.checkUrl(url -> assertThat(url).contains("#/screen/myexample3353/view/myexample3356form"))
				.formByName("MyExample3356Form");
		var popup = form.pickTree(FIELD).openPopup();
		int before = popup.tree().rows().element().size();
		createAndCancel(popup.tree(), PICK, "actioncancel.gif", 1200, 760);
		assertThat(popup.tree().rows().element().size()).as("the new row is removed").isEqualTo(before);
		popup.close();
	}

	@Test
	@Feature(PopupRowActionsTest.PICK)
	@Severity(CRITICAL)
	@Tag("Positive")
	@DisplayName("PickTreePopup: cancel-create with the onCancel action")
	@Description("The cancel of the created row runs the onCancel action of the sample; the row is removed.")
	void pickCreateAndCancelOnCancel() {
		var screen = PlatformApp.screen("PickTreePopup widget action");
		screen.secondLevelView("CancelCreate");
		var form = screen.thirdLevelView("Action cancel-create OnCancel")
				.checkUrl(url -> assertThat(url).contains("#/screen/myexample3353/view/myexample3356formoncancel"))
				.formByName("MyExample3356FormOnCancel");
		var popup = form.pickTree(FIELD).openPopup();
		createAndCancel(popup.tree(), PICK, "actioncanceloncancel.gif", 1200, 760);
		// the onCancel action of the sample drills down to the create view
		Selenide.webdriver().shouldHave(WebDriverConditions.urlContaining("myexample3348inlinecreatelist"), popup.tree().getExpectations().getTimeout());
	}

	@Test
	@Feature(PopupRowActionsTest.PICK)
	@Severity(CRITICAL)
	@Tag("Positive")
	@DisplayName("PickTreePopup: edit inline-form")
	@Description("The pencil of the popup row opens its form (options.edit.widget); the changed value is saved and shown.")
	void pickEditInlineForm() {
		var screen = PlatformApp.screen("PickTreePopup widget action");
		screen.secondLevelView("Edit");
		var list = screen.thirdLevelView("Inline-Form")
				.checkUrl(url -> assertThat(url).contains("#/screen/myexample3353/view/myexample3353listinlineform"))
				.listByName("MyExample3353ListInlineForm");
		var popup = list.rows().clickRow(0).pickTree("Custom Field PickTree").openPopup();
		editInlineForm(popup.treeInlineForm(), PICK, "edit_inline_form.gif", FIELD, 1200, 900);
		popup.close();
	}

	@Test
	@Feature(PopupRowActionsTest.ASSOC)
	@Severity(CRITICAL)
	@Tag("Positive")
	@DisplayName("AssocTreePopup: create inline, save, delete")
	@Description("Add creates an empty root row inside the popup; the row is saved from its menu and then deleted from its menu.")
	void assocCreateInlineAndDelete() {
		var screen = PlatformApp.screen("AssocTreePopup widget action");
		screen.secondLevelView("Create");
		var form = screen.thirdLevelView("Create Inline")
				.checkUrl(url -> assertThat(url).contains("#/screen/myexample3331/view/myexample3331create"))
				.formByName("MyExample3331FormCreate");
		var popup = form.multivalueTree(FIELD).openPopup();
		createInlineAndDelete(popup.tree(), ASSOC, "assoc_create_inline.gif", "actiondelete.gif", 1200, 760);
		popup.closeModal();
	}

	@Test
	@Feature(PopupRowActionsTest.ASSOC)
	@Severity(CRITICAL)
	@Tag("Positive")
	@DisplayName("AssocTreePopup: create inline-form")
	@Description("Add opens the row form inside the popup (options.create.widget); the form is saved and the new row is shown.")
	void assocCreateInlineForm() {
		var form = PlatformApp
				.screen("AssocTreePopup widget action")
				.secondLevelView("Create")
				.checkUrl(url -> assertThat(url).contains("#/screen/myexample3331/view/myexample3331inlinecreate"))
				.formByName("MyExample3331Form");
		var popup = form.multivalueTree(FIELD).openPopup();
		createInlineForm(popup.treeInlineForm(), ASSOC, "assoc_create_with_widget.gif", FIELD, 1200, 900);
		popup.closeModal();
	}

	@Test
	@Feature(PopupRowActionsTest.ASSOC)
	@Severity(CRITICAL)
	@Tag("Positive")
	@DisplayName("AssocTreePopup: edit inline")
	@Description("A click on the cell switches the popup row into the edit mode; the changed value is saved from the row menu.")
	void assocEditInline() {
		var screen = PlatformApp.screen("AssocTreePopup widget action");
		screen.secondLevelView("Edit");
		var form = screen.thirdLevelView("Edit Inline")
				.checkUrl(url -> assertThat(url).contains("#/screen/myexample3331/view/myexample3331edit"))
				.formByName("MyExample3331Edit");
		var popup = form.multivalueTree(FIELD).openPopup();
		editInline(popup.tree(), ASSOC, "assoc_edit_basic.gif", 1200, 760);
		popup.closeModal();
	}

	@Test
	@Feature(PopupRowActionsTest.ASSOC)
	@Severity(CRITICAL)
	@Tag("Positive")
	@DisplayName("AssocTreePopup: edit inline-form")
	@Description("The pencil of the popup row opens its form (options.edit.widget); the changed value is saved and shown.")
	void assocEditInlineForm() {
		var form = PlatformApp
				.screen("AssocTreePopup widget action")
				.secondLevelView("Edit")
				.checkUrl(url -> assertThat(url).contains("#/screen/myexample3331/view/myexample3331editinlineform"))
				.formByName("MyExample3331FormEdit");
		var popup = form.multivalueTree(FIELD).openPopup();
		editInlineForm(popup.treeInlineForm(), ASSOC, "assoc_edit_with_widget.gif", FIELD, 1200, 900);
		popup.closeModal();
	}

}
