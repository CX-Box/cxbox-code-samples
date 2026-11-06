package core.element.widget.chart;

import com.codeborne.selenide.ClickOptions;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import core.common.Identifier;
import core.element.widget.type.PlatformTypeWidgets;
import core.element.widget.type.TypeWidget;
import io.qameta.allure.Allure;
import java.util.List;
import java.util.function.Consumer;

/**
 * A RelationGraph widget: the records are the edges "source node -> target node" of a graph drawn on a canvas.
 * <p>
 * The nodes and the edges are not in the DOM: they are found in the G6 graph that the widget keeps in a ref of its
 * React component, by the title of the node. The records themselves are checked in the table mode with {@link #table()}.
 */
public class RelationGraphWidget extends ChartWidget<RelationGraphWidget> {

	/** The start of a script that finds the G6 graph of the canvas ({@code arguments[0]}) as {@code graph}, or returns null. */
	private static final String FIND_GRAPH = """
			let node = arguments[0], fiberKey = null;
			while (node && !(fiberKey = Object.keys(node).find(k => k.startsWith('__reactFiber$')))) node = node.parentElement;
			let graph = null;
			for (let fiber = node && node[fiberKey]; fiber && !graph; fiber = fiber.return) {
				for (let hook = fiber.memoizedState; hook && typeof hook === 'object' && 'next' in hook && !graph; hook = hook.next) {
					const ref = hook.memoizedState;
					if (ref && typeof ref === 'object' && ref.current && typeof ref.current.getNodes === 'function'
							&& typeof ref.current.getEdges === 'function') graph = ref.current;
				}
			}
			if (!graph) return null;
			const title = n => n.getModel().value && n.getModel().value.title;
			const center = shape => { const b = shape.getCanvasBBox(); return [b.x + b.width / 2, b.y + b.height / 2]; };
			""";

	/** The titles of the visible nodes. */
	private static final String NODE_TITLES = "return graph.getNodes().filter(n => n.isVisible()).map(title);";

	/** The center of the visible node with the title ({@code arguments[1]}). */
	private static final String NODE_CENTER = """
			const n = graph.getNodes().find(n => n.isVisible() && title(n) === arguments[1]);
			return n ? center(n.getContainer()) : null;
			""";

	/** The middle of the visible incoming edge of the node with the title ({@code arguments[1]}). */
	private static final String EDGE_CENTER = """
			const n = graph.getNodes().find(n => n.isVisible() && title(n) === arguments[1]);
			const e = n && n.getInEdges().find(e => e.isVisible());
			if (!e) return null;
			const p = e.getKeyShape().getPoint(0.5);
			const c = graph.getCanvasByPoint(p.x, p.y);
			return [c.x, c.y];
			""";

	/** The center of the collapse marker of the node with the title ({@code arguments[1]}). */
	private static final String MARKER_CENTER = """
			const n = graph.getNodes().find(n => n.isVisible() && title(n) === arguments[1]);
			if (!n) return null;
			const marker = n.getContainer().findAll(s => /marker|collapse/i.test(s.get('name') || '')).find(s => s.get('visible') !== false);
			return marker ? center(marker) : null;
			""";

	public RelationGraphWidget(Identifier identifier, String textIdentifier) {
		super(identifier, textIdentifier);
	}

	@Override
	protected String elementCenter() {
		return NODE_CENTER;
	}

	@Override
	public TypeWidget getType() {
		return PlatformTypeWidgets.RELATION_GRAPH;
	}

	/** The records of RelationGraph are checked in the table mode: the graph has no chart2D options to read them by. */
	@Override
	public ChartRows<? extends ChartRow<RelationGraphWidget, ?>> rows() {
		throw new UnsupportedOperationException("RelationGraph: check the records with mode(Mode.TABLE).table()");
	}

	/** The titles of the nodes the graph shows: the nodes under a collapsed node are hidden. */
	public List<String> nodeTitles() {
		List<String> titles = Selenide.executeJavaScript(FIND_GRAPH + NODE_TITLES, element().$("canvas"));
		if (titles == null) {
			throw new IllegalStateException("Cannot read the nodes of the graph");
		}
		return titles;
	}

	/** Passes {@link #nodeTitles()} to the check. */
	public RelationGraphWidget checkNodeTitles(Consumer<List<String>> checkTitles) {
		checkTitles.accept(nodeTitles());
		return this;
	}

	/** Clicks the node: the drilldown of the node, or the selection of its incoming edge. */
	public RelationGraphWidget clickNode(String title) {
		return Allure.step("Click the node " + title, step -> {
			clickAt(NODE_CENTER, title);
			return this;
		});
	}

	/** Clicks the incoming edge of the node: the drilldown of edgeValue, or the selection of the edge. */
	public RelationGraphWidget clickEdge(String targetTitle) {
		return Allure.step("Click the edge to the node " + targetTitle, step -> {
			clickAt(EDGE_CENTER, targetTitle);
			return this;
		});
	}

	/** Clicks the marker of the node: collapses or expands its children. */
	public RelationGraphWidget clickMarker(String title) {
		return Allure.step("Click the collapse marker of the node " + title, step -> {
			clickAt(MARKER_CENTER, title);
			Selenide.sleep(700);
			return this;
		});
	}

	/** Clicks the point of the canvas found by the script, as an offset from the center of the canvas. */
	private void clickAt(String script, String title) {
		SelenideElement canvas = element().$("canvas");
		List<Number> point = Selenide.executeJavaScript(FIND_GRAPH + script, canvas, title);
		if (point == null) {
			throw new IllegalArgumentException("The graph does not show the element of the node " + title);
		}
		canvas.click(ClickOptions.usingDefaultMethod().offset(
				(int) Math.round(point.get(0).doubleValue() - canvas.getSize().getWidth() / 2.0),
				(int) Math.round(point.get(1).doubleValue() - canvas.getSize().getHeight() / 2.0)));
	}

}
