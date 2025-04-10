package application.Samples.Info;

import application.config.BaseTestForSamples;
import core.MainPages;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Severity;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.SeverityLevel.MINOR;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("Info. Checking the basic functions for the Number")
@Epic("application/Samples")
@Tag("application/Samples")

public class NumberOnInfoTest extends BaseTestForSamples {

    @Test
    @Tag("Positive")
    @DisplayName("Test for getting the Placeholder value")
    @Description("The InfoWidget doesn't have a Placeholder.")
    void placeholder() {
        MainPages.click("Number placeholder");
        MainPages.FirstLevelMenu.click("Info");
        var info = $box.findInfoWidgetByTitle("Info title");
        var customField = info.number("Custom Field");
        assertThatThrownBy(customField::getPlaceholder).isInstanceOf(UnsupportedOperationException.class);
    }

    @Test
    @Tag("Positive")
    @DisplayName("A test to get the field color value in Hex format")
    @Description("The test gets the value from the style attribute in RGB format, and then converts it to Hex format")
    void color() {
        MainPages.click("Number color");
        MainPages.FirstLevelMenu.click("Info");
        var info = $box.findInfoWidgetByTitle("Info title");
        var customField = info.number("custom Field");
        assertThat(customField.getHexColor()).isEqualTo("#EDA6A6");
    }

    @Test
    @Tag("Positive")
    @DisplayName("A test to check the field for \"Read-only\"")
    @Description("Info Widget is always read-only")
    void readonly() {
        MainPages.click("Number readonly");
        MainPages.FirstLevelMenu.click("Info");
        var info = $box.findInfoWidgetByTitle("Info title");
        var customField = info.number("Custom Field");
        assertThatThrownBy(customField::getReadOnly).isInstanceOf(UnsupportedOperationException.class);
    }

    @Test
    @Tag("Positive")
    @DisplayName("The test for getting the value from the field")
    void read() {
        MainPages.click("Number basic");
        MainPages.FirstLevelMenu.click("Info");
        var info = $box.findInfoWidgetByTitle("Info title");
        var customField = info.number("custom Field");
        assertThat(customField.getValue()).isEqualTo(123456);
    }

    @Test
    @Severity(MINOR)
    @Tag("Negative")
    @DisplayName("Filtering test")
    @Description("Filtering is not available for InfoWidget.")
    void filtration() {
        MainPages.click("Number filtration");
        MainPages.FirstLevelMenu.click("Info");
        var info = $box.findInfoWidgetByTitle("Info title");
        var customField = info.number("Custom Field");
        assertThatThrownBy(customField::setFiltration).isInstanceOf(UnsupportedOperationException.class);
    }

    @Test
    @Tag("Positive")
    @DisplayName("The DrillDown test")
    @Description("DrillDown is not available for InfoWidget.")
    void drillDown() {
        MainPages.click("Number drilldown");
        MainPages.FirstLevelMenu.click("Info");
        var info = $box.findInfoWidgetByTitle("Info title");
        var customField = info.number("custom Field");
        assertThat(customField.drillDown()).isTrue();
    }

    @Test
    @Severity(MINOR)
    @Tag("Negative")
    @DisplayName("Sorting test")
    @Description("Sorting is not available for InfoWidget.")
    void sorting() {
        MainPages.click("Number filtration");
        MainPages.FirstLevelMenu.click("Info");
        var info = $box.findInfoWidgetByTitle("Info title");
        var customField = info.number("Custom Field");
        assertThatThrownBy(customField::setSorting).isInstanceOf(UnsupportedOperationException.class);
    }
}
