package application.Samples.Info;

import core.ConfigTest.BaseTestForSamples;
import core.MainPages;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Severity;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.selenide.videorecorder.junit5.VideoRecorderExtension;

import java.util.List;

import static io.qameta.allure.SeverityLevel.MINOR;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("Info. Checking the basic functions for the MultiValue")
@Epic("Samples")
@Tag("Samples")
@ExtendWith(VideoRecorderExtension.class)
public class MultiValueOnInfoTest extends BaseTestForSamples {

    @Test
    @Tag("Positive")
    @DisplayName("Test for getting the Placeholder value")
    @Description("The InfoWidget doesn't have a Placeholder..")
    void placeholder() {
        MainPages.click("MultiValue placeholder");
        MainPages.FirstLevelMenu.click("Info");
        var info = page.findInfoWidgetByTitle("Info title");
        var customField = info.multiValue("Custom Field");
        assertThatThrownBy(customField::getPlaceholder).isInstanceOf(UnsupportedOperationException.class);
    }

    @Test
    @Tag("Positive")
    @DisplayName("A test to get the field color value in Hex format")
    @Description("The test gets the value from the style attribute in RGB format, and then converts it to Hex format")
    void color() {
        MainPages.click("MultiValue color");
        MainPages.FirstLevelMenu.click("Info");
        var info = page.findInfoWidgetByTitle("Info title");
        var customField = info.multiValue("Custom Field");
        assertThat(customField.getHexColor()).isNull();
    }

    @Test
    @Tag("Positive")
    @DisplayName("A test to check the field for \"Read-only\"")
    @Description("Info Widget is always read-only")
    void readonly() {
        MainPages.click("MultiValue readonly");
        MainPages.FirstLevelMenu.click("Info");
        var info = page.findInfoWidgetByTitle("Info title");
        var customField = info.multiValue("Custom Field");
        assertThatThrownBy(customField::getReadOnly).isInstanceOf(UnsupportedOperationException.class);
    }

    @Test
    @Tag("Positive")
    @DisplayName("The test for getting the value from the field")
    void read() {
        MainPages.click("MultiValue basic");
        MainPages.FirstLevelMenu.click("Info");
        var info = page.findInfoWidgetByTitle("Info title");
        var customField = info.multiValue("Custom Field");
        assertThat(customField.getValue()).isEqualTo(List.of("Abs data",
                "Abs data",
                "Test data",
                "Test data",
                "Information data",
                "Information data",
                "Information2 data",
                "Information2 data",
                "Information3 data",
                "Information3 data",
                "Information4 data",
                "Information4 data",
                "Information5 data",
                "Information5 data",
                "Information6 data",
                "Information6 data",
                "Information7 data",
                "Information7 data",
                "Information8 data",
                "Information8 data",
                "Information9 data",
                "Information9 data",
                "Information10 data",
                "Information10 data"));
    }

    @Test
    @Severity(MINOR)
    @Tag("Negative")
    @DisplayName("Filtering test")
    @Description("Filtering is not available for InfoWidget.")
    void filtration() {
        MainPages.click("MultiValue filtration");
        MainPages.FirstLevelMenu.click("Info");
        var info = page.findInfoWidgetByTitle("Info title");
        var customField = info.multiValue("Custom Field");
        assertThatThrownBy(customField::setFiltration).isInstanceOf(UnsupportedOperationException.class);
    }

    @Test
    @Tag("Positive")
    @DisplayName("The DrillDown test")
    @Description("Drill Down is not available for InfoWidget.")
    void drillDown() {
        MainPages.click("MultiValue drilldown");
        MainPages.FirstLevelMenu.click("Info");
        var info = page.findInfoWidgetByTitle("Info title");
        var customField = info.multiValue("custom Field");
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
        var info = page.findInfoWidgetByTitle("Info title");
        var customField = info.multiValue("Custom Field");
        assertThatThrownBy(customField::setSorting).isInstanceOf(UnsupportedOperationException.class);
    }
}
