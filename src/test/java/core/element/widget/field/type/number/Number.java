package core.element.widget.field.type.number;

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
import org.openqa.selenium.Keys;

import java.math.BigDecimal;

import static core.element.widget.AbstractWidget.logTime;

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
		return Allure.step("Getting a value from a field", step -> {
			logTime(step);
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
		Allure.step("Setting the " + value + " value in the field", step -> {
			logTime(step);
			step.parameter("Number", value);

			element().click();
			element()
					.$(valueTag())
					.shouldBe(Condition.enabled, widget().getExpectations().getTimeout())
					.clear();
			element()
					.$(valueTag())
					.shouldBe(Condition.enabled, widget().getExpectations().getTimeout())
					.setValue(String.valueOf(value));
			element()
					.$(valueTag())
					.sendKeys(Keys.TAB);
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

