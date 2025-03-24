package application.Samples.Form;

import core.ConfigTest.BaseTestForSamples;
import core.MainPages;
import core.widget.TestingTools.Constants;
import core.widget.form.FormWidget;
import core.widget.modal.confirm.constantsConfirm;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Severity;
import org.apache.commons.lang3.tuple.Pair;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.selenide.videorecorder.junit5.VideoRecorderExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static io.qameta.allure.SeverityLevel.CRITICAL;
import static io.qameta.allure.SeverityLevel.MINOR;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("Form. Checking the basic functions for the MultipleSelect in the widget Form")
@Epic("application/Samples")
@Tag("application/Samples")
@Tag("Form") 
@ExtendWith(VideoRecorderExtension.class)
public class MultipleSelectOnFormTest extends BaseTestForSamples {

    @Test
    @Tag("Positive")
    @DisplayName("Test for getting the Placeholder value")
    @Description("The test gets the value from the placeholder attribute and returns it in String format")
    void placeholder() {
        MainPages.click("MultipleSelect placeholder");
        MainPages.FirstLevelMenu.click("Form");
        FormWidget form = page.findFormWidgetByTitle("Form title");
        var customField = form.multipleSelect("Custom Field");
        assertThat(customField.getPlaceholder()).isEqualTo("Placeholder text");
    }

    @Test
    @Tag("Positive")
    @DisplayName("A test to get the field color value in Hex format")
    @Description("The test gets the value from the style attribute in RGB format, and then converts it to Hex format")
    void color() {
        MainPages.click("MultipleSelect color");
        MainPages.FirstLevelMenu.click("Form");
        FormWidget form = page.findFormWidgetByTitle("Form title");
        var customField = form.multipleSelect("Custom Field");
        assertThat(customField.getHexColor()).isNull();
    }

    @Test
    @Tag("Positive")
    @DisplayName("A test to check the field for \"Read-only\"")
    @Description("The test checks for the disabled attribute")
    void readonly() {
        MainPages.click("MultipleSelect readonly");
        MainPages.FirstLevelMenu.click("Form");
        FormWidget form = page.findFormWidgetByTitle("Form title");
        var customField = form.multipleSelect("Custom Field");
        assertThat(customField.getReadOnly()).isTrue();

    }

    @Test
    @Severity(CRITICAL)
    @Tag("Positive")
    @DisplayName("A test for setting a value in a field")
    @Description("The test sets the value in the field, and then checks the value in the field with what should be set. Предварительной очистки поля нет")
    void edit() {
        MainPages.click("MultipleSelect basic");
        MainPages.FirstLevelMenu.click("Form");
        FormWidget form = page.findFormWidgetByTitle("Form title");
        var customField = form.multipleSelect("Custom Field");
        customField.addValue(Set.of("Middle"));
        customField.addValue(Set.of("Low"));
        form.clickButton("save");
        assertThat(customField.getValue()).isEqualTo(Set.of("Low", "Middle"));
    }

    @Test
    @Severity(MINOR)
    @Tag("Negative")
    @DisplayName("Filtering test")
    @Description("Filtering is not available for the Form widget")
    void filtration() {
        MainPages.click("MultipleSelect filtration");
        MainPages.FirstLevelMenu.click("Form");
        FormWidget form = page.findFormWidgetByTitle("Form title");
        var customField = form.multipleSelect("Custom Field");
        assertThatThrownBy(customField::setFiltration).isInstanceOf(UnsupportedOperationException.class);
    }

    @Test
    @Tag("Positive")
    @DisplayName("The DrillDown test")
    @Description("Checking the url before the transition and after the transition/click on a special element")
    void drillDown() {
        MainPages.click("MultipleSelect drilldown");
        MainPages.FirstLevelMenu.click("Form");
        FormWidget form = page.findFormWidgetByTitle("Form title");
        var customField = form.multipleSelect("Custom Field");
        assertThatThrownBy(customField::drillDown).isInstanceOf(UnsupportedOperationException.class);
    }

