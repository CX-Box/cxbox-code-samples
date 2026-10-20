package core.element.widget.action;

import io.qameta.allure.Allure;
import static com.codeborne.selenide.Selenide.$;
import static core.util.i18n.CoreMessageSource.message;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
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

	private static final String BUTTON = "button[data-test-widget-list-row-action=\"true\"]";

	private static final String OPEN_MENU = "div.ant-dropdown:not(.ant-dropdown-hidden)";

	public BurgerAction(ROW row, WIDGET widget, String label) {
		this.row = row;
		this.widget = widget;
		this.label = label;
	}

	/** For a row that shows its actions as buttons, not in a burger menu: {@code action} is the button of the action. */
	protected BurgerAction(ROW row, WIDGET widget, String label, SelenideElement action) {
		this.row = row;
		this.widget = widget;
		this.label = label;
		this.burger = action;
	}

	/** Whether the menu of the row has the item; the menu is closed after the look, an empty menu has none */
	public boolean exists() {
		return Allure.step(message("row.menuItem", label), () -> {
			var found = openMenu().texts().contains(label);
			menuButton().click();
			$(OPEN_MENU).shouldNot(Condition.exist, widget.getExpectations().getTimeout());
			return found;
		});
	}

	@Override
	public SelenideElement element() {
		if (burger == null) {
			burger = openMenu().findBy(Condition.exactText(label)).shouldBe(Condition.visible, widget.getExpectations().getTimeout())
					.scrollIntoView("{block: \"center\"}");
		}
		return burger;
	}

	/** The items of the open menu of the row: by the test attribute, the menu can be an ant-dropdown-menu or an ant-menu */
	private ElementsCollection openMenu() {
		row.element().shouldBe(Condition.visible, widget.getExpectations().getTimeout()).hover();
		// the mouse stays on the row: a notice of the application can cover the button and stays open while hovered
		menuButton().shouldBe(Condition.visible, widget.getExpectations().getTimeout()).click();
		var menu = openMenuElement().shouldBe(Condition.visible, widget.getExpectations().getTimeout());
		// the menu loads the meta of the row first: its items come after the skeleton
		menu.$("[data-test-loading]").shouldNot(Condition.exist, widget.getExpectations().getTimeout());
		return menu.$$("li[data-test-widget-list-row-action-item=\"true\"]");
	}

	/** The open menu: the box draws it in the list, a project can draw it in the page, as antd does by default */
	private SelenideElement openMenuElement() {
		var inList = widget.element().$(OPEN_MENU);
		return inList.exists() ? inList : $(OPEN_MENU);
	}

	/** The button of the row, or the one button of the list shown on the hover of a row */
	private SelenideElement menuButton() {
		var inRow = row.element().$(BUTTON);
		return inRow.exists() ? inRow : widget.element().$(BUTTON);
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
