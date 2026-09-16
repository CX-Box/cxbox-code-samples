package application.Samples.AdditionalInfo;

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

/** The AdditionalInfo widget with a show condition by the current entity. */
@DisplayName("AdditionalInfo. Show condition")
@Epic("Samples")
@Feature(AdditionalInfoShowConditionTest.ARTICLE)
@Tag("Samples")
@Tag("AdditionalInfo")
public class AdditionalInfoShowConditionTest extends BaseTestForSamples {

	static final String ARTICLE = "widget/type/additionalinfo";

	@Test
	@Severity(CRITICAL)
	@Tag("Positive")
	@DisplayName("The widget is shown only for the record that meets the show condition")
	@Description("Show condition by current entity: the widget is shown for a record with Custom Field Num less than 5 and hidden for the other records")
	void showConditionByCurrentEntity() {
		var view = PlatformApp.screen("AdditionalInfo widget show condition").view();
		var rows = view.listInline("List").rows();
		var info = view.additionalInfo("Additional information");
		DocShots.gif(ARTICLE, "show_cond_current.gif", 1660, 760, DocShots.Frame.WITHOUT_SIDEBAR);
		// "test data": Custom Field Num 0
		rows.clickRow(1);
		info.checkVisible(visible -> assertThat(visible).isTrue());
		// "test data2": Custom Field Num 6
		rows.clickRow(0);
		assertThat(info.isVisible()).isFalse();
		DocShots.stop();
	}

}
