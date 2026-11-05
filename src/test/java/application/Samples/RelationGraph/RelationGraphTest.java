package application.Samples.RelationGraph;

import static io.qameta.allure.SeverityLevel.CRITICAL;
import static org.assertj.core.api.Assertions.assertThat;

import application.config.BaseTestForSamples;
import com.codeborne.selenide.Selenide;
import core.element.PlatformApp;
import core.element.widget.chart.ChartWidget.Mode;
import core.element.widget.chart.RelationGraphWidget;
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

@DisplayName("RelationGraph. The graph of the edges, its options and its table mode")
@Epic("Samples")
@Feature(RelationGraphTest.ARTICLE)
@Tag("Samples")
@Tag("RelationGraph")
public class RelationGraphTest extends BaseTestForSamples {

	static final String ARTICLE = "widget/type/relationgraph";

	private static final int WIDTH = 1600;

	private static final int HEIGHT = 900;

	private static final String TITLE = "Sales network";

	private static final String COMPANY = "Company";

	@Test
	@Severity(CRITICAL)
	@Tag("Positive")
	@DisplayName("Basics: a node per company, an edge per record")
	@Description("The graph shows the root company and its sales network; the table mode shows a row per record")
	void basics() {
		RelationGraphWidget graph = PlatformApp.screen("RelationGraph widget basic").view().relationGraph(TITLE);
		graph.checkMode(mode -> assertThat(mode).isEqualTo(Mode.CHART));
		graph.checkNodeTitles(titles -> assertThat(titles).hasSize(8).contains("Main office", "Smart Retail"));
		DocShots.png(graph.element(), ARTICLE, "relationgraph.png", WIDTH, HEIGHT);

		var table = graph.mode(Mode.TABLE).table();
		assertThat(table.rows().streamCurrentPage().count()).isEqualTo(8);
		table.rows().row(0).input(COMPANY).checkValue(value -> assertThat(value).isEqualTo("Main office"));
		graph.mode(Mode.CHART).checkMode(mode -> assertThat(mode).isEqualTo(Mode.CHART));
	}

	@Test
	@Tag("Positive")
	@DisplayName("Title: constant and empty")
	@Description("The widget with a title shows it above the graph; the widget without a title shows the graph only")
	void title() {
		var view = PlatformApp.screen("RelationGraph title").view();
		DocShots.png(view.relationGraph(TITLE).element(), ARTICLE, "title.png", WIDTH, HEIGHT);
		RelationGraphWidget emptyTitle = view.relationGraphByName("myexample6152relationgraphemptytitle");
		emptyTitle.checkMode(mode -> assertThat(mode).isEqualTo(Mode.CHART));
		DocShots.png(emptyTitle.element(), ARTICLE, "title_empty.png", WIDTH, HEIGHT);
	}

	@Test
	@Tag("Positive")
	@DisplayName("Show condition: the graph follows a field of the form")
	@Description("The graph is shown while Custom Field > 5; after saving 3 it disappears, after saving 8 it is back")
	void showCondition() {
		var view = PlatformApp.screen("RelationGraph show condition").view();
		var form = view.form("Show condition by current entity");
		RelationGraphWidget graph = view.relationGraph(TITLE);
		graph.checkVisible(visible -> assertThat(visible).isTrue());

		DocShots.gif(ARTICLE, "show_cond_current.gif", 1660, 900, Frame.WITHOUT_SIDEBAR);
		form.number("Custom Field").setValue(new BigDecimal(3));
		form.actions().click("Save");
		graph.checkVisible(visible -> assertThat(visible).isFalse());

		form.number("Custom Field").setValue(new BigDecimal(8));
		form.actions().click("Save");
		graph.checkVisible(visible -> assertThat(visible).isTrue());
		DocShots.stop();
	}

	@Test
	@Tag("Positive")
	@DisplayName("Mode: TB, BT, LR, RL")
	@Description("mode sets the direction of the graph")
	void mode() {
		var view = PlatformApp.screen("RelationGraph mode").view();
		for (String mode : new String[]{"TB", "BT", "LR", "RL"}) {
			RelationGraphWidget graph = view.relationGraph("Mode " + mode);
			graph.checkNodeTitles(titles -> assertThat(titles).hasSize(8));
			DocShots.png(graph.element(), ARTICLE, "mode_" + mode.toLowerCase() + ".png", WIDTH, HEIGHT);
		}
	}

	@Test
	@Tag("Positive")
	@DisplayName("Nodes: the title, the description lines and the width")
	@Description("descriptionFieldKeys: the company is the title, the city is the line under it; width of the target node field")
	void nodes() {
		RelationGraphWidget graph = PlatformApp.screen("RelationGraph nodes").view().relationGraph(TITLE);
		graph.checkNodeTitles(titles -> assertThat(titles).contains("North branch"));
		DocShots.png(graph.element(), ARTICLE, "nodes.png", WIDTH, HEIGHT);
	}

	@Test
	@Tag("Positive")
	@DisplayName("Edges: the label and the type of the line")
	@Description("labelFieldKeys joins the description and the sum; type polyline, line, arc, quadratic")
	void edges() {
		var view = PlatformApp.screen("RelationGraph edges").view();
		for (String type : new String[]{"polyline", "line", "arc", "quadratic"}) {
			RelationGraphWidget graph = view.relationGraph("Edge type " + type);
			graph.checkNodeTitles(titles -> assertThat(titles).hasSize(8));
			DocShots.png(graph.element(), ARTICLE, "edges_" + type + ".png", WIDTH, HEIGHT);
		}
	}

