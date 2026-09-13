package application.Samples.Tree;

import application.config.BaseTestForSamples;
import application.config.props.Env;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import core.element.PlatformApp;
import core.element.screen.view.PlatformView;
import core.element.widget.list.realization.inline.tree.PlatformTreeWidgetInline;
import core.element.widget.field.type.multivalueTree.AssocTreeModal;
import core.util.DocShots;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static io.qameta.allure.SeverityLevel.CRITICAL;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * AssocTreePopup widget (samples widgets/assoctree): basics, action button, title, color, lazy load and search modes.
 * Analogue of the AssocListPopup samples.
 */
@DisplayName("AssocTreePopup. Basics, action button, title, color, lazy load, search modes")
@Epic("Samples")
@Feature(AssocTreePopupTest.ARTICLE)
@Tag("Samples")
public class AssocTreePopupTest extends BaseTestForSamples {

	static final String ARTICLE = "widget/type/assoctreepopup";

	private static final String FIELD = "Custom Field";

	private static final String NODE = "Полномочия Минстроя России";

	private static final String SEARCH = "Минстроя";

	/** Texts of the rows of the tree and of the found rows shown apart (search modes). */
	private static List<String> foundTexts(PlatformTreeWidgetInline tree) {
		List<String> texts = new ArrayList<>(tree.rows().streamCurrentPage().map(r -> r.element().getText()).toList());
		tree.unallocatedRows().streamCurrentPage().forEach(r -> texts.add(r.element().getText()));
		return texts;
	}

	private static PlatformView open(String screen, String view) {
		Selenide.open(Env.uri() + "screen/" + screen + "/view/" + view);
		Selenide.sleep(2500);
		return PlatformApp.currentScreen().view();
	}

	@Test
	@Severity(CRITICAL)
	@Tag("Positive")
	@DisplayName("The popup opens from the multivalueTree field of a list and of a form")
	void basics() {
		var list = open("myexample3330", "myexample3330list").listByName("MyExample3330List");
		assertThat(list.rows().element().size()).isGreaterThan(0);
		DocShots.png(list.element(), ARTICLE, "assoc_list.png", 1600, 1000);
		DocShots.png(list.element(), ARTICLE, "assoc_list_button.png", 1600, 1000);
		var form = open("myexample3330", "myexample3330form").formByName("MyExample3330Form");
		DocShots.png(form.element(), ARTICLE, "assoc_form.png", 1600, 1000);
		var popup = form.multivalueTree(FIELD).openPopup();
		assertThat(popup.tree().rows().element().size()).isGreaterThan(0);
		DocShots.png(popup.dialog(), ARTICLE, "choose_assoc.png", 1600, 1000);
		popup.closeModal();
	}

	@Test
	@Tag("Positive")
	@DisplayName("The popup opens by a widget action")
	@Description("The action of the form opens the AssocTreePopup without a field")
	void actionButton() {
		var form = open("myexample3333", "myexample3333form").formByName("MyExample3333Form");
		DocShots.png(form.element(), ARTICLE, "choose_button.png", 1600, 1000);
		form.actions().action("Popup Assoc").click();
		AssocTreeModal.modalElement().shouldBe(Condition.visible, form.getExpectations().getTimeout());
		DocShots.png(ARTICLE, "up_assoc.png", 1600, 1000);
		new AssocTreeModal<>(form).cancel();
	}

	@Test
	@Tag("Positive")
	@DisplayName("Constant title of the popup and a popup without a title")
	void title() {
		var form = open("myexample3336", "myexample3336title").formByName("MyExample3336WithTitle");
		var popup = form.multivalueTree("Custom Field Multivalue").openPopup();
		assertThat(popup.title()).isEqualTo("AssocTreePopup with title");
		DocShots.png(popup.dialog(), ARTICLE, "consttitle.png", 1600, 1000);
		popup.closeModal();
		form = open("myexample3336", "myexample3336emptytitle").formByName("MyExample3336EmptyTitle");
		popup = form.multivalueTree("Custom Field Multivalue").openPopup();
		assertThat(popup.title()).isEmpty();
		DocShots.png(popup.dialog(), ARTICLE, "empytitle.png", 1600, 1000);
		popup.closeModal();
	}

	@Test
	@Tag("Positive")
	@DisplayName("Colored rows of the popup")
	void color() {
		var form = open("myexample3329", "myexample3332color").formByName("MyExample3332Color");
		var popup = form.multivalueTree("Custom Field Multi").openPopup();
		assertThat(popup.tree().rows().element().size()).isGreaterThan(0);
		popup.tree().rows().row(0).expandRow();
		DocShots.png(popup.dialog(), ARTICLE, "colorwidget.png", 1600, 1000);
		popup.closeModal();
	}

	@Test
	@Severity(CRITICAL)
	@Tag("Positive")
	@DisplayName("Lazy load and the search modes of the popup")
	@Description("A node is expanded on demand; the full text search shows the found rows, the hide mode replaces the arrows by the dot")
	void lazyLoadAndSearch() {
		open("myexample3261", "myexample3261list");
		Selenide.sleep(2500);
		var form = PlatformApp.currentScreen().view().formByName("MyExample3263List");
		var popup = form.multivalueTree("Departments Assoc").openPopup();
		popup.expand("Departments", NODE);
		assertThat(popup.children("Departments", NODE)).isNotEmpty();
		DocShots.png(popup.dialog(), ARTICLE, "lazyload.png", 1600, 1000);
		var tree = popup.tree();
		popup.fullTextSearch(SEARCH);
		tree.waitLoaded();
		assertThat(foundTexts(tree)).isNotEmpty().anyMatch(text -> text.contains(SEARCH));
		DocShots.png(popup.dialog(), ARTICLE, "search_collapse.png", 1600, 1000);
		DocShots.png(popup.settings().open(), ARTICLE, "search_modes_menu.png", 1600, 1000);
		popup.settings().select("Hide");
		tree.waitLoaded();
		assertThat(foundTexts(tree)).isNotEmpty().anyMatch(text -> text.contains(SEARCH));
		DocShots.png(popup.dialog(), ARTICLE, "search_hide.png", 1600, 1000);
		popup.closeModal();
	}

}
