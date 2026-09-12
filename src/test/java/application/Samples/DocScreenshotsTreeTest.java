package application.Samples;

import application.config.BaseTestForSamples;
import application.config.props.Env;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import core.element.PlatformApp;
import core.element.screen.view.PlatformView;
import core.element.widget.tree.TreeNavigation;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.condition.EnabledIfSystemProperty;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

/**
 * Takes the screenshots for the Tree documentation with the test core API.
 * Disabled by default; run with -DdocScreenshots=true.
 */
@Tag("DocScreenshots")
@EnabledIfSystemProperty(named = "docScreenshots", matches = "true")
public class DocScreenshotsTreeTest extends BaseTestForSamples {

	private static final Path DOC = Path.of("C:/idea/cxbox-doc/docs/widget/type/tree");

	private static final Path PROPERTY = Path.of("C:/idea/cxbox-doc/docs/widget/type/property");

	@BeforeAll
	static void size() {
		Configuration.browserSize = "1600x1000";
	}

	private static PlatformView open(String screen, String view) {
		Selenide.open(Env.uri() + "screen/" + screen + "/view/" + view);
		Selenide.sleep(4000);
		return PlatformApp.currentScreen().view();
	}

	private static void shot(SelenideElement element, String file) throws IOException {
		shot(DOC, element, file);
	}

	private static void shot(Path dir, SelenideElement element, String file) throws IOException {
		Selenide.sleep(700);
		File png = element.shouldBe(Condition.visible).screenshot();
		Files.createDirectories(dir);
		Files.copy(png.toPath(), dir.resolve(file), StandardCopyOption.REPLACE_EXISTING);
	}

	@Test
	void lazyLoad() throws IOException {
		var tree = open("myexample3261", "myexample3281tree").treeByName("MyExample3281Tree");
		shot(tree.element(), "lazyload_collapsed.png");
		tree.rows().row(0).expandRow();
		shot(tree.element(), "lazyload.png");
	}

	@Test
	void fields() throws IOException {
		var tree = open("myexample3261", "myexample3261allfieldstree").treeByName("MyExample3262AllFields");
		shot(tree.element(), "fields.png");
	}

	@Test
	void createInline() throws IOException {
		var tree = open("myexample3265", "myexample3265tree").treeByName("MyExample3265Tree");
		tree.actions().click("Add");
		shot(tree.element(), "create_inline.png");
	}

	@Test
	void createInlineForm() throws IOException {
		var tree = open("myexample3265", "myexample3279tree").treeInlineFormByName("MyExample3279Tree");
		tree.actions().click("Add");
		shot(tree.element(), "create_inline_form.png");
	}

	@Test
	void createWithView() throws IOException {
		var tree = open("myexample3265", "myexample3266tree").treeByName("MyExample3266Tree");
		tree.actions().click("Add");
		Selenide.sleep(2000);
		shot(PlatformApp.currentScreen().view().formByName("MyExample3266Form").element(), "create_with_view.png");
	}

	@Test
	void editInline() throws IOException {
		var tree = open("myexample3265", "myexample3273tree").treeByName("MyExample3273Tree");
		tree.rows().clickRow(2);
		shot(tree.element(), "edit_inline.png");
	}

	@Test
	void editInlineForm() throws IOException {
		var tree = open("myexample3265", "myexample3275tree").treeInlineFormByName("MyExample3275Tree");
		tree.rows().row(1).clickPencil();
		shot(tree.element(), "edit_inline_form.png");
	}

	@Test
	void columns() throws IOException {
		var tree = open("myexample3268", "myexample3268tree").treeByName("MyExample3268Tree");
		shot(tree.settings().open(), "columns_menu.png");
		tree.settings().close();
		shot(open("myexample3268", "myexample3268listhidden").treeByName("MyExample3268TreeHiddenFields").element(), "columns_hidden.png");
		shot(open("myexample3268", "myexample3268listaddedfields").treeByName("MyExample3268TreeAddedFields").element(), "columns_added.png");
		shot(open("myexample3268", "myexample3268listallfields").treeByName("MyExample3268TreeAllFields").element(), "columns_all.png");
	}

	@Test
	void searchModes() throws IOException {
		var tree = open("myexample3261", "myexample3261list").treeByName("myexample3261TreeList");
		tree.waitLoaded();
		tree.headers().clearFilters();
		tree.waitLoaded();
		tree.headers().filter(fb -> fb.input("Departments", "team"));
		tree.waitLoaded();
		shot(tree.element(), "search_collapse.png");
		tree.unallocatedRows().row(0).restorePath();
		shot(tree.element(), "search_restored.png");
		tree.settings().select("Hide");
		tree.waitLoaded();
		shot(tree.element(), "search_hide.png");
		shot(tree.settings().open(), "search_modes_menu.png");
		tree.settings().close();
	}

	@Test
	void more() throws IOException {
		var tree = open("myexample3261", "myexample3261list").treeByName("myexample3261TreeList");
		tree.waitLoaded();
		tree.headers().clearFilters();
		tree.waitLoaded();
		tree.pagination().nextPage();
		shot(tree.element(), "more_root.png");
		tree.rows().streamAllPages()
				.filter(r -> r.isExpandable())
				.filter(r -> !r.expandRow().pagination().isLastPage())
				.findFirst().orElseThrow();
		shot(tree.element(), "more_loaded.png");
		shot(open("myexample3861", "myexample3860tree").treeByName("MyExample3860Tree").element(), "more_hasnext.png");
		shot(open("myexample3861", "myexample3861tree").treeByName("MyExample3861Tree").element(), "more_smart.png");
	}

	@Test
	void sorting() throws IOException {
		var tree = open("myexample3261", "myexample3281tree").treeByName("MyExample3281Tree");
		tree.rows().row(0).expandRow();
		shot(tree.element(), "sorting_before.png");
		tree.headers().sort(sb -> sb.sort("Custom Field"));
		tree.waitLoaded();
		shot(tree.element(), "sorting.png");
	}

	@Test
	void editWithView() throws IOException {
		var tree = open("myexample3265", "myexample3274tree").treeByName("MyExample3274Tree");
		tree.rows().clickRow(0).burgerAction("Edit").click();
		Selenide.sleep(2000);
		shot(PlatformApp.currentScreen().view().formByName("MyExample3274Form").element(), "edit_with_view.png");
	}

	/** Tree tabs of the property articles (defaultlimitpage, filtration). */
	@Test
	void properties() throws IOException {
		var tree = open("myexample359", "myexample359tree").treeByName("MyExample359Tree");
		shot(PROPERTY.resolve("defaultlimitpage"), tree.element(), "tree_default_limit.png");

		tree = open("myexample3616", "myexample3614tree").treeByName("MyExample3614Tree");
		TreeNavigation.fullTextSearch(tree.element(), "test data2", tree.getExpectations());
		tree.waitLoaded();
		shot(PROPERTY.resolve("filtration"), tree.element(), "fulltextsearch_tree.png");
	}

}
