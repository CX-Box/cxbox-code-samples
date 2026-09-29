package application.Samples.Pie1D;

import static io.qameta.allure.SeverityLevel.CRITICAL;
import static org.assertj.core.api.Assertions.assertThat;

import application.config.BaseTestForSamples;
import core.element.PlatformApp;
import core.element.widget.chart.Chart1DRow;
import core.element.widget.chart.ChartWidget.Mode;
import core.element.widget.chart.Pie1DWidget;
import core.element.widget.list.realization.inline.list.PlatformListWidgetInline;
import core.util.DocShots;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import java.math.BigDecimal;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

@DisplayName("Pie1D. The chart, its table mode and the options of chart1D")
@Epic("Samples")
@Feature(Pie1DTest.ARTICLE)
@Tag("Samples")
@Tag("Pie1D")
public class Pie1DTest extends BaseTestForSamples {

	static final String ARTICLE = "widget/type/pie1d";

	private static final int WIDTH = 1600;

	private static final int HEIGHT = 900;

	private static final String TITLE = "Sales per client";

	/** The client with the most sales in the test data of the samples. */
	private static final String CLIENT = "LLC TelemedOperations";

	@Test
	@Severity(CRITICAL)
	@Tag("Positive")
	@DisplayName("Basics: the chart, the total and the same records in the table mode")
	@Description("The chart opens in the chart mode with the sum in the center; the gear menu switches it to the table with a row per segment and back")
	void basics() {
		Pie1DWidget chart = PlatformApp.screen("Pie1D basic").view().pie1D(TITLE);
		chart.checkMode(mode -> assertThat(mode).isEqualTo(Mode.CHART));
		chart.checkTotal(total -> assertThat(total).contains("Total").contains("62364"));
		assertThat(chart.segments().map(row -> row.titleField().getValue())).hasSize(9).contains(CLIENT);
		segment(chart, CLIENT).valueField().checkValue(value -> assertThat(value).isEqualTo("17294"));
		DocShots.png(chart.element(), ARTICLE, "pie1d.png", WIDTH, HEIGHT);

		var table = chart.mode(Mode.TABLE).table();
		chart.checkMode(mode -> assertThat(mode).isEqualTo(Mode.TABLE));
		assertThat(clients(table)).hasSize(9).contains(CLIENT);
		DocShots.png(chart.element(), ARTICLE, "tablemode.png", WIDTH, HEIGHT);

		chart.mode(Mode.CHART).checkMode(mode -> assertThat(mode).isEqualTo(Mode.CHART));
	}

	@Test
	@Tag("Positive")
	@DisplayName("Title: constant and empty")
	@Description("The widget with a title shows it above the chart; the widget without a title shows the chart only")
	void title() {
		var screen = PlatformApp.screen("Pie1D title");
		Pie1DWidget constTitle = screen.secondLevelView("Constant title").pie1D(TITLE);
		DocShots.png(constTitle.element(), ARTICLE, "consttitle.png", WIDTH, HEIGHT);

		Pie1DWidget emptyTitle = screen.secondLevelView("Constant title empty").pie1DByName("MyExample4217Pie");
		emptyTitle.checkMode(mode -> assertThat(mode).isEqualTo(Mode.CHART));
		DocShots.png(emptyTitle.element(), ARTICLE, "empytitle.png", WIDTH, HEIGHT);
	}

	@Test
	@Tag("Positive")
	@DisplayName("Tooltip: the text of descriptionFieldKey")
	@Description("The tooltip of a segment shows the text of the description field instead of the title and the value")
	void tooltip() {
		Pie1DWidget chart = PlatformApp.screen("Pie1D tooltip").view().pie1D(TITLE);
		segment(chart, CLIENT).hover()
				.checkTooltip(tooltip -> assertThat(tooltip).startsWith(CLIENT + ": 14 sales"));
		DocShots.png(chart.element(), ARTICLE, "tooltip.png", WIDTH, HEIGHT);
	}

