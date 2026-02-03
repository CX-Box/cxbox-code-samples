package core.element.widget.list.realization.inline.gh;

import core.element.widget.list.rows.RowsInline;

public class PlatformGHRowsInline extends
		RowsInline<PlatformGHRowsInline, PlatformGHWidgetInline, PlatformGHRowInline> {

	public PlatformGHRowsInline(PlatformGHWidgetInline widget) {
		super(widget);
	}

	@Override
	public PlatformGHRowInline row(int number) {
		String cursor = element().get(number).getAttribute(ROW_ID_ATTRIBUTE);
		return new PlatformGHRowInline(this, number, cursor);
	}

	@Override
	public PlatformGHRowInline clickRow(int number) {
		String rowKey = element().get(number).getAttribute(ROW_ID_ATTRIBUTE);
		var row = new PlatformGHRowInline(this, number, rowKey);
		return row.editRow();
	}


}