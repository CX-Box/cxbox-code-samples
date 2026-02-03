package core.element.widget.list.rows;

import core.element.widget.AbstractWidget;
import core.element.widget.list.ListWidget;
import core.element.widget.list.rows.row.RowInlineForm;
import core.expectation.ExpectationPattern;

public abstract class RowsInlineForm<
		SELF extends PlatformRows<SELF, W, ROW>,
		W extends ListWidget<W, SELF, ROW>,
		ROW extends RowInlineForm<ROW, SELF, W, FORMWIDGET>,
		FORMWIDGET extends AbstractWidget<ExpectationPattern, FORMWIDGET>>
		extends PlatformRows<SELF, W, ROW> {

	public RowsInlineForm(W widget) {
		super(widget);
	}

//	@Override
//	public ROW row(int number) {
//		String cursor = element().get(number).getAttribute(ROW_ID_ATTRIBUTE);
//		return (ROW) new RowInlineForm<>((SELF) this, number, cursor);
//	}

}