    @Test
    @Severity(CRITICAL)
    @Tag("Negative")
    @DisplayName("Business Exception Validation Test")
    @Description("The test sets the value in the field. After approval, the popup window, the title, the text in it, and the buttons are validated")
    void businessException() {
        MainPages.click("MultipleSelect business error");
        MainPages.FirstLevelMenu.click("Form");
        FormWidget form = page.findFormWidgetByTitle("Form title");
        var customField = form.multipleSelect("Custom Field");
        customField.addValue(Set.of("Middle"));
        var popup = page.findPopup("error");
        assertThat(popup).isPresent();
        assertThat(popup.get().errorPopup().getTitle()).isEqualTo(Constants.ErrorPopup.ErrorTitle);
        assertThat(popup.get().errorPopup().getMessage()).isEqualTo("The field  can contain 'High'");
        popup.get().errorPopup().close();
    }

    @Test
    @Severity(CRITICAL)
    @Tag("Negative")
    @DisplayName("Run-time exception validation test")
    @Description("The test sets the value in the field. After approval, the popup window, the title, the text in it, and the buttons are validated")
    void runtimeException() {
        MainPages.click("MultipleSelect runtime error");
        MainPages.FirstLevelMenu.click("Form");
        FormWidget form = page.findFormWidgetByTitle("Form title");
        var customField = form.multipleSelect("Custom Field");
        customField.addValue(Set.of("Middle"));
        var popup = page.findPopup("error");
        assertThat(popup).isPresent();
        assertThat(popup.get().errorPopup().getTitle()).isEqualTo(Constants.ErrorPopup.ErrorTitle);
        assertThat(popup.get().errorPopup().getMessage()).isEqualTo(Constants.SystemError);
        popup.get().errorPopup().close();
    }

