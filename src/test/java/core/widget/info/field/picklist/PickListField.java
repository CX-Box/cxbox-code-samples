package core.widget.info.field.picklist;

import com.codeborne.selenide.Condition;
import core.widget.info.InfoWidget;
import core.widget.info.field.BaseString;
import io.qameta.allure.Attachment;
import io.qameta.allure.Step;

import java.time.Duration;

public class PickListField extends BaseString<String> {
    public PickListField(InfoWidget infoWidget, String title) {
        super(infoWidget, title, "pickList");
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
                .shouldBe(Condition.visible, Duration.ofSeconds(waitingForTests.Timeout))
                .getText();
    }


    @Override
    public String getValueTag() {
        return "span[class*=\"ReadOnlyField\"]";
    }

}
