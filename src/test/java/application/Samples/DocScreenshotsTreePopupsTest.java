package application.Samples;

import application.config.BaseTestForSamples;
import application.config.props.Env;
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

/**
 * Takes the screenshots for the AssocTreePopup and PickTreePopup articles with the test core API.
 * Disabled by default; run with -DdocScreenshots=true.
 */
@Tag("DocScreenshots")
@EnabledIfSystemProperty(named = "docScreenshots", matches = "true")
public class DocScreenshotsTreePopupsTest extends BaseTestForSamples {

	private static final Path ASSOC = Path.of("C:/idea/cxbox-doc/docs/widget/type/assoctreepopup");

	private static final Path PICK = Path.of("C:/idea/cxbox-doc/docs/widget/type/picktreepopup");

	private static final String DEPARTMENTS = "Departments";

	@BeforeAll
	static void size() {
		Configuration.browserSize = "1600x1000";
	}

	private static PlatformView open(String screen, String view) {
		Selenide.open(Env.uri() + "screen/" + screen + "/view/" + view);
		Selenide.sleep(4000);
		return PlatformApp.currentScreen().view();
	}

	private static void shot(Path dir, SelenideElement element, String file) throws IOException {
		Selenide.sleep(700);
		File png = element.shouldBe(Condition.visible).screenshot();
		Files.createDirectories(dir);
		Files.copy(png.toPath(), dir.resolve(file), StandardCopyOption.REPLACE_EXISTING);
	}

	// ---------------------------------------------------------------- AssocTreePopup

	@Test
	void assocBasics() throws IOException {
		var list = open("myexample3330", "myexample3330list").listByName("MyExample3330List");
		shot(ASSOC, list.element(), "assoc_list.png");
		shot(ASSOC, list.element(), "assoc_list_button.png");
		var form = open("myexample3330", "myexample3330form").formByName("MyExample3330Form");
		shot(ASSOC, form.element(), "assoc_form.png");
		var popup = form.multivalueTree("Custom Field").openPopup();
		shot(ASSOC, popup.dialog(), "choose_assoc.png");
		popup.closeModal();
	}

	@Test
	void assocButton() throws IOException {
		var form = open("myexample3333", "myexample3333form").formByName("MyExample3333Form");
		shot(ASSOC, form.element(), "choose_button.png");
		form.actions().action("Popup Assoc").click();
		Selenide.sleep(1500);
		shot(ASSOC, Selenide.$("body"), "up_assoc.png");
	}

	@Test
	void assocTitle() throws IOException {
		var form = open("myexample3336", "myexample3336title").formByName("MyExample3336WithTitle");
		var popup = form.multivalueTree("Custom Field Multivalue").openPopup();
		shot(ASSOC, popup.dialog(), "consttitle.png");
		popup.closeModal();
		form = open("myexample3336", "myexample3336emptytitle").formByName("MyExample3336EmptyTitle");
		popup = form.multivalueTree("Custom Field Multivalue").openPopup();
		shot(ASSOC, popup.dialog(), "empytitle.png");
		popup.closeModal();
	}

	@Test
	void assocColor() throws IOException {
		var form = open("myexample3329", "myexample3332color").formByName("MyExample3332Color");
		var popup = form.multivalueTree("Custom Field Multi").openPopup();
		shot(ASSOC, popup.dialog(), "colorwidget.png");
		popup.closeModal();
	}

	@Test
	void assocActions() throws IOException {
		var form = open("myexample3331", "myexample3331save").formByName("MyExample3331Save");
		var popup = form.multivalueTree("Custom Field").openPopup();
		shot(ASSOC, popup.dialog(), "assoc_create_inline.png");
		shot(ASSOC, popup.dialog(), "assoc_create_with_widget.png");
		shot(ASSOC, popup.dialog(), "assoc_edit_basic.png");
		popup.closeModal();
		form = open("myexample3331", "myexample3331delete").formByName("MyExample3331Delete");
		popup = form.multivalueTree("Custom Field").openPopup();
		shot(ASSOC, popup.dialog(), "actiondelete.png");
		popup.closeModal();
	}

	@Test
	void assocLazyLoadAndSearch() throws IOException {
		var form = open("myexample3261", "myexample3261list").formByName("MyExample3263List");
		var popup = form.multivalueTree("Departments Assoc").openPopup();
		popup.expand(DEPARTMENTS, "Полномочия Минстроя России");
		shot(ASSOC, popup.dialog(), "lazyload.png");
		popup.fullTextSearch("team");
		shot(ASSOC, popup.dialog(), "search_collapse.png");
		popup.settings().select("Hide");
		Selenide.sleep(1500);
		shot(ASSOC, popup.dialog(), "search_hide.png");
		popup.closeModal();
	}

