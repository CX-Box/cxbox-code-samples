package Samples.List;

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
import java.util.stream.Collectors;

import static io.qameta.allure.SeverityLevel.CRITICAL;
import static io.qameta.allure.SeverityLevel.MINOR;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DisplayName("List. Checking the basic functions for the Hint in the widget List")
@Epic("Samples")
@Tag("Samples")
@Tag("List")
public class HintOnListTest extends BaseTestForSamples {

	@Disabled
	@Test
	@Tag("Positive")
	@DisplayName("A test to get the field color value in Hex format")
	@Description("Getting the field color is not available")
	void color() {
//        MainPages.click("Hint color");
//        MainPages.FirstLevelMenu.click("List");
//        var list = $box.findListWidgetByTitle("List title");
//        List<String> listRows = list.getListRows();
//        var customField = list.findRowSegmentByValue("Custom Field", listRows.get(0)).hint();
//        assertThatThrownBy(customField::getHexColor).isInstanceOf(UnsupportedOperationException.class);
	}

	@Disabled
	@Test
	@Tag("Positive")
	@DisplayName("A test to check the field for \"Read-only\"")
	@Description("The Hint field type is always read-only")
	void readonly() {
//        MainPages.click("Hint readonly");
//        MainPages.FirstLevelMenu.click("List");
//        var list = $box.findListWidgetByTitle("List title");
//        List<String> listRows = list.getListRows();
//        var customField = list.findRowSegmentByValue("Custom Field", listRows.get(0)).hint();
//        assertThatThrownBy(customField::getReadOnly).isInstanceOf(UnsupportedOperationException.class);
	}

	@Disabled
	@Test
	@Severity(CRITICAL)
	@Tag("Positive")
	@DisplayName("A test to check the value in a field")
	@Description("A test to get the value from the field. Hint is always read-only, so it is impossible to set the value.")
	void edit() {

	}

	@Disabled
	@Test
	@Tag("Positive")
	@DisplayName("The DrillDown test")
	@Description("The transition/Redirect is not available")
	void drillDown() {

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
	}

	@Test
	@Severity(MINOR)
	@Tag("Negative")
	@DisplayName("Filtering test")
	@Description("Filtering by the specified column.")
	void filtration() {
		var list = PlatformApp.screen("Hint filtration")
				.secondLevelView("List")
				.listInline("List title");
		list.headers().filter(fb -> fb.hint("Custom Field", "Test data"));
		var actualData = list.rows().streamAllPages()
				.map(r -> r.hint("Custom Field").getValue())
				.collect(Collectors.toList());
		assertThat(actualData).isEqualTo(List.of("Test data", "Test data"));
	}
}
