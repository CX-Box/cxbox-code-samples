package core.element.widget.modal;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import core.common.SingleElement;
import core.element.widget.AbstractWidget;
import core.expectation.ExpectationPattern;
import io.qameta.allure.Allure;

import java.util.function.Consumer;

import static com.codeborne.selenide.Selenide.$;
import static core.element.widget.AbstractWidget.logTime;

public class ErrorPopup<W extends AbstractWidget<ExpectationPattern, W>> implements SingleElement {

	private final W widget;

	private SelenideElement selenideElement;

	public ErrorPopup(W widget) {
		this.widget = widget;
	}

	@Override
	public SelenideElement element() {
		if (selenideElement == null) {
			selenideElement = $("div[data-test-error-popup=\"true\"]")
					.shouldBe(Condition.exist, widget.getExpectations().getTimeout());
		}
		return selenideElement;
	}

	public W close() {
		element().$("span[class=\"ant-modal-close-x\"]")
				.shouldBe(Condition.exist, widget.getExpectations().getTimeout())
				.click();
		element().$("span[class=\"ant-modal-close-x\"]").shouldNot(Condition.exist, widget.getExpectations().getTimeout());
		return widget;
	}

	public ErrorPopup<W> checkTitle(Consumer<String> checkTitle) {
		return Allure.step("Getting the header value", step -> {
			logTime(step);
			checkTitle.accept(getTextElement(" header span"));
			return this;
		});

	}

	public ErrorPopup<W> checkMessage(Consumer<String> checkMessage) {
		return Allure.step("Getting the message text", step -> {
			logTime(step);
			checkMessage.accept(getTextElement("span[class=\"ant-form-item-children\"]"));
			return this;
		});
	}

	public ErrorPopup<W> checkTitleAndMessage(Consumer<String> checkTitle, Consumer<String> checkMessage) {
		return Allure.step("Getting the header value", step -> {
			logTime(step);
			checkTitle.accept(getTextElement(" header span"));
			checkMessage.accept(getTextElement("span[class=\"ant-form-item-children\"]"));
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
}
