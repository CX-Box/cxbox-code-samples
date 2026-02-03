package core.element.widget.list;

import core.common.Identifier;
import core.element.widget.list.rows.RowsEditNone;
import core.element.widget.list.rows.row.RowEditNone;
import core.element.widget.type.PlatformTypeWidgets;
import core.element.widget.type.TypeWidget;

public abstract class ListWidgetEditNone<
		SELF extends ListWidgetEditNone<SELF, ROWS, ROW>,
		ROWS extends RowsEditNone<ROWS, SELF, ROW>,
		ROW extends RowEditNone<ROW, ROWS, SELF>
		> extends ListWidget<SELF, ROWS, ROW> {


	public ListWidgetEditNone(Identifier identifier, String textIdenfier) {
		super(identifier, textIdenfier);
	}

	@Override
	public TypeWidget getType() {
		return PlatformTypeWidgets.LIST;
	}


}
