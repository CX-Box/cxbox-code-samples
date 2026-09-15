package core.element.widget.calendar;

import com.codeborne.selenide.ClickOptions;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import core.element.widget.form.PlatformFormWidget;
import core.element.widget.list.rows.row.RowInline;

import java.time.Duration;

/**
 * An event of the calendar. A click on its title is the drilldown of the title field
 * ({@code row.input("Title").drilldown(...)}), a click on the rest of the event opens the edit popover.
 */
public class CalendarRow<W extends CalendarWidget<W>> extends RowInline<CalendarRow<W>, CalendarRows<W>, W> {

	public CalendarRow(CalendarRows<W> parent, int pageIndex, String rowKey) {
		super(parent, pageIndex, rowKey);
	}

	/** Clicks the event like {@code row.click()} of a List: selects the record, or opens the edit popover when options.edit is set. */
	public CalendarRow<W> click() {
		SelenideElement event = element().shouldBe(Condition.visible, widget().getExpectations().getTimeout());
		event.click(ClickOptions.usingDefaultMethod().offset(event.getSize().getWidth() / 2 - 2, 0));
		CalendarNavigation.waitLoaded(widget().element(), widget().getExpectations());
		return this;
	}

	/** Opens the edit popover of the event, the same as {@link #clickPencil()}. */
	@Override
	public CalendarRow<W> editRow() {
		clickPencil();
		return this;
	}

	/**
	 * Opens the edit popover of the event and returns its form (options.edit.widget); an opened popover is not
	 * clicked again. The event is clicked at its right edge, away from the title link.
	 */
	public PlatformFormWidget clickPencil() {
		Duration timeout = widget().getExpectations().getTimeout();
		// the first click on an event only closes the popover of another event, the second one opens this popover
		for (int click = 0; click < 2 && !CalendarNavigation.form(getRowKey()).is(Condition.visible); click++) {
			SelenideElement event = element().shouldBe(Condition.visible, timeout);
			event.click(ClickOptions.usingDefaultMethod().offset(event.getSize().getWidth() / 2 - 2, 0));
			try {
				CalendarNavigation.form(getRowKey()).shouldBe(Condition.visible, timeout);
			} catch (AssertionError e) {
				// clicked again below
			}
		}
		CalendarNavigation.form(getRowKey()).shouldBe(Condition.visible, timeout);
		return new CalendarFormWidget(getRowKey());
	}

	/** The title field of the event (options.calendar.valueFieldKey), found by its title like on other widgets. */
	@Override
	public CalendarInput<W> input(String title) {
		return new CalendarInput<>(title, widget(), self());
	}

}
