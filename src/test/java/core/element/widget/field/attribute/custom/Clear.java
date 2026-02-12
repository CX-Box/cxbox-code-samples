package core.element.widget.field.attribute.custom;

import com.codeborne.selenide.Condition;
import core.element.widget.AbstractWidget;
import core.element.widget.field.AbstractField;
import core.expectation.ExpectationPattern;
import io.qameta.allure.Allure;
import org.openqa.selenium.Keys;

import static core.element.widget.AbstractWidget.logTime;


public interface Clear<W extends AbstractWidget<ExpectationPattern, W>, VF, SELF extends Clear<W, VF, SELF>> extends AbstractField<ExpectationPattern, W, VF, SELF> {
	private static Keys getModifierKey() {
		String os = System.getProperty("os.name").toLowerCase();
		return os.contains("mac") ? Keys.COMMAND : Keys.CONTROL;
	}

	@SuppressWarnings("unchecked")
	default SELF clear() {
		return Allure.step("Clearing the field", step -> {
			logTime(step);
			element()
					.$(valueTag())
					.shouldBe(Condition.enabled, widget().getExpectations().getTimeout())
					.click();
			if (getValue() == null) {
				return (SELF) this;
			}
			element().$(valueTag()).sendKeys(Keys.chord(getModifierKey(), "a"), Keys.BACK_SPACE);
//			while (sizeText>0) {
//				CharSequence[] sequence = new CharSequence[sizeText+1];
//				Arrays.fill(sequence, 0, sizeText+1 , Keys.BACK_SPACE);
//				element()
//						.$(valueTag())
//						.shouldBe(Condition.enabled, widget().getExpectations().getTimeout())
//						.sendKeys(sequence);
//				sizeText = Optional.ofNullable(getValue()).map(Objects::toString).map(String::length).orElse(0);
//			}
			return (SELF) this;
		});

	}

}
