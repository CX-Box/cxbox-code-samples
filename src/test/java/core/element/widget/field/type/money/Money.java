package core.element.widget.field.type.money;

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
import lombok.extern.slf4j.Slf4j;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.function.Consumer;

import static com.codeborne.selenide.Selenide.$;
import static core.element.widget.AbstractWidget.logTime;

@Slf4j
public class Money<W extends AbstractWidget<ExpectationPattern, W>, SELF extends Money<W, SELF>> extends AbstractFieldImpl<ExpectationPattern, W, BigDecimal, SELF> implements
		Clear<W, BigDecimal, SELF>,
		ColorCheckable<W, BigDecimal, String, SELF>,
		PlaceholderCheckable<W, BigDecimal, String, SELF>,
		ReadOnlyCheckable<W, BigDecimal, Boolean, SELF>,
		ValueCheckable<W, BigDecimal, SELF>,
		DrillDownSupportCheckable<W, BigDecimal, Boolean, SELF>,
		DrillDown<W, BigDecimal, String, SELF>,
		RequiredCheckable<W, BigDecimal, String, SELF>,
		MaxInputCheckable<W, BigDecimal, Integer, SELF> {

	private final String title;

	public Money(W widget, String title) {
		super(widget, title, PlatformIdentifier.TITLE);
		this.title = title;
	}

	@Override
	public FieldType fieldType() {
		return PlatformFieldType.MONEY;
	}

	@Override
	public BigDecimal getValue() {
		return Allure.step("Getting a value from a field", step -> {
			logTime(step);
			String str = element()
					.shouldBe(Condition.exist)
					.$(valueTag())
					.getValue();

			if (PlatformInfoWidget.class.isAssignableFrom(widget().getClass()) || valueTag().contains("span")) {
				str = element().shouldBe(Condition.exist)
						.$(valueTag())
						.getText();
			}
			str = str.replaceAll("\\s+", "")
					.replace(",", ".")
					.replaceAll("[^\\d.]+", "");

			if (str.isBlank()) {
				return null;
			}
			Integer digits = getDigits();
			if (digits == null || digits <= 0) {
				return new BigDecimal(str);
			}
			return new BigDecimal(str).setScale(digits, RoundingMode.HALF_UP);
		});


	}

	@Override
	public SELF setValue(BigDecimal value) {
		return Allure.step("Setting the " + value + " value in the field", step -> {
			logTime(step);
			step.parameter("BigDecimal", value);

			String str = value.toString();
			String pattern = "^\\d+,\\d+$";
			str = str.replace(".", ",");
			if (!str.matches(pattern)) {
				throw new IllegalArgumentException("The value " + value + " is not a valid " + pattern);
			}
			clear();
			element()
					.$(valueTag())
					.shouldBe(Condition.visible, widget().getExpectations().getTimeout())
					.shouldBe(Condition.editable, widget().getExpectations().getTimeout())
					.setValue(str);
			$("body").click();
			return (SELF) this;
		});

	}


	@Override
	protected SelenideElement parentElement() {
		return widget().element();
	}

	protected Integer getDigits() {
		return Allure.step("Getting the number of digits after the decimal point", step -> {
			logTime(step);
			// this need because we clear with
			if (element().$(valueTag()).getAttribute("digits") == null) {
				return null;
			}
			return Integer.parseInt(element().$(valueTag()).getAttribute("digits"));
		});
	}


	public SELF checkCurrencyValue(Consumer<String> currency) {
		return Allure.step("Check a currencySign in a field", step -> {
			logTime(step);
			String selectorSign = "span";
			if (PlatformInfoWidget.class.isAssignableFrom(widget().getClass())) {
				selectorSign = valueTag();
			}
			String curr = element()
					.$(selectorSign)
					.getText();
			currency.accept(curr);
			return (SELF) this;
		});
	}

	@Override
	public String valueTag() {
		if (PlatformInfoWidget.class.isAssignableFrom(widget().getClass())) {
			return "span[class*=\"ReadOnlyField\"]";
		}
		return super.valueTag();
	}
}
