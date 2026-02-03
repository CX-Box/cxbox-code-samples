package core.element.widget.field.type.text;

import core.element.widget.AbstractWidget;
import core.element.widget.field.FieldType;
import core.element.widget.field.PlatformFieldType;
import core.element.widget.field.type.input.Input;
import core.element.widget.info.PlatformInfoWidget;
import core.expectation.ExpectationPattern;

public class Text<W extends AbstractWidget<ExpectationPattern, W>, SELF extends Text<W, SELF>> extends Input<W, SELF> {

	public Text(W widget, String title) {
		super(widget, title);
	}

	@Override
	public FieldType fieldType() {
		return PlatformFieldType.TEXT;
	}

	@Override
	public String valueTag() {
		if (widget() instanceof PlatformInfoWidget) {
			return "span[class*=\"ReadOnlyField\"]";
		}
		return super.valueTag();
	}
}
