package core.element.widget.list.realization.inline.gh;

import core.element.widget.list.rows.row.RowInline;

public class PlatformGHRowInline extends
		RowInline<PlatformGHRowInline, PlatformGHRowsInline, PlatformGHWidgetInline> {


	public PlatformGHRowInline(PlatformGHRowsInline parent, int pageIndex, String rowKey, boolean isEdit) {
		super(parent, pageIndex, rowKey, isEdit);
	}

	public PlatformGHRowInline(PlatformGHRowsInline parent, int pageIndex, String rowKey) {
		super(parent, pageIndex, rowKey);
	}

	@Override
	public PlatformGHRowInline editRow() {
		element().click();
		return new PlatformGHRowInline(getParent(), getPageIndex(), getRowKey(), true);
	}
}