	@Test
	@Tag("Positive")
	@DisplayName("Color: calculated by bgColorKey")
	@Description("bgColorKey of the value field colors every segment by the data: key clients are blue, the others are grey")
	void color() {
		Pie1DWidget chart = PlatformApp.screen("Pie1D color").view().pie1D(TITLE);
		DocShots.png(chart.element(), ARTICLE, "color.png", WIDTH, HEIGHT);
		segment(chart, CLIENT).bgColor().checkValue(value -> assertThat(value).isEqualTo("#3A76E4"));
		segment(chart, "GlobalTrade Partners").bgColor().checkValue(value -> assertThat(value).isEqualTo("#BFBFBF"));
	}

	@Test
	@Severity(CRITICAL)
	@Tag("Positive")
	@DisplayName("Total: aggregate function, other field, constant text, no hole")
	@Description("options.chart1D.total sets the text in the center: func over the value or over argFieldKeys, a constant value, innerSpace 0 draws a full pie")
	void total() {
		var screen = PlatformApp.screen("Pie1D total");
		Pie1DWidget sum = screen.secondLevelView("Aggregate function").pie1DByName("MyExample4261Sum");
		sum.checkTotal(total -> assertThat(total).contains("Total").contains("62364"));
		DocShots.png(sum.element(), ARTICLE, "totalfunc.png", WIDTH, HEIGHT);

		Pie1DWidget avg = screen.secondLevelView("Average").pie1DByName("MyExample4261Avg");
		avg.checkTotal(total -> assertThat(total).contains("Average").contains("6929.33"));

		Pie1DWidget argFields = screen.secondLevelView("Aggregate other field").pie1DByName("MyExample4261ArgFields");
		argFields.checkTotal(total -> assertThat(total).contains("Sales count").contains("66"));
		DocShots.png(argFields.element(), ARTICLE, "totalargfields.png", WIDTH, HEIGHT);

		Pie1DWidget value = screen.secondLevelView("Constant text").pie1DByName("MyExample4261Value");
		value.checkTotal(total -> assertThat(total.trim()).isEqualTo("Q3"));
		DocShots.png(value.element(), ARTICLE, "totalvalue.png", WIDTH, HEIGHT);

		Pie1DWidget innerSpace = screen.secondLevelView("Without hole").pie1DByName("MyExample4261InnerSpace");
		innerSpace.checkMode(mode -> assertThat(mode).isEqualTo(Mode.CHART));
		DocShots.png(innerSpace.element(), ARTICLE, "totalinnerspace.png", WIDTH, HEIGHT);
	}

	@Test
	@Tag("Positive")
	@DisplayName("Label position: inside and outside the segments")
	@Description("valuePosition puts the values inside the segments (default) or outside the pie")
	void labelPosition() {
		var screen = PlatformApp.screen("Pie1D label position");
		Pie1DWidget inner = screen.secondLevelView("Inner").pie1DByName("MyExample4262Inner");
		DocShots.png(inner.element(), ARTICLE, "labelinner.png", WIDTH, HEIGHT);
		Pie1DWidget outer = screen.secondLevelView("Outer").pie1DByName("MyExample4262Outer");
		outer.checkMode(mode -> assertThat(mode).isEqualTo(Mode.CHART));
		DocShots.png(outer.element(), ARTICLE, "labelouter.png", WIDTH, HEIGHT);
	}

	@Test
	@Severity(CRITICAL)
	@Tag("Positive")
	@DisplayName("DrillDown: a click on a segment opens the list of sales of the client")
	@Description("The drilldown of the value field: a click on a segment opens the list of sales filtered by the client of the segment")
	void drillDown() {
		Pie1DWidget chart = PlatformApp.screen("Pie1D drilldown").secondLevelView("Drilldown").pie1D(TITLE);
		DocShots.gif(ARTICLE, "drilldown.gif", WIDTH, HEIGHT, DocShots.Frame.WITHOUT_SIDEBAR);
		segment(chart, CLIENT).drilldown(url -> assertThat(url).contains("/screen/myexample4219/view/myexample4219sales"));
		var sales = PlatformApp.currentScreen().view().listInline("Sales");
		assertThat(clients(sales, "Client")).isNotEmpty().allMatch(CLIENT::equals);
		DocShots.stop();

		sales.headers().clearFilters();
	}

