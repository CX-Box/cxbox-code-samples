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

import java.math.BigDecimal;

import static io.qameta.allure.SeverityLevel.CRITICAL;
import static io.qameta.allure.SeverityLevel.MINOR;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("Form. Checking the basic functions for the NumberDigits in the widget Form")
@Epic("application/Samples")
@Tag("application/Samples")
@Tag("Form") 
@ExtendWith(VideoRecorderExtension.class)
@Tag("NumberDigitsForm")
public class NumberDigitsOnFormTest extends BaseTestForSamples {

    @Test
    @Tag("Positive")
    @DisplayName("Test for getting the Placeholder value")
    @Description("The test gets the value from the placeholder attribute and returns it in String format")
    void placeholder() {
        MainPages.click("Number placeholder");
        MainPages.FirstLevelMenu.click("Form");
        FormWidget form = $box.findFormWidgetByTitle("Form title");
        var customField = form.numberDigits("custom Field");
        assertThat(customField.getPlaceholder()).isEqualTo("123456");
    }

    @Test
    @Tag("Positive")
    @DisplayName("A test to get the field color value in Hex format")
    @Description("The test gets the value from the style attribute in RGB format, and then converts it to Hex format")
    void color() {
        MainPages.click("Number color");
        MainPages.FirstLevelMenu.click("Form");
        FormWidget form = $box.findFormWidgetByTitle("Form title");
        var customField = form.numberDigits("custom Field");
        assertThat(customField.getHexColor()).isEqualTo("#EDA6A6");
    }

    @Test
    @Tag("Positive")
    @DisplayName("A test to check the field for \"Read-only\"")
    @Description("The test checks for the disabled attribute")
    void readonly() {
        MainPages.click("Number readonly");
        MainPages.FirstLevelMenu.click("Form");
        FormWidget form = $box.findFormWidgetByTitle("Form title");
        var customField = form.numberDigits("custom Field");
        assertThat(customField.getReadOnly()).isTrue();
    }

    @Test
    @Severity(CRITICAL)
    @Tag("Positive")
    @DisplayName("A test for setting a value in a field")
    @Description("The test sets the value in the field, and then checks the value in the field with what should be set")
    void edit() {
        MainPages.click("Number basic");
        MainPages.FirstLevelMenu.click("Form");
        FormWidget form = $box.findFormWidgetByTitle("Form title");
        var customField = form.numberDigits("custom Field");
        BigDecimal number = new BigDecimal("131343.23");
        customField.setValue(number);
        assertThat(customField.getValue()).isEqualTo(number);
    }

    @Test
    @Severity(MINOR)
    @Tag("Negative")
    @DisplayName("Filtering test")
    @Description("Filtering is not available for the Form widget")
    void filtration() {
        MainPages.click("Number filtration");
        MainPages.FirstLevelMenu.click("Form");
        FormWidget form = $box.findFormWidgetByTitle("Form title");
        var customField = form.number("Custom Field");
        assertThatThrownBy(customField::setFiltration).isInstanceOf(UnsupportedOperationException.class);
    }

    @Test
    @Tag("Positive")
    @DisplayName("The DrillDown test")
    @Description("Checking the url before the transition and after the transition/click on a special element")
    void drillDown() {
        MainPages.click("Number drilldown");
        MainPages.FirstLevelMenu.click("Form");
        FormWidget form = $box.findFormWidgetByTitle("Form title");
        var customField = form.number("custom Field");
        assertThatThrownBy(customField::drillDown).isInstanceOf(UnsupportedOperationException.class);
    }
}
