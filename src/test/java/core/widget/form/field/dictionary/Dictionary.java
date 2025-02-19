package core.widget.form.field.dictionary;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import core.widget.form.FormWidget;
import core.widget.form.field.BaseField;
import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import java.time.Duration;
import java.util.List;

public class Dictionary extends BaseField<String> {
    protected final String MENU_OPTIONS = "div.ant-select-dropdown";

    public Dictionary(FormWidget formWidget, String title) {
        super(formWidget, title, "dictionary");
    }

    @Override
    public String getValueTag() {
        return "input";
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
                .$("span")
                .shouldBe(Condition.exist, Duration.ofSeconds(waitingForTests.Timeout))
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
        getFieldByName().click();
        getOptionDictionary(value)
                .shouldBe(Condition.visible, Duration.ofSeconds(waitingForTests.Timeout))
                .click();
    }

    /**
     * Getting values from a list
     *
     * @return List String
     */
    @Step("Getting a list of options from a drop-down list")
    @Attachment
    public List<String> getOptions() {
        getFieldByName().click();
        return getOptionsDictionary().texts();
    }

    private SelenideElement getOptionDictionary(String value) {
        return getOptionsDictionary()
                .find(Condition.match("check action name: " + value, b -> b.getText().equals(value)))
                .scrollIntoView("{block: \"center\"}");
    }

    private ElementsCollection getOptionsDictionary() {
        return getFieldByName().$(MENU_OPTIONS)
                .shouldBe(Condition.exist, Duration.ofSeconds(waitingForTests.Timeout))
                .$$(By.tagName("li"));
    }

    /**
     * Clearing the field through the cross icon.
     */
    @Step("Clearing the field through the cross icon")
    public void clear() {
        if (getFieldByName()
                .$("i[aria-label=\"icon: close-circle\"]")
                .is(Condition.exist)) {
            getFieldByName()
                    .$("i[aria-label=\"icon: close-circle\"]")
                    .hover();
            getFieldByName()
                    .$("i[aria-label=\"icon: close-circle\"]")
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
                .shouldBe(Condition.visible, Duration.ofSeconds(waitingForTests.Timeout))
                .text();
    }
}
