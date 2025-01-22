package core.widget.form.field.percent;

import com.codeborne.selenide.Condition;
import core.widget.form.FormWidget;
import core.widget.form.field.BaseField;
import core.widget.form.field.number.Number;
import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.Keys;

import java.time.Duration;
import java.util.Objects;

@Slf4j
public class Percent extends Number {

    public Percent(FormWidget formWidget, String title) {
        super(formWidget, title, "percent");
    }

    /**
     * Setting the value in the field
     * Integers only
     *
     * @param value Integer
     */
    @Override
    @Step("Setting the {value} value in the field")
    public void setValue(Integer value) {
        getFieldByName().click();
        getFieldByName()
                .$(getValueTag())
                .shouldBe(Condition.enabled, Duration.ofSeconds(waitingForTests.Timeout))
                .clear();
        String emptyValue = "0";
        if (getFieldByName().$(getValueTag()).getValue().isEmpty()) {
            log.info("Autofill field is not enabled");
        } else {
            log.info("Autofill field is enabled");
            getFieldByName()
                    .$(getValueTag())
                    .shouldHave(Condition.partialValue(emptyValue), Duration.ofSeconds(waitingForTests.Timeout));
        }
        getFieldByName()
                .$(getValueTag())
                .shouldBe(Condition.enabled, Duration.ofSeconds(waitingForTests.Timeout))
                .setValue(String.valueOf(value));
        getFieldByName()
                .$(getValueTag())
                .shouldNotHave(Condition.partialValue(emptyValue), Duration.ofSeconds(waitingForTests.Timeout));
        getFieldByName()
                .$(getValueTag())
                .sendKeys(Keys.TAB);
        getFieldByName()
                .$(getValueTag())
                .shouldHave(Condition.partialValue("%"), Duration.ofSeconds(waitingForTests.Timeout));
    }

    /**
     * Getting a value from a field.
     * An integer
     *
     * @return Integer
     */
    @Step("Getting a value from a field")
    @Attachment
    public Integer getValue() {
        String str = getFieldByName()
                .shouldBe(Condition.exist)
                .$(getValueTag())
                .getValue();
        str = Objects.requireNonNull(str)
                .replace(" ", "")
                .replace(" ", "")
                .replace(" %", "")
                .replace("%", "");
        return Integer.parseInt(str);
    }


}

