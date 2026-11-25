package application.Samples.ChartHeight;

import static io.qameta.allure.SeverityLevel.CRITICAL;
import static org.assertj.core.api.Assertions.assertThat;

import application.config.BaseTestForSamples;
import core.element.PlatformApp;
import core.element.screen.view.PlatformView;
import core.element.widget.chart.ChartWidget;
import core.util.DocShots;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

/**
 * maxRows of the charts. Funnel and RingProgress have tabs in the sample too, but the test core has no widget of these
 * types to measure.
 */
@DisplayName("Chart height. maxRows of every chart of the article")
@Epic("Samples")
@Feature(ChartHeightTest.ARTICLE)
@Tag("Samples")
@Tag("ChartHeight")
public class ChartHeightTest extends BaseTestForSamples {

	static final String ARTICLE = "widget/type/property/chartheight";

	private static final int WIDTH = 1600;

	private static final int HEIGHT = 900;

	/** maxRows 3: three rows of a standard form, 88 px each. */
	private static final int THREE_ROWS = 264;

	@ParameterizedTest(name = "{0}")
	@ValueSource(strings = {"Column2D", "Line2D", "DualAxes2D", "Pie1D", "RelationGraph"})
	@Severity(CRITICAL)
	@Tag("Positive")
	@DisplayName("maxRows 3: ")
	@Description("maxRows in the options of the chart sets the height of the chart in rows of a standard form")
	void chartHeight(String tab) {
		PlatformView view = PlatformApp.screen("Widget property Chart height").secondLevelView(tab);
		ChartWidget<?> chart = switch (tab) {
			case "Column2D" -> view.column2DByName("myexample4279column2d");
			case "Line2D" -> view.line2DByName("myexample4279line2d");
			case "DualAxes2D" -> view.dualAxes2DByName("myexample4279dualaxes2d");
			case "Pie1D" -> view.pie1DByName("myexample4279pie1d");
			default -> view.relationGraphByName("myexample4279relationgraph");
		};
		chart.checkChartHeight(height -> assertThat(height).isEqualTo(THREE_ROWS));
		DocShots.png(chart.element(), ARTICLE, "chartheight_" + tab.toLowerCase() + ".png", WIDTH, HEIGHT);
	}

}
