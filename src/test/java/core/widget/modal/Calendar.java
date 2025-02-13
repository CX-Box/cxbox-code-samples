package core.widget.modal;

import com.codeborne.selenide.*;
import core.OriginExpectations.CxBoxExpectations;
import io.qameta.allure.Step;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static com.codeborne.selenide.Selenide.$;

@Slf4j
public class Calendar {
    private static final SelenideElement PANEL_CALENDAR = $("div[class=\"ant-calendar-panel\"]");
    static CxBoxExpectations waitingForTests = new CxBoxExpectations();

    /**
     * Initialization of the Calendar window, after opening.
     * If there is no window, click in the field.
     *
     * @param field Field
     */
    @Step("Validating the calendar window")
    public static void findCalendar(SelenideElement field) {
        if (PANEL_CALENDAR.is(Condition.disappear)) {
            field
                    .$("i[aria-label=\"icon: calendar\"]")
                    .shouldBe(Condition.visible, Duration.ofSeconds(waitingForTests.Timeout))
                    .click();
        }
    }

    /**
     * Clearing the calendar
     */
    @Step("Clearing the field in calendar")
    public static void clear() {
        PANEL_CALENDAR
                .$("input")
                .shouldBe(Condition.editable, Duration.ofSeconds(waitingForTests.Timeout))
                .sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.BACK_SPACE);
    }

    /**
     * Setup date
     *
     * @param date LocalDate
     */
    @Step("Setting the {date} in calendar")
    public static void setDate(LocalDate date) {
        PANEL_CALENDAR
                .$("input")
                .shouldBe(Condition.enabled, Duration.ofSeconds(waitingForTests.Timeout))
                .click();
        PANEL_CALENDAR
                .$("input")
                .shouldBe(Condition.enabled, Duration.ofSeconds(waitingForTests.Timeout))
                .setValue(formattedDate(date));
        if (Selenide.$(By.cssSelector("div[data-test-error-popup=\"true\"")).exists()) {
            return;
        }
        PANEL_CALENDAR
                .$("input")
                .shouldBe(Condition.enabled, Duration.ofSeconds(waitingForTests.Timeout))
                .shouldHave(Condition.value(formattedDate(date)));
        PANEL_CALENDAR
                .$("input")
                .shouldBe(Condition.enabled, Duration.ofSeconds(waitingForTests.Timeout))
                .sendKeys(Keys.ENTER);
    }


    /**
     * Set date
     *
     * @param dateTime LocalDateTime
     */
    @Step("Setting the {dateTime} in calendar")
    public static void setDateTime(LocalDateTime dateTime) {
        PANEL_CALENDAR
                .$("input")
                .shouldBe(Condition.enabled, Duration.ofSeconds(waitingForTests.Timeout))
                .click();
        PANEL_CALENDAR
                .$("input")
                .shouldBe(Condition.enabled, Duration.ofSeconds(waitingForTests.Timeout))
                .setValue(formattedDateTime(dateTime));
        if (Selenide.$(By.cssSelector("div[data-test-error-popup=\"true\"")).exists()) {
            return;
        }
        PANEL_CALENDAR
                .$("input")
                .shouldBe(Condition.enabled, Duration.ofSeconds(waitingForTests.Timeout))
                .shouldHave(Condition.value(formattedDateTime(dateTime)));
        PANEL_CALENDAR
                .$("input")
                .shouldBe(Condition.enabled, Duration.ofSeconds(waitingForTests.Timeout))
                .sendKeys(Keys.ENTER);
    }
    /**
     * Set date
     *
     * @param dateTimeWithSeconds LocalDateTime
     */
    @Step("Setting the {dateTimeWithSeconds} in calendar")
    public static void setDateTimeWithSecond(LocalDateTime dateTimeWithSeconds) {
        PANEL_CALENDAR
                .$("input")
                .shouldBe(Condition.enabled, Duration.ofSeconds(waitingForTests.Timeout))
                .click();
        PANEL_CALENDAR
                .$("input")
                .shouldBe(Condition.enabled, Duration.ofSeconds(waitingForTests.Timeout))
                .setValue(formattedDateTimeWithSecond(dateTimeWithSeconds));
        if (Selenide.$(By.cssSelector("div[data-test-error-popup=\"true\"")).exists()) {
            return;
        }
        PANEL_CALENDAR
                .$("input")
                .shouldBe(Condition.enabled, Duration.ofSeconds(waitingForTests.Timeout))
                .shouldHave(Condition.value(formattedDateTimeWithSecond(dateTimeWithSeconds)));
        PANEL_CALENDAR
                .$("input")
                .shouldBe(Condition.enabled, Duration.ofSeconds(waitingForTests.Timeout))
                .sendKeys(Keys.ENTER);
    }

    /**
     * Set the date for today
     */
    @Step("Set the date for today")
    public static void setToday() {
        PANEL_CALENDAR
                .$("a[class=\"ant-calendar-today-btn \"]")
                .shouldBe(Condition.exist, Duration.ofSeconds(waitingForTests.Timeout))
                .click();
    }

    private static SelenideElement getContainer() {
        return PANEL_CALENDAR
                .shouldBe(Condition.exist, Duration.ofSeconds(waitingForTests.Timeout))
                .scrollIntoView("{block: \"center\"}");
    }

    private static ElementsCollection getContainersActions() {
        return getContainer()
                .$$(By.tagName("a"))
                .shouldBe(CollectionCondition.sizeGreaterThan(0));
    }

    private static SelenideElement getButton(String actionName) {
        return getContainersActions()
                .find(Condition.match("check action name: " + actionName, b -> b.getText().equals(actionName)));
    }

    /**
     * Clicking on the button by Name
     *
     * @param actionName Button's name
     */
    @Step("Clicking on the button {actionName} in calendar")
    public static void clickButton(String actionName) {
        SelenideElement button = getButton(actionName);
        button.shouldBe(Condition.enabled, Duration.ofSeconds(waitingForTests.Timeout)).click();
    }

    private static String formattedDate(LocalDate date) {
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
            return date.format(formatter);
        } catch (Exception e) {
            throw new IllegalArgumentException("Некорректный формат даты. Должен быть dd.MM.yyyy");
        }
    }

    private static String formattedDateTime(LocalDateTime date) {
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm");
            return date.format(formatter);
        } catch (Exception e) {
            throw new IllegalArgumentException("Некорректный формат даты. Должен быть dd.MM.yyyy HH:mm");
        }
    }

    private static String formattedDateTimeWithSecond(LocalDateTime date) {
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss");
            return date.format(formatter);
        } catch (Exception e) {
            throw new IllegalArgumentException("Некорректный формат даты. Должен быть dd.MM.yyyy HH:mm:ss");
        }
    }


}
