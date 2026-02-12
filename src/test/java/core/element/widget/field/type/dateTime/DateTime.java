package core.element.widget.field.type.dateTime;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import core.element.widget.AbstractWidget;
import core.element.widget.PlatformIdentifier;
import core.element.widget.field.AbstractFieldImpl;
import core.element.widget.field.FieldType;
import core.element.widget.field.PlatformFieldType;
import core.element.widget.field.attribute.checkable.*;
import core.element.widget.field.attribute.custom.Clear;
import core.element.widget.info.PlatformInfoWidget;
import core.element.widget.list.filter.header.modal.Calendar;
import core.expectation.ExpectationPattern;
import io.qameta.allure.Allure;
import lombok.Getter;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

import static core.element.widget.AbstractWidget.logTime;

@Getter
public class DateTime<W extends AbstractWidget<ExpectationPattern, W>, SELF extends DateTime<W, SELF>> extends AbstractFieldImpl<ExpectationPattern, W, LocalDateTime, SELF> implements
		Clear<W, LocalDateTime, SELF>,
		ColorCheckable<W, LocalDateTime, String, SELF>,
		PlaceholderCheckable<W, LocalDateTime, String, SELF>,
		ReadOnlyCheckable<W, LocalDateTime, Boolean, SELF>,
		ValueCheckable<W, LocalDateTime, SELF>,
		DrillDownSupportCheckable<W, LocalDateTime, Boolean, SELF>,
		DrillDown<W, LocalDateTime, String, SELF>,
		RequiredCheckable<W, LocalDateTime, String, SELF>,
		MaxInputCheckable<W, LocalDateTime, Integer, SELF> {


	public DateTime(W widget, String title) {
		super(widget, title, PlatformIdentifier.TITLE);
	}

	@Override
	public FieldType fieldType() {
		return PlatformFieldType.DATE_TIME;
	}

	@Override
	public LocalDateTime getValue() {
		return Allure.step("Getting a value from a field", step -> {
			logTime(step);
			String date;
			if (widget().getClass().isAssignableFrom(PlatformInfoWidget.class)) {
				date = element().shouldBe(Condition.exist).$(valueTag()).getText();
			} else {
				date = element().shouldBe(Condition.exist).$(valueTag()).getValue();
			}
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm");
			return LocalDateTime.parse(Objects.requireNonNull(date), formatter);
		});
	}

	@Override
	public SELF setValue(LocalDateTime value) {
		return Allure.step("Setting the " + value + " in the field", step -> {
			logTime(step);
			step.parameter("Date  with Seconds", value);
			clear();
			setFocusField();
			Calendar.setDateField(Calendar.formattedDateTime(value));
			return (SELF) this;
		});
	}


	@SuppressWarnings("unchecked")
	@Override
	public SELF clear() {
		return Allure.step("Clearing the field through the cross icon", step -> {
			logTime(step);
			element()
					.$("i[aria-label=\"icon: close-circle\"]")
					.hover()
					.shouldBe(Condition.enabled, widget().getExpectations().getTimeout())
					.click();
			return (SELF) this;
		});
	}


	@Override
	public String valueTag() {
		if (widget().getClass().isAssignableFrom(PlatformInfoWidget.class)) {
			return "span[class*='ReadOnlyField'";
		}
		return super.valueTag();
	}

	@Override
	protected SelenideElement parentElement() {
		return widget().element();
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

}
