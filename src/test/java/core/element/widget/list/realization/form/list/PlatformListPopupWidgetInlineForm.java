package core.element.widget.list.realization.form.list;

import core.element.widget.PlatformIdentifier;
import core.element.widget.type.TypeWidget;

/**
 * The list with the inline forms of the rows inside a popup (options.create.widget / options.edit.widget):
 * the same widget as {@link PlatformListWidgetInlineForm}, found by the popup widget type and name.
 */
public class PlatformListPopupWidgetInlineForm extends PlatformListWidgetInlineForm {

	private final TypeWidget type;

	public PlatformListPopupWidgetInlineForm(TypeWidget type, String name) {
		super(PlatformIdentifier.NAME, name);
		this.type = type;
	}

	@Override
	public TypeWidget getType() {
		return type;
	}

}
