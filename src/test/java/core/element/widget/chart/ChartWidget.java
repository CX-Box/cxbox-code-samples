package core.element.widget.chart;

import com.codeborne.selenide.ClickOptions;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.HoverOptions;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import core.common.Identifier;
import core.element.widget.PlatformIdentifier;
import core.element.widget.PlatformWidget;
import core.element.widget.list.WidgetSettings;
import core.element.widget.list.realization.inline.list.PlatformListWidgetInline;
import core.element.widget.type.TypeWidget;
import io.qameta.allure.Allure;
import java.time.Duration;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

/**
 * A chart widget: Pie1D, Column2D, Line2D.
 * <p>
 * The chart is drawn on a canvas, so the bars, points and segments are not in the DOM. The data of the chart is checked
 * with {@link #rows()} as the rows of a List, or in the table mode with {@link #table()}.
 */
public abstract class ChartWidget<SELF extends ChartWidget<SELF>> extends PlatformWidget<SELF> {

	/** Items of the "Mode" group in the gear menu of a chart. */
	public enum Mode {
		CHART("Chart"),
		TABLE("Table");

		private final String title;

		Mode(String title) {
			this.title = title;
		}
	}

	private final String textIdentifier;

	protected ChartWidget(Identifier identifier, String textIdentifier) {
		super(identifier, textIdentifier);
		this.textIdentifier = textIdentifier;
	}

	/**
	 * The widget with the chart drawn to the end.
	 * <p>
	 * A chart has no text of its own: the labels and the legend are on the canvas, so a widget without a title looks empty
	 * and the check of {@link PlatformWidget#element()} fails. The content is awaited instead: the canvas, the table or
	 * "No data". The chart grows with an animation, so a check or a picture made earlier sees a half-drawn chart: the
	 * canvas is drawn when two frames in a row are the same.
	 */
	@Override
	public SelenideElement element() {
		SelenideElement widget = (getIdentifier().equals(PlatformIdentifier.NAME)
				? widgetByName(getType(), textIdentifier)
				: widgetByTitle(getType(), textIdentifier))
				.shouldBe(Condition.visible, getExpectations().getOverTimeout());
		widget.$("canvas, table, .ant-empty").shouldBe(Condition.exist, getExpectations().getOverTimeout());
		widget.scrollTo();
		SelenideElement canvas = widget.$("canvas");
		if (canvas.exists()) {
			Selenide.Wait()
					.withTimeout(getExpectations().getTimeout())
					.pollingEvery(Duration.ofMillis(200))
					.until(driver -> Boolean.TRUE.equals(Selenide.executeJavaScript(
							"const frame = arguments[0].toDataURL();"
									+ "const same = arguments[0].cxboxLastFrame === frame;"
									+ "arguments[0].cxboxLastFrame = frame;"
									+ "return same;", canvas)));
		}
		return widget;
	}

	/**
	 * The start of a script that finds the chart of the canvas ({@code arguments[0]}) as {@code plot}: the G2Plot object
	 * that @ant-design/plots keeps in a ref of its React component. The bars, points and segments are drawn on the canvas
	 * and are not in the DOM, so only the chart knows where they are. The script returns null when there is no chart.
	 */
	protected static final String FIND_PLOT = """
			let node = arguments[0], fiberKey = null;
			while (node && !(fiberKey = Object.keys(node).find(k => k.startsWith('__reactFiber$')))) node = node.parentElement;
			let plot = null;
			for (let fiber = node && node[fiberKey]; fiber && !plot; fiber = fiber.return) {
				for (let hook = fiber.memoizedState; hook && typeof hook === 'object' && 'next' in hook && !plot; hook = hook.next) {
					const ref = hook.memoizedState;
					if (ref && typeof ref === 'object' && ref.current && ref.current.chart
							&& typeof ref.current.chart.getElements === 'function') plot = ref.current;
				}
			}
			if (!plot) return null;
			""";

	/**
	 * The records drawn by the chart, in the order of the backend, with the fields and the chart options of the widget
	 * with the name {@code arguments[1]}. The meta is taken from the props of the chart component above the canvas.
	 * React keeps two copies of a component and the canvas can point to the old one, left from another widget shown at
	 * the same place, so both copies are checked by the widget name. Every value is text, as the record holds it.
	 */
	private static final String RECORDS = """
			let meta = null;
			for (let fiber = node[fiberKey]; fiber && !meta; fiber = fiber.return) {
				for (const copy of [fiber, fiber.alternate]) {
					const props = copy && copy.memoizedProps;
					if (props && props.meta && props.meta.name === arguments[1] && Array.isArray(props.meta.fields)) meta = props.meta;
				}
			}
			if (!meta) return null;
			const text = v => v == null || typeof v === 'object' ? null : String(v).trim();
			const options = meta.options && (meta.options.chart1D || meta.options.chart2D) || {};
			const fields = meta.fields.filter(f => f.key).map(f => ({
				key: f.key, title: f.title || null, bgColor: f.bgColor || null, bgColorKey: f.bgColorKey || null
			}));
			const records = (plot.options.data || []).map(record => {
				const values = {};
				Object.keys(record).forEach(key => { const v = text(record[key]); if (v !== null) values[key] = v; });
				return {id: String(record.id), values: values};
			});
			return {options: JSON.parse(JSON.stringify(options)), fields: fields, records: records};
			""";

