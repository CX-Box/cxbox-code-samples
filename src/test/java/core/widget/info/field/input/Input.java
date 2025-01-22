package core.widget.info.field.input;

import com.codeborne.selenide.Condition;
import core.widget.info.InfoWidget;
import core.widget.info.field.BaseString;
import io.qameta.allure.Attachment;
import io.qameta.allure.Step;

import java.time.Duration;

public class Input extends BaseString<String> {
    public Input(InfoWidget infoWidget, String title) {
        super(infoWidget, title, "input");
    }

    /**
     * Getting a value from a field. При отсутствии значения, возвращает null.
     *
     * @return String text / null
     */
    @Override
    @Step("Getting a value from a field")
    @Attachment
    public String getValue() {
        if (getFieldByName()
                .shouldBe(Condition.exist, Duration.ofSeconds(waitingForTests.Timeout))
                .$(getValueTag()).is(Condition.visible)) {
            return getFieldByName()
                    .shouldBe(Condition.exist, Duration.ofSeconds(waitingForTests.Timeout))
                    .$(getValueTag())
                    .shouldBe(Condition.visible, Duration.ofSeconds(waitingForTests.Timeout))
                    .getText();
        } else {
            return null;
        }

    }

    @Override
    public String getValueTag() {
        return "span[class*=\"ReadOnlyField\"]";
    }
}
