package application.Samples.DualAxes2D;

import static io.qameta.allure.SeverityLevel.CRITICAL;
import static org.assertj.core.api.Assertions.assertThat;

import application.config.BaseTestForSamples;
import core.element.PlatformApp;
import core.element.widget.chart.ChartWidget.Mode;
import core.element.widget.chart.DualAxes2DWidget;
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

@DisplayName("DualAxes2D. A Column2D and a Line2D chart in one area, its table mode")
@Epic("Samples")
@Feature(DualAxes2DTest.ARTICLE)
@Tag("Samples")
@Tag("DualAxes2D")
public class DualAxes2DTest extends BaseTestForSamples {

	static final String ARTICLE = "widget/type/dualaxes2d";

	private static final int WIDTH = 1600;

	private static final int HEIGHT = 900;

	private static final String TITLE = "Sales sum and number of sales per month";

	private static final String MONTH = "Month";

	private static final String PRODUCT = "Product";

	private static final String SUM = "Sum, $";

	private static final String COUNT = "Number of sales";

	@Test
	@Severity(CRITICAL)
	@Tag("Positive")
	@DisplayName("Basics: two charts with a common X axis and the same records in the table mode")
	@Description("The widget draws the charts of options.dual2D.widgets; the table mode shows a row per month and product")
	void basics() {
		DualAxes2DWidget chart = PlatformApp.screen("DualAxes2D widget basic").view().dualAxes2D(TITLE);
		chart.checkMode(mode -> assertThat(mode).isEqualTo(Mode.CHART));
		DocShots.png(chart.element(), ARTICLE, "dualaxes2d.png", WIDTH, HEIGHT);

		var table = chart.mode(Mode.TABLE).table();
		assertThat(table.rows().streamCurrentPage().count()).isEqualTo(12);
		table.rows().row(0).input(MONTH).checkValue(value -> assertThat(value).isEqualTo("Jan"));
		table.rows().row(0).input(PRODUCT).checkValue(value -> assertThat(value).isEqualTo("Equipment"));
		table.rows().row(0).number(SUM).checkValue(value -> assertThat(value).isEqualByComparingTo(new BigDecimal(2600)));
		table.rows().row(0).number(COUNT).checkValue(value -> assertThat(value).isEqualByComparingTo(new BigDecimal(2)));
		chart.mode(Mode.CHART).checkMode(mode -> assertThat(mode).isEqualTo(Mode.CHART));
	}

	@Test
	@Tag("Positive")
	@DisplayName("Title: constant and empty")
	@Description("The widget with a title shows it above the charts; the widget without a title shows the charts only")
	void title() {
		var view = PlatformApp.screen("DualAxes2D title").view();
		DualAxes2DWidget constTitle = view.dualAxes2D(TITLE);
		DocShots.png(constTitle.element(), ARTICLE, "title.png", WIDTH, HEIGHT);

		DualAxes2DWidget emptyTitle = view.dualAxes2DByName("myexample4281dualaxes2demptytitle");
		emptyTitle.checkMode(mode -> assertThat(mode).isEqualTo(Mode.CHART));
		DocShots.png(emptyTitle.element(), ARTICLE, "title_empty.png", WIDTH, HEIGHT);
	}

