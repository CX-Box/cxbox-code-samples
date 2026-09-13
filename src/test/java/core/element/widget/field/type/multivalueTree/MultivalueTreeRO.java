package core.element.widget.field.type.multivalueTree;

import core.element.widget.AbstractWidget;
import core.element.widget.field.FieldType;
import core.element.widget.field.PlatformFieldType;
import core.element.widget.field.type.multivalue.MultivalueRO;
import core.expectation.ExpectationPattern;

public class MultivalueTreeRO<W extends AbstractWidget<ExpectationPattern, W>> extends MultivalueRO<W> {

	public MultivalueTreeRO(W widget, String identifier) {
		super(widget, identifier);
	}

	@Override
	public FieldType fieldType() {
		return PlatformFieldType.MULTIVALUE_TREE_RO;
	}

}
