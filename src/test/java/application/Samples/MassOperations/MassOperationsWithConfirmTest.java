package application.Samples.MassOperations;

import static core.element.widget.list.MassOperation.Result.FAIL;
import static core.element.widget.list.MassOperation.Result.SUCCESS;
import static io.qameta.allure.SeverityLevel.CRITICAL;
import static org.assertj.core.api.Assertions.assertThat;

import application.config.BaseTestForSamples;
import core.element.PlatformApp;
import core.element.screen.view.PlatformView;
import core.element.widget.list.MassOperation;
import core.util.DocShots;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

/** Mass operations with confirmation: the values of the confirmation form are written to all selected rows. */
@DisplayName("Mass operations with confirmation")
@Epic("Samples")
@Feature(MassOperationsWithConfirmTest.ARTICLE)
@Tag("Samples")
@Tag("MassOperations")
public class MassOperationsWithConfirmTest extends BaseTestForSamples {

	static final String ARTICLE = "widget/type/property/massoperations";

	static final String SCREEN = "Bulk (Mass) operations";

	@Test
	@Severity(CRITICAL)
	@Tag("Positive")
	@DisplayName("List: the values of the form go to the selected rows")
	@Description("Select rows, review, confirm with the form, view results: the row with the dictionary value Error fails, the others succeed")
	void list() {
		var list = view("Basic List widget").listInlineByName("myexample6101List");
		DocShots.gif(ARTICLE, "mass_list.gif", 1280, 800, DocShots.Frame.WITHOUT_SIDEBAR);
		list.actions().click("Mass Edit");
		var mass = list.massOperation();
		run(mass, "Low", "test data 2", "test data 3", "test data");
		DocShots.stop();
		assertThat(mass.results()).isEqualTo(Map.of("test data 2", SUCCESS, "test data 3", SUCCESS, "test data", FAIL));
		assertThat(mass.processed()).isEqualTo("Processed: 3 (2 Success, 1 Fail)");
		mass.click("Close");
		assertThat(mass.isActive()).isFalse();
	}

	@Test
	@Severity(CRITICAL)
	@Tag("Positive")
	@DisplayName("GroupingHierarchy: the values of the form go to the selected rows")
	@Description("The same steps in GroupingHierarchy: the rows are grouped by the dictionary field, the row of the group Error fails")
	void groupingHierarchy() {
		var gh = view("Basic GH").groupingHierarchyInlineByName("myexample6102GH");
		DocShots.gif(ARTICLE, "mass_gh.gif", 1280, 800, DocShots.Frame.WITHOUT_SIDEBAR);
		gh.actions().click("Mass Edit");
		var mass = gh.massOperation();
		run(mass, "High", "test data2", "test data6");
		DocShots.stop();
		assertThat(mass.results()).isEqualTo(Map.of("test data2", SUCCESS, "test data6", FAIL));
		assertThat(mass.processed()).isEqualTo("Processed: 2 (1 Success, 1 Fail)");
		mass.click("Close");
		assertThat(mass.isActive()).isFalse();
	}

	@Test
	@Tag("Positive")
	@DisplayName("Custom title and texts of the confirmation")
	@Description("PreAction.confirmWithWidget with title, yesText and noText: the confirmation shows them, the no button closes the mass operation")
	void customTitle() {
		var list = view("Custom Title on Confirm operation").listInlineByName("myexample6101ListTitle");
		list.actions().click("Mass Edit With Custom Text");
		var mass = list.massOperation()
				.select("test data 2")
				.click("Next")
				.click("Next");
		assertThat(mass.step()).isEqualTo("Confirm operation");
		assertThat(mass.confirmTitle()).isEqualTo("Mass Edit Title");
		mass.confirmClick("It is text no");
		assertThat(mass.isActive()).isFalse();
	}

	@Test
	@Tag("Positive")
	@DisplayName("Back and Cancel")
	@Description("Back returns to the previous step, Cancel leaves the mass-operation mode without changes")
	void backAndCancel() {
		var list = view("Basic List widget").listInlineByName("myexample6101List");
		list.actions().click("Mass Edit");
		var mass = list.massOperation().select("test data 4", "test data 5");
		assertThat(mass.step()).isEqualTo("Select rows");
		mass.click("Next");
		assertThat(mass.step()).isEqualTo("Review rows");
		assertThat(mass.rows()).containsExactlyInAnyOrder("test data 4", "test data 5");
		mass.click("Back");
		assertThat(mass.step()).isEqualTo("Select rows");
		mass.click("Cancel");
		assertThat(mass.isActive()).isFalse();
	}

	/** Steps 1-3: selects the rows, goes to the confirmation, sets the dictionary value and the checkbox, saves. */
	private static void run(MassOperation<?> mass, String dictionary, String... rows) {
		assertThat(mass.step()).isEqualTo("Select rows");
		mass.select(rows).click("Next");
		assertThat(mass.step()).isEqualTo("Review rows");
		assertThat(mass.rows()).containsExactlyInAnyOrder(rows);
		mass.click("Next");
		assertThat(mass.step()).isEqualTo("Confirm operation");
		mass.confirmDictionary("customFieldDictionary", dictionary)
				.confirmCheckbox("customFieldCheckbox", true)
				.confirmClick("Save");
		assertThat(mass.step()).isEqualTo("View results");
	}

	private static PlatformView view(String name) {
		var screen = PlatformApp.screen(SCREEN);
		screen.secondLevelView("with Confirm operation");
		return screen.thirdLevelView(name);
	}

}
