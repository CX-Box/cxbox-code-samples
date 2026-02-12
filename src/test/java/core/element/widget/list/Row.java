package core.element.widget.list;

import core.common.SingleElement;
import core.element.widget.AbstractWidget;
import core.expectation.ExpectationPattern;

public abstract class Row<SELF extends Row<SELF, R, W>, R extends Rows<R, W>, W extends AbstractWidget<ExpectationPattern, W>> implements SingleElement {
}
