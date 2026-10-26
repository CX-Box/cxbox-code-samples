package core.element.widget.group;

import static com.codeborne.selenide.Selenide.$$;
import static core.util.i18n.CoreMessageSource.message;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import core.common.SingleElement;
import core.expectation.CxBoxExpectations;
import core.expectation.ExpectationPattern;
import core.util.report.StepReport;
import io.qameta.allure.Allure;
import java.util.function.Consumer;

/**
 * The group of widgets of the view ({@code view.json -> groups}). The first widget of the group is the main one: its title
 * has the toggle that collapses and expands the group. A collapsed group shows only the title of the main widget.
 */
public class WidgetGroup implements SingleElement {

	private final ExpectationPattern expectations = new CxBoxExpectations();

	private final String mainWidgetName;

	public WidgetGroup(String mainWidgetName) {
		this.mainWidgetName = mainWidgetName;
	}

	/** The main widget of the group: the first widget of {@code widgetNames} */
	@Override
	public SelenideElement element() {
		return widget(mainWidgetName).shouldBe(Condition.visible, expectations.getOverTimeout());
	}

	/** The toggle in the title of the main widget */
	public SelenideElement toggle() {
		return element().$("[data-test-widget-collapse]").shouldBe(Condition.visible, expectations.getTimeout());
	}

	public boolean isCollapsed() {
		return Allure.step(message("group.collapsed", mainWidgetName), () -> {
			var collapsed = Boolean.parseBoolean(toggle().getAttribute("data-test-widget-collapsed"));
			StepReport.value(collapsed);
			return collapsed;
		});
	}

	/** Passes the state of the group ({@link #isCollapsed()}) to the check */
	public WidgetGroup checkCollapsed(Consumer<Boolean> checkCollapsed) {
		checkCollapsed.accept(isCollapsed());
		return this;
	}

	/** Clicks the toggle of the main widget: a collapsed group is expanded, an expanded one is collapsed */
	public WidgetGroup toggleClick() {
		Allure.step(message("group.toggle", mainWidgetName), () -> {
			var collapsed = isCollapsed();
			toggle().click();
			toggle().shouldHave(Condition.attribute("data-test-widget-collapsed", String.valueOf(!collapsed)), expectations.getTimeout());
		});
		return this;
	}

	public WidgetGroup collapse() {
		if (!isCollapsed()) {
			toggleClick();
		}
		return this;
	}

	public WidgetGroup expand() {
		if (isCollapsed()) {
			toggleClick();
		}
		return this;
	}

	/**
	 * Whether the widget is shown on the view, without waiting for it: a widget of a collapsed group (except the main one)
	 * is not on the page
	 */
	public boolean isWidgetShown(String widgetName) {
		return Allure.step(message("group.widgetShown", widgetName), () -> {
			var shown = widget(widgetName).is(Condition.visible);
			StepReport.value(shown);
			return shown;
		});
	}

	/** Passes the visibility of the widget ({@link #isWidgetShown(String)}) to the check */
	public WidgetGroup checkWidgetShown(String widgetName, Consumer<Boolean> checkShown) {
		checkShown.accept(isWidgetShown(widgetName));
		return this;
	}

	/** The height of the main widget: the content of a collapsed main widget is hidden, only its title stays */
	public int mainWidgetHeight() {
		return element().getSize().getHeight();
	}

	private static SelenideElement widget(String name) {
		return $$("div[data-test='WIDGET'][data-test-widget-name='" + name + "']").findBy(Condition.visible);
	}

}
