package core.widget.filter.filter;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import core.widget.ListHelper;
import org.openqa.selenium.By;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.$;

public class DictionaryFilter extends AbstractFilter<String> {
    public DictionaryFilter(String columnType, String columnName, ListHelper helper) {
        super(columnType, columnName, helper);
    }

    @Override
    public void setFilter(String value) {
        getOptionDictionary(value)
                .shouldBe(Condition.enabled, Duration.ofSeconds(waitingForTests.Timeout))
                .$(By.tagName("label"))
                .click();
        setApply();
    }

    @Override
    public String getTypeFilter() {
        return "dictionary";
    }

    private SelenideElement getOptionDictionary(String value) {
        return getOptionsDictionary()
                .find(Condition.match("check action name: " + value, b -> b.getText().equals(value)))
                .scrollIntoView("{block: \"center\"}");
    }

    private ElementsCollection getOptionsDictionary() {
        return $("form[class=\"ant-form ant-form-vertical\"]")
                .$$(By.tagName("li"));
    }

    public void setApply() {
        $("div[class=\"ant-popover-inner-content\"]")
                .$("button[data-test-filter-popup-apply=\"true\"]")
                .shouldBe(Condition.visible)
                .click();
    }
}
