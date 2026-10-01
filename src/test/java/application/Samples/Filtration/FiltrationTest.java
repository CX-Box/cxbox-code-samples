package application.Samples.Filtration;

import static io.qameta.allure.SeverityLevel.CRITICAL;
import static org.assertj.core.api.Assertions.assertThat;

import application.config.BaseTestForSamples;
import core.element.PlatformApp;
import core.element.screen.PlatformScreen;
import core.element.screen.view.PlatformView;
import core.element.widget.chart.ChartWidget.Mode;
import core.element.widget.chart.Pie1DWidget;
import core.element.widget.field.type.multivalue.Multivalue;
import core.element.widget.form.PlatformFormWidget;
import core.element.widget.list.ListWidget;
import core.element.widget.list.filter.header.modal.FilterGroupSettingsPopup;
import core.element.widget.list.realization.inline.gh.PlatformGHWidgetInline;
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

@DisplayName("Filtration. Filter by fields, full text search, personal filter group and filter group on every widget of the article")
@Epic("Samples")
@Feature(FiltrationTest.ARTICLE)
@Tag("Samples")
@Tag("Filtration")
public class FiltrationTest extends BaseTestForSamples {

	static final String ARTICLE = "widget/type/property/filtration";

	private static final String SCREEN = "Widget property Filtration";

	private static final String FULL_TEXT_SEARCH = "Widget property FullTextSearch";

	private static final String PERSONAL_FILTER_GROUP = "Widget property personal filter group";

	private static final String FILTER_GROUP = "Widget property filter group";

	/** Window of the GIFs on the page: the widget without the side menu. */
	private static final int PAGE_WIDTH = 1660;

	private static final int PAGE_HEIGHT = 760;

	/** Window of the GIFs with a popup: the popup is centered in the window. */
	private static final int POPUP_WIDTH = 1200;

	private static final int POPUP_HEIGHT = 760;

	/** The tree popups of the business example have many columns. */
	private static final int TREE_POPUP_WIDTH = 1600;

	private static final int TREE_POPUP_HEIGHT = 1000;

	/**
	 * Name of the personal filter group saved by the tests; the tests delete it.
	 * The name of a group is unique for a business component, and List, AdditionalList and Tree share one.
	 */
	private static final String SAVED_GROUP = "My filter ";

	/** A department of the business example of the tree popups. */
	private static final String DEPARTMENT = "Минстроя";

	private static final String PIE_TITLE = "Sales per client";

	// --- by fields ---

	@Test
	@Severity(CRITICAL)
	@Tag("Positive")
	@DisplayName("by fields: List")
	@Description("The filter of a column leaves the records with the value")
	void byFieldsList() {
		var list = view(PERSONAL_FILTER_GROUP, "List").listInline("List");
		DocShots.gif(ARTICLE, "filtration_list.gif", PAGE_WIDTH, PAGE_HEIGHT, DocShots.Frame.WITHOUT_SIDEBAR);
		list.headers().filter(fb -> fb.input("Custom Field New", "new 2"));
		assertThat(values(list, "Custom Field New")).containsExactly("test data new 2");
		DocShots.stop();
	}

	@Test
	@Tag("Positive")
	@DisplayName("by fields: AdditionalList")
	@Description("The filter of a column of the AdditionalList leaves the records with the value")
	void byFieldsAdditionalList() {
		var list = view(PERSONAL_FILTER_GROUP, "AdditionalList").additionalList("AdditionalList");
		DocShots.gif(ARTICLE, "filtration_addlist.gif", PAGE_WIDTH, PAGE_HEIGHT, DocShots.Frame.WITHOUT_SIDEBAR);
		list.headers().filter(fb -> fb.input("Custom Field New", "new 2"));
		assertThat(values(list, "Custom Field New")).containsExactly("test data new 2");
		DocShots.stop();
	}

