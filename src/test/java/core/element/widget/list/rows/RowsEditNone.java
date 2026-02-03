package core.element.widget.list.rows;

import core.element.widget.list.ListWidget;
import core.element.widget.list.rows.row.RowEditNone;

public abstract class RowsEditNone<
		SELF extends PlatformRows<SELF, W, ROW>,
		W extends ListWidget<W, SELF, ROW>,
		ROW extends RowEditNone<ROW, SELF, W>
		> extends PlatformRows<SELF, W, ROW> {

	public RowsEditNone(W widget) {
		super(widget);
	}

//	@Override
//	public ROW row(int number) {
//		String cursor = element().get(number).getAttribute(ROW_ID_ATTRIBUTE);
//		return (ROW) new RowEditNone<>((SELF) this, number, cursor);
//	}


}
