package core.element.widget.list.realization.form.tree;

import core.common.Identifier;
import core.element.widget.form.PlatformInlineFormWidget;
import core.element.widget.list.TreeWidgetInlineForm;

public class PlatformTreeWidgetInlineForm extends
		TreeWidgetInlineForm<PlatformTreeWidgetInlineForm, PlatformTreeRowsInlineForm, PlatformTreeRowInlineForm, PlatformInlineFormWidget> {

	public PlatformTreeWidgetInlineForm(Identifier identifier, String textIdentifier) {
		super(identifier, textIdentifier);
	}

	@Override
	protected PlatformTreeRowsInlineForm rowsOf(String ownerKey) {
		return new PlatformTreeRowsInlineForm(this, ownerKey);
	}

}
