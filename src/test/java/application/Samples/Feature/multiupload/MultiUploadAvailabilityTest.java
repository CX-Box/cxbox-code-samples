package application.Samples.Feature.multiupload;

import static io.qameta.allure.SeverityLevel.CRITICAL;
import static org.assertj.core.api.Assertions.assertThat;

import application.config.BaseTestForSamples;
import core.element.PlatformApp;
import core.element.screen.PlatformScreen;
import core.element.screen.view.PlatformView;
import core.element.widget.list.ListWidget;
import core.util.DocShots;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

@DisplayName("Multi-upload files. Availability of the button and the drag-and-drop zone")
@Epic("Samples")
@Feature(MultiUploadAvailabilityTest.ARTICLE)
@Tag("Samples")
@Tag("MultiUpload")
public class MultiUploadAvailabilityTest extends BaseTestForSamples {

	static final String ARTICLE = "widget/type/property/multiupload";

	private static final String SCREEN = "File options multi-upload files-availability";

	private static final String BUTTON = "Add Files";

	@Test
	@Severity(CRITICAL)
	@Tag("Positive")
	@DisplayName("Button and Multi-upload files: the task is closed, the button is hidden and the zone is disabled")
	@Description("The test opens the task, closes it and checks the button and the drag-and-drop zone, then opens the task again")
	void buttonAndMultiUpload() {
		var app = screen("Button And Multi-upload files");
		var view = app.thirdLevelView("Button and Multi-upload files");
		var list = view.listInline("List");
		setStatus(view, "Open");
		checkAvailable(list, true, true);
		setStatus(view, "Closed", "availability-default-and-file-upload-dnd.gif");
		checkAvailable(list, false, true);
		setStatus(view, "Open");
		checkAvailable(list, true, true);
	}

	@Test
	@Severity(CRITICAL)
	@Tag("Positive")
	@DisplayName("Button: the task is closed, the button is hidden")
	@Description("The test opens the task, closes it and checks the button, then opens the task again")
	void button() {
		var app = screen("Button And Multi-upload files");
		var view = app.thirdLevelView("Button");
		var list = view.listInline("List");
		setStatus(view, "Open");
		checkAvailable(list, true, false);
		setStatus(view, "Closed", "availability-default-mode.gif");
		checkAvailable(list, false, false);
		setStatus(view, "Open");
		checkAvailable(list, true, false);
	}

	@Test
	@Severity(CRITICAL)
	@Tag("Positive")
	@DisplayName("Multi-upload files: the task is closed, the zone is disabled")
	@Description("The test opens the task, closes it and checks the drag-and-drop zone, then opens the task again")
	void multiUpload() {
		var app = screen("Button And Multi-upload files");
		var view = app.thirdLevelView("Multi-upload files");
		var list = view.listInline("List");
		setStatus(view, "Open");
		list.fileUploadDnd().checkDisabled(disabled -> assertThat(disabled).isFalse());
		setStatus(view, "Closed", "availability-file-upload-dnd.gif");
		list.fileUploadDnd().checkDisabled(disabled -> assertThat(disabled).isTrue());
		setStatus(view, "Open");
		list.fileUploadDnd().checkDisabled(disabled -> assertThat(disabled).isFalse());
	}

	@Test
	@Severity(CRITICAL)
	@Tag("Positive")
	@DisplayName("List: the task is closed, the button is hidden and the zone is disabled")
	@Description("The test opens the task, closes it and checks the button and the drag-and-drop zone, then opens the task again")
	void list() {
		var view = screen("List").view();
		var list = view.listInline("List");
		setStatus(view, "Open");
		checkAvailable(list, true, true);
		setStatus(view, "Closed");
		checkAvailable(list, false, true);
		setStatus(view, "Open");
		checkAvailable(list, true, true);
	}

	@Test
	@Severity(CRITICAL)
	@Tag("Positive")
	@DisplayName("GroupingHierarchy: the task is closed, the button is hidden and the zone is disabled")
	@Description("The test opens the task, closes it and checks the button and the drag-and-drop zone, then opens the task again")
	void groupingHierarchy() {
		var view = screen("GroupingHierarchy").view();
		var gh = view.groupingHierarchyInline("Grouping Hierarchy");
		setStatus(view, "Open");
		checkAvailable(gh, true, true);
		setStatus(view, "Closed");
		checkAvailable(gh, false, true);
		setStatus(view, "Open");
		checkAvailable(gh, true, true);
	}

	private static PlatformScreen screen(String secondLevelView) {
		var app = PlatformApp.screen(SCREEN);
		app.secondLevelView(secondLevelView);
		return app;
	}

	private static void setStatus(PlatformView view, String status) {
		var task = view.form("Task");
		task.dictionary("Status").setValue(status);
		task.actions().click("Save");
	}

	/** The same, the saving goes to the GIF of the article: the status is chosen, Save, the button and the zone change. */
	private static void setStatus(PlatformView view, String status, String gif) {
		var task = view.form("Task");
		task.dictionary("Status").setValue(status);
		DocShots.gif(ARTICLE, gif, 1660, 900, DocShots.Frame.WITHOUT_SIDEBAR);
		task.actions().click("Save");
		DocShots.stop();
	}

	private static void checkAvailable(ListWidget<?, ?, ?> list, boolean available, boolean zone) {
		if (zone) {
			list.fileUploadDnd().checkDisabled(disabled -> assertThat(disabled).isEqualTo(!available));
		}
		list.actions().action(BUTTON).checkExist(exist -> assertThat(exist).isEqualTo(available));
	}

}
