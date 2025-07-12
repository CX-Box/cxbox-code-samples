package core.widget.list.field.date;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import core.widget.ListHelper;
import core.widget.TestingTools.Constants;
import core.widget.list.ListWidget;
import core.widget.list.field.BaseRow;
import core.widget.modal.Calendar;

import io.qameta.allure.Step;
import org.openqa.selenium.By;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.codeborne.selenide.Selenide.$;
import static core.widget.modal.Calendar.formattedDate;

public class Date extends BaseRow<LocalDate> {
    public Date(ListWidget listWidget, String title, String id, ListHelper listHelper, Boolean sort, Boolean filter) {
        super(listWidget, title, "date", id, listHelper, sort, filter);
    }

    private static final SelenideElement PANEL_CALENDAR = $("div[class=\"ant-calendar-panel\"]");

    /**
     * Date input: year, month, day
     *
     * @param value LocalDate
     * {@code example} LocalDate date = LocalDate.of(2024, 20,5)
     */
    @Override
    @Step("Setting the {value} in the field")
    public void setValue(LocalDate value) {
        setFocusField();
        clearIcon();
        getRowByName().click();
        Calendar.setDate(value);
    }

    @Step("Setting the {value} in the field")
    public void setValueManual(LocalDate value) {
        setFocusField();
        clearIcon();
        getRowByName().click();
        PANEL_CALENDAR
                .$("input")
                .shouldBe(Condition.enabled, Duration.ofSeconds(waitingForTests.Timeout))
                .click();
        if (Selenide.$(By.cssSelector("div[data-test-error-popup=\"true\"")).exists()) {
            return;
        }
        PANEL_CALENDAR
                .$("input")
                .shouldBe(Condition.enabled, Duration.ofSeconds(waitingForTests.Timeout))
                .setValue(formattedDate(value));
        Selenide.sleep(200);
        if (Selenide.$(By.cssSelector("div[data-test-error-popup=\"true\"")).exists()) {
            return;
        }
    }

    /**
     * Getting the date in the data type -  LocalDate
     *
     * @return LocalDate date
     */
    @Override
    @Step("Getting a value from a field")
    public LocalDate getValue() {
        setFocusField();
        String date = getRowByName()
                .shouldBe(Condition.exist)
                .$(getValueTag())
                .getValue();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        return LocalDate.parse(Objects.requireNonNull(date), formatter);
    }

    @Override
    public String getValueTag() {
        return "input";
    }

    /**
     * Clearing the field through the cross icon.
     */
    @Step("Clearing the field")
    public void clearIcon() {
        setFocusField();
        getRowByName()
                .$("i[aria-label=\"icon: close-circle\"]")
                .hover()
                .shouldBe(Condition.enabled, Duration.ofSeconds(waitingForTests.Timeout))
                .click();
    }

    /**
     * Getting the field color in Hex format
     *
     * @return String/null
     */
    @Step("Getting the field color in Hex format")
    public String getHexColor() {
        setFocusField();
        String color = getValueByAttribute(1, "span", "style");
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
            return String.format(Constants.FormatForRgb, numbers[0], numbers[1], numbers[2]);
        } else {
            return null;
        }
    }
}
