package core.widget.filter.filter;

import com.codeborne.selenide.Condition;
import core.widget.ListHelper;
import org.openqa.selenium.Keys;

import java.math.BigDecimal;
import java.time.Duration;

public class MoneyFilter extends AbstractFilter<BigDecimal>{
    public MoneyFilter(String columnType, String columnName, ListHelper helper) {
        super(columnType, columnName, helper);
    }

    @Override
    public void setFilter(BigDecimal value) {
        String pattern = ".*\\d.\\d{2}";
        String str = value.toString();
        str = str.replace(".", ",");
        assert str.matches(pattern) : "Число не соответствует паттерну.";
        clear();
        formFilter.$("input[data-test-filter-popup-value=\"true\"]")
                .shouldBe(Condition.editable, Duration.ofSeconds(waitingForTests.Timeout))
                .click();
        formFilter.$("input[data-test-filter-popup-value=\"true\"]")
                .shouldBe(Condition.editable, Duration.ofSeconds(waitingForTests.Timeout))
                .shouldBe(Condition.visible, Duration.ofSeconds(waitingForTests.Timeout))
                .setValue(str);
        setApply();
    }

    @Override
    public String getTypeFilter() {
        return "money";
    }

    private void clear() {
        formFilter.$("input[data-test-filter-popup-value=\"true\"]")
                .shouldBe(Condition.editable, Duration.ofSeconds(waitingForTests.Timeout))
                .click();
        formFilter.$("input[data-test-filter-popup-value=\"true\"]")
                .shouldBe(Condition.editable, Duration.ofSeconds(waitingForTests.Timeout))
                .sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.BACK_SPACE);
    }
}
