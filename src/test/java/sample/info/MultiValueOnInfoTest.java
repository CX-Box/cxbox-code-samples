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

import java.util.List;

import static io.qameta.allure.SeverityLevel.MINOR;
import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("Info. Checking the basic functions for the MultiValue")
@Epic("Samples")
@Tag("Samples")
public class MultiValueOnInfoTest extends BaseTestForSamples {

	@Disabled
	@Test
	@Tag("Positive")
	@DisplayName("Test for getting the Placeholder value")
	@Description("The InfoWidget doesn't have a Placeholder..")
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
	@DisplayName("A test to get the field color value in Hex format")
	@Description("The test gets the value from the style attribute in RGB format, and then converts it to Hex format")
	void color() {
		var info = PlatformApp
				.screen("MultiValue color")
				.secondLevelView("Info")
				.info("Info title");
		info.multivalue("Custom Field")
				.checkColor(color -> assertThat(color).isNull());
	}

	@Test
	@Tag("Positive")
	@DisplayName("The test for getting the value from the field")
	void read() {
		List<String> expectedValue = List.of("Abs data",
				"Abs data",
				"Test data",
				"Test data",
				"Information data",
				"Information data",
				"Information2 data",
				"Information2 data",
				"Information3 data",
				"Information3 data",
				"Information4 data",
				"Information4 data",
				"Information5 data",
				"Information5 data",
				"Information6 data",
				"Information6 data",
				"Information7 data",
				"Information7 data",
				"Information8 data",
				"Information8 data",
				"Information9 data",
				"Information9 data",
				"Information10 data",
				"Information10 data");
		var info = PlatformApp.screen("MultiValue basic")
				.secondLevelView("Info")
				.info("Info title");
		info.multivalue("Custom Field")
				.checkValue(value -> assertThat(value).isEqualTo(expectedValue));
	}
}
