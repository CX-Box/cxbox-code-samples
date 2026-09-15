package application.Samples.Calendar;

import application.config.BaseTestForSamples;
import application.config.props.Env;
import com.codeborne.selenide.Selenide;
import core.element.PlatformApp;
import core.element.screen.view.PlatformView;
import core.element.widget.calendar.CalendarWidget;
import core.util.DocShots;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.util.List;

import static io.qameta.allure.SeverityLevel.CRITICAL;
import static io.qameta.allure.SeverityLevel.NORMAL;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * Basics of the CalendarList widget (samples widgets/calendarlist): title, title color, show condition, events of
 * the shown period, periods as pages, views, filtration. The test data has three events in the current month.
 */
@DisplayName("Calendar. Basics: title, color, show condition, events, periods, views, filtration")
@Epic("Samples")
@Feature(CalendarBasicsTest.ARTICLE)
@Tag("Samples")
public class CalendarBasicsTest extends BaseTestForSamples {

	static final String ARTICLE = "widget/type/calendarlist";

	private static final String FIELD = "Custom Field";

	private static final List<String> EVENTS = List.of("Meeting 1", "Meeting 2", "Conference");

	private static PlatformView open(String screen, String view) {
		Selenide.open(Env.uri() + "screen/" + screen + "/view/" + view);
		Selenide.sleep(2500);
		return PlatformApp.currentScreen().view();
	}

	private static <W extends CalendarWidget<W>> List<String> titles(W calendar) {
		return calendar.rows().streamCurrentPage().map(row -> row.input(FIELD).getValue()).toList();
	}

	@Test
	@Severity(CRITICAL)
	@Tag("Positive")
	@DisplayName("Constant title, the events of the current month")
	@Description("The widget is found by its title; the events of the month are the rows in the order of the grid.")
	void constantTitle() {
		var calendar = open("myexample5055", "myexample5055list").calendar("Constant Title");
		calendar.waitLoaded();
		DocShots.png(calendar.element(), ARTICLE, "calendar.png", 1600, 1000);
		DocShots.png(calendar.element(), ARTICLE, "consttitle.png", 1600, 1000);
		assertThat(titles(calendar)).containsExactlyElementsOf(EVENTS);
	}

	@Test
	@Severity(NORMAL)
	@Tag("Positive")
	@DisplayName("Empty title")
	@Description("A widget without a title is found by its name.")
	void emptyTitle() {
		var calendar = open("myexample5055", "myexample5055emptytitle").calendarByName("MyExample5055EmptyTitle");
		calendar.waitLoaded();
		DocShots.png(calendar.element(), ARTICLE, "empytitle.png", 1600, 1000);
		assertThat(titles(calendar)).containsExactlyElementsOf(EVENTS);
	}

	@Test
	@Severity(NORMAL)
	@Tag("Positive")
	@DisplayName("Title color")
	@Description("bgColorKey of the title field colors the title and the events.")
	void titleColor() {
		var calendar = open("myexample5056", "myexample5056list").calendarByName("MyExample5056");
		calendar.waitLoaded();
		DocShots.png(calendar.element(), ARTICLE, "colorwidget.png", 1600, 1000);
		assertThat(titles(calendar)).containsExactlyElementsOf(EVENTS);
	}

	@Test
	@Severity(NORMAL)
	@Tag("Positive")
	@DisplayName("Show condition by current entity")
	@Description("A click on an event selects its record; the widget with the show condition by the selected record is shown.")
	void showConditionByCurrentEntity() {
		var view = open("myexample5057", "myexample5057showcond");
		var calendar = view.calendarByName("MyExample5057");
		calendar.waitLoaded();
		DocShots.gif(ARTICLE, "show_cond_current.gif", 1660, 1000, DocShots.Frame.WITHOUT_SIDEBAR);
		calendar.rows().row(1).click();
		var shown = view.calendarByName("MyExample5057ShowCond").waitLoaded();
		DocShots.stop();
		assertThat(titles(shown)).containsExactlyElementsOf(EVENTS);
	}

	@Test
	@Severity(CRITICAL)
	@Tag("Positive")
	@DisplayName("Periods are the pages of the calendar")
	@Description("The arrows go to the next and the previous month, Today (the first page) returns to the current month.")
	void periods() {
		var calendar = open("myexample5055", "myexample5055list").calendar("Constant Title");
		DocShots.gif(ARTICLE, "calendar_pagination.gif", 1660, 1000, DocShots.Frame.WITHOUT_SIDEBAR);
		calendar.pagination().nextPage();
		assertThat(titles(calendar)).isEmpty();
		calendar.pagination().previousPage();
		assertThat(titles(calendar)).containsExactlyElementsOf(EVENTS);
		calendar.pagination().nextPage().nextPage().today();
		DocShots.stop();
		assertThat(titles(calendar)).containsExactlyElementsOf(EVENTS);
		calendar.pagination().pages(1);
		assertThat(titles(calendar)).isEmpty();
		calendar.pagination().firstPage();
		assertThat(titles(calendar)).containsExactlyElementsOf(EVENTS);
	}

	@Test
	@Severity(NORMAL)
	@Tag("Positive")
	@DisplayName("Views: month, week, day")
	@Description("Every view is a widget of its own; the month view shows the events of the month again after the week and the day views.")
	void views() {
		var month = open("myexample5055", "myexample5055list").calendar("Constant Title");
		DocShots.gif(ARTICLE, "calendar_views.gif", 1660, 1000, DocShots.Frame.WITHOUT_SIDEBAR);
		var week = month.weekWidget();
		assertThat(titles(week)).isSubsetOf(EVENTS);
		var day = week.dayWidget();
		assertThat(titles(day)).isSubsetOf(EVENTS);
		month = day.monthWidget();
		DocShots.stop();
		assertThat(titles(month)).containsExactlyElementsOf(EVENTS);
	}

	@Test
	@Severity(NORMAL)
	@Tag("Positive")
	@DisplayName("Filtration by the fields above the calendar")
	@Description("The filter of a field above the calendar is applied like the filter of a column of a List.")
	void filtration() {
		var calendar = open("myexample5055", "myexample5055list").calendar("Constant Title");
		calendar.waitLoaded();
		DocShots.gif(ARTICLE, "calendar_filtration.gif", 1660, 1000, DocShots.Frame.WITHOUT_SIDEBAR);
		calendar.headers().filter(fb -> fb.input(FIELD, "Meeting"));
		assertThat(titles(calendar)).containsExactly("Meeting 1", "Meeting 2");
		DocShots.stop();
		calendar.headers().clearFilters();
		assertThat(titles(calendar)).containsExactlyElementsOf(EVENTS);
	}

}