	@Test
	@Tag("Positive")
	@DisplayName("Show condition: the chart follows a field of the form")
	@Description("The chart is shown while Custom Field > 5; after saving 3 it disappears, after saving 8 it is back")
	void showCondition() {
		var view = PlatformApp.screen("DualAxes2D show condition").view();
		var form = view.form("Show condition by current entity");
		DualAxes2DWidget chart = view.dualAxes2D(TITLE);
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
	@DisplayName("Axis: min, max and step of both Y axes")
	@Description("yMin, yMax and yStep of the chart widgets set the scales of the left and the right Y axis")
	void axis() {
		DualAxes2DWidget chart = PlatformApp.screen("DualAxes2D axis scale and step").view().dualAxes2D(TITLE);
		chart.checkMode(mode -> assertThat(mode).isEqualTo(Mode.CHART));
		DocShots.png(chart.element(), ARTICLE, "axis.png", WIDTH, HEIGHT);
	}

	@Test
	@Tag("Positive")
	@DisplayName("Tooltip: the text of descriptionFieldKey")
	@Description("The tooltip of an element shows the description field of the record")
	void tooltip() {
		DualAxes2DWidget chart = PlatformApp.screen("DualAxes2D tooltip").view().dualAxes2D(TITLE);
		chart.hover("2-EQUIPMENT").checkTooltip(text -> assertThat(text).contains("Equipment: 3 sales, 4200 $"));
		DocShots.png(chart.element(), ARTICLE, "tooltip.png", WIDTH, HEIGHT);
	}

	@Test
	@Tag("Positive")
	@DisplayName("Color: the columns from a field of the record, the line constant")
	@Description("bgColorKey on the X field of the Column2D widget, bgColor on the X field of the Line2D widget")
	void color() {
		DualAxes2DWidget chart = PlatformApp.screen("DualAxes2D color").view().dualAxes2D(TITLE);
		chart.checkMode(mode -> assertThat(mode).isEqualTo(Mode.CHART));
		DocShots.png(chart.element(), ARTICLE, "color.png", WIDTH, HEIGHT);
	}

	@Test
	@Severity(CRITICAL)
	@Tag("Positive")
	@DisplayName("Drilldown: a click on a column opens the sales of the month and the product")
	@Description("The click on the April column of Equipment opens the view Sales filtered by the month and the product")
	void drillDown() {
		var screen = PlatformApp.screen("DualAxes2D drilldown");
		DualAxes2DWidget chart = screen.secondLevelView("DualAxes2D").dualAxes2D(TITLE);

		DocShots.gif(ARTICLE, "drilldown.gif", 1660, 900, Frame.WITHOUT_SIDEBAR);
		chart.click("4-EQUIPMENT");
		var sales = PlatformApp.currentScreen().view().listInline("Sales");
		assertThat(sales.rows().streamCurrentPage().count()).isEqualTo(4);
		assertThat(sales.rows().streamCurrentPage().map(row -> row.dictionary(PRODUCT).getValue())).containsOnly("Equipment");
		DocShots.stop();
		sales.headers().clearFilters();
	}

	@Test
	@Tag("Positive")
	@DisplayName("Table mode: a column per field of the DualAxes2D widget, back to the chart")
	@Description("The gear menu switches the chart to the table with the fields of the DualAxes2D widget as columns")
	void tableMode() {
		DualAxes2DWidget chart = PlatformApp.screen("DualAxes2D table mode").view().dualAxes2D(TITLE);
		DocShots.gif(ARTICLE, "table_mode.gif", 1660, 900, Frame.WITHOUT_SIDEBAR);
		var table = chart.mode(Mode.TABLE).table();
		assertThat(table.rows().streamCurrentPage().count()).isEqualTo(12);
		table.rows().row(1).input(PRODUCT).checkValue(value -> assertThat(value).isEqualTo("Expertise"));
		chart.mode(Mode.CHART).checkMode(mode -> assertThat(mode).isEqualTo(Mode.CHART));
		DocShots.stop();
	}

	@Test
	@Tag("Negative")
	@DisplayName("No data: the backend returns no records")
	@Description("The widget shows No Data instead of the charts")
	void noData() {
		DualAxes2DWidget chart = PlatformApp.screen("DualAxes2D no data").view().dualAxes2D(TITLE);
		chart.checkNoData(noData -> assertThat(noData).isTrue());
		DocShots.png(chart.element(), ARTICLE, "no_data.png", WIDTH, HEIGHT);
	}

	@Test
	@Tag("Negative")
	@DisplayName("Page limit: more records than the page limit")
	@Description("The chart mode is not available when the business component has more records than its page limit")
	void pageLimit() {
		DualAxes2DWidget chart = PlatformApp.screen("DualAxes2D page limit").view().dualAxes2D(TITLE);
		chart.checkMode(mode -> assertThat(mode).isEqualTo(Mode.TABLE));
		chart.checkChartModeAvailable(available -> assertThat(available).isFalse());
		DocShots.png(chart.element(), ARTICLE, "page_limit.png", WIDTH, HEIGHT);
	}

}
