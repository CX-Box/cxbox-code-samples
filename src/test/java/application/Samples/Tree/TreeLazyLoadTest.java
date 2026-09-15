package application.Samples.Tree;

import application.config.BaseTestForSamples;
import core.element.PlatformApp;
import core.element.widget.list.realization.inline.tree.PlatformTreeWidgetInline;
import core.util.DocShots;
import core.element.widget.tree.TreeNavigation;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
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
 * Tree article, sections "Basics", "Lazy load", "More", "Sorting".
 */
@DisplayName("Tree. Lazy load: roots, expand, More per node, sorting")
@Epic("Samples")
@Feature(TreeLazyLoadTest.ARTICLE)
@Tag("Samples")
@Tag("Tree")
public class TreeLazyLoadTest extends BaseTestForSamples {

	static final String ARTICLE = "widget/type/tree";

	private static final String FIELD = "Custom Field";

	private static final String LEAF = "Root 1 without children";

	private static final String NODE = "Root 5 (with children)";

	/** Tree Basic: five roots, the first one with three children; the whole tree fits in one page. */
	private PlatformTreeWidgetInline basicTree() {
		return PlatformApp.screen("Tree widget basic")
				.secondLevelView("Tree Basic")
				.treeByName("MyExample3281Tree");
	}

	/** Business example: more roots and more children than the page size; the default filter is cleared. */
	private PlatformTreeWidgetInline bigTree() {
		var tree = PlatformApp.screen("Tree widget basic")
				.secondLevelView("Business example")
				.treeByName("myexample3261TreeList");
		tree.waitLoaded();
		tree.headers().clearFilters();
		return tree.waitLoaded();
	}

	@Test
	@Severity(CRITICAL)
	@Tag("Positive")
	@DisplayName("Only the root rows are loaded; a node is collapsed, a leaf has no arrow")
	@Description("Lazy load: the widget opens collapsed; the children are not requested until the node is expanded")
	void rootsOnly() {
		var tree = basicTree();
		DocShots.png(tree.element(), ARTICLE, "lazyload_collapsed.png", 1600, 1000);
		assertThat(tree.rows().element().size()).isEqualTo(5);
		var node = tree.rows().row(0);
		assertThat(node.input(FIELD).getValue()).isEqualTo(NODE);
		assertThat(node.isExpandable()).isTrue();
		assertThat(node.isExpanded()).isFalse();
		assertThat(node.rows().element().size()).isZero();
		assertThat(node.pagination().isLastPage()).isFalse();
		var leaf = tree.rows().row(4);
		assertThat(leaf.input(FIELD).getValue()).isEqualTo(LEAF);
		assertThat(leaf.isExpandable()).isFalse();
		assertThat(leaf.pagination().isLastPage()).isTrue();
	}

	@Test
	@Severity(CRITICAL)
	@Tag("Positive")
	@DisplayName("Expanding a node loads its children, the siblings are untouched; collapsing hides them")
	@Description("The first nextPage() of a collapsed row expands it, i.e. loads page 1 of its children")
	void expandLoadsChildren() {
		var tree = basicTree();
		var node = tree.rows().row(0).expandRow();
		assertThat(node.isExpanded()).isTrue();
		DocShots.png(tree.element(), ARTICLE, "lazyload.png", 1600, 1000);
		DocShots.png(tree.element(), ARTICLE, "tree.png", 1600, 1000);
		assertThat(node.rows().element().size()).isEqualTo(3);
		assertThat(node.rows().row(0).input(FIELD).getValue()).contains("Root 5");
		assertThat(tree.rows().element().size()).isEqualTo(5);
		assertThat(node.pagination().isLastPage()).isTrue();
		node.collapseRow();
		assertThat(node.isExpanded()).isFalse();
		assertThat(node.rows().element().size()).isZero();
	}

	@Test
	@Tag("Positive")
	@DisplayName("More loads the next page of the root rows and keeps the loaded ones")
	@Description("The pages accumulate: after More the previously loaded rows stay on the screen")
	void rootMoreAccumulates() {
		var tree = bigTree();
		assertThat(tree.pagination().isLastPage()).isFalse();
		tree.pagination().nextPage();
		DocShots.png(tree.element(), ARTICLE, "more_root.png", 1600, 1000);
		int loaded = tree.rows().element().size();
		assertThat(loaded).isGreaterThanOrEqualTo(5);
		tree.pagination().nextPage();
		assertThat(tree.rows().element().size()).isGreaterThan(loaded);
	}

	@Test
	@Tag("Positive")
	@DisplayName("Every node has its own More")
	@Description("Loading a page of one node does not change the neighbouring node")
	void morePerNode() {
		var tree = bigTree();
		// root pages are loaded lazily until a node with more children than the page size is found
		var node = tree.rows().streamAllPages()
				.filter(r -> r.isExpandable())
				.filter(r -> !r.expandRow().pagination().isLastPage())
				.findFirst().orElseThrow();
		var sibling = tree.rows().streamCurrentPage()
				.filter(r -> r.isExpandable() && !r.isExpanded())
				.findFirst().orElseThrow();
		int children = node.rows().element().size();
		assertThat(children).isGreaterThan(0);
		assertThat(sibling.rows().element().size()).isZero();
		node.pagination().nextPage();
		assertThat(node.rows().element().size()).isGreaterThan(children);
		assertThat(sibling.rows().element().size()).isZero();
	}

