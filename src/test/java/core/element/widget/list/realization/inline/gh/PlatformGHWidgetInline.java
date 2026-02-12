package core.element.widget.list.realization.inline.gh;

import core.common.Identifier;
import core.element.widget.list.GroupingHierarchyWidgetInline;

public class PlatformGHWidgetInline extends GroupingHierarchyWidgetInline<PlatformGHWidgetInline, PlatformGHRowsInline, PlatformGHRowInline> {
	public PlatformGHWidgetInline(Identifier identifier, String textIdenfier) {
		super(identifier, textIdenfier);
	}

	@Override
	public PlatformGHRowsInline rows() {
		return new PlatformGHRowsInline(widget());
	}


}
