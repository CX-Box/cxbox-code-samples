package core.element.widget.field.attribute.value;

import static core.util.i18n.CoreMessageSource.message;

import core.element.widget.AbstractWidget;
import core.element.widget.field.AbstractField;
import core.expectation.ExpectationPattern;
import io.qameta.allure.Allure;


public interface Digits<W extends AbstractWidget<ExpectationPattern, W>, VF, SELF extends Digits<W, VF, SELF>> extends AbstractField<ExpectationPattern, W, VF, SELF> {
	default Integer digits() {
		return Allure.step(message("field.digits", getFieldIdentifier()), step -> {
			// this need because we clear with
			if (element().$(valueTag()).getAttribute("digits") == null) {
				return null;
			}
			return Integer.parseInt(element().$(valueTag()).getAttribute("digits"));
		});
	}
}
