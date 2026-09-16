package application.Samples.Form;

import application.config.BaseTestForSamples;
import application.custom.Position;
import core.element.PlatformApp;
import core.util.DocShots;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.SeverityLevel.CRITICAL;
import static io.qameta.allure.SeverityLevel.MINOR;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DisplayName("Form. Checking the basic functions for the Hint in the widget Form")
@Epic("Samples")
@Feature(HintOnFormTest.ARTICLE)
@Tag("Samples")
@Tag("Form")
public class HintOnFormTest extends BaseTestForSamples {

	static final String ARTICLE = "widget/fields/field/hint";

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
		DocShots.png(form.element(), ARTICLE, "img_form.png", 1600, 1000);
	}

	@Disabled
	@Test
	@Severity(MINOR)
	@Tag("Negative")
	@DisplayName("Filtering test")
	@Description("Filtering is not available for the Form widget")
	void filtration() {
	}

	@Test
	@Tag("Positive")
	@DisplayName("The DrillDown test")
	@Description("Checking the url before the transition and after the transition/click on a special element")
	void drillDown() {
		var form = PlatformApp.screen("Hint drilldown")
				.secondLevelView("Form")
				.form("Form title");
		DocShots.png(form.element(), ARTICLE, "img_drilldown_form.png", 1600, 1000);
		form.hint("Custom Field")
				.drilldown(url -> assertThat(url).contains("/screen/myexample161/view/myexample161form/myExampleBc161/"));
	}

	@Test
	void position() {
		assertTrue(Position.checkPosition(302, 94, PlatformApp.screen("Hint basic").secondLevelView("Form").form("Form title").element()));
	}
}
