package application.Samples.Filtration;

import static io.qameta.allure.SeverityLevel.CRITICAL;
import static org.assertj.core.api.Assertions.assertThat;

import application.config.BaseTestForSamples;
import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import core.element.PlatformApp;
import core.element.screen.PlatformScreen;
import core.element.screen.view.PlatformView;
import core.element.widget.chart.ChartWidget.Mode;
import core.element.widget.chart.Column2DWidget;
import core.element.widget.chart.Line2DWidget;
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

@DisplayName("Filtration. Filter by fields, full text search, personal filter group, filter group, default filter group and deleting of a saved group on every widget of the article")
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

	/** Tabs and groups of the default filter group samples: 7 records, 4 High, 2 Middle, 1 Low. */
	private static final String DEFAULT_LIST = "List with default filter group";

	private static final String DEFAULT_TREE = "Tree with default filter group";

	private static final String DEFAULT_BC_FILTER = "Default filter group and BC_PROPERTIES filter";

	private static final String DEFAULT_BC_FILTER_TITLE = "List with BC_PROPERTIES filter and default filter group";

	private static final String HIGH = "Dictionary = High";

	private static final String MIDDLE = "Dictionary = Middle";

	private static final String SHOW_ALL = "Show all";

	private static final String TO_DEFAULT = "To default filter(s)";

	/** Without filters: the first page of the 7 records, the page limit is 5. */
	private static final int ALL_ON_PAGE = 5;

	private static final String PIE_TITLE = "Sales per client";

	private static final String COLUMN_2D_TITLE = "Sales per client";
	private static final String LINE_2D_TITLE = "Sales sum per month";

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
		var form = view(PERSONAL_FILTER_GROUP, "AssocListPopup").formByName("myexample3616listforassoc");
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
		var form = view(FULL_TEXT_SEARCH, "PickListPopup").formByName("myexample3614listforpicklist");
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
		var tree = tree(PERSONAL_FILTER_GROUP, "Tree", "myexample3616tree");
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

	@Test
	@Tag("Positive")
	@DisplayName("by fields: Column2D in the table mode")
	@Description("The filter of the table mode; the chart draws only the filtered records")
	void byFieldsColumn2D() {
		Column2DWidget chart = PlatformApp.screen("Column2D widget filtration").view().column2D(COLUMN_2D_TITLE);
		DocShots.gif(ARTICLE, "filtration_column2d.gif", PAGE_WIDTH, PAGE_HEIGHT, DocShots.Frame.WITHOUT_SIDEBAR);
		var table = chart.mode(Mode.TABLE).table();
		table.headers().filter(fb -> fb.input("Client", "Trade"));
		assertThat(values(table, "Client")).hasSize(3).allMatch(client -> client.contains("Trade"));
		chart.mode(Mode.CHART);
		assertThat(chart.bars()).hasSize(3);
		DocShots.stop();
	}

	@Test
	@Tag("Positive")
	@DisplayName("by fields: Line2D in the table mode")
	@Description("The filter of the table mode; the chart draws only the filtered records")
	void byFieldsLine2D() {
		Line2DWidget chart = PlatformApp.screen("Line2D filtration").view().line2D(LINE_2D_TITLE);
		DocShots.gif(ARTICLE, "filtration_line2d.gif", PAGE_WIDTH, PAGE_HEIGHT, DocShots.Frame.WITHOUT_SIDEBAR);
		var table = chart.mode(Mode.TABLE).table();
		table.headers().filter(fb -> fb.input("Month", "Ma"));
		assertThat(values(table, "Month")).hasSize(2).allMatch(month -> month.contains("Ma"));
		chart.mode(Mode.CHART);
		assertThat(chart.points()).hasSize(2);
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
		var form = view(FULL_TEXT_SEARCH, "AssocListPopup").formByName("myexample3614listforassoc");
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
		var form = view(FULL_TEXT_SEARCH, "PickListPopup").formByName("myexample3614listforpicklist");
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
		var tree = tree(FULL_TEXT_SEARCH, "Tree", "myexample3614tree");
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

	@Test
	@Tag("Positive")
	@DisplayName("by fulltextsearch: Column2D in the table mode")
	@Description("The search of the table mode; the chart draws only the found records")
	void fullTextSearchColumn2D() {
		Column2DWidget chart = PlatformApp.screen("Column2D widget fulltextsearch").view().column2D(COLUMN_2D_TITLE);
		DocShots.gif(ARTICLE, "fulltextsearch_column2d.gif", PAGE_WIDTH, PAGE_HEIGHT, DocShots.Frame.WITHOUT_SIDEBAR);
		var table = chart.mode(Mode.TABLE).table();
		table.fullTextSearch("Trade");
		assertThat(values(table, "Client")).hasSize(3).allMatch(client -> client.contains("Trade"));
		chart.mode(Mode.CHART);
		assertThat(chart.bars()).hasSize(3);
		DocShots.stop();
	}

	@Test
	@Tag("Positive")
	@DisplayName("by fulltextsearch: Line2D in the table mode")
	@Description("The search of the table mode; the chart draws only the found records")
	void fullTextSearchLine2D() {
		Line2DWidget chart = PlatformApp.screen("Line2D fulltextsearch").view().line2D(LINE_2D_TITLE);
		DocShots.gif(ARTICLE, "fulltextsearch_line2d.gif", PAGE_WIDTH, PAGE_HEIGHT, DocShots.Frame.WITHOUT_SIDEBAR);
		var table = chart.mode(Mode.TABLE).table();
		table.fullTextSearch("Mar");
		assertThat(values(table, "Month")).containsExactly("Mar");
		chart.mode(Mode.CHART);
		assertThat(chart.points()).hasSize(1);
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
		var tree = tree(PERSONAL_FILTER_GROUP, "Tree", "myexample3616tree");
		personalFilterGroup(tree, "filtergroup_tree.gif", SAVED_GROUP + "Tree");
	}

	@Test
	@Severity(CRITICAL)
	@Tag("Positive")
	@DisplayName("by personal filter group: List with FullTextSearch")
	@Description("The text of the full text search is saved in the group together with the filters of the columns and is searched again when the group is applied")
	void personalFilterGroupFullTextSearch() {
		var list = view(PERSONAL_FILTER_GROUP, "List with FullTextSearch").listInline("List FullTextSearch and personal filter group");
		String group = SAVED_GROUP + "FullTextSearch";
		DocShots.gif(ARTICLE, "filtergroup_fulltextsearch.gif", PAGE_WIDTH, PAGE_HEIGHT, DocShots.Frame.WITHOUT_SIDEBAR);
		list.fullTextSearch("Soviet");
		list.headers().filter(fb -> fb.input("customField", "data"));
		assertThat(values(list, "Address")).containsExactly("Moscow, Dmitrov, st. Soviet, 14");
		list.settings().select("Save filters");
		var save = new FilterGroupSettingsPopup();
		save.setName(group);
		save.clickButtonCreate();
		list.headers().clearFilters();
		// the table draws the rows again after the answer
		rows(list).shouldHave(CollectionCondition.size(5));
		assertThat(list.fullTextSearchValue()).isEmpty();
		list.headers().filterGroup(group);
		rows(list).shouldHave(CollectionCondition.size(1));
		assertThat(list.fullTextSearchValue()).isEqualTo("Soviet");
		assertThat(values(list, "Address")).containsExactly("Moscow, Dmitrov, st. Soviet, 14");
		DocShots.stop();
		list.headers().clearFilters();
		list.settings().select("Save filters");
		var saved = new FilterGroupSettingsPopup();
		saved.clearAllFilterSettings();
		saved.close();
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
		var tree = tree(FILTER_GROUP, "Tree", "myexample3618tree");
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

	@Test
	@Tag("Positive")
	@DisplayName("by filter group: Column2D in the table mode")
	@Description("The group chosen in the table mode; the chart draws only the records of the group")
	void filterGroupColumn2D() {
		Column2DWidget chart = PlatformApp.screen("Column2D widget filter group").view().column2D(COLUMN_2D_TITLE);
		DocShots.gif(ARTICLE, "filter_group_save_column2d.gif", PAGE_WIDTH, PAGE_HEIGHT, DocShots.Frame.WITHOUT_SIDEBAR);
		var table = chart.mode(Mode.TABLE).table();
		table.headers().filterGroup("Sum from 4000");
		assertThat(values(table, "Client")).hasSize(2);
		chart.mode(Mode.CHART);
		assertThat(chart.bars()).hasSize(2);
		DocShots.stop();
	}

	@Test
	@Tag("Positive")
	@DisplayName("by filter group: Line2D in the table mode")
	@Description("The group chosen in the table mode; the chart draws only the records of the group")
	void filterGroupLine2D() {
		Line2DWidget chart = PlatformApp.screen("Line2D filter group").view().line2D(LINE_2D_TITLE);
		DocShots.gif(ARTICLE, "filter_group_save_line2d.gif", PAGE_WIDTH, PAGE_HEIGHT, DocShots.Frame.WITHOUT_SIDEBAR);
		var table = chart.mode(Mode.TABLE).table();
		table.headers().filterGroup("Sum from 5000");
		assertThat(values(table, "Month")).hasSize(3);
		chart.mode(Mode.CHART);
		assertThat(chart.points()).hasSize(3);
		DocShots.stop();
	}

	// --- default filter group (CXBOX-1382) ---

	@Test
	@Severity(CRITICAL)
	@Tag("Positive")
	@DisplayName("default filter group: List")
	@Description("The group with default_filter = true is applied when the view is opened and is marked by the star. "
			+ "\"To default filter(s)\" is shown when the filters differ from the group and returns the group, "
			+ "\"Clear N filter(s)\" is shown when filters are applied")
	void defaultFilterGroupList() {
		var list = view(FILTER_GROUP, DEFAULT_LIST).listInline(DEFAULT_LIST);
		DocShots.gif(ARTICLE, "default_filter_group_list.gif", PAGE_WIDTH, PAGE_HEIGHT, DocShots.Frame.WITHOUT_SIDEBAR);
		// 1. the view is opened: the default filter group is applied, only "Clear 1 filter(s)"
		assertThat(list.headers().appliedFilterGroup()).isEqualTo(HIGH);
		assertThat(dictionaries(list)).hasSize(4).containsOnly("High");
		assertThat(list.headers().hasClearFilters()).isTrue();
		assertThat(list.headers().resetFiltersTitle()).isNull();
		assertThat(list.headers().filterGroups(true)).containsExactly(HIGH);
		// 2. another group: the filters differ from the default ones, both links
		list.headers().filterGroup(MIDDLE);
		assertThat(dictionaries(list)).hasSize(2).containsOnly("Middle");
		assertThat(list.headers().hasClearFilters()).isTrue();
		assertThat(list.headers().resetFiltersTitle()).isEqualTo(TO_DEFAULT);
		// 3. "Clear N filter(s)": all the records, only the reset link
		list.headers().clearFilters();
		rows(list).shouldHave(CollectionCondition.size(ALL_ON_PAGE));
		assertThat(list.headers().hasClearFilters()).isFalse();
		assertThat(list.headers().resetFiltersTitle()).isEqualTo(TO_DEFAULT);
		// 4. the reset link: the default filter group again, only "Clear 1 filter(s)"
		list.headers().resetFilters();
		rows(list).shouldHave(CollectionCondition.size(4));
		assertThat(list.headers().appliedFilterGroup()).isEqualTo(HIGH);
		assertThat(list.headers().hasClearFilters()).isTrue();
		assertThat(list.headers().resetFiltersTitle()).isNull();
		DocShots.stop();
	}

	@Test
	@Tag("Positive")
	@DisplayName("default filter group: the filters of the user are kept when the user comes back to the view")
	@Description("Priority 1: the filters touched by the user (cleared filters too) are kept when the user leaves the view and "
			+ "comes back; the default filter group is not applied again")
	void defaultFilterGroupUserFiltersKept() {
		var list = view(FILTER_GROUP, DEFAULT_LIST).listInline(DEFAULT_LIST);
		assertThat(list.headers().appliedFilterGroup()).isEqualTo(HIGH);
		list.headers().clearFilters();
		rows(list).shouldHave(CollectionCondition.size(ALL_ON_PAGE));
		// another view and back
		view(FILTER_GROUP, "List").listInline("List");
		list = view(FILTER_GROUP, DEFAULT_LIST).listInline(DEFAULT_LIST);
		rows(list).shouldHave(CollectionCondition.size(ALL_ON_PAGE));
		assertThat(list.headers().hasClearFilters()).isFalse();
		assertThat(list.headers().resetFiltersTitle()).isEqualTo(TO_DEFAULT);
		// the filter of the user is kept too
		list.headers().filterGroup(MIDDLE);
		view(FILTER_GROUP, "List").listInline("List");
		list = view(FILTER_GROUP, DEFAULT_LIST).listInline(DEFAULT_LIST);
		assertThat(dictionaries(list)).hasSize(2).containsOnly("Middle");
		assertThat(list.headers().appliedFilterGroup()).isEqualTo(MIDDLE);
		list.headers().resetFilters();
		assertThat(list.headers().appliedFilterGroup()).isEqualTo(HIGH);
	}

	@Test
	@Tag("Positive")
	@DisplayName("default filter group: the page is refreshed")
	@Description("The filters of the user are not kept after the refresh of the page: the default filter group is applied again")
	void defaultFilterGroupRefresh() {
		var list = view(FILTER_GROUP, DEFAULT_LIST).listInline(DEFAULT_LIST);
		list.headers().clearFilters();
		rows(list).shouldHave(CollectionCondition.size(ALL_ON_PAGE));
		Selenide.refresh();
		list = view(FILTER_GROUP, DEFAULT_LIST).listInline(DEFAULT_LIST);
		rows(list).shouldHave(CollectionCondition.size(4));
		assertThat(list.headers().appliedFilterGroup()).isEqualTo(HIGH);
	}

	@Test
	@Tag("Positive")
	@DisplayName("default filter group: Tree")
	@Description("The default filter group is applied to the tree when the view is opened; the reset link returns it")
	void defaultFilterGroupTree() {
		var tree = tree(FILTER_GROUP, DEFAULT_TREE, "myexample3629tree");
		DocShots.gif(ARTICLE, "default_filter_group_tree.gif", PAGE_WIDTH, PAGE_HEIGHT, DocShots.Frame.WITHOUT_SIDEBAR);
		assertThat(tree.headers().appliedFilterGroup()).isEqualTo(HIGH);
		assertThat(tree.headers().filterGroups(true)).containsExactly(HIGH);
		// the search mode of the tree: "shown N" - the records of the group
		shown(tree, 4);
		assertThat(tree.headers().resetFiltersTitle()).isNull();
		tree.headers().filterGroup(MIDDLE);
		shown(tree, 2);
		assertThat(tree.headers().resetFiltersTitle()).isEqualTo(TO_DEFAULT);
		tree.headers().resetFilters();
		assertThat(tree.headers().appliedFilterGroup()).isEqualTo(HIGH);
		shown(tree, 4);
		assertThat(tree.headers().resetFiltersTitle()).isNull();
		DocShots.stop();
	}

	@Test
	@Tag("Positive")
	@DisplayName("default filter group: the filter of BC_PROPERTIES is applied instead of it")
	@Description("Priority 2: BC_PROPERTIES.FILTER of the business component is applied when the view is opened, "
			+ "the default filter group is not applied, but is marked by the star; the reset link returns the filter of BC_PROPERTIES")
	void defaultFilterGroupBcProperties() {
		var list = view(FILTER_GROUP, DEFAULT_BC_FILTER).listInline(DEFAULT_BC_FILTER_TITLE);
		assertThat(dictionaries(list)).hasSize(2).containsOnly("Middle");
		assertThat(list.headers().appliedFilterGroup()).isEqualTo(SHOW_ALL);
		assertThat(list.headers().filterGroups(true)).containsExactly(HIGH);
		assertThat(list.headers().resetFiltersTitle()).isNull();
		list.headers().filterGroup(HIGH);
		assertThat(dictionaries(list)).hasSize(4).containsOnly("High");
		assertThat(list.headers().resetFiltersTitle()).isEqualTo(TO_DEFAULT);
		list.headers().resetFilters();
		assertThat(dictionaries(list)).hasSize(2).containsOnly("Middle");
		assertThat(list.headers().resetFiltersTitle()).isNull();
	}

	// --- delete a saved personal filter group ---

	@Test
	@Severity(CRITICAL)
	@Tag("Positive")
	@DisplayName("delete personal filter group: List")
	@Description("The user deletes the saved personal filter group by the cross in \"Save filters\": the group disappears "
			+ "from the select above the table and is not shown after the refresh of the page")
	void deletePersonalFilterGroupList() {
		deletePersonalFilterGroup(() -> view(PERSONAL_FILTER_GROUP, "List").listInline("List"), "delete_filter_group_list.gif",
				SAVED_GROUP + "delete List");
	}

	@Test
	@Tag("Positive")
	@DisplayName("delete personal filter group: AdditionalList")
	@Description("The user deletes the saved personal filter group by the cross in \"Save filters\"")
	void deletePersonalFilterGroupAdditionalList() {
		deletePersonalFilterGroup(() -> view(PERSONAL_FILTER_GROUP, "AdditionalList").additionalList("AdditionalList"),
				"delete_filter_group_addlist.gif", SAVED_GROUP + "delete AdditionalList");
	}

	@Test
	@Tag("Positive")
	@DisplayName("delete personal filter group: Tree")
	@Description("The user deletes the saved personal filter group by the cross in \"Save filters\"")
	void deletePersonalFilterGroupTree() {
		deletePersonalFilterGroup(() -> tree(PERSONAL_FILTER_GROUP, "Tree", "myexample3616tree"), "delete_filter_group_tree.gif",
				SAVED_GROUP + "delete Tree");
	}

	@Test
	@Tag("Positive")
	@DisplayName("delete personal filter group: the predefined groups can not be deleted")
	@Description("\"Save filters\" lists only the personal groups of the user: the groups of BC_FILTER_GROUPS have no cross")
	void deletePersonalFilterGroupOnlyPersonal() {
		var list = view(FILTER_GROUP, DEFAULT_LIST).listInline(DEFAULT_LIST);
		String group = SAVED_GROUP + "personal";
		removeIfSaved(list, group);
		list.headers().filterGroup(MIDDLE);
		list.settings().select("Save filters");
		var save = new FilterGroupSettingsPopup();
		// the groups of BC_FILTER_GROUPS are not listed
		assertThat(save.groups()).doesNotContain(HIGH, MIDDLE);
		save.setName(group);
		save.clickButtonCreate();
		assertThat(list.headers().filterGroups(false)).contains(HIGH, MIDDLE, group);
		list.settings().select("Save filters");
		var saved = new FilterGroupSettingsPopup();
		assertThat(saved.groups()).contains(group).doesNotContain(HIGH, MIDDLE);
		saved.remove(group);
		saved.close();
		assertThat(list.headers().filterGroups(false)).contains(HIGH, MIDDLE).doesNotContain(group);
		list.headers().resetFilters();
	}

	/** The group saved by an interrupted run of the test: the names of the groups are unique. */
	private static void removeIfSaved(ListWidget<?, ?, ?> widget, String group) {
		widget.settings().select("Save filters");
		var popup = new FilterGroupSettingsPopup();
		if (popup.groups().contains(group)) {
			popup.remove(group);
		}
		popup.close();
	}

	private static void deletePersonalFilterGroup(java.util.function.Supplier<? extends ListWidget<?, ?, ?>> widgetOf, String gif,
			String group) {
		var widget = widgetOf.get();
		removeIfSaved(widget, group);
		widget.headers().filter(fb -> fb.input("Custom Field New", "new 2"));
		widget.settings().select("Save filters");
		var save = new FilterGroupSettingsPopup();
		save.setName(group);
		save.clickButtonCreate();
		widget.headers().clearFilters();
		assertThat(widget.headers().filterGroups(false)).contains(group);
		DocShots.gif(ARTICLE, gif, PAGE_WIDTH, PAGE_HEIGHT, DocShots.Frame.WITHOUT_SIDEBAR);
		widget.settings().select("Save filters");
		var saved = new FilterGroupSettingsPopup();
		assertThat(saved.groups()).contains(group);
		saved.remove(group);
		assertThat(saved.groups()).doesNotContain(group);
		saved.close();
		assertThat(widget.headers().filterGroups(false)).doesNotContain(group);
		DocShots.stop();
		// the group is deleted on the server: it is not loaded again with the meta of the screen
		Selenide.refresh();
		widget = widgetOf.get();
		widget.element();
		var filterGroups = widget.element().$$("div[class*=\"Header__filtersContainer\"] .ant-select");
		if (!filterGroups.isEmpty()) {
			assertThat(widget.headers().filterGroups(false)).doesNotContain(group);
		}
	}

	private static List<String> dictionaries(PlatformListWidgetInline list) {
		return list.rows().streamCurrentPage().map(row -> row.dictionary("Custom Field Dictionary").getValue()).toList();
	}

	/** "shown N" above the tree in the search mode: the number of the found records. */
	private static void shown(PlatformTreeWidgetInline tree, int count) {
		tree.element().$("[data-test-widget-tree-filter-shown]")
				.shouldHave(com.codeborne.selenide.Condition.attribute("data-test-widget-tree-filter-shown", String.valueOf(count)),
						tree.getExpectations().getTimeout());
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
		return PlatformApp.screen("Tree widget basic").secondLevelView("Business example").formByName("myexample3263list");
	}

	private static List<String> values(PlatformListWidgetInline list, String column) {
		return list.rows().streamCurrentPage().map(row -> row.input(column).getValue()).toList();
	}

	private static ElementsCollection rows(PlatformListWidgetInline list) {
		return list.element().$$("tbody tr[data-test-widget-list-row-type='Row']");
	}

	private static List<String> departments(PlatformTreeWidgetInline tree) {
		return departments(tree, "Departments");
	}

	private static List<String> departments(PlatformTreeWidgetInline tree, String column) {
		return tree.rows().streamCurrentPage().map(row -> row.input(column).getValue()).toList();
	}

}
