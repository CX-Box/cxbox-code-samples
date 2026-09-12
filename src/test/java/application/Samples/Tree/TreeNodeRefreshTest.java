package application.Samples.Tree;

import application.config.BaseTestForSamples;
import application.config.props.Env;
import com.codeborne.selenide.Selenide;
import core.element.PlatformApp;
import core.element.widget.list.realization.inline.tree.PlatformTreeRowInline;
import core.element.widget.list.realization.inline.tree.PlatformTreeWidgetInline;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Severity;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.util.List;

import static io.qameta.allure.SeverityLevel.CRITICAL;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * Node refresh of the Tree widget after custom actions (sample widgets/tree/actions/create/basic, screen "Tree widget action basic"):
 * a custom action refreshes only the node of the record, a deleting action removes the row;
 * PostAction.refreshBc: the current behaviour (the tree is not collapsed) and the disabled check of the next release.
 * Analogue of the custom action checks of the List widget.
 */
@DisplayName("Tree. Node refresh after custom actions")
@Epic("Samples")
@Tag("Samples")
public class TreeNodeRefreshTest extends BaseTestForSamples {

	private static final String SCREEN = "myexample3265";

	private static final String VIEW = "myexample3265tree";

	private static final String WIDGET = "MyExample3265Tree";

	private static final String FIELD = "Custom Field";

	/** Value written by the custom actions of the sample service. */
	private static final String CUSTOM_SAVE_VALUE = "Test data";

	private static PlatformTreeWidgetInline open() {
		Selenide.open(Env.uri() + "screen/" + SCREEN + "/view/" + VIEW);
		Selenide.sleep(2500);
		var tree = PlatformApp.currentScreen().view().treeByName(WIDGET);
		tree.waitLoaded();
		return tree;
	}

	/** Index of the first root row with child rows; the root pages are loaded by "More" until such a row is found. */
	private static int expandableRow(PlatformTreeWidgetInline tree) {
		while (true) {
			int count = (int) tree.rows().streamCurrentPage().count();
			for (int i = 0; i < count; i++) {
				if (tree.rows().row(i).isExpandable()) {
					return i;
				}
			}
			if (tree.pagination().isLastPage()) {
				throw new IllegalStateException("No root row with child rows in " + WIDGET);
			}
			tree.pagination().nextPage();
			tree.waitLoaded();
		}
	}

	/** Root row with the given key; the rows may change their order after an action, so the row is looked up by key. */
	private static PlatformTreeRowInline rowByKey(PlatformTreeWidgetInline tree, String key) {
		return tree.rows().streamCurrentPage().filter(r -> key.equals(r.rowKey())).findFirst()
				.orElseThrow(() -> new AssertionError("Root row " + key + " is not shown in " + WIDGET));
	}

	/** Texts of the root rows except the row with the given key. */
	private static List<String> otherRows(PlatformTreeWidgetInline tree, String key) {
		return tree.rows().streamCurrentPage().filter(r -> !key.equals(r.rowKey())).map(r -> r.element().getText()).toList();
	}

	private static int rowWith(PlatformTreeWidgetInline tree, String value) {
		int count = (int) tree.rows().streamCurrentPage().count();
		for (int i = 0; i < count; i++) {
			if (tree.rows().row(i).element().getText().contains(value)) {
				return i;
			}
		}
		return -1;
	}

	@Test
	@Severity(CRITICAL)
	@Tag("Positive")
	@DisplayName("Custom action refreshes only the node")
	@Description("A custom action without PostAction re-reads the record and updates its row; the node of the record is collapsed and its child rows are forgotten, the other rows of the tree stay as they were.")
	void customActionRefreshesNode() {
		var tree = open();
		int index = expandableRow(tree);
		PlatformTreeRowInline root = tree.rows().row(index).expandRow();
		tree.waitLoaded();
		String key = root.rowKey();
		assertThat(root.rows().streamCurrentPage().count()).isPositive();
		List<String> others = otherRows(tree, key);

		tree.rows().clickRow(index).burgerAction("custom Save").click();
		tree.waitLoaded();

		root = rowByKey(tree, key);
		assertThat(root.element().getText()).contains(CUSTOM_SAVE_VALUE);
		root.shouldBeCollapsed();
		assertThat(root.isExpandable()).as("the node can be expanded again").isTrue();
		assertThat(otherRows(tree, key)).as("other root rows are not refreshed").isEqualTo(others);
	}

	@Test
	@Severity(CRITICAL)
	@Tag("Positive")
	@DisplayName("PostAction.refreshBc: current behaviour, the tree is not collapsed")
	@Description("PostAction.refreshBc is not supported for the Tree widget in this release: the action succeeds without an error, "
			+ "the record is updated in its row, the root page is reloaded, the expanded node stays expanded with its child rows.")
	void refreshBcKeepsTreeExpanded() {
		var tree = open();
		int index = expandableRow(tree);
		PlatformTreeRowInline root = tree.rows().row(index).expandRow();
		tree.waitLoaded();
		String key = root.rowKey();
		long children = root.rows().streamCurrentPage().count();
		assertThat(children).isPositive();

		tree.rows().clickRow(index).burgerAction("custom Save With Refresh").click();
		tree.waitLoaded();

		root = rowByKey(tree, key);
		assertThat(root.element().getText()).contains(CUSTOM_SAVE_VALUE);
		root.shouldBeExpanded();
		assertThat(root.rows().streamCurrentPage().count()).isEqualTo(children);
	}

	@Test
	@Disabled("PostAction.refreshBc for the Tree widget is planned for the next release: the tree must be collapsed after it (specification, section 8)")
	@Severity(CRITICAL)
	@Tag("Positive")
	@DisplayName("PostAction.refreshBc collapses the tree")
	@Description("A custom action with PostAction.refreshBc updates the record and reloads the whole tree: the expanded node is collapsed.")
	void refreshBcCollapsesTree() {
		var tree = open();
		int index = expandableRow(tree);
		String key = tree.rows().row(index).expandRow().rowKey();
		tree.waitLoaded();
		tree.rows().row(index).shouldBeExpanded();

		tree.rows().clickRow(index).burgerAction("custom Save With Refresh").click();
		tree.waitLoaded();

		var root = rowByKey(tree, key);
		assertThat(root.element().getText()).contains(CUSTOM_SAVE_VALUE);
		root.shouldBeCollapsed();
		assertThat(root.isExpandable()).as("the node can be expanded again").isTrue();
	}

	@Test
	@Severity(CRITICAL)
	@Tag("Positive")
	@DisplayName("Custom delete removes the row")
	@Description("A custom action that deletes the record removes its row from the node; the other rows stay.")
	void customDeleteRemovesRow() {
		var tree = open();
		tree.actions().click("Add");
		var row = tree.rows().row(0);
		row.element().$("input").shouldBe(com.codeborne.selenide.Condition.visible, tree.getExpectations().getTimeout());
		String value = "Delete me " + System.currentTimeMillis() % 100000;
		row.input(FIELD).setValue(value);
		row.burgerAction("Save").click();
		tree.waitLoaded();
		int index = rowWith(tree, value);
		assertThat(index).as("created row is shown").isNotNegative();
		long before = tree.rows().streamCurrentPage().count();

		tree.rows().clickRow(index).burgerAction("custom Delete").click();
		tree.waitLoaded();

		assertThat(rowWith(tree, value)).as("deleted row is removed from the node").isEqualTo(-1);
		assertThat(tree.rows().streamCurrentPage().count()).isEqualTo(before - 1);
	}

}
