package application.Samples.Column2D;

import static io.qameta.allure.SeverityLevel.CRITICAL;
import static org.assertj.core.api.Assertions.assertThat;

import application.config.BaseTestForSamples;
import core.element.PlatformApp;
import core.element.widget.chart.ChartWidget.Mode;
import core.element.widget.chart.Column2DWidget;
import core.util.DocShots;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import java.math.BigDecimal;
import java.math.BigDecimal;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

@DisplayName("Column2D. The chart, its table mode and the options of chart2D")
@Epic("Samples")
@Feature(Column2DTest.ARTICLE)
@Tag("Samples")
@Tag("Column2D")
public class Column2DTest extends BaseTestForSamples {

	static final String ARTICLE = "widget/type/column2d";

	private static final int WIDTH = 1600;

	private static final int HEIGHT = 900;

	private static final BigDecimal CONDITION_MET = BigDecimal.valueOf(8);

	private static final BigDecimal CONDITION_NOT_MET = BigDecimal.valueOf(3);

	@Test
	@Severity(CRITICAL)
	@Tag("Positive")
	@DisplayName("Basics: the chart and the same records in the table mode")
	@Description("The chart opens in the chart mode; the gear menu switches it to the table with a row per bar and back")
	void basics() {
		Column2DWidget chart = PlatformApp.screen("Column2D widget basic").view().column2D("Sales per client");
		chart.checkMode(mode -> assertThat(mode).isEqualTo(Mode.CHART));
		chart.rows().row(0)
				.xValueField().checkValue(x -> assertThat(x).isEqualTo("AcademWeb Holding"))
				.yValueField().checkValue(y -> assertThat(y).isEqualTo("2600"));
		DocShots.png(chart.element(), ARTICLE, "column2d.png", WIDTH, HEIGHT);

		var table = chart.mode(Mode.TABLE).table();
		chart.checkMode(mode -> assertThat(mode).isEqualTo(Mode.TABLE));
		assertThat(table.rows().streamCurrentPage().count()).isEqualTo(5);
		table.rows().row(0).input("Client").checkValue(value -> assertThat(value).isEqualTo("AcademWeb Holding"));
		DocShots.png(chart.element(), ARTICLE, "tablemode.png", WIDTH, HEIGHT);

		chart.mode(Mode.CHART).checkMode(mode -> assertThat(mode).isEqualTo(Mode.CHART));
	}

	@Test
	@Tag("Positive")
	@DisplayName("Title: constant and empty")
	@Description("The widget with a title shows it above the chart; the widget without a title shows the chart only")
	void title() {
		var screen = PlatformApp.screen("Column2D widget title");
		Column2DWidget constTitle = screen.secondLevelView("Constant title").column2D("Sales per client");
		DocShots.png(constTitle.element(), ARTICLE, "consttitle.png", WIDTH, HEIGHT);

		Column2DWidget emptyTitle = screen.secondLevelView("Empty title").column2DByName("MyExample4253Column2DEmptyTitle");
		emptyTitle.checkMode(mode -> assertThat(mode).isEqualTo(Mode.CHART));
		DocShots.png(emptyTitle.element(), ARTICLE, "emptytitle.png", WIDTH, HEIGHT);
	}

	@Test
	@Tag("Positive")
	@DisplayName("Show condition by current entity")
	@Description("The chart is shown while Custom Field of the form is greater than 5; the condition is recalculated on save")
	void showCondition() {
		var view = PlatformApp.screen("Column2D widget show condition").view();
		var form = view.formByName("MyExample4276Form");
		Column2DWidget chart = view.column2DByName("MyExample4276Column2D");
		var customField = form.number("Custom Field");
		BigDecimal initialValue = customField.getValue();

		customField.setValue(CONDITION_MET);
		form.actions().action("Save").click();
		chart.checkVisible(visible -> assertThat(visible).isTrue());

		DocShots.gif(ARTICLE, "show_cond_current.gif", WIDTH, HEIGHT, DocShots.Frame.WITHOUT_SIDEBAR);
		customField.setValue(CONDITION_NOT_MET);
		form.actions().action("Save").click();
		chart.checkVisible(visible -> assertThat(visible).isFalse());
		customField.setValue(CONDITION_MET);
		form.actions().action("Save").click();
		chart.checkVisible(visible -> assertThat(visible).isTrue());
		DocShots.stop();

		customField.setValue(initialValue);
		form.actions().action("Save").click();
	}

	@Test
	@Tag("Positive")
	@DisplayName("Group: bars side by side and stacked")
	@Description("groupFieldKey splits every client by product; stack puts the bars of a client one on another")
	void group() {
		var screen = PlatformApp.screen("Column2D widget group");
		Column2DWidget grouped = screen.secondLevelView("Grouped").column2DByName("MyExample4254Column2D");
		DocShots.png(grouped.element(), ARTICLE, "group.png", WIDTH, HEIGHT);
		assertThat(grouped.bars()
				.filter(row -> "Info Trust".equals(row.xValueField().getValue()))
				.map(row -> row.groupField().getValue()))
				.containsExactly("Equipment", "Expertise");
		var table = grouped.mode(Mode.TABLE).table();
		assertThat(table.rows().streamCurrentPage().count()).isEqualTo(10);
		table.rows().row(0).input("Product").checkValue(value -> assertThat(value).isEqualTo("Equipment"));
		grouped.mode(Mode.CHART);

		Column2DWidget stacked = screen.secondLevelView("Stacked").column2DByName("MyExample4254Column2DStack");
		DocShots.png(stacked.element(), ARTICLE, "stack.png", WIDTH, HEIGHT);
	}

