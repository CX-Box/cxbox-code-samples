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

/** Mass operations without confirmation: Apply on the step "Review rows" executes the action. */
@DisplayName("Mass operations without confirmation")
@Epic("Samples")
@Feature(MassOperationsWithoutConfirmTest.ARTICLE)
@Tag("Samples")
@Tag("MassOperations")
public class MassOperationsWithoutConfirmTest extends BaseTestForSamples {

	static final String ARTICLE = "widget/type/property/massoperations/withoutconfirm";

	@Test
	@Severity(CRITICAL)
	@Tag("Positive")
	@DisplayName("List: Apply sets the checkbox in the selected rows")
	@Description("Select rows, review, Apply: the row with the dictionary value Error fails, the others succeed")
	void list() {
		var list = view("List").listInlineByName("myexample6101CheckboxTrueList");
		DocShots.gif(ARTICLE, "mass_list_without_confirm.gif", 1280, 800, DocShots.Frame.WITHOUT_SIDEBAR);
		list.actions().click("Mass Set Checkbox true");
		var mass = list.massOperation();
		run(mass, "test data 4", "test data 5", "test data");
		DocShots.stop();
		assertThat(mass.results()).isEqualTo(Map.of("test data 4", SUCCESS, "test data 5", SUCCESS, "test data", FAIL));
		assertThat(mass.processed()).isEqualTo("Processed: 3 (2 Success, 1 Fail)");
		mass.click("Close");
		assertThat(mass.isActive()).isFalse();
	}

	@Test
	@Severity(CRITICAL)
	@Tag("Positive")
	@DisplayName("GroupingHierarchy: Apply sets the checkbox in the selected rows")
	@Description("The same steps in GroupingHierarchy: the rows are grouped by the dictionary field, the row of the group Error fails")
	void groupingHierarchy() {
		var gh = view("GroupingHierarchy").groupingHierarchyInlineByName("myexample6102CheckboxTrueGH");
		DocShots.gif(ARTICLE, "mass_gh_without_confirm.gif", 1280, 800, DocShots.Frame.WITHOUT_SIDEBAR);
		gh.actions().click("Mass Set Checkbox true");
		var mass = gh.massOperation();
		run(mass, "test data3", "test data5", "test data6");
		DocShots.stop();
		assertThat(mass.results()).isEqualTo(Map.of("test data3", SUCCESS, "test data5", SUCCESS, "test data6", FAIL));
		assertThat(mass.processed()).isEqualTo("Processed: 3 (2 Success, 1 Fail)");
		mass.click("Close");
		assertThat(mass.isActive()).isFalse();
	}

	/** Steps 1-2: selects the rows, reviews them and applies the action: there is no confirmation step. */
	private static void run(MassOperation<?> mass, String... rows) {
		assertThat(mass.step()).isEqualTo("Select rows");
		mass.select(rows).click("Next");
		assertThat(mass.step()).isEqualTo("Review rows");
		assertThat(mass.rows()).containsExactlyInAnyOrder(rows);
		mass.click("Apply");
		assertThat(mass.step()).isEqualTo("View results");
	}

	private static PlatformView view(String name) {
		var screen = PlatformApp.screen(MassOperationsWithConfirmTest.SCREEN);
		screen.secondLevelView("without Confirm operation");
		screen.thirdLevelView("Basic");
		return screen.fourthLevelView(name);
	}

}
