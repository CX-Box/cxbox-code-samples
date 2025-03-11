package core.widget.modal.error;

import com.codeborne.selenide.SelenideElement;
import core.widget.modal.BasePopup;
import io.qameta.allure.Attachment;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;

public class ErrorPopup extends BasePopup<String> {
    public ErrorPopup() {
        super("error");
    }
    @Override
    public SelenideElement findPopup() {
        return $("div[data-test-" + typePopup + "-popup=\"true\"]");
    }
    /**
     * Getting the title of a modal window
     * @return String title text
     */
    @Step("Getting the header value")
    @Attachment
    public String getTitle() {
        return getTextElement(" header span");
    }

    /**
     * Getting the message text
     * @return String message text
     */
    @Step("Getting the message text")
    @Attachment
    public String getMessage() {
        return getTextElement("span[class=\"ant-form-item-children\"]");
    }

}
