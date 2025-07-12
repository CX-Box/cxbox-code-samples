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
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import static io.qameta.allure.SeverityLevel.CRITICAL;
import static io.qameta.allure.SeverityLevel.MINOR;
import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("List. Checking the basic functions for the Percent in the widget List")
@Epic("Samples")
@Tag("Samples")
@Tag("List")
public class PercentOnListTest extends BaseTestForSamples {

    @Test
    @Tag("Positive")
    @DisplayName("Test for getting the Placeholder value")
    @Description("The test gets the value from the placeholder attribute and returns it in String format")
    void placeholder() {
        MainPages.click("Percent placeholder");
        MainPages.FirstLevelMenu.click("List");
        var list = $box.findListWidgetByTitle("List title");
        var customField = list.findRowSegmentByValue("custom Field", "").percent();
        assertThat(customField.getPlaceholder()).isEqualTo("17");
    }

    @Test
    @Tag("Positive")
    @DisplayName("A test to get the field color value in Hex format")
    @Description("The test gets the value from the style attribute in RGB format, and then converts it to Hex format")
    void color() {
        MainPages.click("Percent color");
        MainPages.FirstLevelMenu.click("List");
        var list = $box.findListWidgetByTitle("List title");
        List<String> values = list.getNoFocusValues("Custom Field");
        var customField = list.findRowSegmentByValue("Custom Field", values.get(0)).percent();
        assertThat(customField.getHexColor()).isEqualTo("#EDA6A6");
    }

    @Test
    @Tag("Positive")
    @DisplayName("A test to check the field for \"Read-only\"")
    @Description("The test checks for the disabled attribute.")
    void readonly() {
        MainPages.click("Percent readonly");
        MainPages.FirstLevelMenu.click("List");
        var list = $box.findListWidgetByTitle("List title");
        List<String> values = list.getNoFocusValues("custom Field");
        var customField = list.findRowSegmentByValue("custom Field", values.get(0)).percent();
        assertThat(customField.getReadOnly()).isTrue();
    }

    @Test
    @Severity(CRITICAL)
    @Tag("Positive")
    @DisplayName("A test for checking a value in a field")
    @Description("The test gets the value in the field, and then checks the value in the field with what should be.")
    @Disabled("Checked at filtration and sorting")
    void read() {
        MainPages.click("Percent basic");
        MainPages.FirstLevelMenu.click("List");
        var list = $box.findListWidgetByTitle("List title");
        List<String> listRows = list.getNoFocusValues("custom Field");
        var customField = list.findRowSegmentByValue("custom Field", listRows.get(0)).percent();
        assertThat(customField.compareRows("27 %")).isTrue();
    }

    @Test
    @Severity(CRITICAL)
    @Tag("Positive")
    @DisplayName("A test for setting a value in a field")
    @Description("The test sets the value in the field, and then checks the value in the field with what should be set.")
    void edit() {
        MainPages.click("Percent basic");
        MainPages.FirstLevelMenu.click("List");
        var list = $box.findListWidgetByTitle("List title");
        List<String> values = list.getNoFocusValues("custom Field");
        var customField = list.findRowSegmentByValue("custom Field", values.get(0)).percent();
        customField.setValue(57);
        assertThat(customField.getValue()).isEqualTo(57);
    }

    @Test
    @Severity(MINOR)
    @Tag("Negative")
    @DisplayName("Filtering test")
    @Description("Filtering by the specified column.")
    void filtration() {
        MainPages.click("Percent filtration");
        MainPages.FirstLevelMenu.click("List");
        var list = $box.findListWidgetByTitle("List title");
        list.findFilterColumn("custom Field").percentFilter().setFilter(13,14);
        assertThat(list.getNoFocusValues("custom Field")).isEqualTo(List.of("13 %"));
    }

    @Test
    @Tag("Positive")
    @DisplayName("The DrillDown test")
    @Description("Checking the url before the transition and after the transition/click on a special element")
    void drillDown() {
        MainPages.click("Percent drilldown");
        MainPages.FirstLevelMenu.click("List");
        var list = $box.findListWidgetByTitle("List title");
        List<String> values = list.getNoFocusValues("custom Field");
        var customField = list.findRowSegmentByValue("custom Field", values.get(0)).percent();
        assertThat(customField.drillDown()).isTrue();
    }

    @Test
    @Severity(CRITICAL)
    @Tag("Negative")
    @DisplayName("Business Exception Validation Test")
    @Description("The test sets the value in the field. After approval, the popup window, the title, the text in it, and the buttons are validated.")
    void businessException() {
        MainPages.click("Percent validation business exception");
        MainPages.FirstLevelMenu.click("List");
        var list = $box.findListWidgetByTitle("List title");

        List<String> values = list.getNoFocusValues("custom Field");

        var row = list.findRowSegmentByValue("custom Field", values.get(0));
        row.percent().setValue(3);
        Optional<MenuRow> menuRow = row.findMenuRow();
        assertThat(menuRow).isPresent();
        menuRow.get().clickOption("Save");
        var popup = $box.findPopup("error");
        assertThat(popup).isPresent();
        assertThat(popup.get().errorPopup().getTitle()).isEqualTo(Constants.ErrorPopup.ErrorTitle);
        assertThat(popup.get().errorPopup().getMessage()).isEqualTo(Constants.MoreThatPercent);
        popup.get().errorPopup().close();
    }

