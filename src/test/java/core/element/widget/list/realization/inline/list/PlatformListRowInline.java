package core.element.widget.list.realization.inline.list;

import core.element.widget.list.rows.row.RowInline;

public class PlatformListRowInline extends
		RowInline<PlatformListRowInline, PlatformListRowsInline, PlatformListWidgetInline> {

	public PlatformListRowInline(PlatformListRowsInline parent, int pageIndex, String rowKey, boolean isEdit) {
		super(parent, pageIndex, rowKey, isEdit);
	}

	public PlatformListRowInline(PlatformListRowsInline parent, int pageIndex, String rowKey) {
		super(parent, pageIndex, rowKey);
	}

	@Override
	public PlatformListRowInline editRow() {
		element().click();
		return new PlatformListRowInline(getParent(), getPageIndex(), getRowKey(), true);
	}
}