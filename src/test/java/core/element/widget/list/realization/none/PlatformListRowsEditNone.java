package core.element.widget.list.realization.none;

import core.element.widget.list.rows.RowsEditNone;

public class PlatformListRowsEditNone extends RowsEditNone<PlatformListRowsEditNone, PlatformListEditNone, PlatformListRowEditNone> {
	public PlatformListRowsEditNone(PlatformListEditNone widget) {
		super(widget);
	}

	@Override
	public PlatformListRowEditNone row(int number) {
		return null;
	}
}
