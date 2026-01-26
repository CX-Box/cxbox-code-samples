package application.Samples.Info;

import application.config.BaseTestForSamples;
import core.MainPages;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("Info. Checking the basic functions for the Time")
@Epic("application/Samples")
@Tag("application/Samples")
public class TimeOnInfoTest extends BaseTestForSamples {


    @Test
    @Tag("Positive")
    @DisplayName("A test to get the field color value in Hex format")
    @Description("The test gets the value from the style attribute in RGB format, and then converts it to Hex format")
    void color() {
        MainPages.click("Time color");
        MainPages.FirstLevelMenu.click("Info");
        var info = $box.findInfoWidgetByTitle("Info title");
        var customField = info.time("Custom Field", "HH:mm:ss");
        assertThat(customField.getHexColor()).isEqualTo("#EDA6A6");
    }

    @Test
    @Tag("Positive")
    @DisplayName("A test to read value")
    @Description("The test checks the value in the field with what should be set")
    void read() {
        MainPages.click("Time base");
        MainPages.FirstLevelMenu.click("Info");
        var info = $box.findInfoWidgetByTitle("Info title");
        var customField = info.time("h:mm:ss", "HH:mm:ss");
        assertThat(customField.getValue()).isEqualTo(LocalDateTime.of(2024, 12, 5, 11, 54, 25));
    }

    @Test
    @Tag("Positive")
    @DisplayName("A test to read value")
    @Description("The test checks the value in the field with what should be set")
    void read2() {
        MainPages.click("Time base");
        MainPages.FirstLevelMenu.click("Info");
        var info = $box.findInfoWidgetByTitle("Info title");
        var customField = info.time("h:mm", "HH:mm");
        assertThat(customField.getValue()).isEqualTo(LocalDateTime.of(2024, 12, 5, 11, 54));
    }

    @Test
    @Tag("Positive")
    @DisplayName("A test to read value")
    @Description("The test checks the value in the field with what should be set")
    void read3() {
        MainPages.click("Time base");
        MainPages.FirstLevelMenu.click("Info");
        var info = $box.findInfoWidgetByTitle("Info title");
        var customField = info.time("h:mm:ss A", "HH:mm:ss a");
        assertThat(customField.getValue()).isEqualTo(LocalDateTime.of(2024, 12, 5, 11, 54, 25));
        assertThat(customField.getStringValue()).isEqualTo("11:54:25 AM");
    }


    @Test
    @Tag("Positive")
    @DisplayName("The DrillDown test")
    @Description("Checking the url before the transition and after the transition/click on a special element")
    void drillDown() {
        MainPages.click("Time drilldown");
        MainPages.FirstLevelMenu.click("Info");
        var info = $box.findInfoWidgetByTitle("Info title");
        var customField = info.time("Custom Field", "HH:mm:ss a");
        assertThat(customField.drillDown()).isTrue();
    }

}
