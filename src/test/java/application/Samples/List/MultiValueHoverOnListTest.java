package application.Samples.List;

import application.config.BaseTestForSamples;
import core.MainPages;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Severity;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.util.List;

import static io.qameta.allure.SeverityLevel.CRITICAL;
import static io.qameta.allure.SeverityLevel.MINOR;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("List. Checking the basic functions for the MultiValueHover in the widget List")
@Epic("Samples")
@Tag("Samples")
@Tag("List")
public class MultiValueHoverOnListTest extends BaseTestForSamples {

    @Test
    @Tag("Positive")
    @DisplayName("Test for getting the Placeholder value")
    @Description("Getting a Placeholder is not available")
    void placeholder() {
        MainPages.click("MultivalueHover placeholder");
        MainPages.FirstLevelMenu.click("List");
        var list = $box.findListWidgetByTitle("List title");
        List<String> listRows = list.getNoFocusValues("Custom Field");
        var customField = list.findRowSegmentByValue("Custom Field", listRows.get(0)).multiValueHover();
        assertThatThrownBy(customField::getPlaceholder).isInstanceOf(UnsupportedOperationException.class);
    }

    @Test
    @Tag("Positive")
    @DisplayName("A test to get the field color value in Hex format")
    @Description("Getting the field color is not available")
    void color() {
        MainPages.click("MultivalueHover color");
        MainPages.FirstLevelMenu.click("List");
        var list = $box.findListWidgetByTitle("List title");
        List<String> listRows = list.getListRows();
        var customField = list.findRowSegmentByValue("Custom Field", listRows.get(0)).multiValueHover();
        assertThat(customField.getHexColor()).isEqualTo("#EDA6A6");
    }

    @Test
    @Tag("Positive")
    @DisplayName("A test to check the field for \"Read-only\"")
    @Description("The Hint field type is always read-only")
    void readonly() {
        MainPages.click("MultivalueHover readonly");
        MainPages.FirstLevelMenu.click("List");
        var list = $box.findListWidgetByTitle("List title");
        List<String> listRows = list.getListRows();
        var customField = list.findRowSegmentByValue("Custom Field", listRows.get(0)).multiValueHover();
        assertThatThrownBy(customField::getReadonly).isInstanceOf(UnsupportedOperationException.class);
    }

    @Test
    @Severity(CRITICAL)
    @Tag("Positive")
    @DisplayName("A test for checking a value in a field")
    @Description("The test gets the value in the field, and then checks the value in the field with what should be.")
    @Disabled("Checked at filtration and sorting")
    void read() {
        MainPages.click("MultivalueHover basic");
        MainPages.FirstLevelMenu.click("List");
        var list = $box.findListWidgetByTitle("List title");
        List<String> listRows = list.getNoFocusValues("Custom Field");
        var customField = list.findRowSegmentByValue("Custom Field", listRows.get(0)).multiValueHover();
        assertThat(customField.compareRows("Saturn's ...")).isTrue();
    }

    @Test
    @Severity(CRITICAL)
    @Tag("Positive")
    @DisplayName("A test for setting a value in a field")
    @Description("A test to get the value from the field. MultiValueHover is always read-only, so it is impossible to set the value.")
    void edit() {
        MainPages.click("MultivalueHover basic");
        MainPages.FirstLevelMenu.click("List");
        var list = $box.findListWidgetByTitle("List title");
        List<String> listRows = list.getListRows();
        var customField = list.findRowSegmentByValue("Custom Field", listRows.get(0)).multiValueHover();
        assertThat(customField.getValue()).isEqualTo("Saturn's interior is thought to be composed of a rocky core, surrounded by a deep layer of metallic hydrogen, an intermediate layer of liquid hydrogen and liquid helium\n" +
                "Despite consisting mostly of hydrogen and helium, most of Saturn's mass is not in the gas phase, because hydrogen becomes a non-ideal liquid when the density is above 0.01 g/cm3, which is reached at a radius containing 99.9% of Saturn's mass.");
    }

    @Test
    @Severity(MINOR)
    @Tag("Negative")
    @DisplayName("Filtering test")
    @Description("Filtering by the specified column.")
    void filtration() {
        MainPages.click("MultivalueHover filtration");
        MainPages.FirstLevelMenu.click("List");
        var list = $box.findListWidgetByTitle("List title");
        list.findFilterColumn("Custom Field").multiValueHoverFilter().setFilter("Saturn's interior");
        assertThat(list.getNoFocusValues("Custom Field")).isEqualTo(List.of("Saturn's ..."));
    }
}
