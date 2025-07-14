package application.Samples.List;

import application.config.BaseTestForSamples;
import com.codeborne.selenide.Selenide;
import core.MainPages;
import core.widget.TestingTools.Constants;
import core.widget.list.actions.MenuRow;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Severity;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static io.qameta.allure.SeverityLevel.CRITICAL;
import static io.qameta.allure.SeverityLevel.MINOR;
import static org.assertj.core.api.Assertions.assertThat;


@DisplayName("List. Checking the basic functions for the SuggestionPickList in the widget List")
@Epic("Samples")
@Tag("Samples")
@Tag("List")
public class SuggestionPickListOnListTest extends BaseTestForSamples {

    @Test
    @Tag("Positive")
    @DisplayName("Test for getting the Placeholder value")
    @Description("The test gets the value from the placeholder attribute and returns it in String format")
    void placeholder() {
        MainPages.click("SuggestionPickList placeholder");
        MainPages.FirstLevelMenu.click("List");
        var list = $box.findListWidgetByTitle("List Widget with suggestionPickList placeholder");
        List<String> listRows = list.getNoFocusValues("customField");
        var customField = list.findRowSegmentByValue("customField", listRows.get(0)).suggestionPickList();
        assertThat(customField.getPlaceholder()).isEqualTo("Placeholder text");
    }

    @Test
    @Tag("Positive")
    @DisplayName("A test to get the field color value in Hex format")
    @Description("The test gets the value from the style attribute in RGB format, and then converts it to Hex format")
    void color() {
        MainPages.click("SuggestionPickList color");
        MainPages.SecondLevelMenu.click("List");
        var list = $box.findListWidgetByTitle("List Widget with suggestionPickList color");
        List<String> listRows = list.getNoFocusValues("customField");
        var customField = list.findRowSegmentByValue("customField", listRows.get(0)).suggestionPickList();
        assertThat(customField.getHexColor()).isEqualTo("#EDA6A6");
    }

    @Test
    @Tag("Positive")
    @DisplayName("A test to check the field for \"Read-only\"")
    @Description("The test checks for the disabled attribute.")
    void readonly() {
        MainPages.click("SuggestionPickList readonly");
        MainPages.FirstLevelMenu.click("List");
        var list = $box.findListWidgetByTitle("List");
        List<String> listRows = list.getNoFocusValues("customField");
        var customField = list.findRowSegmentByValue("customField", listRows.get(0)).suggestionPickList();
        assertThat(customField.getReadOnly()).isTrue();
    }


    @Test
    @Severity(CRITICAL)
    @Tag("Positive")
    @DisplayName("A test for setting a value in a field")
    @Description("The test sets the value in the field via Popup using a unique id, and then checks the value in the field with what needs to be set.")
    void edit() {
        MainPages.click("SuggestionPicklist basic");
        MainPages.SecondLevelMenu.click("List");
        var list = $box.findListWidgetByTitle("List Widget with suggestionPickList basic");
        List<String> listRows = list.getNoFocusValues("customField");
        var customField = list.findRowSegmentByValue("customField", listRows.get(0)).suggestionPickList();
        customField.setValue("Test data9");
        assertThat(customField.getValue()).isEqualTo("Test data9");
    }

    @Test
    @Severity(MINOR)
    @Tag("Negative")
    @DisplayName("Filtering test")
    @Description("Filtering by the specified column.")
    void filtration() {
        MainPages.click("SuggestionPicklist filtration");
        MainPages.FirstLevelMenu.click("List");
        var list = $box.findListWidgetByTitle("List");
        list.findFilterColumn("customField").inputFilter().setFilter("data7");
        assertThat(list.getNoFocusValues("customField")).isEqualTo(List.of("test data7"));
    }


    @Test
    @Tag("Positive")
    @DisplayName("The DrillDown test")
    @Description("Checking the url before the transition and after the transition/click on a special element")
    void drillDown() {
        MainPages.click("SuggestionPicklist drilldown");
        MainPages.FirstLevelMenu.click("List");
        var list = $box.findListWidgetByTitle("List Widget with suggestionPickList drilldown");
        List<String> listRows = list.getNoFocusValues("customField");
        var customField = list.findRowSegmentByValue("customField", listRows.get(0)).suggestionPickList();
        assertThat(customField.drillDown()).isTrue();
    }


    @Test
    @Severity(MINOR)
    @Tag("Negative")
    @DisplayName("Sorting test")
    @Description("Sorting by the specified column.")
    void sorting() {
        MainPages.click("SuggestionPicklist sorting");
        MainPages.FirstLevelMenu.click("List");
        var list = $box.findListWidgetByTitle("List");
        assertThat(list.getNoFocusValues("customField")).isEqualTo(List.of(
                "test data7",
                "test data6",
                "test data5",
                "test data4",
                "test data3",
                "test data2",
                "test data1",
                "test data"
        ));
        list.setSorting("customField");
        list.setSorting("customField");
        assertThat(list.getNoFocusValues("customField")).isEqualTo(List.of(
                "test data",
                "test data1",
                "test data2",
                "test data3",
                "test data4",
                "test data5",
                "test data6",
                "test data7"
        ));
    }

    @Test
    @Severity(CRITICAL)
    @Tag("Negative")
    @DisplayName("Required Message text Verification field test")
    @Description("The test clears the field and clicks the Save button. Then validates the message that the field is required.")
    void required() {
        MainPages.click("SuggestionPicklist required");
        MainPages.FirstLevelMenu.click("List");
        var list = $box.findListWidgetByTitle("List");
        List<String> listRows = list.getNoFocusValues("customField");
        var row = list.findRowSegmentByValue("customField", listRows.get(0));
        row.suggestionPickList().clear();
        Selenide.sleep(100);
        Optional<MenuRow> menuRow = row.findMenuRow();
        assertThat(menuRow).isPresent();
        menuRow.get().clickOption("save");
        assertThat(row.suggestionPickList().getRequiredMessage()).isEqualTo(Constants.RequiredMessage);
    }

}
