package core.element.widget.action;

import io.qameta.allure.Allure;
import static core.util.i18n.CoreMessageSource.message;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import core.common.SingleElement;
import core.element.widget.list.ListWidget;
import core.element.widget.list.rows.PlatformRows;
import core.element.widget.list.rows.row.PlatformRow;

public class BurgerAction<ROW extends PlatformRow<ROW, ROWS, WIDGET>, ROWS extends PlatformRows<ROWS, WIDGET, ROW>, WIDGET extends ListWidget<WIDGET, ROWS, ROW>> implements SingleElement {

	private final String label;
	private final WIDGET widget;
	private final ROW row;
	private SelenideElement burger;

	public BurgerAction(ROW row, WIDGET widget, String label) {
		this.row = row;
		this.widget = widget;
		this.label = label;
		this.burger = getBurger();
	}

	/** For a row that shows its actions as buttons, not in a burger menu: {@code action} is the button of the action. */
	protected BurgerAction(ROW row, WIDGET widget, String label, SelenideElement action) {
		this.row = row;
		this.widget = widget;
		this.label = label;
		this.burger = action;
	}

	/** Whether the menu of the row has the item */
	public boolean exists() {
		return Allure.step(message("row.menuItem", label), () -> element() != null);
	}

	@Override
	public SelenideElement element() {
		if (burger == null) {
			burger = getBurger();
		}
		return burger;
	}

	private SelenideElement getBurger() {
		row.element()
				.shouldBe(Condition.visible, widget.getExpectations().getTimeout())
				.hover();
		row.element()
				.shouldBe(Condition.visible, widget.getExpectations().getTimeout())
				.hover();
		// each list has its own button and menu of the row, the first ones of the page can belong to another list
		widget.element().$("button[data-test-widget-list-row-action=\"true\"]")
				.shouldBe(Condition.exist, widget.getExpectations().getTimeout())
				.hover()
				.shouldBe(Condition.visible, widget.getExpectations().getTimeout())
				.click();
		return widget.element()
				.$$("ul[class=\"ant-dropdown-menu ant-dropdown-menu-light ant-dropdown-menu-root ant-dropdown-menu-vertical\"]")
				.findBy(Condition.visible)
				.shouldBe(Condition.visible, widget.getExpectations().getTimeout())
				.$$("li[data-test-widget-list-row-action-item=\"true\"]")
				.shouldHave(CollectionCondition.sizeGreaterThan(0), widget.getExpectations().getTimeout())
				.stream()
				.filter(se -> se.getText().equals(label))
				.findFirst()
				.map(se -> se.scrollIntoView("{block: \"center\"}")).orElse(null);
	}

	public ROW click() {
		return Allure.step(message("row.menu", label), () -> {
			PageRequests.track();
			element().click();
			waitOperationFinished();
			return row;
		});
	}

	/**
	 * The row operation is finished when its requests are done and rendered (a popup widget has no loading spinner) and
	 * the widget has no loading spinner. A widget that is gone after the operation (a drilldown, a closed popup) has nothing to wait for.
	 * The requests wait is temporary until the popup widgets show the loading spinner ({@link PageRequests}).
	 */
	private void waitOperationFinished() {
		PageRequests.waitDone(widget.getExpectations().getOverTimeout());
		Selenide.Wait().withTimeout(widget.getExpectations().getOverTimeout()).until(driver -> {
			try {
				// the widget that is gone is not looked for: the look up waits for it the whole timeout
				return !widget.isOnPage() || !widget.element().$(".ant-spin-spinning").exists();
			} catch (RuntimeException | AssertionError e) {
				return true;
			}
		});
	}
}
