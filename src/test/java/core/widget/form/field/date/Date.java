package core.widget.form.field.date;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import core.widget.form.FormWidget;
import core.widget.form.field.BaseField;
import core.widget.modal.Calendar;
import io.qameta.allure.Attachment;
import io.qameta.allure.Step;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Objects;


public class Date extends BaseField<LocalDate> {

    public Date(FormWidget formWidget, String title) {
        super(formWidget, title, "date");
    }

    public String getValueTag() {
        return "input";
    }

    /**
     * Date input: year, month, day
     *
     * @param value LocalDate
     * {@code example} LocalDate date = LocalDate.of(2024, 20, 5)
     */
    @Override
    @Step("Setting the {value} in the field")
    public void setValue(LocalDate value) {
        Selenide.sleep(10);
        setFocusField();
        Calendar.clear();
        Calendar.setDate(value);
    }

    /**
     * Getting the date in the data type -  LocalDate
     *
     * @return LocalDate date
     */
    @Step("Getting a value from a field")
    @Attachment
    public LocalDate getValue() {
        String date = getFieldByName()
                .shouldBe(Condition.exist)
                .$(getValueTag())
                .getValue();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        return LocalDate.parse(Objects.requireNonNull(date), formatter);
    }

    /**
     * Clearing the field through the cross icon.
     */
    @Step("Clearing the field through the cross icon")
    public void clearIcon() {
        getFieldByName()
                .$("i[aria-label=\"icon: close-circle\"]")
                .hover()
                .shouldBe(Condition.enabled, Duration.ofSeconds(waitingForTests.Timeout))
                .click();
    }
}
