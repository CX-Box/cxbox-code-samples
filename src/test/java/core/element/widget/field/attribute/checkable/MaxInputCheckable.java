package core.element.widget.field.attribute.checkable;

import core.element.widget.AbstractWidget;
import core.element.widget.field.AbstractField;
import core.expectation.ExpectationPattern;

import java.util.function.Consumer;

public interface MaxInputCheckable<W extends AbstractWidget<ExpectationPattern, W>, VF, V, SELF extends MaxInputCheckable<W, VF, V, SELF>> extends AbstractField<ExpectationPattern, W, VF, SELF> {

	@SuppressWarnings("unchecked")
	default SELF checkMaxInput(Consumer<V> checkMaxInput) {
		Integer length = getValue().toString().length();
		checkMaxInput.accept((V) length);
		return (SELF) this;
	}

	;
}
