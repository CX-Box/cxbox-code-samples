package core.element.widget.field.type.time;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import core.element.widget.AbstractWidget;
import core.element.widget.PlatformIdentifier;
import core.element.widget.field.AbstractFieldImpl;
import core.element.widget.field.FieldType;
import core.element.widget.field.PlatformFieldType;
import core.element.widget.field.attribute.checkable.*;
import core.element.widget.field.attribute.custom.Clear;
import core.element.widget.list.filter.header.modal.Calendar;
import core.element.widget.type.PlatformTypeWidgets;
import core.expectation.ExpectationPattern;
import io.qameta.allure.Allure;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import static core.element.widget.AbstractWidget.logTime;

@Slf4j
public class Time<W extends AbstractWidget<ExpectationPattern, W>, SELF extends Time<W, SELF>> extends AbstractFieldImpl<ExpectationPattern, W, LocalDateTime, SELF> implements
		Clear<W, LocalDateTime, SELF>,
		ColorCheckable<W, LocalDateTime, String, SELF>,
		PlaceholderCheckable<W, LocalDateTime, String, SELF>,
		ReadOnlyCheckable<W, LocalDateTime, Boolean, SELF>,
		ValueCheckable<W, LocalDateTime, SELF>,
		DrillDownSupportCheckable<W, LocalDateTime, Boolean, SELF>,
		RequiredCheckable<W, LocalDateTime, String, SELF>,
		MaxInputCheckable<W, LocalDateTime, Integer, SELF> {

	private final String title;

	@Getter(AccessLevel.PROTECTED)
	private String format;

	public Time(W widget, String title, String format) {
		super(widget, title, PlatformIdentifier.TITLE);
		this.title = title;
		this.format = format;
	}

	@Override
	public FieldType fieldType() {
		return PlatformFieldType.TIME;
	}

	@Override
	public LocalDateTime getValue() {
		return Allure.step("Getting time value from the field", step -> {
			logTime(step);
			log.info("Getting time value from the field {}", format);
			String time = getUniversalText(element()
					.shouldBe(Condition.exist, widget().getExpectations().getTimeout())
					.$(valueTag()));

			LocalTime times = LocalTime.parse(time, DateTimeFormatter.ofPattern(format));
			LocalDateTime dateTime = times.atDate(LocalDate.MIN);
			return dateTime;
		});
	}

	@Override
	public SELF setValue(LocalDateTime value) {
		return Allure.step("Setting the " + value + " in the field", step -> {
			logTime(step);
			step.parameter("Date  with Seconds", value);
			clear();
			setFocusField();
			Calendar.setTimeField(value.format(DateTimeFormatter.ofPattern(format)));
			return (SELF) this;
		});
	}

	@Override
	protected SelenideElement parentElement() {
		return widget().element();
	}

	@Override
	public String valueTag() {
		if (widget().getType().equals(PlatformTypeWidgets.INFO) || widget().getType().equals(PlatformTypeWidgets.ADDITIONAL_INFO)) {

			return "span[class*=\"ReadOnlyField\"]";
		}
		return super.valueTag();
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

	@Override
	public SELF clear() {
		Allure.step("Clearing the time field using cross icon", step -> {
			logTime(step);

			element()
					.$("i[aria-label=\"icon: close-circle\"]")
					.hover()
					.shouldBe(Condition.enabled, widget().getExpectations().getTimeout())
					.click();
		});
		return (SELF) this;
	}
}
