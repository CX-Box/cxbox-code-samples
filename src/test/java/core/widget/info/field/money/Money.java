package core.widget.info.field.money;

import com.codeborne.selenide.Condition;
import core.widget.info.InfoWidget;
import core.widget.info.field.BaseString;
import io.qameta.allure.Allure;
import io.qameta.allure.Attachment;

import java.math.BigDecimal;
import java.math.RoundingMode;

import static core.widget.TestingTools.CellProcessor.logTime;

public class Money extends BaseString<BigDecimal> {

    public Money(InfoWidget infoWidget, String title) {
        super(infoWidget, title, "money");
    }

    /**
     * Getting a value from a field
     *
     * @return BigDecimal
     */
    @Attachment
    public BigDecimal getValue() {
        return Allure.step("Getting a value from a field", step -> {
            logTime(step);

            String str = getFieldByName()
                    .shouldBe(Condition.exist)
                    .$(getValueTag())
                    .getText();
            str = str.replace(" ", "").replace(",", ".").replace(" ", "");
            double value = Double.parseDouble(str);
            int digits = 2;
            return BigDecimal.valueOf(value).setScale(digits, RoundingMode.HALF_UP);
        });
    }

    public String getValueTag() {
        return "span[class*=\"ReadOnlyField\"]";
    }

}
