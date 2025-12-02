package application.Samples.List;

import application.common.Text;
import application.config.BaseTestForSamples;
import core.MainPages;
import core.widget.TestingTools.Constants;
import core.widget.form.FormWidget;
import core.widget.list.actions.MenuRow;
import core.widget.modal.confirm.constantsConfirm;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Severity;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import static io.qameta.allure.SeverityLevel.CRITICAL;
import static io.qameta.allure.SeverityLevel.MINOR;
import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("List. Checking the basic functions for the DateTimeWithSeconds in the widget List")
@Epic("Samples")
@Tag("Samples")
@Tag("List")
public class DateTimeWithSecondsOnListTest extends BaseTestForSamples {

    @Test
    @Tag("Positive")
    @DisplayName("Test for getting the Placeholder value")
    @Description("The test gets the value from the placeholder attribute and returns it in String format")
    void placeholder() {
        MainPages.click("DateTimeWithSeconds placeholder");
        MainPages.FirstLevelMenu.click("List");
        var list = $box.findListWidgetByTitle("List title");
        List<String> listRows = list.getNoFocusValues("custom Field");
        var customField = list.findRowSegmentByValue("custom Field", listRows.get(0)).dateTimeWithSeconds();
        assertThat(customField.getPlaceholder()).isEqualTo("29.05.2023 11:25:58");
    }

    @Test
    @Tag("Positive")
    @DisplayName("A test to get the field color value in Hex format")
    @Description("The test gets the value from the style attribute in RGB format, and then converts it to Hex format")
    void color() {
        MainPages.click("DateTimeWithSeconds color");
        MainPages.FirstLevelMenu.click("List");
        var list = $box.findListWidgetByTitle("List title");
        List<String> listRows = list.getNoFocusValues("custom Field");
        var customField = list.findRowSegmentByValue("custom Field", listRows.get(0)).dateTimeWithSeconds();
        assertThat(customField.getHexColor()).isEqualTo("#EDA6A6");
    }

    @Test
    @Tag("Positive")
    @DisplayName("A test to check the field for \"Read-only\"")
    @Description("The test checks for the disabled attribute.")
    void readonly() {
        MainPages.click("DateTimeWithSeconds readonly");
        MainPages.FirstLevelMenu.click("Form");
        FormWidget form = $box.findFormWidgetByTitle("Form title");
        var customField = form.dateTimeWithSeconds("custom Field");
        assertThat(customField.getReadOnly()).isTrue();
    }

    @Test
    @Severity(CRITICAL)
    @Tag("Positive")
    @DisplayName("A test for setting a value in a field")
    @Description("The test sets the value in the field, and then checks the value in the field with what should be set.")
    void edit() {
        MainPages.click("DateTimeWithSeconds basic");
        MainPages.FirstLevelMenu.click("List");
        var list = $box.findListWidgetByTitle("List title");
        List<String> listRows = list.getNoFocusValues("custom Field");
        var customField = list.findRowSegmentByValue("custom Field", listRows.get(0)).dateTimeWithSeconds();
        LocalDateTime dateTime = LocalDateTime.of(2020, 11, 10, 10, 10, 10);
        customField.setValue(dateTime);
        assertThat(customField.getValue()).isEqualTo(dateTime);
    }

    @Test
    @Severity(MINOR)
    @Tag("Negative")
    @DisplayName("Filtering test")
    @Description("Filtering by the specified column.")
    void filtration() {
        MainPages.click("DateTimeWithSeconds filtration");
        MainPages.FirstLevelMenu.click("List");
        var list = $box.findListWidgetByTitle("List title");
        LocalDateTime dateTime = LocalDateTime.of(2022, 5, 20, 8, 47, 34);
        LocalDateTime dateTime2 = LocalDateTime.of(2023, 6, 25, 8, 47, 34);
        list.findFilterColumn("custom Field").dateTimeWithSecondsFilter().setFilter(dateTime, dateTime2);
        assertThat(list.getNoFocusValues("custom Field")).isEqualTo(List.of("15.05.2023 09:20:42"));
    }

