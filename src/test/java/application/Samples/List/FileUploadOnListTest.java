package application.Samples.List;

import application.common.Text;
import application.config.BaseTestForSamples;
import core.config.Constants;
import core.element.PlatformApp;
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
import java.util.stream.Collectors;

import static io.qameta.allure.SeverityLevel.CRITICAL;
import static io.qameta.allure.SeverityLevel.MINOR;
import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("List. Checking the basic functions for the FileUpload in the widget List")
@Epic("Samples")
@Tag("Samples")
@Tag("List")
public class FileUploadOnListTest extends BaseTestForSamples {

	@Disabled("Checked at filtration and sorting")
	@Test
	@Severity(CRITICAL)
	@Tag("Positive")
	@DisplayName("A test for checking a value in a field")
	@Description("The test gets the value in the field, and then checks the value in the field with what should be.")
	void read() {
//        MainPages.click("FileUpload basic");
//        MainPages.FirstLevelMenu.click("List");
//        var list = $box.findListWidgetByTitle("List title");
//        List<String> listRows = list.getNoFocusValues("Custom Field");
//        var customField = list.findRowSegmentByValue("Custom Field", listRows.get(0)).fileUpload();
//        assertThat(customField.compareRows("FILE_1.txt")).isTrue();
	}

	@Test
	@Tag("Positive")
	@DisplayName("Test for getting the Placeholder value")
	@Description("The test gets the value from the placeholder attribute and returns it in String format")
	void placeholder() {
		var list = PlatformApp.screen("FileUpload placeholder")
				.secondLevelView("List")
				.listInline("List title");
		var row = list.rows().clickRow(0);
		row.fileUpload("Custom Field")
				.checkPlaceholder(expectedPlaceholder -> assertThat(expectedPlaceholder).isEqualTo("Placeholder text"));
	}

	@Test
	@Tag("Positive")
	@DisplayName("A test to get the field color value in Hex format")
	@Description("The test gets the value from the style attribute in RGB format, and then converts it to Hex format")
	void color() {
		var list = PlatformApp.screen("FileUpload color")
				.secondLevelView("List")
				.listInline("List title");
		var row = list.rows().clickRow(0);
		row.fileUpload("Custom Field")
				.checkColor(color -> assertThat(color).isNull());
	}

	@Test
	@Tag("Positive")
	@DisplayName("A test to check the field for \"Read-only\"")
	@Description("The test checks for the disabled attribute.")
	void readonly() {
		var list = PlatformApp.screen("FileUpload readonly")
				.secondLevelView("List")
				.listInline("List title");
		var row = list.rows().clickRow(0);
		row.fileUpload("Custom Field")
				.checkReadOnly(ro -> assertThat(ro).isTrue());
	}

	@Test
	@Severity(CRITICAL)
	@Tag("Positive")
	@DisplayName("A test for setting a value in a field")
	@Description("The test sets the value in the field, and then checks the value in the field with what should be set.")
	void edit() {
		File fileFromResource = getFileFromResource("FILE_1.txt");
		var list = PlatformApp.screen("FileUpload basic")
				.secondLevelView("List")
				.listInline("List title");
		var row = list.rows().clickRow(0);
		row.fileUpload("Custom Field")
				.setValue(fileFromResource)
				.popup().checkFileNameAndStatusUpload(lfs -> assertThat(lfs).isEqualTo(List.of(Pair.of("FILE_1.txt", "done")))).close()
				.checkValue(af -> assertThat(af)
						.isFile()
						.hasFileName("FILE_1.txt")
						.hasSameBinaryContentAs(fileFromResource));
	}

	@Test
	@Severity(MINOR)
	@Tag("Negative")
	@DisplayName("Filtering test")
	@Description("Filtering by the specified column.")
	void filtration() {
		var list = PlatformApp.screen("FileUpload filtration")
				.secondLevelView("List")
				.listInline("List title");
		list.headers().filter(fb -> fb.fileUpload("Custom Field", "1"));
		var actualData = list.rows().streamCurrentPage()
				.map(r -> r.fileUpload("Custom Field").getFileNameInField())
				.collect(Collectors.toList());
		assertThat(actualData).isEqualTo(List.of("FILE_1.txt"));
	}

