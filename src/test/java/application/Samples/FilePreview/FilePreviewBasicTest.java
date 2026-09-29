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

/** The FilePreview widget: the file next to the form, the title and the place of the widget on the view. */
@DisplayName("FilePreview. Basic")
@Epic("Samples")
@Feature(FilePreviewBasicTest.ARTICLE)
@Tag("Samples")
@Tag("FilePreview")
public class FilePreviewBasicTest extends BaseTestForSamples {

	static final String ARTICLE = "widget/type/filepreview";

	@Test
	@Severity(CRITICAL)
	@Tag("Positive")
	@DisplayName("The file is shown next to the form")
	@Description("The fileUpload field with preview.mode inline is shown as the file itself, the header shows the file name")
	void basic() {
		var viewer = PlatformApp.screen("FilePreview basic").secondLevelView("FilePreview Inline")
				.filePreview("FilePreview").viewer();
		assertThat(viewer.getTitle()).isEqualTo("Contract.pdf");
		assertThat(viewer.getMessage()).isEmpty();
		DocShots.png(ARTICLE, "filepreview.png", 1660, 760);
	}

	@Test
	@Severity(CRITICAL)
	@Tag("Positive")
	@DisplayName("Fullscreen")
	@Description("Fullscreen in the header opens the file on the whole screen, the cross returns to the view")
	void fullscreen() {
		var viewer = PlatformApp.screen("FilePreview basic").secondLevelView("FilePreview Inline")
				.filePreview("FilePreview").viewer();
		viewer.getTitle();
		DocShots.gif(ARTICLE, "fullscreen.gif", 1660, 760, DocShots.Frame.WITH_SIDEBAR);
		viewer.switchFullscreenMode();
		viewer.closeFullscreen();
		DocShots.stop();
		assertThat(viewer.getTitle()).isEqualTo("Contract.pdf");
	}

	@Test
	@Tag("Positive")
	@DisplayName("Constant title")
	void constantTitle() {
		var preview = PlatformApp.screen("FilePreview title").secondLevelView("FilePreview const title")
				.filePreview("Constant Title");
		preview.viewer().getTitle();
		DocShots.png(ARTICLE, "consttitle.png", 1660, 760);
	}

	@Test
	@Tag("Positive")
	@DisplayName("Empty title")
	void emptyTitle() {
		var preview = PlatformApp.screen("FilePreview title").secondLevelView("FilePreview empty title")
				.filePreviewByName("MyExample5007FilePreviewTitleEmpty");
		preview.viewer().getTitle();
		DocShots.png(ARTICLE, "emptytitle.png", 1660, 760);
	}

	@Test
	@Tag("Positive")
	@DisplayName("Calculated title color")
	void titleColor() {
		var preview = PlatformApp.screen("FilePreview colortitle").secondLevelView("calc")
				.filePreviewByName("MyExample5004FilePreviewCalc");
		preview.viewer().getTitle();
		DocShots.png(ARTICLE, "colorwidget.png", 1660, 760);
	}

	@Test
	@Tag("Positive")
	@DisplayName("Only the first FilePreview of the view is shown")
	@Description("The widget always takes the right half of the view; a second FilePreview on the view is not shown")
	void onlyFirstWidget() {
		var view = PlatformApp.screen("FilePreview layout").secondLevelView("Two widgets FilePreview");
		view.filePreviewByName("MyExample5005FilePreview").checkVisible(visible -> assertThat(visible).isTrue());
		view.filePreviewByName("MyExample5005FilePreviewOther").checkVisible(visible -> assertThat(visible).isFalse());
	}

}
