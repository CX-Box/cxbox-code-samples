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

import java.math.BigDecimal;

import static io.qameta.allure.SeverityLevel.MINOR;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DisplayName("Info. Checking the basic functions for the Number")
@Epic("application/Samples")
@Tag("application/Samples")

public class NumberOnInfoTest extends BaseTestForSamples {

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
				.screen("Number color")
				.secondLevelView("Info")
				.info("Info title");
		info.number("custom Field")
				.checkColor(color -> assertThat(color).isEqualTo("#EDA6A6"));
	}

	@Test
	@Tag("Positive")
	@DisplayName("The test for getting the value from the field")
	void read() {
		var info = PlatformApp.screen("Number basic")
				.secondLevelView("Info")
				.info("Info title");
		info.number("custom Field")
				.checkValue(val -> assertThat(val).isEqualTo(new BigDecimal("123456")));
	}

	@Test
	@Tag("Positive")
	@DisplayName("The DrillDown test")
	@Description("DrillDown is not available for InfoWidget.")
	void drillDown() {
		var info = PlatformApp
				.screen("Number drilldown")
				.secondLevelView("Info")
				.info("Info title");
		info.number("custom Field")
				.checkDrillDownSupported(ds -> assertThat(ds).isTrue());
	}

	@Disabled
	@Test
	@DisplayName("Test for getting the digits value")
	void digits() {
		var info = PlatformApp.screen("Number digits")
				.secondLevelView("Info")
				.info("Info title");
		info.number("custom Field")
				.checkValue(d -> {
					var split = d.toString().split("\\.");
					assertThat(split.length).isEqualTo(2);
					assertThat(split[0]).isNotBlank();
					assertThat(split[1]).isNotBlank();
					assertThat(split[1].length()).isEqualTo(2);
				});
	}
}
