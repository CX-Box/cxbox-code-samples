package core.widget.list.field.dictionary;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import core.widget.ListHelper;
import core.widget.list.ListWidget;
import core.widget.list.field.BaseRow;

import io.qameta.allure.Step;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;

import java.time.Duration;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.codeborne.selenide.Selenide.$;

@Slf4j
public class Dictionary extends BaseRow<String> {
    protected final String MENU_OPTIONS = "div.ant-select-dropdown";

    public Dictionary(ListWidget listWidget, String title, String id, ListHelper listHelper, Boolean filter, Boolean sort) {
        super(listWidget, title, "dictionary", id, listHelper, filter, sort);
    }

    /**
     * Setting the in the field
     *
     * @param value String
     */
    @Override
    @Step("Setting the {value} in the field")
    public void setValue(String value) {
        setFocusField();
        getRowByName().click();
        getOptionDictionary(value)
                .shouldBe(Condition.visible, Duration.ofSeconds(waitingForTests.Timeout))
                .click();
    }

    /**
     * Getting a value from a field
     *
     * @return String
     */
    @Override
    @Step("Getting a value from a field")
    public String getValue() {
        setFocusField();
        return getRowByName()
                .$("span")
                .shouldBe(Condition.exist, Duration.ofSeconds(waitingForTests.Timeout))
                .text();
    }

    @Override
    public String getValueTag() {
        return "input";
    }

    /**
     * Getting values from a list
     *
     * @return List(String)
     */
    @Step("Getting a list of options from a drop-down list")

    public List<String> getOptions() {
        setFocusField();
        getRowByName().click();
        return getOptionsDictionary().texts();
    }

    private SelenideElement getOptionDictionary(String value) {
        return getOptionsDictionary()
                .find(Condition.match("check action name: " + value, b -> b.getText().equals(value)))
                .scrollIntoView("{block: \"center\"}");
    }

    private ElementsCollection getOptionsDictionary() {
        return $(MENU_OPTIONS)
                .shouldBe(Condition.exist, Duration.ofSeconds(waitingForTests.Timeout))
                .$$(By.tagName("li"));
    }

    /**
     * Clearing the field through the cross icon.
     */
    @Step("Clearing the field")
    public void clear() {
        setFocusField();
        getRowByName()
                .$("i[aria-label=\"icon: close-circle\"]")
                .hover()
                .shouldBe(Condition.enabled, Duration.ofSeconds(waitingForTests.Timeout))
                .click();
    }

    /**
     * Getting the Placeholder test
     *
     * @return String
     */
    @Step("Getting the Placeholder value")

    public String getPlaceholder() {
        setFocusField();
        return getRowByName()
                .$("div[class=\"ant-select-selection__placeholder\"]")
                .shouldBe(Condition.visible, Duration.ofSeconds(waitingForTests.Timeout))
                .text();
    }

    /**
     * Getting the field color in Hex format
     *
     * @return String/null
     */
    @Step("Getting the field color in Hex format")

    public String getHexColor() {
        String color = getValueByAttribute(1, "div", "style");
        Pattern pattern = Pattern.compile("rgb\\((\\d{1,3}, \\d{1,3}, \\d{1,3})\\)");
        Matcher matcher = pattern.matcher(color);

        if (matcher.find()) {
            String rgb = matcher.group(1);
            String NewRGB = rgb.replaceAll(" ", "");
            String[] strings = NewRGB.split("[,\\\\s]+");
            int[] numbers = new int[strings.length];
            for (int i = 0; i < strings.length; i++) {
                numbers[i] = Integer.parseInt(strings[i]);
            }
            return String.format("#%02X%02X%02X", numbers[0], numbers[1], numbers[2]);
        } else {
            return null;
        }
    }

    /**
     * Clicking on a hyperlink in the text.
     * This method is not available for Dictionary
     *
     * @return UnsupportedOperationException
     */
    @Step("Clicking on a hyperlink in the text or by clicking on a special element")

    public Boolean drillDown() {
        throw new UnsupportedOperationException("DrillDown not supported on Dictionary");
    }

    /**
     * Focus on the field/A click in the field..
     */
    @Step("Фокус на сегменте")
    public void setFocusField() {
        try {
            if (getRowByName().$$(By.tagName("div")).size() == 1) {
                getRowByName()
                        .shouldBe(Condition.visible, Duration.ofSeconds(waitingForTests.Timeout))
                        .doubleClick();
            }
        } catch (Throwable t) {
            log.error(String.valueOf(t));
        }

    }
}