    @Test
    @Severity(CRITICAL)
    @Tag("Positive")
    @DisplayName("Confirmation Popup Validation Test")
    @Description("The test sets the value in the field. After approval, by clicking on the save button, the popup window, the title, the text in it, and the buttons are validated")
    void confirm() {
        MainPages.click("MultipleSelect validation confirm");
        MainPages.FirstLevelMenu.click("Form");
        FormWidget form = page.findFormWidgetByTitle("Form title");
        var customField = form.multipleSelect("Custom Field");
        customField.addValue(Set.of("Middle"));
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
    @DisplayName("Required Message validation test for one field")
    @Description("The test sets the value with the wrong data type in the field. After approval, it checks the text under the field, which informs about the correctness of the type of data entered")
    void fieldLevelValidationAnnotation() {
        MainPages.click("MultipleSelect validation field level annotation");
        MainPages.FirstLevelMenu.click("Form");
        FormWidget form = page.findFormWidgetByTitle("Form title");
        var customField = form.multipleSelect("Custom Field");
        customField.clear();
        form.clickButton("save");
        assertThat(customField.getRequiredMessage()).isEqualTo(Constants.MessageAboutError);
    }

    @Test
    @Severity(CRITICAL)
    @Tag("Negative")
    @DisplayName("Required Message validation test for multiple fields")
    @Description("The test sets a value with the wrong data type in several fields for different widgets. After approval, it checks the text under the field, which informs about the correctness of the type of data entered")
    void fieldLevelValidation() {
        MainPages.click("MultipleSelect validation field level dynamic");
        MainPages.FirstLevelMenu.click("Form");
        FormWidget form = page.findFormWidgetByTitle("Form title");
        var customField = form.multipleSelect("Custom Field");
        var customField2 = form.multipleSelect("Custom Field Additional");
        form.clickButton("save");
        assertThat(customField.getRequiredMessage()).isEqualTo(Constants.MessageAboutError);
        assertThat(customField2.getRequiredMessage()).isEqualTo(Constants.MessageAboutError);
    }

    @Test
    @Severity(MINOR)
    @Tag("Negative")
    @DisplayName("Sorting test")
    @Description("Sorting is not available for the Form widget")
    void sorting() {
        MainPages.click("MultipleSelect sorting");
        MainPages.FirstLevelMenu.click("Form");
        FormWidget form = page.findFormWidgetByTitle("Form title");
        var customField = form.multipleSelect("Custom Field");
        assertThatThrownBy(customField::setSorting).isInstanceOf(UnsupportedOperationException.class);
    }

    @Test
    @Severity(CRITICAL)
    @Tag("Negative")
    @DisplayName("Required Message text Verification field test")
    @Description("The test clears the field and clicks the Save button. Then validates the message that the field is required")
    void required() {
        MainPages.click("MultipleSelect required");
        MainPages.FirstLevelMenu.click("Form");
        FormWidget form = page.findFormWidgetByTitle("Form title");
        var customField = form.multipleSelect("Custom Field");
        customField.addValue(Set.of("Low", "Middle"));
        customField.clear();
        form.clickButton("save");
        assertThat(customField.getRequiredMessage()).isEqualTo(Constants.RequiredMessage);
    }

    @Test
    @Severity(MINOR)
    @Tag("Positive")
    @DisplayName("Test to get a list of options")
    @Description("The test checks the list of options that the method returns, with the expected result")
    void getListOptions() {
        MainPages.click("MultipleSelect basic");
        MainPages.FirstLevelMenu.click("Form");
        FormWidget form = page.findFormWidgetByTitle("Form title");
        var customField = form.multipleSelect("Custom Field");
        customField.addValue(Set.of("Middle"));
        assertThat(customField.getValue()).isEqualTo(Set.of("Middle"));
        assertThat(customField.getOptions()).isEqualTo(List.of("High", "Middle", "Low"));
    }

    @Test
    @Severity(MINOR)
    @Tag("Positive")
    @DisplayName("A test to check the status of one option")
    @Description("The test checks the status of one option, whether it is selected or not")
    void statusOption() {
        MainPages.click("MultipleSelect basic");
        MainPages.FirstLevelMenu.click("Form");
        FormWidget form = page.findFormWidgetByTitle("Form title");
        var customField = form.multipleSelect("Custom Field");
        customField.addValue(Set.of("Low"));
        assertThat(customField.getStatusOption("Low")).isTrue();
    }

    @Test
    @Severity(MINOR)
    @Tag("Positive")
    @DisplayName("Test to check the status of all options")
    @Description("The method returns Option-Status pairs, for all. The test checks each pair.")
    void statusOptions() {
        MainPages.click("MultipleSelect basic");
        MainPages.FirstLevelMenu.click("Form");
        FormWidget form = page.findFormWidgetByTitle("Form title");
        var customField = form.multipleSelect("Custom Field");
        customField.addValue(Set.of("Middle"));
        List<Pair<String, Boolean>> expectedPairs = new ArrayList<>();
        expectedPairs.add(Pair.of("High", false));
        expectedPairs.add(Pair.of("Middle", true));
        expectedPairs.add(Pair.of("Low", true));
        assertThat(customField.getStatusOption("Middle")).isTrue();
        assertThat(customField.getStatusOptions()).isEqualTo(expectedPairs);
    }

    @Test
    @Severity(MINOR)
    @Tag("Positive")
    @DisplayName("Value setting test with field clearing")
    @Description("The test adds a value after removing all previous values.")
    void setValue() {
        MainPages.click("MultipleSelect basic");
        MainPages.FirstLevelMenu.click("Form");
        FormWidget form = page.findFormWidgetByTitle("Form title");
        var customField = form.multipleSelect("Custom Field");
        customField.setValue(Set.of("Middle"));
        form.clickButton("save");
        assertThat(customField.getValue()).isEqualTo(Set.of("Middle"));
    }

}
