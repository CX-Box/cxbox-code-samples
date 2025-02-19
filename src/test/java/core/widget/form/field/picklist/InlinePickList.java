package core.widget.form.field.picklist;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import core.widget.form.FormWidget;
import core.widget.form.field.BaseField;
import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import static com.codeborne.selenide.Selenide.$;

public class InlinePickList extends BaseField<String> {
    public InlinePickList(FormWidget formWidget, String title) {
        super(formWidget, title, "inline-pickList");
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
                .$("div[class=\"ant-select-selection-selected-value\"]")
                .shouldBe(Condition.visible, Duration.ofSeconds(waitingForTests.Timeout))
                .text();
    }

    /**
     * Setting the in the field
     *
     * @param value String
     */
    @Override
    @Step("Setting the {value} in the field")
    public void setValue(String value) {
        clear();
        getFieldByName()
                .$("div[class=\"ant-select-selection__placeholder\"]")
                .shouldBe(Condition.visible, Duration.ofSeconds(waitingForTests.Timeout))
                .click();
        getFieldByName()
                .$(getValueTag())
                .shouldBe(Condition.enabled, Duration.ofSeconds(waitingForTests.Timeout))
                .setValue(value);
        waitingForTests.getWaitAllElements(getFieldByName());
        getValues()
                .findBy(Condition.text(value))
                .shouldBe(Condition.enabled, Duration.ofSeconds(waitingForTests.Timeout))
                .click();
    }

    @Override
    public String getValueTag() {
        return "input";
    }

    private ElementsCollection getValues() {
        return $("div[class=\"ant-select-dropdown ant-select-dropdown--single ant-select-dropdown-placement-bottomLeft\"]")
                .$("ul[role=\"listbox\"]")
                .shouldBe(Condition.visible, Duration.ofSeconds(waitingForTests.Timeout))
                .$$(By.tagName("li"));
    }

    /**
     * Getting a list of options via a character match
     *
     * @param value String Symbol
     * @return List String Match results
     */
    @Step("Getting a list of options via a character match")
    @Attachment
    public List<String> getValueInList(String value) {
        getFieldByName()
                .$("div[class=\"ant-select-selection-selected-value\"]")
                .shouldBe(Condition.enabled, Duration.ofSeconds(waitingForTests.Timeout))
                .click();
        getFieldByName()
                .$(getValueTag())
                .shouldBe(Condition.enabled, Duration.ofSeconds(waitingForTests.Timeout))
                .setValue(value);
        return new ArrayList<>(getValues().texts());
    }

    /**
     * Clearing the field
     */
    @Step("Clearing the field")
    public void clear() {
        boolean iconClear = getFieldByName()
                .$("span[class=\"ant-select-selection__clear\"]")
                .is(Condition.exist);
        if (iconClear) {
            getFieldByName()
                    .$("span[class=\"ant-select-selection__clear\"]")
                    .shouldBe(Condition.visible, Duration.ofSeconds(waitingForTests.Timeout))
                    .click();
        }
    }

    /**
     * Getting the placeholder text
     *
     * @return String
     */
    @Step("Getting the Placeholder value")
    @Attachment
    public String getPlaceholder() {
        return getFieldByName()
                .$("div[class=\"ant-select-selection__placeholder\"]")
                .shouldBe(Condition.visible, Duration.ofSeconds(waitingForTests.Timeout)).text();
    }
}
