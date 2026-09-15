package core.element.widget.calendar;

import core.common.Identifier;
import core.element.widget.type.PlatformTypeWidgets;
import core.element.widget.type.TypeWidget;

/**
 * CalendarYearList widget. A day of the year shows the number of its events ("2 events"), not the events,
 * so {@link #rows()} are not available.
 */
public class PlatformCalendarYearWidget extends CalendarWidget<PlatformCalendarYearWidget> {

	public PlatformCalendarYearWidget(Identifier identifier, String textIdentifier) {
		super(identifier, textIdentifier);
	}

	@Override
	public TypeWidget getType() {
		return PlatformTypeWidgets.CALENDAR_YEAR_LIST;
	}

	/** Not available: a day of the year shows the number of its events, not the events. */
	@Override
	public CalendarRows<PlatformCalendarYearWidget> rows() {
		throw new UnsupportedOperationException("A day of the year calendar shows the number of its events, not the events");
	}

}
