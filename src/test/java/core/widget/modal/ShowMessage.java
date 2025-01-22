package core.widget.modal;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import core.OriginExpectations.CxBoxExpectations;
import io.qameta.allure.Attachment;
import io.qameta.allure.Step;

import java.time.Duration;

public class ShowMessage {
    private final SelenideElement alert;
    private final CxBoxExpectations waitingForTests = new CxBoxExpectations();

    public ShowMessage(SelenideElement alert) {
        this.alert = alert;
    }

    /**
     * Getting the icon test
     * @return String
     */
    @Step("Getting the icon test")
    @Attachment
    public String getIcon() {
        return alert
                .$("i[class*=\"anticon\"]").$("svg")
                .shouldBe(Condition.visible, Duration.ofSeconds(waitingForTests.Timeout))
                .getAttribute("data-icon");
    }

    /**
     * Getting the message text
     * @return String
     */
    @Step("Getting the message text")
    @Attachment
    public String getAlertMessage() {
        return alert
                .$("span[class=\"ant-alert-message\"]")
                .shouldBe(Condition.visible, Duration.ofSeconds(waitingForTests.Timeout))
                .getText();
    }

    /**
     * Getting the Message Description
     * @return String
     */
    @Step("Getting the Message Description")
    @Attachment
    public String getAlertDescription() {
        return alert
                .$("span[class=\"ant-alert-description\"]")
                .shouldBe(Condition.visible, Duration.ofSeconds(waitingForTests.Timeout))
                .getText();
    }

    /**
     * Closing the message
     */
    @Step("Closing the message")
    public void close() {
        alert
                .$("button[type=\"button\"][class=\"ant-alert-close-icon\"]")
                .shouldBe(Condition.visible, Duration.ofSeconds(waitingForTests.Timeout))
                .click();
    }
}
