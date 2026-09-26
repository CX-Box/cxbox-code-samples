package core.element.widget.chart;

import core.common.Identifier;

/** A chart of the 1D family (values without axes): Pie1D. */
public abstract class Chart1DWidget<SELF extends Chart1DWidget<SELF>> extends ChartWidget<SELF> {

	protected Chart1DWidget(Identifier identifier, String textIdentifier) {
		super(identifier, textIdentifier);
	}

	@Override
	public ChartRows<Chart1DRow<SELF>> rows() {
		return new ChartRows<>(() -> readRecords().stream().map(record -> new Chart1DRow<>(widget(), record)).toList());
	}

}
