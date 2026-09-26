package core.element.widget.chart;

import static core.element.widget.AbstractWidget.logTime;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Allure;
import java.util.function.Consumer;

/**
 * A record of a chart: a bar, a point or a segment. {@link #drilldown} and {@link #hover} act on the element of the
 * record on the chart. The row of a family also reads the fields named in the chart options.
 */
public abstract class ChartRow<W extends ChartWidget<W>, SELF extends ChartRow<W, SELF>> {

	private final W widget;

	protected final ChartRecord record;

	ChartRow(W widget, ChartRecord record) {
		this.widget = widget;
		this.record = record;
	}

	/** The value of the field with this title, as text: a number without formatting, an enum by its text. */
	public ChartValue<SELF> input(String title) {
		String key = record.keyByTitle(title).orElseThrow(() -> new IllegalArgumentException(
				"The chart has no field " + title + ", the fields are " + record.titles()));
		return value(record.value(key));
	}

	/**
	 * Clicks the element of the record on the chart, as the user does, and passes the address of the opened view to the
	 * consumer.
	 */
	public void drilldown(Consumer<String> consumer) {
		Allure.step("Drilldown from the record " + record.values(), step -> {
			logTime(step);
			String url = WebDriverRunner.url();
			widget.clickRecord(record.id());
			Selenide.Wait().until(webDriver -> !webDriver.getCurrentUrl().equals(url));
			consumer.accept(WebDriverRunner.url());
		});
	}

	/** Moves the mouse over the element of the record: the chart shows the tooltip of the record. */
	public SELF hover() {
		return Allure.step("Hover over the record " + record.values(), step -> {
			logTime(step);
			widget.hoverRecord(record.id());
			return self();
		});
	}

	/** Passes the text of the tooltip ({@link ChartWidget#tooltip()}) to the check. */
	public SELF checkTooltip(Consumer<String> checkTooltip) {
		checkTooltip.accept(widget.tooltip());
		return self();
	}

	public W widget() {
		return widget;
	}

	/**
	 * The description of the record as the tooltip shows it: the values of {@code descriptionFieldKey} joined with a
	 * comma, empty values skipped. Empty when the option is not set.
	 */
	public ChartValue<SELF> descriptionField() {
		return value(String.join(", ", record.listOption("descriptionFieldKey").stream()
				.map(record::value)
				.filter(value -> !value.isEmpty())
				.toList()));
	}

	/**
	 * The color of the record: the value of the field named by {@code bgColorKey}, or {@code bgColor} of the field.
	 * Empty when the field has neither.
	 */
	protected ChartValue<SELF> bgColor(String fieldOption) {
		return value(record.field(key(fieldOption))
				.map(field -> field.get("bgColorKey") != null
						? record.value((String) field.get("bgColorKey"))
						: field.get("bgColor") != null ? (String) field.get("bgColor") : "")
				.orElse(""));
	}

	/** The value of the field named by the chart option, e.g. {@code valueFieldKey}. */
	protected ChartValue<SELF> byOption(String option) {
		return value(record.value(key(option)));
	}

	private String key(String option) {
		return record.option(option).orElseThrow(() -> new IllegalStateException(
				"The chart " + widget.getClass().getSimpleName() + " has no " + option + " in its options"));
	}

	private ChartValue<SELF> value(String value) {
		return new ChartValue<>(self(), value);
	}

	@SuppressWarnings("unchecked")
	private SELF self() {
		return (SELF) this;
	}

}
