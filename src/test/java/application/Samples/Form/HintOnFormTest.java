package application.Samples.Form;

import core.config.BaseTestForSamples;
import core.MainPages;
import core.widget.form.FormWidget;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Severity;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.selenide.videorecorder.junit5.VideoRecorderExtension;

import static io.qameta.allure.SeverityLevel.CRITICAL;
import static io.qameta.allure.SeverityLevel.MINOR;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("Form. Checking the basic functions for the Hint in the widget Form")
@Epic("Samples")
@Tag("Samples")
@Tag("Form") 
@ExtendWith(VideoRecorderExtension.class)
public class HintOnFormTest extends BaseTestForSamples {

//    @Test
//    @Tag("Positive")
//    @DisplayName("Test for getting the Placeholder value")
//    @Description("Getting a Placeholder is not available")
//    void placeholder() {
//        MainPages.click("Hint placeholder");
//        MainPages.FirstLevelMenu.click("Form");
//        FormWidget form = page.findFormWidgetByTitle("Form title");
//        var customField = form.input("customField");
//        assertThat(customField.getPlaceholder()).isEqualTo("Placeholder text");
//    }

    @Test
    @Tag("Positive")
    @DisplayName("A test to get the field color value in Hex format")
    @Description("Getting the field color is not available")
    void color() {
        MainPages.click("Hint color");
        MainPages.FirstLevelMenu.click("Form");
        FormWidget form = $box.findFormWidgetByTitle("Form title");
        var customField = form.hint("Custom Field");
        assertThatThrownBy(customField::getHexColor).isInstanceOf(UnsupportedOperationException.class);
    }

    @Test
    @Tag("Positive")
    @DisplayName("A test to check the field for \"Read-only\"")
    @Description("The Hint field type is always read-only")
    void readonly() {
        MainPages.click("Hint readonly");
        MainPages.FirstLevelMenu.click("Form");
        FormWidget form = $box.findFormWidgetByTitle("Form title");
        var customField = form.hint("Custom Field");
        assertThatThrownBy(customField::getReadOnly).isInstanceOf(UnsupportedOperationException.class);
    }

    @Test
    @Severity(CRITICAL)
    @Tag("Positive")
    @DisplayName("A test to check the value in a field")
    @Description("A test to get the value from the field. Hint is always read-only, so it is impossible to set the value.")
    void edit() {
        MainPages.click("Hint basic");
        MainPages.FirstLevelMenu.click("Form");
        FormWidget form = $box.findFormWidgetByTitle("Form title");
        var customField = form.hint("Custom Field");
        assertThat(customField.getValue()).isEqualTo("Information data");
    }

    @Test
    @Severity(MINOR)
    @Tag("Negative")
    @DisplayName("Filtering test")
    @Description("Filtering is not available for the Form widget")
    void filtration() {
        MainPages.click("Hint filtration");
        MainPages.FirstLevelMenu.click("Form");
        FormWidget form = $box.findFormWidgetByTitle("Form title");
        var customField = form.hint("Custom Field");
        assertThatThrownBy(customField::setFiltration).isInstanceOf(UnsupportedOperationException.class);
    }


    @Test
    @Tag("Positive")
    @DisplayName("The DrillDown test")
    @Description("The transition/Redirect is not available")
    void drillDown() {
        MainPages.click("Hint drilldown");
        MainPages.FirstLevelMenu.click("Form");
        FormWidget form = $box.findFormWidgetByTitle("Form title");
        var customField = form.hint("customField2");
        assertThatThrownBy(customField::drillDown).isInstanceOf(UnsupportedOperationException.class);
    }
}
