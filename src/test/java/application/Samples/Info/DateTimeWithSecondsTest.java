package application.Samples.Info;

import application.config.BaseTestForSamples;
import core.element.PlatformApp;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Severity;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static io.qameta.allure.SeverityLevel.MINOR;
import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("Info. Checking the basic functions for the DateTimeWithSeconds")
@Epic("application/Samples")
@Tag("application/Samples")
public class DateTimeWithSecondsTest extends BaseTestForSamples {

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
				.screen("DateTimeWithSeconds placeholder")
				.secondLevelView("Info")
				.info("Info title");
		info.dateTimeWithSeconds("custom Field")
				.checkPlaceholder(ph -> assertThat(ph).isNull());
	}

	@Test
	@Tag("Positive")
	@DisplayName("A test to get the field color value in Hex format")
	@Description("The test gets the value from the style attribute in RGB format, and then converts it to Hex format")
	void color() {
		var info = PlatformApp
				.screen("DateTimeWithSeconds color")
				.secondLevelView("Info")
				.info("Info title");
		info.dateTimeWithSeconds("custom Field")
				.checkColor(color -> assertThat(color).isEqualTo("#EDA6A6"));
	}

	@Test
	@Tag("Positive")
	@DisplayName("A test to check the field for \"Read-only\"")
	@Description("Info Widget is always read-only")
	void readonly() {
		var info = PlatformApp
				.screen("DateTimeWithSeconds readonly")
				.secondLevelView("Info")
				.info("Info title");
		info.dateTimeWithSeconds("custom Field")
				.checkReadOnly(readonly -> assertThat(readonly).isFalse());
	}

	@Test
	@Tag("Positive")
	@DisplayName("The test for getting the value from the field")
	void read() {
		var info = PlatformApp.screen("DateTimeWithSeconds basic")
				.secondLevelView("Info")
				.info("Info title");
		info.dateTimeWithSeconds("custom Field")
				.checkValue(val -> assertThat(val).isBeforeOrEqualTo(LocalDateTime.now()));
	}

	@Test
	@Tag("Positive")
	@DisplayName("The DrillDown test")
	@Description("DrillDown is  available for InfoWidget.")
	void drillDown() {
		var info = PlatformApp
				.screen("DateTimeWithSeconds drillDown")
				.secondLevelView("Info")
				.info("Info title");
		info.dateTimeWithSeconds("custom Field")
				.checkDrillDownSupported(drillDown -> assertThat(drillDown).isTrue());
	}
}
