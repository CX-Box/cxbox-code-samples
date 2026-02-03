package core.element.widget.field.type.date;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import core.element.widget.AbstractWidget;
import core.element.widget.PlatformIdentifier;
import core.element.widget.field.AbstractFieldImpl;
import core.element.widget.field.FieldType;
import core.element.widget.field.PlatformFieldType;
import core.element.widget.field.attribute.checkable.*;
import core.element.widget.field.attribute.custom.Clear;
import core.element.widget.info.PlatformAdditionalInfoWidget;
import core.element.widget.info.PlatformInfoWidget;
import core.element.widget.list.filter.header.modal.Calendar;
import core.expectation.ExpectationPattern;
import io.qameta.allure.Allure;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

import static core.element.widget.AbstractWidget.logTime;

public class Date<W extends AbstractWidget<ExpectationPattern, W>, SELF extends Date<W, SELF>> extends AbstractFieldImpl<ExpectationPattern, W, LocalDate, SELF> implements
		Clear<W, LocalDate, SELF>,
		ColorCheckable<W, LocalDate, String, SELF>,
		PlaceholderCheckable<W, LocalDate, String, SELF>,
		ReadOnlyCheckable<W, LocalDate, Boolean, SELF>,
		ValueCheckable<W, LocalDate, SELF>,
		DrillDownSupportCheckable<W, LocalDate, Boolean, SELF>,
		DrillDown<W, LocalDate, String, SELF>,
		RequiredCheckable<W, LocalDate, String, SELF>,
		MaxInputCheckable<W, LocalDate, Integer, SELF>,
		PlaceholderSupportedCheckable<W, LocalDate, SELF> {

	final String title;

	public Date(String title, W widget) {
		super(widget, title, PlatformIdentifier.TITLE);
		this.title = title;
	}


	@Override
	public FieldType fieldType() {
		return PlatformFieldType.DATE;
	}

	@Override
	public String valueTag() {
		if (widget().getClass().isAssignableFrom(PlatformInfoWidget.class) || widget().getClass().isAssignableFrom(PlatformAdditionalInfoWidget.class)) {
			return "span[class*='ReadOnlyField'";
		}
		return super.valueTag();
	}

	@Override
	protected SelenideElement parentElement() {
		return widget().element();
	}

	@Override
	public LocalDate getValue() {
		return Allure.step("Getting a value from a field", step -> {
			logTime(step);
			String date;
			if (widget().getClass().isAssignableFrom(PlatformInfoWidget.class) || widget().getClass().isAssignableFrom(PlatformAdditionalInfoWidget.class)) {
				date = element().shouldBe(Condition.exist).$(valueTag()).getText();
			} else {
				date = element().shouldBe(Condition.exist).$(valueTag()).getValue();
			}
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
			return LocalDate.parse(Objects.requireNonNull(date), formatter);
		});
	}

	@SuppressWarnings("unchecked")
	@Override
	public SELF setValue(LocalDate value) {
		return Allure.step("Setting the " + value + " in the field", step -> {
			logTime(step);
			step.parameter("Date  with Seconds", value);
			clear();
			setFocusField();
			Calendar.setDateField(Calendar.formattedDate(value));
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
