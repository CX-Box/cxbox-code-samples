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
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static io.qameta.allure.SeverityLevel.CRITICAL;
import static io.qameta.allure.SeverityLevel.MINOR;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("List. Checking the basic functions for the CheckBox")
@Epic("Samples")
@Story("List")
@Tag("Samples")
@Tag("List")
public class CheckBoxOnListTest extends BaseTestForSamples {

    @Test
    @Tag("Positive")
    @DisplayName("Test for getting the Placeholder value")
    @Description("The test gets the value from the placeholder attribute and returns it in String format")
    void placeholder() {
        MainPages.click("Checkbox placeholder");
        MainPages.FirstLevelMenu.click("List");
        var list = $box.findListWidgetByTitle("List title");

        List<Long> listRowsId = list.getListRowsId();

        var customField = list.findRowSegmentById("Custom Field", listRowsId.get(0)).checkbox();
        assertThat(customField.getPlaceholder()).isEmpty();
    }

    @Test
    @Tag("Positive")
    @DisplayName("A test to get the field color value in Hex format")
    @Description("The test gets the value from the style attribute in RGB format, and then converts it to Hex format")
    void color() {
        MainPages.click("Checkbox color");
        MainPages.FirstLevelMenu.click("List");
        var list = $box.findListWidgetByTitle("List title");
        List<Long> listRowsId = list.getListRowsId();
        var customField = list.findRowSegmentById("Custom Field", listRowsId.get(0)).checkbox();
        assertThat(customField.getHexColor()).isNull();
    }

    @Test
    @Tag("Positive")
    @DisplayName("A test to check the field for \"Read-only\"")
    @Description("The test checks for the disabled attribute.")
    void readonly() {
        MainPages.click("Checkbox readonly");
        MainPages.FirstLevelMenu.click("List");
        var list = $box.findListWidgetByTitle("List title");
        List<Long> listRowsId = list.getListRowsId();
        var customField = list.findRowSegmentById("Custom Field", listRowsId.get(0)).checkbox();
        assertThat(customField.getReadOnly()).isTrue();
    }

    @Test
    @Severity(CRITICAL)
    @Tag("Positive")
    @DisplayName("A test for checking a value in a field")
    @Description("The test gets the value in the field, and then checks the value in the field with what should be.")
    void read() {
        MainPages.click("Checkbox basic");
        MainPages.FirstLevelMenu.click("List");
        var list = $box.findListWidgetByTitle("List title");
        List<String> listRows = list.getNoFocusValues("Custom Field");
        var customField = list.findRowSegmentByValue("Custom Field", listRows.get(0)).checkbox();
        assertThat(customField.compareRows("True")).isTrue();
    }

    @Test
    @Severity(CRITICAL)
    @Tag("Positive")
    @DisplayName("A test for setting a value in a field")
    @Description("The test sets the value to false in the field, and then checks the value in the field with what should be set.")
    void edit() {
        MainPages.click("Checkbox basic");
        MainPages.FirstLevelMenu.click("List");
        var list = $box.findListWidgetByTitle("List title");
        List<Long> listRowsId = list.getListRowsId();
        var customField = list.findRowSegmentById("Custom Field", listRowsId.get(0)).checkbox();
        customField.setValue(false);
        assertThat(customField.getValue()).isFalse();
    }

    @Test
    @Severity(CRITICAL)
    @Tag("Positive")
    @DisplayName("A test for setting a value in a field")
    @Description("The test sets the value to true in the field, and then checks the value in the field with what should be set.")
    void edit2() {
        MainPages.click("Checkbox basic");
        MainPages.FirstLevelMenu.click("List");
        var list = $box.findListWidgetByTitle("List title");
        List<Long> listRowsId = list.getListRowsId();
        var customField = list.findRowSegmentById("Custom Field", listRowsId.get(0)).checkbox();
        customField.setValue(true);
        assertThat(customField.getValue()).isTrue();
    }

    @Test
    @Severity(MINOR)
    @Tag("Negative")
    @DisplayName("Filtering test")
    @Description("Filtering by the specified column.")
    void filtration() {
        MainPages.click("Checkbox filtration");
        MainPages.FirstLevelMenu.click("List");
        var list = $box.findListWidgetByTitle("List title");
        list.findFilterColumn("Custom Field").checkboxFilter().setFilter(true);
        assertThat(list.getNoFocusStatusValues("Custom Field")).isEqualTo(List.of(true));
    }


    @Test
    @Tag("Positive")
    @DisplayName("The DrillDown test")
    @Description("Checking the url before the transition and after the transition/click on a special element")
    void drillDown() {
        MainPages.click("Checkbox drilldown");
        MainPages.FirstLevelMenu.click("List");
        var list = $box.findListWidgetByTitle("List title");
        List<Long> listRowsId = list.getListRowsId();
        var customField = list.findRowSegmentById("Custom Field", listRowsId.get(0)).checkbox();
        assertThatThrownBy(customField::drillDown).isInstanceOf(UnsupportedOperationException.class);
    }

