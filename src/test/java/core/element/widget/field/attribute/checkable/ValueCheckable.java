package core.element.widget.field.attribute.checkable;

import core.util.report.StepReport;
import core.element.widget.AbstractWidget;
import core.element.widget.field.AbstractField;
import core.expectation.ExpectationPattern;

import java.util.function.Consumer;


public interface ValueCheckable<W extends AbstractWidget<ExpectationPattern, W>, VF, SELF extends ValueCheckable<W, VF, SELF>> extends AbstractField<ExpectationPattern, W, VF, SELF> {

	/**
	 * The value of the field checked at once: one step of the report with the value
	 */
	@SuppressWarnings("unchecked")
	default SELF checkValue(Consumer<VF> checkValue) {
		StepReport.check(this, this::getValue, checkValue);
		return (SELF) this;
	}

}