	@Test
	@Tag("Positive")
	@DisplayName("by fields: GroupingHierarchy")
	@Description("The filter of a column of the GroupingHierarchy leaves the groups with the value")
	void byFieldsGroupingHierarchy() {
		var gh = groupingHierarchy();
		DocShots.gif(ARTICLE, "filtration_gh.gif", PAGE_WIDTH, PAGE_HEIGHT, DocShots.Frame.WITHOUT_SIDEBAR);
		gh.headers().filter(fb -> fb.dictionary("Custom Field Dictionary", "High"));
		DocShots.stop();
	}

	@Test
	@Tag("Positive")
	@DisplayName("by fields: AssocListPopup")
	@Description("The filter of a column of the popup leaves the records with the value")
	void byFieldsAssocListPopup() {
		var form = view(PERSONAL_FILTER_GROUP, "AssocListPopup").formByName("MyExample3616ListForAssoc");
		DocShots.gif(ARTICLE, "filtration_assoc.gif", POPUP_WIDTH, POPUP_HEIGHT, DocShots.Frame.WITH_SIDEBAR);
		var popup = form.field(w -> new Multivalue<>(w, "Custom Field Multivalue")).openPopup().list();
		popup.headers().filter(fb -> fb.input("Custom Field", "data 4"));
		assertThat(values(popup, "Custom Field")).containsExactly("test data 4", "test data 4");
		DocShots.stop();
	}

	@Test
	@Tag("Positive")
	@DisplayName("by fields: PickListPopup")
	@Description("The filter of a column of the popup leaves the records with the value")
	void byFieldsPickListPopup() {
		var form = view(FULL_TEXT_SEARCH, "PickListPopup").formByName("MyExample3614ListForPicklist");
		DocShots.gif(ARTICLE, "filtration_picklist.gif", POPUP_WIDTH, POPUP_HEIGHT, DocShots.Frame.WITH_SIDEBAR);
		var popup = form.pickList("Custom Field PickList").openListPopup();
		popup.list().headers().filter(fb -> fb.input("Custom Field", "data3"));
		assertThat(values(popup.list(), "Custom Field")).containsExactly("test data3");
		DocShots.stop();
		popup.close();
	}

	@Test
	@Severity(CRITICAL)
	@Tag("Positive")
	@DisplayName("by fields: Tree")
	@Description("The filter of a column of the tree shows the found records by the search mode")
	void byFieldsTree() {
		var tree = tree(PERSONAL_FILTER_GROUP, "Tree", "MyExample3616Tree");
		DocShots.gif(ARTICLE, "filtration_tree.gif", PAGE_WIDTH, PAGE_HEIGHT, DocShots.Frame.WITHOUT_SIDEBAR);
		tree.headers().filter(fb -> fb.input("Custom Field New", "new 2"));
		tree.shouldShow(1);
		DocShots.stop();
	}

	@Test
	@Tag("Positive")
	@DisplayName("by fields: AssocTreePopup")
	@Description("The filter of a column of the tree popup shows the found departments by the search mode")
	void byFieldsAssocTreePopup() {
		var form = businessExample();
		DocShots.gif(ARTICLE, "filtration_assoctree.gif", TREE_POPUP_WIDTH, TREE_POPUP_HEIGHT, DocShots.Frame.WITH_SIDEBAR);
		var popup = form.multivalueTree("Departments Assoc").openPopup();
		var tree = popup.tree();
		tree.headers().filter(fb -> fb.input("Departments", DEPARTMENT));
		tree.waitLoaded();
		assertThat(departments(tree)).isNotEmpty().anyMatch(text -> text.contains(DEPARTMENT));
		DocShots.stop();
		popup.closeModal();
	}

	@Test
	@Tag("Positive")
	@DisplayName("by fields: PickTreePopup")
	@Description("The filter of a column of the tree popup shows the found departments by the search mode")
	void byFieldsPickTreePopup() {
		var form = businessExample();
		DocShots.gif(ARTICLE, "filtration_picktree.gif", TREE_POPUP_WIDTH, TREE_POPUP_HEIGHT, DocShots.Frame.WITH_SIDEBAR);
		var popup = form.pickTree("Department Pick").openPopup();
		var tree = popup.tree();
		tree.headers().filter(fb -> fb.input("Department", DEPARTMENT));
		tree.waitLoaded();
		assertThat(departments(tree, "Department")).isNotEmpty().anyMatch(text -> text.contains(DEPARTMENT));
		DocShots.stop();
		popup.close();
	}

