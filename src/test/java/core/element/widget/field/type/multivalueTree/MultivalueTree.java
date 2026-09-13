package core.element.widget.field.type.multivalueTree;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import core.element.widget.AbstractWidget;
import core.element.widget.field.FieldType;
import core.element.widget.field.PlatformFieldType;
import core.element.widget.field.type.multivalue.Multivalue;
import core.element.widget.field.type.multivalue.MultivalueModal;
import core.element.widget.tree.TreeNavigation;
import core.expectation.ExpectationPattern;

/**
 * multivalueTree field: same control as multivalue, the popup is an AssocTreePopup.
 */
public class MultivalueTree<W extends AbstractWidget<ExpectationPattern, W>> extends Multivalue<W> {

	public MultivalueTree(W widget, String name) {
		super(widget, name);
	}

	@Override
	public FieldType fieldType() {
		return PlatformFieldType.MULTIVALUE_TREE;
	}

	@Override
	protected MultivalueModal<W> modal() {
		return new AssocTreeModal<>(widget());
	}

	/** Opens the AssocTreePopup of the field and returns it for step-by-step checks. */
	public AssocTreeModal<W> openPopup() {
		widget().getExpectations().getWaitAllFields();
		SelenideElement icon = element()
				.$("div[data-test-field-multivalue-icon=\"true\"]")
				.shouldBe(Condition.visible, widget().getExpectations().getTimeout());
		SelenideElement modal = AssocTreeModal.modalElement();
		for (int attempt = 0; attempt < 3 && !modal.is(Condition.visible); attempt++) {
			icon.click();
			modal.is(Condition.visible, widget().getExpectations().getTimeout());
		}
		AssocTreeModal<W> popup = new AssocTreeModal<>(widget());
		TreeNavigation.waitLoaded(popup.element(), widget().getExpectations());
		return popup;
	}

}
