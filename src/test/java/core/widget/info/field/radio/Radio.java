package core.widget.info.field.radio;

import com.codeborne.selenide.Condition;
import core.widget.info.InfoWidget;
import core.widget.info.field.BaseString;
import io.qameta.allure.Attachment;
import io.qameta.allure.Step;

import java.time.Duration;

public class Radio extends BaseString<String> {
    public Radio(InfoWidget infoWidget, String title) {
        super(infoWidget, title, "radio");
    }

    @Override
    public String getValueTag() {
        return "span[class*=\"ReadOnlyField\"]";
    }

    /**
     * Getting a value from a field
     *
     * @return String
     */
    @Override
    @Step("Getting a value from a field")
    @Attachment
    public String getValue() {
        return getFieldByName()
                .shouldBe(Condition.visible, Duration.ofSeconds(waitingForTests.Timeout))
                .$(getValueTag())
                .shouldBe(Condition.visible, Duration.ofSeconds(waitingForTests.Timeout))
                .getText();
    }
}
