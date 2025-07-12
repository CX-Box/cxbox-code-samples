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

import java.util.List;
import java.util.Optional;

import static io.qameta.allure.SeverityLevel.CRITICAL;
import static io.qameta.allure.SeverityLevel.MINOR;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("List. Checking the basic functions for the Dictionary in the widget List")
@Epic("Samples")
@Tag("Samples")
@Tag("List")
public class DictionaryOnListTest extends BaseTestForSamples {

    @Test
    @Tag("Positive")
    @DisplayName("Test for getting the Placeholder value")
    @Description("The test gets the value from the placeholder attribute and returns it in String format")
    void placeholder() {
        MainPages.click("Dictionary enum placeholder");
        MainPages.FirstLevelMenu.click("List");
        var list = $box.findListWidgetByTitle("List title");
        List<String> listRows = list.getListRows();
        var customField = list.findRowSegmentByValue("Custom Field", listRows.get(0)).dictionary();
        assertThat(customField.getPlaceholder()).isEqualTo("Placeholder text");
    }

    @Test
    @Tag("Positive")
    @DisplayName("A test to get the field color value in Hex format")
    @Description("The test gets the value from the style attribute in RGB format, and then converts it to Hex format")
    void color() {
        MainPages.click("Dictionary enum color");
        MainPages.FirstLevelMenu.click("List");
        var list = $box.findListWidgetByTitle("List title");
        List<String> listRows = list.getListRows();
        var customField = list.findRowSegmentByValue("Custom Field", listRows.get(0)).dictionary();
        assertThat(customField.getHexColor()).isEqualTo("#EDA6A6");
    }

    @Test
    @Tag("Positive")
    @DisplayName("A test to check the field for \"Read-only\"")
    @Description("The test checks for the disabled attribute.")
    void readonly() {
        MainPages.click("Dictionary enum readonly");
        MainPages.FirstLevelMenu.click("List");
        var list = $box.findListWidgetByTitle("List title");
        List<String> listRows = list.getListRows();
        var customField = list.findRowSegmentByValue("Custom Field", listRows.get(0)).dictionary();
        assertThat(customField.getReadOnly()).isTrue();
    }

    @Test
    @Severity(CRITICAL)
    @Tag("Positive")
    @DisplayName("A test for checking a value in a field")
    @Description("The test gets the value in the field, and then checks the value in the field with what should be.")
    @Disabled("Checked at filtration and sorting")
    void read() {
        MainPages.click("Dictionary enum basic");
        MainPages.FirstLevelMenu.click("List");
        var list = $box.findListWidgetByTitle("List title");
        List<String> listRows = list.getNoFocusValues("Custom Field");
        var customField = list.findRowSegmentByValue("Custom Field", listRows.get(0)).dictionary();
        assertThat(customField.compareRows("Kostroma region")).isTrue();
    }

    @Test
    @Severity(CRITICAL)
    @Tag("Positive")
    @DisplayName("A test for setting a value in a field")
    @Description("The test sets the value in the field, and then checks the value in the field with what should be set.")
    void edit() {
        MainPages.click("Dictionary enum basic");
        MainPages.FirstLevelMenu.click("List");
        var list = $box.findListWidgetByTitle("List title");
        List<String> listRows = list.getListRows();
        var customField = list.findRowSegmentByValue("Custom Field", listRows.get(0)).dictionary();
        customField.setValue("Tver region");
        assertThat(customField.getValue()).isEqualTo("Tver region");
    }

    @Test
    @Severity(MINOR)
    @Tag("Negative")
    @DisplayName("Filtering test")
    @Description("Filtering by the specified column.")
    void filtration() {
        MainPages.click("Dictionary enum filtration");
        MainPages.FirstLevelMenu.click("List");
        var list = $box.findListWidgetByTitle("List title");
        list.findFilterColumn("Custom Field").dictionaryFilter().setFilter("Low");
        assertThat(list.getNoFocusValues("Custom Field")).isEqualTo(List.of("Low", "Low","Low", "Low"));
    }

    @Test
    @Tag("Positive")
    @DisplayName("The DrillDown test")
    @Description("Checking the url before the transition and after the transition/click on a special element")
    void drillDown() {
        MainPages.click("Dictionary enum drilldown");
        MainPages.FirstLevelMenu.click("List");
        var list = $box.findListWidgetByTitle("List title");
        List<String> listRows = list.getListRows();
        var customField = list.findRowSegmentByValue("Custom Field", listRows.get(0)).dictionary();
        assertThatThrownBy(customField::drillDown).isInstanceOf(UnsupportedOperationException.class);
    }

    @Test
    @Severity(CRITICAL)
    @Tag("Negative")
    @DisplayName("Business Exception Validation Test")
    @Description("The test sets the value in the field. After approval, the popup window, the title, the text in it, and the buttons are validated.")
    void businessException() {
        MainPages.click("Dictionary enum validation business exception");
        MainPages.FirstLevelMenu.click("List");
        var list = $box.findListWidgetByTitle("List title");
        List<String> listRows = list.getListRows();
        var customField = list.findRowSegmentByValue("Custom Field", listRows.get(0)).dictionary();
        customField.setValue("Middle");
        var popup = $box.findPopup("error");
        assertThat(popup).isPresent();
        assertThat(popup.get().errorPopup().getTitle()).isEqualTo(Constants.ErrorPopup.ErrorTitle);
        assertThat(popup.get().errorPopup().getMessage()).isEqualTo(Text.textOnly("'High'"));
        popup.get().errorPopup().close();
    }

