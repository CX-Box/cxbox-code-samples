package core.element.widget.chart;

/**
 * A bar or a point of a 2D chart. The attributes are the fields named in {@code options.chart2D}: no field title is
 * needed.
 */
public class Chart2DRow<W extends Chart2DWidget<W>> extends ChartRow<W, Chart2DRow<W>> {

	Chart2DRow(W widget, ChartRecord record) {
		super(widget, record);
	}

	/** The value on the X axis: the field of {@code xValueFieldKey}. */
	public ChartValue<Chart2DRow<W>> xValueField() {
		return byOption("xValueFieldKey");
	}

	/** The value on the Y axis: the field of {@code yValueFieldKey}. */
	public ChartValue<Chart2DRow<W>> yValueField() {
		return byOption("yValueFieldKey");
	}

	/** The group of the bar or the line: the field of {@code groupFieldKey}. */
	public ChartValue<Chart2DRow<W>> groupField() {
		return byOption("groupFieldKey");
	}

	/** The color: the value of {@code bgColorKey} or {@code bgColor} of the X field. */
	public ChartValue<Chart2DRow<W>> bgColor() {
		return bgColor("xValueFieldKey");
	}

}
