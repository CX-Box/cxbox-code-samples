package Samples.Info;

import application.config.BaseTestForSamples;
import core.element.PlatformApp;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.SeverityLevel.MINOR;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class TextOnInfoTest extends BaseTestForSamples {

	@Disabled
	@Test
	@Tag("Positive")
	@DisplayName("Test for getting the Placeholder value")
	@Description("The InfoWidget doesn't have a Placeholder.")
	void placeholder() {
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
	@DisplayName("A test to get the field color value in Hex format")
	@Description("The test gets the value from the style attribute in RGB format, and then converts it to Hex format")
	void color() {
		var info = PlatformApp
				.screen("Text color")
				.secondLevelView("Info")
				.info("Info title");
		info.text("Custom Field")
				.checkColor(color -> assertThat(color).isEqualTo("#EDA6A6"));
	}

	@Test
	@Tag("Positive")
	@DisplayName("The test for getting the value from the field")
	void read() {
		var info = PlatformApp.screen("Text basic")
				.secondLevelView("Info")
				.info("Info title");
		info.text("Custom Field")
				.checkValue(val -> assertThat(val).isEqualTo("Unlike a digital typeface, a metal font would not include a single definition of each character, but commonly used characters (such as vowel..."));
	}

	@Test
	@Tag("Positive")
	@DisplayName("The DrillDown test")
	@Description("DrillDown is not available for InfoWidget.")
	void drillDown() {
		var info = PlatformApp
				.screen("Text drilldown")
				.secondLevelView("Info")
				.info("Info title");
		info.text("Custom Field")
				.drilldown(url -> assertThat(url).isNotEmpty());
	}
}