	@Test
	@Tag("Positive")
	@DisplayName("Sorting collapses the tree")
	@Description("After a sort the root rows are requested again and every node is collapsed")
	void sortingCollapses() {
		var tree = basicTree();
		var node = tree.rows().row(0).expandRow();
		assertThat(node.isExpanded()).isTrue();
		tree.headers().sort(sb -> sb.sort(FIELD));
		tree.waitLoaded();
		assertThat(tree.rows().streamCurrentPage().noneMatch(r -> r.isExpanded())).isTrue();
		DocShots.png(tree.element(), ARTICLE, "sorting.png", 1600, 1000);
	}

	@Test
	@Tag("Positive")
	@Feature("widget/type/property/defaultlimitpage")
	@DisplayName("Default limit of the page: the root page is cut to the limit")
	@Description("Sample of the defaultLimitPage property on a Tree")
	void defaultLimit() {
		var view = PlatformApp
				.screen("Widget property Default limit page")
				.secondLevelView("Tree")
				.checkUrl(url -> assertThat(url).contains("#/screen/myexample359/view/myexample359tree"));
		// TODO CXBOX-1394: a tree opened by a tab after a view of the same bc stays empty until the page is reloaded
		Selenide.refresh();
		var tree = view.treeByName("MyExample359Tree");
		tree.waitLoaded();
		assertThat(tree.rows().element().size()).isGreaterThan(0);
		assertThat(tree.pagination().isLastPage()).isFalse();
		DocShots.png(tree.element(), "widget/type/property/defaultlimitpage", "tree_default_limit.png", 1600, 1000);
	}

	@Test
	@Tag("Positive")
	@DisplayName("Customization of the displayed columns: the gear menu, hidden and added columns")
	@Description("The hidden fields are not shown as columns; the settings menu lists the columns of the widget")
	void columns() {
		var tree = PlatformApp
				.screen("Tree widget customization columns")
				.secondLevelView("Tree widget")
				.checkUrl(url -> assertThat(url).contains("#/screen/myexample3268/view/myexample3268tree"))
				.treeByName("MyExample3268Tree");
		tree.waitLoaded();
		DocShots.png(tree.settings().open(), ARTICLE, "columns_menu.png", 1600, 1000);
		tree.settings().close();
		var hidden = PlatformApp
				.screen("Tree widget customization columns")
				.secondLevelView("Tree widget hidden columns")
				.checkUrl(url -> assertThat(url).contains("#/screen/myexample3268/view/myexample3268listhidden"))
				.treeByName("MyExample3268TreeHiddenFields");
		int hiddenColumns = TreeNavigation.columnNames(hidden.element(), hidden.getExpectations()).size();
		DocShots.png(hidden.element(), ARTICLE, "columns_hidden.png", 1600, 1000);
		var all = PlatformApp
				.screen("Tree widget customization columns")
				.secondLevelView("Tree widget all fields")
				.checkUrl(url -> assertThat(url).contains("#/screen/myexample3268/view/myexample3268listallfields"))
				.treeByName("MyExample3268TreeAllFields");
		int allColumns = TreeNavigation.columnNames(all.element(), all.getExpectations()).size();
		DocShots.png(all.element(), ARTICLE, "columns_all.png", 1600, 1000);
		assertThat(allColumns).isGreaterThan(hiddenColumns);
	}

	/** nextAndPreviousWithHasNext: More is shown while the backend returns hasNext = true, the counter is not shown. */
	@Test
	@Tag("Positive")
	@DisplayName("More of a node in the nextAndPreviousWithHasNext mode")
	void nodeMoreHasNext() {
		var screen = PlatformApp.screen("Widget property Pagination");
		screen.secondLevelView("nextAndPreviousWithHasNext");
		var view = screen.thirdLevelView("Tree").checkUrl(url -> assertThat(url).contains("#/screen/myexample3861/view/myexample3860tree"));
		// TODO CXBOX-1394: a tree opened by a tab after a view of the same bc stays empty until the page is reloaded
		Selenide.refresh();
		nodeMore(view.treeByName("MyExample3860Tree"), "more_hasnext.png");
	}

	/** nextAndPreviousSmart: More is shown while the backend returns more records than the limit of the node. */
	@Test
	@Tag("Positive")
	@DisplayName("More of a node in the nextAndPreviousSmart mode")
	void nodeMoreSmart() {
		var screen = PlatformApp.screen("Widget property Pagination");
		screen.secondLevelView("nextAndPreviousSmart");
		var view = screen.thirdLevelView("Tree").checkUrl(url -> assertThat(url).contains("#/screen/myexample3861/view/myexample3861tree"));
		// TODO CXBOX-1394: a tree opened by a tab after a view of the same bc stays empty until the page is reloaded
		Selenide.refresh();
		nodeMore(view.treeByName("MyExample3861Tree"), "more_smart.png");
	}

	/** The root has more children than the page: More loads the next page and keeps the loaded rows. */
	private static void nodeMore(PlatformTreeWidgetInline tree, String picture) {
		// the first request of the AnySource sample is slow
		tree.element().shouldBe(Condition.visible, tree.getExpectations().getTimeout().multipliedBy(10));
		tree.waitLoaded();
		var node = tree.rows().row(0).expandRow();
		assertThat(node.isExpanded()).isTrue();
		assertThat(node.pagination().isLastPage()).as("the node has a next page").isFalse();
		DocShots.png(tree.element(), ARTICLE, picture, 1600, 1000);
		int loaded = node.rows().element().size();
		node.pagination().nextPage();
		assertThat(node.rows().element().size()).isGreaterThan(loaded);
	}

}
