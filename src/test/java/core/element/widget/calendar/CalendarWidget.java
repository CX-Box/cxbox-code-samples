package core.element.widget.calendar;

import core.common.Identifier;
import core.element.widget.list.ListWidget;
import core.element.widget.type.PlatformTypeWidgets;
import core.element.widget.type.TypeWidget;

/**
 * Calendar widget: a List-like widget whose {@link #rows()} are the events of the shown period.
 * The create form (options.create.widget) is a form widget of the view: {@code view.formByName(...)};
 * the edit form (options.edit.widget) is opened by {@link CalendarRow#clickPencil()}.
 */
public abstract class CalendarWidget<SELF extends CalendarWidget<SELF>> extends ListWidget<SELF, CalendarRows<SELF>, CalendarRow<SELF>> {

	private final String textIdentifier;

	protected CalendarWidget(Identifier identifier, String textIdentifier) {
		super(identifier, textIdentifier);
		this.textIdentifier = textIdentifier;
	}

	@Override
	public TypeWidget getType() {
		return PlatformTypeWidgets.CALENDAR_LIST;
	}

	/** Events of the shown period in the order of the grid. */
	@Override
	public CalendarRows<SELF> rows() {
		return new CalendarRows<>(self());
	}

	/** Filters above the calendar, written as for the table header of a List. */
	@Override
	public CalendarHeaders<SELF> headers() {
		return new CalendarHeaders<>(self());
	}

	/** Periods of the calendar: the arrows of the toolbar and "Today". */
	@Override
	public CalendarPagination<SELF> pagination() {
		return new CalendarPagination<>(self());
	}

	public SELF waitLoaded() {
		CalendarNavigation.waitLoaded(element(), getExpectations());
		return self();
	}

	protected String textIdentifier() {
		return textIdentifier;
	}

}
