package application.Samples.List;

import application.config.BaseTestForSamples;
import core.MainPages;
import core.widget.TestingTools.Constants;
import core.widget.list.actions.MenuRow;
import core.widget.modal.Popup;
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
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("List. Checking the basic functions for the MultiValue in the widget List")
@Epic("Samples")
@Tag("Samples")
@Tag("List")
//@Disabled("В самплах использован другой тип поля")
public class MultiValueOnListTest extends BaseTestForSamples {

    @Test
    @Tag("Positive")
    @DisplayName("Test for getting the Placeholder value")
    @Description("The test gets the value from the placeholder attribute and returns it in String format")
    void placeholder() {
        MainPages.click("MultiValue placeholder");
        MainPages.FirstLevelMenu.click("List");
        var list = $box.findListWidgetByTitle("List title");
        List<String> listRows = list.getListRows();
        var customField = list.findRowSegmentByValue("Custom Field", listRows.get(0)).multiValue();
        assertThat(customField.getPlaceholder()).isEqualTo("Placeholder text");
    }

    @Test
    @Tag("Positive")
    @DisplayName("A test to get the field color value in Hex format")
    @Description("The test gets the value from the style attribute in RGB format, and then converts it to Hex format")
    void color() {
        MainPages.click("MultiValue color");
        MainPages.FirstLevelMenu.click("List");
        var list = $box.findListWidgetByTitle("List title");
        List<String> listRows = list.getListRows();
        var customField = list.findRowSegmentByValue("Custom Field", listRows.get(0)).multiValue();
        assertThat(customField.getHexColor()).isEqualTo("#EDA6A6");
    }

    @Test
    @Tag("Positive")
    @DisplayName("A test to check the field for \"Read-only\"")
    @Description("The test checks for the disabled attribute.")
    void readonly() {
        MainPages.click("MultiValue readonly");
        MainPages.FirstLevelMenu.click("List");
        var list = $box.findListWidgetByTitle("List title");
        List<String> listRows = list.getListRows();
        var customField = list.findRowSegmentByValue("Custom Field", listRows.get(0)).multiValue();
        customField.openInlineRedactor();
        assertThat(customField.getReadOnly()).isTrue();
    }

    @Test
    @Severity(CRITICAL)
    @Tag("Positive")
    @DisplayName("A test for checking a value in a field")
    @Description("The test gets the value in the field, and then checks the value in the field with what should be.")
    void read() {
        MainPages.click("MultiValue basic");
        MainPages.FirstLevelMenu.click("List");
        var list = $box.findListWidgetByTitle("List title");
        List<String> listRows = list.getNoFocusValues("Custom Field");
        var customField = list.findRowSegmentByValue("Custom Field", listRows.get(0)).multiValue();
        assertThat(customField.compareRows("Abs data,...")).isTrue();
    }

    @Test
    @Severity(CRITICAL)
    @Tag("Positive")
    @DisplayName("A test for setting a value in a field")
    @Description("The test sets the value in the field, and then checks the value in the field with what should be set.")
    void edit() {
        MainPages.click("MultiValue basic");
        MainPages.FirstLevelMenu.click("List");
        var list = $box.findListWidgetByTitle("List title");

        List<String> listRows = list.getNoFocusValues("Custom Field");
        var customField = list.findRowSegmentByValue("Custom Field", listRows.get(0)).multiValue();
        customField.openInlineRedactor();
        customField.clear();
        customField.openModalWindow();
        Optional<Popup> popup = customField.findPopup();
        assertThat(popup).isPresent();
        var popupAssocListPopup = popup.get().multiValueModal("myEntityAssocListPopup title");
        popupAssocListPopup.setMultiValue("Custom Field", List.of("Information7 data", "Information9 data", "Abs data"), true);
        popupAssocListPopup.close();
        assertThat(customField.getValue()).isEqualTo(List.of("Information9 data", "Information7 data", "Abs data"));
    }

    @Test
    @Severity(MINOR)
    @Tag("Negative")
    @DisplayName("Filtering test")
    @Description("Filtering by the specified column.")
    void filtration() {
        MainPages.click("MultiValue filtration");
        MainPages.FirstLevelMenu.click("List");
        var list = $box.findListWidgetByTitle("List title");
        List<String> listRows = list.getNoFocusValues("Custom Field");
        var customField = list.findRowSegmentByValue("Custom Field", listRows.get(0)).multiValue();
        assertThatThrownBy(customField::setFiltration).isInstanceOf(UnsupportedOperationException.class);
    }


    @Test
    @Severity(CRITICAL)
    @Tag("Negative")
    @DisplayName("Business Exception Validation Test")
    @Description("The test sets the value in the field. After approval, the popup window, the title, the text in it, and the buttons are validated.")
    void businessException() {
        MainPages.click("MultiValue validation business exception");
        MainPages.FirstLevelMenu.click("List");
        var list = $box.findListWidgetByTitle("List title");
        List<String> listRows = list.getNoFocusValues("Custom Field");
        var customField = list.findRowSegmentByValue("Custom Field", listRows.get(0)).multiValue();
        customField.openInlineRedactor();
        customField.openModalWindow();
        Optional<Popup> popupMultiValue = customField.findPopup();
        assertThat(popupMultiValue).isPresent();
        var popupAssocListPopup = popupMultiValue.get().multiValueModal("myEntityAssocListPopup title");
        popupAssocListPopup.clear();
        var popup = $box.findPopup("error");
        assertThat(popup).isPresent();
        assertThat(popup.get().errorPopup().getTitle()).isEqualTo(Constants.ErrorPopup.ErrorTitle);
        assertThat(popup.get().errorPopup().getMessage()).isEqualTo(Constants.OnlyLetters);
        popup.get().errorPopup().close();
        popupAssocListPopup.close();
    }

