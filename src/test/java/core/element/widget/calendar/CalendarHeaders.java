package core.element.widget.calendar;

import com.codeborne.selenide.ElementsCollection;
import core.element.widget.list.ListHeaders;

/**
 * Filters of a calendar: the filterable fields above the grid instead of the columns of the table header,
 * so {@code headers().filter(fb -> ...)} and {@code clearFilters()} are written as for a List. No sorting.
 */
public class CalendarHeaders<W extends CalendarWidget<W>> extends ListHeaders<W, CalendarRows<W>, CalendarRow<W>> {

	public CalendarHeaders(W widget) {
		super(widget);
	}

	@Override
	public ElementsCollection element() {
		CalendarNavigation.waitLoaded(widget().element(), widget().getExpectations());
		return widget().element().$$(CalendarNavigation.FILTER_COLUMNS);
	}

}
