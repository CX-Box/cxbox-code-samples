package core.element.widget.list.realization.inline.tree;

import core.common.Identifier;
import core.element.widget.list.TreeWidgetInline;

public class PlatformTreeWidgetInline extends
		TreeWidgetInline<PlatformTreeWidgetInline, PlatformTreeRowsInline, PlatformTreeRowInline> {

	public PlatformTreeWidgetInline(Identifier identifier, String textIdenfier) {
		super(identifier, textIdenfier);
	}

	@Override
	protected PlatformTreeRowsInline rowsOf(String ownerKey) {
		return new PlatformTreeRowsInline(this, ownerKey);
	}

}
