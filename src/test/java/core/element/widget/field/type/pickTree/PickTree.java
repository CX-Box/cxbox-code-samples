package core.element.widget.field.type.pickTree;

import com.codeborne.selenide.Condition;
import core.element.widget.AbstractWidget;
import core.element.widget.field.FieldType;
import core.element.widget.field.PlatformFieldType;
import core.element.widget.field.type.pickList.PickList;
import core.expectation.ExpectationPattern;

/**
 * pickTree field: same control as pickList, the popup is a PickTreePopup.
 */
public class PickTree<W extends AbstractWidget<ExpectationPattern, W>, SELF extends PickTree<W, SELF>> extends PickList<W, SELF> {

	public PickTree(W widget, String title) {
		super(widget, title);
	}

	@Override
	public FieldType fieldType() {
		return PlatformFieldType.PICK_TREE;
	}

	@Override
	protected String popupIconSelector() {
		return "i[data-test-field-picktree-popup=\"true\"]";
	}

	@Override
	protected String clearIconSelector() {
		return "i[data-test-field-picktree-clear=\"true\"]";
	}

	@Override
	protected void pickInModal(String columnName, String value) {
		new PickTreeModal<>(widget()).setValue(columnName, value);
	}

	/** Opens the PickTreePopup of the field and returns it for step-by-step checks. */
	public PickTreeModal<W> openPopup() {
		widget().getExpectations().getWaitAllFields();
		element()
				.$(popupIconSelector())
				.shouldBe(Condition.visible, widget().getExpectations().getTimeout())
				.click();
		return new PickTreeModal<>(widget());
	}

}
