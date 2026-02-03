package sample.info;

import application.config.BaseTestForSamples;
import core.element.PlatformApp;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Story;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("Info. New Api.  Checking the basic functions for the CheckBox")
@Epic("application/Samples")
@Story("Info")
@Tag("application/Samples")
@Tag("Info")
@Slf4j
public class CheckboxTest extends BaseTestForSamples {

	@Test
	@Tag("Positive")
	@DisplayName("Test for getting the Placeholder value")
	@Description("The InfoWidget doesn't have a Placeholder.")
	void placeholder() {
		var info = PlatformApp
				.screen("Checkbox placeholder")
				.secondLevelView("Info")
				.info("Info title");
		info.checkbox("Custom Field")
				.checkPlaceholder(act -> assertThat(act).isEmpty());
	}

	@Test
	@Tag("Positive")
	@DisplayName("A test to get the field color value in Hex format")
	@Description("InfoWidget does not have a Hex field color for this type.")
	void color() {
		var info = PlatformApp
				.screen("Checkbox color")
				.secondLevelView("Info")
				.info("Info title");
		info.checkbox("Custom Field")
				.checkColor(color -> assertThat(color).isNull());
	}

	@Test
	@Tag("Positive")
	@DisplayName("A test to check the field for \"Read-only\"")
	@Description("Info Widget is always read-only")
	void readonly() {
		var info = PlatformApp
				.screen("Checkbox readonly")
				.secondLevelView("Info")
				.info("Info title");
		info.checkbox("Custom Field")
				.checkReadOnly(ro -> assertThat(ro).isTrue());
	}

	@Test
	@Tag("Positive")
	@DisplayName("The test for getting the value from the field")
	void read() {
		var info = PlatformApp.screen("Checkbox basic")
				.secondLevelView("Info")
				.info("Info title");
		info.checkbox("Custom Field")
				.checkValue(value -> assertThat(value).isTrue());
	}

	@Test
	@Tag("Positive")
	@DisplayName("The DrillDown test")
	@Description("DrillDown is not available for InfoWidget.")
	void drillDown() {
		var info = PlatformApp
				.screen("Checkbox drilldown")
				.secondLevelView("Info")
				.info("Info title");
		info.checkbox("Custom Field")
				.checkDrillDownSupported(isDrilldown -> assertThat(isDrilldown).isFalse());
	}
}
