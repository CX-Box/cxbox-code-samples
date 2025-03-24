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

import static io.qameta.allure.SeverityLevel.MINOR;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("Info. Checking the basic functions for the Input")
@Epic("application/Samples")
@Tag("application/Samples")
@ExtendWith(VideoRecorderExtension.class)
public class InputOnInfoTest extends BaseTestForSamples {

    @Test
    @Tag("Positive")
    @DisplayName("Test for getting the Placeholder value")
    @Description("The InfoWidget doesn't have a Placeholder.")
    void placeholder() {
        MainPages.click("Input placeholder");
        MainPages.FirstLevelMenu.click("Info");
        var info = page.findInfoWidgetByTitle("Info");
        var customField = info.input("customField");
        assertThatThrownBy(customField::getPlaceholder).isInstanceOf(UnsupportedOperationException.class);
    }

    @Test
    @Tag("Positive")
    @DisplayName("A test to get the field color value in Hex format")
    @Description("The test gets the value from the style attribute in RGB format, and then converts it to Hex format")
    void color() {
        MainPages.click("Input color");
        MainPages.FirstLevelMenu.click("Info");
        var info = page.findInfoWidgetByTitle("Info");
        var customField = info.input("customField");
        assertThat(customField.getHexColor()).isEqualTo("#EDA6A6");
    }

    @Test
    @Tag("Positive")
    @DisplayName("A test to check the field for \"Read-only\"")
    @Description("Info Widget is always read-only")
    void readonly() {
        MainPages.click("Input readonly");
        MainPages.FirstLevelMenu.click("Info");
        var info = page.findInfoWidgetByTitle("Info");
        var customField = info.input("customField");
        assertThatThrownBy(customField::getReadOnly).isInstanceOf(UnsupportedOperationException.class);
    }

    @Test
    @Tag("Positive")
    @DisplayName("The test for getting the value from the field")
    void read() {
        MainPages.click("Input basic");
        MainPages.FirstLevelMenu.click("Info");
        var info = page.findInfoWidgetByTitle("Info");
        var customField = info.input("customField");
        assertThat(customField.getValue()).isEqualTo("test data");
    }

    @Test
    @Severity(MINOR)
    @Tag("Negative")
    @DisplayName("Filtering test")
    @Description("Filtering is not available for InfoWidget.")
    void filtration() {
        MainPages.click("Input filtration");
        MainPages.FirstLevelMenu.click("Info");
        var info = page.findInfoWidgetByTitle("Info");
        var customField = info.input("customField");
        assertThatThrownBy(customField::setFiltration).isInstanceOf(UnsupportedOperationException.class);
    }

    @Test
    @Tag("Positive")
    @DisplayName("The DrillDown test")
    @Description("DrillDown is not available for InfoWidget.")
    void drillDown() {
        MainPages.click("Input drilldown");
        MainPages.FirstLevelMenu.click("Info");
        var info = page.findInfoWidgetByTitle("Info");
        var customField = info.input("customField");
        assertThat(customField.drillDown()).isTrue();
    }

    @Test
    @Severity(MINOR)
    @Tag("Negative")
    @DisplayName("Sorting test")
    @Description("Sorting is not available for InfoWidget.")
    void sorting() {
        MainPages.click("Input filtration");
        MainPages.FirstLevelMenu.click("Info");
        var info = page.findInfoWidgetByTitle("Info");
        var customField = info.input("customField");
        assertThatThrownBy(customField::setSorting).isInstanceOf(UnsupportedOperationException.class);
    }
}
