package sample.list;

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

@DisplayName("List. Checking the basic functions for the MultiValueHover in the widget List")
@Epic("Samples")
@Tag("Samples")
@Tag("List")
public class MultiValueHoverOnListTest extends BaseTestForSamples {

	@Disabled
	@Test
	@Tag("Positive")
	@DisplayName("Test for getting the Placeholder value")
	@Description("Getting a Placeholder is not available")
	void placeholder() {
//        MainPages.click("MultivalueHover placeholder");
//        MainPages.FirstLevelMenu.click("List");
//        var list = $box.findListWidgetByTitle("List title");
//        List<String> listRows = list.getNoFocusValues("Custom Field");
//        var customField = list.findRowSegmentByValue("Custom Field", listRows.get(0)).multiValueHover();
//        assertThatThrownBy(customField::getPlaceholder).isInstanceOf(UnsupportedOperationException.class);
	}

	@Disabled
	@Test
	@Tag("Positive")
	@DisplayName("A test to check the field for \"Read-only\"")
	@Description("The Hint field type is always read-only")
	void readonly() {
//        MainPages.click("MultivalueHover readonly");
//        MainPages.FirstLevelMenu.click("List");
//        var list = $box.findListWidgetByTitle("List title");
//        List<String> listRows = list.getListRows();
//        var customField = list.findRowSegmentByValue("Custom Field", listRows.get(0)).multiValueHover();
//        assertThatThrownBy(customField::getReadonly).isInstanceOf(UnsupportedOperationException.class);
	}

	@Disabled("Checked at filtration and sorting")
	@Test
	@Severity(CRITICAL)
	@Tag("Positive")
	@DisplayName("A test for checking a value in a field")
	@Description("The test gets the value in the field, and then checks the value in the field with what should be.")
	void read() {
//        PlatformApp.screen("MultivalueHover basic")
//                .secondLevelView("List")
//                .listInline("List title")
//                .rows().row(0).multivalueHover("Custom Field")
//                .checkShortText(value->assertThat(value).isEqualTo("Saturn's ..."));
	}

	@Test
	@Tag("Positive")
	@DisplayName("A test to get the field color value in Hex format")
	@Description("Getting the field color is not available")
	void color() {
		var list = PlatformApp.screen("MultivalueHover color")
				.secondLevelView("List")
				.listInline("List title");
		var row = list.rows().row(0);
		row.multivalueHover("Custom Field")
				.checkColor(color -> assertThat(color).isEqualTo("#EDA6A6"));
	}

	@Test
	@Severity(CRITICAL)
	@Tag("Positive")
	@DisplayName("A test for setting a value in a field")
	@Description("A test to get the value from the field. MultiValueHover is always read-only, so it is impossible to set the value.")
	void edit() {
		String expectedValue = "Saturn's interior is thought to be composed of a rocky core, surrounded by a deep layer of metallic hydrogen, an intermediate layer of liquid hydrogen and liquid helium\n" +
				"Despite consisting mostly of hydrogen and helium, most of Saturn's mass is not in the gas phase, because hydrogen becomes a non-ideal liquid when the density is above 0.01 g/cm3, which is reached at a radius containing 99.9% of Saturn's mass.";
		var list = PlatformApp.screen("MultivalueHover basic")
				.secondLevelView("List")
				.listInline("List title");
		var row = list.rows().clickRow(0);
		row.multivalueHover("Custom Field")
				.checkValue(value -> assertThat(value).isEqualTo(expectedValue));
	}

	@Test
	@Severity(MINOR)
	@Tag("Negative")
	@DisplayName("Filtering test")
	@Description("Filtering by the specified column.")
	void filtration() {
		var list = PlatformApp.screen("MultivalueHover filtration")
				.secondLevelView("List")
				.listInline("List title");
		var row = list.rows().row(0);
		row.multivalueHover("Custom Field")
				.checkShortText(value -> assertThat(value).isEqualTo("Despite c..."));
	}
}
