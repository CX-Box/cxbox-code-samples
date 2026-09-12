package application.Samples;

import application.config.BaseTestForSamples;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import core.element.PlatformApp;
import core.element.screen.view.PlatformView;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.EnabledIfSystemProperty;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.List;

/**
 * Takes the screenshots for the pickTree and multivalueTree field articles with the test core API.
 * The file names repeat the images of the pickList / multivalue articles.
 * Disabled by default; run with -DdocScreenshots=true.
 */
@Tag("DocScreenshots")
@EnabledIfSystemProperty(named = "docScreenshots", matches = "true")
public class DocScreenshotsTreeFieldsTest extends BaseTestForSamples {

	private static final Path PICK_TREE = Path.of("C:/idea/cxbox-doc/docs/widget/fields/field/pickTree");

	private static final Path MULTIVALUE_TREE = Path.of("C:/idea/cxbox-doc/docs/widget/fields/field/multivalueTree");

	private static final String FIELD = "Custom Field";

	@BeforeAll
	static void size() {
		Configuration.browserSize = "1600x1000";
	}

	private static PlatformView open(String screen, String view) {
		PlatformApp.screen(screen).secondLevelView(view);
		Selenide.sleep(1500);
		return PlatformApp.currentScreen().view();
	}

	private static void shot(Path dir, SelenideElement element, String file) throws IOException {
		Selenide.sleep(700);
		File png = element.shouldBe(Condition.visible).screenshot();
		Files.createDirectories(dir);
		Files.copy(png.toPath(), dir.resolve(file), StandardCopyOption.REPLACE_EXISTING);
	}

	// ---------------------------------------------------------------- pickTree

	@Test
	void pickTreeBasics() throws IOException {
		var form = open("Picktree basic", "Form").form("Form title");
		var popup = form.pickTree(FIELD).openPopup();
		popup.loadNext();
		shot(PICK_TREE, popup.dialog(), "img_form.png");
		popup.close();
		shot(PICK_TREE, open("Picktree basic", "List").listInline("List title").element(), "img_list.png");
		shot(PICK_TREE, open("Picktree basic", "Info").info("Info title").element(), "img_info.png");
	}

	@Test
	void pickTreePlaceholder() throws IOException {
		shot(PICK_TREE, open("Picktree placeholder", "List").listInline("List title").element(), "img_plchldr_list.png");
		shot(PICK_TREE, open("Picktree placeholder", "Form").form("Form title").element(), "img_plchldr_form.png");
	}

	@Test
	void pickTreeColor() throws IOException {
		shot(PICK_TREE, open("Picktree color", "List").listInline("List title").element(), "img_color_list.png");
		shot(PICK_TREE, open("Picktree color", "Info").info("Info title").element(), "img_color_info.png");
	}

	@Test
	void pickTreeReadonly() throws IOException {
		shot(PICK_TREE, open("Picktree readonly", "List").listInline("List title").element(), "img_ro_list.png");
		shot(PICK_TREE, open("Picktree readonly", "Info").info("Info title").element(), "img_ro_info.png");
		shot(PICK_TREE, open("Picktree readonly", "Form").form("Form title").element(), "img_ro_form.png");
	}

	@Test
	void pickTreeFiltration() throws IOException {
		var list = open("Picktree filtration", "List").listInline("List title");
		list.headers().filter(fb -> fb.input(FIELD, "Abs"));
		Selenide.sleep(1500);
		shot(PICK_TREE, list.element(), "img_filtr_list.png");
	}

	@Test
	void pickTreeDrilldown() throws IOException {
		shot(PICK_TREE, open("Picktree drilldown", "List").listInline("List title").element(), "img_drilldown_list.png");
		shot(PICK_TREE, open("Picktree drilldown", "Info").info("Info title").element(), "img_drilldown_info.png");
	}

	@Test
	void pickTreeSorting() throws IOException {
		var list = open("Picktree sorting", "List").listInline("List title");
		list.headers().sort(sb -> sb.sort(FIELD));
		Selenide.sleep(1500);
		shot(PICK_TREE, list.element(), "img_sort_list.png");
	}

	@Test
	void pickTreeRequired() throws IOException {
		var list = open("Picktree required", "List").listInline("List title");
		var row = list.rows().clickRow(0);
		row.burgerAction("Save").click();
		Selenide.sleep(1000);
		shot(PICK_TREE, list.element(), "img_req_list.png");
		var form = open("Picktree required", "Form").form("Form title");
		form.actions().action("Save").click();
		Selenide.sleep(1000);
		shot(PICK_TREE, form.element(), "img_req_form.png");
	}

