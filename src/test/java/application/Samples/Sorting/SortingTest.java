package application.Samples.Sorting;

import static io.qameta.allure.SeverityLevel.CRITICAL;
import static org.assertj.core.api.Assertions.assertThat;

import application.config.BaseTestForSamples;
import core.element.PlatformApp;
import core.element.widget.chart.ChartWidget.Mode;
import core.element.widget.chart.Pie1DWidget;
import core.element.widget.list.realization.inline.list.PlatformListWidgetInline;
import core.element.widget.list.realization.inline.tree.PlatformTreeWidgetInline;
import core.util.DocShots;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

@DisplayName("Sorting. Sorting by a column on every widget of the article")
@Epic("Samples")
@Feature(SortingTest.ARTICLE)
@Tag("Samples")
@Tag("Sorting")
public class SortingTest extends BaseTestForSamples {

	static final String ARTICLE = "widget/type/property/sorting";

	/** Window of the GIFs on the page: the widget without the side menu. */
	private static final int PAGE_WIDTH = 1660;

	private static final int PAGE_HEIGHT = 760;

	/** Window of the GIFs with a popup: the popup is centered in the window. */
	private static final int POPUP_WIDTH = 1200;

	private static final int POPUP_HEIGHT = 760;

	@Test
	@Severity(CRITICAL)
	@Tag("Positive")
	@DisplayName("List")
	@Description("A click on the sort icon of the column sorts the records")
	void list() {
		var list = PlatformApp.screen("Input sorting").secondLevelView("List").listInline("List");
		DocShots.gif(ARTICLE, "sorting.gif", PAGE_WIDTH, PAGE_HEIGHT, DocShots.Frame.WITHOUT_SIDEBAR);
		list.headers().sort(sb -> sb.sort("customField"));
		assertThat(values(list, "customField")).containsExactly("Acb row", "Abc row", "A2 row", "A1 row", "2 row");
		DocShots.stop();
	}

	@Test
	@Tag("Positive")
	@DisplayName("GroupingHierarchy")
	@Description("The records are sorted inside the groups; the groups keep their order")
	void groupingHierarchy() {
		String title = "GroupingHierarchy (GH) widget basic";
		var gh = PlatformApp.screen(title).secondLevelView(title).groupingHierarchyInline(title);
		DocShots.gif(ARTICLE, "sorting_gh.gif", PAGE_WIDTH, PAGE_HEIGHT, DocShots.Frame.WITHOUT_SIDEBAR);
		// the records already go in the descending order: the second click shows the change
		gh.headers().sort(sb -> sb.sort("customField"));
		gh.headers().sort(sb -> sb.sort("customField"));
		DocShots.stop();
	}

	@Test
	@Severity(CRITICAL)
	@Tag("Positive")
	@DisplayName("Tree")
	@Description("The records are sorted inside a node; the hierarchy is not changed")
	void tree() {
		var tree = PlatformApp.screen("Tree widget basic").secondLevelView("Tree Basic").treeByName("MyExample3281Tree");
		tree.waitLoaded();
		DocShots.gif(ARTICLE, "sorting_tree.gif", PAGE_WIDTH, PAGE_HEIGHT, DocShots.Frame.WITHOUT_SIDEBAR);
		// the roots already go in the descending order: the second click shows the change
		sortTwice(tree, "Custom Field");
		assertThat(tree.rows().row(0).input("Custom Field").getValue()).startsWith("Root 1");
		DocShots.stop();
	}

	@Test
	@Tag("Positive")
	@DisplayName("AssocTreePopup")
	@Description("The records of the popup are sorted inside a node")
	void assocTreePopup() {
		var form = PlatformApp.screen("MultivalueTree sorting").secondLevelView("Form").formByName("MyExample3323Form");
		DocShots.gif(ARTICLE, "sorting_assoctree.gif", POPUP_WIDTH, POPUP_HEIGHT, DocShots.Frame.WITH_SIDEBAR);
		var popup = form.multivalueTree("Custom Field").openPopup();
		var tree = popup.tree();
		tree.rows().row(0).expandRow();
		tree.headers().sort(sb -> sb.sort("Custom Field"));
		tree.waitLoaded();
		tree.rows().row(0).expandRow();
		DocShots.stop();
		popup.closeModal();
	}

	@Test
	@Tag("Positive")
	@DisplayName("PickTreePopup")
	@Description("The records of the popup are sorted inside a node")
	void pickTreePopup() {
		var form = PlatformApp.screen("Picktree sorting").secondLevelView("Form").formByName("MyExample3290Form");
		DocShots.gif(ARTICLE, "sorting_picktree.gif", POPUP_WIDTH, POPUP_HEIGHT, DocShots.Frame.WITH_SIDEBAR);
		var popup = form.pickTree("Custom Field").openPopup();
		var tree = popup.tree();
		tree.rows().row(0).expandRow();
		tree.headers().sort(sb -> sb.sort("Custom Field"));
		tree.waitLoaded();
		tree.rows().row(0).expandRow();
		assertThat(tree.rows().row(1).input("Custom Field").getValue()).isEqualTo("Test data");
		DocShots.stop();
		popup.close();
	}

	@Test
	@Tag("Positive")
	@DisplayName("Pie1D in the table mode")
	@Description("The sort of the table mode; the chart draws the segments in the sorted order")
	void pie1D() {
		Pie1DWidget chart = PlatformApp.screen("Pie1D sorting").view().pie1D("Sales per client");
		DocShots.gif(ARTICLE, "sorting_pie1d.gif", PAGE_WIDTH, PAGE_HEIGHT, DocShots.Frame.WITHOUT_SIDEBAR);
		var table = chart.mode(Mode.TABLE).table();
		table.headers().sort(sb -> sb.sort("Sales"));
		assertThat(values(table, "Client")).first().isEqualTo("LLC TelemedOperations");
		chart.mode(Mode.CHART);
		DocShots.stop();
	}

	/** Sorts the column in the descending and then in the ascending order; a sort collapses a tree. */
	private static void sortTwice(PlatformTreeWidgetInline tree, String column) {
		tree.headers().sort(sb -> sb.sort(column));
		tree.waitLoaded();
		tree.headers().sort(sb -> sb.sort(column));
		tree.waitLoaded();
	}

	private static List<String> values(PlatformListWidgetInline list, String column) {
		return list.rows().streamCurrentPage().map(row -> row.input(column).getValue()).toList();
	}

}
