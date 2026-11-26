package application.Samples.StatsBlock;

import application.config.BaseTestForSamples;
import core.element.PlatformApp;
import core.util.DocShots;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.SeverityLevel.CRITICAL;
import static org.assertj.core.api.Assertions.assertThat;

/** The drilldown of the StatsBlock widget: a block opens the list filtered by its statuses. */
@DisplayName("StatsBlock. Drilldown")
@Epic("Samples")
@Feature(StatsBlockDrillDownTest.ARTICLE)
@Tag("Samples")
@Tag("StatsBlock")
public class StatsBlockDrillDownTest extends BaseTestForSamples {

	static final String ARTICLE = "widget/type/statblocks";

	@Test
	@Severity(CRITICAL)
	@Tag("Positive")
	@DisplayName("Drilldown: a block filters the list by two statuses")
	@Description("The block Open opens the list filtered by the statuses New and In progress: the list shows the records of both statuses")
	void drillDownByTwoStatuses() {
		var view = PlatformApp.screen("StatsBlock widget filter for List widget").secondLevelView("Drilldown");
		var stats = view.statBlock("StatsBlock title");
		var list = view.listInline("List title");

		DocShots.gif(ARTICLE, "drilldown.gif", 1280, 1000, DocShots.Frame.WITHOUT_SIDEBAR);
		stats.block("Open").drilldown(url -> assertThat(url).contains("/screen/myexample4210/view/myexample4210list"));
		assertThat(list.rows().streamCurrentPage().map(row -> row.dictionary("Custom Field Status").getValue()))
				.containsExactlyInAnyOrder("New", "New", "New", "In progress");
		DocShots.stop();

		list.headers().clearFilters();
	}

}
