package core.element.widget.list.realization.form.list;

import core.common.Identifier;
import core.element.widget.form.PlatformInlineFormWidget;
import core.element.widget.list.ListWidgetInlineForm;

public class PlatformListWidgetInlineForm extends
		ListWidgetInlineForm<PlatformListWidgetInlineForm, PlatformListRowsInlineForm, PlatformListRowInlineForm, PlatformInlineFormWidget> {
	public PlatformListWidgetInlineForm(Identifier identifier, String textIdentifier) {
		super(identifier, textIdentifier);
	}

	@Override
	public PlatformListRowsInlineForm rows() {
		return new PlatformListRowsInlineForm(this);
	}
}
