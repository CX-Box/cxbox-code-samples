package core.element.widget.field.attribute.value;

import core.config.Constants;
import core.element.widget.AbstractWidget;
import core.element.widget.field.AbstractField;
import core.element.widget.field.attribute.checkable.ColorCheckable;
import core.expectation.ExpectationPattern;
import io.qameta.allure.Allure;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static core.element.widget.AbstractWidget.logTime;

public interface Colorable<W extends AbstractWidget<ExpectationPattern, W>, VF, V, SELF extends ColorCheckable<W, VF, V, SELF>> extends AbstractField<ExpectationPattern, W, VF, SELF> {

	default String color() {
		return Allure.step("Getting the field color in Hex format", step -> {
			logTime(step);
			String style = getValueByAttribute("style");
			Pattern pattern = Pattern.compile("rgb\\((\\d{1,3}, \\d{1,3}, \\d{1,3})\\)");
			Matcher matcher = pattern.matcher(style);
			if (matcher.find()) {
				String rgb = matcher.group(1);
				String NewRGB = rgb.replaceAll(" ", "");
				String[] strings = NewRGB.split("[,\\\\s]+");
				int[] numbers = new int[strings.length];
				for (int i = 0; i < strings.length; i++) {
					numbers[i] = Integer.parseInt(strings[i]);
				}
				return String.format(Constants.FormatForRgb, numbers[0], numbers[1], numbers[2]);
			}
			return null;
		});
	}

	private String getValueByAttribute(String attribute) {
		return element().find(valueTag()).getAttribute(attribute);
	}

}
