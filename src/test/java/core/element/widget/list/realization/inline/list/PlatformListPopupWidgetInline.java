package core.element.widget.list.realization.inline.list;

import core.element.widget.PlatformIdentifier;
import core.element.widget.type.TypeWidget;

/**
 * The list inside a popup (PickListPopup, AssocListPopup): the same widget as {@link PlatformListWidgetInline},
 * found by the popup widget type and name. The selection of the rows belongs to the popup (see the modal classes).
 */
public class PlatformListPopupWidgetInline extends PlatformListWidgetInline {

	private final TypeWidget type;

	public PlatformListPopupWidgetInline(TypeWidget type, String name) {
		super(PlatformIdentifier.NAME, name);
		this.type = type;
	}

	@Override
	public TypeWidget getType() {
		return type;
	}

}
