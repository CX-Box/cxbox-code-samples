package core.element.widget.chart;

import com.codeborne.selenide.Selenide;
import core.common.Identifier;
import core.element.widget.type.PlatformTypeWidgets;
import core.element.widget.type.TypeWidget;
import io.qameta.allure.Allure;

/**
 * A DualAxes2D widget: two 2D charts (the widgets of {@code options.dual2D.widgets}) drawn in one area.
 * <p>
 * The widget has no chart options of its own, so its records are checked in the table mode with {@link #table()}.
 * The elements of the charts are found by the id of the record in the views of the chart: the first view is the
 * first widget of {@code options.dual2D.widgets}.
 */
public class DualAxes2DWidget extends ChartWidget<DualAxes2DWidget> {

	/**
	 * A point of the element of the record with the id ({@code arguments[1]}) in the first view that draws it.
	 * A line is an element with an array of records as its data, it is skipped. The line of the second chart is drawn
	 * over the bars and takes the click where it crosses a bar, so a bar is clicked at its bottom.
	 */
	private static final String ELEMENT_CENTER = """
			const element = plot.chart.views.flatMap(v => v.getElements()).find(e => {
				const data = e.getModel().data;
				return !Array.isArray(data) && String(data.id) === arguments[1];
			});
			if (!element) return null;
			const box = element.getBBox();
			return [box.x + box.width / 2, element.geometry.type === 'interval' ? box.maxY - 6 : box.y + box.height / 2];
			""";

	public DualAxes2DWidget(Identifier identifier, String textIdentifier) {
		super(identifier, textIdentifier);
	}

	@Override
	protected String elementCenter() {
		return ELEMENT_CENTER;
	}

	@Override
	public TypeWidget getType() {
		return PlatformTypeWidgets.DUAL_AXES_2D;
	}

	/** The records of DualAxes2D are checked in the table mode: the widget has no chart options to read them by. */
	@Override
	public ChartRows<? extends ChartRow<DualAxes2DWidget, ?>> rows() {
		throw new UnsupportedOperationException("DualAxes2D: check the records with mode(Mode.TABLE).table()");
	}

	/** Clicks the element (the bar of the first chart) of the record with the id, as the user does. */
	public DualAxes2DWidget click(String id) {
		return Allure.step("Click the element of the record " + id, step -> {
			clickRecord(id);
			return this;
		});
	}

	/** Moves the mouse over the element of the record with the id: the chart shows the tooltip. */
	public DualAxes2DWidget hover(String id) {
		return Allure.step("Hover the element of the record " + id, step -> {
			hoverRecord(id);
			Selenide.sleep(500);
			return this;
		});
	}

}
