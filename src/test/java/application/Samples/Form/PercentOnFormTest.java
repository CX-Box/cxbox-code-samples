package application.Samples.Form;

import application.common.Text;
import core.config.BaseTestForSamples;
import core.MainPages;
import core.widget.TestingTools.Constants;
import core.widget.form.FormWidget;
import core.widget.modal.confirm.constantsConfirm;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Severity;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.selenide.videorecorder.junit5.VideoRecorderExtension;

import java.math.BigDecimal;

import static io.qameta.allure.SeverityLevel.CRITICAL;
import static io.qameta.allure.SeverityLevel.MINOR;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("Form. Checking the basic functions for the Percent in the widget Form")
@Epic("application/Samples")
@Tag("application/Samples")
@Tag("Form") 
@ExtendWith(VideoRecorderExtension.class)
public class PercentOnFormTest extends BaseTestForSamples {

    @Test
    @Tag("Positive")
    @DisplayName("Test for getting the Placeholder value")
    @Description("The test gets the value from the placeholder attribute and returns it in String format")
    void placeholder() {
        MainPages.click("Percent placeholder");
        MainPages.FirstLevelMenu.click("Form");
        FormWidget form = $box.findFormWidgetByTitle("Form title");
        var customField = form.percent("custom Field");
        assertThat(customField.getPlaceholder()).isEqualTo("17");
    }

    @Test
    @Tag("Positive")
    @DisplayName("A test to get the field color value in Hex format")
    @Description("The test gets the value from the style attribute in RGB format, and then converts it to Hex format")
    void color() {
        MainPages.click("Percent color");
        MainPages.FirstLevelMenu.click("Form");
        FormWidget form = $box.findFormWidgetByTitle("Form title");
        var customField = form.percent("Custom Field");
        assertThat(customField.getHexColor()).isEqualTo("#EDA6A6");
    }

    @Test
    @Tag("Positive")
    @DisplayName("A test to check the field for \"Read-only\"")
    @Description("The test checks for the disabled attribute")
    void readonly() {
        MainPages.click("Percent readonly");
        MainPages.FirstLevelMenu.click("Form");
        FormWidget form = $box.findFormWidgetByTitle("Form title");
        var customField = form.percent("custom Field");
        assertThat(customField.getReadOnly()).isTrue();
    }

    @Test
    @Severity(CRITICAL)
    @Tag("Positive")
    @DisplayName("A test for setting a value in a field")
    @Description("The test sets the value in the field, and then checks the value in the field with what should be set")
    void edit() {
        MainPages.click("Percent basic");
        MainPages.FirstLevelMenu.click("Form");
        FormWidget form = $box.findFormWidgetByTitle("Form title");
        var customField = form.percent("custom Field");
        customField.setValue(57);
        assertThat(customField.getValue()).isEqualTo(57);
    }

    @Test
    @Severity(MINOR)
    @Tag("Negative")
    @DisplayName("Filtering test")
    @Description("Filtering is not available for the Form widget")
    void filtration() {
        MainPages.click("Percent filtration");
        MainPages.FirstLevelMenu.click("Form");
        FormWidget form = $box.findFormWidgetByTitle("Form title");
        var customField = form.percent("custom Field");
        assertThatThrownBy(customField::setFiltration).isInstanceOf(UnsupportedOperationException.class);
    }

    @Test
    @Tag("Positive")
    @DisplayName("The DrillDown test")
    @Description("Checking the url before the transition and after the transition/click on a special element")
    void drillDown() {
        MainPages.click("Percent drilldown");
        MainPages.FirstLevelMenu.click("Form");
        FormWidget form = $box.findFormWidgetByTitle("Form title");
        var customField = form.percent("custom Field");
        assertThatThrownBy(customField::drillDown).isInstanceOf(UnsupportedOperationException.class);
    }

