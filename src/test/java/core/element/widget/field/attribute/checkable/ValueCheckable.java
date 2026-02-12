package core.element.widget.field.attribute.checkable;

import core.element.widget.AbstractWidget;
import core.element.widget.field.AbstractField;
import core.expectation.ExpectationPattern;

import java.util.function.Consumer;

public interface ValueCheckable<W extends AbstractWidget<ExpectationPattern, W>, VF, SELF extends ValueCheckable<W, VF, SELF>> extends AbstractField<ExpectationPattern, W, VF, SELF> {

	@SuppressWarnings("unchecked")
	default SELF checkValue(Consumer<VF> checkValue) {
		checkValue.accept(getValue());
		return (SELF) this;
	}

}
