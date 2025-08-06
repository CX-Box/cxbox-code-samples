package application.Samples.List;

import application.common.Text;
import application.config.BaseTestForSamples;
import core.MainPages;
import core.widget.TestingTools.Constants;
import core.widget.addfiles.FilesPopup;
import core.widget.list.actions.MenuRow;
import core.widget.list.field.fileupload.FileUpload;
import core.widget.modal.confirm.constantsConfirm;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Severity;
import lombok.SneakyThrows;
import org.apache.commons.lang3.tuple.Pair;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.net.URL;
import java.util.List;
import java.util.Optional;

import static io.qameta.allure.SeverityLevel.CRITICAL;
import static io.qameta.allure.SeverityLevel.MINOR;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("List. Checking the basic functions for the FileUpload in the widget List")
@Epic("Samples")
@Tag("Samples")
@Tag("List")
public class FileUploadOnListTest extends BaseTestForSamples {

    @Test
    @Tag("Positive")
    @DisplayName("Test for getting the Placeholder value")
    @Description("The test gets the value from the placeholder attribute and returns it in String format")
    void placeholder() {
        MainPages.click("FileUpload placeholder");
        MainPages.FirstLevelMenu.click("List");
        var list = $box.findListWidgetByTitle("List title");
        List<String> listRows = list.getListRows();
        var customField = list.findRowSegmentByValue("Custom Field", listRows.get(0)).fileUpload();
        String placeholder = customField.getPlaceholder();
        assertThat(placeholder).isEqualTo("Placeholder text");
    }

    @Test
    @Tag("Positive")
    @DisplayName("A test to get the field color value in Hex format")
    @Description("The test gets the value from the style attribute in RGB format, and then converts it to Hex format")
    void color() {
        MainPages.click("FileUpload color");
        MainPages.FirstLevelMenu.click("List");
        var list = $box.findListWidgetByTitle("List title");
        List<String> listRows = list.getListRows();
        var customField = list.findRowSegmentByValue("Custom Field", listRows.get(0)).fileUpload();
        assertThat(customField.getHexColor()).isNull();
    }

    @Test
    @Tag("Positive")
    @DisplayName("A test to check the field for \"Read-only\"")
    @Description("The test checks for the disabled attribute.")
    void readonly() {
        MainPages.click("FileUpload readonly");
        MainPages.FirstLevelMenu.click("List");
        var list = $box.findListWidgetByTitle("List title");
        List<String> listRows = list.getListRows();
        var customField = list.findRowSegmentByValue("Custom Field", listRows.get(0)).fileUpload();
        assertThat(customField.getReadOnly()).isTrue();
    }

    @Test
    @Severity(CRITICAL)
    @Tag("Positive")
    @DisplayName("A test for checking a value in a field")
    @Description("The test gets the value in the field, and then checks the value in the field with what should be.")
    @Disabled("Checked at filtration and sorting")
    void read() {
        MainPages.click("FileUpload basic");
        MainPages.FirstLevelMenu.click("List");
        var list = $box.findListWidgetByTitle("List title");
        List<String> listRows = list.getNoFocusValues("Custom Field");
        var customField = list.findRowSegmentByValue("Custom Field", listRows.get(0)).fileUpload();
        assertThat(customField.compareRows("FILE_1.txt")).isTrue();
    }

    @Test
    @Severity(CRITICAL)
    @Tag("Positive")
    @DisplayName("A test for setting a value in a field")
    @Description("The test sets the value in the field, and then checks the value in the field with what should be set.")
    void edit() {
        MainPages.click("FileUpload basic");
        MainPages.FirstLevelMenu.click("List");
        var list = $box.findListWidgetByTitle("List title");
        List<String> listRows = list.getListRows();
        var customField = list.findRowSegmentByValue("Custom Field", listRows.get(0)).fileUpload();
        File fileFromResource = getFileFromResource("FILE_1.txt");
        customField.setValue(fileFromResource);
        assertThat(customField.getValueName()).isEqualTo("FILE_1.txt");
        FilesPopup filesPopup = customField.getPopup();
        assertThat(filesPopup.getFileNameAndStatusUpload()).isEqualTo(List.of(Pair.of("FILE_1.txt", "done")));
    }

