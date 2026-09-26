package core.element.widget.chart;

import core.common.Identifier;

/** A chart of the 2D family (X and Y axes): Column2D, Line2D. */
public abstract class Chart2DWidget<SELF extends Chart2DWidget<SELF>> extends ChartWidget<SELF> {

	protected Chart2DWidget(Identifier identifier, String textIdentifier) {
		super(identifier, textIdentifier);
	}

	@Override
	public ChartRows<Chart2DRow<SELF>> rows() {
		return new ChartRows<>(() -> readRecords().stream().map(record -> new Chart2DRow<>(widget(), record)).toList());
	}

}
