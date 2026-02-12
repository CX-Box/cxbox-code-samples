package core.element.widget.field.attribute.checkable;

import com.codeborne.selenide.Condition;
import core.element.widget.AbstractWidget;
import core.element.widget.field.AbstractField;
import core.expectation.ExpectationPattern;
import io.qameta.allure.Allure;

import java.util.function.Consumer;

import static core.element.widget.AbstractWidget.logTime;


public interface PlaceholderSupportedCheckable<W extends AbstractWidget<ExpectationPattern, W>, VF, SELF extends PlaceholderSupportedCheckable<W, VF, SELF>> extends AbstractField<ExpectationPattern, W, VF, SELF> {

	default SELF checkPlaceholderSupported(Consumer<Boolean> consumer) {
		Allure.step("Getting the Placeholder value", step -> {
			logTime(step);
			boolean isPlaceholder = element()
					.shouldBe(Condition.exist)
					.$(valueTag())
					.getAttribute("placeholder") != null;
			consumer.accept(isPlaceholder);
		});
		return (SELF) this;
	}


}
