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
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.Deque;
import java.util.LinkedList;
import java.util.function.Predicate;

import static com.codeborne.selenide.Selectors.by;
import static com.codeborne.selenide.Selenide.$;

// TODO add to burger and check logic
public class Actions<W extends AbstractWidget<ExpectationPattern, W>> implements SingleElement {

	@Getter(AccessLevel.PROTECTED)
	private final W widget;

	@Getter(AccessLevel.PROTECTED)
	@Setter(AccessLevel.PROTECTED)
	protected Actions<W> parent;

	@Getter(AccessLevel.PROTECTED)
	@Setter(AccessLevel.PROTECTED)
	protected Action<W> current;

	@Getter(AccessLevel.PROTECTED)
	@Setter(AccessLevel.PROTECTED)
	private String name;

	@Getter(AccessLevel.PROTECTED)
	@Setter(AccessLevel.PROTECTED)
	private String iconName;

	// needly for find for chain
	@Getter(AccessLevel.PROTECTED)
	@Setter(AccessLevel.PROTECTED)
	private Predicate<WebElement> condition;

	public Actions(W widget) {
		this.widget = widget;
		this.parent = null;
	}


	@SneakyThrows
	public Actions<W> action(String name) {
		Action<W> wAction = new Action<>(this.widget);
		wAction.setParent(current);
		wAction.setName(name);
		wAction.setCurrent(wAction);
		wAction.setCondition(el-> el.getText().equals(name));
		return wAction;
	}

	@SneakyThrows
	public Actions<W> action(String name, String iconName) {
		Action<W> wAction = new Action<>(this.widget);
		wAction.setParent(current);
		wAction.setName(name);
		wAction.setIconName(iconName);
		wAction.setCurrent(wAction);
		wAction.setCondition(el-> el.getText().equals(name) && el.findElement(By.cssSelector("i[aria-label='icon: '" + iconName)).isEnabled());
		return wAction;
	}

	@SneakyThrows
	public Actions<W> actionWithIcon(String iconName) {
		Action<W> wAction = new Action<>(this.widget);
		wAction.setParent(current);
		wAction.setIconName(iconName);
		wAction.setCurrent(wAction);
		wAction.setCondition(el->el.findElement(By.cssSelector("i[aria-label='icon: '" + iconName)).isEnabled());
		return wAction;
	}


	public W click() {
		Actions<W> currentActions = this.current;
		if (this.parent == null) {
			element().findAll(by("type", "button"))
					.shouldHave(CollectionCondition.sizeGreaterThan(0)).find(Condition.match("check action name: " + name, currentActions.condition))
					.click();
			return this.widget;
		}
		Deque<Actions<W>> deque = new LinkedList<>();
		while (currentActions.parent != null) {
			deque.push(currentActions);
			currentActions = currentActions.parent;
		}
		SelenideElement elementAction = element().findAll(by("type", "button"))
				.shouldHave(CollectionCondition.sizeGreaterThan(0))
				.find(Condition.match("check action name: " + currentActions.getName(), currentActions.condition));
		elementAction.click();
		var actionsIterator = deque.descendingIterator();
		// TODO check logic  inner group action on group action (group lay inner other group)
		elementAction = $("div[class*='OperationsGroup__overlayContainer']");
		//
		while (actionsIterator.hasNext()) {
			Actions<W> parentAction = actionsIterator.next();
			elementAction = elementAction.$$("li[class*='ant-menu-item OperationsGroup__subOperation']").find(Condition.match("check action name: " + parentAction.getName(), parentAction.condition));
			elementAction.click();
		}
		return widget;
	}

	public W click(String name) {
		action(name).click();
		return this.widget;
	}

	@Override
	public SelenideElement element() {
		return widget.element()
				.scrollIntoView("{block: \"center\"}")
				.shouldBe(Condition.enabled);

	}

	public W checkExistButtons() {
		element()
				.findAll(by("type", "button"))
				.shouldBe(CollectionCondition.sizeGreaterThan(0));
		return this.widget;
	}


}
