package application.Samples.Form;

import application.config.BaseTestForSamples;
import core.MainPages;
import core.widget.TestingTools.Constants;
import core.widget.form.FormWidget;
import core.widget.modal.confirm.constantsConfirm;
import core.widget.modal.error.constantsError;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Severity;
import org.apache.commons.lang3.tuple.Pair;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static io.qameta.allure.SeverityLevel.CRITICAL;
import static io.qameta.allure.SeverityLevel.MINOR;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("Form. Checking the basic functions for the MultiValue in the widget Form")
@Epic("Samples")
@Tag("Samples")
@Tag("Form") 

public class MultiValueOnFormTest extends BaseTestForSamples {

    @Test
    @Tag("Positive")
    @DisplayName("Test for getting the Placeholder value")
    @Description("The test gets the value from the placeholder attribute and returns it in String format")
    void placeholder() {
        MainPages.click("MultiValue placeholder");
        MainPages.FirstLevelMenu.click("Form");
        FormWidget form = $box.findFormWidgetByTitle("Form title");
        var customField = form.multiValue("Custom Field");
        assertThat(customField.getPlaceholder()).isEqualTo("Placeholder text");
    }

    @Test
    @Tag("Positive")
    @DisplayName("A test to get the field color value in Hex format")
    @Description("The test gets the value from the style attribute in RGB format, and then converts it to Hex format")
    void color() {
        MainPages.click("MultiValue color");
        MainPages.FirstLevelMenu.click("Form");
        FormWidget form = $box.findFormWidgetByTitle("Form title");
        var customField = form.multiValue("Custom Field");
        assertThat(customField.getHexColor()).isNull();
    }


    @Test
    @Severity(CRITICAL)
    @Tag("Positive")
    @DisplayName("A test for setting a value in a field")
    @Description("The test sets the value in the field, and then checks the value in the field with what should be set.")
    void edit() {
        MainPages.click("MultiValue basic");
        MainPages.FirstLevelMenu.click("Form");
        FormWidget form = $box.findFormWidgetByTitle("Form title");
        var customField = form.multiValue("Custom Field");
        customField.clear();
        customField.openModalWindow();
        var popupAssocListPopup = customField.findPopup().get().multiValueModal("myEntityAssocListPopup title");
        assertThat(customField.findPopup()).isPresent();
        popupAssocListPopup.setMultiValue("Custom Field", List.of("Information7 data", "Information9 data", "Abs data"), true);
        popupAssocListPopup.close();
        assertThat(customField.getValue()).isEqualTo(List.of("Abs data", "Information7 data", "Information9 data"));
    }

    @Test
    @Severity(MINOR)
    @Tag("Negative")
    @DisplayName("Filtering test")
    @Description("Filtering is not available for the Form widget")
    void filtration() {
        MainPages.click("MultiValue filtration");
        MainPages.FirstLevelMenu.click("Form");
        FormWidget form = $box.findFormWidgetByTitle("Form title");
        var customField = form.multiValue("Custom Field");
        assertThatThrownBy(customField::setFiltration).isInstanceOf(UnsupportedOperationException.class);
    }


    @Test
    @Tag("Positive")
    @DisplayName("The DrillDown test")
    @Description("Checking the url before the transition and after the transition/click on a special element")
    void drillDown() {
        MainPages.click("MultiValue drilldown");
        MainPages.FirstLevelMenu.click("Form");
        FormWidget form = $box.findFormWidgetByTitle("Form title");
        var customField = form.multiValue("Custom Field");
        assertThatThrownBy(customField::drillDown).isInstanceOf(UnsupportedOperationException.class);
    }

