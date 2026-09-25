package core.element.widget.chart;

import core.common.Identifier;
import core.element.widget.type.PlatformTypeWidgets;
import core.element.widget.type.TypeWidget;
import java.util.stream.Stream;

public class Column2DWidget extends Chart2DWidget<Column2DWidget> {

	/** The center of the bar of the record with the id ({@code arguments[1]}). */
	private static final String BAR_CENTER = """
			const bar = plot.chart.getElements().find(e => String(e.getModel().data.id) === arguments[1]);
			if (!bar) return null;
			const box = bar.getBBox();
			return [box.x + box.width / 2, box.y + box.height / 2];
			""";

	public Column2DWidget(Identifier identifier, String textIdentifier) {
		super(identifier, textIdentifier);
	}

	@Override
	protected String elementCenter() {
		return BAR_CENTER;
	}

	@Override
	public TypeWidget getType() {
		return PlatformTypeWidgets.COLUMN_2D;
	}

	/** The bars of the chart: {@code rows().streamCurrentPage()}. */
	public Stream<Chart2DRow<Column2DWidget>> bars() {
		return rows().streamCurrentPage();
	}

}