	@Test
	void pickTreeValidationForm() throws IOException {
		var form = open("Picktree validation business exception", "Form").form("Form title");
		form.pickTree(FIELD).setValue(FIELD, "1234");
		Selenide.sleep(1500);
		shot(PICK_TREE, Selenide.$("body"), "img_business_error.png");
		form.errorPopup().close();

		form = open("Picktree runtime", "Form").form("Form title");
		form.pickTree(FIELD).setValue(FIELD, "Test data");
		Selenide.sleep(1500);
		shot(PICK_TREE, Selenide.$("body"), "img_runtime_error.png");
		form.errorPopup().close();

		form = open("Picktree validation confirm", "Form").form("Form title");
		form.pickTree(FIELD).setValue(FIELD, "Test data");
		Selenide.sleep(1500);
		shot(PICK_TREE, Selenide.$("body"), "confirm_form.png");

		form = open("Picktree validation field level dynamic", "Form").form("Form title");
		form.pickTree(FIELD).setValue(FIELD, "Test data");
		form.actions().action("Save").click();
		Selenide.sleep(1500);
		shot(PICK_TREE, form.element(), "img_javax_stat_form.png");
	}

	@Test
	void pickTreeValidationList() throws IOException {
		var list = open("Picktree validation field level dynamic", "List").listInline("List title");
		var row = list.rows().clickRow(0);
		row.pickTree(FIELD).setValue(FIELD, "Test data");
		row.burgerAction("Save").click();
		Selenide.sleep(1500);
		shot(PICK_TREE, list.element(), "img_javax_stat_list.png");
	}

	// ---------------------------------------------------------------- multivalueTree

	@Test
	void multivalueTreeBasics() throws IOException {
		var form = open("MultivalueTree basic", "Form").form("Form title");
		var popup = form.multivalueTree(FIELD).openPopup();
		shot(MULTIVALUE_TREE, popup.dialog(), "img_form.png");
		popup.closeModal();
		shot(MULTIVALUE_TREE, open("MultivalueTree basic", "List").listInline("List title").element(), "img_list.png");
		shot(MULTIVALUE_TREE, open("MultivalueTree basic", "Info").info("Info title").element(), "img_info.png");
	}

	@Test
	void multivalueTreePlaceholder() throws IOException {
		shot(MULTIVALUE_TREE, open("MultivalueTree placeholder", "Form").form("Form title").element(), "img_plchldr_form.png");
	}

	@Test
	void multivalueTreeColor() throws IOException {
		shot(MULTIVALUE_TREE, open("MultivalueTree color", "List").listInline("List title").element(), "img_color_list.png");
	}

	@Test
	void multivalueTreeReadonly() throws IOException {
		shot(MULTIVALUE_TREE, open("MultivalueTree readonly", "List").listInline("List title").element(), "img_ro_list.png");
		shot(MULTIVALUE_TREE, open("MultivalueTree readonly", "Info").info("Info title").element(), "img_ro_info.png");
		shot(MULTIVALUE_TREE, open("MultivalueTree readonly", "Form").form("Form title").element(), "img_ro_form.png");
	}

	@Test
	void multivalueTreeRequired() throws IOException {
		var form = open("MultivalueTree required", "Form").form("Form title");
		form.multivalueTree(FIELD).clear(true);
		form.actions().action("Save").click();
		Selenide.sleep(1000);
		shot(MULTIVALUE_TREE, form.element(), "img_req_form.png");
	}

	@Test
	void multivalueTreeValidationForm() throws IOException {
		var form = open("MultivalueTree validation business exception", "Form").form("Form title");
		form.multivalueTree(FIELD).setValue(List.of("Abs data"));
		Selenide.sleep(1500);
		shot(MULTIVALUE_TREE, Selenide.$("body"), "img_business_error.png");
		form.errorPopup().close();

		form = open("MultivalueTree validation runtime exception", "Form").form("Form title");
		form.multivalueTree(FIELD).setValue(List.of("Abs data"));
		Selenide.sleep(1500);
		shot(MULTIVALUE_TREE, Selenide.$("body"), "img_runtime_error.png");
		form.errorPopup().close();

		form = open("MultivalueTree validation confirm", "Form").form("Form title");
		form.multivalueTree(FIELD).setValue(List.of("Abs data"));
		Selenide.sleep(1500);
		shot(MULTIVALUE_TREE, Selenide.$("body"), "confirm_form.png");

		form = open("MultivalueTree validation field level dynamic", "Form").form("Form title");
		form.multivalueTree(FIELD).setValue(List.of("Abs data"));
		form.actions().action("Save").click();
		Selenide.sleep(1500);
		shot(MULTIVALUE_TREE, form.element(), "img_javax_stat_form.png");
	}

	@Test
	void multivalueTreeSelection() throws IOException {
		var form = open("MultivalueTree basic", "Form").form("Form title");
		var popup = form.multivalueTree(FIELD).openPopup();
		popup.clearFilters();
		popup.row(FIELD, "Test group");
		popup.expand(FIELD, "Test group");
		popup.toggle(FIELD, "Test group");
		shot(MULTIVALUE_TREE, popup.dialog(), "img_selection_form.png");
		popup.closeModal();
	}

}
