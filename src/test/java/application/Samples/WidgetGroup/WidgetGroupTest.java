package application.Samples.WidgetGroup;

import application.config.BaseTestForSamples;
import core.element.PlatformApp;
import core.element.screen.PlatformScreen;
import core.element.screen.view.PlatformView;
import core.util.DocShots;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static com.codeborne.selenide.Selenide.$;
import static io.qameta.allure.SeverityLevel.CRITICAL;
import static org.assertj.core.api.Assertions.assertThat;

/** Groups of widgets of the view ({@code view.json -> groups}): the main widget collapses and expands its group. */
@DisplayName("Widget groups. Collapse and expand")
@Epic("Samples")
@Feature(WidgetGroupTest.ARTICLE)
@Tag("Samples")
@Tag("WidgetGroup")
public class WidgetGroupTest extends BaseTestForSamples {

	static final String ARTICLE = "widget/type/property/collapse";

	private static final String SCREEN = "Widget Collapse";

	private static final String GROUP_CHILD = "MyExample3022GroupChild";

	private static final String OUTSIDE = "MyExample3022Outside";

	@Test
	@Severity(CRITICAL)
	@Tag("Positive")
	@DisplayName("All widget types: the groups are expanded by default, the main widget collapses only its group")
	@Description("The view with all widget types in four groups: every group is expanded after the view is opened, "
			+ "the Header collapses the Form, Info, List and GroupingHierarchy and expands them back, the other groups stay as they are")
	void allWidgetTypes() {
		var view = PlatformApp.screen(SCREEN).secondLevelView("All widget types");
		var header = view.widgetGroup("MyExample3022Header");
		var stats = view.widgetGroup("MyExample4203StatBlocs");
		var charts = view.widgetGroup("MyExample3022RingProcessl");
		var additional = view.widgetGroup("MyExample3022AdditionalInfo");
		String[] headerGroup = {"MyExample3022Form", "MyExample3022Info", "MyExample3022List", "MyExample3022GroupingHierarchy"};

		header.checkCollapsed(collapsed -> assertThat(collapsed).isFalse());
		stats.checkCollapsed(collapsed -> assertThat(collapsed).isFalse());
		charts.checkCollapsed(collapsed -> assertThat(collapsed).isFalse());
		additional.checkCollapsed(collapsed -> assertThat(collapsed).isFalse());
		for (String widget : headerGroup) {
			header.checkWidgetShown(widget, shown -> assertThat(shown).isTrue());
		}
		DocShots.png($("main"), ARTICLE, "collapse.png", 1600, 1000);

		DocShots.gif(ARTICLE, "collapse.gif", 1600, 1000, DocShots.Frame.WITHOUT_SIDEBAR);
		header.collapse();
		for (String widget : headerGroup) {
			header.checkWidgetShown(widget, shown -> assertThat(shown).isFalse());
		}
		header.checkWidgetShown("MyExample3022Header", shown -> assertThat(shown).isTrue());
		stats.checkWidgetShown("MyExample3022Steps", shown -> assertThat(shown).isTrue());
		charts.checkWidgetShown("MyExample3022DashboardList", shown -> assertThat(shown).isTrue());
		stats.collapse();
		stats.checkWidgetShown("MyExample3022Steps", shown -> assertThat(shown).isFalse());
		header.expand();
		stats.expand();
		DocShots.stop();

		for (String widget : headerGroup) {
			header.checkWidgetShown(widget, shown -> assertThat(shown).isTrue());
		}
		stats.checkWidgetShown("MyExample3022Steps", shown -> assertThat(shown).isTrue());
	}

