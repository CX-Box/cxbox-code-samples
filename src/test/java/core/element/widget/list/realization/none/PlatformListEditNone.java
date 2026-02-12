package core.element.widget.list.realization.none;

import core.common.Identifier;
import core.element.widget.list.ListWidgetEditNone;

public class PlatformListEditNone extends ListWidgetEditNone<PlatformListEditNone, PlatformListRowsEditNone, PlatformListRowEditNone> {

	public PlatformListEditNone(Identifier identifier, String textIdenfier) {
		super(identifier, textIdenfier);
	}

	@Override
	public PlatformListRowsEditNone rows() {
		return null;
	}
}
