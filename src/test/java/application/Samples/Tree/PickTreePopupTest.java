package application.Samples.Tree;

import application.config.BaseTestForSamples;
import application.config.props.Env;
import com.codeborne.selenide.Selenide;
import core.element.PlatformApp;
import core.element.screen.view.PlatformView;
import core.element.widget.list.realization.inline.tree.PlatformTreeWidgetInline;
import core.util.DocShots;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static io.qameta.allure.SeverityLevel.CRITICAL;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * PickTreePopup widget (samples widgets/picktree): title, color, lazy load and search modes, selection.
 * Analogue of the PickListPopup samples.
 */
@DisplayName("PickTreePopup. Title, color, lazy load, search modes, selection")
@Epic("Samples")
@Feature(PickTreePopupTest.ARTICLE)
@Tag("Samples")
public class PickTreePopupTest extends BaseTestForSamples {

	static final String ARTICLE = "widget/type/picktreepopup";

	private static final String FIELD = "Custom Field";

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
	@DisplayName("Constant title of the popup; the popup with selection = node")
	void constantTitle() {
		var form = open("myexample3344", "myexample3344form").formByName("MyExample3344Form");
		var popup = form.pickTree(FIELD).openPopup();
		assertThat(popup.title()).isEqualTo("Constant Title");
		DocShots.png(popup.dialog(), ARTICLE, "pickTreePopupWithTitle.png", 1600, 1000);
		popup.loadNext();
		DocShots.png(popup.dialog(), ARTICLE, "selection_node.png", 1600, 1000);
		popup.close();
	}

	@Test
	@Tag("Positive")
	@DisplayName("Popup without a title; the popup with selection = leaf")
	void withoutTitle() {
		var form = open("myexample3344", "myexample3345form").formByName("MyExample3345Form");
		var popup = form.pickTree(FIELD).openPopup();
		assertThat(popup.title()).isEmpty();
		DocShots.png(popup.dialog(), ARTICLE, "pickTreePopupWithoutTitle.png", 1600, 1000);
		popup.loadNext();
		DocShots.png(popup.dialog(), ARTICLE, "selection_leaf.png", 1600, 1000);
		popup.close();
	}

	@Test
	@Tag("Positive")
	@DisplayName("Calculated title of the popup")
	@Description("The title is built from the field of the parent record: customFieldPick: ${customFieldPick}")
	void calculatedTitle() {
		var form = open("myexample3344", "myexample3347form").formByName("MyExample3347Form");
		var popup = form.pickTree(FIELD).openPopup();
		assertThat(popup.title()).startsWith("customFieldPick:");
		DocShots.png(popup.dialog(), ARTICLE, "pickTreePopupCalculatedTitle.png", 1600, 1000);
		popup.close();
	}

	@Test
	@Tag("Positive")
	@DisplayName("Colored rows of the popup")
	void color() {
		var form = open("myexample3341", "myexample3341form").formByName("MyExample3341Form");
		var popup = form.pickTree("Custom Field Picktree").openPopup();
		assertThat(popup.tree().rows().element().size()).isGreaterThan(0);
		popup.tree().rows().row(0).expandRow();
		DocShots.png(popup.dialog(), ARTICLE, "pickTreePopupColor.png", 1600, 1000);
		popup.close();
	}

	@Test
	@Severity(CRITICAL)
	@Tag("Positive")
	@DisplayName("Lazy load and the search modes of the popup")
	@Description("A node is expanded on demand; the full text search shows the found rows, the hide mode replaces the arrows by the dot")
	void lazyLoadAndSearch() {
		var form = open("myexample3261", "myexample3261list").formByName("MyExample3263List");
		var popup = form.pickTree("Department Pick").openPopup();
		var tree = popup.tree();
		int roots = tree.rows().element().size();
		assertThat(popup.loadNext()).isTrue();
		assertThat(tree.rows().element().size()).isGreaterThan(roots);
		DocShots.png(popup.dialog(), ARTICLE, "lazyload.png", 1600, 1000);
		DocShots.png(popup.dialog(), ARTICLE, "selection_nodeandleaf.png", 1600, 1000);
		popup.fullTextSearch("team");
		tree.waitLoaded();
		assertThat(foundTexts(tree)).isNotEmpty().anyMatch(text -> text.toLowerCase().contains("team"));
		DocShots.png(popup.dialog(), ARTICLE, "search_collapse.png", 1600, 1000);
		DocShots.png(popup.settings().open(), ARTICLE, "search_modes_menu.png", 1600, 1000);
		popup.settings().select("Hide");
		tree.waitLoaded();
		assertThat(foundTexts(tree)).isNotEmpty().anyMatch(text -> text.toLowerCase().contains("team"));
		DocShots.png(popup.dialog(), ARTICLE, "search_hide.png", 1600, 1000);
		popup.close();
	}

}