    @Test
    @Tag("Positive")
    @DisplayName("The DrillDown test")
    @Description("Checking the url before the transition and after the transition/click on a special element")
    void drillDown() {
        MainPages.click("DateTimeWithSeconds drilldown");
        MainPages.FirstLevelMenu.click("List");
        var list = $box.findListWidgetByTitle("List title");
        List<String> listRows = list.getNoFocusValues("Custom Field");
        var customField = list.findRowSegmentByValue("Custom Field", listRows.get(0)).dateTimeWithSeconds();
        assertThat(customField.drillDown("/screen/DateTimeWithSecondsDrillDown/view/DateTimeWithSecondsDrillDownform/dateTimeWithSecondsDrillDown")).isTrue();
    }

    @Test
    @Severity(CRITICAL)
    @Tag("Negative")
    @DisplayName("Business Exception Validation Test")
    @Description("The test sets the value in the field. After approval, the popup window, the title, the text in it, and the buttons are validated.")
    void businessException() {
        MainPages.click("DateTimeWithSeconds validation business exception");
        MainPages.FirstLevelMenu.click("List");
        var list = $box.findListWidgetByTitle("List title");
        List<String> listRows = list.getNoFocusValues("Custom Field");
        var row = list.findRowSegmentByValue("Custom Field", listRows.get(0));
        LocalDateTime dateTime = LocalDateTime.of(2020, 9, 10, 10, 10, 10);
        row.dateTimeWithSeconds().setValue(dateTime);
        Optional<MenuRow> menuRow = row.findMenuRow();
        assertThat(menuRow).isPresent();
        menuRow.get().clickOption("Save");
        var popup = $box.findPopup("error");
        assertThat(popup).isPresent();
        assertThat(popup.get().errorPopup().getTitle()).isEqualTo(Constants.ErrorPopup.ErrorTitle);
        assertThat(popup.get().errorPopup().getMessage()).isEqualTo(Constants.MoreThatCurrentDate);
        popup.get().errorPopup().close();
    }

    @Test
    @Severity(CRITICAL)
    @Tag("Negative")
    @DisplayName("Run-time exception validation test")
    @Description("The test sets the value in the field. After approval, the popup window, the title, the text in it, and the buttons are validated.")
    void runtimeException() {
        MainPages.click("DateTimeWithSeconds validation runtime exception");
        MainPages.FirstLevelMenu.click("List");
        var list = $box.findListWidgetByTitle("List title");
        List<String> listRows = list.getNoFocusValues("custom Field");
        var customField = list.findRowSegmentByValue("custom Field", listRows.get(0)).dateTimeWithSeconds();
        customField.clearIcon();
        var popup = $box.findPopup("error");
        assertThat(popup).isPresent();
        assertThat(popup.get().errorPopup().getTitle()).isEqualTo(Constants.ErrorPopup.ErrorTitle);
        assertThat(popup.get().errorPopup().getMessage()).isEqualTo(Constants.SystemError);
        popup.get().errorPopup().close();
    }

    @Test
    @Severity(CRITICAL)
    @Tag("Positive")
    @DisplayName("Confirmation Popup Validation Test")
    @Description("The test sets the value in the field. After approval, by clicking on the save button, the popup window, the title, the text in it, and the buttons are validated.")
    void confirm() {
        MainPages.click("DateTimeWithSeconds validation confirm");
        MainPages.FirstLevelMenu.click("List");
        var list = $box.findListWidgetByTitle("List title");
        List<String> listRows = list.getNoFocusValues("custom Field");
        var row = list.findRowSegmentByValue("custom Field", listRows.get(0));
        LocalDateTime dateTime = LocalDateTime.of(2020, 9, 10, 10, 10, 10);
        row.dateTimeWithSeconds().setValue(dateTime);
        Optional<MenuRow> menuRow = row.findMenuRow();
        assertThat(menuRow).isPresent();
        menuRow.get().clickOption("save");
        var popup = $box.findPopup("confirm");
        assertThat(popup).isPresent();
        popup.get().confirmPopup().getButtons();
        assertThat(popup.get().confirmPopup().getTitle()).isEqualTo(constantsConfirm.Title);
        assertThat(popup.get().confirmPopup().getMessage()).isEqualTo(Constants.SaveValue);
        popup.get().confirmPopup().clickOk();
    }

