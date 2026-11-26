package application.Samples.Feature.downloadProgress;

import static io.qameta.allure.SeverityLevel.CRITICAL;
import static org.assertj.core.api.Assertions.assertThat;

import application.config.BaseTestForSamples;
import core.config.Constants;
import core.element.PlatformApp;
import core.util.DocShots;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import java.io.File;
import java.util.List;
import lombok.SneakyThrows;
import org.apache.commons.lang3.tuple.Pair;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

//CXBOX-1470
@DisplayName("Download progress. The window of a file download")
@Epic("Samples")
@Feature(DownloadProgressTest.ARTICLE)
@Tag("Samples")
@Tag("FileUpload")
public class DownloadProgressTest extends BaseTestForSamples {

	static final String ARTICLE = "features/element/filestorage";

	private static final String RELEASE = "new/v3.0.2";

	@Test
	@Severity(CRITICAL)
	@Tag("Positive")
	@DisplayName("A file of a field is shown in the Download progress window")
	@Description("The test downloads the file of a fileUpload field on a List and checks its line in the Download progress window")
	void fieldFile() {
		var field = PlatformApp.screen("FileUpload basic")
				.secondLevelView("List")
				.listInline("List title")
				.rows()
				.clickRow(0)
				.fileUpload("Custom Field");
		field.getValue();
		PlatformApp.fileUploadPopups()
				.popup(Constants.FileUploadPopup.DOWNLOAD_TITLE)
				.checkFileNameAndStatusUpload(files -> assertThat(files).isEqualTo(List.of(Pair.of("FILE_1.pdf", "done"))));
		DocShots.png(ARTICLE, "download-progress.png", 1600, 1000);
		DocShots.png(RELEASE, "CXBOX-1470-after.png", 1600, 1000);
	}

	@Test
	@Tag("Positive")
	@DisplayName("A file of an action is shown in the Download progress window")
	@Description("The Export action gives a file with PostAction.downloadFile, the test checks its line in the Download progress window")
	void actionFile() {
		var csv = PlatformApp.screen("Administration")
				.secondLevelView("Dictionary")
				.groupingHierarchyInline("Dictionary configurable dictionary administration")
				.actions()
				.download("Export");
		PlatformApp.fileUploadPopups()
				.popup(Constants.FileUploadPopup.DOWNLOAD_TITLE)
				.checkFileNameAndStatusUpload(files -> assertThat(files).isEqualTo(List.of(Pair.of(csv.getName(), "done"))));
	}

	@Test
	@Tag("Positive")
	@DisplayName("The upload and the download of a field are shown in two windows")
	@Description("The test uploads a file to a field and downloads it at once: the Upload progress window of the field and the Download progress window are open together, each has its own line")
	void uploadAndDownload() {
		var field = PlatformApp.screen("FileUpload basic")
				.secondLevelView("Form")
				.form("Form title")
				.fileUpload("Custom Field");
		field.setValue(resourceFile("FILE_1.pdf")).getValue();
		assertThat(PlatformApp.fileUploadPopups().names())
				.containsExactlyInAnyOrder(Constants.FileUploadPopup.UPLOAD_TITLE, Constants.FileUploadPopup.DOWNLOAD_TITLE);
		field.popup()
				.checkTitle(title -> assertThat(title).isEqualTo(Constants.FileUploadPopup.UPLOAD_TITLE))
				.checkFileNameAndStatusUpload(files -> assertThat(files).isEqualTo(List.of(Pair.of("FILE_1.pdf", "done"))));
		PlatformApp.fileUploadPopups()
				.popup(Constants.FileUploadPopup.DOWNLOAD_TITLE)
				.checkFileNameAndStatusUpload(files -> assertThat(files).isEqualTo(List.of(Pair.of("FILE_1.pdf", "done"))));
	}

	@SneakyThrows
	static File resourceFile(String name) {
		return new File(DownloadProgressTest.class.getClassLoader().getResource(name).toURI());
	}

}
