package core.element.widget.field.attribute.checkable;

import core.element.widget.AbstractWidget;
import core.element.widget.field.AbstractField;
import core.expectation.ExpectationPattern;
import org.openqa.selenium.By;

import java.util.function.Consumer;

public interface DrillDownSupportCheckable<W extends AbstractWidget<ExpectationPattern, W>, VF, V, SELF extends DrillDownSupportCheckable<W, VF, V, SELF>> extends AbstractField<ExpectationPattern, W, VF, SELF> {

	@SuppressWarnings("unchecked")
	default SELF checkDrillDownSupported(Consumer<V> drillDown) {
		V isDrillDownSupported = (V) Boolean.valueOf(!element().$(valueTag()).getWrappedElement().findElements(By.cssSelector("span:has(a)")).isEmpty());
		drillDown.accept(isDrillDownSupported);
		return (SELF) this;
	}

	;
}
