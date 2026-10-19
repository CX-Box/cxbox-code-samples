package core.element.widget.field.type.number;

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
import core.element.widget.info.PlatformInfoWidget;
import core.expectation.ExpectationPattern;
import io.qameta.allure.Allure;

import java.math.BigDecimal;
import java.util.Objects;


public class Number<W extends AbstractWidget<ExpectationPattern, W>, SELF extends Number<W, SELF>> extends AbstractFieldImpl<ExpectationPattern, W, BigDecimal, SELF> implements
		Clear<W, BigDecimal, SELF>,
		ColorCheckable<W, BigDecimal, String, SELF>,
		PlaceholderCheckable<W, BigDecimal, String, SELF>,
		ReadOnlyCheckable<W, BigDecimal, Boolean, SELF>,
		ValueCheckable<W, BigDecimal, SELF>,
		DrillDownSupportCheckable<W, BigDecimal, Boolean, SELF>,
		RequiredCheckable<W, BigDecimal, String, SELF>,
		MaxInputCheckable<W, BigDecimal, Integer, SELF>,
		CheckDigits<W, BigDecimal, SELF> {

	private final String title;

	public Number(W widget, String title) {
		super(widget, title, PlatformIdentifier.TITLE);
		this.title = title;
	}

	@Override
	public FieldType fieldType() {
		return PlatformFieldType.NUMBER;
	}

	@Override
	public BigDecimal getValue() {
		return StepReport.read(this, () -> {
			String str = getUniversalText(element()
					.shouldBe(Condition.exist)
					.$(valueTag()));
			str = str.replaceAll("\\s+", "")
					.replace(",", ".")
					.replaceAll("[^\\d.]+", "");
			if (str.isBlank()) {
				return null;
			}
			return new BigDecimal(str);
		});
	}

	@Override
	public SELF setValue(BigDecimal value) {
		Allure.step(message("field.set", getFieldIdentifier()), step -> {
			StepReport.value(value);

			element().click();
			typeOver(element().$(valueTag()).shouldBe(Condition.interactable, widget().getExpectations().getTimeout()), Objects.toString(value, ""));
		});

		return (SELF) this;
	}


	protected SelenideElement parentElement() {
		return widget().element();
	}

	@Override
	public String valueTag() {
		if (PlatformInfoWidget.class.isAssignableFrom(widget().getClass())) {
			return "span[class*='ReadOnlyField__readOnlyField']";
		}
		return super.valueTag();
	}
}

