package application.Samples.StatsBlock;

import application.config.BaseTestForSamples;
import core.element.PlatformApp;
import core.element.widget.statblock.StatsBlock;
import core.util.DocShots;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import java.math.BigDecimal;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.SeverityLevel.CRITICAL;
import static org.assertj.core.api.Assertions.assertThat;

/** The StatsBlock widget with a show condition by the parent entity. */
@DisplayName("StatsBlock. Show condition")
@Epic("Samples")
@Feature(StatsBlockShowConditionTest.ARTICLE)
@Tag("Samples")
@Tag("StatsBlock")
public class StatsBlockShowConditionTest extends BaseTestForSamples {

	static final String ARTICLE = "widget/type/statblocks";

	private static final BigDecimal CONDITION_MET = BigDecimal.valueOf(8);

	private static final BigDecimal CONDITION_NOT_MET = BigDecimal.valueOf(3);

	@Test
	@Severity(CRITICAL)
	@Tag("Positive")
	@DisplayName("Show condition by parent entity")
	@Description("The statistics are shown while Custom Field Number of the parent form is greater than 5; the condition is recalculated on save")
	void showConditionByParentEntity() {
		var view = PlatformApp.screen("StatsBlock show condition")
				.view()
				.checkUrl(url -> assertThat(url).contains("#/screen/myexample4230"));
		var parent = view.formByName("MyExample4232Parent");
		var stats = view.statBlockByName("MyExample4233Child");
		var customFieldNumber = parent.number("Custom Field Number");
		BigDecimal initialValue = customFieldNumber.getValue();

		// the picture of the article starts with the statistics shown
		customFieldNumber.setValue(CONDITION_MET);
		parent.actions().action("Save").click();
		stats.checkVisible(visible -> assertThat(visible).isTrue());

		DocShots.gif(ARTICLE, "show_cond.gif", 1280, 760, DocShots.Frame.WITHOUT_SIDEBAR);
		customFieldNumber.setValue(CONDITION_NOT_MET);
		parent.actions().action("Save").click();
		stats.checkVisible(visible -> assertThat(visible).isFalse());
		customFieldNumber.setValue(CONDITION_MET);
		parent.actions().action("Save").click();
		stats.checkVisible(visible -> assertThat(visible).isTrue());
		DocShots.stop();
		assertThat(stats.allBlocks()).extracting(StatsBlock::description).containsExactlyInAnyOrder("Meetings", "Calls");

		customFieldNumber.setValue(initialValue);
		parent.actions().action("Save").click();
	}

}