    @Test
    @Severity(MINOR)
    @Tag("Negative")
    @DisplayName("Filtering test")
    @Description("Filtering by the specified column.")
    void filtration() {
        MainPages.click("FileUpload filtration");
        MainPages.FirstLevelMenu.click("List");
        var list = $box.findListWidgetByTitle("List title");
        list.findFilterColumn("Custom Field").fileUploadFilter().setFilter("1");
        assertThat(list.getNoFocusValues("Custom Field")).isEqualTo(List.of("FILE_1.txt"));
    }

    @Test
    @Tag("Positive")
    @DisplayName("The DrillDown test")
    @Description("Checking the url before the transition and after the transition/click on a special element")
    void drillDown() {
        MainPages.click("FileUpload drilldown");
        MainPages.FirstLevelMenu.click("List");
        var list = $box.findListWidgetByTitle("List title");
        List<String> listRows = list.getListRows();
        var customField = list.findRowSegmentByValue("Custom Field", listRows.get(0)).fileUpload();
        assertThatThrownBy(customField::drillDown).isInstanceOf(UnsupportedOperationException.class);
    }

    @Test
    @Severity(CRITICAL)
    @Tag("Negative")
    @DisplayName("Business Exception Validation Test")
    @Description("The test sets the value in the field. After approval, the popup window, the title, the text in it, and the buttons are validated.")
    void businessException() {
        MainPages.click("FileUpload validation business exception");
        MainPages.FirstLevelMenu.click("List");
        var list = $box.findListWidgetByTitle("List title");
        List<String> listRows = list.getListRows();
        var customField = list.findRowSegmentByValue("Custom Field", listRows.get(0)).fileUpload();
        File fileFromResource = getFileFromResource("FILE_1.txt");
        customField.setValue(fileFromResource);
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
        MainPages.click("FileUpload validation runtime exception");
        MainPages.FirstLevelMenu.click("List");
        var list = $box.findListWidgetByTitle("List title");
        List<String> listRows = list.getListRows();
        var customField = list.findRowSegmentByValue("Custom Field", listRows.get(0)).fileUpload();
        File fileFromResource = getFileFromResource("FILE_1.txt");
        customField.setValue(fileFromResource);
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
        MainPages.click("FileUpload validation confirm");
        MainPages.FirstLevelMenu.click("List");
        var list = $box.findListWidgetByTitle("List title");
        List<String> listRows = list.getListRows();
        var row = list.findRowSegmentByValue("Custom Field", listRows.get(0));
        FileUpload fileUpload = row.fileUpload();
        File fileFromResource = getFileFromResource("FILE_1.txt");
        fileUpload.setValue(fileFromResource);
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
        MainPages.click("FileUpload validation field level annotation");
        MainPages.FirstLevelMenu.click("List");
        var list = $box.findListWidgetByTitle("List title");
        List<String> listRows = list.getListRows();
        var row = list.findRowSegmentByValue("Custom Field", listRows.get(0));
        FileUpload fileUpload = row.fileUpload();
        File fileFromResource = getFileFromResource("FILE_1.txt");
        fileUpload.setValue(fileFromResource);
        Optional<MenuRow> menuRow = row.findMenuRow();
        assertThat(menuRow).isPresent();
        menuRow.get().clickOption("Save");
        assertThat(row.fileUpload().getRequiredMessage()).isEqualTo(Constants.OnlyLetters);
    }

    @Test
    @Severity(CRITICAL)
    @Tag("Negative")
    @DisplayName("Required Message validation test for multiple fields")
    @Description("The test sets a value with the wrong data type in several fields for different widgets. After approval, it checks the text under the field, which informs about the correctness of the type of data entered")
    void fieldLevelValidation() {

        File fileFromResource = getFileFromResource("FILE_1.txt");
        File fileFromResource1 = getFileFromResource("FILE_7405.txt");

        MainPages.click("FileUpload validation field level dynamic");
        MainPages.FirstLevelMenu.click("List");
        var list = $box.findListWidgetByTitle("List title");
        List<String> listRows = list.getNoFocusValues("Custom Field");
        var row = list.findRowSegmentByValue("Custom Field", listRows.get(0));
        row.fileUpload().setValue(fileFromResource);

        List<String> listRows2 = list.getNoFocusValues("Custom Field Additional");
        var row2 = list.findRowSegmentByValue("Custom Field Additional", listRows2.get(0));
        row2.fileUpload().setValue(fileFromResource1);
        Optional<MenuRow> menuRow2 = row2.findMenuRow();
        assertThat(menuRow2).isPresent();
        menuRow2.get().clickOption("Save");
        assertThat(row.fileUpload().getRequiredMessage()).isEqualTo(Text.textOnlyLetters("customField"));
        assertThat(row2.fileUpload().getRequiredMessage()).isEqualTo(Text.textOnlyLetters("customFieldAdditional"));
    }

