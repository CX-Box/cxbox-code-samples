package core.element.widget.field.attribute.checkable;

import core.element.widget.AbstractWidget;
import core.element.widget.field.AbstractField;
import core.element.widget.field.attribute.value.Colorable;
import core.expectation.ExpectationPattern;

import java.util.function.Consumer;


public interface ColorCheckable<W extends AbstractWidget<ExpectationPattern, W>, VF, V, SELF extends ColorCheckable<W, VF, V, SELF>> extends AbstractField<ExpectationPattern, W, VF, SELF>, Colorable<W, VF, V, SELF> {

	@SuppressWarnings("unchecked")
	default SELF checkColor(Consumer<V> checkColor) {
		checkColor.accept((V) color());
		return (SELF) this;
	}

}
