package core.element.widget.list.realization.form.gh;

import core.common.Identifier;
import core.element.widget.form.PlatformInlineFormWidget;
import core.element.widget.list.GroupingHierarchyWidgetInlineForm;

public class PlatformGHWidgetInlineForm extends GroupingHierarchyWidgetInlineForm<PlatformGHWidgetInlineForm, PlatformGHRowsInlineForm, PlatformGHRowInlineForm, PlatformInlineFormWidget> {
	public PlatformGHWidgetInlineForm(Identifier identifier, String textIdentifier) {
		super(identifier, textIdentifier);
	}

	@Override
	public PlatformGHRowsInlineForm rows() {
		return new PlatformGHRowsInlineForm(this);
	}
}
