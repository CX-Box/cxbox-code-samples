package core.widget.info.field.number;

import com.codeborne.selenide.Condition;
import core.widget.info.InfoWidget;
import core.widget.info.field.BaseString;
import io.qameta.allure.Allure;
import io.qameta.allure.Attachment;

import java.math.BigDecimal;
import java.math.RoundingMode;

import static core.widget.TestingTools.CellProcessor.logTime;


public class NumberDigits extends BaseString<BigDecimal> {
    public NumberDigits(InfoWidget infoWidget, String title) {
        super(infoWidget, title, "number");
    }

    private Integer getDigits() {
        return Integer.parseInt(getValueByAttribute(1, getValueTag(), "digits"));
    }

    /**
     * Getting the value from the field.
     * Any numbers
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
                    .getValue();
            assert str != null;
            str = str.replace(" ", "").replace(",", ".");
            double value = Double.parseDouble(str);
            return BigDecimal.valueOf(value).setScale(getDigits(), RoundingMode.HALF_UP);
        });
    }

    public String getValueTag() {
        return "input";
    }

}
