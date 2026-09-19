package core.element.widget.action;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import core.common.SingleElement;
import core.element.widget.AbstractWidget;
import core.expectation.ExpectationPattern;
import io.qameta.allure.Allure;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;

import java.time.Duration;
import java.util.function.Consumer;
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
		PageRequests.track();
		if (this.parent == null) {
			currentAction.element().click();
			waitOperationFinished();
			return this.widget;
		}
		log.warn("Action parent: {} {} , action: {} {}", this.parent.name, this.parent.iconName, this.name, this.iconName);
		//click parent action;
		currentAction.parent.element().click();
		currentAction.element().click();
		waitOperationFinished();
		return widget;
	}

	/**
	 * The operation is finished when its requests are done and rendered (a popup widget has no loading spinner) and the
	 * widget has no loading spinner. A widget that is gone after the operation (a drilldown, a closed popup) has nothing to wait for.
	 * The requests wait is temporary until the popup widgets show the loading spinner ({@link PageRequests}).
	 */
	private void waitOperationFinished() {
		PageRequests.waitDone(widget.getExpectations().getOverTimeout());
		Selenide.Wait().withTimeout(widget.getExpectations().getOverTimeout()).until(driver -> {
			try {
				return !widget.element().$(".ant-spin-spinning").exists();
			} catch (RuntimeException | AssertionError e) {
				return true;
			}
		});
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


	/**
	 * Checks whether the widget shows the action button (top level actions only). Like the click, it waits for the
	 * buttons of the widget: they are shown with its row meta. A widget without any button gives false after the timeout.
	 */
	public W checkExist(Consumer<Boolean> exist) {
		if (parent != null) {
			throw new UnsupportedOperationException("checkExist supports top level actions only");
		}
		return Allure.step("Checking the action \"" + name + "\" for existence", step -> {
			AbstractWidget.logTime(step);
			ElementsCollection buttons = widget.element().$$("div[class*='Operations__operations'] button");
			try {
				buttons.shouldHave(CollectionCondition.sizeGreaterThan(0), widget.getExpectations().getTimeout());
			} catch (AssertionError e) {
				exist.accept(false);
				return widget;
			}
			exist.accept(buttons.asFixedIterable().stream().anyMatch(this.condition));
			return widget;
		});
	}

	public W checkExistActionsBlocks() {
		widget.element()
				.findAll(by("type", "button"))
				.shouldBe(CollectionCondition.sizeGreaterThan(0));
		return this.widget;
	}


}