	@Test
	@Severity(CRITICAL)
	@Tag("Positive")
	@DisplayName("Parent child: the child list follows the selected row of the table mode")
	@Description("In the table mode a click on a row selects the client; the child list shows only his sales. In the chart mode a click on a segment does not select it")
	void parentChild() {
		var view = PlatformApp.screen("Pie1D drilldown").secondLevelView("Parent child");
		Pie1DWidget chart = view.pie1D(TITLE);
		PlatformListWidgetInline table = chart.mode(Mode.TABLE).table();
		var sales = view.listInline("Sales");

		table.rows().clickRow(indexOf(table, CLIENT));
		assertThat(clients(sales, "Client")).isNotEmpty().allMatch(CLIENT::equals);
	}

	@Test
	@Severity(CRITICAL)
	@Tag("Positive")
	@DisplayName("Show condition by parent entity")
	@Description("The chart is shown while Custom Field Number of the parent form is greater than 5; the condition is recalculated on save")
	void showConditionByParentEntity() {
		var view = PlatformApp.screen("Pie1D show condition")
				.secondLevelView("Show condition by parent entity")
				.checkUrl(url -> assertThat(url).contains("#/screen/myexample4215"));
		var parent = view.formByName("MyExample4215Parent");
		Pie1DWidget chart = view.pie1DByName("MyExample4215Pie");
		var customFieldNumber = parent.number("Custom Field Number");
		BigDecimal initialValue = customFieldNumber.getValue();

		// the picture of the article starts with the chart shown
		customFieldNumber.setValue(BigDecimal.valueOf(8));
		parent.actions().action("Save").click();
		chart.checkVisible(visible -> assertThat(visible).isTrue());

		DocShots.gif(ARTICLE, "show_cond.gif", WIDTH, HEIGHT, DocShots.Frame.WITHOUT_SIDEBAR);
		customFieldNumber.setValue(BigDecimal.valueOf(3));
		parent.actions().action("Save").click();
		chart.checkVisible(visible -> assertThat(visible).isFalse());
		customFieldNumber.setValue(BigDecimal.valueOf(8));
		parent.actions().action("Save").click();
		chart.checkVisible(visible -> assertThat(visible).isTrue());
		DocShots.stop();

		customFieldNumber.setValue(initialValue);
		parent.actions().action("Save").click();
	}

	@Test
	@Tag("Negative")
	@DisplayName("Page limit: more records than the page limit")
	@Description("The chart mode is not available when the business component has more records than its page limit: the widget shows the table and a warning")
	void pageLimit() {
		Pie1DWidget chart = PlatformApp.screen("Pie1D page limit").view().pie1D(TITLE);
		chart.checkMode(mode -> assertThat(mode).isEqualTo(Mode.TABLE));
		chart.checkChartModeAvailable(available -> assertThat(available).isFalse());
		DocShots.png(chart.element(), ARTICLE, "limit.png", WIDTH, HEIGHT);
	}

	/** The segment of the client: the record of the chart with this title. */
	private static Chart1DRow<Pie1DWidget> segment(Pie1DWidget chart, String client) {
		return chart.segments()
				.filter(row -> client.equals(row.titleField().getValue()))
				.findFirst()
				.orElseThrow(() -> new AssertionError("No segment of the client " + client));
	}

	private static List<String> clients(PlatformListWidgetInline table) {
		return clients(table, "Client");
	}

	private static List<String> clients(PlatformListWidgetInline list, String column) {
		return list.rows().streamCurrentPage().map(row -> row.input(column).getValue()).toList();
	}

	private static int indexOf(PlatformListWidgetInline table, String client) {
		int index = clients(table).indexOf(client);
		assertThat(index).as("row of the client " + client).isNotNegative();
		return index;
	}

}
