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

/** The FilePreview widget with a show condition by the current record. */
@DisplayName("FilePreview. Show condition")
@Epic("Samples")
@Feature(FilePreviewShowConditionTest.ARTICLE)
@Tag("Samples")
@Tag("FilePreview")
public class FilePreviewShowConditionTest extends BaseTestForSamples {

	static final String ARTICLE = FilePreviewBasicTest.ARTICLE;

	@Test
	@Severity(CRITICAL)
	@Tag("Positive")
	@DisplayName("Show condition by current entity")
	@Description("The file is shown while Show preview of the record is set; the condition is recalculated on save")
	void showConditionByCurrentEntity() {
		var view = PlatformApp.screen("FilePreview show condition").view();
		var form = view.formByName("MyExample5006Form");
		var preview = view.filePreviewByName("MyExample5006FilePreview");
		var showPreview = form.checkbox("Show preview");
		preview.checkVisible(visible -> assertThat(visible).isTrue());

		DocShots.gif(ARTICLE, "show_cond_current.gif", 1660, 760, DocShots.Frame.WITHOUT_SIDEBAR);
		showPreview.setValue(false);
		form.actions().action("Save").click();
		preview.checkVisible(visible -> assertThat(visible).isFalse());
		showPreview.setValue(true);
		form.actions().action("Save").click();
		preview.checkVisible(visible -> assertThat(visible).isTrue());
		DocShots.stop();
		assertThat(preview.viewer().getTitle()).isEqualTo("Contract.pdf");
	}

}
