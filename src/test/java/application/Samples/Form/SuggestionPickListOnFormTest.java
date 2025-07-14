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
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;


import static io.qameta.allure.SeverityLevel.CRITICAL;
import static io.qameta.allure.SeverityLevel.MINOR;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("Form. Checking the basic functions for the Suggestion PickList in the widget Form")
@Epic("application/Samples")
@Tag("application/Samples")
@Tag("Form")
public class SuggestionPickListOnFormTest extends BaseTestForSamples {

    @Test
    @Tag("Positive")
    @DisplayName("Test for getting the Placeholder value")
    @Description("The test gets the value from the placeholder attribute and returns it in String format")
    void placeholder() {
        MainPages.click("SuggestionPicklist placeholder");
        MainPages.FirstLevelMenu.click("Form");
        FormWidget form = $box.findFormWidgetByTitle("Form Widget with suggestionPickList placeholder");
        var customField = form.suggestionPickList("customField");
        assertThat(customField.getPlaceholder()).isEqualTo("Placeholder text");
    }


    @Test
    @Severity(CRITICAL)
    @Tag("Positive")
    @DisplayName("A test for setting a value in a field")
    @Description("The test sets the value in the field via Popup using a unique id, and then checks the value in the field with what needs to be set")
    void edit() {
        MainPages.click("SuggestionPicklist basic");
        MainPages.SecondLevelMenu.click("Form");
        FormWidget form = $box.findFormWidgetByTitle("Form Widget with suggestionPickList basic");
        var customField = form.suggestionPickList("customField");
        customField.setValue("Test data8");
        customField.getValue();
        System.out.println(customField.getValue());
        assertThat(customField.getValue()).isEqualTo("Test data8");
    }

    @Test
    @Severity(MINOR)
    @Tag("Negative")
    @DisplayName("Filtering test")
    @Description("Filtering is not available for the Form widget")
    void filtration() {
        MainPages.click("SuggestionPicklist filtration");
        MainPages.FirstLevelMenu.click("Form");
        FormWidget form = $box.findFormWidgetByTitle("Form");
        var customField = form.suggestionPickList("customField");
        assertThatThrownBy(customField::setFiltration).isInstanceOf(UnsupportedOperationException.class);
    }


    @Test
    @Tag("Positive")
    @DisplayName("The DrillDown test")
    @Description("Checking the url before the transition and after the transition/click on a special element")
    void drillDown() {
        MainPages.click("SuggestionPicklist drilldown");
        MainPages.FirstLevelMenu.click("Form");
        FormWidget form = $box.findFormWidgetByTitle("Form Widget with suggestionPickList drilldown");
        var customField = form.suggestionPickList("customField");
        assertThatThrownBy(customField::drillDown).isInstanceOf(UnsupportedOperationException.class);
    }


    @Test
    @Severity(CRITICAL)
    @Tag("Negative")
    @DisplayName("Business Exception Validation Test")
    @Description("The test sets the value in the field. After approval, the popup window, the title, the text in it, and the buttons are validated")
    void businessException() {
        MainPages.click("SuggestionPicklist validation business exception");
        FormWidget form = $box.findFormWidgetByTitle("Form");
        var customField = form.suggestionPickList("customField");
        customField.setValue("Test data9");
        form.clickButton("save");
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
    @Description("The test sets the value in the field. After approval, the popup window, the title, the text in it, and the buttons are validated")
    void runtimeException() {
        MainPages.click("SuggestionPicklist validation runtime exception");
        FormWidget form = $box.findFormWidgetByTitle("Form");
        var customField = form.suggestionPickList("customField");
        customField.setValue("Test data9");
        form.clickButton("save");
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
    @Description("The test sets the value in the field. After approval, by clicking on the save button, the popup window, the title, the text in it, and the buttons are validated")
    void confirm() {
        MainPages.click("SuggestionPicklist validation confirm");
        FormWidget form = $box.findFormWidgetByTitle("Form");
        var customField = form.suggestionPickList("customField");
        customField.setValue("Test data9");
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
    @DisplayName("Required Message validation test for multiple fields")
    @Description("The test sets a value with the wrong data type in several fields for different widgets. After approval, it checks the text under the field, which informs about the correctness of the type of data entered")
    void fieldLevelValidation() {
        MainPages.click("SuggestionPicklist validation field level dynamic");
        FormWidget form = $box.findFormWidgetByTitle("Form");
        var customField = form.suggestionPickList("customField");
        var customField2 = form.suggestionPickList("customFieldAdditional");
        customField.setValue("Test data9");
        customField2.setValue("Test data10");
        form.clickButton("save");
        assertThat(customField.getRequiredMessage()).isEqualTo("The field 'customField' can contain only letters.");
        assertThat(customField2.getRequiredMessage()).isEqualTo("The field 'customFieldAdditional' can contain only letters.");
    }

    @Test
    @Severity(MINOR)
    @Tag("Negative")
    @DisplayName("Sorting test")
    @Description("Sorting is not available for the Form widget")
    void sorting() {
        MainPages.click("SuggestionPicklist sorting");
        MainPages.FirstLevelMenu.click("Form");
        FormWidget form = $box.findFormWidgetByTitle("Form");
        var customField = form.suggestionPickList("customField");
        assertThatThrownBy(customField::setSorting).isInstanceOf(UnsupportedOperationException.class);
    }

    @Test
    @Severity(CRITICAL)
    @Tag("Negative")
    @DisplayName("Required Message text Verification field test")
    @Description("The test clears the field and clicks the Save button. Then validates the message that the field is required")
    void required() {
        MainPages.click("SuggestionPicklist required");
        MainPages.FirstLevelMenu.click("Form");
        FormWidget form = $box.findFormWidgetByTitle("Form");
        var customField = form.suggestionPickList("customField");
        customField.clear();
        form.clickButton("save");
        assertThat(customField.getRequiredMessage()).isEqualTo(Constants.RequiredMessage);
    }

    @Test
    @Tag("Positive")
    @DisplayName("A test to check the field for \"Read-only\"")
    @Description("The test checks for the disabled attribute")
    void readonly() {
        MainPages.click("SuggestionPicklist readonly");
        MainPages.FirstLevelMenu.click("Form");
        FormWidget form = $box.findFormWidgetByTitle("Form");
        var customField = form.suggestionPickList("customField");
        assertThat(customField.getReadOnly()).isTrue();
    }

}
