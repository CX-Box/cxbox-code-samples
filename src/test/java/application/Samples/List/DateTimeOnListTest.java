package application.Samples.List;

import application.common.Text;
import application.config.BaseTestForSamples;
import core.MainPages;
import core.widget.TestingTools.Constants;
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

@DisplayName("List. Checking the basic functions for the DateTime in the widget List")
@Epic("Samples")
@Tag("Samples")
@Tag("List")
public class DateTimeOnListTest extends BaseTestForSamples {

    @Test
    @Tag("Positive")
    @DisplayName("Test for getting the Placeholder value")
    @Description("The test gets the value from the placeholder attribute and returns it in String format")
    void placeholder() {
        MainPages.click("Datetime placeholder");
        MainPages.FirstLevelMenu.click("List");
        var list = $box.findListWidgetByTitle("List title");
        List<String> listRows = list.getListRows();
        var customField = list.findRowSegmentByValue("custom Field", listRows.get(0)).dateTime();
        assertThat(customField.getPlaceholder()).isEqualTo("29.05.2023 11:25");
    }

    @Test
    @Tag("Positive")
    @DisplayName("A test to get the field color value in Hex format")
    @Description("The test gets the value from the style attribute in RGB format, and then converts it to Hex format")
    void color() {
        MainPages.click("Datetime color");
        MainPages.FirstLevelMenu.click("List");
        var list = $box.findListWidgetByTitle("List title");
        List<String> listRows = list.getListRows();
        var customField = list.findRowSegmentByValue("custom Field", listRows.get(0)).dateTime();
        assertThat(customField.getHexColor()).isEqualTo("#EDA6A6");
    }

    @Test
    @Tag("Positive")
    @DisplayName("A test to check the field for \"Read-only\"")
    @Description("The test checks for the disabled attribute.")
    void readonly() {
        MainPages.click("Datetime readonly");
        MainPages.FirstLevelMenu.click("List");
        var list = $box.findListWidgetByTitle("List title");
        List<String> listRows = list.getListRows();
        var customField = list.findRowSegmentByValue("custom Field", listRows.get(0)).dateTime();
        assertThat(customField.getReadOnly()).isTrue();
    }

    @Test
    @Severity(CRITICAL)
    @Tag("Positive")
    @DisplayName("A test for setting a value in a field")
    @Description("The test sets the value in the field, and then checks the value in the field with what should be set.")
    void edit() {
        MainPages.click("Datetime basic");
        MainPages.FirstLevelMenu.click("List");
        var list = $box.findListWidgetByTitle("List title");
        List<String> listRows = list.getNoFocusValues("custom Field");
        var customField = list.findRowSegmentByValue("custom Field", listRows.get(0)).dateTime();
        LocalDateTime dateTime = LocalDateTime.of(220, 10, 10, 10, 10);
        customField.setValue(dateTime);
        assertThat(customField.getValue()).isEqualTo(dateTime);
    }

    @Test
    @Severity(MINOR)
    @Tag("Negative")
    @DisplayName("Filtering test")
    @Description("Filtering by the specified column.")
    void filtration() {
        MainPages.click("Datetime filtration");
        MainPages.FirstLevelMenu.click("List");
        var list = $box.findListWidgetByTitle("List title");
        LocalDateTime dateTime = LocalDateTime.of(2025, 5, 1, 23, 59);
        list.findFilterColumn("custom Field").dateTimeFilter().setFilter(dateTime);
        assertThat(list.getNoFocusValues("custom Field")).isEqualTo(List.of("15.05.2023 08:50",
                "15.05.2024 05:05"));
    }

    @Test
    @Tag("Positive")
    @DisplayName("The DrillDown test")
    @Description("Checking the url before the transition and after the transition/click on a special element")
    void drillDown() {
        MainPages.click("Datetime drilldown");
        MainPages.FirstLevelMenu.click("List");
        var list = $box.findListWidgetByTitle("List title");
        List<String> listRows = list.getListRows();
        var customField = list.findRowSegmentByValue("custom Field", listRows.get(0)).dateTime();
        assertThat(customField.drillDown()).isTrue();
    }