    @Test
    @Severity(CRITICAL)
    @Tag("Negative")
    @DisplayName("Run-time exception validation test")
    @Description("The test sets the value in the field. After approval, the popup window, the title, the text in it, and the buttons are validated.")
    void runtimeException() {
        MainPages.click("MultiValue validation runtime exception");
        MainPages.FirstLevelMenu.click("List");
        var list = $box.findListWidgetByTitle("List title");
        List<String> listRows = list.getNoFocusValues("Custom Field");
        var customField = list.findRowSegmentByValue("Custom Field", listRows.get(0)).multiValue();
        customField.openInlineRedactor();
        customField.openModalWindow();
        Optional<Popup> popupMultiValue = customField.findPopup();
        assertThat(popupMultiValue).isPresent();
        var popupAssocListPopup = popupMultiValue.get().multiValueModal("myEntityAssocListPopup title");
        assertThat(customField.findPopup()).isPresent();
        popupAssocListPopup.setValueAll();
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
        MainPages.click("MultiValue validation confirm");
        MainPages.FirstLevelMenu.click("List");
        var list = $box.findListWidgetByTitle("List title");
        List<String> listRows = list.getNoFocusValues("Custom Field");
        var row = list.findRowSegmentByValue("Custom Field", listRows.get(0));
        row.multiValue().openInlineRedactor();
        row.multiValue().openModalWindow();
        Optional<Popup> popupMultiValue = row.multiValue().findPopup();
        assertThat(popupMultiValue).isPresent();
        var popupAssocListPopup = popupMultiValue.get().multiValueModal("myEntityAssocListPopup title");
        popupAssocListPopup.setValueAll();
        popupAssocListPopup.close();
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
        MainPages.click("MultiValue validation field level annotation");
        MainPages.FirstLevelMenu.click("List");
        var list = $box.findListWidgetByTitle("List title");
        List<String> listRows = list.getNoFocusValues("Custom Field");
        var row = list.findRowSegmentByValue("Custom Field", listRows.get(0));
        row.multiValue().openInlineRedactor();
        Optional<MenuRow> menuRow = row.findMenuRow();
        assertThat(menuRow).isPresent();
        menuRow.get().clickOption("Save");
        assertThat(row.multiValue().getRequiredMessage()).isEqualTo(Constants.MessageAboutError);
    }

    @Test
    @Severity(CRITICAL)
    @Tag("Negative")
    @DisplayName("Required Message validation test for multiple fields")
    @Description("The test sets a value with the wrong data type in several fields for different widgets. After approval, it checks the text under the field, which informs about the correctness of the type of data entered")
    void fieldLevelValidation() {
        MainPages.click("MultiValue validation field level dynamic");
        MainPages.FirstLevelMenu.click("List");
        var list = $box.findListWidgetByTitle("List title");
        List<String> listRows = list.getNoFocusValues("Custom Field");
        var row = list.findRowSegmentByValue("Custom Field", listRows.get(0));
        List<String> listRows2 = list.getNoFocusValues("Custom Field Additional");
        var row2 = list.findRowSegmentByValue("Custom Field Additional", listRows2.get(0));
        row.multiValue().openInlineRedactor();
        Optional<MenuRow> menuRow = row.findMenuRow();
        assertThat(menuRow).isPresent();
        menuRow.get().clickOption("Save");
        assertThat(row.multiValue().getRequiredMessage()).isEqualTo(Constants.RequiredField);
        assertThat(row2.multiValue().getRequiredMessage()).isEqualTo(Constants.RequiredField);
    }
    

    @Test
    @Severity(CRITICAL)
    @Tag("Negative")
    @DisplayName("Required Message text Verification field test")
   @Description("The test clears the field and clicks the Save button. Then validates the message that the field is required.")
    void required() {
        MainPages.click("MultiValue required");
        MainPages.FirstLevelMenu.click("List");
        var list = $box.findListWidgetByTitle("List title");
        List<String> listRows = list.getNoFocusValues("Custom Field");
        var row = list.findRowSegmentByValue("Custom Field", listRows.get(0));
        row.multiValue().openInlineRedactor();
        row.multiValue().clear();
        Optional<MenuRow> menuRow = row.findMenuRow();
        assertThat(menuRow).isPresent();
        menuRow.get().clickOption("Save");
        assertThat(row.multiValue().getRequiredMessage()).isEqualTo(Constants.RequiredMessage);
    }

    @Test
    @Severity(CRITICAL)
    @Tag("Negative")
    @DisplayName("Required Message text Verification field test")
    @Description("The test opens a modal window, clears the field, closes the window, and then checks the message under the field.")
    void required_2() {
        MainPages.click("MultiValue required");
        MainPages.FirstLevelMenu.click("List");
        var list = $box.findListWidgetByTitle("List title");
        List<String> listRows = list.getNoFocusValues("Custom Field");
        var row = list.findRowSegmentByValue("Custom Field", listRows.get(0));
        row.multiValue().openInlineRedactor();
        row.multiValue().openModalWindow();
        Optional<Popup> popupMultiValue = row.multiValue().findPopup();
        assertThat(popupMultiValue).isPresent();
        var popupAssocListPopup = popupMultiValue.get().multiValueModal("myEntityAssocListPopup title");
        assertThat(popupMultiValue).isPresent();
        popupAssocListPopup.clear();
        popupAssocListPopup.close();
        Optional<MenuRow> menuRow = row.findMenuRow();
        assertThat(menuRow).isPresent();
        menuRow.get().clickOption("Save");
        assertThat(row.multiValue().getRequiredMessage()).isEqualTo(Constants.RequiredMessage);
    }
}
