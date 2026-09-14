package application.Samples.Info;

import application.config.BaseTestForSamples;
import application.custom.Position;
import core.element.PlatformApp;
import core.util.DocShots;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.SeverityLevel.MINOR;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DisplayName("Info. Checking the basic functions for the Hint")
@Epic("Samples")
@Feature(HintOnInfoTest.ARTICLE)
@Tag("Samples")
public class HintOnInfoTest extends BaseTestForSamples {

	static final String ARTICLE = "widget/fields/field/hint";

	@Test
	@Tag("Positive")
	@DisplayName("A test to get the field color value in Hex format")
	@Description("The test gets the value from the style attribute in RGB format, and then converts it to Hex format")
	void color() {
		var info = PlatformApp.screen("Hint color")
				.secondLevelView("Info")
				.info("Info title");
		info.hint("Custom Field")
				.checkColor(color -> assertThat(color).isEqualTo("#EDA6A6"));
		DocShots.png(info.element(), ARTICLE, "img_color_info.png", 1600, 1000);
	}

	@Disabled
	@Test
	@Tag("Positive")
	@DisplayName("A test to check the field for \"Read-only\"")
	@Description("Info Widget is always read-only")
	void readonly() {
	}

	@Disabled
	@Test
	@Severity(MINOR)
	@Tag("Negative")
	@DisplayName("Filtering test")
	@Description("Filtering is not available for InfoWidget.")
	void filtration() {
	}

	@Test
	@Tag("Positive")
	@DisplayName("The DrillDown test")
	@Description("Checking the url before the transition and after the transition/click on a special element")
	void drillDown() {
		var info = PlatformApp.screen("Hint drilldown")
				.secondLevelView("Info")
				.info("Info title");
		DocShots.png(info.element(), ARTICLE, "img_drilldown_info.png", 1600, 1000);
		info.hint("Custom Field")
				.drilldown(url -> assertThat(url).contains("/screen/myexample161/view/myexample161form/myExampleBc161/"));
	}

	@Disabled
	@Test
	@Severity(MINOR)
	@Tag("Negative")
	@DisplayName("Sorting test")
	@Description("Sorting is not available for InfoWidget.")
	void sorting() {
	}

	@Test
	@Tag("Positive")
	@DisplayName("The test for getting the value from the field")
	void read() {
		var info = PlatformApp.screen("Hint basic")
				.secondLevelView("Info")
				.info("Info title");
		info.hint("Custom Field")
				.checkValue(val -> assertThat(val).isEqualTo("Information data"));
		DocShots.png(info.element(), ARTICLE, "img_info.png", 1600, 1000);
	}

	@Test
	void position() {
		assertTrue(Position.checkPosition(302, 94, PlatformApp.screen("Hint basic").secondLevelView("Info").info("Info title").element()));
	}
}
