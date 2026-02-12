package core.element.widget.list.filter.header.modal;

import com.codeborne.selenide.*;
import core.expectation.CxBoxExpectations;
import core.expectation.ExpectationPattern;
import io.qameta.allure.Allure;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.stream.IntStream;

import static com.codeborne.selenide.Selenide.$;
import static core.element.widget.AbstractWidget.logTime;

@Slf4j
public class Calendar {

	private static final SelenideElement PANEL_CALENDAR = $("div[class=\"ant-calendar-panel\"]");
	private static final SelenideElement TIME_PANEL_CALENDAR = $("div[class=\"ant-time-picker-panel-inner\"]");
	private static final ExpectationPattern expectationPattern = new CxBoxExpectations();

	/**
	 * Initialization of the Calendar window, after opening.
	 * If there is no window, click in the field.
	 *
	 * @param field Field
	 */
	public static void findCalendar(SelenideElement field) {
		Allure.step("Validating the calendar window", step -> {
			logTime(step);
			step.parameter("Field", field);
			if (PANEL_CALENDAR.is(Condition.disappear)) {
				field
						.$("i[aria-label=\"icon: calendar\"]")
						.shouldBe(Condition.visible, expectationPattern.getTimeout())
						.click();
			}
		});
	}

	/**
	 * Clearing the calendar
	 */
	public static void clear() {
		Allure.step("Clearing the field in calendar", step -> {
			logTime(step);

			PANEL_CALENDAR
					.$("input")
					.shouldBe(Condition.editable, expectationPattern.getTimeout())
					.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.BACK_SPACE);
		});
	}


	/**
	 * Setup date
	 *
	 * @param date LocalDate
	 */
	public static void setDate(LocalDate date) {
		Allure.step("Setting the " + date + " in calendar", step -> {
			logTime(step);
			step.parameter("Date", date);

			PANEL_CALENDAR
					.$("input")
					.shouldBe(Condition.enabled, expectationPattern.getTimeout())
					.click();
			if (Selenide.$(By.cssSelector("div[data-test-error-popup=\"true\"]")).exists()) {
				return;
			}
			PANEL_CALENDAR
					.$("input")
					.shouldBe(Condition.enabled, expectationPattern.getTimeout())
					.setValue(formattedDate(date));

			if (Selenide.$(By.cssSelector("div[data-test-error-popup=\"true\"]")).exists()) {
				return;
			}
			PANEL_CALENDAR
					.$("input")
					.shouldBe(Condition.enabled, expectationPattern.getTimeout())
					.shouldHave(Condition.value(formattedDate(date)));
			if (Selenide.$(By.cssSelector("div[data-test-error-popup=\"true\"]")).exists()) {
				return;
			}
			PANEL_CALENDAR
					.$("input")
					.shouldBe(Condition.enabled, expectationPattern.getTimeout())
					.sendKeys(Keys.ENTER);

		});
	}

	public static void setDateField(String value) {
		Allure.step("Setting the " + value + " in calendar", step -> {
			logTime(step);
			step.parameter(" set value", value);
			if (value == null || value.isBlank()) {
				PANEL_CALENDAR
						.$("input")
						.sendKeys(Keys.TAB, Keys.TAB);
				return;
			}
			PANEL_CALENDAR
					.$("input")
					.shouldBe(Condition.enabled, expectationPattern.getTimeout())
					.click();
			if (Selenide.$(By.cssSelector("div[data-test-error-popup=\"true\"]"))
					.is(Condition.exist, Duration.of(500, ChronoUnit.MILLIS))) {
				return;
			}
			PANEL_CALENDAR
					.$("input")
					.shouldBe(Condition.enabled, expectationPattern.getTimeout())
					.setValue(value);
			if (Selenide.$(By.cssSelector("div[data-test-error-popup=\"true\"]"))
					.is(Condition.exist, Duration.of(500, ChronoUnit.MILLIS))) {
				return;
			}
			PANEL_CALENDAR
					.$("input")
					.shouldBe(Condition.enabled, expectationPattern.getTimeout())
					.shouldHave(Condition.value(value));
			if (Selenide.$(By.cssSelector("div[data-test-error-popup=\"true\"]"))
					.is(Condition.exist, Duration.of(500, ChronoUnit.MILLIS))) {
				return;
			}
			PANEL_CALENDAR
					.$("input")
					.shouldBe(Condition.enabled, expectationPattern.getTimeout())
					.sendKeys(Keys.ENTER);
		});

	}

	public static void setDateField(List<String> value) {
		Allure.step("Setting the " + value + " in calendar", step -> {
			logTime(step);
			step.parameter(" set value", value);
			value.forEach(Calendar::setDateField);
		});

	}

	/**
	 * Set date
	 *
	 * @param value LocalDateTime
	 */
	public static void setDateTimeWithSecond(String value) {
		Allure.step("Setting the " + value + " in calendar", step -> {
			logTime(step);
			step.parameter("LocalDateTime with sec", value);
			if (value == null || value.isBlank()) {
				PANEL_CALENDAR
						.$("input")
						.sendKeys(Keys.TAB, Keys.TAB);
				return;
			}
			PANEL_CALENDAR
					.$("input")
					.shouldBe(Condition.enabled, expectationPattern.getTimeout())
					.click();
			if (Selenide.$(By.cssSelector("div[data-test-error-popup=\"true\"]")).exists()) {
				return;
			}
			PANEL_CALENDAR
					.$("input")
					.shouldBe(Condition.enabled, expectationPattern.getTimeout())
					.setValue(value);

			if (Selenide.$(By.cssSelector("div[data-test-error-popup=\"true\"]")).exists()) {
				return;
			}
			PANEL_CALENDAR
					.$("input")
					.shouldBe(Condition.enabled, expectationPattern.getTimeout())
					.shouldHave(Condition.value(value));
			if (Selenide.$(By.cssSelector("div[data-test-error-popup=\"true\"]")).exists()) {
				return;
			}
			PANEL_CALENDAR
					.$("input")
					.shouldBe(Condition.enabled, expectationPattern.getTimeout())
					.sendKeys(Keys.ENTER);
		});

	}

	public static void setTimeField(String value) {
		setTimeField(value, false);
	}

	public static void setTimeField(String value, boolean isManualButtonClick) {
		Allure.step("Setting the " + value + " in calendar", step -> {
			logTime(step);
			step.parameter("LocalDateTime with sec", value);
			if (value == null || value.isBlank()) {
				PANEL_CALENDAR
						.$("input")
						.sendKeys(Keys.TAB, Keys.TAB);
				return;
			}
			TIME_PANEL_CALENDAR
					.$("input")
					.shouldBe(Condition.enabled, expectationPattern.getTimeout())
					.click();
			if (Selenide.$(By.cssSelector("div[data-test-error-popup=\"true\"]")).exists()) {
				return;
			}
			TIME_PANEL_CALENDAR
					.$("input")
					.shouldBe(Condition.enabled, expectationPattern.getTimeout())
					.setValue(value);
			if (Selenide.$(By.cssSelector("div[data-test-error-popup=\"true\"]")).exists()) {
				return;
			}
			TIME_PANEL_CALENDAR
					.$("input")
					.shouldBe(Condition.enabled, expectationPattern.getTimeout())
					.shouldHave(Condition.value(value));
			if (Selenide.$(By.cssSelector("div[data-test-error-popup=\"true\"]")).exists()) {
				return;
			}
			if (isManualButtonClick) {
				$("div[class='ant-time-picker-panel-addon']").$("button[class*='ant-btn-primary']").click();

			} else {
				TIME_PANEL_CALENDAR
						.$("input")
						.shouldBe(Condition.enabled, expectationPattern.getTimeout())
						.sendKeys(Keys.ENTER);
			}
		});

	}

	public static void setTimeField(List<String> value) {
		Allure.step("Setting the " + value + " in calendar", step -> {
			logTime(step);
			step.parameter(" set value", value);
			IntStream.range(0, value.size())
					.forEach(i -> {
						var val = value.get(i);
						var isExist = $("div[class*='ant-time-picker-panel']").is(Condition.exist, expectationPattern.getTimeout());
						if (!isExist) {
							$("div[class*='TimeRangePicker__container']").$$("span[class='ant-time-picker']").get(i).click();
						}
						setTimeField(val, true);
						$("div[class*='ant-time-picker-panel']").is(Condition.not(Condition.exist), expectationPattern.getTimeout());
					});
			value.forEach(v -> {

			});
		});

	}

	/**
	 * Set the date for today
	 */
	public static void setToday() {
		Allure.step("Set the date for today", step -> {
			logTime(step);

			PANEL_CALENDAR
					.$("a[class=\"ant-calendar-today-btn \"]")
					.shouldBe(Condition.exist, expectationPattern.getTimeout())
					.click();
		});
	}

	private static SelenideElement getContainer() {
		return PANEL_CALENDAR
				.shouldBe(Condition.exist, expectationPattern.getTimeout())
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
	public static void clickButton(String actionName) {
		Allure.step("Clicking on the button " + actionName + " in calendar", step -> {
			logTime(step);
			step.parameter("Button's name", actionName);

			SelenideElement button = getButton(actionName);
			button.shouldBe(Condition.enabled, expectationPattern.getTimeout()).click();
		});

	}

	public static String formattedDate(LocalDate date) {
		try {
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
			return date.format(formatter);
		} catch (Exception e) {
			throw new IllegalArgumentException("Некорректный формат даты. Должен быть dd.MM.yyyy");
		}
	}

	public static String formattedDateTime(LocalDateTime date) {
		try {
			if (date == null) {
				return "";
			}
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm");
			return date.format(formatter);
		} catch (Exception e) {
			throw new IllegalArgumentException("Некорректный формат даты. Должен быть dd.MM.yyyy HH:mm");
		}
	}

	public static String formattedDateTimeWithSecond(LocalDateTime date) {
		try {
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss");
			return date.format(formatter);
		} catch (Exception e) {
			throw new IllegalArgumentException("Некорректный формат даты. Должен быть dd.MM.yyyy HH:mm:ss");
		}
	}

	public static String formattedTimeWithSecond(LocalDateTime date, String format) {
		try {
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern(format);
			return date.format(formatter);
		} catch (Exception e) {
			throw new IllegalArgumentException("Некорректный формат даты. Должен быть dd.MM.yyyy HH:mm:ss");
		}
	}


}
