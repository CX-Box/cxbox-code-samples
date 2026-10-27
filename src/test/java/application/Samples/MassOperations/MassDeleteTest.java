package application.Samples.MassOperations;

import static core.element.widget.list.MassOperation.Result.FAIL;
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
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

/**
 * Mass delete: the selected rows are deleted, a row that cannot be deleted gets Fail. Each test adds the row it deletes,
 * so the data of the sample stays the same.
 */
@DisplayName("Mass delete")
@Epic("Samples")
@Feature(MassDeleteTest.ARTICLE)
@Tag("Samples")
@Tag("MassOperations")
public class MassDeleteTest extends BaseTestForSamples {

	static final String ARTICLE = "widget/type/property/massoperations";

	@Test
	@Severity(CRITICAL)
	@Tag("Positive")
	@DisplayName("List: the selected rows are deleted")
	@Description("A new row and the row with the dictionary value Error are deleted: the new row is gone, the Error row fails and stays")
	void list() {
		var list = view("List").listInlineByName("myexample6101Delete");
		var name = newName();
		list.actions().click("Add");
		list.rows().row(0).input("customField").setValue(name);
		list.actions().click("Save");
		DocShots.gif(ARTICLE, "mass_delete.gif", 1280, 800, DocShots.Frame.WITHOUT_SIDEBAR);
		list.actions().click("Mass Delete");
		var mass = list.massOperation();
		run(mass, name, "test data");
		DocShots.stop();
		// a deleted record is not shown on the results step, the counter still has it
		assertThat(mass.results()).containsEntry("test data", FAIL).doesNotContainEntry(name, FAIL);
		assertThat(mass.processed()).isEqualTo("Processed: 2 (1 Success, 1 Fail)");
		mass.click("Close");
		assertThat(mass.rows()).contains("test data").doesNotContain(name);
	}

	@Test
	@Severity(CRITICAL)
	@Tag("Positive")
	@DisplayName("GroupingHierarchy: the selected rows are deleted")
	@Description("The same steps in GroupingHierarchy: the new row is gone, the row of the group Error fails and stays")
	void groupingHierarchy() {
		var gh = view("GroupingHierarchy").groupingHierarchyInlineByName("myexample6102DeleteGH");
		var name = newName();
		gh.actions().click("Add");
		gh.rows().row(0).input("customField").setValue(name);
		gh.actions().click("Save");
		DocShots.gif(ARTICLE, "mass_delete_gh.gif", 1280, 800, DocShots.Frame.WITHOUT_SIDEBAR);
		gh.actions().click("Mass Delete");
		var mass = gh.massOperation();
		run(mass, name, "test data6");
		DocShots.stop();
		// a deleted record is not shown on the results step, the counter still has it
		assertThat(mass.results()).containsEntry("test data6", FAIL).doesNotContainEntry(name, FAIL);
		assertThat(mass.processed()).isEqualTo("Processed: 2 (1 Success, 1 Fail)");
		mass.click("Close");
		assertThat(mass.rows()).contains("test data6").doesNotContain(name);
	}

	/** Steps 1-2: selects the rows, reviews them and applies the delete. */
	private static void run(MassOperation<?> mass, String... rows) {
		assertThat(mass.step()).isEqualTo("Select rows");
		mass.select(rows).click("Next");
		assertThat(mass.step()).isEqualTo("Review rows");
		mass.click("Apply");
		assertThat(mass.step()).isEqualTo("View results");
	}

	private static String newName() {
		return "to delete " + UUID.randomUUID().toString().substring(0, 4);
	}

	private static PlatformView view(String name) {
		var screen = PlatformApp.screen(MassOperationsWithConfirmTest.SCREEN);
		screen.secondLevelView("without Confirm operation");
		screen.thirdLevelView("Delete");
		return screen.fourthLevelView(name);
	}

}
