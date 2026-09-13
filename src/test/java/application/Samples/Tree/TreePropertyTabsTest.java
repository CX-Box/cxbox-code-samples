package application.Samples.Tree;

import application.config.BaseTestForSamples;
import application.config.props.Env;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import core.element.PlatformApp;
import core.element.widget.list.realization.inline.tree.PlatformTreeWidgetInline;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.SeverityLevel.CRITICAL;
import static org.assertj.core.api.Assertions.assertThat;

/** The Tree tabs of the widget property samples: every tab shows a tree whose root can be expanded. */
@DisplayName("Tree. The Tree tabs of the widget property samples")
@Epic("Samples")
@Feature(TreePropertyTabsTest.ARTICLE)
@Tag("Samples")
@Tag("Tree")
public class TreePropertyTabsTest extends BaseTestForSamples {

	static final String ARTICLE = "widget/type/tree";

	/** screen, view, tree widget */
	private static final String[][] TABS = {
			{"myexample3616", "myexample3614tree", "MyExample3614Tree"},
			{"myexample3616", "myexample3616tree", "MyExample3616Tree"},
			{"myexample3616", "myexample3618tree", "MyExample3618Tree"},
			{"myexample3861", "myexample3860tree", "MyExample3860Tree"},
			{"myexample3861", "myexample3861tree", "MyExample3861Tree"},
			{"myexample3861", "myexample3862tree", "MyExample3862Tree"},
			{"myexample3861", "myexample3865tree", "MyExample3865Tree"},
			{"myexample3861", "myexample3867tree", "MyExample3867Tree"},
			{"myexample3134", "myexample3134tree", "MyExample3134Tree"},
			{"myexample3136", "myexample3136tree", "MyExample3136Tree"},
			{"MyExample6500PostActionExportToExcel", "myexample6500PostActionExportToExcelTree", "myexample6500PostActionExportToExcelTree"},
			{"myexample5019", "myexample5019tree", "MyExample5019Tree"},
	};

	@Test
	@Severity(CRITICAL)
	@Tag("Positive")
	@DisplayName("Every Tree tab of the property samples opens and its root expands")
	@Description("The root rows are loaded; a root with children is expanded and shows them")
	void everyTabShowsATree() {
		for (String[] tab : TABS) {
			Selenide.open(Env.uri() + "screen/" + tab[0] + "/view/" + tab[1]);
			Selenide.sleep(2500);
			PlatformTreeWidgetInline tree = PlatformApp.currentScreen().view().treeByName(tab[2]);
			// the first request of a sample after the start of the application is slow
			tree.element().shouldBe(Condition.visible, tree.getExpectations().getTimeout().multipliedBy(10));
			tree.waitLoaded();
			assertThat(tree.rows().element().size()).as(tab[1] + ": root rows").isPositive();
			var root = tree.rows().row(0);
			if (root.isExpandable()) {
				root.expandRow();
				assertThat(root.rows().element().size()).as(tab[1] + ": children of the root").isPositive();
			} else {
				assertThat(tree.rows().element().size()).as(tab[1] + ": a single root without children").isEqualTo(1);
			}
		}
	}

}
