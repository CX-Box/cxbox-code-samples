package application.Samples.Tree;

import application.config.BaseTestForSamples;
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
	/** The screen title, the tabs of the second and third level (empty: none), the address of the view, the widget. */
	private static final String[][] TABS = {
			{"Widget property Filtration", "Widget property FullTextSearch", "Tree", "#/screen/myexample3616/view/myexample3614tree", "MyExample3614Tree"},
			{"Widget property Filtration", "Widget property personal filter group", "Tree", "#/screen/myexample3616/view/myexample3616tree", "MyExample3616Tree"},
			{"Widget property Filtration", "Widget property filter group", "Tree", "#/screen/myexample3616/view/myexample3618tree", "MyExample3618Tree"},
			{"Widget property Pagination", "nextAndPreviousWithHasNext", "Tree", "#/screen/myexample3861/view/myexample3860tree", "MyExample3860Tree"},
			{"Widget property Pagination", "nextAndPreviousSmart", "Tree", "#/screen/myexample3861/view/myexample3861tree", "MyExample3861Tree"},
			{"Widget property Pagination", "nextAndPreviousWithCount", "Tree", "#/screen/myexample3861/view/myexample3862tree", "MyExample3862Tree"},
			{"Widget property Pagination", "hideLimitOptions", "Tree", "#/screen/myexample3861/view/myexample3865tree", "MyExample3865Tree"},
			{"Widget property Pagination", "availableLimitsList", "Tree", "#/screen/myexample3861/view/myexample3867tree", "MyExample3867Tree"},
			{"Widget property export Excel inner source", "List", "", "#/screen/myexample3134/view/myexample3134tree", "MyExample3134Tree"},
			{"Widget property export Excel any source", "", "", "#/screen/myexample3136", "MyExample3136Tree"},
			{"Widget property export Excel postAction", "Tree", "", "#/screen/MyExample6500PostActionExportToExcel/view/myexample6500PostActionExportToExcelTree", "myexample6500PostActionExportToExcelTree"},
			{"Widget property field setHidden", "Family List, Assoc, Popup, 2D, 1D", "Tree", "#/screen/myexample5019/view/myexample5019tree", "MyExample5019Tree"},
	};

	@Test
	@Severity(CRITICAL)
	@Tag("Positive")
	@DisplayName("Every Tree tab of the property samples opens and its root expands")
	@Description("The root rows are loaded; a root with children is expanded and shows them")
	void everyTabShowsATree() {
		for (String[] tab : TABS) {
			var screen = PlatformApp.screen(tab[0]);
			var view = tab[1].isEmpty() ? screen.view() : screen.secondLevelView(tab[1]);
			if (!tab[2].isEmpty()) {
				view = screen.thirdLevelView(tab[2]);
			}
			view.checkUrl(url -> assertThat(url).contains(tab[3]));
			// TODO CXBOX-1394: a tree opened by a tab after a view of the same bc stays empty until the page is reloaded
			Selenide.refresh();
			PlatformTreeWidgetInline tree = view.treeByName(tab[4]);
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
