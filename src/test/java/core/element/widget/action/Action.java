package core.element.widget.action;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import core.common.SingleElement;
import core.element.widget.AbstractWidget;
import core.expectation.ExpectationPattern;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;

import java.time.Duration;
import java.util.function.Predicate;
import java.util.stream.Stream;

import static com.codeborne.selenide.Selectors.by;
import static com.codeborne.selenide.Selenide.$;

// TODO add to burger and check logic
@Slf4j
public class Action<W extends AbstractWidget<ExpectationPattern, W>> implements SingleElement {

	@Getter(AccessLevel.PROTECTED)
	private final W widget;

	@Getter(AccessLevel.PROTECTED)
	@Setter(AccessLevel.PROTECTED)
	protected Action<W> parent;

	@Getter(AccessLevel.PROTECTED)
	@Setter(AccessLevel.PROTECTED)
	protected Action<W> current;

	@Getter(AccessLevel.PROTECTED)
	@Setter(AccessLevel.PROTECTED)
	private String name;

	@Getter(AccessLevel.PROTECTED)
	@Setter(AccessLevel.PROTECTED)
	private String iconName;

	@Getter(AccessLevel.PROTECTED)
	@Setter(AccessLevel.PROTECTED)
	private Predicate<SelenideElement> condition;

	public Action(W widget) {
		this.widget = widget;
		this.parent = null;
	}

	@SneakyThrows
	public Action<W> action(String name) {
		Action<W> wAction = new Action<>(this.widget);
		wAction.setParent(current);
		wAction.setName(name);
		wAction.setCurrent(wAction);
		wAction.setCondition(el-> el.getText().equals(name));
		return wAction;
	}

	@SneakyThrows
	public Action<W> action(String name, String iconName) {
		Action<W> wAction = new Action<>(this.widget);
		wAction.setParent(current);
		wAction.setName(name);
		wAction.setIconName(iconName);
		wAction.setCurrent(wAction);
		wAction.setCondition(el-> el.getText().equals(name) && el.$(By.cssSelector("i[aria-label='icon: " + iconName + "']")).isDisplayed());
		return wAction;
	}

	@SneakyThrows
	public Action<W> actionWithIcon(String iconName) {
		Action<W> wAction = new Action<>(this.widget);
		wAction.setParent(current);
		wAction.setIconName(iconName);
		wAction.setCurrent(wAction);
		wAction.setCondition(el-> el.$(By.cssSelector("i[aria-label='icon: " + iconName + "']")).isDisplayed() );
		return wAction;
	}


	public W click() {
		Action<W> currentAction = this.current;
		if (this.parent == null) {
			currentAction.element().click();
			return this.widget;
		}
		log.warn("Action parent: {} {} , action: {} {}", this.parent.name, this.parent.iconName, this.name, this.iconName);
		//click parent action;
		currentAction.parent.element().click();
		currentAction.element().click();
		return widget;
	}

	public W click(String name) {
		action(name).click();
		return this.widget;
	}
	@Override
	public SelenideElement element() {
		Duration timeout = this.widget.getExpectations().getTimeout();
		Stream<SelenideElement> stream = null;
		if (parent == null) {
			stream =  widget.element()
					.$("div[class*='Operations__operations']")
					.$$("button")
					.shouldHave(CollectionCondition.sizeGreaterThan(0), timeout)
					.asFixedIterable().stream();
		}else{
			stream = widget.element()
					.$("div[class*='Operations__operations']")
					.$("div[class*='OperationsGroup__overlayContainer']")
					.shouldBe(Condition.visible, timeout)
					.$$("li[data-test-widget-action-item='true'] div.ant-spin-container")
					.shouldHave(CollectionCondition.sizeGreaterThan(0), timeout)
					.asFixedIterable().stream();
		}

		return stream
				.filter(this.condition)
				.findFirst()
				.orElseThrow(() -> new NoSuchElementException("No such element"));
	}


	public W checkExistActionsBlocks() {
		widget.element()
				.findAll(by("type", "button"))
				.shouldBe(CollectionCondition.sizeGreaterThan(0));
		return this.widget;
	}


}
