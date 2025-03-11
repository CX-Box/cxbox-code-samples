package core.widget.info.field.multivaluehover;

import com.codeborne.selenide.Condition;
import core.widget.info.InfoWidget;
import core.widget.info.field.BaseString;
import io.qameta.allure.Attachment;
import io.qameta.allure.Step;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.$;

public class MultiValueHover extends BaseString<String> {
    public MultiValueHover(InfoWidget infoWidget, String title) {
        super(infoWidget, title, "multivalueHover");
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
        getFieldByName()
                .$(getValueTag())
                .shouldBe(Condition.visible, Duration.ofSeconds(waitingForTests.Timeout))
                .hover();
        return $("div[class=\"ant-popover-inner\"]")
                .shouldBe(Condition.visible, Duration.ofSeconds(waitingForTests.Timeout))
                .text();
    }

    @Override
    public String getValueTag() {
        return "p[class*=\"MultivalueHover\"]";
    }

    /**
     * This method is not available..
     *
     * @return UnsupportedOperationException
     */
    @Step("Clicking on a hyperlink in the text or by clicking on a special element")
    public Boolean drillDown() {
        throw new UnsupportedOperationException("drillDown not supported for CheckBox on Info");
    }

}
