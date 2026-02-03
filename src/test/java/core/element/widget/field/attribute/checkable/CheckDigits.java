package core.element.widget.field.attribute.checkable;

import core.element.widget.AbstractWidget;
import core.element.widget.field.AbstractField;
import core.element.widget.field.attribute.value.Digits;
import core.expectation.ExpectationPattern;

import java.util.function.Consumer;

public interface CheckDigits<W extends AbstractWidget<ExpectationPattern, W>, VF, SELF extends CheckDigits<W, VF, SELF>> extends AbstractField<ExpectationPattern, W, VF, SELF>, Digits<W, VF, SELF> {

	default SELF checkDigits(Consumer<Integer> checkDigits) {
		checkDigits.accept(digits());
		return (SELF) this;
	}

	;
}
