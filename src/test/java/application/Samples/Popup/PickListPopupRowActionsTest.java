package application.Samples.Popup;

import application.config.BaseTestForSamples;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverConditions;
import com.codeborne.selenide.WebDriverRunner;
import core.element.PlatformApp;
import core.element.widget.list.ListWidget;
import core.element.widget.list.realization.inline.list.PlatformListPopupWidgetInline;
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
 * Row actions inside the PickListPopup (samples widgets/picklist/actions): create inline and inline-form,
 * edit inline-form, delete, cancel. The list of the popup is driven with the standard List API ({@code popup.list()}),
 * the same scenarios as the PickTreePopup ones in {@code Samples/Tree/PopupRowActionsTest}.
 */
@DisplayName("PickListPopup. Row actions inside the popup")
@Epic("Samples")
@Feature(PickListPopupRowActionsTest.ARTICLE)
@Tag("Samples")
public class PickListPopupRowActionsTest extends BaseTestForSamples {

	static final String ARTICLE = "widget/type/picklistpopup";

	private static final String FIELD = "Custom Field";


	private static String unique(String prefix) {
		return prefix + " " + System.currentTimeMillis() % 100000;
	}

	/** Index of the saved row: the filters of the list are cleared first, the sample may filter the new row out. */
	private static int savedRowIndex(ListWidget<?, ?, ?> list, String value) {
		list.headers().clearFilters();
		return rowIndex(list, value);
	}

	/** Index of the row with the value on the current page, -1 when there is no such row. */
	private static int rowIndex(ListWidget<?, ?, ?> list, String value) {
		list.getExpectations().getWaitAllElements(list.element());
		var texts = list.rows().element().texts();
		for (int i = 0; i < texts.size(); i++) {
			if (texts.get(i).contains(value)) {
				return i;
			}
		}
		return -1;
	}

	/** Add, then Cancel from the row menu; what happens next is checked by the test (the onCancel action of a sample may close the popup). */
	private static void createAndCancel(PlatformListPopupWidgetInline list, String picture, int width, int height) {
		DocShots.gif(ARTICLE, picture, width, height, DocShots.Frame.WITH_SIDEBAR);
		list.actions().click("Add");
		list.rows().row(0).burgerAction("Cancel").click();
		DocShots.stop();
	}

	@Test
	@Severity(CRITICAL)
	@Tag("Positive")
	@DisplayName("Create inline, save, delete")
	@Description("Add creates an empty row inside the popup; the row is saved from its menu and then deleted from its menu.")
	void createInlineAndDelete() {
		var page = PlatformApp
				.screen("PickListPopup widget action")
				.secondLevelView("Create")
				.checkUrl(url -> assertThat(url).contains("#/screen/myexample3092/view/myexample3072inlinecreatelist"))
				.listByName("MyExample3072List");
		var popup = page.rows().clickRow(0).pickList("Custom Field Pick").openListPopup();
		var list = popup.list();
		DocShots.gif(ARTICLE, "create_inline.gif", 1200, 760, DocShots.Frame.WITH_SIDEBAR);
		list.actions().click("Add");
		var row = list.rows().row(0);
		String value = unique("Popup inline");
		row.input("Custom Field Pick").setValue(value);
		row.burgerAction("Save").click();
		int index = savedRowIndex(list, value);
		DocShots.stop();
		assertThat(index).as("the saved row is shown").isNotNegative();

		DocShots.gif(ARTICLE, "actiondelete.gif", 1200, 760, DocShots.Frame.WITH_SIDEBAR);
		list.rows().row(index).burgerAction("Delete").click();
		DocShots.stop();
		assertThat(rowIndex(list, value)).as("the deleted row is removed").isEqualTo(-1);
		popup.close();
	}

