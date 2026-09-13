package core.element.widget.list.realization.inline.tree;

import core.element.widget.PlatformIdentifier;
import core.element.widget.tree.TreeNavigation;
import core.element.widget.type.TypeWidget;

/**
 * The tree inside a popup (PickTreePopup, AssocTreePopup): the same widget as {@link PlatformTreeWidgetInline},
 * found by the popup widget type and name. The selection of the rows belongs to the popup (see the modal classes).
 */
public class PlatformTreePopupWidgetInline extends PlatformTreeWidgetInline {

	private final TypeWidget type;

	public PlatformTreePopupWidgetInline(TypeWidget type, String name) {
		super(PlatformIdentifier.NAME, name);
		this.type = type;
	}

	@Override
	public TypeWidget getType() {
		return type;
	}

	/** Every visible row of the popup: a popup opened filtered (e.g. by the selected values) shows its rows apart from the tree. */
	@Override
	public PlatformTreeRowsInline rows() {
		return rowsOf(TreeNavigation.ALL_KEY);
	}

}
