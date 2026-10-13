package application.Samples.Feature.drilldown;

import application.config.BaseTestForSamples;
import core.element.PlatformApp;
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
 * The total count of the list pagination ("of N") after each drillDown format of the article:
 * N is the count of all records the list has after the drillDown, on all its pages.
 * DrillDown to a record: the list has this record only, N is 1 (CXBOX-369: it was the count of all records of the bc).
 * DrillDown with a filter: N is the count of records that match the filter. DrillDown without id and filter: N is the count of all records.
 */
@DisplayName("DrillDown. Total count of the list pagination after drillDown")
@Epic("Samples")
@Feature(DrillDownPaginationTest.ARTICLE)
@Tag("Samples")
public class DrillDownPaginationTest extends BaseTestForSamples {

	static final String ARTICLE = "features/element/drilldown/drilldown";

	@Test
	@Severity(CRITICAL)
	@Tag("Positive")
	@DisplayName("To screen: the list has all records")
	@Description("DrillDown from Info to another screen opens its list with all records, the total count is the count of all records.")
	void toScreen() {
		PlatformApp.screen("Feature drilldown to screen")
				.view()
				.info("Info")
				.input("customField")
				.drilldown(url -> assertThat(url).contains("/screen/myexample3610"));
		PlatformApp.currentScreen()
				.view()
				.listInline("List")
				.pagination()
				.checkTotal(total -> assertThat(total).isEqualTo(2));
	}

	@Test
	@Severity(CRITICAL)
	@Tag("Positive")
	@DisplayName("To view without id: the list has all records")
	@Description("DrillDown from Info to the view of the list without a record id opens the list with all records.")
	void toViewWithoutId() {
		PlatformApp.screen("Feature Drilldown to view")
				.secondLevelView("Info")
				.info("Info")
				.input("Custom Field DrillDowm")
				.drilldown(url -> assertThat(url).contains("/view/myexample3611list"));
		PlatformApp.currentScreen()
				.view()
				.listInline("List")
				.pagination()
				.checkTotal(total -> assertThat(total).isEqualTo(2));
	}

	@Test
	@Severity(CRITICAL)
	@Tag("Positive")
	@DisplayName("To view by bc record id: the list has this record only")
	@Description("DrillDown from the list to Info of a record, then the List tab: the list has this record only, the total count is 1.")
	void toViewById() {
		PlatformApp.screen("Feature Drilldown to view by bc record id")
				.secondLevelView("List")
				.listInline("List")
				.rows()
				.row(0)
				.input("customFieldDrillDown")
				.drilldown(url -> assertThat(url).contains("/view/myexample3610form/myexample3610/"));
		PlatformApp.currentScreen()
				.secondLevelView("List")
				.listInline("List")
				.pagination()
				.checkTotal(total -> assertThat(total).isEqualTo(1));
	}

	@Test
	@Severity(CRITICAL)
	@Tag("Positive")
	@DisplayName("With fields filtration: the list has the records of the filter")
	@Description("DrillDown from Info to the list with a filter by a field: the total count is the count of records that match the filter.")
	void byFieldsFiltration() {
		PlatformApp.screen("Feature drilldown (visually visible)")
				.view()
				.info("Info")
				.input("customField")
				.drilldown(url -> assertThat(url).contains("/view/myexample3612list/myexample3612"));
		PlatformApp.currentScreen()
				.view()
				.listInline("List")
				.pagination()
				.checkTotal(total -> assertThat(total).isEqualTo(2));
	}

	@Test
	@Severity(CRITICAL)
	@Tag("Positive")
	@DisplayName("By full text search: the list has the found records")
	@Description("DrillDown from Info to the list with a full text search: the total count is the count of found records.")
	void byFullTextSearch() {
		PlatformApp.screen("Feature drilldown fullTextSearch")
				.view()
				.info("Info")
				.input("customField")
				.drilldown(url -> assertThat(url).contains("/view/myexample3615list/myexample3615"));
		PlatformApp.currentScreen()
				.view()
				.listInline("List")
				.pagination()
				.checkTotal(total -> assertThat(total).isEqualTo(2));
	}

	@Test
	@Severity(CRITICAL)
	@Tag("Positive")
	@DisplayName("By filter group: the list has the records of the filters")
	@Description("DrillDown from Info to the list with several filters: the total count is the count of records that match them.")
	void byFilterGroup() {
		// both widgets have the title "List"
		PlatformApp.screen("Feature drilldown filter group")
				.view()
				.infoByName("MyExample3617Info")
				.input("Custom Field DrillDown")
				.drilldown(url -> assertThat(url).contains("/view/myexample3617list/myexample3617"));
		PlatformApp.currentScreen()
				.view()
				.listInlineByName("MyExample3617List")
				.pagination()
				.checkTotal(total -> assertThat(total).isEqualTo(1));
	}

	@Test
	@Severity(CRITICAL)
	@Tag("Positive")
	@DisplayName("Going forward after drillDown: the list has the record until a view without id")
	@Description("DrillDown from the list to Step 1 of a record: the list has this record only on Step 1 and on the Step2 tab; "
			+ "Go to Step3 opens a view without id and the list has all records again.")
	void goingForwardAfterDrillDown() {
		PlatformApp.screen("Feature drilldown going forward after")
				.view()
				.listInline("List")
				.rows()
				.row(2)
				.input("customField")
				.drilldown(url -> assertThat(url).contains("/view/myexample3621info/myexample3621/"));
		PlatformApp.currentScreen()
				.view()
				.listInline("List")
				.pagination()
				.checkTotal(total -> assertThat(total).isEqualTo(1));
		var step2 = PlatformApp.currentScreen().secondLevelView("Step2");
		step2.listInline("List")
				.pagination()
				.checkTotal(total -> assertThat(total).isEqualTo(1));
		step2.form("Step 2").actions().click("Go to Step3");
		PlatformApp.currentScreen()
				.view()
				.listInline("List")
				.pagination()
				.checkTotal(total -> assertThat(total).isEqualTo(6));
	}

	@Test
	@Severity(CRITICAL)
	@Tag("Positive")
	@DisplayName("Going back after drillDown: the list has all records again")
	@Description("DrillDown from the list to Info of a record: the list has this record only; Go to List returns to the list with all records.")
	void goingBackAfterDrillDown() {
		PlatformApp.screen("Feature drilldown going back after")
				.view()
				.listInline("List")
				.rows()
				.row(0)
				.input("customField")
				.drilldown(url -> assertThat(url).contains("/view/myexample3620info/myexample3620/"));
		var view = PlatformApp.currentScreen().view();
		view.listInline("List")
				.pagination()
				.checkTotal(total -> assertThat(total).isEqualTo(1));
		view.form("Info").actions().click("Go to List");
		PlatformApp.currentScreen()
				.view()
				.listInline("List")
				.pagination()
				.checkTotal(total -> assertThat(total).isEqualTo(6));
	}
}
