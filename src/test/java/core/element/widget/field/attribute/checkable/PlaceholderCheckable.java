package core.element.widget.field.attribute.checkable;

import static core.util.i18n.CoreMessageSource.message;

import com.codeborne.selenide.Condition;
import core.element.widget.AbstractWidget;
import core.element.widget.field.AbstractField;
import core.expectation.ExpectationPattern;
import io.qameta.allure.Allure;

import java.util.function.Consumer;


public interface PlaceholderCheckable<W extends AbstractWidget<ExpectationPattern, W>, VF, V, SELF extends PlaceholderCheckable<W, VF, V, SELF>> extends AbstractField<ExpectationPattern, W, VF, SELF> {


	@SuppressWarnings("unchecked")
	default SELF checkPlaceholder(Consumer<V> expectedPlaceholder) {
		Allure.step(message("field.placeholder", getFieldIdentifier()), step -> {
			V actualPlaceholder = (V) element()
					.shouldBe(Condition.exist)
					.$(valueTag())
					.getAttribute("placeholder");
			expectedPlaceholder.accept(actualPlaceholder);
		});
		return (SELF) this;
	}

}
