package application.Samples.Form;

import core.ConfigTest.BaseTestForSamples;
import core.MainPages;
import core.widget.form.FormWidget;
import io.qameta.allure.Epic;
import io.qameta.allure.Severity;
import org.apache.commons.lang3.tuple.Pair;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.selenide.videorecorder.junit5.VideoRecorderExtension;

import java.util.List;

import static io.qameta.allure.SeverityLevel.MINOR;
import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("Form. Checking the basic functions for the MultiField in the widget Form")
@Epic("Samples")
@Tag("Samples")
@Tag("Form") 
@ExtendWith(VideoRecorderExtension.class)
public class MultiFieldOnFormTest extends BaseTestForSamples {

    @Test
    @Severity(MINOR)
    @Tag("Negative")
    @DisplayName("A test to get a value for a multifield hint")
    void getValues() {
        MainPages.click("Multifield basic");
        MainPages.FirstLevelMenu.click("Form");
        FormWidget form = page.findFormWidgetByTitle("Form title");
        var customField = form.multiField("Custom multifield hint");
        assertThat(customField.getValue()).isEqualTo(List.of(Pair.of("input", "Test data"), Pair.of("hint", "Information data")));
    }
    @Test
    @Severity(MINOR)
    @Tag("Negative")
    @DisplayName("A test to get a value for a multifield")
    void getValues2() {
        MainPages.click("Multifield basic");
        MainPages.FirstLevelMenu.click("Form");
        FormWidget form = page.findFormWidgetByTitle("Form title");
        var customField = form.multiField("Custom multifield");
        assertThat(customField.getValue()).isEqualTo(List.of(Pair.of("input", "Additional data multi"), Pair.of("input", "Data multi")));
    }
}