	@Test
	void assocSelection() throws IOException {
		var form = open("myexample3261", "myexample3261list").formByName("MyExample3263List");
		var popup = form.multivalueTree("Departments Assoc").openPopup();
		popup.expand(DEPARTMENTS, "Полномочия Минстроя России");
		popup.toggle(DEPARTMENTS, "Полномочия Минстроя России");
		shot(ASSOC, popup.dialog(), "selection_group.png");
		popup.toggle(DEPARTMENTS, "Градостроительство и перепланировка (регионы)");
		if (popup.confirm().isShown()) {
			popup.confirm().ok();
		}
		shot(ASSOC, popup.dialog(), "selection_manual.png");
		popup.toggle(DEPARTMENTS, "Полномочия Минстроя России");
		Selenide.sleep(500);
		popup.element().$("button[data-test-widget-tree-show-more]").click();
		Selenide.sleep(1000);
		shot(ASSOC, Selenide.$("body"), "selection_confirm.png");
		if (popup.confirm().isShown()) {
			popup.confirm().cancel();
		}
		popup.closeModal();
	}

	// ---------------------------------------------------------------- PickTreePopup

	@Test
	void pickBasics() throws IOException {
		var form = open("myexample3282", "myexample3282form").form("Form title");
		var popup = form.pickTree("Custom Field").openPopup();
		popup.loadNext();
		shot(PICK, popup.dialog(), "pickTreePopupBasic.png");
		popup.close();
	}

	@Test
	void pickTitle() throws IOException {
		var form = open("myexample3344", "myexample3344form").formByName("MyExample3344Form");
		var popup = form.pickTree("Custom Field").openPopup();
		shot(PICK, popup.dialog(), "pickTreePopupWithTitle.png");
		popup.close();
		form = open("myexample3344", "myexample3345form").formByName("MyExample3345Form");
		popup = form.pickTree("Custom Field").openPopup();
		shot(PICK, popup.dialog(), "pickTreePopupWithoutTitle.png");
		popup.close();
		form = open("myexample3344", "myexample3347form").formByName("MyExample3347Form");
		popup = form.pickTree("Custom Field").openPopup();
		shot(PICK, popup.dialog(), "pickTreePopupCalculatedTitle.png");
		popup.close();
	}

	@Test
	void pickColor() throws IOException {
		var form = open("myexample3341", "myexample3341form").formByName("MyExample3341Form");
		var popup = form.pickTree("Custom Field Picktree").openPopup();
		shot(PICK, popup.dialog(), "pickTreePopupColor.png");
		popup.close();
	}

	@Test
	void pickActions() throws IOException {
		var form = open("myexample3353", "myexample3354form").formByName("MyExample3354Form");
		var popup = form.pickTree("Custom Field Delete").openPopup();
		shot(PICK, popup.dialog(), "create_inline.png");
		shot(PICK, popup.dialog(), "actionsave.png");
		popup.close();
		form = open("myexample3353", "myexample3355form").formByName("MyExample3355Form");
		popup = form.pickTree("Custom Field Pick List").openPopup();
		shot(PICK, popup.dialog(), "create_with_widget.png");
		shot(PICK, popup.dialog(), "actioncancel.png");
		popup.close();
	}

	@Test
	void pickLazyLoadAndSearch() throws IOException {
		var form = open("myexample3261", "myexample3261list").formByName("MyExample3263List");
		var popup = form.pickTree("Department Pick").openPopup();
		popup.loadNext();
		shot(PICK, popup.dialog(), "lazyload.png");
		popup.fullTextSearch("team");
		shot(PICK, popup.dialog(), "search_collapse.png");
		popup.settings().select("Hide");
		Selenide.sleep(1500);
		shot(PICK, popup.dialog(), "search_hide.png");
		popup.close();
	}

	@Test
	void pickSelection() throws IOException {
		var form = open("myexample3344", "myexample3344form").formByName("MyExample3344Form");
		var popup = form.pickTree("Custom Field").openPopup();
		popup.loadNext();
		shot(PICK, popup.dialog(), "selection_node.png");
		popup.close();
		form = open("myexample3344", "myexample3345form").formByName("MyExample3345Form");
		popup = form.pickTree("Custom Field").openPopup();
		popup.loadNext();
		shot(PICK, popup.dialog(), "selection_leaf.png");
		popup.close();
		form = open("myexample3261", "myexample3261list").formByName("MyExample3263List");
		popup = form.pickTree("Department Pick").openPopup();
		popup.loadNext();
		shot(PICK, popup.dialog(), "selection_nodeandleaf.png");
		popup.close();
	}

	@Test
	void assocEditWithWidget() throws IOException {
		var form = open("myexample3331", "myexample3331editinlineform").formByName("MyExample3331FormEdit");
		var popup = form.multivalueTree("Custom Field").openPopup();
		shot(ASSOC, popup.dialog(), "assoc_edit_with_widget.png");
		popup.closeModal();
	}

	@Test
	void pickCancelCreateOnCancel() throws IOException {
		var form = open("myexample3353", "myexample3356formoncancel").formByName("MyExample3356FormOnCancel");
		var popup = form.pickTree("Custom Field").openPopup();
		shot(PICK, popup.dialog(), "actioncanceloncancel.png");
		popup.close();
	}

}
