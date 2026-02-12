package application.Samples.Info;


import application.config.BaseTestForSamples;
import core.element.PlatformApp;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("Info. Checking the basic functions for the Time")
@Epic("application/Samples")
@Tag("application/Samples")
public class TimeOnInfoTest extends BaseTestForSamples {

	@Test
	@Tag("Positive")
	@DisplayName("A test to get the field color value in Hex format")
	@Description("The test gets the value from the style attribute in RGB format, and then converts it to Hex format")
	void color() {
		var info = PlatformApp.screen("Time color")
				.secondLevelView("Info")
				.info("Info title");
		info.time("Custom Field", "HH:mm:ss")
				.checkColor(color -> assertThat(color).isEqualTo("#EDA6A6"));
	}

	@Test
	@Tag("Positive")
	@DisplayName("A test to read value")
	@Description("The test checks the value in the field with what should be set")
	void read3() {
		var info = PlatformApp.screen("Time base")
				.secondLevelView("Info")
				.info("Info title");
		var customFieldHHmmSS = info.time("HH:mm:ss", "HH:mm:ss");
		var customFieldHH = info.time("HH", "HH");
		var customFieldHmm = info.time("HH:mm", "HH:mm");
		var customFieldHmmA = info.time("hh:mm A", "h:mm a");
		var customFieldHmmSSA = info.time("hh:mm:ss A", "hh:mm:ss a");
		customFieldHHmmSS.checkValue(value -> assertThat(value).isEqualTo(LocalDate.MIN.atTime(11, 54, 25)));
		customFieldHH.checkValue(value -> assertThat(value).isEqualTo(LocalDate.MIN.atTime(11, 0)));
		customFieldHmm.checkValue(value -> assertThat(value).isEqualTo(LocalDate.MIN.atTime(11, 54)));
		customFieldHmmA.checkValue(value -> assertThat(value).isEqualTo(LocalDate.MIN.atTime(11, 54)));
		customFieldHmmSSA.checkValue(value -> assertThat(value).isEqualTo(LocalDate.MIN.atTime(11, 54, 25)));
	}

	@Test
	@Tag("Positive")
	@DisplayName("The DrillDown test")
	@Description("Checking the url before the transition and after the transition/click on a special element")
	void drillDown() {
		var info = PlatformApp.screen("Time drilldown")
				.secondLevelView("Info")
				.info("Info title");
		info.time("Custom Field", "hh:mm:ss A")
				.checkDrillDownSupported(success -> assertThat(success).isTrue());
	}

	@Test
	@Tag("Positive")
	@DisplayName("Test for getting the Placeholder value")
	@Description("Info widgets do not support placeholder attribute")
	void placeholder() {
		var info = PlatformApp.screen("Time placeholder")
				.secondLevelView("Info")
				.info("Info title");
		info.time("Custom Field", "HH:mm:ss")
				.checkPlaceholder(pl -> assertThat(pl).isNull());
	}

	@Disabled
	@Test
	@Tag("Positive")
	@DisplayName("A test to check the field for \"Read-only\"")
	@Description("Info widgets are always read-only")
	void readonly() {
//        var info = PlatformApp.screen("Time readonly")
//              .secondLevelView("Info")
//              .info("Info title");
//        info.time("Custom Field", "HH:mm:ss")
//              .checkReadOnly(ro -> assertThat(ro).isFalse());
	}
}