    @Test
    @Severity(CRITICAL)
    @Tag("Negative")
    @DisplayName("Business Exception Validation Test")
    @Description("The test sets the value in the field. After approval, the popup window, the title, the text in it, and the buttons are validated.")
    void businessException() {
        MainPages.click("MultiValue validation business exception");
        MainPages.FirstLevelMenu.click("Form");
        FormWidget form = $box.findFormWidgetByTitle("Form title");
        var customField = form.multiValue("Custom Field");
        customField.openModalWindow();
        var popupAssocListPopup = customField.findPopup().get().multiValueModal("myEntityAssocListPopup title");
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
        MainPages.FirstLevelMenu.click("Form");
        FormWidget form = $box.findFormWidgetByTitle("Form title");
        var customField = form.multiValue("Custom Field");
        customField.openModalWindow();
        var popupAssocListPopup = customField.findPopup().get().multiValueModal("myEntityAssocListPopup title");
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
        MainPages.FirstLevelMenu.click("Form");
        FormWidget form = $box.findFormWidgetByTitle("Form title");
        var customField = form.multiValue("Custom Field");
        customField.openModalWindow();
        var popupAssocListPopup = customField.findPopup().get().multiValueModal("myEntityAssocListPopup title");
        assertThat(customField.findPopup()).isPresent();
        popupAssocListPopup.setValueAll();
        popupAssocListPopup.close();
        form.clickButton("save");
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
        MainPages.FirstLevelMenu.click("Form");
        FormWidget form = $box.findFormWidgetByTitle("Form title");
        var customField = form.multiValue("Custom Field");
        form.clickButton("save");
        assertThat(customField.getRequiredMessage()).isEqualTo(Constants.MessageAboutError);
    }

    @Test
    @Severity(CRITICAL)
    @Tag("Negative")
    @DisplayName("Required Message validation test for multiple fields")
    @Description("The test sets a value with the wrong data type in several fields for different widgets. After approval, it checks the text under the field, which informs about the correctness of the type of data entered")
    void fieldLevelValidation() {
        MainPages.click("MultiValue validation field level dynamic");
        MainPages.FirstLevelMenu.click("Form");
        FormWidget form = $box.findFormWidgetByTitle("Form title");
        var customField = form.multiValue("Custom Field");
        var customField2 = form.multiValue("Custom Field Additional");
        form.clickButton("save");
        assertThat(customField.getRequiredMessage()).isEqualTo(Constants.RequiredField);
        assertThat(customField2.getRequiredMessage()).isEqualTo(Constants.RequiredField);
    }

    @Test
    @Severity(MINOR)
    @Tag("Negative")
    @DisplayName("Sorting test")
    @Description("Sorting is not available for the Form widget")
    void sorting() {
        MainPages.click("MultiValue sorting");
        MainPages.FirstLevelMenu.click("Form");
        FormWidget form = $box.findFormWidgetByTitle("Form title");
        var customField = form.multiValue("Custom Field");
        assertThatThrownBy(customField::setSorting).isInstanceOf(UnsupportedOperationException.class);
    }

    @Test
    @Severity(CRITICAL)
    @Tag("Negative")
    @DisplayName("Required Message text Verification field test")
    @Description("The test clears the field and clicks the Save button. Then validates the message that the field is required.")
    void required() {
        MainPages.click("MultiValue required");
        MainPages.FirstLevelMenu.click("Form");
        FormWidget form = $box.findFormWidgetByTitle("Form title");
        var customField = form.multiValue("Custom Field");
        customField.clear();
        form.clickButton("save");
        assertThat(customField.getRequiredMessage()).isEqualTo(Constants.RequiredMessage);
    }

    @Test
    @Severity(CRITICAL)
    @Tag("Negative")
    @DisplayName("Required Message text Verification field test")
    @Description("The test opens a modal window, clears the field, closes the window, and then checks the message under the field.")
    void required_2() {
        MainPages.click("MultiValue required");
        MainPages.FirstLevelMenu.click("Form");
        FormWidget form = $box.findFormWidgetByTitle("Form title");
        var customField = form.multiValue("Custom Field");
        customField.openModalWindow();
        var popupAssocListPopup = customField.findPopup().get().multiValueModal("myEntityAssocListPopup title");
        assertThat(customField.findPopup()).isPresent();
        popupAssocListPopup.clear();
        popupAssocListPopup.close();
        form.clickButton("save");
        assertThat(customField.getRequiredMessage()).isEqualTo(Constants.RequiredMessage);
    }


