package core.widget.info.field.picklist;

import com.codeborne.selenide.Condition;
import core.widget.info.InfoWidget;
import core.widget.info.field.BaseString;
import io.qameta.allure.Allure;
import io.qameta.allure.Attachment;

import java.time.Duration;

import static core.widget.TestingTools.CellProcessor.logTime;

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
    @Attachment
    public String getValue() {
        return Allure.step("Getting a value from a field", step -> {
            logTime(step);

            return getFieldByName()
                    .$("div[class=\"ant-select-selection-selected-value\"]")
                    .shouldBe(Condition.visible, Duration.ofSeconds(waitingForTests.Timeout))
                    .text();
        });
    }

    @Override
    public String getValueTag() {
        return "input";
    }

}