    @Test
    @Severity(CRITICAL)
    @Tag("Negative")
    @DisplayName("Business Exception Validation Test")
    @Description("The test sets the value in the field. After approval, the popup window, the title, the text in it, and the buttons are validated")
    void businessException() {
        MainPages.click("Percent validation business exception");
        MainPages.FirstLevelMenu.click("Form");
        FormWidget form = $box.findFormWidgetByTitle("Form title");
        var customField = form.percent("custom Field");
        customField.setValue(3);
        form.clickButton("save");
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
    @Description("The test sets the value in the field. After approval, the popup window, the title, the text in it, and the buttons are validated")
    void runtimeException() {
        MainPages.click("Percent validation runtime exception");
        MainPages.FirstLevelMenu.click("Form");
        FormWidget form = $box.findFormWidgetByTitle("Form title");
        var customField = form.percent("custom Field");
        customField.clear();
        form.clickButton("save");
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
    @Description("The test sets the value in the field. After approval, by clicking on the save button, the popup window, the title, the text in it, and the buttons are validated")
    void confirm() {
        MainPages.click("Percent validation confirm");
        MainPages.FirstLevelMenu.click("Form");
        FormWidget form = $box.findFormWidgetByTitle("Form title");
        var customField = form.percent("custom Field");
        customField.setValue(57);
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
    @Description("The test sets the value with the wrong data type in the field. After approval, it checks the text under the field, which informs about the correctness of the type of data entered")
    void fieldLevelValidationAnnotation() {
        MainPages.click("Percent validation field level annotation");
        MainPages.FirstLevelMenu.click("Form");
        FormWidget form = $box.findFormWidgetByTitle("Form title");
        var customField = form.percent("Custom Field");
        customField.setValue(3);
        form.clickButton("save");
        assertThat(customField.getRequiredMessage()).isEqualTo(Text.textInvalidPercent("5%."));
    }

    @Test
    @Severity(CRITICAL)
    @Tag("Negative")
    @DisplayName("Required Message validation test for multiple fields")
    @Description("The test sets a value with the wrong data type in several fields for different widgets. After approval, it checks the text under the field, which informs about the correctness of the type of data entered")
    void fieldLevelValidation() {
        MainPages.click("Percent validation field level dynamic");
        MainPages.FirstLevelMenu.click("Form");
        FormWidget form = $box.findFormWidgetByTitle("Form title");
        var customField = form.percent("Custom Field");
        var customField2 = form.percent("Custom Field Additional");
        customField.setValue(3);
        customField2.setValue(3);
        form.clickButton("save");
        assertThat(customField.getRequiredMessage()).isEqualTo(Text.textInvalidPercent("5%"));
        assertThat(customField2.getRequiredMessage()).isEqualTo(Text.textInvalidPercent("5%"));
    }


    @Test
    @Severity(MINOR)
    @Tag("Negative")
    @DisplayName("Sorting test")
    @Description("Sorting is not available for the Form widget")
    void sorting() {
        MainPages.click("Percent sorting");
        MainPages.FirstLevelMenu.click("Form");
        FormWidget form = $box.findFormWidgetByTitle("Form title");
        var customField = form.percent("custom Field");
        assertThatThrownBy(customField::setSorting).isInstanceOf(UnsupportedOperationException.class);
    }


    @Test
    @Severity(CRITICAL)
    @Tag("Negative")
    @DisplayName("Required Message text Verification field test")
    @Description("The test clears the field and clicks the Save button. Then validates the message that the field is required")
    void required() {
        MainPages.click("Percent required");
        MainPages.FirstLevelMenu.click("Form");
        FormWidget form = $box.findFormWidgetByTitle("Form title");
        var customField = form.percent("custom Field");
        customField.clear();
        form.clickButton("save");
        assertThat(customField.getRequiredMessage()).isEqualTo(Constants.RequiredMessage);
    }

    @Test
    @Severity(CRITICAL)
    @Tag("Positive")
    @DisplayName("A test for entering numbers with a fractional part using the PercentDigits class")
    @Description("The test sets the value in the field, and then checks the value in the field with what should be set. The Number Digits class is used for numbers with a fractional part.")
    void digits() {
        MainPages.click("Percent digits");
        MainPages.FirstLevelMenu.click("Form");
        FormWidget form = $box.findFormWidgetByTitle("Form title");
        var customField = form.percentDigits("Custom Field");

        BigDecimal number = new BigDecimal("131343.00");

        customField.setValue(number);
        assertThat(customField.getValue()).isEqualTo(number);
    }

    @Test
    @Tag("Positive")
    @DisplayName("Auto-completion test after cleaning")
    @Description("The test deletes the value by checking the autocomplete in a blank field")
    void nullable() {
        MainPages.click("Percent nullable");
        MainPages.FirstLevelMenu.click("Form");
        FormWidget form = $box.findFormWidgetByTitle("Form title");
        var customField = form.percent("Custom Field");
        customField.setValue(123);
        assertThat(customField.getValue()).isEqualTo(123);
    }
}
