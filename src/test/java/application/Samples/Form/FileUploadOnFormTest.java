package application.Samples.Form;

import application.common.Text;
import application.config.BaseTestForSamples;
import core.config.Constants;
import core.element.PlatformApp;
import core.element.widget.field.type.fileUpload.FileUpload;
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

import static io.qameta.allure.SeverityLevel.CRITICAL;
import static io.qameta.allure.SeverityLevel.MINOR;
import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("Form. Checking the basic functions for the FileUpload in the widget Form")
@Epic("application/Samples")
@Tag("application/Samples")
@Tag("Form")
public class FileUploadOnFormTest extends BaseTestForSamples {

	@Test
	@Tag("Positive")
	@DisplayName("Test for getting the Placeholder value")
	@Description("The test gets the value from the placeholder attribute and returns it in String format")
	void placeholder() {
		var form = PlatformApp
				.screen("FileUpload placeholder")
				.secondLevelView("Form")
				.form("Form title");
		form.fileUpload("Custom Field")
				.checkPlaceholderSupported(ips -> assertThat(ips).isTrue())
				.checkPlaceholder(ips -> assertThat(ips).isEqualTo("Placeholder text"));
	}

	@Test
	@Tag("Positive")
	@DisplayName("A test to get the field color value in Hex format")
	@Description("The test gets the value from the style attribute in RGB format, and then converts it to Hex format")
	void color() {
		var form = PlatformApp
				.screen("FileUpload color")
				.secondLevelView("Form")
				.form("Form title");
		form.fileUpload("Custom Field")
				.checkColor(color -> assertThat(color).isNull());
	}

	@Test
	@Tag("Positive")
	@DisplayName("A test to check the field for \"Read-only\"")
	@Description("The test checks for the disabled attribute")
	void readonly() {
		var form = PlatformApp
				.screen("FileUpload readonly")
				.secondLevelView("Form")
				.form("Form title");
		form.fileUpload("Custom Field")
				.checkReadOnly(iro -> assertThat(iro).isTrue());
	}

	@Test
	@Severity(CRITICAL)
	@Tag("Positive")
	@DisplayName("A test for setting a value in a field")
	@Description("The test sets the value in the field, and then checks the value in the field with what should be set")
	void edit() {
		File upload = getFileFromResource("FILE_1.txt");
		var form = PlatformApp.screen("FileUpload basic")
				.secondLevelView("Form")
				.form("Form title");
		form.fileUpload("Custom Field")
				.setValue(upload)
				.popup()
				.checkFileNameAndStatusUpload(ns -> assertThat(ns).isEqualTo(List.of(Pair.of("FILE_1.txt", "done"))))
				.close();
	}

	@Disabled
	@Test
	@Severity(MINOR)
	@Tag("Negative")
	@DisplayName("Filtering test")
	@Description("Filtering is not available for the Form widget")
	void filtration() {
	}

	@Test
	@Tag("Positive")
	@DisplayName("The DrillDown test")
	@Description("Checking the url before the transition and after the transition/click on a special element")
	void drillDown() {
		var form = PlatformApp
				.screen("FileUpload drillDown")
				.secondLevelView("Form")
				.form("Form title");
		form.fileUpload("Custom Field")
				.checkDrillDownSupported(ids -> assertThat(ids).isFalse());
	}

	@Test
	@Severity(CRITICAL)
	@Tag("Negative")
	@DisplayName("Business Exception Validation Test")
	@Description("The test sets the value in the field. After approval, the popup window, the title, the text in it, and the buttons are validated")
	void businessException() {
		var form = PlatformApp.screen("FileUpload validation business exception")
				.secondLevelView("Form")
				.form("Form title");
		var fileUpload = form.fileUpload("Custom Field");
		fileUpload.setValue(getFileFromResource("FILE_1.txt"))
				.popup()
				.close();
		form.errorPopup()
				.checkTitle(title -> assertThat(title).isEqualTo(Constants.ErrorPopup.TITLE))
				.checkMessage(message -> assertThat(message).isEqualTo(Constants.OnlyLetters))
				.close();
	}

	@Test
	@Severity(CRITICAL)
	@Tag("Negative")
	@DisplayName("Run-time exception validation test")
	@Description("The test sets the value in the field. After approval, the popup window, the title, the text in it, and the buttons are validated")
	void runtimeException() {
		var form = PlatformApp.screen("FileUpload validation runtime exception")
				.secondLevelView("Form")
				.form("Form title");
		var fileUpload = form.fileUpload("Custom Field");
		fileUpload.setValue(getFileFromResource("FILE_1.txt"))
				.popup()
				.close();
		form.errorPopup()
				.checkTitle(title -> assertThat(title).isEqualTo(Constants.ErrorPopup.TITLE))
				.checkMessage(message -> assertThat(message).isEqualTo(Constants.SystemError))
				.close();
	}