	@Test
	@Tag("Positive")
	@DisplayName("Color: from a field of the record and constant")
	@Description("bgColorKey on the target node field and on edgeValue colors the nodes and the edges by the data; bgColor gives one color")
	void color() {
		var view = PlatformApp.screen("RelationGraph color").view();
		DocShots.png(view.relationGraph("Color from a field (bgColorKey)").element(), ARTICLE, "color_key.png", WIDTH, HEIGHT);
		DocShots.png(view.relationGraph("Constant color (bgColor)").element(), ARTICLE, "color_constant.png", WIDTH, HEIGHT);
	}

	@Test
	@Severity(CRITICAL)
	@Tag("Positive")
	@DisplayName("Drilldown: a click on a node opens the card of the company")
	@Description("The click on the node North branch opens the view Company of this company")
	void drillDown() {
		RelationGraphWidget graph = PlatformApp.screen("RelationGraph drilldown").secondLevelView("RelationGraph").relationGraph(TITLE);
		DocShots.gif(ARTICLE, "drilldown.gif", 1660, 900, Frame.WITHOUT_SIDEBAR);
		graph.clickNode("North branch");
		PlatformApp.currentScreen().view().info(COMPANY).input(COMPANY)
				.checkValue(value -> assertThat(value).isEqualTo("North branch"));
		DocShots.stop();
	}

	@Test
	@Tag("Positive")
	@DisplayName("Main node and collapsed nodes")
	@Description("North branch is the main node; South branch is collapsed: its client is hidden until the marker is clicked")
	void expand() {
		RelationGraphWidget graph = PlatformApp.screen("RelationGraph main node and collapsed nodes").view().relationGraph(TITLE);
		graph.checkNodeTitles(titles -> assertThat(titles).hasSize(7).doesNotContain("GlobalTrade Partners"));
		DocShots.gif(ARTICLE, "expand.gif", 1660, 900, Frame.WITHOUT_SIDEBAR);
		graph.clickMarker("South branch");
		graph.checkNodeTitles(titles -> assertThat(titles).hasSize(8).contains("GlobalTrade Partners"));
		DocShots.stop();
	}

	@Test
	@Tag("Positive")
	@DisplayName("Drag node: the user moves a node")
	@Description("dragNode allows the user to move a node with the mouse")
	void dragNode() {
		RelationGraphWidget graph = PlatformApp.screen("RelationGraph drag node").view().relationGraph(TITLE);
		graph.checkNodeTitles(titles -> assertThat(titles).hasSize(8));
		DocShots.png(graph.element(), ARTICLE, "drag_node.png", WIDTH, HEIGHT);
	}

	@Test
	@Tag("Positive")
	@DisplayName("Field keys: other fields for the ids of the nodes")
	@Description("nodes.fieldKeys sets parentCompanyId and companyId as the source and the target")
	void fieldKeys() {
		RelationGraphWidget graph = PlatformApp.screen("RelationGraph field keys").view().relationGraph(TITLE);
		graph.checkNodeTitles(titles -> assertThat(titles).hasSize(8));
		DocShots.png(graph.element(), ARTICLE, "field_keys.png", WIDTH, HEIGHT);
	}

	@Test
	@Severity(CRITICAL)
	@Tag("Positive")
	@DisplayName("Select record: a click on a node selects its incoming edge")
	@Description("The Info widget of the same business component shows the company of the clicked node")
	void selectRecord() {
		var view = PlatformApp.screen("RelationGraph select record").view();
		RelationGraphWidget graph = view.relationGraph(TITLE);
		var info = view.info("Selected company");
		DocShots.gif(ARTICLE, "select_record.gif", 1660, 900, Frame.WITHOUT_SIDEBAR);
		graph.clickNode("Trade Prof Media LLC");
		info.input(COMPANY).checkValue(value -> assertThat(value).isEqualTo("Trade Prof Media LLC"));
		graph.clickEdge("East branch");
		info.input(COMPANY).checkValue(value -> assertThat(value).isEqualTo("East branch"));
		Selenide.sleep(500);
		DocShots.stop();
	}

	@Test
	@Tag("Positive")
	@DisplayName("Table mode: a row per edge, back to the graph")
	@Description("The gear menu switches the graph to the table with the fields of the widget as columns")
	void tableMode() {
		RelationGraphWidget graph = PlatformApp.screen("RelationGraph widget basic").view().relationGraph(TITLE);
		DocShots.gif(ARTICLE, "table_mode.gif", 1660, 900, Frame.WITHOUT_SIDEBAR);
		var table = graph.mode(Mode.TABLE).table();
		assertThat(table.rows().streamCurrentPage().count()).isEqualTo(8);
		graph.mode(Mode.CHART).checkMode(mode -> assertThat(mode).isEqualTo(Mode.CHART));
		DocShots.stop();
	}

	@Test
	@Tag("Negative")
	@DisplayName("Incorrect data: the same edge twice")
	@Description("Two records with the same source and target: only the table mode is available")
	void incorrectData() {
		RelationGraphWidget graph = PlatformApp.screen("RelationGraph incorrect data").view().relationGraph(TITLE);
		graph.checkMode(mode -> assertThat(mode).isEqualTo(Mode.TABLE));
		graph.checkChartModeAvailable(available -> assertThat(available).isFalse());
		DocShots.png(graph.element(), ARTICLE, "incorrect_data.png", WIDTH, HEIGHT);
	}

	@Test
	@Tag("Negative")
	@DisplayName("No data: the backend returns no records")
	@Description("The widget shows No Data instead of the graph")
	void noData() {
		RelationGraphWidget graph = PlatformApp.screen("RelationGraph no data").view().relationGraph(TITLE);
		graph.checkNoData(noData -> assertThat(noData).isTrue());
		DocShots.png(graph.element(), ARTICLE, "no_data.png", WIDTH, HEIGHT);
	}

}
