package sample.info;

import application.config.BaseTestForSamples;
import core.element.PlatformApp;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Severity;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.SeverityLevel.MINOR;
import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("Info. Checking the basic functions for the Input")
@Epic("application/Samples")
@Tag("application/Samples")
public class InputTest extends BaseTestForSamples {

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
	@DisplayName("Test for getting the Placeholder value")
	@Description("The InfoWidget doesn't have a Placeholder.")
	void placeholder() {
		var info = PlatformApp
				.screen("Input placeholder")
				.secondLevelView("Info")
				.info("Info");
		info.input("customField")
				.checkPlaceholder(pl -> assertThat(pl).isNull());
	}

	@Test
	@Tag("Positive")
	@DisplayName("A test to get the field color value in Hex format")
	@Description("The test gets the value from the style attribute in RGB format, and then converts it to Hex format")
	void color() {
		var info = PlatformApp
				.screen("Input color")
				.secondLevelView("Info")
				.info("Info");
		info.input("customField")
				.checkColor(color -> assertThat(color).isEqualTo("#EDA6A6"));
	}

	@Test
	@Tag("Positive")
	@DisplayName("A test to check the field for \"Read-only\"")
	@Description("Info Widget is always read-only")
	void readonly() {
		var info = PlatformApp
				.screen("Input readonly")
				.secondLevelView("Info")
				.info("Info");
		info.input("customField")
				.checkReadOnly(ro -> assertThat(ro).isFalse());
	}

	@Test
	@Tag("Positive")
	@DisplayName("The test for getting the value from the field")
	void read() {
		var info = PlatformApp.screen("Input basic")
				.secondLevelView("Info")
				.info("Info");
		info.input("customField")
				.checkValue(val -> assertThat(val).isEqualTo("test data"));
	}

	@Test
	@Tag("Positive")
	@DisplayName("The DrillDown test")
	@Description("DrillDown is not available for InfoWidget.")
	void drillDown() {
		var info = PlatformApp
				.screen("Input drilldown")
				.secondLevelView("Info")
				.info("Info");
		info.input("customField")
				.drilldown(dr -> assertThat(dr).contains("screen/InputDrilldown/view/InputDrilldownform/InputDrilldown"));
	}
}
