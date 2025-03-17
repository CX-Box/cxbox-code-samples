package application.Samples.Form;

import core.ConfigTest.BaseTestForSamples;
import core.MainPages;
import core.widget.TestingTools.Constants;
import core.widget.form.FormWidget;
import core.widget.modal.Popup;
import core.widget.modal.confirm.constantsConfirm;
import core.widget.modal.error.constantsError;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Severity;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.selenide.videorecorder.junit5.VideoRecorderExtension;

import java.util.List;
import java.util.Optional;

import static io.qameta.allure.SeverityLevel.CRITICAL;
import static io.qameta.allure.SeverityLevel.MINOR;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("Form. Checking the basic functions for the PickList in the widget Form")
@Epic("application/Samples")
@Tag("application/Samples")
@Tag("Form") 
@ExtendWith(VideoRecorderExtension.class)
public class PickListOnFormTest extends BaseTestForSamples {

    @Test
    @Tag("Positive")
    @DisplayName("Test for getting the Placeholder value")
    @Description("The test gets the value from the placeholder attribute and returns it in String format")
    void placeholder() {
        MainPages.click("Picklist placeholder");
        MainPages.FirstLevelMenu.click("Form");
        FormWidget form = page.findFormWidgetByTitle("Form title");
        var customField = form.pickList("Custom Field");
        assertThat(customField.getPlaceholder()).isEqualTo("Placeholder text");
    }

    @Test
    @Tag("Positive")
    @DisplayName("A test to get the field color value in Hex format")
    @Description("The test gets the value from the style attribute in RGB format, and then converts it to Hex format")
    void color() {
        MainPages.click("Picklist color");
        MainPages.FirstLevelMenu.click("Form");
        FormWidget form = page.findFormWidgetByTitle("Form title");
        var customField = form.pickList("Custom Field");
        assertThat(customField.getHexColor()).isNull();
    }


    @Test
    @Severity(CRITICAL)
    @Tag("Positive")
    @DisplayName("A test for setting a value in a field")
    @Description("The test sets the value in the field via Popup using a unique id, and then checks the value in the field with what needs to be set")
    void edit() {
        MainPages.click("Picklist basic");
        MainPages.FirstLevelMenu.click("Form");
        FormWidget form = page.findFormWidgetByTitle("Form title");
        var customField = form.pickList("Custom Field");
        customField.openModalWindow();
        Optional<Popup> popup = customField.findPopup();
        assertThat(popup).isPresent();
        var popupPickList = popup.get().pickListPopupForSetValue("myEntityPickListPopup Title");
        popupPickList.setValue("1101088");
        assertThat(customField.getValue()).isEqualTo("New data");
    }

    @Test
    @Severity(MINOR)
    @Tag("Positive")
    @DisplayName("The test for getting column headings")
    @Description("The test calls Popup, the method returns a list with column headings")
    void getColumnName() {
        MainPages.click("Picklist basic");
        MainPages.FirstLevelMenu.click("Form");
        FormWidget form = page.findFormWidgetByTitle("Form title");
        var customField = form.pickList("Custom Field");
        customField.openModalWindow();
        Optional<Popup> fieldPopup = customField.findPopup();
        assertThat(fieldPopup).isPresent();
        var popup = fieldPopup.get().pickListPopupForSetValue("myEntityPickListPopup Title");
        assertThat(popup.getColumnName()).isEqualTo(List.of("Custom Field", "id"));
        popup.close();
    }

    @Test
    @Severity(CRITICAL)
    @Tag("Positive")
    @DisplayName("A test for setting a value in a field")
    @Description("The test sets the value in the field via Popup using the name, and then checks the value in the field with what should be set")
    void edit_2() {
        MainPages.click("Picklist basic");
        MainPages.FirstLevelMenu.click("Form");
        FormWidget form = page.findFormWidgetByTitle("Form title");
        var customField = form.pickList("Custom Field");
        customField.openModalWindow();
        Optional<Popup> popup = customField.findPopup();
        assertThat(popup).isPresent();
        var popupPickList = popup.get().pickListPopupForSetValue("myEntityPickListPopup Title");
        popupPickList.setValue("New data");
        assertThat(customField.getValue()).isEqualTo("New data");
    }

    @Test
    @Severity(MINOR)
    @Tag("Negative")
    @DisplayName("Filtering test")
    @Description("Filtering is not available for the Form widget")
    void filtration() {
        MainPages.click("Picklist filtration");
        MainPages.FirstLevelMenu.click("Form");
        FormWidget form = page.findFormWidgetByTitle("Form title");
        var customField = form.pickList("Custom Field");
        assertThatThrownBy(customField::setFiltration).isInstanceOf(UnsupportedOperationException.class);
    }


    @Test
    @Tag("Positive")
    @DisplayName("The DrillDown test")
    @Description("Checking the url before the transition and after the transition/click on a special element")
    void drillDown() {
        MainPages.click("Picklist drilldown");
        MainPages.FirstLevelMenu.click("Form");
        FormWidget form = page.findFormWidgetByTitle("Form title");
        var customField = form.pickList("Custom Field");
        assertThatThrownBy(customField::drillDown).isInstanceOf(UnsupportedOperationException.class);
    }

