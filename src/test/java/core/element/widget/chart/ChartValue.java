package core.element.widget.chart;

import java.util.function.Consumer;

/** A value of a chart record, see {@link ChartRow}. */
public class ChartValue<R> {

	private final R row;

	private final String value;

	ChartValue(R row, String value) {
		this.row = row;
		this.value = value;
	}

	/** The value as the record holds it: a number without formatting, an enum by its text. */
	public String getValue() {
		return value;
	}

	/** Passes {@link #getValue()} to the check. */
	public R checkValue(Consumer<String> checkValue) {
		checkValue.accept(value);
		return row;
	}

}
