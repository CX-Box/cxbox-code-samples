package core.widget.info.field.percent;

import com.codeborne.selenide.Condition;
import core.widget.info.InfoWidget;
import core.widget.info.field.BaseString;
import io.qameta.allure.Attachment;
import io.qameta.allure.Step;

public class Percent extends BaseString<Integer> {
    public Percent(InfoWidget infoWidget, String title) {
        super(infoWidget, title, "percent");
    }

    @Override
    public String getValueTag() {
        return "span[class*=\"ReadOnlyField\"]";
    }

    /**
     * Getting a value from a field.
     * Integer
     *
     * @return Integer
     */
    @Step("Getting a value from a field")
    @Attachment
    public Integer getValue() {
        String str = getFieldByName()
                .shouldBe(Condition.exist)
                .$(getValueTag())
                .getText();
        str = str.replace(" ", "").replace(" %", "").replace(" ", "");
        return Integer.parseInt(str);
    }

}
