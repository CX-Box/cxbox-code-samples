package application.Samples.Tree;

import application.config.BaseTestForSamples;
import core.element.PlatformApp;
import core.element.widget.list.realization.inline.tree.PlatformTreeWidgetInline;
import core.util.DocShots;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Epic;
import io.qameta.allure.Severity;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.SeverityLevel.CRITICAL;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * Tree article, sections "Filtration" and "Search modes" (collapse / hide, restoring the path).
 */
@DisplayName("Tree. Search modes: collapse, hide, restoring the path of the found rows")
@Epic("Samples")
@Feature(TreeSearchModesTest.ARTICLE)
@Tag("Samples")
@Tag("Tree")
public class TreeSearchModesTest extends BaseTestForSamples {

	private static final String COLUMN = "Departments";

	/** matches child rows only; their parents are not loaded, so the rows are shown apart */
	private static final String SEARCH = "заявлений";

	/** matches root rows: the difference between the modes (arrows or dots) is visible */
	private static final String ROOT_SEARCH = "Полномочия";

	static final String ARTICLE = "widget/type/tree";

	/** the page size of the filter results */
	private static final int SHOWN = 5;

	private PlatformTreeWidgetInline treeWithFilter() {
		return treeWithFilter(SEARCH);
	}

	private PlatformTreeWidgetInline treeWithFilter(String search) {
		var tree = PlatformApp.screen("Tree widget basic")
				.secondLevelView("Business example")
				.treeByName("myexample3261TreeList");
		tree.waitLoaded();
		tree.headers().clearFilters();
		tree.waitLoaded();
		tree.headers().filter(fb -> fb.input(COLUMN, search));
		return tree.shouldShow(SHOWN);
	}

	@Test
	@Severity(CRITICAL)
	@Tag("Positive")
	@DisplayName("collapse: only the found rows are shown, the panel counts them, the arrows stay active")
	@Description("Default search mode; every shown row matches the filter, no row gets the disabled dot")
	void collapseMode() {
		var tree = treeWithFilter(ROOT_SEARCH);
		DocShots.png(tree.element(), ARTICLE, "search_collapse.png", 1600, 1000);
		int shown = tree.filterShown();
		assertThat(shown).isEqualTo(SHOWN);
		// a found record whose parent is not loaded waits in the unallocated block
		assertThat(tree.rows().element().size() + tree.unallocatedRows().element().size()).isEqualTo(shown);
		tree.rows().streamCurrentPage().forEach(r ->
				assertThat(r.input(COLUMN).getValue()).contains(ROOT_SEARCH));
		assertThat(tree.rows().streamCurrentPage().anyMatch(r -> r.isExpandable())).as("the arrows stay active").isTrue();
	}

	@Test
	@Severity(CRITICAL)
	@Tag("Positive")
	@DisplayName("hide: the same rows, the arrows are replaced by the dot")
	@Description("Switching the mode in the gear menu keeps the filter; switching back restores the arrows")
	void hideMode() {
		var tree = treeWithFilter(ROOT_SEARCH);
		int shown = tree.filterShown();
		DocShots.png(tree.settings().open(), ARTICLE, "search_modes_menu.png", 1600, 1000);
		tree.settings().select("Hide");
		tree.shouldShow(shown);
		DocShots.png(tree.element(), ARTICLE, "search_hide.png", 1600, 1000);
		assertThat(tree.rows().element().size() + tree.unallocatedRows().element().size()).isEqualTo(shown);
		assertThat(tree.rows().streamCurrentPage().noneMatch(r -> r.isExpandable())).as("the arrows are replaced by the dot").isTrue();
		tree.settings().select("Collapse");
		tree.shouldShow(shown);
		assertThat(tree.rows().streamCurrentPage().anyMatch(r -> r.isExpandable())).as("the arrows are back").isTrue();
	}

	@Test
	@Severity(CRITICAL)
	@Tag("Positive")
	@DisplayName("A found row whose parents are not loaded is shown apart with the >... button")
	@Description("onFilterApplyNestLevel = 0: the parents are not requested; the rows wait in the unallocated block")
	void foundRowsAreUnallocated() {
		var tree = treeWithFilter();
		assertThat(tree.rows().element().size()).isZero();
		assertThat(tree.unallocatedRows().element().size()).isEqualTo(tree.filterShown());
		var row = tree.unallocatedRows().row(0);
		assertThat(row.isUnallocated()).isTrue();
		assertThat(row.input(COLUMN).getValue()).contains(SEARCH);
	}

	@Test
	@Severity(CRITICAL)
	@Tag("Positive")
	@DisplayName(">... restores the path: the row moves under its parent")
	@Description("The missing parents are requested and expanded; the row leaves the unallocated block")
	void restorePathByButton() {
		var tree = treeWithFilter();
		int unallocated = tree.unallocatedRows().element().size();
		var row = tree.unallocatedRows().row(0);
		String value = row.input(COLUMN).getValue();
		row.restorePath();
		assertThat(tree.unallocatedRows().element().size()).isLessThan(unallocated);
		var parent = tree.rows().streamCurrentPage().filter(r -> r.isExpanded()).findFirst().orElseThrow();
		assertThat(parent.isUnallocated()).isFalse();
		var restored = parent.rows().streamCurrentPage()
				.filter(r -> r.input(COLUMN).getValue().equals(value))
				.findFirst().orElseThrow();
		assertThat(restored.isUnallocated()).isFalse();
	}

	@Test
	@Tag("Positive")
	@DisplayName("Restore path -> For all in the gear menu restores every found row")
	void restorePathForAll() {
		var tree = treeWithFilter();
		assertThat(tree.unallocatedRows().element().size()).isGreaterThan(0);
		tree.restorePathForAll();
		assertThat(tree.unallocatedRows().element().size()).isZero();
		assertThat(tree.rows().streamCurrentPage().anyMatch(r -> r.isExpanded())).isTrue();
	}

	@Test
	@Tag("Positive")
	@DisplayName("Clearing the filter forgets the unallocated rows; the root page is loaded by More")
	void clearFilterForgetsUnallocated() {
		var tree = treeWithFilter();
		assertThat(tree.unallocatedRows().element().size()).isGreaterThan(0);
		tree.headers().clearFilters();
		tree.waitLoaded();
		assertThat(tree.filterShown()).isZero();
		assertThat(tree.unallocatedRows().element().size()).isZero();
		assertThat(tree.pagination().isLastPage()).isFalse();
		tree.pagination().nextPage();
		assertThat(tree.rows().element().size()).isGreaterThan(0);
		assertThat(tree.rows().streamCurrentPage().noneMatch(r -> r.isUnallocated())).isTrue();
	}

}
