package core.widget.form.field.datetime;

import com.codeborne.selenide.Condition;
import core.widget.form.FormWidget;
import core.widget.form.field.BaseField;
import core.widget.modal.Calendar;
import io.qameta.allure.Attachment;
import io.qameta.allure.Step;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class DateTime extends BaseField<LocalDateTime> {
    public DateTime(FormWidget formWidget, String title) {
        super(formWidget, title, "dateTime");
    }

    public String getValueTag() {
        return "input";
    }

    /**
     * Return the date in the appropriate data type
     *
     * @return LocalDateTime
     */
    @Step("Getting a value from a field")
    @Attachment
    public LocalDateTime getValue() {
        String date = getFieldByName()
                .shouldBe(Condition.visible, Duration.ofSeconds(waitingForTests.Timeout))
                .$(getValueTag())
                .shouldBe(Condition.visible, Duration.ofSeconds(waitingForTests.Timeout))
                .getValue();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm");
        if (Objects.requireNonNull(date) == null || Objects.requireNonNull(date).isEmpty()){
            return null;
        }
        return LocalDateTime.parse(Objects.requireNonNull(date), formatter);
    }

    /**
     * Setting the date in the calendar
     *
     * @param date LocalDateTime
     * {@code example} LocalDateTime dateTime = LocalDateTime.of(2020,10,10,10,10)
     */
    @Step("Setting the {value} in the field")
    @Override
    public void setValue(LocalDateTime date) {
        if (getValue() != null) {
            clearIcon();
        }
        setFocusField();
        Calendar.setDateTime(date);
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
