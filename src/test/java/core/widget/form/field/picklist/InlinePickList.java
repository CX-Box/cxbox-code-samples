package core.widget.form.field.picklist;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import core.widget.form.FormWidget;
import core.widget.form.field.BaseField;
import io.qameta.allure.Allure;
import io.qameta.allure.Attachment;
import org.openqa.selenium.By;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import static com.codeborne.selenide.Selenide.$;
import static core.widget.TestingTools.CellProcessor.logTime;

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
    @Attachment
    public String getValue() {
        return Allure.step("Getting a value from a field", step -> {
            logTime(step);
            return getFieldByName()
                    .$("div[class=\"ant-select-selection-selected-value\"]")
                    .shouldBe(Condition.visible, Duration.ofSeconds(waitingForTests.Timeout))
                    .text();
        });

    }

    /**
     * Setting the in the field
     *
     * @param value String
     */
    @Override
    public void setValue(String value) {
        Allure.step("Setting the " + value + " in the field", step -> {
            logTime(step);
            step.parameter("PickList", value);

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
        });

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
    @Attachment
    public List<String> getValueInList(String value) {
        return Allure.step("Getting a list of options via a character match", step -> {
            logTime(step);
            step.parameter("Symbol", value);

            getFieldByName()
                    .$("div[class=\"ant-select-selection-selected-value\"]")
                    .shouldBe(Condition.enabled, Duration.ofSeconds(waitingForTests.Timeout))
                    .click();
            getFieldByName()
                    .$(getValueTag())
                    .shouldBe(Condition.enabled, Duration.ofSeconds(waitingForTests.Timeout))
                    .setValue(value);
            return new ArrayList<>(getValues().texts());
        });
    }

    /**
     * Clearing the field
     */
    public void clear() {
        Allure.step("Clearing the field", step -> {
            logTime(step);

            boolean iconClear = getFieldByName()
                    .$("span[class=\"ant-select-selection__clear\"]")
                    .is(Condition.exist);
            if (iconClear) {
                getFieldByName()
                        .$("span[class=\"ant-select-selection__clear\"]")
                        .shouldBe(Condition.visible, Duration.ofSeconds(waitingForTests.Timeout))
                        .click();
            }
        });
    }

    /**
     * Getting the placeholder text
     *
     * @return String
     */
    @Attachment
    public String getPlaceholder() {
        return Allure.step("Getting the Placeholder value", step -> {
            logTime(step);

            return getFieldByName()
                    .$("div[class=\"ant-select-selection__placeholder\"]")
                    .shouldBe(Condition.visible, Duration.ofSeconds(waitingForTests.Timeout)).text();
        });
    }
}