	@Test
	@Tag("Positive")
	@DisplayName("Axes: min, max and step of the Y axis")
	@Description("yMin, yMax and yStep set the scale of the numeric Y axis")
	void axes() {
		Column2DWidget chart = PlatformApp.screen("Column2D widget axes").view().column2D("Sales per client");
		chart.checkMode(mode -> assertThat(mode).isEqualTo(Mode.CHART));
		DocShots.png(chart.element(), ARTICLE, "axes.png", WIDTH, HEIGHT);
	}

	@Test
	@Tag("Positive")
	@DisplayName("Tooltip: the text of descriptionFieldKey")
	@Description("The tooltip of a bar shows the description field instead of the X value")
	void tooltip() {
		Column2DWidget chart = PlatformApp.screen("Column2D widget tooltip").view().column2D("Sales per client");
		chart.bars()
				.filter(row -> "Info Trust".equals(row.xValueField().getValue()))
				.findFirst().orElseThrow()
				.descriptionField().checkValue(description -> assertThat(description).isEqualTo("Info Trust: 3 sales"))
				.hover()
				.checkTooltip(tooltip -> assertThat(tooltip).startsWith("Info Trust: 3 sales"));
		DocShots.png(chart.element(), ARTICLE, "tooltip.png", WIDTH, HEIGHT);
	}

	@Test
	@Tag("Positive")
	@DisplayName("Color: calculated per group and constant")
	@Description("bgColorKey on the X field colors the groups by the data; bgColor gives all bars one color")
	void color() {
		var screen = PlatformApp.screen("Column2D widget color");
		Column2DWidget calculated = screen.secondLevelView("Calculated color").column2DByName("MyExample4257Column2D");
		DocShots.png(calculated.element(), ARTICLE, "colorcalculated.png", WIDTH, HEIGHT);
		calculated.bars()
				.filter(row -> "Expertise".equals(row.groupField().getValue()))
				.forEach(row -> row.bgColor().checkValue(color -> assertThat(color).isEqualTo("#30BA8F")));

		Column2DWidget constant = screen.secondLevelView("Constant color").column2DByName("MyExample4257Column2DColorConst");
		DocShots.png(constant.element(), ARTICLE, "colorconst.png", WIDTH, HEIGHT);
		constant.bars()
				.forEach(row -> row.bgColor().checkValue(color -> assertThat(color).isEqualTo("#EDA6A6")));
	}

	@Test
	@Severity(CRITICAL)
	@Tag("Positive")
	@DisplayName("DrillDown: a click on a bar opens the sales of the client")
	@Description("A click on the bar of a client opens the list of sales filtered by this client")
	void drillDown() {
		var screen = PlatformApp.screen("Column2D widget drilldown");
		Column2DWidget chart = screen.secondLevelView("Column2D").column2D("Sales per client");

		DocShots.gif(ARTICLE, "drilldown.gif", WIDTH, HEIGHT, DocShots.Frame.WITHOUT_SIDEBAR);
		chart.bars()
				.filter(row -> "Info Trust".equals(row.xValueField().getValue()))
				.findFirst().orElseThrow()
				.drilldown(url -> assertThat(url).contains("/screen/myexample4258/view/myexample4258sales"));
		var sales = screen.view().listInline("Sales");
		assertThat(sales.rows().streamCurrentPage().map(row -> row.input("Client").getValue()))
				.containsExactly("Info Trust", "Info Trust", "Info Trust");
		DocShots.stop();

		sales.headers().clearFilters();
	}

	@Test
	@Tag("Positive")
	@DisplayName("DrillDown: the link of the X value in the table mode")
	@Description("In the table mode the X value is a link with the same drilldown as the bar")
	void drillDownFromTable() {
		var screen = PlatformApp.screen("Column2D widget drilldown");
		Column2DWidget chart = screen.secondLevelView("Column2D").column2D("Sales per client");

		chart.mode(Mode.TABLE).table().rows().row(2).input("Client")
				.drilldown(url -> assertThat(url).contains("/screen/myexample4258/view/myexample4258sales"));
		var sales = screen.view().listInline("Sales");
		assertThat(sales.rows().streamCurrentPage().map(row -> row.input("Client").getValue()))
				.containsExactly("Info Trust", "Info Trust", "Info Trust");

		sales.headers().clearFilters();
	}

	@Test
	@Tag("Negative")
	@DisplayName("Limit: more records than the page limit")
	@Description("The chart mode is not available when the business component has more records than its page limit")
	void limit() {
		Column2DWidget chart = PlatformApp.screen("Column2D widget limit").view().column2D("Sales per client");
		chart.checkMode(mode -> assertThat(mode).isEqualTo(Mode.TABLE));
		chart.checkChartModeAvailable(available -> assertThat(available).isFalse());
		DocShots.png(chart.element(), ARTICLE, "limit.png", WIDTH, HEIGHT);
	}

	@Test
	@Tag("Negative")
	@DisplayName("No data: the backend returns no records")
	@Description("The widget shows No Data instead of the chart")
	void noData() {
		Column2DWidget chart = PlatformApp.screen("Column2D widget no data").view().column2D("Sales per client");
		chart.checkNoData(noData -> assertThat(noData).isTrue());
		DocShots.png(chart.element(), ARTICLE, "nodata.png", WIDTH, HEIGHT);
	}

}
