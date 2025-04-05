package core.widget.list.field.money;

import com.codeborne.selenide.Condition;
import core.widget.ListHelper;
import core.widget.list.ListWidget;
import core.widget.list.field.BaseRow;

import io.qameta.allure.Step;
import org.openqa.selenium.Keys;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.Duration;
import java.util.Objects;

import static com.codeborne.selenide.Selenide.$;

public class Money extends BaseRow<BigDecimal> {

    private Integer getDigits() {
        return Integer.parseInt(getValueByAttribute(1, getValueTag(), "digits"));
    }

    public Money(ListWidget listWidget, String title, String id, ListHelper listHelper, Boolean sort, Boolean filter) {
        super(listWidget, title, "money", id, listHelper, sort, filter);
    }

    /**
     * Entering a value in the field
     *
     * @param value BigDecimal
     * {@code pattern} ***.XX
     */
    @Override
    @Step("Setting the {value} in the field")
    public void setValue(BigDecimal value) {
        setFocusField();
        String pattern = ".*\\d.\\d{2}";
        String str = value.toString();
        str = str.replace(".", ",");
        if (!str.matches(pattern)) {
            throw new IllegalArgumentException("Число не соответствует паттерну: " + str);
        }
        clear();
        setFocusField();
        getRowByName()
                .$(getValueTag())
                .shouldBe(Condition.visible, Duration.ofSeconds(waitingForTests.Timeout))
                .setValue(str);
        $("body").click();
    }

    /**
     * Getting a value from a field
     *
     * @return BigDecimal
     */
    @Override
    @Step("Getting a value from a field")
    public BigDecimal getValue() {
        setFocusField();
        String str = getRowByName()
                .shouldBe(Condition.exist)
                .$(getValueTag())
                .getValue();
        str = Objects.requireNonNull(str).replace(" ", "").replace(",", ".");
        double value = Double.parseDouble(str);
        return BigDecimal.valueOf(value).setScale(getDigits(), RoundingMode.HALF_UP);
    }

    @Override
    public String getValueTag() {
        return "input";
    }

    /**
     * Clearing the field using a keyboard shortcut
     */
    @Step("Clearing the field")
    public void clear() {
        setFocusField();
        getRowByName()
                .$(getValueTag())
                .shouldBe(Condition.enabled, Duration.ofSeconds(waitingForTests.Timeout))
                .click();
        getRowByName()
                .$(getValueTag())
                .shouldBe(Condition.enabled, Duration.ofSeconds(waitingForTests.Timeout))
                .sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.BACK_SPACE);
    }
}
