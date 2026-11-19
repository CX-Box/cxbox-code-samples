package application.Samples.Tree;

import application.config.BaseTestForSamples;
import core.element.PlatformApp;
import core.util.DocShots;
import com.codeborne.selenide.Selenide;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.SeverityLevel.CRITICAL;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * Tree article, section "Show condition", show condition by parent entity: the parent tree and the child tree whose
 * records belong to the selected parent record.
 */
@DisplayName("Tree. Show condition by parent entity")
@Epic("Samples")
@Feature(TreeShowConditionTest.ARTICLE)
@Tag("Samples")
@Tag("Tree")
public class TreeShowConditionTest extends BaseTestForSamples {

	static final String ARTICLE = "widget/type/tree";

	private static final String CHILD_FIELD = "Custom Field, bc - myExampleBc3277";

	/** Parent rows: Root 5 (Custom Field Number 7), Root 4 (2), Root 3 (7). The child tree is shown for a number over 5. */
	private static final int ROOT_5 = 0;

	private static final int ROOT_4 = 1;

	private static final int ROOT_3 = 2;

	@Test
	@Severity(CRITICAL)
	@Tag("Positive")
	@DisplayName("Show condition by parent entity")
	@Description("The child tree is shown while Custom Field Number of the selected parent record is greater than 5")
	void showConditionByParentEntity() {
		var view = PlatformApp.screen("Tree widget show condition")
				.secondLevelView("Show condition by parent entity")
				.checkUrl(url -> assertThat(url).contains("#/screen/myexample3269/view/myexample3276showcond"));
		var parent = view.treeByName("myexample3276parent").waitLoaded();
		var child = view.treeByName("myexample3277child");

		// the picture of the article starts with the child tree shown
		parent.rows().clickRow(ROOT_3);
		child.checkVisible(visible -> assertThat(visible).isTrue());

		DocShots.gif(ARTICLE, "show_cond.gif", 1280, 1480, DocShots.Frame.WITHOUT_SIDEBAR);
		parent.rows().clickRow(ROOT_4);
		child.checkVisible(visible -> assertThat(visible).isFalse());
		parent.rows().clickRow(ROOT_3);
		child.checkVisible(visible -> assertThat(visible).isTrue());
		DocShots.stop();
		Selenide.Wait().withMessage("the child tree shows the one root of Root 3").until(driver -> child.rows().element().size() == 1);
		assertThat(child.rows().row(0).input(CHILD_FIELD).getValue()).isEqualTo("Node of Root 3 (with children)");
	}

	@Test
	@Severity(CRITICAL)
	@Tag("Positive")
	@DisplayName("Another parent record: the child tree shows only its records")
	@Description("A branch of the child tree is expanded for Root 3; after Root 5 is selected the child tree has only the rows of Root 5")
	void anotherParentRecord() {
		var view = PlatformApp.screen("Tree widget show condition").secondLevelView("Show condition by parent entity");
		var parent = view.treeByName("myexample3276parent").waitLoaded();
		var child = view.treeByName("myexample3277child");

		parent.rows().clickRow(ROOT_3);
		Selenide.Wait().withMessage("the child tree shows the one root of Root 3").until(driver -> child.rows().element().size() == 1);
		var node = child.rows().row(0);
		node.expandRow();
		assertThat(node.rows().streamCurrentPage().map(row -> row.input(CHILD_FIELD).getValue()))
				.containsExactlyInAnyOrder("Child 1 of Node of Root 3", "Child 2 of Node of Root 3");

		parent.rows().clickRow(ROOT_5);
		Selenide.Wait().withMessage("the child tree shows the five roots of Root 5").until(driver -> child.rows().element().size() == 5);
		assertThat(child.rows().streamCurrentPage().map(row -> row.input(CHILD_FIELD).getValue()))
				.containsExactlyInAnyOrder("Root 1 without children", "Root 2 (without children)", "Root 3 (without children)",
						"Root 4 (without children)", "Root 5 (with children)");
	}

}
