package core.element.widget.list.realization.inline.list;

import core.common.Identifier;
import core.element.widget.list.ListWidgetInline;

public class PlatformListWidgetInline extends
		ListWidgetInline<PlatformListWidgetInline, PlatformListRowsInline, PlatformListRowInline> {

	public PlatformListWidgetInline(Identifier identifier, String textIdentifier) {
		super(identifier, textIdentifier);
	}

	@Override
	public PlatformListRowsInline rows() {
		return new PlatformListRowsInline(this);
	}
}
