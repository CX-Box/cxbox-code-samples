package core.element.widget.list.realization.inline.list;

import core.element.widget.list.rows.RowsInline;

public class PlatformListRowsInline extends
		RowsInline<PlatformListRowsInline, PlatformListWidgetInline, PlatformListRowInline> {
	public PlatformListRowsInline(PlatformListWidgetInline widget) {
		super(widget);
	}

	@Override
	public PlatformListRowInline row(int number) {
		String rowKey = element().get(number).getAttribute(ROW_ID_ATTRIBUTE);
		return new PlatformListRowInline(this, number, rowKey, false);
	}

	@Override
	public PlatformListRowInline clickRow(int number) {
		String rowKey = element().get(number).getAttribute(ROW_ID_ATTRIBUTE);
		var row = new PlatformListRowInline(this, number, rowKey);
		return row.editRow();
	}
}