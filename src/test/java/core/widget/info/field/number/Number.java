package core.widget.info.field.number;

import com.codeborne.selenide.Condition;
import core.widget.info.InfoWidget;
import core.widget.info.field.BaseString;
import io.qameta.allure.Attachment;
import io.qameta.allure.Step;

public class Number extends BaseString<Integer> {

    public Number(InfoWidget infoWidget, String title) {
        super(infoWidget, title, "number");
    }

    /**
     * Getting a value from a field. Integer only
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
        str = str.replace(" ", "").replace(",00", "").replace(" ", "");
        return Integer.parseInt(str);
    }

    @Override
    public String getValueTag() {
        return "span[class*=\"ReadOnlyField\"]";
    }
}
