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

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static io.qameta.allure.SeverityLevel.CRITICAL;
import static io.qameta.allure.SeverityLevel.MINOR;
import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("List. Checking the basic functions for the Date in the widget List")
@Epic("Samples")
@Tag("Samples")
@Tag("List")
public class DateOnListTest extends BaseTestForSamples {

    @Test
    @Tag("Positive")
    @DisplayName("Test for getting the Placeholder value")
    @Description("The test gets the value from the placeholder attribute and returns it in String format")
    void placeholder() {
        MainPages.click("Date placeholder");
        MainPages.FirstLevelMenu.click("List");
        var list = $box.findListWidgetByTitle("List title");
        List<String> listRows = list.getNoFocusValues("custom Field");
        var customField = list.findRowSegmentByValue("custom Field", listRows.get(0)).date();
        assertThat(customField.getPlaceholder()).isEqualTo("29.05.2023");
    }

    @Test
    @Tag("Positive")
    @DisplayName("A test to get the field color value in Hex format")
    @Description("The test gets the value from the style attribute in RGB format, and then converts it to Hex format")
    void color() {
        MainPages.click("Date color");
        MainPages.FirstLevelMenu.click("List");
        var list = $box.findListWidgetByTitle("List title");
        List<String> listRows = list.getNoFocusValues("custom Field");
        var customField = list.findRowSegmentByValue("custom Field", listRows.get(0)).date();
        assertThat(customField.getHexColor()).isEqualTo("#EDA6A6");
    }

    @Test
    @Tag("Positive")
    @DisplayName("A test to check the field for \"Read-only\"")
    @Description("The test checks for the disabled attribute.")
    void readonly() {
        MainPages.click("Date readonly");
        MainPages.FirstLevelMenu.click("List");
        var list = $box.findListWidgetByTitle("List title");
        List<String> listRows = list.getNoFocusValues("custom Field");
        var customField = list.findRowSegmentByValue("custom Field", listRows.get(0)).date();
        assertThat(customField.getReadOnly()).isTrue();
    }

    @Test
    @Severity(CRITICAL)
    @Tag("Positive")
    @DisplayName("A test for setting a value in a field")
    @Description("The test sets the value in the field, and then checks the value in the field with what should be set.")
    void edit() {
        MainPages.click("Date basic");
        MainPages.FirstLevelMenu.click("List");
        var list = $box.findListWidgetByTitle("List title");
        LocalDate date = LocalDate.of(2020, 10, 11);
        List<String> listRows = list.getNoFocusValues("custom Field");
        var customField = list.findRowSegmentByValue("custom Field", listRows.get(0)).date();
        customField.setValue(date);
        assertThat(customField.getValue()).isEqualTo(date);
    }

    @Test
    @Severity(MINOR)
    @Tag("Negative")
    @DisplayName("Filtering test")
    @Description("Filtering by the specified column.")
    void filtration() {
        MainPages.click("Date filtration");
        MainPages.FirstLevelMenu.click("List");
        var list = $box.findListWidgetByTitle("List title");
        LocalDate date = LocalDate.of(2021, 3, 7);
        LocalDate date2 = LocalDate.of(2023, 3, 7);
        list.findFilterColumn("custom Field").dateFilter().setFilter(date, date2);
        assertThat(list.getNoFocusValues("custom Field").get(0)).isEqualTo("13.05.2022");
    }

    @Test
    @Tag("Positive")
    @DisplayName("The DrillDown test")
    @Description("Checking the url before the transition and after the transition/click on a special element")
    void drillDown() {
        MainPages.click("Date drilldown");
        MainPages.FirstLevelMenu.click("List");
        var list = $box.findListWidgetByTitle("List title");
        List<String> listRows = list.getNoFocusValues("custom Field");
        var customField = list.findRowSegmentByValue("custom Field", listRows.get(0)).date();
        assertThat(customField.drillDown()).isTrue();
    }

