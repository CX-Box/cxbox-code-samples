package core.element.widget.calendar;

import com.codeborne.selenide.Condition;
import core.common.Identifier;

import java.util.function.BiFunction;

/**
 * CalendarList widget switched between its scales (the buttons "Month", "Week", "Day"). Every scale is a widget of its own:
 * the scales work with different units (a month of days, a week or a day of hours).
 */
public abstract class CalendarScaleWidget<SELF extends CalendarScaleWidget<SELF>> extends CalendarWidget<SELF> {

	protected CalendarScaleWidget(Identifier identifier, String textIdentifier) {
		super(identifier, textIdentifier);
	}

	/** Button "Month" of the toolbar. */
	public PlatformCalendarMonthWidget monthWidget() {
		return switchTo(CalendarNavigation.MONTH_SCALE, PlatformCalendarMonthWidget::new);
	}

	/** Button "Week" of the toolbar. */
	public PlatformCalendarWeekWidget weekWidget() {
		return switchTo(CalendarNavigation.WEEK_SCALE, PlatformCalendarWeekWidget::new);
	}

	/** Button "Day" of the toolbar. */
	public PlatformCalendarDayWidget dayWidget() {
		return switchTo(CalendarNavigation.DAY_SCALE, PlatformCalendarDayWidget::new);
	}

	private <W extends CalendarScaleWidget<W>> W switchTo(String scale, BiFunction<Identifier, String, W> widget) {
		CalendarNavigation.scaleButton(element(), scale)
				.shouldBe(Condition.visible, getExpectations().getTimeout())
				.click();
		CalendarNavigation.waitLoaded(element(), getExpectations());
		return widget.apply(getIdentifier(), textIdentifier());
	}

}
