package application.Samples;

import application.config.BaseTestForSamples;
import com.codeborne.selenide.HighlightOptions;
import core.element.PlatformApp;
import core.element.widget.form.PlatformInlineFormWidget;
import core.element.widget.list.realization.inline.list.PlatformListRowsInline;
import core.element.widget.statblock.StatsBlock;
import core.element.widget.statblock.StatsBlockWidget;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.time.LocalDate;
import java.util.UUID;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DisplayName("Checking the functions for bug fix")
@Epic("Samples")
@Tag("Samples")
public class BugFixTests extends BaseTestForSamples {

	@Test
	@DisplayName("Include Id when No Fields In Widgets On Bc ")
	@Description("Id field should be automatically added to the API response when no fields of the Business Component (BC) are added to widgets on the screen during the initial load. Check when the BC has no visible fields but acts as a parent BC, child bc data should load")
	public void testIncludeIdWhenNoFieldsInWidgetsOnBc () {
	//CXBOX-1242
	var list = PlatformApp.screen("ShowCondition example")
			.view()
			.listInline("Child Bc");
	var row = list.rows().clickRow(0);
	row.text("Custom Field");
	}

	@Test
	@DisplayName("Row menu of the second list on a view")
	@Description("The view has two lists, each with the row menu. The test changes a row of the second list and saves it by the row menu of this list.")
	public void rowMenuOfSecondList() {
		//CXBOX-1371
		var list = PlatformApp.screen("List widget title")
				.secondLevelView("List widget empty title")
				.listInlineByName("myexample3104emptytitle");
		var row = list.rows().clickRow(0);
		row.input("Custom Field widget2: Empty Title").setValue("Row menu of the second list");
		row.burgerAction("Save").click();
		list.rows().row(0)
				.input("Custom Field widget2: Empty Title")
				.checkValue(value -> assertThat(value).isEqualTo("Row menu of the second list"));
	}

	@Test
	@DisplayName("Bulk upload: the error of each file in the upload progress")
	@Description("Two files of one bulk upload fail with different errors: a business error (error.popup) and a server error (errorMessage). The line of each file in the window of the upload progress shows the error of its own answer, not the standard text.")
	public void bulkUploadShowsErrorOfEachFile() throws IOException {
		//CXBOX-1038
		var list = PlatformApp.screen("Upload errors")
				.secondLevelView("Upload errors")
				.listInlineByName("myexample3701list");
		var business = file("upload-error-business");
		var server = file("upload-error-server");
		var progress = list.actions().uploadWithoutCheck("Add Files", business, server);

		assertThat(progress.status(business.getName())).isEqualTo("error");
		assertThat(progress.status(server.getName())).isEqualTo("error");
		assertThat(progress.statusInformation(business.getName()))
				.isEqualTo("File " + business.getName() + " is rejected: the size is over the limit of the sample");
		assertThat(progress.statusInformation(server.getName()))
				.contains("File " + server.getName() + " is not saved: the file storage is not available");
		assertThat(progress.tooltip(business.getName()))
				.isEqualTo("File " + business.getName() + " is rejected: the size is over the limit of the sample");
		assertThat(progress.tooltip(server.getName()))
				.contains("File " + server.getName() + " is not saved: the file storage is not available");
	}

	@Test
	@DisplayName("Single file upload: the error of the file in the upload progress")
	@Description("The upload of a file to the field fails with a server error (errorMessage). The line of the file in the window of the upload progress shows this error, not the standard text.")
	public void singleUploadShowsErrorOfFile() throws IOException {
		//CXBOX-1038
		var form = PlatformApp.screen("Upload errors")
				.secondLevelView("Upload errors")
				.formByName("myexample3701form");
		var server = file("upload-error-server");
		var progress = form.fileUpload("Custom Field File").uploadWithoutCheck(server);

		assertThat(progress.status(server.getName())).isEqualTo("error");
		assertThat(progress.tooltip(server.getName()))
				.contains("File " + server.getName() + " is not saved: the file storage is not available");
	}

	/**
	 * A copy of {@code FILE_1.pdf}: the name starts with the prefix of an error of the sample "Upload errors"
	 */
	private static File file(String prefix) throws IOException {
		var file = Files.createTempDirectory("upload-error").resolve(prefix + "-" + UUID.randomUUID() + ".pdf");
		try (var pdf = BugFixTests.class.getClassLoader().getResourceAsStream("FILE_1.pdf")) {
			Files.copy(pdf, file);
		}
		return file.toFile();
	}
}
