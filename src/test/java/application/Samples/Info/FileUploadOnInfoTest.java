package application.Samples.Info;

import application.config.BaseTestForSamples;
import core.element.PlatformApp;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Severity;
import lombok.SneakyThrows;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.net.URL;

import static io.qameta.allure.SeverityLevel.CRITICAL;
import static io.qameta.allure.SeverityLevel.MINOR;
import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("Info. Checking the basic functions for the FileUp")
@Epic("application/Samples")
@Tag("application/Samples")
public class FileUploadOnInfoTest extends BaseTestForSamples {

	@Disabled
	@Test
	@Tag("Positive")
	@DisplayName("Test for getting the Placeholder value")
	@Description("The InfoWidget doesn't have a Placeholder.")
	void placeholder() {
	}

	@Disabled
	@Test
	@Tag("Positive")
	@DisplayName("A test to get the field color value in Hex format")
	@Description("InfoWidget does not have a Hex field color for this type.")
	void color() {
	}

	@Disabled
	@Test
	@Tag("Positive")
	@DisplayName("A test to check the field for \"Read-only\"")
	@Description("Info Widget is always read-only")
	void readonly() {
	}

	@Disabled
	@Test
	@Severity(MINOR)
	@Tag("Negative")
	@DisplayName("Filtering test")
	@Description("Filtering is not available for InfoWidget.")
	void filtration() {
	}

	@Disabled
	@Test
	@Tag("Positive")
	@DisplayName("The DrillDown test")
	@Description("DrillDown is not available for InfoWidget.")
	void drillDown() {
	}

	@Disabled
	@Test
	@Severity(MINOR)
	@Tag("Negative")
	@DisplayName("Sorting test")
	@Description("Sorting is not available for InfoWidget.")
	void sorting() {
	}

	@Test
	@Tag("Positive")
	@DisplayName("The test for getting the value from the field")
	void read() {
		var info = PlatformApp.screen("Fileupload basic")
				.secondLevelView("Info")
				.info("Info title");
		info.fileUpload("Custom Field")
				.checkFileNameInField(file -> assertThat(file).isEqualTo("FILE_1.txt"));
	}

	@Test
	@Severity(CRITICAL)
	@Tag("Positive")
	@DisplayName("A test to compare the source file with the downloaded one")
	void compare() {
		File fileFromResource = getFileFromResource("FILE_1.txt");
		var info = PlatformApp.screen("Fileupload basic")
				.secondLevelView("Info")
				.info("Info title");
		var fileUpload = info.fileUpload("Custom Field");
		fileUpload.checkValue(file -> assertThat(file)
				.isFile()
				.hasContent("Test data"));
		fileUpload.checkFileName(name -> assertThat(name).isEqualTo("FILE_1.txt"));
	}

	@Test
	@Severity(MINOR)
	@Tag("Positive")
	@DisplayName("Test to get the name of the downloaded file")
	void getFileName() {
		var info = PlatformApp.screen("Fileupload basic")
				.secondLevelView("Info")
				.info("Info title");
		info.fileUpload("Custom Field")
				.checkFileName(name -> assertThat(name).isEqualTo("FILE_1.txt"));
	}

	@Test
	@Severity(MINOR)
	@Tag("Positive")
	@DisplayName("The test for getting the file name in the field")
	void readNameFileInField() {
		var info = PlatformApp.screen("Fileupload basic")
				.secondLevelView("Info")
				.info("Info title");
		info.fileUpload("Custom Field")
				.checkFileNameInField(name -> assertThat(name).isEqualTo("FILE_1.txt"));
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