	@Test
	@Tag("Positive")
	@DisplayName("by fields: Pie1D in the table mode")
	@Description("The filter of the table mode; the chart draws only the filtered records")
	void byFieldsPie1D() {
		Pie1DWidget chart = PlatformApp.screen("Pie1D filtration").view().pie1D(PIE_TITLE);
		DocShots.gif(ARTICLE, "filtration_pie1d.gif", PAGE_WIDTH, PAGE_HEIGHT, DocShots.Frame.WITHOUT_SIDEBAR);
		var table = chart.mode(Mode.TABLE).table();
		table.headers().filter(fb -> fb.input("Client", "Trade"));
		assertThat(values(table, "Client")).hasSize(3).allMatch(client -> client.contains("Trade"));
		chart.mode(Mode.CHART);
		assertThat(chart.segments()).hasSize(3);
		DocShots.stop();
	}

	// --- by fulltextsearch ---

	@Test
	@Severity(CRITICAL)
	@Tag("Positive")
	@DisplayName("by fulltextsearch: List")
	@Description("The search text leaves the records where one of the columns contains it")
	void fullTextSearchList() {
		var list = view(FULL_TEXT_SEARCH, "List").listInline("List FullTextSearch");
		DocShots.gif(ARTICLE, "fulltextsearch.gif", PAGE_WIDTH, PAGE_HEIGHT, DocShots.Frame.WITHOUT_SIDEBAR);
		list.fullTextSearch("Soviet");
		assertThat(values(list, "Address")).hasSize(2).allMatch(address -> address.contains("Soviet"));
		DocShots.stop();
	}

	@Test
	@Tag("Positive")
	@DisplayName("by fulltextsearch: AssocListPopup")
	@Description("The search text of the popup leaves the records where one of the columns contains it")
	void fullTextSearchAssocListPopup() {
		var form = view(FULL_TEXT_SEARCH, "AssocListPopup").formByName("MyExample3614ListForAssoc");
		DocShots.gif(ARTICLE, "fulltextsearch_assoc.gif", POPUP_WIDTH, POPUP_HEIGHT, DocShots.Frame.WITH_SIDEBAR);
		var popup = form.field(w -> new Multivalue<>(w, "Custom Field Multivalue")).openPopup().list();
		popup.fullTextSearch("text2");
		assertThat(values(popup, "Custom Field")).hasSize(2);
		DocShots.stop();
	}

	@Test
	@Tag("Positive")
	@DisplayName("by fulltextsearch: PickListPopup")
	@Description("The search text of the popup leaves the records where one of the columns contains it")
	void fullTextSearchPickListPopup() {
		var form = view(FULL_TEXT_SEARCH, "PickListPopup").formByName("MyExample3614ListForPicklist");
		DocShots.gif(ARTICLE, "fulltextsearch_picklist.gif", POPUP_WIDTH, POPUP_HEIGHT, DocShots.Frame.WITH_SIDEBAR);
		var popup = form.pickList("Custom Field PickList").openListPopup();
		popup.list().fullTextSearch("text2");
		assertThat(values(popup.list(), "Custom Field")).hasSize(2);
		DocShots.stop();
		popup.close();
	}

	@Test
	@Severity(CRITICAL)
	@Tag("Positive")
	@DisplayName("by fulltextsearch: Tree")
	@Description("The search text of the tree shows the found records by the search mode")
	void fullTextSearchTree() {
		var tree = tree(FULL_TEXT_SEARCH, "Tree", "MyExample3614Tree");
		DocShots.gif(ARTICLE, "fulltextsearch_tree.gif", PAGE_WIDTH, PAGE_HEIGHT, DocShots.Frame.WITHOUT_SIDEBAR);
		tree.fullTextSearch("Neal");
		tree.shouldShow(2);
		DocShots.stop();
	}

