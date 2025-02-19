package core.widget.form.field.checkbox;

import com.codeborne.selenide.Condition;
import core.widget.form.FormWidget;
import core.widget.form.field.BaseField;
import io.qameta.allure.Attachment;
import io.qameta.allure.Step;

import java.time.Duration;

public class CheckBox extends BaseField<Boolean> {
    public CheckBox(FormWidget formWidget, String title) {
        super(formWidget, title, "checkbox");
    }

    public String getValueTag() {
        return "input";
    }

    /**
     * CheckBox value
     *
     * @return Boolean true/false
     */
    @Override
    @Step("Getting a value from a field")
    @Attachment
    public Boolean getValue() {
        return getFieldByName()
                .$(getValueTag())
                .shouldBe(Condition.enabled, Duration.ofSeconds(waitingForTests.Timeout))
                .isSelected();
    }

    /**
     * Setting the selected value
     *
     * @param value Boolean true/false
     */
    @Override
    @Step("Setting the {value} in the field")
    public void setValue(Boolean value) {
        if (value) {
            setTrue();
        } else {
            setFalse();
        }
    }

    private void set() {
        getFieldByName()
                .$(getValueTag())
                .shouldBe(Condition.exist, Duration.ofSeconds(waitingForTests.Timeout))
                .click();
    }

    private void setTrue() {
        set();
        if (!getValue()) {
            set();
        }
    }

    private void setFalse() {
        set();
        if (getValue()) {
            set();
        }
    }

    public void setTrueWithError() {
        set();
    }


}
