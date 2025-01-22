package core.widget.info.field.text;

import com.codeborne.selenide.Condition;
import core.widget.info.InfoWidget;
import core.widget.info.field.BaseString;
import io.qameta.allure.Attachment;
import io.qameta.allure.Step;

import java.time.Duration;

public class Text extends BaseString<String> {
    public Text(InfoWidget infoWidget, String title) {
        super(infoWidget, title, "text");
    }

    /**
     * Getting a value from a field
     *
     * @return String
     */
    @Step("Getting a value from a field")
    @Attachment
    public String getValue() {
        return getFieldByName()
                .shouldBe(Condition.exist, Duration.ofSeconds(waitingForTests.Timeout))
                .$(getValueTag())
                .getText();
    }

    public String getValueTag() {
        return "span[class*=\"ReadOnlyField\"]";
    }

}
