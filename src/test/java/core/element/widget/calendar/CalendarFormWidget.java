package core.element.widget.calendar;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import core.element.widget.PlatformIdentifier;
import core.element.widget.form.PlatformFormWidget;

/** The form of the opened edit popover of an event: the visible form widget of options.edit with the id of the event. */
public class CalendarFormWidget extends PlatformFormWidget {

	private final String rowKey;

	public CalendarFormWidget(String rowKey) {
		super(PlatformIdentifier.NONE, rowKey);
		this.rowKey = rowKey;
	}

	@Override
	public SelenideElement element() {
		return CalendarNavigation.form(rowKey).shouldBe(Condition.visible, getExpectations().getTimeout());
	}

}
