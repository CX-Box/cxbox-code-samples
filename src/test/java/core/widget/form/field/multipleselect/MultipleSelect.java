package core.widget.form.field.multipleselect;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import core.widget.form.FormWidget;
import core.widget.form.field.BaseField;
import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import lombok.NonNull;
import org.apache.commons.lang3.tuple.Pair;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import java.time.Duration;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static com.codeborne.selenide.Selenide.$;

public class MultipleSelect extends BaseField<Set<String>> {

    public MultipleSelect(FormWidget formWidget, String title) {
        super(formWidget, title, "multipleSelect");
    }

    /**
     * Getting a list of selected options from a field
     *
     * @return List String [e1,e2,...en]
     */
    @Override
    @Step("Getting a value from a field")
    @Attachment
    public Set<String> getValue() {
        List<String> list = getFieldByName()
                .shouldBe(Condition.exist, Duration.ofSeconds(waitingForTests.Timeout))
                .$$("li[class=\"ant-select-selection__choice\"]").texts();
        return new HashSet<>(list);
    }

    /**
     * Set values from the list. The values that have already been set are removed
     *
     * @param values Set<String>
     */
    @Override
    @Step("Setting the {value} in the field")
    public void setValue(@NonNull Set<String> values) {
        clear();
        addValue(values);
    }

    /**
     * Add values from the list. The values that have already been set are saved
     *
     * @param values Set(String)
     */
    @Step("Setting the {values} in the field")
    public void addValue(@NonNull Set<String> values) {
        getFieldByName().click();
        values.forEach(value -> {
            if (!isSelected(value)) {
                getOption(value)
                        .shouldBe(Condition.enabled, Duration.ofSeconds(waitingForTests.Timeout))
                        .click();
            }
        });
        $("body").sendKeys(Keys.ESCAPE);
    }

    /**
     * Requesting the value of a selected parameter from the list
     *
     * @param option String
     * @return Boolean true/false
     */
    @Step("Getting the option status {option}")
    public Boolean getStatusOption(String option) {
        getFieldByName().click();
        return isSelected(option);
    }


    public String getValueTag() {
        return "input";
    }

    private Boolean isSelected(String option) {
        return Boolean.parseBoolean(getOption(option).getAttribute("aria-selected"));
    }

    /**
     * Getting a list of options
     *
     * @return List String
     */
    @Step("Getting a list of options")
    @Attachment
    public List<String> getOptions() {
        getFieldByName().click();
        return getOptionsMultipleSelect().texts();
    }

    /**
     * Clearing the field
     */
    @Step("Clearing the field")
    public void clear() {
        ElementsCollection closeX = getFieldByName()
                .shouldBe(Condition.exist, Duration.ofSeconds(waitingForTests.Timeout))
                .$$("i[aria-label=\"icon: close\"]");
        for (int i = 0; i <= closeX.size(); i++) {
            if (closeX.get(i).is(Condition.exist)) {
                closeX.get(i).click();
            }
        }
        $("body").sendKeys(Keys.ESCAPE);
    }

    private SelenideElement getOption(String nameRadio) {
        return getOptionsMultipleSelect().find(Condition.match("check action name: " + nameRadio, b -> b.getText().equals(nameRadio)));
    }

    /**
     * Getting a list of options and status
     *
     * @return Pair (String, Boolean)
     */
    @Step("Getting a list of options and status")
    @Attachment
    public List<Pair<String, Boolean>> getStatusOptions() {
        List<String> list = getOptionsMultipleSelect().texts();
        List<Pair<String, Boolean>> pairs = new ArrayList<Pair<String, Boolean>>();
        for (int i = 0; i < list.size(); i++) {
            pairs.add(Pair.of(getOptionsMultipleSelect().get(i).text(), isSelected(list.get(i))));
        }
        return pairs;
    }

    private ElementsCollection getOptionsMultipleSelect() {
        return $("div[class^=\"ant-select-dropdown MultipleSelectField__dropDownMenu\"]")
                .shouldBe(Condition.exist, Duration.ofSeconds(waitingForTests.Timeout))
                .$$(By.tagName("li"));
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
                .shouldBe(Condition.visible, Duration.ofSeconds(waitingForTests.Timeout))
                .text();
    }
}
