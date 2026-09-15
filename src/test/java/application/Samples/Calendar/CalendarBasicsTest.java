package application.Samples.Calendar;

import application.config.BaseTestForSamples;
import core.element.PlatformApp;
import core.element.widget.calendar.CalendarWidget;
import core.element.widget.calendar.PlatformCalendarMonthWidget;
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
 * Basics of the CalendarList widget (samples widgets/calendarlist): events of the shown period, event color, show
 * condition, periods as pages, views, filtration. The test data has three events in the current month.
 */
@DisplayName("Calendar. Basics: events, color, show condition, periods, views, filtration")
@Epic("Samples")
@Feature(CalendarBasicsTest.ARTICLE)
@Tag("Samples")
public class CalendarBasicsTest extends BaseTestForSamples {

	static final String ARTICLE = "widget/type/calendarlist";

	private static final String FIELD = "Custom Field";

	private static final List<String> EVENTS = List.of("Meeting 1", "Meeting 2", "Conference");

	/** The events sample opened by the menu. */
	private static PlatformCalendarMonthWidget events() {
		return PlatformApp.screen("CalendarList widget events")
				.secondLevelView("Events")
				.checkUrl(url -> assertThat(url).contains("#/screen/myexample5055/view/myexample5055list"))
				.calendarByName("MyExample5055List");
	}

	private static <W extends CalendarWidget<W>> List<String> titles(W calendar) {
		return calendar.rows().streamCurrentPage().map(row -> row.input(FIELD).getValue()).toList();
	}

	@Test
	@Severity(CRITICAL)
	@Tag("Positive")
	@DisplayName("Events of the current month")
	@Description("The events of the month are the rows in the order of the grid.")
	void events_ofCurrentMonth() {
		var calendar = events();
		calendar.waitLoaded();
		DocShots.png(calendar.element(), ARTICLE, "calendar.png", 1600, 1000);
		assertThat(titles(calendar)).containsExactlyElementsOf(EVENTS);
	}

	@Test
	@Severity(NORMAL)
	@Tag("Positive")
	@DisplayName("Event color")
	@Description("bgColorKey of the title field colors the events.")
	void eventColor() {
		var calendar = PlatformApp.screen("CalendarList widget color")
				.secondLevelView("Color")
				.checkUrl(url -> assertThat(url).contains("#/screen/myexample5056/view/myexample5056list"))
				.calendarByName("MyExample5056");
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
		var view = PlatformApp.screen("CalendarList widget show condition")
				.secondLevelView("Show condition by current entity")
				.checkUrl(url -> assertThat(url).contains("#/screen/myexample5057/view/myexample5057showcond"));
		var calendar = view.calendarByName("MyExample5057");
		calendar.waitLoaded();
		DocShots.gif(ARTICLE, "show_cond_current.gif", 1660, 1400, DocShots.Frame.WITHOUT_SIDEBAR);
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
		var calendar = events();
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
		var month = events();
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
		var calendar = events();
		calendar.waitLoaded();
		DocShots.gif(ARTICLE, "calendar_filtration.gif", 1660, 1000, DocShots.Frame.WITHOUT_SIDEBAR);
		calendar.headers().filter(fb -> fb.input(FIELD, "Meeting"));
		assertThat(titles(calendar)).containsExactly("Meeting 1", "Meeting 2");
		DocShots.stop();
		calendar.headers().clearFilters();
		assertThat(titles(calendar)).containsExactlyElementsOf(EVENTS);
	}

}
