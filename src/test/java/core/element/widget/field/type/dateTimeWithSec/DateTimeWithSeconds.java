package core.element.widget.field.type.dateTimeWithSec;

import core.util.report.StepReport;
import static core.util.i18n.CoreMessageSource.message;

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
import core.expectation.ExpectationPattern;
import io.qameta.allure.Allure;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;


public class DateTimeWithSeconds<W extends AbstractWidget<ExpectationPattern, W>, SELF extends DateTimeWithSeconds<W, SELF>> extends AbstractFieldImpl<ExpectationPattern, W, LocalDateTime, SELF> implements
		Clear<W, LocalDateTime, SELF>,
		ColorCheckable<W, LocalDateTime, String, SELF>,
		PlaceholderCheckable<W, LocalDateTime, String, SELF>,
		ReadOnlyCheckable<W, LocalDateTime, Boolean, SELF>,
		ValueCheckable<W, LocalDateTime, SELF>,
		DrillDownSupportCheckable<W, LocalDateTime, Boolean, SELF>,
		RequiredCheckable<W, LocalDateTime, String, SELF>,
		MaxInputCheckable<W, LocalDateTime, Integer, SELF> {

	public DateTimeWithSeconds(String title, W widget) {
		super(widget, title, PlatformIdentifier.TITLE);

	}


	@Override
	public FieldType fieldType() {
		return PlatformFieldType.DATE_TIME_WITH_SECONDS;
	}

	@Override
	public LocalDateTime getValue() {
		return StepReport.read(this, () -> {

			String date = element().shouldBe(Condition.exist).$(valueTag()).getValue();
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss");
			return LocalDateTime.parse(Objects.requireNonNull(date), formatter);
		});
	}

	@Override
	public SELF setValue(LocalDateTime value) {
		return Allure.step(message("field.set", getFieldIdentifier()), step -> {
			StepReport.value(value);
			clear();
			setFocusField();
			Calendar.setDateField(Calendar.formattedDateTimeWithSecond(value));
			return (SELF) this;
		});
	}

	@Override
	protected SelenideElement parentElement() {
		return widget().element();
	}


	@Override
	public SELF clear() {
		if (!element().$("i[aria-label=\"icon: close-circle\"]").exists()) {
			return (SELF) this;
		}
		return StepReport.service(message("field.clearCross", getFieldIdentifier()), () -> {
			element()
					.$("i[aria-label=\"icon: close-circle\"]")
					.hover()
					.shouldBe(Condition.interactable, widget().getExpectations().getTimeout())
					.click();
			return (SELF) this;
		});
	}

	private void setFocusField() {
		StepReport.service(message("field.focus", getFieldIdentifier()), () -> {
			element()
					.$(valueTag())
					.shouldBe(Condition.interactable, widget().getExpectations().getTimeout())
					.click();
		});
	}


}
