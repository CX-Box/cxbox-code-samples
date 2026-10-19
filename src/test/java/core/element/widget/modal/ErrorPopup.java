package core.element.widget.modal;

import core.util.report.StepReport;
import static core.util.i18n.CoreMessageSource.message;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import core.common.SingleElement;
import core.element.widget.AbstractWidget;
import core.expectation.CxBoxExpectations;
import core.expectation.ExpectationPattern;
import io.qameta.allure.Allure;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

import static com.codeborne.selenide.Selenide.$;

public class ErrorPopup<W extends AbstractWidget<ExpectationPattern, W>> implements SingleElement {

	private final W widget;

	private final ExpectationPattern expectations;

	private SelenideElement selenideElement;

	public ErrorPopup(W widget) {
		this.widget = widget;
		this.expectations = widget.getExpectations();
	}

	/**
	 * A popup that is not bound to a widget, e.g. the record of a form view could not be loaded
	 */
	public ErrorPopup() {
		this.widget = null;
		this.expectations = new CxBoxExpectations();
	}

	@Override
	public SelenideElement element() {
		if (selenideElement == null) {
			selenideElement = StepReport.service(message("popup.get", message("report.popup.message")),
					() -> $("div[data-test-error-popup=\"true\"]").shouldBe(Condition.exist, expectations.getTimeout()));
		}
		return selenideElement;
	}

	public W close() {
		return Allure.step(message("popup.close"), () -> {
			element().$("span[class=\"ant-modal-close-x\"]")
					.shouldBe(Condition.exist, expectations.getTimeout())
					.click();
			element().$("span[class=\"ant-modal-close-x\"]").shouldNot(Condition.exist, expectations.getTimeout());
			return widget;
		});
	}

	public ErrorPopup<W> checkTitle(Consumer<String> checkTitle) {
		return Allure.step(message("popup.header"), step -> {
			checkTitle.accept(getTextElement(" header span"));
			return this;
		});

	}

	public ErrorPopup<W> checkMessage(Consumer<String> checkMessage) {
		return Allure.step(message("popup.message"), step -> {
			checkMessage.accept(getTextElement("span[class=\"ant-form-item-children\"]"));
			return this;
		});
	}

	public ErrorPopup<W> checkTitleAndMessage(Consumer<String> checkTitle, Consumer<String> checkMessage) {
		return Allure.step(message("popup.header"), step -> {
			checkTitle.accept(getTextElement(" header span"));
			checkMessage.accept(getTextElement("span[class=\"ant-form-item-children\"]"));
			return this;
		});
	}

	/**
	 * Hands over what "Copy details" put on the clipboard
	 */
	public ErrorPopup<W> checkDetails(Consumer<ErrorDetails> checkDetails) {
		return Allure.step(message("popup.copiedDetails"), step -> {
			checkDetails.accept(copyDetails());
			return this;
		});
	}

	/**
	 * Hands over what "Copy details" put on the clipboard and what the expanded panel shows
	 */
	public ErrorPopup<W> checkDetails(BiConsumer<ErrorDetails, RequestDetails> checkDetails) {
		return Allure.step(message("popup.copiedExpandedDetails"), step -> {
			checkDetails.accept(copyDetails(), expandDetails());
			return this;
		});
	}

	public ErrorDetails copyDetails() {
		return details().copy();
	}

	public RequestDetails expandDetails() {
		return details().expand();
	}

	private RequestErrorDetailsRow details() {
		return new RequestErrorDetailsRow(element(), expectations);
	}

	private String getTextElement(String locator) {
		var text = element()
				.$(locator)
				.shouldBe(Condition.visible, expectations.getTimeout())
				.text();
		StepReport.value(text);
		return text;
	}

	public W and() {
		return widget;
	}
}
