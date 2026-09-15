package application.Samples.Tree;

import application.config.BaseTestForSamples;
import core.element.PlatformApp;
import core.element.widget.list.ListWidget;
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
 * Standard actions of the Tree widget (samples widgets/tree/actions, screen "Tree widget action basic"):
 * create inline, inline-form, with view; edit inline, inline-form, with view. Analogue of the List action samples.
 */
@DisplayName("Tree. Standard actions: create and edit (inline, inline-form, with view)")
@Epic("Samples")
@Feature(TreeActionsTest.ARTICLE)
@Tag("Samples")
public class TreeActionsTest extends BaseTestForSamples {

	private static final String FIELD = "Custom Field";

	static final String ARTICLE = "widget/type/tree";

	private static String unique(String prefix) {
		return prefix + " " + System.currentTimeMillis() % 100000;
	}

	/** After save the tree is refreshed and the saved root row is shown on the current page (the created row is on top). */
	private static void assertRowShown(ListWidget<?, ?, ?> tree, String value) {
		TreeNavigation.waitLoaded(tree.element(), tree.getExpectations());
		assertThat(tree.rows().streamCurrentPage().map(r -> r.element().getText()).toList()).anyMatch(t -> t.contains(value));
	}

	@Test
	@Severity(CRITICAL)
	@Tag("Positive")
	@DisplayName("Create inline")
	@Description("Add creates an empty root row in the tree; the row is filled and saved from the row menu, the value stays after save.")
	void createInline() {
		var tree = PlatformApp
				.screen("Tree widget action basic")
				.secondLevelView("Action create")
				.checkUrl(url -> assertThat(url).contains("#/screen/myexample3265/view/myexample3265tree"))
				.treeByName("MyExample3265Tree");
		tree.waitLoaded();
		tree.actions().click("Add");
		var row = tree.rows().row(0);
		DocShots.png(tree.element(), ARTICLE, "create_inline.png", 1600, 1000);
		String value = unique("Inline root");
		row.input(FIELD).setValue(value);
		row.burgerAction("Save").click();
		assertRowShown(tree, value);
	}

	@Test
	@Severity(CRITICAL)
	@Tag("Positive")
	@DisplayName("Create inline-form")
	@Description("Add opens the row form inside the tree; the form is filled and saved, the new root row shows the value.")
	void createInlineForm() {
		var screen = PlatformApp.screen("Tree widget action basic");
		screen.secondLevelView("Action create");
		var tree = screen.thirdLevelView("Create inline-form")
				.checkUrl(url -> assertThat(url).contains("#/screen/myexample3265/view/myexample3279tree"))
				.treeInlineFormByName("MyExample3279Tree");
		tree.actions().click("Add");
		var form = tree.rows().row(0).clickPencil();
		DocShots.png(tree.element(), ARTICLE, "create_inline_form.png", 1600, 1000);
		String value = unique("Inline-form root");
		form.input(FIELD).setValue(value);
		form.actions().action("Save").click();
		assertRowShown(tree, value);
	}

	@Test
	@Severity(CRITICAL)
	@Tag("Positive")
	@DisplayName("Create with view")
	@Description("Add drills down to the form view; Save and Close returns to the tree with the new root row.")
	void createWithView() {
		var screen = PlatformApp.screen("Tree widget action basic");
		screen.secondLevelView("Action create");
		var tree = screen.thirdLevelView("create with view")
				.checkUrl(url -> assertThat(url).contains("#/screen/myexample3265/view/myexample3266tree"))
				.treeByName("MyExample3266Tree");
		tree.waitLoaded();
		tree.actions().click("Add");
		var form = PlatformApp.currentScreen().view().formByName("MyExample3266Form");
		DocShots.png(form.element(), ARTICLE, "create_with_view.png", 1600, 1000);
		String value = unique("With view root");
		form.input(FIELD).setValue(value);
		form.actions().action("Save and Close").click();
		tree = PlatformApp.currentScreen().view().treeByName("MyExample3266Tree");
		assertRowShown(tree, value);
	}

	@Test
	@Severity(CRITICAL)
	@Tag("Positive")
	@DisplayName("Edit inline")
	@Description("A click on the row switches it to the edit mode; the changed value is saved from the row menu and kept.")
	void editInline() {
		var tree = PlatformApp
				.screen("Tree widget action basic")
				.secondLevelView("Edit")
				.checkUrl(url -> assertThat(url).contains("#/screen/myexample3265/view/myexample3273tree"))
				.treeByName("MyExample3273Tree");
		tree.waitLoaded();
		var row = tree.rows().clickRow(1);
		DocShots.png(tree.element(), ARTICLE, "edit_inline.png", 1600, 1000);
		String value = unique("Edited inline");
		row.input(FIELD).setValue(value);
		row.burgerAction("Save").click();
		assertRowShown(tree, value);
	}

	@Test
	@Severity(CRITICAL)
	@Tag("Positive")
	@DisplayName("Edit inline-form")
	@Description("The pencil of the row opens the row form inside the tree; the changed value is saved and shown in the row.")
	void editInlineForm() {
		var screen = PlatformApp.screen("Tree widget action basic");
		screen.secondLevelView("Edit");
		var tree = screen.thirdLevelView("Edit inline-form")
				.checkUrl(url -> assertThat(url).contains("#/screen/myexample3265/view/myexample3275tree"))
				.treeInlineFormByName("MyExample3275Tree");
		var form = tree.rows().row(1).clickPencil();
		DocShots.png(tree.element(), ARTICLE, "edit_inline_form.png", 1600, 1000);
		String value = unique("Edited inline-form");
		form.input(FIELD).setValue(value);
		form.actions().action("Save").click();
		assertRowShown(tree, value);
	}

	@Test
	@Severity(CRITICAL)
	@Tag("Positive")
	@DisplayName("Edit with view")
	@Description("Edit from the row menu drills down to the form view; Save and Close returns to the tree with the changed value.")
	void editWithView() {
		var screen = PlatformApp.screen("Tree widget action basic");
		screen.secondLevelView("Edit");
		var tree = screen.thirdLevelView("Edit with view")
				.checkUrl(url -> assertThat(url).contains("#/screen/myexample3265/view/myexample3274tree"))
				.treeByName("MyExample3274Tree");
		tree.waitLoaded();
		tree.rows().clickRow(1).burgerAction("Edit").click();
		var form = PlatformApp.currentScreen().view().formByName("MyExample3274Form");
		DocShots.png(form.element(), ARTICLE, "edit_with_view.png", 1600, 1000);
		String value = unique("Edited with view");
		form.input(FIELD).setValue(value);
		form.actions().action("Save and Close").click();
		tree = PlatformApp.currentScreen().view().treeByName("MyExample3274Tree");
		assertRowShown(tree, value);
	}

}