	@Test
	@Tag("Positive")
	@DisplayName("The DrillDown test")
	@Description("Checking the url before the transition and after the transition/click on a special element")
	void drillDown() {
		var list = PlatformApp.screen("FileUpload drillDown")
				.secondLevelView("List")
				.listInline("List title");
		var row = list.rows().clickRow(0);
		row.fileUpload("Custom Field")
				.checkDrillDownSupported(ids -> assertThat(ids).isFalse());
	}

	@Test
	@Severity(CRITICAL)
	@Tag("Negative")
	@DisplayName("Business Exception Validation Test")
	@Description("The test sets the value in the field. After approval, the popup window, the title, the text in it, and the buttons are validated.")
	void businessException() {
		File fileFromResource = getFileFromResource("FILE_1.txt");
		var list = PlatformApp.screen("FileUpload validation business exception")
				.secondLevelView("List")
				.listInline("List title");
		var row = list.rows().clickRow(0);
		row.fileUpload("Custom Field")
				.setValue(fileFromResource).popup().close();
		list.errorPopup()
				.checkTitleAndMessage(
						title -> assertThat(title).isEqualTo(Constants.ErrorPopup.TITLE),
						message -> assertThat(message).isEqualTo(Constants.OnlyLetters))
				.close();
	}

	@Test
	@Severity(CRITICAL)
	@Tag("Negative")
	@DisplayName("Run-time exception validation test")
	@Description("The test sets the value in the field. After approval, the popup window, the title, the text in it, and the buttons are validated.")
	void runtimeException() {
		File fileFromResource = getFileFromResource("FILE_1.txt");
		var list = PlatformApp.screen("FileUpload validation runtime exception")
				.secondLevelView("List")
				.listInline("List title");
		var row = list.rows().clickRow(0);
		row.fileUpload("Custom Field")
				.setValue(fileFromResource).popup().close();
		list.errorPopup()
				.checkTitleAndMessage(
						title -> assertThat(title).isEqualTo(Constants.ErrorPopup.TITLE),
						message -> assertThat(message).isEqualTo(Constants.SystemError))
				.close();
	}

	@Test
	@Severity(CRITICAL)
	@Tag("Positive")
	@DisplayName("Confirmation Popup Validation Test")
	@Description("The test sets the value in the field. After approval, by clicking on the save button, the popup window, the title, the text in it, and the buttons are validated.")
	void confirm() {
		File fileFromResource = getFileFromResource("FILE_1.txt");
		var list = PlatformApp.screen("FileUpload validation confirm")
				.secondLevelView("List")
				.listInline("List title");
		var row = list.rows().clickRow(0);
		row.fileUpload("Custom Field")
				.setValue(fileFromResource).popup().close();
		row.burgerAction("save").click();
		list.confirmPopup()
				.checkTitleAndMessage(
						title -> assertThat(title).isEqualTo(Constants.ConfirmPopup.TITLE),
						message -> assertThat(message).isEqualTo(Constants.SaveValue))
				.clickOk();
	}

	@Test
	@Severity(CRITICAL)
	@Tag("Negative")
	@DisplayName("Required Message validation test for one field")
	@Description("The test sets the value with the wrong data type in the field. After approval, it checks the text under the field, which informs about the correctness of the type of data entered.")
	void fieldLevelValidationAnnotation() {
		File fileFromResource = getFileFromResource("FILE_1.txt");
		var list = PlatformApp.screen("FileUpload validation field level annotation")
				.secondLevelView("List")
				.listInline("List title");
		var row = list.rows().clickRow(0);
		var customField = row.fileUpload("Custom Field");
		customField
				.setValue(fileFromResource).popup().close();
		row.burgerAction("Save").click();
		customField
				.checkRequired(message -> assertThat(message).isEqualTo(Constants.OnlyLetters));
	}

	@Test
	@Severity(CRITICAL)
	@Tag("Negative")
	@DisplayName("Required Message validation test for multiple fields")
	@Description("The test sets a value with the wrong data type in several fields for different widgets. After approval, it checks the text under the field, which informs about the correctness of the type of data entered")
	void fieldLevelValidation() {
		File fileFromResource = getFileFromResource("FILE_1.txt");
		File fileFromResource0 = getFileFromResource("FILE_7405.txt");
		var list = PlatformApp.screen("FileUpload validation field level dynamic")
				.secondLevelView("List")
				.listInline("List title");
		var row = list.rows().clickRow(0);
		var customField = row.fileUpload("Custom Field");
		var customFieldAdditional = row.fileUpload("Custom Field Additional");
		customField.setValue(fileFromResource).popup().close();
		customFieldAdditional.setValue(fileFromResource0).popup().close();
		row.burgerAction("Save").click();
		customField.checkRequired(message -> assertThat(message).isEqualTo(Text.textOnlyLetters("customField")));
		customFieldAdditional.checkRequired(message -> assertThat(message).isEqualTo(Text.textOnlyLetters("customFieldAdditional")));
	}

