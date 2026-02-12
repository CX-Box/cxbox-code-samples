package core.element.widget.modal;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import core.common.SingleElement;
import core.element.widget.AbstractWidget;
import core.expectation.ExpectationPattern;
import io.qameta.allure.Allure;
import org.openqa.selenium.By;

import java.util.function.Consumer;

import static com.codeborne.selenide.Selenide.$;
import static core.element.widget.AbstractWidget.logTime;

public class ConfirmPopup<W extends AbstractWidget<ExpectationPattern, W>> implements SingleElement {

	private final W widget;

	private SelenideElement selenideElement;

	public ConfirmPopup(W widget) {
		this.widget = widget;
	}

	public W close() {
		element().$("span[class=\"ant-modal-close-x\"]")
				.shouldBe(Condition.exist, widget.getExpectations().getTimeout())
				.click();
		return widget;
	}

	public ConfirmPopup<W> checkTitle(Consumer<String> checkTitle) {
		return Allure.step("Getting the header value", step -> {
			logTime(step);
			checkTitle.accept(getTextElement("div[class=\"ant-modal-title\""));
			return this;
		});

	}

	public ConfirmPopup<W> checkMessage(Consumer<String> checkMessage) {
		return Allure.step("Getting the message text", step -> {
			logTime(step);
			checkMessage.accept(getTextElement("p"));
			return this;
		});
	}

	public ConfirmPopup<W> checkTitleAndMessage(Consumer<String> title, Consumer<String> message) {
		return Allure.step("Getting the message text", step -> {
			logTime(step);
			title.accept(getTextElement("div[class=\"ant-modal-title\""));
			message.accept(getTextElement("p"));
			return this;
		});
	}

	private String getTextElement(String locator) {
		return element()
				.$(locator)
				.shouldBe(Condition.visible, widget.getExpectations().getTimeout())
				.text();
	}

	public W and() {
		return widget;
	}

	@Override
	public SelenideElement element() {
		if (selenideElement == null) {
			selenideElement = $("div[data-test-confirm-popup=\"true\"]")
					.shouldBe(Condition.exist, widget.getExpectations().getTimeout());
		}
		return selenideElement;
	}

	public void clickOk() {
		clickButton("Ok");
	}

	public void clickCancel() {
		clickButton("cancel");
	}

	private void clickButton(String actionName) {
		SelenideElement button = getButton(actionName);
		button.shouldBe(Condition.enabled, widget.getExpectations().getTimeout()).click();
	}

	private SelenideElement getContainer() {
		return element()
				.shouldBe(Condition.exist, widget.getExpectations().getTimeout())
				.scrollIntoView("{block: \"center\"}");
	}

	private ElementsCollection getContainersActions() {
		return getContainer()
				.$$(By.tagName("button"))
				.shouldBe(CollectionCondition.sizeGreaterThan(0));
	}

	private SelenideElement getButton(String actionName) {
		return getContainersActions()
				.find(Condition.match("check action name: " + actionName, b -> b.getText().equals(actionName)));
	}

}
