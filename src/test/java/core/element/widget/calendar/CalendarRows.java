package core.element.widget.calendar;

import com.codeborne.selenide.ElementsCollection;
import core.element.widget.list.rows.RowsInline;
import core.element.widget.list.rows.stream.StreamWithPagination;

import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/** Events of the shown period in the order of the grid; an event spanning several weeks is one row. */
public class CalendarRows<W extends CalendarWidget<W>> extends RowsInline<CalendarRows<W>, W, CalendarRow<W>> {

	public CalendarRows(W widget) {
		super(widget);
	}

	/** Visible parts of the events; an event spanning several weeks has several parts. */
	@Override
	public ElementsCollection element() {
		CalendarNavigation.waitLoaded(widget().element(), widget().getExpectations());
		return CalendarNavigation.rows(widget().element());
	}

	@Override
	public CalendarRow<W> row(int number) {
		return new CalendarRow<>(this, number, keys().get(number));
	}

	/** Clicks the event: the edit popover is opened. */
	@Override
	public CalendarRow<W> clickRow(int number) {
		return row(number).editRow();
	}

	/** Events of the shown period (month, week or day). */
	@Override
	public Stream<CalendarRow<W>> streamCurrentPage() {
		List<String> keys = keys();
		return IntStream.range(0, keys.size()).mapToObj(i -> new CalendarRow<>(this, i, keys.get(i)));
	}

	/** Not applicable: a calendar has no last period, use {@link #streamCurrentPage()}. */
	@Override
	public StreamWithPagination<CalendarRow<W>> streamAllPages() {
		throw new UnsupportedOperationException("A calendar has no last period: use streamCurrentPage() of the shown period");
	}

	private List<String> keys() {
		CalendarNavigation.waitLoaded(widget().element(), widget().getExpectations());
		return CalendarNavigation.rowKeys(widget().element());
	}

}
