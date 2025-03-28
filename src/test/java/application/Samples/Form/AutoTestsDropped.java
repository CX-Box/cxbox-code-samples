package application.Samples.Form;

import core.ConfigTest.BaseTestForSamples;
import core.MainPages;
import core.widget.form.FormWidget;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Story;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.selenide.videorecorder.junit5.VideoRecorderExtension;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("Checking counter of dropped tests")
@Epic("application/Samples")
@Story("Form")
@Tag("application/Samples")
@Tag("Form")
@Slf4j
@ExtendWith(VideoRecorderExtension.class)
public class AutoTestsDropped extends BaseTestForSamples {

    @Test
    @Tag("Positive")
    @DisplayName("failedTests1")
    @Description("failedTests1")
    void failedTests1() {
        MainPages.click("Checkbox placeholder");
        MainPages.FirstLevelMenu.click("Form");
        FormWidget form = page.findFormWidgetByTitle("Form title");
        assertThat(1).isEqualTo(2);
    }

    @Test
    @Tag("Positive")
    @DisplayName("failedTests2")
    @Description("failedTests2")
    void failedTests2() {
        MainPages.click("Checkbox placeholder");
        MainPages.FirstLevelMenu.click("Form");
        FormWidget form = page.findFormWidgetByTitle("Form title");
        assertThat(1).isEqualTo(2);
    }

    @Test
    @Tag("Positive")
    @DisplayName("failedTests2")
    @Description("failedTests2")
    void failedTests3() {
        MainPages.click("Checkbox placeholder");
        MainPages.FirstLevelMenu.click("Form");
        FormWidget form = page.findFormWidgetByTitle("Form title");
        assertThat(1).isEqualTo(2);
    }
}
