package core.element.widget.field.type.dateTimeWithSec;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import core.config.Constants;
import core.element.widget.field.FieldType;
import core.element.widget.field.PlatformFieldType;
import core.element.widget.field.type.ParentRow;
import core.element.widget.list.ListWidget;
import core.element.widget.list.realization.inline.list.PlatformListRowInline;
import core.element.widget.list.rows.PlatformRows;
import core.element.widget.list.rows.row.PlatformRow;
import io.qameta.allure.Allure;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;
import java.util.function.Consumer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.codeborne.selenide.Selenide.$;
import static core.element.widget.AbstractWidget.logTime;

@Slf4j
public class ListDateTimeWithSeconds<
		W extends ListWidget<W, RR, R>,
		RR extends PlatformRows<RR, W, R>,
		R extends PlatformRow<R, RR, W>
		>
		extends DateTimeWithSeconds<W, ListDateTimeWithSeconds<W, RR, R>> implements ParentRow<R> {

	private static final SelenideElement PANEL_CALENDAR = $("div[class=\"ant-calendar-panel\"]");
	private static final String REQUIRED_MESSAGE = "div[class=\"ant-tooltip-inner\"]";
	final R row;
	String title;

	public ListDateTimeWithSeconds(String title, W widget, R row) {
		super(title, widget);
		this.row = row;
		this.title = title;
	}

	private static String formattedDateTimeWithSecond(LocalDateTime date) {
		try {
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss");
			return date.format(formatter);
		} catch (Exception e) {
			throw new IllegalArgumentException("Incorrect date format. Must be  dd.MM.yyyy HH:mm:ss");
		}
	}

	@Override
	public FieldType fieldType() {
		return PlatformFieldType.DATE_TIME_WITH_SECONDS_LIST;
	}

	@Override
	public LocalDateTime getValue() {
		return Allure.step("Getting a value from a field", step -> {
			logTime(step);
			element();
			String date = getUniversalText(element().shouldBe(Condition.exist).find(valueTag()));
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss");
			return LocalDateTime.parse(Objects.requireNonNull(date), formatter);
		});
	}

	@Override
	public ListDateTimeWithSeconds<W, RR, R> setValue(LocalDateTime value) {
		Allure.step("Setting the " + value + " in calendar", step -> {
			logTime(step);
			clear();
			setFocusField();
			step.parameter("LocalDateTime with sec", value);
			PANEL_CALENDAR
					.$("input")
					.shouldBe(Condition.enabled, widget().getExpectations().getTimeout())

					.click();
			if (Selenide.$(By.cssSelector("div[data-test-error-popup=\"true\"]")).exists()) {
				return;
			}
			PANEL_CALENDAR
					.$("input")
					.shouldBe(Condition.enabled, widget().getExpectations().getTimeout())

					.setValue(formattedDateTimeWithSecond(value));
			if (Selenide.$(By.cssSelector("div[data-test-error-popup=\"true\"]")).exists()) {
				return;
			}
			PANEL_CALENDAR
					.$("input")
					.shouldBe(Condition.enabled, widget().getExpectations().getTimeout())
					.shouldHave(Condition.value(formattedDateTimeWithSecond(value)));
			if (Selenide.$(By.cssSelector("div[data-test-error-popup=\"true\"]")).exists()) {
				return;
			}
			PANEL_CALENDAR
					.$("input")
					.shouldBe(Condition.enabled, widget().getExpectations().getTimeout())
					.sendKeys(Keys.ENTER);
		});
		return this;
	}

	@Override
	protected SelenideElement parentElement() {
		return row().element();
	}

	private void setFocusField() {
		Allure.step("Focus on the field", step -> {
			logTime(step);
			element()
					.$(valueTag())
					.shouldBe(Condition.enabled, widget().getExpectations().getTimeout())
					.click();
		});
	}

	public String valueTag() {
		if (row instanceof PlatformListRowInline ri) {
			if (!ri.getIsEdit()) {
				return "span[class*=\"ReadOnlyField\"]";
			}
		}
		return super.valueTag();
	}

	@Override
	public ListDateTimeWithSeconds<W, RR, R> checkColor(Consumer<String> checkColor) {
		return Allure.step("Getting the field color in Hex format", step -> {
			String color = element().$("span").getAttribute("style");
			Pattern pattern = Pattern.compile("rgb\\((\\d{1,3}, \\d{1,3}, \\d{1,3})\\)");
			Matcher matcher = pattern.matcher(color);
			String actualColor = null;
			if (matcher.find()) {
				String rgb = matcher.group(1);
				String NewRGB = rgb.replaceAll(" ", "");
				String[] strings = NewRGB.split("[,\\\\s]+");
				int[] numbers = new int[strings.length];
				for (int i = 0; i < strings.length; i++) {
					numbers[i] = Integer.parseInt(strings[i]);
				}
				actualColor = String.format(Constants.FormatForRgb, numbers[0], numbers[1], numbers[2]);
			}
			checkColor.accept(actualColor);
			return this;
		});
	}

	@Override
	public ListDateTimeWithSeconds<W, RR, R> clear() {
		return Allure.step("Clearing the field through the cross icon", step -> {
			logTime(step);
			element()
					.$("i[aria-label=\"icon: close-circle\"]")

					.hover()
					.shouldBe(Condition.enabled, widget().getExpectations().getTimeout())
					.click();
			return this;
		});
	}

	private ListDateTimeWithSeconds<W, RR, R> clearWithInput() {
		return Allure.step("Clearing the field through the input value", step -> {
			logTime(step);
			element()
					.$("i[aria-label=\"icon: close-circle\"]")

					.hover()
					.shouldBe(Condition.enabled, widget().getExpectations().getTimeout())
					.click();
			return this;
		});
	}

	@Override
	public ListDateTimeWithSeconds<W, RR, R> checkRequired(Consumer<String> checkRequired) {
		return Allure.step("Get validation message", step -> {
			logTime(step);
			Selenide.actions()
					.moveToElement($("body"))
					.perform();
			element()
					.shouldBe(Condition.visible, widget().getExpectations().getTimeout())
					.$("div.ant-row.ant-form-item")
					.hover();
			element()
					.$(REQUIRED_MESSAGE)
					.shouldBe(Condition.visible, widget().getExpectations().getTimeout())
					.text()
					.replace(title, "");
			return this;
		});
	}

	public R row() {
		return row;
	}


}
