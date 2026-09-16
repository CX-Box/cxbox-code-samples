package core.element.widget.action;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import core.common.SingleElement;
import core.element.widget.AbstractWidget;
import core.expectation.ExpectationPattern;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.$$;

/** An item of the "..." menu shown on a form, e.g. in the edit popover of a calendar event. */
public class FormBurgerAction<W extends AbstractWidget<ExpectationPattern, W>> implements SingleElement {

	private static final String BUTTON = "button[data-test-widget-list-row-action=\"true\"]";

	private static final String ITEM = "li[data-test-widget-list-row-action-item=\"true\"]";

	private final W widget;

	private final String label;

	public FormBurgerAction(W widget, String label) {
		this.widget = widget;
		this.label = label;
	}

	/** Opens the menu of the form if needed and returns the item. */
	@Override
	public SelenideElement element() {
		Duration timeout = widget.getExpectations().getTimeout();
		SelenideElement item = $$(ITEM).filter(Condition.visible).findBy(Condition.exactText(label));
		if (!item.is(Condition.visible)) {
			widget.element().$(BUTTON).shouldBe(Condition.visible, timeout).click();
		}
		return item.shouldBe(Condition.visible, timeout);
	}

	public W click() {
		element().click();
		return widget;
	}

}
