package core.widget.form.field.picklist;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import core.widget.form.FormWidget;
import core.widget.form.field.BaseField;
import io.qameta.allure.Attachment;
import io.qameta.allure.Step;

import java.time.Duration;
import java.util.List;

import static com.codeborne.selenide.Selenide.$;

public class SuggestionPickList extends BaseField<String> {
    public SuggestionPickList(FormWidget formWidget, String title) {
        super(formWidget, title, "suggestionPickList");
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
     * Setting the in the field
     *
     * @param value String
     */
    @Override
    @Step("Setting the {value} in the field")
    public void setValue(String value) {
        SelenideElement field = getFieldByName()
                .$(getValueTag())
                .shouldBe(Condition.visible, Duration.ofSeconds(waitingForTests.Timeout));
        clear();
        field
                .setValue(value);
        getItems()
                .findBy(Condition.text(value))
                .shouldBe(Condition.visible, Duration.ofSeconds(waitingForTests.Timeout))
                .click();
    }

    @Override
    public String getValueTag() {
        return "input";
    }

    /**
     * Clearing the field
     */
    @Step("Clearing the field")
    public void clear() {
        getFieldByName().click();
        getFieldByName().hover();
        if (getFieldByName()
                .$("i[class=\"anticon anticon-close-circle\"]")
                .is(Condition.visible)) {
            getFieldByName()
                    .$("i[class=\"anticon anticon-close-circle\"]")
                    .shouldBe(Condition.visible, Duration.ofSeconds(waitingForTests.Timeout))
                    .click();
        }

    }

    /**
     * Getting a list of matching options
     *
     * @param value Symbols, which will be searched for
     * @return List(String)
     */
    @Step("Getting a list of matching options by symbols {value}")
    public List<String> getOptions(String value) {
        getFieldByName()
                .$(getValueTag())
                .shouldBe(Condition.visible, Duration.ofSeconds(waitingForTests.Timeout))
                .setValue(value);
        return getItems().texts();
    }

    private ElementsCollection getItems() {
        return $("div[class*=\"rc-select-dropdown SuggestionPickList\"]")
                .shouldBe(Condition.visible, Duration.ofSeconds(waitingForTests.Timeout))
                .$("div[class=\"rc-virtual-list\"]")
                .shouldBe(Condition.visible, Duration.ofSeconds(waitingForTests.Timeout))
                .$$("div[class*=\"rc-select-item rc-select-item-option\"]");
    }
}