    @Test
    @Severity(CRITICAL)
    @Tag("Negative")
    @DisplayName("Required Message validation test for multiple fields")
    @Description("The test sets a value with the wrong data type in several fields for different widgets. After approval, it checks the text under the field, which informs about the correctness of the type of data entered")
    void fieldLevelValidation() {
        MainPages.click("DateTimeWithSeconds validation field level dynamic");
        MainPages.FirstLevelMenu.click("List");
        var list = $box.findListWidgetByTitle("List title");
        List<String> listRows = list.getNoFocusValues("Custom Field");
        var row = list.findRowSegmentByValue("Custom Field", listRows.get(0));
        List<String> listRows2 = list.getNoFocusValues("Custom Field");
        var row2 = list.findRowSegmentByValue("Custom Field Additional", listRows2.get(0));
        LocalDateTime dateTime = LocalDateTime.of(1999, 11, 10, 10, 10, 10);
        row.dateTimeWithSeconds().setValue(dateTime);
        row2.dateTimeWithSeconds().setValue(dateTime);
        Optional<MenuRow> menuRow = row.findMenuRow();
        assertThat(menuRow).isPresent();
        menuRow.get().clickOption("Save");
        assertThat(row.dateTimeWithSeconds().getRequiredMessage()).isEqualTo(Text.textMoreThatCurrentDate("customField"));
        assertThat(row2.dateTimeWithSeconds().getRequiredMessage()).isEqualTo(Text.textMoreThatCurrentDate("customFieldAdditional"));
    }

    @Test
    @Severity(MINOR)
    @Tag("Negative")
    @DisplayName("Sorting test")
    @Description("Sorting by the specified column.")
    void sorting() {
        MainPages.click("DateTimeWithSeconds sorting");
        MainPages.FirstLevelMenu.click("List");
        var list = $box.findListWidgetByTitle("List title");
        assertThat(list.getNoFocusValues("custom Field")).isEqualTo(List.of("15.07.2025 09:20:42",
                "15.06.2025 06:05:42",
                "13.05.2025 09:05:42",
                "15.05.2024 05:05:42",
                "13.05.2025 09:05:42",
                "14.05.2025 07:17:42",
                "15.05.2025 06:50:42",
                "15.05.2023 09:20:42",
                "15.05.2025 08:50:42"));

        list.setSorting("custom Field");
        assertThat(list.getNoFocusValues("custom Field")).isEqualTo(List.of("15.07.2025 09:20:42",
                "15.06.2025 06:05:42",
                "15.05.2025 08:50:42",
                "15.05.2025 06:50:42",
                "14.05.2025 07:17:42",
                "13.05.2025 09:05:42",
                "13.05.2025 09:05:42",
                "15.05.2024 05:05:42",
                "15.05.2023 09:20:42"));

        list.setSorting("custom Field");
        assertThat(list.getNoFocusValues("custom Field")).isEqualTo(List.of(
                "15.05.2023 09:20:42",
                "15.05.2024 05:05:42",
                "13.05.2025 09:05:42",
                "13.05.2025 09:05:42",
                "14.05.2025 07:17:42",
                "15.05.2025 06:50:42",
                "15.05.2025 08:50:42",
                "15.06.2025 06:05:42",
                "15.07.2025 09:20:42"));
    }

    @Test
    @Severity(CRITICAL)
    @Tag("Negative")
    @DisplayName("Required Message text Verification field test")
    @Description("The test clears the field and clicks the Save button. Then validates the message that the field is required.")
    void required() {
        MainPages.click("DateTimeWithSeconds required");
        MainPages.FirstLevelMenu.click("List");
        var list = $box.findListWidgetByTitle("List title");
        List<String> listRows = list.getNoFocusValues("custom Field");
        var customField = list.findRowSegmentByValue("custom Field", listRows.get(0)).dateTimeWithSeconds();
        var row = list.findRowSegmentByValue("custom Field", listRows.get(0));
        customField.clearIcon();
        Optional<MenuRow> menuRow = row.findMenuRow();
        assertThat(menuRow).isPresent();
        menuRow.get().clickOption("Save");
        assertThat(customField.getRequiredMessage()).isEqualTo(Constants.RequiredMessage);
    }
}
