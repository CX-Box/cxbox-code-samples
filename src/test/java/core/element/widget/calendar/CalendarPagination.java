package core.element.widget.calendar;

import com.codeborne.selenide.Condition;
import core.element.widget.AbstractWidget;
import core.element.widget.list.Pagination;
import core.expectation.ExpectationPattern;

import java.util.function.Consumer;

/**
 * Periods of a calendar as pages: the arrows of the toolbar go to the next or the previous month, week, day
 * or year; the first page is "Today", the period the calendar is opened with.
 */
public class CalendarPagination<W extends AbstractWidget<ExpectationPattern, W>> implements Pagination<CalendarPagination<W>, W> {

	private final W widget;

	public CalendarPagination(W widget) {
		this.widget = widget;
	}

	/** Not applicable: a calendar has no number of periods. */
	@Override
	public CalendarPagination<W> checkPageCount(Consumer<Integer> pageCountChecker) {
		throw new UnsupportedOperationException("A calendar has no number of periods");
	}

	/** Goes to today, then the given number of periods forward. */
	@Override
	public CalendarPagination<W> pages(int number) {
		firstPage();
		for (int i = 0; i < number; i++) {
			nextPage();
		}
		return this;
	}

	/** "Today". */
	@Override
	public CalendarPagination<W> firstPage() {
		return click(CalendarNavigation.TODAY_BUTTON);
	}

	/** "Today", the same as {@link #firstPage()}. */
	public CalendarPagination<W> today() {
		return firstPage();
	}

	@Override
	public CalendarPagination<W> nextPage() {
		return click(CalendarNavigation.NEXT_BUTTON);
	}

	@Override
	public CalendarPagination<W> previousPage() {
		return click(CalendarNavigation.PREV_BUTTON);
	}

	@Override
	public boolean checkNextPage() {
		return !isLastPage();
	}

	/** A calendar has no last period. */
	@Override
	public boolean isLastPage() {
		return false;
	}

	@Override
	public W widget() {
		return widget;
	}

	private CalendarPagination<W> click(String button) {
		widget.element().$(button)
				.shouldBe(Condition.visible, widget.getExpectations().getTimeout())
				.click();
		CalendarNavigation.waitLoaded(widget.element(), widget.getExpectations());
		return this;
	}

}
