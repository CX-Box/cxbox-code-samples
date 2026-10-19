package core.element.widget.list.filter.header.modal.confirm;

import static core.util.i18n.CoreMessageSource.message;

import com.codeborne.selenide.SelenideElement;
import core.element.widget.list.filter.header.modal.BasePopup;
import io.qameta.allure.Allure;

import static com.codeborne.selenide.Selenide.$;

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
		return Allure.step(message("popup.header"), step -> {

			return getTextElement("div[class=\"ant-modal-title\"]");
		});

	}

	/**
	 * Getting the message text
	 *
	 * @return String
	 */
	public String getMessage() {
		return Allure.step(message("popup.message"), step -> {

			return getTextElement("p");
		});
	}

	@Override
	public SelenideElement findPopup() {
		return $("[data-test-" + popup + "-popup=\"true\"]");
	}
}
