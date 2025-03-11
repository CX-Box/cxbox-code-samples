package core.widget.form.field.percent;

import com.codeborne.selenide.Condition;
import core.widget.form.FormWidget;
import core.widget.form.field.BaseField;
import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.Keys;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.time.Duration;
import java.util.Objects;

@Slf4j
public class PercentDigits extends BaseField<BigDecimal> {

    public PercentDigits(FormWidget formWidget, String title) {
        super(formWidget, title, "percent");
    }

    public String getValueTag() {
        return "input";
    }

    /**
     * Setting the value in the field
     * For numbers with a fractional part
     *
     * @param value BigDecimal
     */
    @Override
    @Step("Setting the {value} value in the field")
    public void setValue(BigDecimal value) {
        if (checkDigits(value) && getDigits() > 0) {
            getFieldByName().click();
            getFieldByName()
                    .$(getValueTag())
                    .shouldBe(Condition.enabled, Duration.ofSeconds(waitingForTests.Timeout))
                    .clear();
            String emptyValue = getDigits() != null && getDigits() > 0 ? "0," + "0".repeat(getDigits()) : "0";
            getFieldByName()
                    .$("div[class=\"ant-col ant-form-item-label\"]")
                    .click();
            if (getFieldByName().$(getValueTag()).getValue().isEmpty()) {
                log.info("Autofill field is not enabled");
            } else {
                log.info("Autofill field is enabled");
                getFieldByName()
                        .$(getValueTag())
                        .shouldHave(Condition.partialValue(emptyValue), Duration.ofSeconds(waitingForTests.Timeout));
            }
            getFieldByName().click();
            getFieldByName()
                    .$(getValueTag())
                    .shouldBe(Condition.enabled, Duration.ofSeconds(waitingForTests.Timeout))
                    .setValue("")
                    .setValue((String.valueOf(value)).replace(".", ","));
            getFieldByName()
                    .$(getValueTag())
                    .shouldNotHave(Condition.partialValue(emptyValue), Duration.ofSeconds(waitingForTests.Timeout));
            getFieldByName()
                    .$(getValueTag())
                    .sendKeys(Keys.TAB);
            getFieldByName()
                    .$(getValueTag())
                    .shouldHave(Condition.partialValue("%"), Duration.ofSeconds(waitingForTests.Timeout));
        } else {
            throw new IllegalArgumentException("Введенном вами числе нету дробной части. Рекомендуется использовать класс Percent для целых чисел или добавить дробную часть");
        }
    }

    /**
     * Getting a value from a field.
     * An integer
     *
     * @return BigDecimal
     */
    @Step("Getting a value from a field")
    @Attachment
    @SneakyThrows
    public BigDecimal getValue() {
        String str = Objects.requireNonNull(getFieldByName()
                .shouldBe(Condition.exist)
                .$(getValueTag())
                .getValue());
        str = str.replace(" %", "")
                .replace(" ", "")
                .replace(" ", "")
                .replace(",", ".");

        int digits = getDigits();

        DecimalFormatSymbols symbols = new DecimalFormatSymbols();
        symbols.setDecimalSeparator('.');

        String pattern = "#,##0." + "0".repeat(Math.max(0, digits));
        DecimalFormat decimalFormat = new DecimalFormat(pattern, symbols);

        decimalFormat.setParseBigDecimal(true);
        return (BigDecimal) decimalFormat.parse(str);
    }

    /**
     * Clearing the field using a keyboard shortcut
     */
    @Step("Clearing the field")
    public void clear() {
        getFieldByName()
                .$(getValueTag())
                .shouldBe(Condition.enabled, Duration.ofSeconds(waitingForTests.Timeout))
                .click();
        getFieldByName()
                .$(getValueTag())
                .shouldBe(Condition.enabled, Duration.ofSeconds(waitingForTests.Timeout))
                .sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.BACK_SPACE);
    }

    /**
     * Getting the number of zeros after the decimal point
     *
     * @return Integer
     */
    @Step("Getting the number of digits after the decimal point")
    @Attachment
    public Integer getDigits() {
        if (getFieldByName().$(getValueTag()).has(Condition.attribute("digits"))) {
            String digits = getFieldByName().$(getValueTag()).getAttribute("digits");
            return Integer.parseInt(Objects.requireNonNull(digits));
        } else {
            throw new IllegalArgumentException("Argument 'digits' is not a valid digits");
        }
    }

    @Step("Checking the fractional part of the number and the number of digits entered after the dot in the field")
    @Attachment
    private boolean checkDigits(BigDecimal number) {
        return number.scale() == getDigits();
    }
}
