package core.element.widget.chart;

import core.common.Identifier;
import core.element.widget.type.PlatformTypeWidgets;
import core.element.widget.type.TypeWidget;
import java.util.function.Consumer;
import java.util.stream.Stream;

public class Pie1DWidget extends Chart1DWidget<Pie1DWidget> {

	/**
	 * The middle of the arc of the segment of the record with the id ({@code arguments[1]}). The center of the bounding box of a
	 * segment can be outside the ring, so the point is calculated from the angles and the radius of the ring.
	 */
	private static final String SEGMENT_CENTER = """
			const id = arguments[1], chart = plot.chart;
			const geometry = chart.geometries[0], coordinate = chart.getCoordinate();
			const valueKey = geometry.getAttribute('position').getFields()[1];
			const items = geometry.elements.map(e => e.getModel().data);
			const total = items.reduce((sum, d) => sum + Number(d[valueKey]), 0);
			let before = 0;
			for (const d of items) {
				if (String(d.id) === id) {
					const angle = coordinate.startAngle
							+ (coordinate.endAngle - coordinate.startAngle) * (before + Number(d[valueKey]) / 2) / total;
					const radius = coordinate.getRadius() * (1 + coordinate.innerRadius) / 2, center = coordinate.getCenter();
					return [center.x + radius * Math.cos(angle), center.y + radius * Math.sin(angle)];
				}
				before += Number(d[valueKey]);
			}
			return null;
			""";

	public Pie1DWidget(Identifier identifier, String textIdentifier) {
		super(identifier, textIdentifier);
	}

	@Override
	public TypeWidget getType() {
		return PlatformTypeWidgets.PIE_1D;
	}

	@Override
	protected String elementCenter() {
		return SEGMENT_CENTER;
	}

	/**
	 * The text in the center of the pie set by {@code options.chart1D.total}: the description and the value, e.g.
	 * {@code "Total \n62364"}. Empty when the widget has no total.
	 */
	public String total() {
		var total = element().$(".g2-html-annotation");
		return total.exists() ? total.innerText() : "";
	}

	/** Passes {@link #total()} to the check. */
	public Pie1DWidget checkTotal(Consumer<String> checkTotal) {
		checkTotal.accept(total());
		return this;
	}

	/** The segments of the chart: {@code rows().streamCurrentPage()}. */
	public Stream<Chart1DRow<Pie1DWidget>> segments() {
		return rows().streamCurrentPage();
	}

}
