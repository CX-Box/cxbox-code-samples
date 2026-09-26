package application.Samples.Line2D;

import static io.qameta.allure.SeverityLevel.CRITICAL;
import static org.assertj.core.api.Assertions.assertThat;

import application.config.BaseTestForSamples;
import core.element.PlatformApp;
import core.element.widget.chart.ChartWidget.Mode;
import core.element.widget.chart.Line2DWidget;
import core.util.DocShots;
import core.util.DocShots.Frame;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import java.math.BigDecimal;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

@DisplayName("Line2D. The chart, its table mode and the options of chart2D")
@Epic("Samples")
@Feature(Line2DTest.ARTICLE)
@Tag("Samples")
@Tag("Line2D")
public class Line2DTest extends BaseTestForSamples {

	static final String ARTICLE = "widget/type/line2d";

	private static final int WIDTH = 1600;

	private static final int HEIGHT = 900;

	private static final String MONTH = "Month";

	private static final String SUM = "Sum, $";

	private static final String PRODUCT = "Product";

	private static final String TITLE = "Sales sum per month";

	private static final String TITLE_GROUPS = "Sales sum per month and product";

	@Test
	@Severity(CRITICAL)
	@Tag("Positive")
	@DisplayName("Basics: the chart and the same records in the table mode")
	@Description("The chart opens in the chart mode; the gear menu switches it to the table with a row per point and back")
	void basics() {
		Line2DWidget chart = PlatformApp.screen("Line2D widget basic").view().line2D(TITLE);
		chart.checkMode(mode -> assertThat(mode).isEqualTo(Mode.CHART));
		DocShots.png(chart.element(), ARTICLE, "line2d.png", WIDTH, HEIGHT);

		var table = chart.mode(Mode.TABLE).table();
		chart.checkMode(mode -> assertThat(mode).isEqualTo(Mode.TABLE));
		assertThat(table.rows().streamCurrentPage().count()).isEqualTo(6);
		table.rows().row(0).input(MONTH).checkValue(value -> assertThat(value).isEqualTo("Jan"));
		table.rows().row(0).number(SUM).checkValue(value -> assertThat(value).isEqualByComparingTo(new BigDecimal(3800)));
		table.rows().row(5).input(MONTH).checkValue(value -> assertThat(value).isEqualTo("Jun"));

		chart.mode(Mode.CHART).checkMode(mode -> assertThat(mode).isEqualTo(Mode.CHART));
	}

	@Test
	@Tag("Positive")
	@DisplayName("Title: constant and empty")
	@Description("The widget with a title shows it above the chart; the widget without a title shows the chart only")
	void title() {
		var view = PlatformApp.screen("Line2D widget title").view();
		Line2DWidget constTitle = view.line2D(TITLE);
		DocShots.png(constTitle.element(), ARTICLE, "title.png", WIDTH, HEIGHT);

		Line2DWidget emptyTitle = view.line2DByName("MyExample4241Line2DEmptyTitle");
		emptyTitle.checkMode(mode -> assertThat(mode).isEqualTo(Mode.CHART));
		DocShots.png(emptyTitle.element(), ARTICLE, "title_empty.png", WIDTH, HEIGHT);
	}

	@Test
	@Tag("Positive")
	@DisplayName("Show condition: the chart follows a field of the form")
	@Description("The chart is shown while Custom Field > 5; after saving 3 it disappears, after saving 8 it is back")
	void showCondition() {
		var view = PlatformApp.screen("Line2D show condition").view();
		var form = view.form("Show condition by current entity");
		Line2DWidget chart = view.line2D(TITLE);
		chart.checkVisible(visible -> assertThat(visible).isTrue());

		DocShots.gif(ARTICLE, "show_cond_current.gif", 1660, 900, Frame.WITHOUT_SIDEBAR);
		form.number("Custom Field").setValue(new BigDecimal(3));
		form.actions().click("Save");
		chart.checkVisible(visible -> assertThat(visible).isFalse());

		form.number("Custom Field").setValue(new BigDecimal(8));
		form.actions().click("Save");
		chart.checkVisible(visible -> assertThat(visible).isTrue());
		DocShots.stop();
	}

	@Test
	@Tag("Positive")
	@DisplayName("Groups: a line per product, stacked or not")
	@Description("groupFieldKey splits the sum of a month by product; stack puts the lines one on another")
	void groups() {
		Line2DWidget grouped = PlatformApp.screen("Line2D groups").view().line2D(TITLE_GROUPS);
		DocShots.png(grouped.element(), ARTICLE, "groups.png", WIDTH, HEIGHT);
		var table = grouped.mode(Mode.TABLE).table();
		assertThat(table.rows().streamCurrentPage().count()).isEqualTo(12);
		table.rows().row(0).input(PRODUCT).checkValue(value -> assertThat(value).isEqualTo("Equipment"));
		table.rows().row(1).input(PRODUCT).checkValue(value -> assertThat(value).isEqualTo("Expertise"));
		grouped.mode(Mode.CHART);

		Line2DWidget stacked = PlatformApp.screen("Line2D stack").view().line2D("Sales sum per month, stacked by product");
		stacked.checkMode(mode -> assertThat(mode).isEqualTo(Mode.CHART));
		DocShots.png(stacked.element(), ARTICLE, "stack.png", WIDTH, HEIGHT);
	}