	@Test
	@Tag("Positive")
	@DisplayName("by fulltextsearch: AssocTreePopup")
	@Description("The search text of the tree popup shows the found departments by the search mode")
	void fullTextSearchAssocTreePopup() {
		var form = businessExample();
		DocShots.gif(ARTICLE, "fulltextsearch_assoctree.gif", TREE_POPUP_WIDTH, TREE_POPUP_HEIGHT, DocShots.Frame.WITH_SIDEBAR);
		var popup = form.multivalueTree("Departments Assoc").openPopup();
		popup.fullTextSearch(DEPARTMENT);
		var tree = popup.tree();
		tree.waitLoaded();
		assertThat(departments(tree)).isNotEmpty().anyMatch(text -> text.contains(DEPARTMENT));
		DocShots.stop();
		popup.closeModal();
	}

	@Test
	@Tag("Positive")
	@DisplayName("by fulltextsearch: PickTreePopup")
	@Description("The search text of the tree popup shows the found departments by the search mode")
	void fullTextSearchPickTreePopup() {
		var form = businessExample();
		DocShots.gif(ARTICLE, "fulltextsearch_picktree.gif", TREE_POPUP_WIDTH, TREE_POPUP_HEIGHT, DocShots.Frame.WITH_SIDEBAR);
		var popup = form.pickTree("Department Pick").openPopup();
		popup.fullTextSearch(DEPARTMENT);
		var tree = popup.tree();
		tree.waitLoaded();
		assertThat(departments(tree, "Department")).isNotEmpty().anyMatch(text -> text.contains(DEPARTMENT));
		DocShots.stop();
		popup.close();
	}

	@Test
	@Tag("Positive")
	@DisplayName("by fulltextsearch: Pie1D in the table mode")
	@Description("The search of the table mode; the chart draws only the found records")
	void fullTextSearchPie1D() {
		Pie1DWidget chart = PlatformApp.screen("Pie1D fulltextsearch").view().pie1D(PIE_TITLE);
		DocShots.gif(ARTICLE, "fulltextsearch_pie1d.gif", PAGE_WIDTH, PAGE_HEIGHT, DocShots.Frame.WITHOUT_SIDEBAR);
		var table = chart.mode(Mode.TABLE).table();
		table.fullTextSearch("Trade");
		assertThat(values(table, "Client")).hasSize(3).allMatch(client -> client.contains("Trade"));
		chart.mode(Mode.CHART);
		assertThat(chart.segments()).hasSize(3);
		DocShots.stop();
	}

	// --- by personal filter group ---

	@Test
	@Severity(CRITICAL)
	@Tag("Positive")
	@DisplayName("by personal filter group: List")
	@Description("The filter is saved as a group of the user and applied again from the select above the table")
	void personalFilterGroupList() {
		var list = view(PERSONAL_FILTER_GROUP, "List").listInline("List");
		personalFilterGroup(list, "filtergroup.gif", SAVED_GROUP + "List");
	}

	@Test
	@Tag("Positive")
	@DisplayName("by personal filter group: AdditionalList")
	@Description("The filter is saved as a group of the user and applied again from the select above the table")
	void personalFilterGroupAdditionalList() {
		var list = view(PERSONAL_FILTER_GROUP, "AdditionalList").additionalList("AdditionalList");
		personalFilterGroup(list, "filtergroup_addlist.gif", SAVED_GROUP + "AdditionalList");
	}

	@Test
	@Tag("Positive")
	@DisplayName("by personal filter group: Tree")
	@Description("The filter is saved as a group of the user and applied again from the select above the tree")
	void personalFilterGroupTree() {
		var tree = tree(PERSONAL_FILTER_GROUP, "Tree", "MyExample3616Tree");
		personalFilterGroup(tree, "filtergroup_tree.gif", SAVED_GROUP + "Tree");
	}

	// --- by filter group ---

	@Test
	@Severity(CRITICAL)
	@Tag("Positive")
	@DisplayName("by filter group: List")
	@Description("The group chosen above the table leaves the records of the group")
	void filterGroupList() {
		var list = view(FILTER_GROUP, "List").listInline("List");
		filterGroup(list, "filter_group_save_list.gif");
	}

