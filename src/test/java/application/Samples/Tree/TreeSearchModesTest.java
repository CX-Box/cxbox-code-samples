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
 * Tree article, sections "Filtration" and "Search modes" (collapse / hide, restoring the path).
 */
@DisplayName("Tree. Search modes: collapse, hide, restoring the path of the found rows")
@Epic("Samples")
@Tag("Samples")
@Tag("Tree")
public class TreeSearchModesTest extends BaseTestForSamples {

	private static final String COLUMN = "Departments";

	/** matches child rows only; their parents are not loaded, so the rows are shown apart */
	private static final String SEARCH = "заявлений";

	/** the page size of the filter results */
	private static final int SHOWN = 5;

	private PlatformTreeWidgetInline treeWithFilter() {
		var tree = PlatformApp.screen("Tree widget basic")
				.secondLevelView("Business example")
				.treeByName("myexample3261TreeList");
		tree.waitLoaded();
		tree.headers().clearFilters();
		tree.waitLoaded();
		tree.headers().filter(fb -> fb.input(COLUMN, SEARCH));
		return tree.shouldShow(SHOWN);
	}

	@Test
	@Severity(CRITICAL)
	@Tag("Positive")
	@DisplayName("collapse: only the found rows are shown, the panel counts them, the arrows stay active")
	@Description("Default search mode; every shown row matches the filter, no row gets the disabled dot")
	void collapseMode() {
		var tree = treeWithFilter();
		int shown = tree.filterShown();
		assertThat(shown).isEqualTo(SHOWN);
		assertThat(tree.rows().element().size() + tree.unallocatedRows().element().size()).isEqualTo(shown);
		tree.rows().streamCurrentPage().forEach(r ->
				assertThat(r.input(COLUMN).getValue()).contains(SEARCH));
		var unallocated = tree.unallocatedRows();
		for (int i = 0; i < unallocated.element().size(); i++) {
			assertThat(unallocated.row(i).input(COLUMN).getValue()).contains(SEARCH);
			assertThat(unallocated.row(i).isExpandDisabled()).isFalse();
		}
	}

	@Test
	@Severity(CRITICAL)
	@Tag("Positive")
	@DisplayName("hide: the same rows, the arrows are replaced by the dot")
	@Description("Switching the mode in the gear menu keeps the filter; switching back restores the arrows")
	void hideMode() {
		var tree = treeWithFilter();
		int shown = tree.filterShown();
		tree.settings().select("Hide");
		tree.shouldShow(shown);
		var unallocated = tree.unallocatedRows();
		assertThat(tree.rows().element().size() + unallocated.element().size()).isEqualTo(shown);
		assertThat(tree.rows().streamCurrentPage().noneMatch(r -> r.isExpandable())).isTrue();
		for (int i = 0; i < unallocated.element().size(); i++) {
			assertThat(unallocated.row(i).isExpandable()).isFalse();
		}
		tree.settings().select("Collapse");
		tree.shouldShow(shown);
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
