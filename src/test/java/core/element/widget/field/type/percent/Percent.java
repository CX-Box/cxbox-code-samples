package core.element.widget.field.type.percent;

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


public class Percent<W extends AbstractWidget<ExpectationPattern, W>, SELF extends Percent<W, SELF>> extends AbstractFieldImpl<ExpectationPattern, W, BigDecimal, Percent<W, SELF>> implements
		Clear<W, BigDecimal, Percent<W, SELF>>,
		ColorCheckable<W, BigDecimal, String, Percent<W, SELF>>,
		PlaceholderCheckable<W, BigDecimal, String, Percent<W, SELF>>,
		ReadOnlyCheckable<W, BigDecimal, Boolean, Percent<W, SELF>>,
		ValueCheckable<W, BigDecimal, Percent<W, SELF>>,
		DrillDownSupportCheckable<W, BigDecimal, Boolean, Percent<W, SELF>>,
		RequiredCheckable<W, BigDecimal, String, Percent<W, SELF>>,
		MaxInputCheckable<W, BigDecimal, Integer, Percent<W, SELF>> {

	private final String title;

	public Percent(W widget, String title) {
		super(widget, title, PlatformIdentifier.TITLE);
		this.title = title;
	}

	@Override
	public FieldType fieldType() {
		return PlatformFieldType.PERCENT;
	}

	@Override
	public BigDecimal getValue() {
		return StepReport.read(this, () -> {

			String str = getUniversalText(element()
					.shouldBe(Condition.exist)
					.$(valueTag()));
			str = Objects.requireNonNull(str)
					.replace("%", "")
					.replaceAll(",", ".")
					.replaceAll(" ", "")
					.replaceAll(" ", "");
			return new BigDecimal(str);
		});
	}

	@Override
	public Percent<W, SELF> setValue(BigDecimal value) {
		Allure.step(message("field.set", getFieldIdentifier()), step -> {
			StepReport.value(value);

			// the field is looked up once: each look up waits for the widget
			var field = element();
			field.click();
			typeOver(field.$(valueTag()).shouldBe(Condition.interactable, widget().getExpectations().getTimeout()), Objects.toString(value, ""));
		});
		return this;
	}

	@Override
	public String valueTag() {
		if (PlatformInfoWidget.class.isAssignableFrom(widget().getClass())) {
			return "span[class*=\"ReadOnlyField\"]";
		}
		return super.valueTag();
	}

	@Override
	protected SelenideElement parentElement() {
		return widget().element();
	}

}
