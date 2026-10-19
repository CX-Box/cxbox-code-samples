package core.element.widget.field.attribute.checkable;

import static core.util.i18n.CoreMessageSource.message;

import core.element.widget.AbstractWidget;
import core.element.widget.field.AbstractField;
import core.expectation.ExpectationPattern;
import io.qameta.allure.Allure;

import java.util.function.Consumer;
import java.util.regex.Pattern;


public interface ColorSupportedCheckable<W extends AbstractWidget<ExpectationPattern, W>, VF, SELF extends PlaceholderSupportedCheckable<W, VF, SELF>> extends AbstractField<ExpectationPattern, W, VF, SELF> {

	@SuppressWarnings("unchecked")
	default SELF checkColorSupported(Consumer<Boolean> colorSupported) {
		return Allure.step(message("field.color", getFieldIdentifier()), step -> {
			String style = getValueByAttribute("style");
			Pattern pattern = Pattern.compile("rgb\\((\\d{1,3}, \\d{1,3}, \\d{1,3})\\)");
			colorSupported.accept(pattern.matcher(style).matches());
			return (SELF) this;
		});
	}

	private String getValueByAttribute(String attribute) {
		return element().find(valueTag()).getAttribute(attribute);
	}
}