	@Test
	@Tag("Positive")
	@DisplayName("Axis: min, max and step of the Y axis")
	@Description("yMin, yMax and yStep set the scale of the numeric Y axis")
	void axis() {
		Line2DWidget chart = PlatformApp.screen("Line2D axis scale").view().line2D(TITLE);
		chart.checkMode(mode -> assertThat(mode).isEqualTo(Mode.CHART));
		DocShots.png(chart.element(), ARTICLE, "axis.png", WIDTH, HEIGHT);
	}

	@Test
	@Tag("Positive")
	@DisplayName("Tooltip: the text of descriptionFieldKey")
	@Description("The tooltip of a point shows the description field instead of the X value; the table mode shows the same text in its column")
	void tooltip() {
		Line2DWidget chart = PlatformApp.screen("Line2D tooltip").view().line2D(TITLE_GROUPS);
		chart.points()
				.filter(row -> "Feb".equals(row.xValueField().getValue()) && "Equipment".equals(row.groupField().getValue()))
				.findFirst().orElseThrow()
				.hover().checkTooltip(text -> assertThat(text).startsWith("Month 2, Equipment"));
		DocShots.png(chart.element(), ARTICLE, "tooltip.png", WIDTH, HEIGHT);
		chart.mode(Mode.TABLE).table().rows().row(2).input("Description")
				.checkValue(value -> assertThat(value).isEqualTo("Month 2, Equipment"));
		chart.mode(Mode.CHART);
	}

	@Test
	@Tag("Positive")
	@DisplayName("Color: from a field of the record and constant")
	@Description("bgColorKey on the X field colors every line by its data; bgColor gives all lines one color")
	void color() {
		var view = PlatformApp.screen("Line2D color").view();
		Line2DWidget fromField = view.line2D("Color from a field (bgColorKey)");
		DocShots.png(fromField.element(), ARTICLE, "color_key.png", WIDTH, HEIGHT);

		Line2DWidget constant = view.line2D("Constant color (bgColor)");
		DocShots.png(constant.element(), ARTICLE, "color_constant.png", WIDTH, HEIGHT);
	}

	@Test
	@Severity(CRITICAL)
	@Tag("Positive")
	@DisplayName("Drilldown: a click on a point opens the sales of the month and the product")
	@Description("The click on the April point of the Equipment line opens the view Sales filtered by the month and the product")
	void drillDown() {
		var screen = PlatformApp.screen("Line2D drilldown");
		Line2DWidget chart = screen.secondLevelView("Line2D").line2D(TITLE_GROUPS);

		DocShots.gif(ARTICLE, "drilldown.gif", 1660, 900, Frame.WITHOUT_SIDEBAR);
		chart.points()
				.filter(row -> "Apr".equals(row.xValueField().getValue()) && "Equipment".equals(row.groupField().getValue()))
				.findFirst().orElseThrow()
				.drilldown(url -> assertThat(url).contains("/screen/myexample4248/view/myexample4248list"));
		var sales = screen.view().listInline("Sales");
		assertThat(sales.rows().streamCurrentPage().map(row -> row.input("Client").getValue()))
				.containsExactlyInAnyOrder("Trade Prof Media LLC", "AcademWeb Holding", "GlobalTrade Partners");
		assertThat(sales.rows().streamCurrentPage().map(row -> row.dictionary(PRODUCT).getValue()))
				.containsOnly("Equipment");
		DocShots.stop();
		sales.headers().clearFilters();
	}

	@Test
	@Tag("Positive")
	@DisplayName("Table mode: a column per field, back to the chart")
	@Description("The gear menu switches the chart to the table with the fields of the widget as columns")
	void tableMode() {
		Line2DWidget chart = PlatformApp.screen("Line2D table mode").view().line2D(TITLE_GROUPS);
		DocShots.gif(ARTICLE, "table_mode.gif", 1660, 900, Frame.WITHOUT_SIDEBAR);
		var table = chart.mode(Mode.TABLE).table();
		assertThat(table.rows().streamCurrentPage().count()).isEqualTo(12);
		table.rows().row(0).input(MONTH).checkValue(value -> assertThat(value).isEqualTo("Jan"));
		table.rows().row(1).input(PRODUCT).checkValue(value -> assertThat(value).isEqualTo("Expertise"));
		chart.mode(Mode.CHART).checkMode(mode -> assertThat(mode).isEqualTo(Mode.CHART));
		DocShots.stop();
	}

	@Test
	@Tag("Negative")
	@DisplayName("No data: the backend returns no records")
	@Description("The widget shows No Data instead of the chart")
	void noData() {
		Line2DWidget chart = PlatformApp.screen("Line2D no data").view().line2D(TITLE);
		chart.checkNoData(noData -> assertThat(noData).isTrue());
		DocShots.png(chart.element(), ARTICLE, "no_data.png", WIDTH, HEIGHT);
	}

	@Test
	@Tag("Negative")
	@DisplayName("Page limit: more records than the page limit")
	@Description("The chart mode is not available when the business component has more records than its page limit")
	void pageLimit() {
		Line2DWidget chart = PlatformApp.screen("Line2D page limit").view().line2D(TITLE_GROUPS);
		chart.checkMode(mode -> assertThat(mode).isEqualTo(Mode.TABLE));
		chart.checkChartModeAvailable(available -> assertThat(available).isFalse());
		DocShots.png(chart.element(), ARTICLE, "page_limit.png", WIDTH, HEIGHT);
	}

}