    @Test
    @Severity(MINOR)
    @Tag("Negative")
    @DisplayName("Sorting test")
    @Description("Sorting by the specified column.")
    void sorting() {
        MainPages.click("FileUpload sorting");
        MainPages.FirstLevelMenu.click("List");
        var list = $box.findListWidgetByTitle("List title");
        assertThat(list.getNoFocusValues("Custom Field")).isEqualTo(List.of("IMG_5867.jpg", "IMG_5866.jpg", "IMG_5865.jpg"));
        list.setSorting("Custom Field");
        assertThat(list.getNoFocusValues("Custom Field")).isEqualTo(List.of("IMG_5867.jpg", "IMG_5866.jpg", "IMG_5865.jpg"));
        list.setSorting("Custom Field");
        assertThat(list.getNoFocusValues("Custom Field")).isEqualTo(List.of("IMG_5865.jpg", "IMG_5866.jpg", "IMG_5867.jpg"));

    }

    @Test
    @Severity(CRITICAL)
    @Tag("Negative")
    @DisplayName("Required Message text Verification field test")
    @Description("The test clears the field and clicks the Save button. Then validates the message that the field is required.")
    void required() {
        MainPages.click("FileUpload required");
        MainPages.FirstLevelMenu.click("List");
        var list = $box.findListWidgetByTitle("List title");
        List<String> listRows = list.getListRows();
        var row = list.findRowSegmentByValue("Custom Field", listRows.get(0));
        row.fileUpload().clear();
        Optional<MenuRow> menuRow = row.findMenuRow();
        assertThat(menuRow).isPresent();
        menuRow.get().clickOption("Save");
        assertThat(row.fileUpload().getRequiredMessage()).isEqualTo(Constants.RequiredMessage);
    }

    @Test
    @Tag("Positive")
    @DisplayName("The test for deleting a file from a field")
    @Description("The test verifies that after clearing the field, it is empty.")
    void clear() {
        MainPages.click("FileUpload basic");
        MainPages.FirstLevelMenu.click("List");
        var list = $box.findListWidgetByTitle("List title");
        List<String> listRows = list.getListRows();
        var customField = list.findRowSegmentByValue("Custom Field", listRows.get(0)).fileUpload();
        File fileFromResource = getFileFromResource("FILE_1.txt");
        customField.setValue(fileFromResource);
        assertThat(customField.getNameFileInField()).isEqualTo("FILE_1.txt");
        customField.clear();
        assertThat(customField.getNameFileInField()).isEmpty();
    }

    @Test
    @Severity(CRITICAL)
    @Tag("Positive")
    @DisplayName("A test to compare the downloaded file with the template")
    @Description("The test checks the downloaded file with the template file that is contained in the resources")
    void compare() {
        MainPages.click("FileUpload basic");
        MainPages.FirstLevelMenu.click("List");
        var list = $box.findListWidgetByTitle("List title");
        List<String> listRows = list.getListRows();
        var customField = list.findRowSegmentByValue("Custom Field", listRows.get(0)).fileUpload();
        File fileFromResource = getFileFromResource("FILE_1.txt");
        customField.setValue(fileFromResource);
        assertThat(customField.getFileComparison(fileFromResource)).isTrue();
    }

    @Test
    void setValueGetValue() {
        MainPages.click("FileUpload basic");
        MainPages.FirstLevelMenu.click("List");
        var list = $box.findListWidgetByTitle("List title");
        List<String> listRows = list.getListRows();
        var customField = list.findRowSegmentByValue("Custom Field", listRows.get(0)).fileUpload();
        File fileFromResource = getFileFromResource("FILE_1.txt");
        customField.setValue(fileFromResource);
        assertThat(customField.getValue()).isFile();
    }

    @SneakyThrows
    private File getFileFromResource(String value) {
        ClassLoader classLoader = getClass().getClassLoader();
        URL resource = classLoader.getResource(value);

        if (resource == null) {
            throw new IllegalArgumentException("file is not found!");
        } else {
            return new File(resource.getFile());
        }
    }
}
