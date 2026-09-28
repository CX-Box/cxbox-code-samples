package application.Samples.FilePreview;

import application.config.BaseTestForSamples;
import core.element.PlatformApp;
import core.util.DocShots;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.SeverityLevel.CRITICAL;
import static org.assertj.core.api.Assertions.assertThat;

/** Additional properties of the FilePreview widget: the header, switching the records, AdditionalInfo widgets. */
@DisplayName("FilePreview. Additional properties")
@Epic("Samples")
@Feature(FilePreviewPropertiesTest.ARTICLE)
@Tag("Samples")
@Tag("FilePreview")
public class FilePreviewPropertiesTest extends BaseTestForSamples {

	static final String ARTICLE = FilePreviewBasicTest.ARTICLE;

	@Test
	@Severity(CRITICAL)
	@Tag("Positive")
	@DisplayName("The header shows fields of the record")
	@Description("preview.titleKey and preview.hintKey replace the file name in the header")
	void header() {
		var viewer = PlatformApp.screen("FilePreview header").view().filePreview("FilePreview").viewer();
		assertThat(viewer.getTitle()).isEqualTo("Service contract No 15");
		assertThat(viewer.getHint()).isEqualTo("Signed on 1 September");
		DocShots.png(ARTICLE, "header.png", 1660, 760);
	}

	@Test
	@Severity(CRITICAL)
	@Tag("Positive")
	@DisplayName("The arrows switch the records")
	@Description("The arrows under the file switch the current record: pdf and png are shown, txt cannot be viewed, the record without a file shows a message")
	void switchRecords() {
		var viewer = PlatformApp.screen("FilePreview records").view().filePreview("FilePreview").viewer();
		assertThat(viewer.getTitle()).isEqualTo("Contract.pdf");
		assertThat(viewer.getPagePagination()).isEqualTo("1 of 4");

		DocShots.gif(ARTICLE, "records.gif", 1660, 760, DocShots.Frame.WITHOUT_SIDEBAR);
		viewer.clickPaginationButton("right", 1);
		assertThat(viewer.getTitle()).isEqualTo("Floor plan.png");
		assertThat(viewer.getMessage()).isEmpty();
		viewer.clickPaginationButton("right", 1);
		assertThat(viewer.getTitle()).isEqualTo("Meeting notes.txt");
		assertThat(viewer.getMessage()).isEqualTo("This file type cannot be viewed");
		viewer.clickPaginationButton("right", 1);
		assertThat(viewer.getPagePagination()).isEqualTo("4 of 4");
		assertThat(viewer.getMessage()).isEqualTo("There is no file in this row");
		DocShots.stop();

		viewer.clickPaginationButton("left", 1);
		assertThat(viewer.getTitle()).isEqualTo("Meeting notes.txt");
	}

	@Test
	@Tag("Positive")
	@DisplayName("With AdditionalInfo widgets")
	@Description("The AdditionalInfo widgets take the right quarter of the view, FilePreview takes a half of the rest")
	void withAdditionalInfo() {
		var view = PlatformApp.screen("FilePreview with AdditionalInfo").view();
		assertThat(view.filePreview("FilePreview").viewer().getTitle()).isEqualTo("Contract.pdf");
		view.additionalInfo("AdditionalInfo").checkVisible(visible -> assertThat(visible).isTrue());
		DocShots.png(ARTICLE, "additionalinfo.png", 1660, 760);
	}

}
