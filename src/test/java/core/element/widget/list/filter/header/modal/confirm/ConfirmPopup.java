package core.element.widget.list.filter.header.modal.confirm;

import com.codeborne.selenide.SelenideElement;
import core.element.widget.list.filter.header.modal.BasePopup;
import io.qameta.allure.Allure;

import static com.codeborne.selenide.Selenide.$;
import static core.element.widget.AbstractWidget.logTime;

public class ConfirmPopup extends BasePopup<String> {

	public ConfirmPopup() {
		super("confirm");
	}

	/**
	 * Getting the header value
	 *
	 * @return String
	 */
	public String getTitle() {
		return Allure.step("Getting the header value", step -> {
			logTime(step);

			return getTextElement("div[class=\"ant-modal-title\"]");
		});

	}

	/**
	 * Getting the message text
	 *
	 * @return String
	 */
	public String getMessage() {
		return Allure.step("Getting the message text", step -> {
			logTime(step);

			return getTextElement("p");
		});
	}

	@Override
	public SelenideElement findPopup() {
		return $("[data-test-" + popup + "-popup=\"true\"]");
	}
}
