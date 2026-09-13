package core.element.widget.list.realization.form.tree;

import core.element.widget.PlatformIdentifier;
import core.element.widget.tree.TreeNavigation;
import core.element.widget.type.TypeWidget;

/**
 * The tree with the inline forms of the rows inside a popup (options.create.widget / options.edit.widget):
 * the same widget as {@link PlatformTreeWidgetInlineForm}, found by the popup widget type and name.
 */
public class PlatformTreePopupWidgetInlineForm extends PlatformTreeWidgetInlineForm {

	private final TypeWidget type;

	public PlatformTreePopupWidgetInlineForm(TypeWidget type, String name) {
		super(PlatformIdentifier.NAME, name);
		this.type = type;
	}

	@Override
	public TypeWidget getType() {
		return type;
	}

	/** Every visible row of the popup: a popup opened filtered (e.g. by the selected values) shows its rows apart from the tree. */
	@Override
	public PlatformTreeRowsInlineForm rows() {
		return rowsOf(TreeNavigation.ALL_KEY);
	}

}
