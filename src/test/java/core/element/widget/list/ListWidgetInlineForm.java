package core.element.widget.list;

import core.common.Identifier;
import core.element.widget.AbstractWidget;
import core.element.widget.list.rows.RowsInlineForm;
import core.element.widget.list.rows.row.RowInlineForm;
import core.element.widget.type.PlatformTypeWidgets;
import core.element.widget.type.TypeWidget;
import core.expectation.ExpectationPattern;

public abstract class ListWidgetInlineForm<
		SELF extends ListWidgetInlineForm<SELF, ROWS, ROW, FORMWIDGET>,
		ROWS extends RowsInlineForm<ROWS, SELF, ROW, FORMWIDGET>,
		ROW extends RowInlineForm<ROW, ROWS, SELF, FORMWIDGET>,
		FORMWIDGET extends AbstractWidget<ExpectationPattern, FORMWIDGET>> extends ListWidget<SELF, ROWS, ROW> {


	public ListWidgetInlineForm(Identifier identifier, String textIdenfier) {
		super(identifier, textIdenfier);
	}

	@Override
	public TypeWidget getType() {
		return PlatformTypeWidgets.LIST;
	}


}
