package application.Samples.Tree;

import application.config.BaseTestForSamples;
import core.element.PlatformApp;
import core.element.widget.field.type.multivalueTree.AssocTreeModal;
import core.element.widget.form.PlatformFormWidget;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
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
@Tag("Samples")
@Tag("Tree")
public class AssocTreePopupSelectionTest extends BaseTestForSamples {

	private static final String COLUMN = "Departments";

	private static final String NODE = "Полномочия Минстроя России";

	private static final String CHILD_1 = "Градостроительство и перепланировка (регионы)";

	private static final String CHILD_2 = "Экспертиза, строительство и планировка (Минстрой РФ)";

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
		assertThat(popup.isChecked(COLUMN, CHILD_1)).isFalse();
		assertThat(popup.isChecked(COLUMN, CHILD_2)).isTrue();
		assertThat(popup.isImplicitlyChecked(COLUMN, CHILD_2)).isFalse();
		assertThat(popup.isIndeterminate(COLUMN, NODE)).isTrue();
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
