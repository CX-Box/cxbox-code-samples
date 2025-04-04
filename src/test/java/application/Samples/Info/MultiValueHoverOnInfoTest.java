package application.Samples.Info;

import core.config.BaseTestForSamples;
import core.MainPages;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Severity;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.selenide.videorecorder.junit5.VideoRecorderExtension;

import static io.qameta.allure.SeverityLevel.MINOR;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("Info. Checking the basic functions for the MultiValueHover")
@Epic("application/Samples")
@Tag("application/Samples")
@ExtendWith(VideoRecorderExtension.class)
public class MultiValueHoverOnInfoTest extends BaseTestForSamples {

    @Test
    @Tag("Positive")
    @DisplayName("Test for getting the Placeholder value")
    @Description("The InfoWidget doesn't have a Placeholder.")
    void placeholder() {
        MainPages.click("MultiValueHover placeholder");
        MainPages.FirstLevelMenu.click("Info");
        var info = $box.findInfoWidgetByTitle("Info title");
        var customField = info.multiValueHover("Custom Field");
        assertThatThrownBy(customField::getPlaceholder).isInstanceOf(UnsupportedOperationException.class);
    }

    @Test
    @Tag("Positive")
    @DisplayName("A test to get the field color value in Hex format")
    @Description("The test gets the value from the style attribute in RGB format, and then converts it to Hex format")
    void color() {
        MainPages.click("MultiValueHover color");
        MainPages.FirstLevelMenu.click("Info");
        var info = $box.findInfoWidgetByTitle("Info title");
        var customField = info.multiValueHover("Custom Field");
        assertThat(customField.getHexColor()).isEqualTo("#EDA6A6");
    }

    @Test
    @Tag("Positive")
    @DisplayName("A test to check the field for \"Read-only\"")
    @Description("Info Widget is always read-only")
    void readonly() {
        MainPages.click("MultiValueHover readonly");
        MainPages.FirstLevelMenu.click("Info");
        var info = $box.findInfoWidgetByTitle("Info title");
        var customField = info.multiValueHover("Custom Field");
        assertThatThrownBy(customField::getReadOnly).isInstanceOf(UnsupportedOperationException.class);
    }

    @Test
    @Tag("Positive")
    @DisplayName("The test for getting the value from the field")
    void read() {
        MainPages.click("MultiValueHover basic");
        MainPages.FirstLevelMenu.click("Info");
        var info = $box.findInfoWidgetByTitle("Info title");
        var customField = info.multiValueHover("Custom Field");
        assertThat(customField.getValue()).isEqualTo("Saturn's interior is thought to be composed of a rocky core, surrounded by a deep layer of metallic hydrogen, an intermediate layer of liquid hydrogen and liquid helium\n" +
                "Despite consisting mostly of hydrogen and helium, most of Saturn's mass is not in the gas phase, because hydrogen becomes a non-ideal liquid when the density is above 0.01 g/cm3, which is reached at a radius containing 99.9% of Saturn's mass.");
    }

    @Test
    @Severity(MINOR)
    @Tag("Negative")
    @DisplayName("Filtering test")
    @Description("Filtering is not available for InfoWidget.")
    void filtration() {
        MainPages.click("MultiValueHover filtration");
        MainPages.FirstLevelMenu.click("Info");
        var info = $box.findInfoWidgetByTitle("Info title");
        var customField = info.multiValueHover("Custom Field");
        assertThatThrownBy(customField::setFiltration).isInstanceOf(UnsupportedOperationException.class);
    }

    @Test
    @Tag("Positive")
    @DisplayName("The DrillDown test")
    @Description("DrillDown is not available for InfoWidget.")
    void drillDown() {
        MainPages.click("MultiValueHover drilldown");
        MainPages.FirstLevelMenu.click("Info");
        var info = $box.findInfoWidgetByTitle("Info title");
        var customField = info.multiValueHover("custom Field");
        assertThatThrownBy(customField::drillDown).isInstanceOf(UnsupportedOperationException.class);
    }

    @Test
    @Severity(MINOR)
    @Tag("Negative")
    @DisplayName("Sorting test")
    @Description("Sorting is not available for InfoWidget.")
    void sorting() {
        MainPages.click("MultiValue filtration");
        MainPages.FirstLevelMenu.click("Info");
        var info = $box.findInfoWidgetByTitle("Info title");
        var customField = info.multiValue("Custom Field");
        assertThatThrownBy(customField::setSorting).isInstanceOf(UnsupportedOperationException.class);
    }
}
