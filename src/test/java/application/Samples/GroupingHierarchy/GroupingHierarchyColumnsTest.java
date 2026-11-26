package application.Samples.GroupingHierarchy;

import application.config.BaseTestForSamples;
import core.element.PlatformApp;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.SeverityLevel.CRITICAL;
import static org.assertj.core.api.Assertions.assertThat;

/** The window of the columns of the GroupingHierarchy widget: the column of the grouping cannot leave the table. */
@DisplayName("GroupingHierarchy. Customization of displayed columns")
@Epic("Samples")
@Feature(GroupingHierarchyColumnsTest.ARTICLE)
@Tag("Samples")
@Tag("GroupingHierarchy")
public class GroupingHierarchyColumnsTest extends BaseTestForSamples {

	static final String ARTICLE = "widget/type/groupinghierarchy";

	private static final String GROUPING = "Custom Field Dictionary";

	@Test
	@Severity(CRITICAL)
	@Tag("Positive")
	@DisplayName("The column of the grouping stays in the table")
	@Description("Clear in the window of the columns moves all columns to Additional except the column of the grouping; Reset returns the columns")
	void groupingColumnStaysInTable() {
		var gh = PlatformApp.screen("GroupingHierarchy (GH) widget customization columns")
				.secondLevelView("GroupingHierarchy widget")
				.groupingHierarchyInline("GroupingHierarchy");
		var columns = gh.settings().changeColumns().clear();
		assertThat(columns.getValue()).containsExactly(GROUPING);
		columns.close();
		gh.settings().select("Reset");
		assertThat(gh.headers().names()).containsExactly(GROUPING, "customField", "Custom Field Text");
	}
}
