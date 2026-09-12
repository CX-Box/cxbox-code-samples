package application.Samples.Tree;

import application.config.BaseTestForSamples;
import core.element.PlatformApp;
import core.element.widget.list.realization.inline.tree.PlatformTreeWidgetInline;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
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
@Tag("Samples")
@Tag("Tree")
public class TreeLazyLoadTest extends BaseTestForSamples {

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
	}

}
