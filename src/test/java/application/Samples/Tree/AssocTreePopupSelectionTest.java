package application.Samples.Tree;

import application.config.BaseTestForSamples;
import core.element.PlatformApp;
import core.element.widget.field.type.multivalueTree.AssocTreeModal;
import core.element.widget.form.PlatformFormWidget;
import com.codeborne.selenide.Selenide;
import core.util.DocShots;
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
 * AssocTreePopup article, section "options.tree.selection": what the user checks explicitly is what is sent.
 */
@DisplayName("AssocTreePopup. Selection of a node and of its children")
@Epic("Samples")
@Feature(AssocTreePopupSelectionTest.ARTICLE)
@Tag("Samples")
@Tag("Tree")
public class AssocTreePopupSelectionTest extends BaseTestForSamples {

	private static final String COLUMN = "Departments";

	private static final String NODE = "Полномочия Минстроя России";

	static final String ARTICLE = "widget/type/assoctreepopup";

	private static final String CHILD_1 = "Градостроительство и перепланировка (регионы)";

	private static final String CHILD_2 = "Экспертиза, строительство и планировка (Минстрой РФ)";

	/** A node with more children than the page limit: its last row is More. */
	private static final String BIG_NODE = "Полномочия субъектов РФ";

	private AssocTreeModal<PlatformFormWidget> openPopup() {
		var form = PlatformApp.screen("Tree widget basic")
				.secondLevelView("Business example")
				.formByName("MyExample3263List");
		return form.multivalueTree("Departments Assoc").openPopup();
	}

	@Test
	@Severity(CRITICAL)
	@Tag("Positive")
	@DisplayName("Checking a node marks its loaded children as implicitly selected")
	@Description("selection = node: the node is checked explicitly, the children get the dimmed checkbox")
	void selectNodeCoversChildren() {
		var popup = openPopup();
		popup.expand(COLUMN, NODE);
		assertThat(popup.children(COLUMN, NODE)).containsExactly(CHILD_1, CHILD_2);
		popup.toggle(COLUMN, NODE);
		DocShots.png(popup.dialog(), ARTICLE, "selection_group.png", 1600, 1000);
		DocShots.png(popup.dialog(), "widget/fields/field/multivalueTree", "img_selection_form.png", 1600, 1000);
		assertThat(popup.isChecked(COLUMN, NODE)).isTrue();
		assertThat(popup.isImplicitlyChecked(COLUMN, NODE)).isFalse();
		assertThat(popup.isChecked(COLUMN, CHILD_1)).isTrue();
		assertThat(popup.isImplicitlyChecked(COLUMN, CHILD_1)).isTrue();
		assertThat(popup.isChecked(COLUMN, CHILD_2)).isTrue();
		assertThat(popup.isImplicitlyChecked(COLUMN, CHILD_2)).isTrue();
		popup.closeModal();
	}

	@Test
	@Severity(CRITICAL)
	@Tag("Positive")
	@DisplayName("Unchecking a child of a selected node switches the node to the manual selection")
	@Description("The node becomes partially selected; the other child stays checked explicitly")
	void uncheckChildSwitchesToManual() {
		var popup = openPopup();
		popup.expand(COLUMN, NODE);
		popup.toggle(COLUMN, NODE);
		popup.toggle(COLUMN, CHILD_1);
		if (popup.confirm().isShown()) {
			popup.confirm().ok();
		}
		DocShots.png(popup.dialog(), ARTICLE, "selection_manual.png", 1600, 1000);
		assertThat(popup.isChecked(COLUMN, CHILD_1)).isFalse();
		assertThat(popup.isChecked(COLUMN, CHILD_2)).isTrue();
		assertThat(popup.isImplicitlyChecked(COLUMN, CHILD_2)).isFalse();
		assertThat(popup.isIndeterminate(COLUMN, NODE)).isTrue();
		popup.closeModal();
	}

	@Test
	@Severity(CRITICAL)
	@Tag("Positive")
	@DisplayName("Unchecking a child of a selected node with unloaded children asks for a confirmation")
	@Description("confirms = paginationUnselect: the node has the More row, so the switch to the manual selection is confirmed; Cancel keeps the node selected")
	void confirmUnselectWithUnloadedChildren() {
		var popup = openPopup();
		// the node is not on the first page of the roots: it is found by the search
		popup.fullTextSearch("субъектов");
		popup.expand(COLUMN, BIG_NODE);
		// the More row and the implicit selection of the children are rendered after the data arrives
		Selenide.Wait().until(d -> popup.hasMore(COLUMN, BIG_NODE));
		popup.toggle(COLUMN, BIG_NODE);
		String child = popup.children(COLUMN, BIG_NODE).get(0);
		Selenide.Wait().until(d -> popup.isImplicitlyChecked(COLUMN, child));
		popup.toggle(COLUMN, child);
		Selenide.Wait().until(d -> popup.confirm().isShown());
		DocShots.png(ARTICLE, "selection_confirm.png", 1600, 1000);
		popup.confirm().cancel();
		assertThat(popup.confirm().isShown()).isFalse();
		assertThat(popup.isChecked(COLUMN, BIG_NODE)).isTrue();
		assertThat(popup.isImplicitlyChecked(COLUMN, child)).isTrue();
		popup.closeModal();
	}

	@Test
	@Tag("Positive")
	@DisplayName("Checking every child manually does not turn into the selection of the node")
	@Description("The children are checked explicitly; the node only reflects them")
	void selectAllChildrenManually() {
		var popup = openPopup();
		popup.expand(COLUMN, NODE);
		popup.toggle(COLUMN, CHILD_1);
		popup.toggle(COLUMN, CHILD_2);
		assertThat(popup.isChecked(COLUMN, CHILD_1)).isTrue();
		assertThat(popup.isImplicitlyChecked(COLUMN, CHILD_1)).isFalse();
		assertThat(popup.isChecked(COLUMN, CHILD_2)).isTrue();
		assertThat(popup.isImplicitlyChecked(COLUMN, CHILD_2)).isFalse();
		assertThat(popup.isChecked(COLUMN, NODE) || popup.isIndeterminate(COLUMN, NODE)).isTrue();
		assertThat(popup.isImplicitlyChecked(COLUMN, NODE)).isEqualTo(popup.isChecked(COLUMN, NODE));
		popup.closeModal();
	}

}
