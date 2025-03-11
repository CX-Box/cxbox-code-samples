package core.widget.info.field.picklist;

import com.codeborne.selenide.Condition;
import core.widget.info.InfoWidget;
import core.widget.info.field.BaseString;
import io.qameta.allure.Attachment;
import io.qameta.allure.Step;

import java.time.Duration;

public class InlinePickList extends BaseString<String> {
    public InlinePickList(InfoWidget infoWidget, String title) {
        super(infoWidget, title, "inline-pickList");
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
                .$("div[class=\"ant-select-selection-selected-value\"]")
                .shouldBe(Condition.visible, Duration.ofSeconds(waitingForTests.Timeout))
                .text();
    }

    @Override
    public String getValueTag() {
        return "input";
    }

}