    @Test
    @Severity(CRITICAL)
    @Tag("Negative")
    @DisplayName("Test to set all values in the field")
    @Description("The test sets all the values in the field, then checks the list with the expected value.")
    void test_set_all() {
        MainPages.click("MultiValue basic");
        MainPages.FirstLevelMenu.click("Form");
        FormWidget form = $box.findFormWidgetByTitle("Form title");
        var customField = form.multiValue("Custom Field");
        customField.clear();
        customField.openModalWindow();
        var popupAssocListPopup = customField.findPopup().get().multiValueModal("myEntityAssocListPopup title");
        assertThat(customField.findPopup()).isPresent();
        popupAssocListPopup.setValueAll();
        popupAssocListPopup.close();
        assertThat(customField.getValue()).isEqualTo(List.of("Abs data",
                "Test data",
                "Information data",
                "Information2 data",
                "Information3 data",
                "Information4 data",
                "Information5 data",
                "Information6 data",
                "Information7 data",
                "Information8 data",
                "Information9 data",
                "Information10 data"));
    }

    @Test
    @Severity(CRITICAL)
    @Tag("Negative")
    @DisplayName("A test for setting multiple values in a field")
    @Description("The test sets several values in the field, then checks the list with the expected value.")
    void test_set() {
        MainPages.click("MultiValue basic");
        MainPages.FirstLevelMenu.click("Form");
        FormWidget form = $box.findFormWidgetByTitle("Form title");
        var customField = form.multiValue("Custom Field");
        customField.clear();
        customField.openModalWindow();
        var popupAssocListPopup = customField.findPopup().get().multiValueModal("myEntityAssocListPopup title");
        assertThat(customField.findPopup()).isPresent();
        popupAssocListPopup.setValues("Custom Field", List.of("Information7 data", "Information9 data", "Abs data"), true);
        assertThat(customField.getValue()).isEqualTo(List.of("Abs data", "Information7 data", "Information9 data"));
    }

    @Test@Severity(CRITICAL)
    @Tag("Negative")
    @DisplayName("A test for checking values by column heading in a modal window")
    @Description("The test calls a modal window, after which the method returns Status-Value pairs depending on the column header.")
    void test_status() {
        MainPages.click("MultiValue basic");
        MainPages.FirstLevelMenu.click("Form");
        FormWidget form = $box.findFormWidgetByTitle("Form title");
        var customField = form.multiValue("Custom Field");
        customField.clear();
        customField.openModalWindow();
        var popupAssocListPopup = customField.findPopup().get().multiValueModal("myEntityAssocListPopup title");
        assertThat(customField.findPopup()).isPresent();
        popupAssocListPopup.setValues("Custom Field", List.of("Information7 data", "Information9 data", "Abs data"), true);
        customField.openModalWindow();
        var popupAssocListPopup2 = customField.findPopup().get().multiValueModal("myEntityAssocListPopup title");
        List<Pair<Boolean, String>> expectedPairs = new ArrayList<>();
        expectedPairs.add(Pair.of(false, "Information10 data"));
        expectedPairs.add(Pair.of(true, "Information9 data"));
        expectedPairs.add(Pair.of(false, "Information8 data"));
        expectedPairs.add(Pair.of(true, "Information7 data"));
        expectedPairs.add(Pair.of(false, "Information6 data"));
        expectedPairs.add(Pair.of(false, "Information5 data"));
        expectedPairs.add(Pair.of(false, "Information4 data"));
        expectedPairs.add(Pair.of(false, "Information3 data"));
        expectedPairs.add(Pair.of(false, "Information2 data"));
        expectedPairs.add(Pair.of(false, "Information data"));
        expectedPairs.add(Pair.of(false, "Test data"));
        expectedPairs.add(Pair.of(true, "Abs data"));
        assertThat(popupAssocListPopup2.getStatusValue("Custom Field")).isEqualTo(expectedPairs);
    }
    @Test
    @Severity(CRITICAL)
    @Tag("Negative")
    @DisplayName("A test for setting a single value in a field")
    @Description("The test sets one value in the field, then checks the list with the expected value.")
    void test_once() {
        MainPages.click("MultiValue basic");
        MainPages.FirstLevelMenu.click("Form");
        FormWidget form = $box.findFormWidgetByTitle("Form title");
        var customField = form.multiValue("Custom Field");
        customField.clear();
        customField.openModalWindow();
        var popupAssocListPopup = customField.findPopup().get().multiValueModal("myEntityAssocListPopup title");
        assertThat(customField.findPopup()).isPresent();
        popupAssocListPopup.setValue("Abs data", true);
        assertThat(customField.getValue()).isEqualTo(List.of("Abs data"));
    }
}
