package core.widget.form.field.picklist;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import core.widget.form.FormWidget;
import core.widget.form.field.BaseField;
import core.widget.modal.Popup;
import io.qameta.allure.Attachment;
import io.qameta.allure.Step;

import java.time.Duration;
import java.util.Optional;

import static com.codeborne.selenide.Selenide.$;

public class PickList extends BaseField<String> {
    public PickList(FormWidget formWidget, String title) {
        super(formWidget, title, "pickList");
    }

    /**
     * Getting a value from a field
     *
     * @return String
     */
    @Override
    @Step("Getting a value from a field")
    @Attachment
    public String getValue() {
        return getFieldByName()
                .$(getValueTag())
                .shouldBe(Condition.visible, Duration.ofSeconds(waitingForTests.Timeout))
                .getValue();
    }

    /**
     * This method is not available for PickListField.
     * The values are entered via findPopup
     *
     * @param value UnsupportedOperationException
     */
    @Override
    @Step("Setting the in the field not available")
    public void setValue(String value) {
        throw new UnsupportedOperationException("First findPopup");
    }

    @Override
    public String getValueTag() {
        return "input";
    }

    private SelenideElement modalWindow() {
        return getFieldByName()
                .$("i[data-test-field-picklist-popup=\"true\"]")
                .shouldBe(Condition.visible,
                        Duration.ofSeconds(waitingForTests.Timeout));
    }

    /**
     * Opening a modal window
     */
    @Step("Вызов Popup")
    public void openModalWindow() {
        modalWindow().click();
    }

    /**
     * Clearing the field
     */
    @Step("Clearing the field")
    public void clear() {
        getFieldByName()
                .$("i[data-test-field-picklist-clear=\"true\"]")
                .shouldBe(Condition.visible,
                        Duration.ofSeconds(waitingForTests.Timeout)).click();
    }

    /**
     * Initialization of the modal window
     *
     * @return Popup class for accessing modal windows
     */
    @Step("Validation of the Popup window")
    @Attachment
    public Optional<Popup> findPopup() {
        SelenideElement elementPopup = $("div[data-test-widget-type=\"PickListPopup\"]")
                .shouldBe(Condition.exist, Duration.ofSeconds(waitingForTests.Timeout));
        if (elementPopup.is(Condition.exist)) {
            return Optional.of(new Popup());
        } else {
            return Optional.empty();
        }
    }
}
