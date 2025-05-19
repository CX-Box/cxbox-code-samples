package core.widget.filter.filter;

import com.codeborne.selenide.Condition;
import core.widget.ListHelper;
import core.widget.modal.Calendar;

import java.time.Duration;
import java.time.LocalDate;

import static com.codeborne.selenide.Selenide.$;

public class DateFilter extends AbstractFilter<LocalDate> {
    public DateFilter(String columnType, String columnName, ListHelper helper) {
        super(columnType, columnName, helper);
    }

    @Override
    public void setFilter(LocalDate value, LocalDate value2) {
        Calendar.setDate(value);

        Calendar.setDate(value2);
        setApply();
    }

    @Override
    public void setFilter(LocalDate value) {

        $("input.ant-calendar-picker-input.ant-input[placeholder=\"End date\"]")
                .shouldBe(Condition.exist, Duration.ofSeconds(waitingForTests.Timeout))
                .click();
        Calendar.setDate(value);
        setApply();
    }

    @Override
    public String getTypeFilter() {
        return "date";
    }
}
