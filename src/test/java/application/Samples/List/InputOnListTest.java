package application.Samples.List;

import application.common.Text;
import application.config.BaseTestForSamples;
import core.MainPages;
import core.widget.TestingTools.Constants;
import core.widget.list.actions.MenuRow;
import core.widget.modal.confirm.constantsConfirm;
import core.widget.modal.error.constantsError;
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

@DisplayName("List. Checking the basic functions for the Input in the widget List")
@Epic("Samples")
@Tag("Samples")
@Tag("List")
public class InputOnListTest extends BaseTestForSamples {

    @Test
    @Tag("Positive")
    @DisplayName("Test for getting the Placeholder value")
    @Description("The test gets the value from the placeholder attribute and returns it in String format")
    void placeholder() {
        MainPages.click("Input placeholder");
        MainPages.FirstLevelMenu.click("List");
        var list = $box.findListWidgetByTitle("List");
        List<String> listRows = list.getNoFocusValues("customField");
        var customField = list.findRowSegmentByValue("customField", listRows.get(0)).input();
        assertThat(customField.getPlaceholder()).isEqualTo("Placeholder text");
    }

    @Test
    @Tag("Positive")
    @DisplayName("A test to get the field color value in Hex format")
    @Description("The test gets the value from the style attribute in RGB format, and then converts it to Hex format")
    void color() {
        MainPages.click("Input color");
        MainPages.FirstLevelMenu.click("List");
        var list = $box.findListWidgetByTitle("List");
        List<String> listRows = list.getNoFocusValues("customField");
        var customField = list.findRowSegmentByValue("customField", listRows.get(0)).input();
        assertThat(customField.getHexColor()).isEqualTo("#EDA6A6");
    }

    @Test
    @Tag("Positive")
    @DisplayName("A test to check the field for \"Read-only\"")
    @Description("The test checks for the disabled attribute.")
    void readonly() {
        MainPages.click("Input readonly");
        MainPages.FirstLevelMenu.click("List");
        var list = $box.findListWidgetByTitle("List");
        List<String> listRows = list.getNoFocusValues("customField");
        var customField = list.findRowSegmentByValue("customField", listRows.get(0)).input();
        assertThat(customField.getReadOnly()).isTrue();
    }

    @Test
    @Severity(CRITICAL)
    @Tag("Positive")
    @DisplayName("A test for checking a value in a field")
    @Description("The test gets the value in the field, and then checks the value in the field with what should be.")
    void read() {
        MainPages.click("Input basic");
        MainPages.FirstLevelMenu.click("List");
        var list = $box.findListWidgetByTitle("List");
        List<String> listRows = list.getNoFocusValues("customField");
        var customField = list.findRowSegmentByValue("customField", listRows.get(0)).input();
        assertThat(customField.compareRows("test data")).isTrue();
    }

    @Test
    @Severity(CRITICAL)
    @Tag("Positive")
    @DisplayName("A test for setting a value in a field")
    @Description("The test sets the value in the field, and then checks the value in the field with what should be set.")
    void edit() {
        MainPages.click("Input basic");
        MainPages.FirstLevelMenu.click("List");
        var list = $box.findListWidgetByTitle("List");
        List<String> listRows = list.getNoFocusValues("customField");
        var customField = list.findRowSegmentByValue("customField", listRows.get(0)).input();
        customField.setValue("57");
        assertThat(customField.getValue()).isEqualTo("57");
    }

    @Test
    @Severity(MINOR)
    @Tag("Negative")
    @DisplayName("Filtering test")
    @Description("Filtering by the specified column.")
    void filtration() {
        MainPages.click("Input filtration");
        MainPages.FirstLevelMenu.click("List");
        var list = $box.findListWidgetByTitle("List");
        list.findFilterColumn("customField").inputFilter().setFilter("Test data2");
        assertThat(list.getNoFocusValues("customField")).isEqualTo(List.of("Test data2"));
    }

    @Test
    @Tag("Positive")
    @DisplayName("The DrillDown test")
    @Description("Checking the url before the transition and after the transition/click on a special element")
    void drillDown() {
        MainPages.click("Input drilldown");
        MainPages.FirstLevelMenu.click("List");
        var list = $box.findListWidgetByTitle("List");
        List<String> listRows = list.getNoFocusValues("customField");
        var customField = list.findRowSegmentByValue("customField", listRows.get(0)).input();
        assertThat(customField.drillDown()).isTrue();
    }

    @Test
    @Severity(CRITICAL)
    @Tag("Negative")
    @DisplayName("Business Exception Validation Test")
    @Description("The test sets the value in the field. After approval, the popup window, the title, the text in it, and the buttons are validated.")
    void businessException() {
        MainPages.click("Input validation business exception");
        MainPages.FirstLevelMenu.click("List");
        var list = $box.findListWidgetByTitle("List");
        List<String> listRows = list.getNoFocusValues("customField");
        var customField = list.findRowSegmentByValue("customField", listRows.get(0)).input();
        customField.setValue("5700");
        var popup = $box.findPopup("error");
        assertThat(popup).isPresent();
        assertThat(popup.get().errorPopup().getTitle()).isEqualTo(Constants.ErrorPopup.ErrorTitle);
        assertThat(popup.get().errorPopup().getMessage()).isEqualTo(Constants.OnlyLetters);
        popup.get().errorPopup().close();
    }

