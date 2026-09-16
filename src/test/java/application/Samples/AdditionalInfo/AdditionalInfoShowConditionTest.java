package application.Samples.AdditionalInfo;

import application.config.BaseTestForSamples;
import core.element.PlatformApp;
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

/** The AdditionalInfo widget with a show condition by the current entity. */
@DisplayName("AdditionalInfo. Show condition")
@Epic("Samples")
@Feature(AdditionalInfoShowConditionTest.ARTICLE)
@Tag("Samples")
@Tag("AdditionalInfo")
public class AdditionalInfoShowConditionTest extends BaseTestForSamples {

	static final String ARTICLE = "widget/type/additionalinfo";

	private static final BigDecimal CONDITION_MET = BigDecimal.ZERO;

	private static final BigDecimal CONDITION_NOT_MET = BigDecimal.valueOf(6);

	@Test
	@Severity(CRITICAL)
	@Tag("Positive")
	@DisplayName("The widget is shown while the saved value meets the show condition")
	@Description("Show condition by current entity: the widget is hidden after Custom Field Num 5 or more is saved and is shown again after a smaller value is saved")
	void showConditionByCurrentEntity() {
		var view = PlatformApp.screen("AdditionalInfo widget show condition").view();
		var form = view.form("Show condition by current entity");
		var info = view.additionalInfo("Additional information");
		var customFieldNum = form.number("Custom Field Num");
		BigDecimal initialValue = customFieldNum.getValue();

		// the picture of the article starts with the widget shown
		customFieldNum.setValue(CONDITION_MET);
		form.actions().action("Save").click();
		info.checkVisible(visible -> assertThat(visible).isTrue());

		// one change of the value per loop of the picture: the widget goes away right after the save
		DocShots.gif(ARTICLE, "show_cond_current.gif", 1280, 760, DocShots.Frame.WITHOUT_SIDEBAR);
		customFieldNum.setValue(CONDITION_NOT_MET);
		form.actions().action("Save").click();
		info.checkVisible(visible -> assertThat(visible).isFalse());
		DocShots.stop();

		customFieldNum.setValue(CONDITION_MET);
		form.actions().action("Save").click();
		info.checkVisible(visible -> assertThat(visible).isTrue());

		customFieldNum.setValue(initialValue);
		form.actions().action("Save").click();
	}

}
