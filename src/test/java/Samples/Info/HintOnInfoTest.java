package Samples.Info;

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
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DisplayName("Info. Checking the basic functions for the Hint")
@Epic("Samples")
@Tag("Samples")
public class HintOnInfoTest extends BaseTestForSamples {

	@Disabled
	@Test
	@Tag("Positive")
	@DisplayName("A test to get the field color value in Hex format")
	@Description("InfoWidget does not have a Hex field color for this type.")
	void color() {
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
	@Tag("Positive")
	@DisplayName("The DrillDown test")
	@Description("Drill Down is not available for InfoWidget.")
	void drillDown() {
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
	}
}
