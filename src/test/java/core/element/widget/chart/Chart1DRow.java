package core.element.widget.chart;

/**
 * A segment of a 1D chart. The attributes are the fields named in {@code options.chart1D}: no field title is needed.
 */
public class Chart1DRow<W extends Chart1DWidget<W>> extends ChartRow<W, Chart1DRow<W>> {

	Chart1DRow(W widget, ChartRecord record) {
		super(widget, record);
	}

	/** The value of the segment: the field of {@code valueFieldKey}. */
	public ChartValue<Chart1DRow<W>> valueField() {
		return byOption("valueFieldKey");
	}

	/** The title of the segment in the legend: the field of {@code titleFieldKey}. */
	public ChartValue<Chart1DRow<W>> titleField() {
		return byOption("titleFieldKey");
	}

	/** The color of the segment: the value of {@code bgColorKey} or {@code bgColor} of the value field. */
	public ChartValue<Chart1DRow<W>> bgColor() {
		return bgColor("valueFieldKey");
	}

}