	@Test
	@Severity(CRITICAL)
	@Tag("Positive")
	@DisplayName("Confirmation Popup Validation Test")
	@Description("The test sets the value in the field. After approval, by clicking on the save button, the popup window, the title, the text in it, and the buttons are validated")
	void confirm() {
		var form = PlatformApp.screen("FileUpload validation confirm")
				.secondLevelView("Form")
				.form("Form title");
		var fileUpload = form.fileUpload("Custom Field");
		fileUpload.setValue(getFileFromResource("FILE_1.txt"))
				.popup()
				.close();
		form.actions().action("save").click();
		form.confirmPopup()
				.checkTitle(title -> assertThat(title).isEqualTo(Constants.ConfirmPopup.TITLE))
				.checkMessage(message -> assertThat(message).isEqualTo(Constants.SaveValue))
				.clickOk();
	}

	@Test
	@Severity(CRITICAL)
	@Tag("Negative")
	@DisplayName("Required Message validation test for one field")
	@Description("The test sets the value with the wrong data type in the field. After approval, it checks the text under the field, which informs about the correctness of the type of data entered")
	void fieldLevelValidationAnnotation() {
		File uploadFile = getFileFromResource("FILE_1.txt");
		var form = PlatformApp.screen("FileUpload validation field level annotation")
				.secondLevelView("Form")
				.form("Form title");
		var fileUpload = form.fileUpload("Custom Field");
		fileUpload.setValue(uploadFile)
				.popup()
				.close();
		form.actions().action("Save").click();
		fileUpload.checkRequired(rt -> assertThat(rt).isEqualTo(Constants.OnlyLetters));
	}

	@Test
	@Severity(CRITICAL)
	@Tag("Negative")
	@DisplayName("Required Message validation test for multiple fields")
	@Description("The test sets a value with the wrong data type in several fields for different widgets. After approval, it checks the text under the field, which informs about the correctness of the type of data entered")
	void fieldLevelValidation() {
		File uploadFile = getFileFromResource("FILE_1.txt");
		var form = PlatformApp.screen("FileUpload validation field level dynamic")
				.secondLevelView("Form")
				.form("Form title");
		var customField = form.fileUpload("Custom Field");
		var customFieldAdditional = new FileUpload<>(form, "Custom Field Additional");
		customField.setValue(uploadFile).popup().close();
		customFieldAdditional.setValue(uploadFile).popup().close();
		form.actions().action("Save").click();
		customField.checkRequired(rt -> assertThat(rt).isEqualTo(Text.textOnlyLetters("customField")));
		customFieldAdditional.checkRequired(rt -> assertThat(rt).isEqualTo(Text.textOnlyLetters("customFieldAdditional")));
	}

	@Disabled
	@Test
	@Severity(MINOR)
	@Tag("Negative")
	@DisplayName("Sorting test")
	@Description("Sorting is not available for the Form widget")
	void sorting() {
	}

	@Test
	@Severity(CRITICAL)
	@Tag("Negative")
	@DisplayName("Required Message text Verification field test")
	@Description("The test clears the field and clicks the Save button. Then validates the message that the field is required")
	void required() {
		var form = PlatformApp.screen("FileUpload required")
				.secondLevelView("Form")
				.form("Form title");
		var fileUpload = form.fileUpload("Custom Field");
		fileUpload.clear()
				.checkFileNameInField(fn -> assertThat(fn).isEmpty());
		form.actions().action("Save").click();
		fileUpload.checkRequired(rt -> assertThat(rt).isEqualTo(Constants.RequiredMessage));
	}

	@Test
	@Tag("Positive")
	@DisplayName("The test for deleting a file from a field")
	@Description("The test verifies that after clearing the field, it is empty")
	void clear() {
		File uploadFile = getFileFromResource("FILE_1.txt");
		var form = PlatformApp.screen("FileUpload basic")
				.secondLevelView("Form")
				.form("Form title");
		var fileUpload = form.fileUpload("Custom Field");
		fileUpload.setValue(uploadFile)
				.popup()
				.close()
				.checkFileName(ffn -> assertThat(ffn).isEqualTo("FILE_1.txt"))
				.clear()
				.checkNoFileInField();
	}

	@Test
	@Severity(CRITICAL)
	@Tag("Positive")
	@DisplayName("A test to compare the downloaded file with the template")
	@Description("The test checks the downloaded file with the template file that is contained in the resources")
	void compare() {
		File expected = getFileFromResource("FILE_1.txt");
		File uploadFile = getFileFromResource("FILE_1.txt");
		var form = PlatformApp.screen("FileUpload basic")
				.secondLevelView("Form")
				.form("Form title");
		form.fileUpload("Custom Field")
				.setValue(uploadFile)
				.popup()
				.close()
				.checkValue(af -> assertThat(af)
						.isFile()
						.hasFileName("FILE_1.txt")
						.hasContent("Test data")
						.hasSameBinaryContentAs(expected)
						.hasSameBinaryContentAs(uploadFile));
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
