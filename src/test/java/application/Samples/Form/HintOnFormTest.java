package application.Samples.Form;

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
import static io.qameta.allure.SeverityLevel.MINOR;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DisplayName("Form. Checking the basic functions for the Hint in the widget Form")
@Epic("Samples")
@Tag("Samples")
@Tag("Form")

public class HintOnFormTest extends BaseTestForSamples {

	@Disabled
	@Test
	@Tag("Positive")
	@DisplayName("A test to get the field color value in Hex format")
	@Description("Getting the field color is not available")
	void color() {
	}

	@Disabled
	@Test
	@Tag("Positive")
	@DisplayName("A test to check the field for \"Read-only\"")
	@Description("The Hint field type is always read-only")
	void readonly() {
	}

	@Test
	@Severity(CRITICAL)
	@Tag("Positive")
	@DisplayName("A test to check the value in a field")
	@Description("A test to get the value from the field. Hint is always read-only, so it is impossible to set the value.")
	void edit() {
		var form = PlatformApp.screen("Hint basic")
				.secondLevelView("Form")
				.form("Form title");
		form
				.hint("Custom Field")
				.checkValue(value -> assertThat(value).isEqualTo("Information data"));
	}

	@Disabled
	@Test
	@Severity(MINOR)
	@Tag("Negative")
	@DisplayName("Filtering test")
	@Description("Filtering is not available for the Form widget")
	void filtration() {
	}

	@Disabled
	@Test
	@Tag("Positive")
	@DisplayName("The DrillDown test")
	@Description("The transition/Redirect is not available")
	void drillDown() {
	}
}
