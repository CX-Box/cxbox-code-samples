package core.element.widget.modal;

import core.util.report.StepReport;
import static core.util.i18n.CoreMessageSource.message;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import core.common.SingleElement;
import core.element.widget.AbstractWidget;
import core.expectation.ExpectationPattern;
import io.qameta.allure.Allure;

import java.util.function.Consumer;

import static com.codeborne.selenide.Selenide.$;

public class ConfirmPopup<W extends AbstractWidget<ExpectationPattern, W>> implements SingleElement {

	private final W widget;

	private SelenideElement selenideElement;

	public ConfirmPopup(W widget) {
		this.widget = widget;
	}

	public W close() {
		return Allure.step(message("popup.close"), () -> {
			element().$("span[class=\"ant-modal-close-x\"]")
					.shouldBe(Condition.exist, widget.getExpectations().getTimeout())
					.click();
			return widget;
		});
	}

	public ConfirmPopup<W> checkTitle(Consumer<String> checkTitle) {
		return Allure.step(message("popup.header"), step -> {
			checkTitle.accept(getTextElement("div[class=\"ant-modal-title\""));
			return this;
		});

	}

	public ConfirmPopup<W> checkMessage(Consumer<String> checkMessage) {
		return Allure.step(message("popup.message"), step -> {
			checkMessage.accept(getTextElement("p"));
			return this;
		});
	}

	public ConfirmPopup<W> checkTitleAndMessage(Consumer<String> title, Consumer<String> message) {
		return Allure.step(message("popup.message"), step -> {
			title.accept(getTextElement("div[class=\"ant-modal-title\""));
			message.accept(getTextElement("p"));
			return this;
		});
	}

	private String getTextElement(String locator) {
		var text = element()
				.$(locator)
				.shouldBe(Condition.visible, widget.getExpectations().getTimeout())
				.text();
		StepReport.value(text);
		return text;
	}

	public W and() {
		return widget;
	}

	@Override
	public SelenideElement element() {
		if (selenideElement == null) {
			selenideElement = StepReport.service(message("popup.get", message("report.popup.confirm")),
					() -> $("div[data-test-confirm-popup=\"true\"]").shouldBe(Condition.exist, widget.getExpectations().getTimeout()));
		}
		return selenideElement;
	}

	public void clickOk() {
		Allure.step(message("popup.ok"), () -> clickButton("ok"));
	}

	public void clickCancel() {
		Allure.step(message("popup.cancel"), () -> clickButton("cancel"));
	}

	/**
	 * The button by its test mark ({@code data-test-confirm-popup-button-ok}, {@code -cancel}): its text depends on the
	 * language and on the operation («Подтверждаю», «Да»), the line of the report names it
	 */
	private void clickButton(String button) {
		var found = getContainer().$("[data-test-confirm-popup-button-" + button + "=\"true\"]")
				.shouldBe(Condition.enabled, widget.getExpectations().getTimeout());
		StepReport.value(found.getText());
		found.click();
	}

	private SelenideElement getContainer() {
		return element()
				.shouldBe(Condition.exist, widget.getExpectations().getTimeout())
				.scrollIntoView("{block: \"center\"}");
	}

}
