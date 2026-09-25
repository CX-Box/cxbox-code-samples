package application.Samples.List;

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

import java.util.List;
import java.util.stream.Collectors;

import static io.qameta.allure.SeverityLevel.CRITICAL;
import static io.qameta.allure.SeverityLevel.MINOR;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DisplayName("List. Checking the basic functions for the Hint in the widget List")
@Epic("Samples")
@Feature(HintOnListTest.ARTICLE)
@Tag("Samples")
@Tag("List")
public class HintOnListTest extends BaseTestForSamples {

	static final String ARTICLE = "widget/fields/field/hint";

	@Test
	@Tag("Positive")
	@DisplayName("A test to get the field color value in Hex format")
	@Description("The test gets the value from the style attribute in RGB format, and then converts it to Hex format")
	void color() {
		var list = PlatformApp.screen("Hint color")
				.secondLevelView("List")
				.listInline("List title");
		list.rows().row(0)
				.hint("Custom Field")
				.checkColor(color -> assertThat(color).isEqualTo("#EDA6A6"));
		DocShots.png(list.element(), ARTICLE, "img_color_list.png", 1600, 1000);
	}

	@Disabled("Hint is always read-only")
	@Test
	@Tag("Positive")
	@DisplayName("A test to check the field for \"Read-only\"")
	@Description("The Hint field type is always read-only")
	void readonly() {
	}

	@Disabled("Hint is always read-only")
	@Test
	@Severity(CRITICAL)
	@Tag("Positive")
	@DisplayName("A test to check the value in a field")
	@Description("A test to get the value from the field. Hint is always read-only, so it is impossible to set the value.")
	void edit() {
	}

	@Test
	@Tag("Positive")
	@DisplayName("The DrillDown test")
	@Description("Checking the url before the transition and after the transition/click on a special element")
	void drillDown() {
		var list = PlatformApp.screen("Hint drilldown")
				.secondLevelView("List")
				.listInline("List title");
		DocShots.png(list.element(), ARTICLE, "img_drilldown_list.png", 1600, 1000);
		list.rows().row(0)
				.hint("Custom Field")
				.drilldown(url -> assertThat(url).contains("/screen/myexample161/view/myexample161form/myExampleBc161/"));
	}

	@Test
	@Severity(CRITICAL)
	@Tag("Positive")
	@DisplayName("A test for checking a value in a field")
	@Description("The test gets the value in the field, and then checks the value in the field with what should be.")
	void read() {
		var list = PlatformApp.screen("Hint basic")
				.secondLevelView("List")
				.listInline("List title");
		var row = list.rows().row(0);
		row.hint("Custom Field")
				.checkValue(value -> assertThat(value).isEqualTo("Information data"));
		DocShots.png(list.element(), ARTICLE, "img_list.png", 1600, 1000);
	}

	@Test
	@Severity(MINOR)
	@Tag("Negative")
	@DisplayName("Filtering test")
	@Description("Filtering by part of the value: records containing the value at any position are shown.")
	void filtration() {
		var list = PlatformApp.screen("Hint filtration")
				.secondLevelView("List")
				.listInline("List title");
		list.headers().filter(fb -> fb.hint("Custom Field", "123"));
		var actualData = list.rows().streamAllPages()
				.map(r -> r.hint("Custom Field").getValue())
				.collect(Collectors.toList());
		assertThat(actualData).isEqualTo(List.of("Test123 data"));
		DocShots.png(list.element(), ARTICLE, "img_filtr_list.png", 1600, 1000);
	}

	@Test
	void position() {
		assertTrue(Position.checkPosition(302, 94, PlatformApp.screen("Hint basic").secondLevelView("List").listInline("List title").element()));
	}
}