    @Test
    @Severity(CRITICAL)
    @Tag("Negative")
    @DisplayName("Business Exception Validation Test")
    @Description("The test sets the value in the field. After approval, the popup window, the title, the text in it, and the buttons are validated.")
    void businessException() {
        MainPages.click("Date validation business exception");
        MainPages.FirstLevelMenu.click("List");
        var list = $box.findListWidgetByTitle("List title");
        LocalDate date = LocalDate.of(2023, 3, 7);
        List<String> listRows = list.getNoFocusValues("custom Field");
        var customField = list.findRowSegmentByValue("custom Field", listRows.get(0)).date();
        customField.setValue(date);
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
        MainPages.click("Date validation runtime exception");
        MainPages.FirstLevelMenu.click("List");
        var list = $box.findListWidgetByTitle("List title");
        List<String> listRows = list.getNoFocusValues("custom Field");
        var row = list.findRowSegmentByValue("custom Field", listRows.get(0));
        row.date().clearIcon();
        Optional<MenuRow> menuRow = row.findMenuRow();
        assertThat(menuRow).isPresent();
        menuRow.get().clickOption("Save");
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
        MainPages.click("Date confirm");
        MainPages.FirstLevelMenu.click("List");
        var list = $box.findListWidgetByTitle("List title");
        LocalDate date = LocalDate.of(2023, 3, 7);
        List<String> listRows = list.getNoFocusValues("custom Field");
        var row = list.findRowSegmentByValue("custom Field", listRows.get(0));
        row.date().setValue(date);
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
        MainPages.click("Date validation field level annotation");
        MainPages.FirstLevelMenu.click("List");
        var list = $box.findListWidgetByTitle("List title");
        List<String> listRows = list.getNoFocusValues("Custom Field");
        LocalDate date = LocalDate.of(2023, 3, 7);
        var row = list.findRowSegmentByValue("Custom Field", listRows.get(0));
        row.date().setValue(date);
        Optional<MenuRow> menuRow = row.findMenuRow();
        assertThat(menuRow).isPresent();
        menuRow.get().clickOption("Save");
        assertThat(row.date().getRequiredMessage()).isEqualTo(Constants.MoreThatCurrentDate);
    }

    @Test
    @Severity(CRITICAL)
    @Tag("Negative")
    @DisplayName("Required Message validation test for multiple fields")
    @Description("The test sets a value with the wrong data type in several fields for different widgets. After approval, it checks the text under the field, which informs about the correctness of the type of data entered")
    void fieldLevelValidation() {
        MainPages.click("Date validation field level dynamic");
        MainPages.FirstLevelMenu.click("List");
        var list = $box.findListWidgetByTitle("List title");
        List<String> listRows = list.getNoFocusValues("Custom Field");
        LocalDate date = LocalDate.of(2023, 3, 7);
        var row = list.findRowSegmentByValue("Custom Field", listRows.get(0));
        row.date().setValue(date);
        List<String> listRows2 = list.getNoFocusValues("Custom Field Additional");
        var row2 = list.findRowSegmentByValue("Custom Field Additional", listRows2.get(0));
        row2.date().setValue(date);
        Optional<MenuRow> menuRow = row.findMenuRow();
        assertThat(menuRow).isPresent();
        menuRow.get().clickOption("Save");
        assertThat(row.date().getRequiredMessage()).isEqualTo(Text.textMoreThatCurrentDate("customField"));
        assertThat(row2.date().getRequiredMessage()).isEqualTo(Text.textMoreThatCurrentDate("customFieldAdditional"));
    }

    @Test
    @Severity(MINOR)
    @Tag("Negative")
    @DisplayName("Sorting test")
    @Description("Sorting by the specified column.")
    void sorting() {
        MainPages.click("Date sorting");
        MainPages.FirstLevelMenu.click("List");
        var list = $box.findListWidgetByTitle("List title");
        assertThat(list.getNoFocusValues("custom Field")).isEqualTo(List.of("15.07.2025",
                "15.06.2025",
                "15.05.2023",
                "15.05.2024",
                "13.05.2025",
                "14.05.2023",
                "13.05.2022",
                "15.04.2025",
                "15.05.2025"));

        list.setSorting("custom Field");
        assertThat(list.getNoFocusValues("custom Field")).isEqualTo(List.of(
                "15.07.2025",
                "15.06.2025",
                "15.05.2025",
                "13.05.2025",
                "15.04.2025",
                "15.05.2024",
                "15.05.2023",
                "14.05.2023",
                "13.05.2022"));

        list.setSorting("custom Field");
        assertThat(list.getNoFocusValues("custom Field")).isEqualTo(List.of(
                "13.05.2022",
                "14.05.2023",
                "15.05.2023",
                "15.05.2024",
                "15.04.2025",
                "13.05.2025",
                "15.05.2025",
                "15.06.2025",
                "15.07.2025"));
    }

    @Test
    @Severity(CRITICAL)
    @Tag("Negative")
    @DisplayName("Required Message text Verification field test")
   @Description("The test clears the field and clicks the Save button. Then validates the message that the field is required.")
    void required() {
        MainPages.click("Date required");
        MainPages.FirstLevelMenu.click("List");
        var list = $box.findListWidgetByTitle("List title");
        List<String> listRows = list.getNoFocusValues("custom Field");
        var customField = list.findRowSegmentByValue("custom Field", listRows.get(0)).date();
        var row = list.findRowSegmentByValue("custom Field", listRows.get(0));
        customField.clearIcon();
        Optional<MenuRow> menuRow = row.findMenuRow();
        assertThat(menuRow).isPresent();
        menuRow.get().clickOption("save");
        assertThat(customField.getRequiredMessage()).isEqualTo(Constants.RequiredMessage);
    }
}
