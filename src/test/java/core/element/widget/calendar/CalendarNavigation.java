package core.element.widget.calendar;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import core.expectation.ExpectationPattern;

import java.util.List;

import static com.codeborne.selenide.Selenide.$$;

/**
 * Selectors of the calendar widgets (CalendarList, CalendarYearList). An event is a row; an event spanning
 * several weeks is shown by several parts with the same row id.
 */
public final class CalendarNavigation {

	public static final String ROW_ID_ATTRIBUTE = "data-test-widget-list-row-id";

	public static final String ROWS_SELECTOR = "[data-test-widget-list-row-type=\"Row\"][" + ROW_ID_ATTRIBUTE + "]";

	public static final String PREV_BUTTON = "button[data-test-widget-calendar-prev]";

	public static final String NEXT_BUTTON = "button[data-test-widget-calendar-next]";

	public static final String TODAY_BUTTON = "button[data-test-widget-calendar-today]";

	public static final String MONTH_SCALE = "dayGridMonth";

	public static final String WEEK_SCALE = "timeGridWeek";

	public static final String DAY_SCALE = "timeGridDay";

	/** a filterable field above the calendar, the analogue of a column of the table header */
	public static final String FILTER_COLUMNS = "[data-test-widget-list-header-column-title]";

	/** the form widget of options.create or options.edit, shown in the create popup or in the edit popover */
	public static final String FORM = "div[data-test=\"WIDGET\"][data-test-widget-type=\"Form\"]";

	private CalendarNavigation() {
	}

	public static SelenideElement scaleButton(SelenideElement container, String scale) {
		return container.$("span[data-test-widget-calendar-view=\"" + scale + "\"]");
	}

	/** Visible parts of the events of the container. */
	public static ElementsCollection rows(SelenideElement container) {
		return container.$$(ROWS_SELECTOR).filter(Condition.visible);
	}

	/** Ids of the shown events in the order of the grid, every event once. */
	public static List<String> rowKeys(SelenideElement container) {
		return rows(container).asFixedIterable().stream()
				.map(row -> row.getAttribute(ROW_ID_ATTRIBUTE))
				.distinct()
				.toList();
	}

	/** The visible form of the event; a closed popover keeps its form in the page hidden. */
	public static SelenideElement form(String rowKey) {
		return $$(FORM + "[" + ROW_ID_ATTRIBUTE + "=\"" + rowKey + "\"]").findBy(Condition.visible);
	}

	/** The visible form of any event: an opened edit popover or the create popup. */
	public static SelenideElement openedForm() {
		return $$(FORM + "[" + ROW_ID_ATTRIBUTE + "]").findBy(Condition.visible);
	}

	/** Waits until the widget is shown and its data is not loading. */
	public static void waitLoaded(SelenideElement container, ExpectationPattern expectations) {
		expectations.getWaitAllElements(container);
		container.$(".ant-spin-spinning").shouldNot(Condition.exist, expectations.getTimeout());
		container.$("[data-test-loading]").shouldNot(Condition.exist, expectations.getTimeout());
	}

}