    @Test
    @Severity(CRITICAL)
    @Tag("Negative")
    @DisplayName("Run-time exception validation test")
    @Description("The test sets the value in the field. After approval, the popup window, the title, the text in it, and the buttons are validated.")
    void runtimeException() {
        MainPages.click("Input validation runtime exception");
        MainPages.FirstLevelMenu.click("List");
        var list = $box.findListWidgetByTitle("List");
        List<String> listRows = list.getNoFocusValues("customField");
        var customField = list.findRowSegmentByValue("customField", listRows.get(0)).input();
        customField.setValue("1234");
        var popup = $box.findPopup("error");
        assertThat(popup).isPresent();
        assertThat(popup.get().errorPopup().getTitle()).isEqualTo(constantsError.Title);
        assertThat(popup.get().errorPopup().getMessage()).isEqualTo(Constants.SystemError);
        popup.get().errorPopup().close();
    }

    @Test
    @Severity(CRITICAL)
    @Tag("Positive")
    @DisplayName("Confirmation Popup Validation Test")
    @Description("The test sets the value in the field. After approval, by clicking on the save button, the popup window, the title, the text in it, and the buttons are validated.")
    void confirm() {
        MainPages.click("Input validation confirm");
        MainPages.FirstLevelMenu.click("List");
        var list = $box.findListWidgetByTitle("List");
        List<String> listRows = list.getNoFocusValues("customField");
        var row = list.findRowSegmentByValue("customField", listRows.get(0));
        row.input().setValue("5700");
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
        MainPages.click("Input validation field level annotation");
        MainPages.FirstLevelMenu.click("List");
        var list = $box.findListWidgetByTitle("List title");
        List<String> listRows = list.getNoFocusValues("Custom Field ");
        var row = list.findRowSegmentByValue("Custom Field ", listRows.get(0));
        row.input().setValue("123"); // На семплах лишний пробел
        Optional<MenuRow> menuRow = row.findMenuRow();
        assertThat(menuRow).isPresent();
        menuRow.get().clickOption("save");
        assertThat(row.input().getRequiredMessage()).isEqualTo(Constants.OnlyLetters);
    }

    @Test
    @Severity(CRITICAL)
    @Tag("Negative")
    @DisplayName("Required Message validation test for multiple fields")
    @Description("The test sets a value with the wrong data type in several fields for different widgets. After approval, it checks the text under the field, which informs about the correctness of the type of data entered")
    void fieldLevelValidation() {
        MainPages.click("Input validation field level dynamic");
        MainPages.FirstLevelMenu.click("List");
        var list = $box.findListWidgetByTitle("List title");
        List<String> listRows = list.getNoFocusValues("Custom Field");
        var row = list.findRowSegmentByValue("Custom Field", listRows.get(0));
        List<String> listRows2 = list.getNoFocusValues("Custom Field Additional");
        var row2 = list.findRowSegmentByValue("Custom Field Additional", listRows2.get(0));
        row.input().setValue("123");
        row2.input().setValue("123");
        Optional<MenuRow> menuRow = row.findMenuRow();
        assertThat(menuRow).isPresent();
        menuRow.get().clickOption("save");
        assertThat(row.input().getRequiredMessage()).isEqualTo(Text.textOnlyLetters("customField"));
        assertThat(row2.input().getRequiredMessage()).isEqualTo(Text.textOnlyLetters("customFieldAdditional"));
    }

    @Test
    @Severity(MINOR)
    @Tag("Negative")
    @DisplayName("Sorting test")
    @Description("Sorting by the specified column.")
    void sorting() {
        MainPages.click("Input sorting");
        MainPages.FirstLevelMenu.click("List");
        var list = $box.findListWidgetByTitle("List");
        assertThat(list.getNoFocusValues("customField")).isEqualTo(List.of("A2 row", "A1 row", "Acb row", "Abc row", "2 row", "1 row"));
        list.setSorting("customField");
        assertThat(list.getNoFocusValues("customField")).isEqualTo(List.of("Acb row", "Abc row", "A2 row", "A1 row", "2 row", "1 row"));
        list.setSorting("customField");
        assertThat(list.getNoFocusValues("customField")).isEqualTo(List.of("1 row", "2 row", "A1 row", "A2 row", "Abc row", "Acb row"));
    }

    @Test
    void getTypeColumn() {
        MainPages.click("Input filtration");
        MainPages.FirstLevelMenu.click("List");
        var list = $box.findListWidgetByTitle("List");
        assertThat(list.getTypeColumn("customField")).isEqualTo("input");
    }

    @Test
    void checkFilterOrSort() {
        MainPages.click("Input filtration");
        MainPages.FirstLevelMenu.click("List");
        var list = $box.findListWidgetByTitle("List");
        assertThat(list.checkFilterColumn("customField")).isTrue();
        assertThat(list.checkSorting("brand")).isFalse();
    }
}
