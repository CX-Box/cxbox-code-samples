package application.Samples.List;

import application.config.BaseTestForSamples;
import core.MainPages;
import core.widget.TestingTools.Constants;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Severity;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import static io.qameta.allure.SeverityLevel.CRITICAL;
import static io.qameta.allure.SeverityLevel.MINOR;
import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("List. Checking the basic functions for the Time")
@Epic("application/Samples")
@Tag("application/Samples")
public class TimeOnListTest extends BaseTestForSamples {

    @Test
    @Tag("Positive")
    @DisplayName("Test for getting the Placeholder value")
    @Description("The test gets the value from the placeholder attribute and returns it in String format")
    void placeholder() {
        MainPages.click("Time placeholder");
        MainPages.FirstLevelMenu.click("List");
        var list = $box.findListWidgetByTitle("List title");
        List<String> listRows = list.getNoFocusValues("Custom Field");
        var customField = list.findRowSegmentByValue("Custom Field", listRows.get(0)).time("HH:mm:ss");
        assertThat(customField.getPlaceholder()).isEqualTo("11:25:58");
    }

    @Test
    @Tag("Positive")
    @DisplayName("A test to get the field color value in Hex format")
    @Description("The test gets the value from the style attribute in RGB format, and then converts it to Hex format")
    void color() {
        MainPages.click("Time color");
        MainPages.FirstLevelMenu.click("List");
        var list = $box.findListWidgetByTitle("List title");
        List<String> listRows = list.getNoFocusValues("Custom Field");
        var customField = list.findRowSegmentByValue("Custom Field", listRows.get(0)).time("HH:mm:ss");
        assertThat(customField.getHexColor()).isEqualTo("#EDA6A6");
    }

    @Test
    @Tag("Positive")
    @DisplayName("A test to check the field for \"Read-only\"")
    @Description("The test checks for the disabled attribute.")
    void readonly() {
        MainPages.click("Time readonly");
        MainPages.FirstLevelMenu.click("List");
        var list = $box.findListWidgetByTitle("List title");
        List<String> listRows = list.getNoFocusValues("Custom Field");
        var customField = list.findRowSegmentByValue("Custom Field", listRows.get(0)).time("HH:mm:ss");
        assertThat(customField.getReadOnly()).isTrue();
    }

    @Test
    @Severity(CRITICAL)
    @Tag("Positive")
    @DisplayName("A test for setting a value in a field")
    @Description("The test sets the value in the field, and then checks the value in the field with what should be set")
    void edit() {
        MainPages.click("Time base");
        MainPages.FirstLevelMenu.click("List");
        var list = $box.findListWidgetByTitle("List title");
        List<String> listRows = list.getNoFocusValues("Custom Field h:mm:ss");
        var customField = list.findRowSegmentByValue("Custom Field h:mm:ss", listRows.get(0)).time("HH:mm:ss");
        LocalDateTime date = LocalDateTime.of(2024, 12, 5, 11, 25, 58);
        customField.setValue(date);
        assertThat(customField.getValue().format(DateTimeFormatter.ofPattern("HH:mm:ss"))).isEqualTo(date.format(DateTimeFormatter.ofPattern("HH:mm:ss")));
    }


    @Test
    @Severity(CRITICAL)
    @Tag("Positive")
    @DisplayName("A test for setting a value in a field")
    @Description("The test sets the value in the field, and then checks the value in the field with what should be set")
    void edit2() {
        MainPages.click("Time base");
        MainPages.FirstLevelMenu.click("List");
        var list = $box.findListWidgetByTitle("List title");
        List<String> listRows = list.getNoFocusValues("Custom Field h:mm");
        var customField = list.findRowSegmentByValue("Custom Field h:mm", listRows.get(0)).time("HH:mm");
        LocalDateTime date = LocalDateTime.of(2024, 12, 5, 11, 25);
        customField.setValue(date);
        assertThat(customField.getValue().format(DateTimeFormatter.ofPattern("HH:mm"))).isEqualTo(date.format(DateTimeFormatter.ofPattern("HH:mm")));
    }