    @Test
    @Severity(CRITICAL)
    @Tag("Negative")
    @DisplayName("Business Exception Validation Test")
    @Description("The test sets the value in the field. After approval, the popup window, the title, the text in it, and the buttons are validated.")
    void businessException() {
        MainPages.click("Checkbox validation business exception");
        MainPages.FirstLevelMenu.click("List");
        var list = $box.findListWidgetByTitle("List title");
        List<Long> listRowsId = list.getListRowsId();
        var customField = list.findRowSegmentById("Custom Field", listRowsId.get(0)).checkbox();
        customField.setValue(false);
        var popup = $box.findPopup("error");
        assertThat(popup).isPresent();
        assertThat(popup.get().errorPopup().getTitle()).isEqualTo(Constants.ErrorPopup.ErrorTitle);
        assertThat(popup.get().errorPopup().getMessage()).isEqualTo(Text.textOnly("'True'"));
        popup.get().errorPopup().close();
    }

    @Test
    @Severity(CRITICAL)
    @Tag("Negative")
    @DisplayName("Run-time exception validation test")
    @Description("The test sets the value in the field. After approval, the popup window, the title, the text in it, and the buttons are validated.")
    void runtimeException() {
        MainPages.click("Checkbox validation runtime exception");
        MainPages.FirstLevelMenu.click("List");
        var list = $box.findListWidgetByTitle("List title");
        List<Long> listRowsId = list.getListRowsId();
        var customField = list.findRowSegmentById("Custom Field", listRowsId.get(0)).checkbox();
        customField.setValue(true);
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
        MainPages.click("Checkbox validation confirm");
        MainPages.FirstLevelMenu.click("List");
        var list = $box.findListWidgetByTitle("List title");
        List<Long> listRowsId = list.getListRowsId();
        var row = list.findRowSegmentById("Custom Field", listRowsId.get(0));
        row.checkbox().setValue(true);
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
        MainPages.click("Checkbox validation field level annotation");
        MainPages.FirstLevelMenu.click("List");
        var list = $box.findListWidgetByTitle("List title");
        List<Long> listRowsId = list.getListRowsId();
        var row = list.findRowSegmentById("Custom Field", listRowsId.get(0));
        row.checkbox().setValue(false);
        Optional<MenuRow> menuRow = row.findMenuRow();
        assertThat(menuRow).isPresent();
        menuRow.get().clickOption("save");
        assertThat(row.checkbox().getRequiredMessage()).isEqualTo(Text.textOnly("'True'"));
    }

    @Test
    @Severity(CRITICAL)
    @Tag("Negative")
    @DisplayName("Required Message validation test for multiple fields")
    @Description("The test sets a value with the wrong data type in several fields for different widgets. After approval, it checks the text under the field, which informs about the correctness of the type of data entered")
    void fieldLevelValidation() {
        MainPages.click("Checkbox validation field level dynamic");
        MainPages.FirstLevelMenu.click("List");
        var list = $box.findListWidgetByTitle("List title");
        List<Long> listRowsId = list.getListRowsId();
        var row = list.findRowSegmentById("Custom Field", listRowsId.get(0));
        var row2 = list.findRowSegmentById("Custom Field Additional", listRowsId.get(0));
        row.checkbox().setValue(false);
        row2.checkbox().setValue(false);
        Optional<MenuRow> menuRow = row.findMenuRow();
        assertThat(menuRow).isPresent();
        menuRow.get().clickOption("save");
        assertThat(row.checkbox().getRequiredMessage()).isEqualTo(Text.textOnlyTrue("customField"));
        assertThat(row2.checkbox().getRequiredMessage()).isEqualTo(Text.textOnlyTrue("customFieldAdditional"));
    }

    @Test
    @Severity(MINOR)
    @Tag("Negative")
    @DisplayName("Sorting test")
    @Description("Sorting by the specified column.")
    void sorting() {
        MainPages.click("Checkbox sorting");
        MainPages.FirstLevelMenu.click("List");
        var list = $box.findListWidgetByTitle("List title");
        assertThat(list.getNoFocusStatusValues("Custom Field")).isEqualTo(List.of(false, false, true, false));
        list.setSorting("Custom Field");
        assertThat(list.getNoFocusStatusValues("Custom Field")).isEqualTo(List.of(false, true, false, false));

    }

    @Test
    @Severity(CRITICAL)
    @Tag("Negative")
    @DisplayName("Required Message text Verification field test")
   @Description("The test clears the field and clicks the Save button. Then validates the message that the field is required.")
    void required() {
        MainPages.click("Checkbox required");
        MainPages.FirstLevelMenu.click("List");
        var list = $box.findListWidgetByTitle("List title");
        List<Long> listRowsId = list.getListRowsId();
        var row = list.findRowSegmentById("Custom Field", listRowsId.get(0));
        Optional<MenuRow> menuRow = row.findMenuRow();
        assertThat(menuRow).isPresent();
        menuRow.get().clickOption("save");
        assertThat(row.checkbox().getRequiredMessage()).isEqualTo(Constants.RequiredMessage);
    }
}
