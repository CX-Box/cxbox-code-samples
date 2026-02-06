package core.element.widget.field.attribute.checkable;

import com.codeborne.selenide.Condition;
import core.element.widget.AbstractWidget;
import core.element.widget.field.AbstractField;
import core.expectation.ExpectationPattern;
import io.qameta.allure.Allure;

import java.util.function.Consumer;

import static core.element.widget.AbstractWidget.logTime;

public interface ReadOnlyCheckable<W extends AbstractWidget<ExpectationPattern, W>, VF, V, SELF extends ReadOnlyCheckable<W, VF, V, SELF>> extends AbstractField<ExpectationPattern, W, VF, SELF> {

	@SuppressWarnings("unchecked")
	default SELF checkReadOnly(Consumer<Boolean> expectedReadOnly) {
		return Allure.step("Checking the field for \"ReadOnly\"", step -> {
			logTime(step);
		 		boolean disabled = element().$("input")
						.has(Condition.attribute("disabled"));
				expectedReadOnly.accept(disabled);
			return (SELF) this;
		});
	}
}
