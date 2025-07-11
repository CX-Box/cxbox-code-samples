package application.Samples.List;

import application.config.BaseTestForSamples;
import core.MainPages;
import io.qameta.allure.Epic;
import io.qameta.allure.Severity;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static io.qameta.allure.SeverityLevel.MINOR;
import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("List. Checking the basic functions for the MultiField in the widget List")
@Epic("Samples")
@Tag("Samples")
@Tag("List")
public class MultiFieldOnListTest extends BaseTestForSamples {

    @Test
    @Severity(MINOR)
    @Tag("Negative")
    @DisplayName("A test to get a value for a multifield hint")
    void getValues() {
        MainPages.click("Multifield basic");
        MainPages.FirstLevelMenu.click("List");
        var list = $box.findListWidgetByTitle("List title");
        List<String> listRows = list.getListRows();
        var column = list.getNoFocusValues("Custom Field Additional");
        var column2 = list.getNoFocusValues("Custom multifield hint");
        assertThat(column).isEqualTo(List.of("Additional test data" ,"Additional test data 2"));
        assertThat(column2).isEqualTo(List.of("Test data\nInformation data" ,"Test data 2\nInformation data 2"));
    }
    @Test
    @Severity(MINOR)
    @Tag("Negative")
    @DisplayName("Filtering test")
    void filtration() {
        MainPages.click("Multifield filtration");
        MainPages.FirstLevelMenu.click("List");
        var list = $box.findListWidgetByTitle("List title");
        list.findFilterColumn("Custom Field Additional").multiFieldFilter().setFilter("2");
        assertThat(list.getNoFocusValues("Custom multifield")).isEqualTo(List.of("Data multi 2\n" +
                "Additional data multi 2"));
    }
}