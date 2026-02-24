package application.Samples.List;

import application.config.BaseTestForSamples;
import core.config.Constants;
import core.element.PlatformApp;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;

import static io.qameta.allure.SeverityLevel.CRITICAL;
import static io.qameta.allure.SeverityLevel.MINOR;
import static org.assertj.core.api.Assertions.assertThat;

public class SuggestionPickListOnListTest extends BaseTestForSamples {

	@Test
	@Tag("Positive")
	@DisplayName("Test for getting the Placeholder value")
	@Description("The test gets the value from the placeholder attribute and returns it in String format")
	void placeholder() {
		var list = PlatformApp.screen("SuggestionPickList placeholder")
				.secondLevelView("List")
				.listInline("List Widget with suggestionPickList placeholder");
		var row = list.rows().clickRow(0);
		row.suggestionPickList("customField")
				.checkPlaceholder(pl -> assertThat(pl).isEqualTo("Placeholder text"));
	}

	@Test
	@Tag("Positive")
	@DisplayName("A test to get the field color value in Hex format")
	@Description("The test gets the value from the style attribute in RGB format, and then converts it to Hex format")
	void color() {
		var screen = PlatformApp.screen("SuggestionPickList color");
		screen.secondLevelView("Color");
		var list = screen.thirdLevelView("List")
				.listInline("List Widget with suggestionPickList color");
		var row = list.rows().row(0);
		row.suggestionPickList("customField")
				.checkColor(color -> assertThat(color).isEqualTo("#EDA6A6"));
	}

	@Test
	@Tag("Positive")
	@DisplayName("A test to check the field for \"Read-only\"")
	@Description("The test checks for the disabled attribute.")
	void readonly() {
		var list = PlatformApp.screen("SuggestionPickList readonly")
				.secondLevelView("List")
				.listInline("List");
		var row = list.rows().clickRow(0);
		row.suggestionPickList("customField")
				.checkReadOnly(ro -> assertThat(ro).isTrue());
	}

	@Test
	@Severity(CRITICAL)
	@Tag("Positive")
	@DisplayName("A test for setting a value in a field")
	@Description("The test sets the value in the field via Popup using a unique id, and then checks the value in the field with what needs to be set.")
	void edit() {
		var suggestionPicklistBasic = PlatformApp.screen("SuggestionPicklist basic");
		suggestionPicklistBasic.secondLevelView("Microservice");
		var view = suggestionPicklistBasic.thirdLevelView("List");

		var list = view.listInline("List Widget with suggestionPickList basic");
		var row = list.rows().clickRow(0);
		row.suggestionPickList("customField")
				.setValue("Test data9")
				.checkValue(value -> assertThat(value).isEqualTo("Test data9"));
		row.suggestionPickList("customField").clear();
	}

	@Test
	@Severity(MINOR)
	@Tag("Negative")
	@DisplayName("Filtering test")
	@Description("Filtering by the specified column.")
	void filtration() {
		var list = PlatformApp.screen("SuggestionPicklist filtration")
				.secondLevelView("List")
				.listInline("List");
		list.headers().filter(fb -> fb.input("customField", "data7"));
		var values = list.rows().streamCurrentPage()
				.map(r -> r.suggestionPickList("customField").getValue())
				.collect(Collectors.toList());
		assertThat(values).isEqualTo(List.of("test data7"));
	}

	@Test
	@Tag("Positive")
	@DisplayName("The DrillDown test")
	@Description("Checking the url before the transition and after the transition/click on a special element")
	void drillDown() {
		var list = PlatformApp.screen("SuggestionPicklist drilldown")
				.secondLevelView("List")
				.listInline("List Widget with suggestionPickList drilldown");
		var row = list.rows().row(0);
		row.suggestionPickList("customField")
				.checkDrillDownSupported(ds -> assertThat(ds).isTrue());
	}

	@Disabled("Incorrect test back")
	@Test
	@Severity(MINOR)
	@Tag("Negative")
	@DisplayName("Sorting test")
	@Description("Sorting by the specified column.")
	void sorting() {
		var list = PlatformApp.screen("SuggestionPicklist sorting")
				.secondLevelView("List")
				.listInline("List");
		var valuesBefore = list.rows().streamCurrentPage()
				.map(r -> r.suggestionPickList("customField").getValue())
				.collect(Collectors.toList());
		assertThat(valuesBefore).isEqualTo(List.of(
				"test data7",
				"test data6",
				"test data5",
				"test data4",
				"test data3",
				"test data2",
				"test data1",
				"test data"));
		list.headers().sort(sb -> sb.sort("customField"));

		var valuesAfter = list.rows().streamCurrentPage()
				.map(r -> r.suggestionPickList("customField").getValue())
				.collect(Collectors.toList());
		assertThat(valuesAfter).isEqualTo(List.of(
				"test data",
				"test data1",
				"test data2",
				"test data3",
				"test data4",
				"test data5",
				"test data6",
				"test data7"));
	}

	@Test
	@Severity(CRITICAL)
	@Tag("Negative")
	@DisplayName("Required Message text Verification field test")
	@Description("The test clears the field and clicks the Save button. Then validates the message that the field is required.")
	void required() {
		var list = PlatformApp.screen("SuggestionPicklist required")
				.secondLevelView("List")
				.listInline("List");
		var row = list.rows().clickRow(0);
		var customField = row.suggestionPickList("customField");
		customField.clear();
		customField.checkRequired(message -> assertThat(message).isEqualTo(Constants.RequiredMessage));
	}
}