    @Test
    @Severity(CRITICAL)
    @Tag("Negative")
    @DisplayName("Business Exception Validation Test")
    @Description("The test sets the value in the field. After approval, the popup window, the title, the text in it, and the buttons are validated")
    void businessException() {
        MainPages.click("Picklist validation business exception");
        MainPages.FirstLevelMenu.click("Form");
        FormWidget form = page.findFormWidgetByTitle("Form title");
        var customField = form.pickList("Custom Field");
        customField.openModalWindow();
        Optional<Popup> fieldPopup = customField.findPopup();
        assertThat(fieldPopup).isPresent();
        var popupPickList = fieldPopup.get().pickListPopupForSetValue("myEntityPickListPopup Title");
        popupPickList.setValue("1234");
        var popup = page.findPopup("error");
        assertThat(popup).isPresent();
        assertThat(popup.get().errorPopup().getTitle()).isEqualTo(Constants.ErrorPopup.ErrorTitle);
        assertThat(popup.get().errorPopup().getMessage()).isEqualTo(Constants.OnlyLetters);
        popup.get().errorPopup().close();
    }

    @Test
    @Severity(CRITICAL)
    @Tag("Negative")
    @DisplayName("Run-time exception validation test")
    @Description("The test sets the value in the field. After approval, the popup window, the title, the text in it, and the buttons are validated")
    void runtimeException() {
        MainPages.click("Picklist runtime");
        MainPages.FirstLevelMenu.click("Form");
        FormWidget form = page.findFormWidgetByTitle("Form title");
        var customField = form.pickList("Custom Field");
        customField.openModalWindow();
        Optional<Popup> fieldPopup = customField.findPopup();
        assertThat(fieldPopup).isPresent();
        var popupPickList = fieldPopup.get().pickListPopupForSetValue("myEntityPickListPopup Title");
        popupPickList.setValue("Test data");
        var popup = page.findPopup("error");
        assertThat(popup).isPresent();
        assertThat(popup.get().errorPopup().getTitle()).isEqualTo(constantsError.Title);
        assertThat(popup.get().errorPopup().getMessage()).isEqualTo(Constants.SystemError);
        popup.get().errorPopup().close();
    }

    @Test
    @Severity(CRITICAL)
    @Tag("Positive")
    @DisplayName("Confirmation Popup Validation Test")
    @Description("The test sets the value in the field. After approval, by clicking on the save button, the popup window, the title, the text in it, and the buttons are validated")
    void confirm() {
        MainPages.click("Picklist validation confirm");
        MainPages.FirstLevelMenu.click("Form");
        FormWidget form = page.findFormWidgetByTitle("Form title");
        var customField = form.pickList("Custom Field");
        customField.openModalWindow();
        Optional<Popup> fieldPopup = customField.findPopup();
        assertThat(fieldPopup).isPresent();
        var popupPickList = fieldPopup.get().pickListPopupForSetValue("myEntityPickListPopup Title");
        popupPickList.setValue("Test data");
        form.clickButton("save");
        var popup = page.findPopup("confirm");
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
        MainPages.click("Picklist validation field level dynamic");
        MainPages.FirstLevelMenu.click("Form");
        FormWidget form = page.findFormWidgetByTitle("Form title");
        var customField = form.pickList("Custom Field");
        var customField2 = form.pickList("Custom Field Additional");
        form.clickButton("save");
        assertThat(customField.getRequiredMessage()).isEqualTo("The field 'customField' can contain only letters."); //Don't work, data-test-field-type=inline picklist at this version
        assertThat(customField2.getRequiredMessage()).isEqualTo("The field 'customFieldAdditional' can contain only letters.");
    }

    @Test
    @Severity(MINOR)
    @Tag("Negative")
    @DisplayName("Sorting test")
    @Description("Sorting is not available for the Form widget")
    void sorting() {
        MainPages.click("Picklist sorting");
        MainPages.FirstLevelMenu.click("Form");
        FormWidget form = page.findFormWidgetByTitle("Form title");
        var customField = form.pickList("Custom Field");
        assertThatThrownBy(customField::setSorting).isInstanceOf(UnsupportedOperationException.class);
    }

    @Test
    @Severity(CRITICAL)
    @Tag("Negative")
    @DisplayName("Required Message text Verification field test")
    @Description("The test clears the field and clicks the Save button. Then validates the message that the field is required")
    void required() {
        MainPages.click("Picklist required");
        MainPages.FirstLevelMenu.click("Form");
        FormWidget form = page.findFormWidgetByTitle("Form title");
        var customField = form.pickList("Custom Field");
        customField.clear();
        form.clickButton("save");
        assertThat(customField.getRequiredMessage()).isEqualTo(Constants.RequiredMessage);
    }
}