	@Test
	@Tag("Positive")
	@DisplayName("by filter group: AdditionalList")
	@Description("The group chosen above the table leaves the records of the group")
	void filterGroupAdditionalList() {
		var list = view(FILTER_GROUP, "AdditionalList").additionalList("AdditionalList");
		filterGroup(list, "filter_group_save_add_list.gif");
	}

	@Test
	@Tag("Positive")
	@DisplayName("by filter group: Tree")
	@Description("The group chosen above the tree shows the records of the group by the search mode")
	void filterGroupTree() {
		var tree = tree(FILTER_GROUP, "Tree", "MyExample3618Tree");
		filterGroup(tree, "filter_group_save_tree.gif");
	}

	@Test
	@Tag("Positive")
	@DisplayName("by filter group: Pie1D in the table mode")
	@Description("The group chosen in the table mode; the chart draws only the records of the group")
	void filterGroupPie1D() {
		Pie1DWidget chart = PlatformApp.screen("Pie1D filter group").view().pie1D(PIE_TITLE);
		DocShots.gif(ARTICLE, "filter_group_save_pie1d.gif", PAGE_WIDTH, PAGE_HEIGHT, DocShots.Frame.WITHOUT_SIDEBAR);
		var table = chart.mode(Mode.TABLE).table();
		table.headers().filterGroup("Sum from 5000");
		assertThat(values(table, "Client")).hasSize(4);
		chart.mode(Mode.CHART);
		assertThat(chart.segments()).hasSize(4);
		DocShots.stop();
	}

	private static void personalFilterGroup(ListWidget<?, ?, ?> widget, String gif, String group) {
		DocShots.gif(ARTICLE, gif, PAGE_WIDTH, PAGE_HEIGHT, DocShots.Frame.WITHOUT_SIDEBAR);
		widget.headers().filter(fb -> fb.input("Custom Field New", "new 2"));
		widget.settings().select("Save filters");
		var save = new FilterGroupSettingsPopup();
		save.setName(group);
		save.clickButtonCreate();
		widget.headers().clearFilters();
		widget.headers().filterGroup(group);
		DocShots.stop();
		widget.settings().select("Save filters");
		var saved = new FilterGroupSettingsPopup();
		saved.clearAllFilterSettings();
		saved.close();
	}

	private static void filterGroup(ListWidget<?, ?, ?> widget, String gif) {
		DocShots.gif(ARTICLE, gif, PAGE_WIDTH, PAGE_HEIGHT, DocShots.Frame.WITHOUT_SIDEBAR);
		widget.headers().filterGroup("Dictionary = High");
		DocShots.stop();
		widget.headers().clearFilters();
	}

	private static PlatformScreen screen() {
		return PlatformApp.screen(SCREEN);
	}

	/** A tab of the samples of the article: the second level is the section, the third level is the widget. */
	private static PlatformView view(String section, String widget) {
		var screen = screen();
		screen.secondLevelView(section);
		return screen.thirdLevelView(widget);
	}

	private static PlatformTreeWidgetInline tree(String section, String widget, String name) {
		var tree = view(section, widget).treeByName(name);
		tree.waitLoaded();
		return tree;
	}

	/** GroupingHierarchy basic: the records are grouped by the dictionary column, which has a filter. */
	private static PlatformGHWidgetInline groupingHierarchy() {
		String title = "GroupingHierarchy (GH) widget basic";
		return PlatformApp.screen(title).secondLevelView(title).groupingHierarchyInline(title);
	}

	/** The form of the business example of the tree samples with the fields that open the tree popups. */
	private static PlatformFormWidget businessExample() {
		return PlatformApp.screen("Tree widget basic").secondLevelView("Business example").formByName("MyExample3263List");
	}

	private static List<String> values(PlatformListWidgetInline list, String column) {
		return list.rows().streamCurrentPage().map(row -> row.input(column).getValue()).toList();
	}

	private static List<String> departments(PlatformTreeWidgetInline tree) {
		return departments(tree, "Departments");
	}

	private static List<String> departments(PlatformTreeWidgetInline tree, String column) {
		return tree.rows().streamCurrentPage().map(row -> row.input(column).getValue()).toList();
	}

}