	@Test
	@Severity(CRITICAL)
	@Tag("Positive")
	@DisplayName("Create inline-form")
	@Description("Add opens the row form inside the popup (options.create.widget); the form is saved and the new row is shown.")
	void createInlineForm() {
		var screen = PlatformApp.screen("PickListPopup widget action");
		screen.secondLevelView("Create");
		var page = screen.thirdLevelView("Inline-form")
				.checkUrl(url -> assertThat(url).contains("#/screen/myexample3092/view/myexample3072listinlineform"))
				.listByName("MyExample3072ListInlineForm");
		var popup = page.rows().clickRow(0).pickList("Custom Field Pick").openListPopup();
		var list = popup.listInlineForm();
		DocShots.gif(ARTICLE, "create_with_widget.gif", 1200, 900, DocShots.Frame.WITH_SIDEBAR);
		list.actions().click("Add");
		var form = list.rows().row(0).clickPencil();
		String value = unique("Popup form");
		form.input("Custom Field Pick").setValue(value);
		form.actions().action("Save").click();
		int index = savedRowIndex(list, value);
		DocShots.stop();
		assertThat(index).as("the saved row is shown").isNotNegative();
		list.rows().row(index).burgerAction("Delete").click();
		assertThat(rowIndex(list, value)).as("the created row is removed").isEqualTo(-1);
		popup.close();
	}

	@Test
	@Severity(CRITICAL)
	@Tag("Positive")
	@DisplayName("Cancel of the created row")
	@Description("Cancel (cancel-create) removes the row added by Add.")
	void createAndCancel() {
		var form = PlatformApp
				.screen("PickListPopup widget action")
				.secondLevelView("CancelCreate")
				.checkUrl(url -> assertThat(url).contains("#/screen/myexample3092/view/myexample3198form"))
				.formByName("MyExample3198Form");
		var popup = form.pickList(FIELD).openListPopup();
		int before = popup.list().rows().element().size();
		createAndCancel(popup.list(), "actioncancel.gif", 1200, 760);
		assertThat(popup.list().rows().element().size()).as("the new row is removed").isEqualTo(before);
		popup.close();
	}

	@Test
	@Severity(CRITICAL)
	@Tag("Positive")
	@DisplayName("Cancel-create with the onCancel action")
	@Description("The cancel of the created row runs the onCancel action of the sample; the row is removed.")
	void createAndCancelOnCancel() {
		var screen = PlatformApp.screen("PickListPopup widget action");
		screen.secondLevelView("CancelCreate");
		var form = screen.thirdLevelView("Action cancel-create OnCancel")
				.checkUrl(url -> assertThat(url).contains("#/screen/myexample3092/view/myexample3198formoncancel"))
				.formByName("MyExample3198FormOnCancel");
		var popup = form.pickList(FIELD).openListPopup();
		createAndCancel(popup.list(), "actioncanceloncancel.gif", 1200, 760);
		// the onCancel action of the sample drills down to the create view
		Selenide.webdriver().shouldHave(WebDriverConditions.urlContaining("myexample3072inlinecreatelist"), popup.list().getExpectations().getTimeout());
	}

	@Test
	@Severity(CRITICAL)
	@Tag("Positive")
	@DisplayName("Edit inline-form")
	@Description("The pencil of the popup row opens its form (options.edit.widget); the changed value is saved and shown.")
	void editInlineForm() {
		var screen = PlatformApp.screen("PickListPopup widget action");
		screen.secondLevelView("Edit");
		var page = screen.thirdLevelView("Inline-Form")
				.checkUrl(url -> assertThat(url).contains("#/screen/myexample3092/view/myexample3092listinlineform"))
				.listByName("MyExample3092ListInlineForm");
		var popup = page.rows().clickRow(0).pickList("Custom Field PickList").openListPopup();
		var list = popup.listInlineForm();
		DocShots.gif(ARTICLE, "edit_with_widget.gif", 1200, 900, DocShots.Frame.WITH_SIDEBAR);
		var form = list.rows().row(0).clickPencil();
		String original = form.input(FIELD).getValue();
		String value = unique("Popup form edited");
		form.input(FIELD).setValue(value);
		form.actions().action("Save").click();
		int index = rowIndex(list, value);
		DocShots.stop();
		assertThat(index).as("the edited row is shown").isNotNegative();
		// the sample data is restored
		form = list.rows().row(index).clickPencil();
		form.input(FIELD).setValue(original);
		form.actions().action("Save").click();
		assertThat(rowIndex(list, original)).as("the original value is restored").isNotNegative();
		popup.close();
	}

}