	@ParameterizedTest(name = "{0}")
	@CsvSource({
			"Header, MyExample3022Header, " + GROUP_CHILD,
			"Form, MyExample3022Form, " + GROUP_CHILD,
			"Info, MyExample3022Info, " + GROUP_CHILD,
			"List, MyExample3022List, " + GROUP_CHILD,
			"GroupingHierarchy, MyExample3022GroupingHierarchy, " + GROUP_CHILD,
			"AdditionalInfo, MyExample3022AdditionalInfo, MyExample3022AdditionalList",
			"AdditionalList, MyExample3022AdditionalList, MyExample3022AdditionalInfo",
			"StatsBlock, MyExample4203StatBlocs, " + GROUP_CHILD,
			"Steps, MyExample3022Steps, " + GROUP_CHILD,
			"DashboardList, MyExample3022DashboardList, " + GROUP_CHILD,
			"Funnel, MyExample3022Funnel, " + GROUP_CHILD,
			"RingProgress, MyExample3022RingProcessl, " + GROUP_CHILD,
			"Tree, MyExample3022Tree, " + GROUP_CHILD
	})
	@Severity(CRITICAL)
	@Tag("Positive")
	@DisplayName("Every widget type as the main widget: ")
	@Description("The group is expanded by default; the toggle of the main widget hides the other widget of the group and the content "
			+ "of the main widget, its title stays; the widget outside the group is shown all the time; the second click expands the group")
	void mainWidgetType(String tab, String mainWidget, String groupWidget) {
		var view = mainWidgetView(tab);
		var group = view.widgetGroup(mainWidget);

		group.checkCollapsed(collapsed -> assertThat(collapsed).isFalse())
				.checkWidgetShown(groupWidget, shown -> assertThat(shown).isTrue())
				.checkWidgetShown(OUTSIDE, shown -> assertThat(shown).isTrue());
		int expandedHeight = group.mainWidgetHeight();

		boolean picture = "Form".equals(tab);
		if (picture) {
			DocShots.gif(ARTICLE, "mainwidget.gif", 1600, 1000, DocShots.Frame.WITHOUT_SIDEBAR);
		}
		group.toggleClick()
				.checkCollapsed(collapsed -> assertThat(collapsed).isTrue())
				.checkWidgetShown(mainWidget, shown -> assertThat(shown).isTrue())
				.checkWidgetShown(groupWidget, shown -> assertThat(shown).isFalse())
				.checkWidgetShown(OUTSIDE, shown -> assertThat(shown).isTrue());
		if (!"Header".equals(tab)) {
			// the Header widget has the title only: nothing to hide in it
			assertThat(group.mainWidgetHeight()).isLessThan(expandedHeight);
		}

		group.toggleClick()
				.checkCollapsed(collapsed -> assertThat(collapsed).isFalse())
				.checkWidgetShown(groupWidget, shown -> assertThat(shown).isTrue())
				.checkWidgetShown(OUTSIDE, shown -> assertThat(shown).isTrue());
		if (picture) {
			DocShots.stop();
		}
		assertThat(group.mainWidgetHeight()).isEqualTo(expandedHeight);
	}

	@Test
	@Severity(CRITICAL)
	@Tag("Positive")
	@DisplayName("Main widget without title: the toggle is shown next to the empty title, the group collapses")
	@Description("The main widget has no title: the page does not fail, the toggle is shown on the empty title and collapses the group")
	void mainWidgetWithoutTitle() {
		var view = mainWidgetView("Without title");
		var group = view.widgetGroup("MyExample3022NoTitle");

		group.checkCollapsed(collapsed -> assertThat(collapsed).isFalse())
				.checkWidgetShown(GROUP_CHILD, shown -> assertThat(shown).isTrue());
		assertThat(group.toggle().text()).isEmpty();
		DocShots.png(group.element(), ARTICLE, "notitle.png", 1600, 1000);

		group.toggleClick()
				.checkCollapsed(collapsed -> assertThat(collapsed).isTrue())
				.checkWidgetShown(GROUP_CHILD, shown -> assertThat(shown).isFalse())
				.checkWidgetShown(OUTSIDE, shown -> assertThat(shown).isTrue());
		group.toggleClick()
				.checkWidgetShown(GROUP_CHILD, shown -> assertThat(shown).isTrue());
	}

	@Test
	@Severity(CRITICAL)
	@Tag("Positive")
	@DisplayName("collapsedCondition: the group with default true is collapsed after the view is opened")
	@Description("collapsedCondition.default = true collapses the group when the view is opened, false keeps it expanded; "
			+ "the collapsed group is expanded by the toggle")
	void collapsedCondition() {
		var view = PlatformApp.screen(SCREEN).secondLevelView("Collapse with collapsedCondition");
		var collapsedByDefault = view.widgetGroup("MyExample3022RingProcessl");
		var expandedByDefault = view.widgetGroup("MyExample3022List");

		collapsedByDefault.checkCollapsed(collapsed -> assertThat(collapsed).isTrue())
				.checkWidgetShown("MyExample3022Funnel", shown -> assertThat(shown).isFalse())
				.checkWidgetShown("MyExample3022DashboardList", shown -> assertThat(shown).isFalse());
		expandedByDefault.checkCollapsed(collapsed -> assertThat(collapsed).isFalse())
				.checkWidgetShown("MyExample3022Form", shown -> assertThat(shown).isTrue());
		DocShots.png($("main"), ARTICLE, "collapsedcondition.png", 1600, 1000);

		collapsedByDefault.toggleClick()
				.checkWidgetShown("MyExample3022Funnel", shown -> assertThat(shown).isTrue())
				.checkWidgetShown("MyExample3022DashboardList", shown -> assertThat(shown).isTrue());
	}

	private static PlatformView mainWidgetView(String tab) {
		PlatformScreen screen = PlatformApp.screen(SCREEN);
		screen.secondLevelView("Main widget");
		return screen.thirdLevelView(tab);
	}

}