    @Test
    @Severity(CRITICAL)
    @Tag("Negative")
    @DisplayName("Business Exception Validation Test")
    @Description("The test sets the value in the field. After approval, the popup window, the title, the text in it, and the buttons are validated.")
    void businessException() {
        MainPages.click("Datetime validation business exception");
        MainPages.FirstLevelMenu.click("List");
        var list = $box.findListWidgetByTitle("List title");
        List<String> listRows = list.getListRows();
        var customField = list.findRowSegmentByValue("custom Field", listRows.get(0)).dateTime();
        LocalDateTime dateTime = LocalDateTime.of(1999, 4, 7, 17, 35);
        customField.setValue(dateTime);
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
        MainPages.click("Datetime validation runtime exception");
        MainPages.FirstLevelMenu.click("List");
        var list = $box.findListWidgetByTitle("List title");
        List<String> listRows = list.getListRows();
        var customField = list.findRowSegmentByValue("custom Field", listRows.get(0)).dateTime();
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
        MainPages.click("Datetime validation confirm");
        MainPages.FirstLevelMenu.click("List");
        var list = $box.findListWidgetByTitle("List title");
        List<String> listRows = list.getListRows();
        var row = list.findRowSegmentByValue("custom Field", listRows.get(0));
        LocalDateTime dateTime = LocalDateTime.of(1999, 4, 7, 17, 35);
        row.dateTime().setValue(dateTime);
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
    @DisplayName("Required Message validation test for one field")
    @Description("The test sets the value with the wrong data type in the field. After approval, it checks the text under the field, which informs about the correctness of the type of data entered.")
    void fieldLevelValidationAnnotation() {
        MainPages.click("Datetime validation field level annotation");
        MainPages.FirstLevelMenu.click("List");
        var list = $box.findListWidgetByTitle("List title");
        List<String> listRows = list.getListRows();
        var row = list.findRowSegmentByValue("Custom Field", listRows.get(0));
        LocalDateTime dateTime = LocalDateTime.of(1999, 4, 7, 17, 35);
        row.dateTime().setValue(dateTime);
        Optional<MenuRow> menuRow = row.findMenuRow();
        assertThat(menuRow).isPresent();
        menuRow.get().clickOption("Save");
        assertThat(row.dateTime().getRequiredMessage()).isEqualTo(Constants.MoreThatCurrentDate);
    }

    @Test
    @Severity(CRITICAL)
    @Tag("Negative")
    @DisplayName("Required Message validation test for multiple fields")
    @Description("The test sets a value with the wrong data type in several fields for different widgets. After approval, it checks the text under the field, which informs about the correctness of the type of data entered")
    void fieldLevelValidation() {
        MainPages.click("Datetime validation field level dynamic");
        MainPages.FirstLevelMenu.click("List");
        var list = $box.findListWidgetByTitle("List title");
        List<String> listRows = list.getNoFocusValues("Custom Field");
        LocalDateTime dateTime = LocalDateTime.of(1999, 4, 7, 17, 35);
        var row = list.findRowSegmentByValue("Custom Field", listRows.get(0));
        row.dateTime().setValue(dateTime);
        List<String> listRows2 = list.getNoFocusValues("Custom Field Additional");
        var row2 = list.findRowSegmentByValue("Custom Field Additional", listRows2.get(0));
        row2.dateTime().setValue(dateTime);
        Optional<MenuRow> menuRow = row.findMenuRow();
        assertThat(menuRow).isPresent();
        menuRow.get().clickOption("Save");
        assertThat(row.dateTime().getRequiredMessage()).isEqualTo(Text.textMoreThatCurrentDate("customField"));
        assertThat(row2.dateTime().getRequiredMessage()).isEqualTo(Text.textMoreThatCurrentDate("customFieldAdditional"));
    }


    @Test
    @Severity(MINOR)
    @Tag("Negative")
    @DisplayName("Sorting test")
    @Description("Sorting by the specified column.")
    void sorting() {
        MainPages.click("Datetime sorting");
        MainPages.FirstLevelMenu.click("List");
        var list = $box.findListWidgetByTitle("List title");
        assertThat(list.getNoFocusValues("custom Field"))
                .isEqualTo(List.of("15.06.2025 06:05",
                        "15.05.2023 08:50",
                        "15.05.2024 05:05",
                        "15.05.2025 09:05",
                        "14.05.2025 06:17",
                        "15.05.2025 06:50",
                        "15.05.2025 09:20",
                        "15.05.2025 08:53",
                        "15.05.2025 08:50"));
        list.setSorting("custom Field");
        assertThat(list.getNoFocusValues("custom Field"))
                .isEqualTo(List.of("15.06.2025 06:05",
                        "15.05.2025 09:20",
                        "15.05.2025 09:05",
                        "15.05.2025 08:53",
                        "15.05.2025 08:50",
                        "15.05.2025 06:50",
                        "14.05.2025 06:17",
                        "15.05.2024 05:05",
                        "15.05.2023 08:50"));

        list.setSorting("custom Field");
        assertThat(list.getNoFocusValues("custom Field"))
                .isEqualTo(List.of("15.05.2023 08:50",
                        "15.05.2024 05:05",
                        "14.05.2025 06:17",
                        "15.05.2025 06:50",
                        "15.05.2025 08:50",
                        "15.05.2025 08:53",
                        "15.05.2025 09:05",
                        "15.05.2025 09:20",
                        "15.06.2025 06:05"));
    }

    @Test
    @Severity(CRITICAL)
    @Tag("Negative")
    @DisplayName("Required Message text Verification field test")
    @Description("The test clears the field and clicks the Save button. Then validates the message that the field is required.")
    void required() {
        MainPages.click("Datetime required");
        MainPages.FirstLevelMenu.click("List");
        var list = $box.findListWidgetByTitle("List title");
        List<String> listRows = list.getListRows();
        var customField = list.findRowSegmentByValue("custom Field", listRows.get(0)).dateTime();
        var row = list.findRowSegmentByValue("custom Field", listRows.get(0));
        customField.clearIcon();
        Optional<MenuRow> menuRow = row.findMenuRow();
        assertThat(menuRow).isPresent();
        menuRow.get().clickOption("Save");
        assertThat(customField.getRequiredMessage()).isEqualTo(Constants.RequiredMessage);
    }
}
