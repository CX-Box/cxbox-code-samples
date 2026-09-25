package core.element.widget.chart;

import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Stream;

/** The records of a chart as rows of a List, see {@link ChartWidget#rows()}. */
public class ChartRows<R extends ChartRow<?, R>> {

	private final Supplier<List<R>> rows;

	ChartRows(Supplier<List<R>> rows) {
		this.rows = rows;
	}

	/** The row of the record, in the order of the backend. */
	public R row(int number) {
		return rows.get().get(number);
	}

	/** All rows of the chart: the chart shows one page of the business component. */
	public Stream<R> streamCurrentPage() {
		return rows.get().stream();
	}

}
