package core.element.widget.chart;

import core.common.Identifier;
import core.element.widget.type.PlatformTypeWidgets;
import core.element.widget.type.TypeWidget;
import java.util.stream.Stream;

public class Line2DWidget extends Chart2DWidget<Line2DWidget> {

	/**
	 * The point of the line for the record with the id ({@code arguments[1]}). The line itself is an element with an
	 * array of records as its data, it is skipped.
	 */
	private static final String POINT_CENTER = """
			const point = plot.chart.getElements().find(e => {
				const data = e.getModel().data;
				return !Array.isArray(data) && String(data.id) === arguments[1];
			});
			if (!point) return null;
			const box = point.getBBox();
			return [box.x + box.width / 2, box.y + box.height / 2];
			""";

	public Line2DWidget(Identifier identifier, String textIdentifier) {
		super(identifier, textIdentifier);
	}

	@Override
	protected String elementCenter() {
		return POINT_CENTER;
	}

	@Override
	public TypeWidget getType() {
		return PlatformTypeWidgets.LINE_2D;
	}

	/** The points of the chart: {@code rows().streamCurrentPage()}. */
	public Stream<Chart2DRow<Line2DWidget>> points() {
		return rows().streamCurrentPage();
	}

}
