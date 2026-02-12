package core.element.widget.list.rows;

import core.element.widget.list.ListWidget;
import core.element.widget.list.rows.row.RowInline;

public abstract class RowsInline<SELF extends RowsInline<SELF, WIDGET, ROW>, WIDGET extends ListWidget<WIDGET, SELF, ROW>, ROW extends RowInline<ROW, SELF, WIDGET>> extends PlatformRows<SELF, WIDGET, ROW> {

	public RowsInline(WIDGET widget) {
		super(widget);
	}

//	@Override
//	public ROW row(int number) {
//		String cursor = element().get(number).getAttribute(ROW_ID_ATTRIBUTE);
//		return (ROW) new RowInline<>((SELF) this, number, cursor);
//	}
//

	public abstract ROW clickRow(int number);

//	public ROW clickRow(int number) {
//		String rowKey = element().get(number).getAttribute(ROW_ID_ATTRIBUTE);
//		var row = (ROW) new RowInline<>((SELF) this, number, rowKey);
//		return row.editRow();
//	}


}
