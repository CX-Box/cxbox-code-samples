package application.Samples.Feature.drilldown;

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

/**
 * DrillDown article, section "Link from a record field: drillDownKey": Form and List show one business component.
 * The List field drills down by the link of the record field, the Form field by the link from the meta.
 */
@DisplayName("Drilldown. drillDownKey of the clicked widget")
@Epic("Samples")
@Feature(DrillDownKeyTest.ARTICLE)
@Tag("Samples")
@Tag("Feature")
public class DrillDownKeyTest extends BaseTestForSamples {

	static final String ARTICLE = "features/element/drilldown";

	private static final String SCREEN = "Feature Drilldown drillDownKey";

	private static final String VIEW = "Form and List";

	@Test
	@Severity(CRITICAL)
	@Tag("Positive")
	@DisplayName("List field drills down by its drillDownKey")
	@Description("The List field has drillDownKey, the Form above it on the same business component has not: the List click opens the link of the record field")
	void listByDrillDownKey() {
		var list = PlatformApp.screen(SCREEN)
				.secondLevelView(VIEW)
				.listInline("List: drill-down by drillDownKey");
		DocShots.gif(ARTICLE, "drilldownkey.gif", 1280, 800, DocShots.Frame.WITHOUT_SIDEBAR);
		list.rows().row(0).input("Custom Field")
				.drilldown(url -> assertThat(url).contains("/screen/myexample3627/view/myexample3627key/myexample3627/"));
		DocShots.stop();
	}

	@Test
	@Severity(CRITICAL)
	@Tag("Positive")
	@DisplayName("Form field without drillDownKey drills down by the meta link")
	@Description("The Form field has no drillDownKey: the click opens the link of fields.setDrilldown")
	void formByMeta() {
		var form = PlatformApp.screen(SCREEN)
				.secondLevelView(VIEW)
				.form("Form: drill-down from meta");
		form.input("Custom Field")
				.drilldown(url -> assertThat(url).contains("/screen/myexample3627/view/myexample3627meta/myexample3627/"));
	}

}
