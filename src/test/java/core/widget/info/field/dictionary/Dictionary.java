package core.widget.info.field.dictionary;

import com.codeborne.selenide.Condition;
import core.widget.info.InfoWidget;
import core.widget.info.field.BaseString;
import io.qameta.allure.Attachment;
import io.qameta.allure.Step;

import java.time.Duration;

public class Dictionary extends BaseString<String> {

    public Dictionary(InfoWidget infoWidget, String title) {
        super(infoWidget, title, "dictionary");
    }

    @Override
    public String getValueTag() {
        return "div[class*=\"Dictionary_coloredValue\"]";
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
                .$(getValueTag())
                .shouldBe(Condition.exist, Duration.ofSeconds(waitingForTests.Timeout))
                .getText();
    }
}
