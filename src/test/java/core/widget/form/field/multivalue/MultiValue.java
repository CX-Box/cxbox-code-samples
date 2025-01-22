package core.widget.form.field.multivalue;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import core.widget.form.FormWidget;
import core.widget.form.field.BaseField;
import core.widget.modal.Popup;
import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import java.time.Duration;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static com.codeborne.selenide.Selenide.$;

public class MultiValue extends BaseField<List<String>> {

    public MultiValue(FormWidget formWidget, String title) {
        super(formWidget, title, "multivalue");
    }

    /**
     * Getting a value from a field
     *
     * @return List String
     */
    @Override
    @Step("Getting a value from a field")
    @Attachment
    public List<String> getValue() {

        List<String> strings =  getFieldByName()
                .$(getValueTag())
                .shouldBe(Condition.visible, Duration.ofSeconds(waitingForTests.Timeout))
                .$$(By.tagName("span"))
                .texts();
        Collections.reverse(strings);
        return strings;
    }

    /**
     * This method is not available for MultiValue.
     * Data entry takes place via findPopup.
     *
     * @param value UnsupportedOperationException
     */
    @Override
    @Step("Setting the value in the field is not available")
    public void setValue(List<String> value) {
        throw new UnsupportedOperationException("First findPopup");
    }

    /**
     * Clearing the field
     */
    @Step("Clearing the field")
    public void clear() {
        ElementsCollection icons = getFieldByName()
                .shouldBe(Condition.exist, Duration.ofSeconds(waitingForTests.Timeout))
                .$$("i[class=\"anticon anticon-close\"]");
        for (SelenideElement i : icons) {
            i.shouldBe(Condition.visible, Duration.ofSeconds(waitingForTests.Timeout)).click();
            //waitingForTests.getWaitAllElements(i);
            i.shouldBe(Condition.disappear, Duration.ofSeconds(waitingForTests.Timeout));
            Selenide.sleep(20);
        }
    }

    private SelenideElement modalWindow() {
        return getFieldByName()
                .$("i[aria-label=\"icon: folder-open\"]")
                .shouldBe(Condition.visible,
                        Duration.ofSeconds(waitingForTests.Timeout));
    }

    /**
     * Opening a modal window
     */
    @Step("Opening a modal window")
    public void openModalWindow() {
        modalWindow().click();
    }

    @Override
    public String getValueTag() {
        return "span[class=\"ant-form-item-children\"]";
    }

    /**
     * Initialization of the modal window.
     * Required for data entry.
     *
     * @return Popup class of all modal windows
     */
    @Step("Validation of the modal window")
    @Attachment
    public Optional<Popup> findPopup() {
        SelenideElement elementPopup = $("div[data-test-widget-type=\"AssocListPopup\"]")
                .shouldBe(Condition.exist, Duration.ofSeconds(waitingForTests.Timeout));
        if (elementPopup.is(Condition.exist)) {
            return Optional.of(new Popup());
        } else {
            return Optional.empty();
        }
    }

    /**
     * Getting the placeholder value
     *
     * @return String
     */
    @Step("Getting the Placeholder value")
    @Attachment
    public String getPlaceholder() {
        String str = getValueByAttribute(1, "span[class=\"ant-form-item-children\"] div div", "data-text");
        if (str.isEmpty()) {
            return null;
        } else {
            return str;
        }
    }
}