    @Test
    @Severity(CRITICAL)
    @Tag("Positive")
    @DisplayName("A test for setting a value in a field")
    @Description("The test sets the value in the field, and then checks the value in the field with what should be set")
    void edit3() {
        MainPages.click("Time base");
        MainPages.FirstLevelMenu.click("List");
        var list = $box.findListWidgetByTitle("List title");
        List<String> listRows = list.getNoFocusValues("Custom Field h:mm:ss A");
        var customField = list.findRowSegmentByValue("Custom Field h:mm:ss A", listRows.get(0)).time("HH:mm:ss a");
        LocalDateTime date = LocalDateTime.of(2024, 12, 5, 11, 25, 58);
        customField.setValue(date);
        assertThat(customField.getValue().format(DateTimeFormatter.ofPattern("HH:mm:ss a"))).isEqualTo(date.format(DateTimeFormatter.ofPattern("HH:mm:ss a")));
    }

    @Test
    @Severity(MINOR)
    @Tag("Negative")
    @DisplayName("Filtering test")
    @Description("Filtering by the specified column.")
    void filtration() {
        MainPages.click("Time filtration");
        MainPages.FirstLevelMenu.click("List");
        var list = $box.findListWidgetByTitle("List title");
        LocalDateTime date = LocalDateTime.of(2021, 3, 7, 5, 0);
        LocalDateTime date2 = LocalDateTime.of(2023, 3, 7, 8, 0);
        list.findFilterColumn("Custom Field h:mm").timeFilter("h:mm").setFilter(date, date2);
        assertThat(list.getNoFocusValues("Custom Field h:mm").get(0)).isEqualTo("05:58");
    }

    @Test
    @Tag("Positive")
    @DisplayName("The DrillDown test")
    @Description("Checking the url before the transition and after the transition/click on a special element")
    void drillDown() {
        MainPages.click("Time drilldown");
        MainPages.FirstLevelMenu.click("List");
        var list = $box.findListWidgetByTitle("List title");
        List<String> listRows = list.getNoFocusValues("Custom Field");
        var customField = list.findRowSegmentByValue("Custom Field", listRows.get(0)).time("HH:mm:ss");
        assertThat(customField.drillDown()).isTrue();
    }

    @Test
    @Severity(MINOR)
    @Tag("Negative")
    @DisplayName("Sorting test")
    @Description("Sorting by the specified column.")
    void sorting() {
        MainPages.click("Time sorting");
        MainPages.FirstLevelMenu.click("List");
        var list = $box.findListWidgetByTitle("List title");
       assertThat(list.getNoFocusValues("Custom Field h:mm:ss")).isEqualTo(List.of(
                "05:58:54",
                "10:58:54",
                "12:28:54",
                "12:58:54"));

        list.setSorting("Custom Field h:mm:ss");
        assertThat(list.getNoFocusValues("Custom Field h:mm:ss")).isEqualTo(List.of(
                "12:58:54",
                "12:28:54",
                "10:58:54",
                "05:58:54"));

        list.setSorting("Custom Field h:mm:ss");
        assertThat(list.getNoFocusValues("Custom Field h:mm:ss")).isEqualTo(List.of(
                "05:58:54",
                "10:58:54",
                "12:28:54",
                "12:58:54"));
    }

    @Test
    @Severity(CRITICAL)
    @Tag("Negative")
    @DisplayName("Required Message text Verification field test")
    @Description("The test clears the field and clicks the Save button. Then validates the message that the field is required.")
    void required() {
        MainPages.click("Time required");
        MainPages.FirstLevelMenu.click("List");
        var list = $box.findListWidgetByTitle("List title");
        List<String> listRows = list.getNoFocusValues("Custom Field");
        var customField = list.findRowSegmentByValue("Custom Field", listRows.get(0)).time("HH:mm:ss");
        customField.clearIcon();
        assertThat(customField.getRequiredMessage()).isEqualTo(Constants.RequiredMessage);
    }

}