    @Test
    @Severity(CRITICAL)
    @Tag("Negative")
    @DisplayName("Run-time exception validation test")
    @Description("The test sets the value in the field. After approval, the popup window, the title, the text in it, and the buttons are validated.")
    void runtimeException() {
        MainPages.click("Percent validation runtime exception");
        MainPages.FirstLevelMenu.click("List");
        var list = $box.findListWidgetByTitle("List title");
        List<String> values = list.getNoFocusValues("custom Field");
        var row = list.findRowSegmentByValue("custom Field", values.get(0));
        row.percent().clear();
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
        MainPages.click("Percent validation confirm");
        MainPages.FirstLevelMenu.click("List");
        var list = $box.findListWidgetByTitle("List title");
        List<String> values = list.getNoFocusValues("custom Field");
        var row = list.findRowSegmentByValue("custom Field", values.get(0));
        row.percent().setValue(57);
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
        MainPages.click("Percent validation field level annotation");
        MainPages.FirstLevelMenu.click("List");
        var list = $box.findListWidgetByTitle("List title");
        List<String> values = list.getNoFocusValues("Custom Field");
        var row = list.findRowSegmentByValue("Custom Field", values.get(0));
        row.percent().setValue(3);
        Optional<MenuRow> menuRow = row.findMenuRow();
        assertThat(menuRow).isPresent();
        menuRow.get().clickOption("Save");
        assertThat(row.percent().getRequiredMessage()).isEqualTo(Text.textInvalidPercent("5%."));
    }

    @Test
    @Severity(CRITICAL)
    @Tag("Negative")
    @DisplayName("Required Message validation test for multiple fields")
    @Description("The test sets a value with the wrong data type in several fields for different widgets. After approval, it checks the text under the field, which informs about the correctness of the type of data entered")
    void fieldLevelValidation() {
        MainPages.click("Percent validation field level dynamic");
        MainPages.FirstLevelMenu.click("List");
        var list = $box.findListWidgetByTitle("List title");

        List<String> customField = list.getNoFocusValues("Custom Field");
        var row = list.findRowSegmentByValue("Custom Field", customField.get(0));
        row.percent().setValue(3);
        Optional<MenuRow> menuRow = row.findMenuRow();
        assertThat(menuRow).isPresent();
        menuRow.get().clickOption("Save");
        assertThat(row.percent().getRequiredMessage()).isEqualTo(Text.textInvalidPercent("5%"));

        List<String> customFieldAdditional = list.getNoFocusValues("Custom Field Additional");
        var row2 = list.findRowSegmentByValue("Custom Field Additional", customFieldAdditional.get(0));
        Optional<MenuRow> menuRow2 = row2.findMenuRow();
        assertThat(menuRow2).isPresent();
        menuRow2.get().clickOption("Save");
        row2.percent().setValue(3);
        assertThat(row2.percent().getRequiredMessage()).isEqualTo(Text.textInvalidPercent("5%"));
    }


    @Test
    @Severity(MINOR)
    @Tag("Negative")
    @DisplayName("Sorting test")
    @Description("Sorting by the specified column.")
    void sorting() {
        MainPages.click("Percent sorting");
        MainPages.FirstLevelMenu.click("List");
        var list = $box.findListWidgetByTitle("List title");
        List<String> list1 = list.getNoFocusValues("custom Field");
        assertThat(list1).isEqualTo(List.of("0 %", "11 %", "54 %", "76 %", "4 %", "27 %"));
        list.setSorting("custom Field");
        List<String> list2 = list.getNoFocusValues("custom Field");
        assertThat(list2).isNotEqualTo(list1);
    }


    @Test
    @Severity(CRITICAL)
    @Tag("Negative")
    @DisplayName("Required Message text Verification field test")
   @Description("The test clears the field and clicks the Save button. Then validates the message that the field is required.")
    void required() {
        MainPages.click("Percent required");
        MainPages.FirstLevelMenu.click("List");
        var list = $box.findListWidgetByTitle("List title");

        List<String> values = list.getNoFocusValues("custom Field");

        var row = list.findRowSegmentByValue("custom Field", values.get(0));
        row.percent().clear();
        Optional<MenuRow> menuRow = row.findMenuRow();
        assertThat(menuRow).isPresent();
        menuRow.get().clickOption("Save");
        assertThat(row.percent().getRequiredMessage()).isEqualTo(Constants.RequiredMessage);
    }

    @Test
    @Severity(CRITICAL)
    @Tag("Positive")
    @DisplayName("Тест на установку числа с дробной частью в поле")
    @Description("The test sets the value in the field, and then checks the value in the field with what should be set.")
    void digits() {
        BigDecimal number = new BigDecimal("123.12");

        MainPages.click("Percent digits");
        MainPages.FirstLevelMenu.click("List");
        var list = $box.findListWidgetByTitle("List title");
        List<String> values = list.getNoFocusValues("Custom Field");
        var customField = list.findRowSegmentByValue("Custom Field", values.get(0)).percentDigits();
        customField.setValue(number);
        assertThat(customField.getValue()).isEqualTo(number);
    }

    @Test
    @Tag("Positive")
    @DisplayName("Тест на автозаполнение после очистки")
    @Description("Тест удаляет значение, проверяя автозаполнение в чистом поле")
    void nullable() {
        MainPages.click("Percent nullable");
        MainPages.FirstLevelMenu.click("List");
        var list = $box.findListWidgetByTitle("List title");
        List<String> values = list.getNoFocusValues("Custom Field");
        var customField = list.findRowSegmentByValue("Custom Field", values.get(0)).percent();
        customField.setValue(123);
        assertThat(customField.getValue()).isEqualTo(123);
    }
}
