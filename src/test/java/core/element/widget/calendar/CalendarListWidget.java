package core.element.widget.calendar;

import com.codeborne.selenide.Condition;
import core.common.Identifier;

import java.util.function.BiFunction;

/**
 * CalendarList widget switched by the buttons "Month", "Week", "Day". The month, the week and the day are widgets of their own:
 * they work with different units (a month of days, a week or a day of hours).
 */
public abstract class CalendarListWidget<SELF extends CalendarListWidget<SELF>> extends CalendarWidget<SELF> {

	protected CalendarListWidget(Identifier identifier, String textIdentifier) {
		super(identifier, textIdentifier);
	}

	/** Button "Month" of the toolbar. */
	public PlatformCalendarMonthWidget monthWidget() {
		return switchTo(CalendarNavigation.MONTH, PlatformCalendarMonthWidget::new);
	}

	/** Button "Week" of the toolbar. */
	public PlatformCalendarWeekWidget weekWidget() {
		return switchTo(CalendarNavigation.WEEK, PlatformCalendarWeekWidget::new);
	}

	/** Button "Day" of the toolbar. */
	public PlatformCalendarDayWidget dayWidget() {
		return switchTo(CalendarNavigation.DAY, PlatformCalendarDayWidget::new);
	}

	private <W extends CalendarListWidget<W>> W switchTo(String value, BiFunction<Identifier, String, W> widget) {
		CalendarNavigation.monthWeekDayButton(element(), value)
				.shouldBe(Condition.visible, getExpectations().getTimeout())
				.click();
		CalendarNavigation.waitLoaded(element(), getExpectations());
		return widget.apply(getIdentifier(), textIdentifier());
	}

}
