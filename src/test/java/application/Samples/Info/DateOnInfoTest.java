package application.Samples.Info;

import application.config.BaseTestForSamples;
import core.element.PlatformApp;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DisplayName("Info. Checking the basic functions for the Date")
@Epic("application/Samples")
@Tag("application/Samples")

public class DateOnInfoTest extends BaseTestForSamples {

	@Test
	@Tag("Positive")
	@DisplayName("Test for getting the Placeholder value")
	@Description("The InfoWidget doesn't have a Placeholder.")
	void placeholder() {
		var info = PlatformApp
				.screen("Date placeholder")
				.secondLevelView("Info")
				.info("Info title");
		info.date("custom Field")
				.checkPlaceholderSupported(p -> assertThat(p).isFalse());
	}

	@Test
	@Tag("Positive")
	@DisplayName("A test to get the field color value in Hex format")
	@Description("The test gets the value from the style attribute in RGB format, and then converts it to Hex format")
	void color() {
		var info = PlatformApp
				.screen("Date color")
				.secondLevelView("Info")
				.info("Info title");
		info.date("custom Field")
				.checkColor(color -> assertThat(color).isEqualTo("#EDA6A6"));
	}

	@Test
	@Tag("Positive")
	@DisplayName("The test for getting the value from the field")
	void read() {
		var info = PlatformApp.screen("Date basic")
				.secondLevelView("Info")
				.info("Info title");
		info.date("custom Field")
				.checkValue(val -> assertThat(val).isBeforeOrEqualTo(LocalDate.now()));
	}

	@Test
	@Tag("Positive")
	@DisplayName("The DrillDown test")
	@Description("DrillDown is not available for InfoWidget.")
	void drillDown() {
		var info = PlatformApp
				.screen("Date drilldown")
				.secondLevelView("Info")
				.info("Info title");
		info.date("custom Field")
				.checkDrillDownSupported(ds -> assertThat(ds).isTrue());
	}
}


