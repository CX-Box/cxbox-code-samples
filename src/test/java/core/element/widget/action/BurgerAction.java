package core.element.widget.action;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import core.common.SingleElement;
import core.element.widget.list.ListWidget;
import core.element.widget.list.rows.PlatformRows;
import core.element.widget.list.rows.row.PlatformRow;
import org.openqa.selenium.By;

import java.util.stream.Collectors;

import static com.codeborne.selenide.Selenide.$;

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
		$("button[data-test-widget-list-row-action=\"true\"]")
				.shouldBe(Condition.exist, widget.getExpectations().getTimeout())
				.hover()
				.shouldBe(Condition.visible, widget.getExpectations().getTimeout())
				.click();
		String collect = $("ul[class=\"ant-dropdown-menu ant-dropdown-menu-light ant-dropdown-menu-root ant-dropdown-menu-vertical\"]")
				.shouldBe(Condition.enabled, widget.getExpectations().getTimeout())
				.shouldBe(Condition.visible, widget.getExpectations().getTimeout())
				.$$("li[data-test-widget-list-row-action-item=\"true\"]").stream().map(se -> se.getText()).collect(Collectors.joining(","));
		return $("ul[class=\"ant-dropdown-menu ant-dropdown-menu-light ant-dropdown-menu-root ant-dropdown-menu-vertical\"]")
				.shouldBe(Condition.enabled, widget.getExpectations().getTimeout())
				.$$("li[data-test-widget-list-row-action-item=\"true\"]")
				.stream()
				.filter(se -> se.getText().equals(label))
				.findFirst()
				.map(se -> se.scrollIntoView("{block: \"center\"}")).orElse(null);
	}

	public ROW click() {
		if (Selenide.$(By.cssSelector("div[data-test-error-popup=\"true\"]")).exists()) {
			return row;
		}
		element().click();
		return row;
	}
}
