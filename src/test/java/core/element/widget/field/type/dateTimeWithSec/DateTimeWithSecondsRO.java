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
import core.expectation.ExpectationPattern;
import io.qameta.allure.Allure;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;


public class DateTimeWithSecondsRO<W extends AbstractWidget<ExpectationPattern, W>, SELF extends DateTimeWithSecondsRO<W, SELF>> extends AbstractFieldImpl<ExpectationPattern, W, LocalDateTime, SELF> implements
		ColorCheckable<W, LocalDateTime, String, SELF>,
		PlaceholderCheckable<W, LocalDateTime, String, SELF>,
		ReadOnlyCheckable<W, LocalDateTime, Boolean, SELF>,
		ValueCheckable<W, LocalDateTime, SELF>,
		DrillDownSupportCheckable<W, LocalDateTime, Boolean, SELF>,
		RequiredCheckable<W, LocalDateTime, String, SELF>,
		MaxInputCheckable<W, LocalDateTime, Integer, SELF> {


	public DateTimeWithSecondsRO(String title, W widget) {
		super(widget, title, PlatformIdentifier.TITLE);
	}


	@Override
	public FieldType fieldType() {
		return PlatformFieldType.DATE_TIME_WITH_SECONDS_RO;
	}

	@Override
	public LocalDateTime getValue() {
		return StepReport.read(this, () -> {

			String date = element().shouldBe(Condition.exist).$(valueTag()).getText();
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss");
			return LocalDateTime.parse(Objects.requireNonNull(date), formatter);
		});
	}

	@Override
	public SELF setValue(LocalDateTime value) {
		return Allure.step(message("field.set", getFieldIdentifier()), step -> {
			StepReport.value(value);
			return (SELF) this;
		});
	}


	@Override
	protected SelenideElement parentElement() {
		return widget().element();
	}
}
