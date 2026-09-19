package application.Samples.Feature.FullTextSearch;

import application.config.BaseTestForSamples;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import core.element.PlatformApp;
import core.element.widget.list.realization.inline.list.PlatformListWidgetInline;
import core.element.widget.list.realization.inline.tree.PlatformTreeWidgetInline;
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
 * Filtration article, section "FullTextSearch": the search field above List and Tree (options.fullTextSearch).
 */
@DisplayName("Widget property FullTextSearch. List and Tree: search and clearing the field")
@Epic("Samples")
@Feature(FullTextSearchTest.ARTICLE)
@Tag("Samples")
@Tag("FullTextSearch")
public class FullTextSearchTest extends BaseTestForSamples {

	static final String ARTICLE = "widget/type/property/filtration";

	private static final String SCREEN = "Widget property Filtration";

	private static final String VIEW = "Widget property FullTextSearch";

	private static final String COLUMN = "Full Name";

	/** matches two records by Full Name */
	private static final String SEARCH = "Neal";

	private static final int FOUND = 2;

	/** shorter than three characters: the search does not start */
	private static final String SHORT = "Ne";

	/** the column filter of the tree: the search is not the last filter */
	private static final String COLUMN_FILTER = "Michael";

	private static final int COLUMN_FILTER_FOUND = 2;

	/** one of the rows of the column filter has this address */
	private static final String TREE_SEARCH = "Dmitrov";

	private PlatformListWidgetInline list() {
		var screen = PlatformApp.screen(SCREEN);
		screen.secondLevelView(VIEW);
		return screen.thirdLevelView("List").listInline("List FullTextSearch");
	}

	/**
	 * The tree filtered by a column: clearing the search sends a request with the column filter.
	 * TODO CXBOX-1388: clearing the last filter shows the loaded rows without a request; when it sends a request,
	 * test the search as the only filter as well.
	 */
	private PlatformTreeWidgetInline treeWithColumnFilter() {
		var screen = PlatformApp.screen(SCREEN);
		screen.secondLevelView(VIEW);
		var view = screen.thirdLevelView("Tree");
		// TODO CXBOX-1394: a tree opened by a tab after a view of the same bc stays empty until the page is reloaded
		Selenide.refresh();
		var tree = view.treeByName("MyExample3614Tree");
		// the first request of a sample after the start of the application is slow
		tree.element().shouldBe(Condition.visible, tree.getExpectations().getTimeout().multipliedBy(10));
		tree.waitLoaded();
		tree.headers().filter(fb -> fb.input(COLUMN, COLUMN_FILTER));
		return tree.shouldShow(COLUMN_FILTER_FOUND);
	}

	@Test
	@Severity(CRITICAL)
	@Tag("Positive")
	@DisplayName("List: the found rows, then all rows after clearing the field")
	@Description("Every found row contains the text; clearing the field removes the search")
	void listSearchAndClear() {
		var list = list();
		long all = list.rows().streamCurrentPage().count();
		list.fullTextSearch(SEARCH);
		assertThat(list.rows().streamCurrentPage().map(r -> r.input(COLUMN).getValue()))
				.hasSize(FOUND)
				.allSatisfy(name -> assertThat(name).contains(SEARCH));
		list.fullTextSearch(null);
		assertThat(list.rows().streamCurrentPage().count()).isEqualTo(all);
	}

	@Test
	@Severity(CRITICAL)
	@Tag("Positive")
	@DisplayName("List: text shorter than three characters, then cleared: all rows stay")
	@Description("CXBOX-325: clearing the field after the hint \"Enter three or more characters\" sent the search for \"null\" and the list became empty")
	void listShortTextCleared() {
		var list = list();
		long all = list.rows().streamCurrentPage().count();
		list.fullTextSearch(SHORT);
		list.fullTextSearch("");
		assertThat(list.rows().streamCurrentPage().count()).isEqualTo(all);
	}

	@Test
	@Severity(CRITICAL)
	@Tag("Positive")
	@DisplayName("Tree with a column filter: the search narrows the rows, clearing the field keeps the column filter")
	@Description("The filter panel counts the found rows of both filters, then of the column filter only")
	void treeSearchAndClear() {
		var tree = treeWithColumnFilter();
		tree.fullTextSearch(TREE_SEARCH);
		assertThat(tree.filterShown()).isEqualTo(1);
		tree.fullTextSearch(null);
		assertThat(tree.filterShown()).isEqualTo(COLUMN_FILTER_FOUND);
	}

	@Test
	@Severity(CRITICAL)
	@Tag("Positive")
	@DisplayName("Tree with a column filter: text shorter than three characters, then cleared: the rows stay")
	@Description("CXBOX-325: clearing the field after the hint \"Enter three or more characters\" sent the search for \"null\" and the tree became empty")
	void treeShortTextCleared() {
		var tree = treeWithColumnFilter();
		tree.fullTextSearch(SHORT);
		tree.fullTextSearch("");
		assertThat(tree.filterShown()).isEqualTo(COLUMN_FILTER_FOUND);
	}

}
