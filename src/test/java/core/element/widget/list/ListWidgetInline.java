package core.element.widget.list;

import core.common.Identifier;
import core.element.widget.list.rows.RowsInline;
import core.element.widget.list.rows.row.RowInline;
import core.element.widget.type.PlatformTypeWidgets;
import core.element.widget.type.TypeWidget;

public abstract class ListWidgetInline<
		SELF extends ListWidgetInline<SELF, ROWS, ROW>,
		ROWS extends RowsInline<ROWS, SELF, ROW>,
		ROW extends RowInline<ROW, ROWS, SELF>>
		extends ListWidget<SELF, ROWS, ROW> {
	public ListWidgetInline(Identifier identifier, String textIdenfier) {
		super(identifier, textIdenfier);
	}

	@Override
	public TypeWidget getType() {
		return PlatformTypeWidgets.LIST;
	}

}