	@Test
	@Severity(MINOR)
	@Tag("Negative")
	@DisplayName("Sorting test")
	@Description("Sorting by the specified column.")
	void sorting() {
		List<String> expectedValue = List.of("IMG_5867.jpg", "IMG_5866.jpg", "IMG_5865.jpg");
		var list = PlatformApp.screen("FileUpload sorting")
				.secondLevelView("List")
				.listInline("List title");
		var headers = list.headers();
		var actualData = list.rows().streamAllPages()
				.map(r -> r.fileUpload("Custom Field").getFileNameInField())
				.collect(Collectors.toList());
		assertThat(actualData).isEqualTo(expectedValue);

		headers.sort(sb -> sb.sort("Custom Field"));
		assertThat(list.rows().streamAllPages()
				.map(r -> r.fileUpload("Custom Field").getFileNameInField())
				.collect(Collectors.toList())).isEqualTo(expectedValue);

		headers.sort(sb -> sb.sort("Custom Field"));
		expectedValue = List.of("IMG_5865.jpg", "IMG_5866.jpg", "IMG_5867.jpg");
		assertThat(list.rows().streamAllPages()
				.map(r -> r.fileUpload("Custom Field").getFileNameInField())
				.collect(Collectors.toList())).isEqualTo(expectedValue);
	}

	@Test
	@Severity(CRITICAL)
	@Tag("Negative")
	@DisplayName("Required Message text Verification field test")
	@Description("The test clears the field and clicks the Save button. Then validates the message that the field is required.")
	void required() {
		var list = PlatformApp.screen("FileUpload required")
				.secondLevelView("List")
				.listInline("List title");
		var row = list.rows().clickRow(0);
		var customField = row.fileUpload("Custom Field");
		customField.clear();
		row.burgerAction("Save").click();
		customField
				.checkRequired(message -> assertThat(message).isEqualTo(Constants.RequiredMessage));
	}

	@Test
	@Tag("Positive")
	@DisplayName("The test for deleting a file from a field")
	@Description("The test verifies that after clearing the field, it is empty.")
	void clear() {
		File fileFromResource = getFileFromResource("FILE_1.txt");
		var list = PlatformApp.screen("FileUpload basic")
				.secondLevelView("List")
				.listInline("List title");
		var row = list.rows().clickRow(0);
		var customField = row.fileUpload("Custom Field");
		customField
				.setValue(fileFromResource).popup().close()
				.checkValue(file -> assertThat(file).isFile().hasFileName("FILE_1.txt"));
		customField.clear()
				.checkFieldIsEmpty(ie -> assertThat(ie).isTrue());
	}

	@Test
	@Severity(CRITICAL)
	@Tag("Positive")
	@DisplayName("A test to compare the downloaded file with the template")
	@Description("The test checks the downloaded file with the template file that is contained in the resources")
	void compare() {
		File fileFromResource = getFileFromResource("FILE_1.txt");
		var list = PlatformApp.screen("FileUpload basic")
				.secondLevelView("List")
				.listInline("List title");
		var row = list.rows().clickRow(0);
		row.fileUpload("Custom Field")
				.setValue(fileFromResource).popup().close()
				.checkValue(file -> assertThat(file).isFile().hasFileName("FILE_1.txt").hasSameBinaryContentAs(fileFromResource));
	}

	@Test
	void setValueGetValue() {
		File fileFromResource = getFileFromResource("FILE_1.txt");
		var list = PlatformApp.screen("FileUpload basic")
				.secondLevelView("List")
				.listInline("List title");
		var row = list.rows().clickRow(0);
		row.fileUpload("Custom Field")
				.setValue(fileFromResource).popup().close()
				.checkValue(file -> assertThat(file).isFile().hasFileName("FILE_1.txt"));
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