	/**
	 * A script that continues {@link #FIND_PLOT}: the center of the element of the record with the id
	 * ({@code arguments[1]}) in CSS pixels of the canvas, or null when the chart does not draw the record.
	 */
	protected abstract String elementCenter();

	/**
	 * The bars, points or segments of the chart as rows of a List: one row per record drawn by the chart. A row is found
	 * by the values of its fields and then clicked or hovered on the chart, as the user does. The row of a family reads
	 * the fields named in the chart options of the widget, see {@link Chart1DRow} and {@link Chart2DRow}.
	 */
	public abstract ChartRows<? extends ChartRow<SELF, ?>> rows();

	@SuppressWarnings("unchecked")
	List<ChartRecord> readRecords() {
		SelenideElement widget = element();
		Map<String, Object> chart = Selenide.executeJavaScript(FIND_PLOT + RECORDS, widget.$("canvas"),
				widget.getAttribute("data-test-widget-name"));
		if (chart == null) {
			throw new IllegalStateException("Cannot read the records of the chart " + textIdentifier);
		}
		Map<String, Object> options = (Map<String, Object>) chart.get("options");
		List<Map<String, Object>> fields = (List<Map<String, Object>>) chart.get("fields");
		return ((List<Map<String, Object>>) chart.get("records")).stream()
				.map(record -> new ChartRecord((String) record.get("id"), (Map<String, String>) record.get("values"), fields, options))
				.toList();
	}

	void clickRecord(String id) {
		SelenideElement canvas = element().$("canvas");
		List<Long> offset = offset(canvas, id);
		canvas.click(ClickOptions.usingDefaultMethod().offset(offset.get(0).intValue(), offset.get(1).intValue()));
	}

	void hoverRecord(String id) {
		SelenideElement canvas = element().$("canvas");
		List<Long> offset = offset(canvas, id);
		canvas.hover(HoverOptions.withOffset(offset.get(0).intValue(), offset.get(1).intValue()));
	}

	/** The element of the record as an offset from the center of the canvas: Selenide clicks relative to the center. */
	private List<Long> offset(SelenideElement canvas, String id) {
		List<Number> point = Selenide.executeJavaScript(FIND_PLOT + elementCenter(), canvas, id);
		if (point == null) {
			throw new IllegalArgumentException("The chart does not draw the record " + id);
		}
		return List.of(Math.round(point.get(0).doubleValue() - canvas.getSize().getWidth() / 2.0),
				Math.round(point.get(1).doubleValue() - canvas.getSize().getHeight() / 2.0));
	}

	/** Switches the widget to the chart or to the table by the gear menu. */
	public SELF mode(Mode mode) {
		return Allure.step("Switching the chart to the mode " + mode.title, step -> {
			logTime(step);
			return settings().select(mode.title);
		});
	}

	/** The current mode: the table mode shows a table instead of the canvas. */
	public Mode mode() {
		return element().$("table").exists() ? Mode.TABLE : Mode.CHART;
	}

	/** Passes the current mode ({@link #mode()}) to the check. */
	public SELF checkMode(Consumer<Mode> checkMode) {
		checkMode.accept(mode());
		return widget();
	}

	/**
	 * The table of the table mode with the API of a List widget. The widget has to be in the table mode:
	 * {@code mode(Mode.TABLE).table()}.
	 */
	public PlatformListWidgetInline table() {
		TypeWidget type = getType();
		return new PlatformListWidgetInline(getIdentifier(), textIdentifier) {
			@Override
			public TypeWidget getType() {
				return type;
			}
		};
	}

	/** The text of the tooltip shown by the chart under the mouse, or an empty string when there is no tooltip. */
	public String tooltip() {
		SelenideElement tooltip = element().$(".g2-tooltip");
		return tooltip.is(Condition.visible) ? tooltip.innerText().trim() : "";
	}

	/** Passes {@link #tooltip()} to the check. */
	public SELF checkTooltip(Consumer<String> checkTooltip) {
		checkTooltip.accept(tooltip());
		return widget();
	}

	/** Whether the widget shows "No data": the backend returned no records. */
	public boolean isNoData() {
		return element().$(".ant-empty").exists();
	}

	/** Passes {@link #isNoData()} to the check. */
	public SELF checkNoData(Consumer<Boolean> checkNoData) {
		checkNoData.accept(isNoData());
		return widget();
	}

	/**
	 * Whether the chart mode can be chosen. It cannot when there are more records than the page limit of the business
	 * component: the widget shows only the table and a warning icon.
	 */
	public boolean isChartModeAvailable() {
		SelenideElement chartItem = settings().open().$$("li[role='menuitem']").findBy(Condition.exactText(Mode.CHART.title));
		boolean available = !chartItem.getAttribute("class").contains("ant-dropdown-menu-item-disabled");
		settings().close();
		return available;
	}

	/** Passes {@link #isChartModeAvailable()} to the check. */
	public SELF checkChartModeAvailable(Consumer<Boolean> checkAvailable) {
		checkAvailable.accept(isChartModeAvailable());
		return widget();
	}

	/** The gear menu of the widget: the mode of the chart. */
	public WidgetSettings<SELF> settings() {
		return new WidgetSettings<>(widget());
	}

}
