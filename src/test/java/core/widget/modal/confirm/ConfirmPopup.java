package core.widget.modal.confirm;

import com.codeborne.selenide.SelenideElement;
import core.widget.modal.BasePopup;
import io.qameta.allure.Attachment;
import io.qameta.allure.Step;

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
    @Step("Getting the header value")
    @Attachment
    public String getTitle() {
        return getTextElement("div[class=\"ant-modal-title\"]");
    }

    /**
     * Getting the message text
     *
     * @return String
     */
    @Step("Getting the message text")
    @Attachment
    public String getMessage() {
        return getTextElement("p");
    }

    @Override
    public SelenideElement findPopup() {
        return $("[data-test-" + typePopup + "-popup=\"true\"]");
    }
}