    @Test
    @Severity(CRITICAL)
    @Tag("Negative")
    @DisplayName("Run-time exception validation test")
    @Description("The test sets the value in the field. After approval, the popup window, the title, the text in it, and the buttons are validated.")
    void runtimeException() {
        MainPages.click("Dictionary enum validation runtime exception");
        MainPages.FirstLevelMenu.click("List");
        var list = $box.findListWidgetByTitle("List title");
        List<String> listRows = list.getListRows();
        var customField = list.findRowSegmentByValue("Custom Field", listRows.get(0)).dictionary();
        customField.setValue("Middle");
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
        MainPages.click("Dictionary enum validation confirm");
        MainPages.FirstLevelMenu.click("List");
        var list = $box.findListWidgetByTitle("List title");
        List<String> listRows = list.getListRows();
        var row = list.findRowSegmentByValue("Custom Field", listRows.get(0));
        row.dictionary().setValue("Low");
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
        MainPages.click("Dictionary enum validation field level annotation");
        MainPages.FirstLevelMenu.click("List");
        var list = $box.findListWidgetByTitle("List title");
        List<String> listRows = list.getNoFocusValues("Custom Field");
        var row = list.findRowSegmentByValue("Custom Field", listRows.get(0));
        row.dictionary().setFocusField();
        Optional<MenuRow> menuRow = row.findMenuRow();
        assertThat(menuRow).isPresent();
        menuRow.get().clickOption("Save");
        assertThat(row.dictionary().getRequiredMessage()).isEqualTo(Constants.MessageAboutError);
    }

    @Test
    @Severity(CRITICAL)
    @Tag("Negative")
    @DisplayName("Required Message validation test for multiple fields")
    @Description("The test sets a value with the wrong data type in several fields for different widgets. After approval, it checks the text under the field, which informs about the correctness of the type of data entered")
    void fieldLevelValidation() {
        MainPages.click("Dictionary enum validation field level dynamic");
        MainPages.FirstLevelMenu.click("List");
        var list = $box.findListWidgetByTitle("List title");
        List<String> listRows = list.getNoFocusValues("Custom Field");
        var row = list.findRowSegmentByValue("Custom Field", listRows.get(0));
        List<String> listRows2 = list.getNoFocusValues("Custom Field Additional");
        var row2 = list.findRowSegmentByValue("Custom Field Additional", listRows2.get(0));
        row.dictionary().setFocusField();
        Optional<MenuRow> menuRow = row.findMenuRow();
        assertThat(menuRow).isPresent();
        menuRow.get().clickOption("Save");
        assertThat(row.dictionary().getRequiredMessage()).isEqualTo(Constants.MessageAboutError);
        assertThat(row2.dictionary().getRequiredMessage()).isEqualTo(Constants.MessageAboutError);
    }

    @Test
    @Severity(MINOR)
    @Tag("Negative")
    @DisplayName("Sorting test")
    @Description("Sorting by the specified column.")
    void sorting() {
        MainPages.click("Dictionary enum sorting");
        MainPages.FirstLevelMenu.click("List");
        var list = $box.findListWidgetByTitle("List Dictionary enum sorting");
        assertThat(list.getNoFocusValues("Custom Field Dictionary")).isEqualTo(List.of("Low", "Middle", "High"));
        list.setSorting("Custom Field Dictionary");
        assertThat(list.getNoFocusValues("Custom Field Dictionary")).isEqualTo(List.of("Middle", "Low", "High"));
    }

    @Test
    @Severity(CRITICAL)
    @Tag("Negative")
    @DisplayName("Required Message text Verification field test")
   @Description("The test clears the field and clicks the Save button. Then validates the message that the field is required.")
    void required() {
        MainPages.click("Dictionary enum required");
        MainPages.FirstLevelMenu.click("List");
        var list = $box.findListWidgetByTitle("List title");
        List<String> listRows = list.getListRows();
        var customField = list.findRowSegmentByValue("Custom Field", listRows.get(0)).dictionary();
        var row = list.findRowSegmentByValue("Custom Field", listRows.get(0));
        customField.clear();
        Optional<MenuRow> menuRow = row.findMenuRow();
        assertThat(menuRow).isPresent();
        menuRow.get().clickOption("Save");
        assertThat(customField.getRequiredMessage()).isEqualTo(Constants.RequiredMessage);
    }

    @Test
    @Severity(MINOR)
    @Tag("Positive")
    @DisplayName("A test to check the options of the drop-down list")
    void options() {
        MainPages.click("Dictionary enum basic");
        MainPages.FirstLevelMenu.click("List");
        var list = $box.findListWidgetByTitle("List title");
        List<String> listRows = list.getListRows();
        var customField = list.findRowSegmentByValue("Custom Field", listRows.get(0)).dictionary();
        assertThat(customField.getOptions()).isEqualTo(List.of("Belgorod region",
                "Bryansk region",
                "Vladimir region",
                "Voronezh region",
                "Ivanovo region",
                "Kaluga region",
                "Kostroma region",
                "Kursk region",
                "Moscow region",
                "Oryol region",
                "Ryazan region",
                "Smolensk region",
                "Tambov region",
                "Tver region"));

    }
}
