package core.element.widget;

import static core.util.i18n.CoreMessageSource.message;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import core.common.SingleElement;
import core.element.screen.view.PlatformView;
import core.element.widget.field.AbstractField;
import core.element.widget.type.TypeWidget;
import core.expectation.ExpectationPattern;
import io.qameta.allure.Allure;
import lombok.Getter;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.function.Function;

import static com.codeborne.selenide.Selenide.$;

@Getter
public abstract class AbstractWidget<EP extends ExpectationPattern, SELF extends AbstractWidget<EP, SELF>> implements SingleElement {

	protected final EP expectations;

	public AbstractWidget(EP expectations) {
		this.expectations = expectations;
	}

	public abstract TypeWidget getType();

	/**
	 * The widget in the technical lines of the report: the type of the widget by default
	 */
	public String describe() {
		return getType().getType();
	}

	/**
	 * Whether the widget is on the page now, without waiting for it. An operation can take the page away from the widget
	 * (a drilldown, a closed popup), and then there is nothing to wait for on the widget. True by default: a widget that
	 * cannot tell is waited for as before.
	 */
	public boolean isOnPage() {
		return true;
	}

	protected SelenideElement getWidgetElementByTitle(TypeWidget type, String title) {
		return loaded(widgetByTitle(type, title));
	}

	protected SelenideElement getWidgetElementByName(TypeWidget type, String name) {
		return loaded(widgetByName(type, name));
	}

	/**
	 * The widget is shown and its data came: no skeleton and no loading spinner in it. The text of the widget is not read:
	 * reading it takes long on a big table, and a widget can have no text at all (a button with an icon only, no title).
	 */
	private SelenideElement loaded(SelenideElement widget) {
		widget.shouldBe(Condition.visible, expectations.getOverTimeout())
				.$(".ant-skeleton, .ant-spin-spinning").shouldNot(Condition.exist, expectations.getOverTimeout());
		return widget;
	}

	/** The widget without waiting for it: a widget hidden by its showCondition is not on the page. */
	protected static SelenideElement widgetByTitle(TypeWidget type, String title) {
		return $("div[data-test='WIDGET'][data-test-widget-type='" + type.getType() + "'][data-test-widget-title='" + title
				+ "']");
	}

	protected static SelenideElement widgetByName(TypeWidget type, String name) {
		return $("div[data-test='WIDGET'][data-test-widget-type='" + type.getType() + "'][data-test-widget-name='" + name
				+ "']");
	}


	public SELF widget() {
		return (SELF) this;
	}

	public PlatformView view() {
		return new PlatformView();
	}

	public <FT, F extends AbstractField<EP, SELF, FT, F>> F field(Function<SELF, F> field) {
		return field.apply(widget());
	}

}
