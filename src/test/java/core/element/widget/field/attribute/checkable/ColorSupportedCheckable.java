package core.element.widget.field.attribute.checkable;

import core.element.widget.AbstractWidget;
import core.element.widget.field.AbstractField;
import core.expectation.ExpectationPattern;
import io.qameta.allure.Allure;

import java.util.function.Consumer;
import java.util.regex.Pattern;

import static core.element.widget.AbstractWidget.logTime;

public interface ColorSupportedCheckable<W extends AbstractWidget<ExpectationPattern, W>, VF, SELF extends PlaceholderSupportedCheckable<W, VF, SELF>> extends AbstractField<ExpectationPattern, W, VF, SELF> {

	@SuppressWarnings("unchecked")
	default SELF checkColorSupported(Consumer<Boolean> colorSupported) {
		return Allure.step("Getting the field color in Hex format", step -> {
			logTime(step);
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
