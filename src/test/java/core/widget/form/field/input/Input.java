package core.widget.form.field.input;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.WebDriverRunner;
import core.widget.form.FormWidget;
import core.widget.form.field.BaseField;
import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import org.openqa.selenium.Keys;

import java.time.Duration;
import java.util.Objects;

import static com.codeborne.selenide.Selenide.$x;


public class Input extends BaseField<String> {
    final String fieldType;

    public Input(FormWidget formWidget, String title) {
        super(formWidget, title, "input");
        this.fieldType = "input";
    }

    protected Input(FormWidget formWidget, String title, String fieldType) {
        super(formWidget, title, fieldType);
        this.fieldType = fieldType;
    }

    public String getValueTag() {
        if (Objects.equals(fieldType, "text")) {
            return fieldType + "area";
        }
        return fieldType;
    }

    /**
     * Getting a value from a field
     *
     * @return String text
     */
    @Override
    @Step("Getting a value from a field")
    @Attachment
    public String getValue() {
        return getFieldByName()
                .shouldBe(Condition.exist)
                .$(getValueTag())
                .getValue();
    }

    /**
     * Setting the value
     *
     * @param value String
     */
    @Override
    @Step("Setting the {value} value in the field")
    public void setValue(String value) {
        setValue(1, value);
    }

    private void setValue(Integer element, String value) {
        getFieldByName().click();
        getFieldByName()
                .$(getValueTag())
                .shouldBe(Condition.enabled)
                .clear();
        getFieldByName()
                .$(getValueTag())
                .shouldBe(Condition.enabled)
                .setValue(value);
        getFieldByName(element)
                .$(getValueTag())
                .shouldNot(Condition.empty);
        getFieldByName(element)
                .$(getValueTag())
                .sendKeys(Keys.TAB);
    }

    /**
     * Checking for the number of characters entered
     *
     * @param n number of characters
     * @return boolean true/false
     */
    @Step("Getting the number of characters that a field accepts")
    public boolean getMaxInput(Integer n) {
        String str = getValue();
        return String.valueOf(str).length() == n;
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
     * Clicking on a hyperlink.
     * After the transition, the old Url and the new Url are checked.,
     * after waiting for the items on the page.
     *
     * @return Boolean true/false
     */
    @Step("Click-through when clicking on a hyperlink or a special element in a field")
    public Boolean drillDown() {
        if(fieldType.equals("text")) {
            super.drillDown();
        }
        String oldUrl = WebDriverRunner.url();
        getFieldByName().$("i[class=\"anticon anticon-link\"]").click();
        String newUrl = WebDriverRunner.url();
        waitingForTests.getContextMenu();
        return oldUrl.equals(newUrl) && $x("//body").exists();
    }

}