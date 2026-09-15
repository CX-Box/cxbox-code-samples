package core.element.widget.calendar;

import com.codeborne.selenide.Condition;
import core.common.Identifier;

import java.util.function.BiFunction;

/**
 * CalendarList widget switched between its views. Every view is a widget of its own: the views work with
 * different units (a month of days, a week or a day of hours).
 */
public abstract class CalendarViewWidget<SELF extends CalendarViewWidget<SELF>> extends CalendarWidget<SELF> {

	protected CalendarViewWidget(Identifier identifier, String textIdentifier) {
		super(identifier, textIdentifier);
	}

	/** Button "Month" of the toolbar. */
	public PlatformCalendarMonthWidget monthWidget() {
		return switchTo(CalendarNavigation.MONTH_VIEW, PlatformCalendarMonthWidget::new);
	}

	/** Button "Week" of the toolbar. */
	public PlatformCalendarWeekWidget weekWidget() {
		return switchTo(CalendarNavigation.WEEK_VIEW, PlatformCalendarWeekWidget::new);
	}

	/** Button "Day" of the toolbar. */
	public PlatformCalendarDayWidget dayWidget() {
		return switchTo(CalendarNavigation.DAY_VIEW, PlatformCalendarDayWidget::new);
	}

	private <W extends CalendarViewWidget<W>> W switchTo(String view, BiFunction<Identifier, String, W> widget) {
		CalendarNavigation.viewButton(element(), view)
				.shouldBe(Condition.visible, getExpectations().getTimeout())
				.click();
		CalendarNavigation.waitLoaded(element(), getExpectations());
		return widget.apply(getIdentifier(), textIdentifier());
	}

}
