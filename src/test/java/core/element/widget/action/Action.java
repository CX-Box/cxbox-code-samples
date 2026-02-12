package core.element.widget.action;

import core.element.widget.AbstractWidget;
import core.expectation.ExpectationPattern;

public class Action<W extends AbstractWidget<ExpectationPattern, W>> extends Actions<W> {

	public Action(W widget) {
		super(widget);
	}

}
