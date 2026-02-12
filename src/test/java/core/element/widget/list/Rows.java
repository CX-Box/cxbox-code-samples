package core.element.widget.list;

import core.common.IterableElement;
import core.element.widget.AbstractWidget;
import core.expectation.ExpectationPattern;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public abstract class Rows<SELF extends Rows<SELF, W>, W extends AbstractWidget<ExpectationPattern, W>> implements IterableElement {

	private final W widget;

	public Rows(W widget) {
		this.widget = widget;
	}

	public W widget() {
		return widget;
	}

}
