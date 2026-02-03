package sample.form;

import application.config.BaseTestForSamples;
import core.element.PlatformApp;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Severity;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.SeverityLevel.CRITICAL;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DisplayName("Form. Checking the basic functions for the MultiValueHover in the widget Form")
@Epic("application/Samples")
@Tag("application/Samples")
@Tag("Form")

public class MultiValueHoverOnFormTest extends BaseTestForSamples {

	@Disabled
	@Test
	@Tag("Positive")
	@DisplayName("Test for getting the Placeholder value")
	@Description("Getting a Placeholder is not available")
	void placeholder() {
	}

	@Disabled
	@Test
	@Tag("Positive")
	@DisplayName("A test to check the field for \"Read-only\"")
	@Description("The Hint field type is always read-only")
	void readonly() {
	}

	@Test
	@Tag("Positive")
	@DisplayName("A test to get the field color value in Hex format")
	@Description("Getting the field color is not available")
	void color() {
		var form = PlatformApp
				.screen("MultiValueHover color")
				.secondLevelView("Form")
				.form("Form title");
		form.multivalueHover("Custom Field")
				.checkColor(color -> assertThat(color).isEqualTo("#EDA6A6"));
	}

	@Test
	@Severity(CRITICAL)
	@Tag("Positive")
	@DisplayName("A test for setting a value in a field")
	@Description("A test to get the value from the field. MultiValueHover is always read-only, so it is impossible to set the value")
	void edit() {
		String expectedValue = "Saturn's interior is thought to be composed of a rocky core, surrounded by a deep layer of metallic hydrogen, an intermediate layer of liquid hydrogen and liquid helium\n" +
				"Despite consisting mostly of hydrogen and helium, most of Saturn's mass is not in the gas phase, because hydrogen becomes a non-ideal liquid when the density is above 0.01 g/cm3, which is reached at a radius containing 99.9% of Saturn's mass.";
		var form = PlatformApp.screen("MultiValueHover basic")
				.secondLevelView("Form")
				.form("Form title");
		form.multivalueHover("Custom Field")
				.checkValue(value -> assertThat(value).isEqualTo(expectedValue));
	}
}