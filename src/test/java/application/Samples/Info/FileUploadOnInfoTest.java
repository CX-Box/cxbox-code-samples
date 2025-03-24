package application.Samples.Info;

import core.ConfigTest.BaseTestForSamples;
import core.MainPages;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Severity;
import lombok.SneakyThrows;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.selenide.videorecorder.junit5.VideoRecorderExtension;

import java.io.File;
import java.net.URL;

import static io.qameta.allure.SeverityLevel.CRITICAL;
import static io.qameta.allure.SeverityLevel.MINOR;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("Info. Checking the basic functions for the FileUp")
@Epic("application/Samples")
@Tag("application/Samples")
@ExtendWith(VideoRecorderExtension.class)
public class FileUploadOnInfoTest extends BaseTestForSamples {

    @Test
    @Tag("Positive")
    @DisplayName("Test for getting the Placeholder value")
    @Description("The InfoWidget doesn't have a Placeholder.")
    void placeholder() {
        MainPages.click("Fileupload placeholder");
        MainPages.FirstLevelMenu.click("Info");
        var info = page.findInfoWidgetByTitle("Info title");
        var customField = info.fileUpload("Custom Field");
        assertThatThrownBy(customField::getPlaceholder).isInstanceOf(UnsupportedOperationException.class);
    }

    @Test
    @Tag("Positive")
    @DisplayName("A test to get the field color value in Hex format")
    @Description("InfoWidget does not have a Hex field color for this type.")
    void color() {
        MainPages.click("Fileupload color");
        MainPages.FirstLevelMenu.click("Info");
        var info = page.findInfoWidgetByTitle("Info title");
        var customField = info.fileUpload("Custom Field");
        assertThatThrownBy(customField::getHexColor).isInstanceOf(UnsupportedOperationException.class);
    }

    @Test
    @Tag("Positive")
    @DisplayName("A test to check the field for \"Read-only\"")
    @Description("Info Widget is always read-only")
    void readonly() {
        MainPages.click("Fileupload readonly");
        MainPages.FirstLevelMenu.click("Info");
        var info = page.findInfoWidgetByTitle("Info title");
        var customField = info.fileUpload("Custom Field");
        assertThatThrownBy(customField::getReadOnly).isInstanceOf(UnsupportedOperationException.class);
    }

    @Test
    @Tag("Positive")
    @DisplayName("The test for getting the value from the field")
    void read() {
        MainPages.click("Fileupload basic");
        MainPages.FirstLevelMenu.click("Info");
        var info = page.findInfoWidgetByTitle("Info title");
        var customField = info.fileUpload("Custom Field");
        assertThat(customField.getValue().getName()).isEqualTo("FILE_1.txt");
    }

    @Test
    @Severity(MINOR)
    @Tag("Negative")
    @DisplayName("Filtering test")
    @Description("Filtering is not available for InfoWidget.")
    void filtration() {
        MainPages.click("Fileupload filtration");
        MainPages.FirstLevelMenu.click("Info");
        var info = page.findInfoWidgetByTitle("Info title");
        var customField = info.fileUpload("Custom Field");
        assertThatThrownBy(customField::setFiltration).isInstanceOf(UnsupportedOperationException.class);
    }

    @Test
    @Tag("Positive")
    @DisplayName("The DrillDown test")
    @Description("DrillDown is not available for InfoWidget.")
    void drillDown() {
        MainPages.click("Fileupload drilldown");
        MainPages.FirstLevelMenu.click("Info");
        var info = page.findInfoWidgetByTitle("Info title");
        var customField = info.fileUpload("Custom Field");
        assertThatThrownBy(customField::drillDown).isInstanceOf(UnsupportedOperationException.class);
    }

    @Test
    @Severity(MINOR)
    @Tag("Negative")
    @DisplayName("Sorting test")
    @Description("Sorting is not available for InfoWidget.")
    void sorting() {
        MainPages.click("Fileupload filtration");
        MainPages.FirstLevelMenu.click("Info");
        var info = page.findInfoWidgetByTitle("Info title");
        var customField = info.fileUpload("Custom Field");
        assertThatThrownBy(customField::setSorting).isInstanceOf(UnsupportedOperationException.class);
    }

    @Test
    @Severity(CRITICAL)
    @Tag("Positive")
    @DisplayName("A test to compare the source file with the downloaded one")
    void compare() {

        File fileFromResource = getFileFromResource("FILE_1.txt");

        MainPages.click("Fileupload basic");
        MainPages.FirstLevelMenu.click("Info");
        var info = page.findInfoWidgetByTitle("Info title");
        var customField = info.fileUpload("Custom Field");
        File file = customField.getValue();
        assertThat(file).isFile();
        assertThat(customField.getValueName()).isEqualTo("FILE_1.txt");
        assertThat(file).hasContent("Test data");
    }

    @Test
    @Severity(MINOR)
    @Tag("Positive")
    @DisplayName("Test to get the name of the downloaded file")
    void getFileName() {
        MainPages.click("Fileupload basic");
        MainPages.FirstLevelMenu.click("Info");
        var info = page.findInfoWidgetByTitle("Info title");
        var customField = info.fileUpload("Custom Field");
        assertThat(customField.getValueName()).isEqualTo("FILE_1.txt");
    }

    @Test
    @Severity(MINOR)
    @Tag("Positive")
    @DisplayName("The test for getting the file name in the field")
    void readNameFileInField() {
        MainPages.click("Fileupload basic");
        MainPages.FirstLevelMenu.click("Info");
        var info = page.findInfoWidgetByTitle("Info title");
        var customField = info.fileUpload("Custom Field");
        assertThat(customField.getNameFileInField()).isEqualTo("FILE_1.txt");
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
