package core.element.widget.list;

import com.codeborne.selenide.ClickOptions;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import core.element.widget.AbstractWidget;
import core.expectation.ExpectationPattern;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

/**
 * The gear menu of a widget: column settings, limit list, search mode of a tree, etc.
 */
public class WidgetSettings<W extends AbstractWidget<ExpectationPattern, W>> {

	private final W widget;

	private final SelenideElement container;

	private final ExpectationPattern expectations;

	public WidgetSettings(W widget) {
		this(widget, widget.element(), widget.getExpectations());
	}

	/** Menu of a container that is not a widget of the view, e.g. a popup. */
	public WidgetSettings(W widget, SelenideElement container, ExpectationPattern expectations) {
		this.widget = widget;
		this.container = container;
		this.expectations = expectations;
	}

	/** Opens the menu and returns its element. */
	public SelenideElement open() {
		SelenideElement menu = menu();
		if (!menu.exists()) {
			container.$("i[aria-label=\"icon: setting\"]")
					.shouldBe(Condition.visible, expectations.getTimeout())
					.click(ClickOptions.usingJavaScript());
		}
		return menu().shouldBe(Condition.visible, expectations.getTimeout());
	}

	/** Chooses an item of the menu, e.g. {@code select("Hide")} or {@code select("10 / page")}. */
	public W select(String item) {
		open().$$("li").findBy(text(item))
				.shouldBe(Condition.visible, expectations.getTimeout())
				.click();
		expectations.getWaitAllElements(container);
		return widget;
	}

	public W close() {
		if (menu().exists()) {
			container.$("i[aria-label=\"icon: setting\"]").click(ClickOptions.usingJavaScript());
		}
		return widget;
	}

	private SelenideElement menu() {
		return $(".ant-dropdown:not(.ant-dropdown-hidden) ul.ant-dropdown-menu");
	}

}
