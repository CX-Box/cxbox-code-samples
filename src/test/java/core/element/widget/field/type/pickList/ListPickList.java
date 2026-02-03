package core.element.widget.field.type.pickList;

import com.codeborne.selenide.SelenideElement;
import core.element.widget.list.ListWidget;
import core.element.widget.list.rows.PlatformRows;
import core.element.widget.list.rows.row.PlatformRow;
import core.element.widget.list.rows.row.RowInline;

public class ListPickList
		<
				W extends ListWidget<W, RR, R>,
				RR extends PlatformRows<RR, W, R>,
				R extends PlatformRow<R, RR, W>
				>
		extends PickList<W, ListPickList<W, RR, R>> {

	private final R row;

	public ListPickList(W widget, String title, R row) {
		super(widget, title);
		this.row = row;
	}

	@Override
	protected SelenideElement parentElement() {
		return row.element();
	}

	@Override
	public String valueTag() {
		if (row instanceof RowInline<?, ?, ?> pri && !pri.getIsEdit()) {
			return "span[class*=\"ReadOnlyField\"]";
		}
		return super.valueTag();
	}

	public R row() {
		return row;
	}

	@Override
	public ListPickList<W, RR, R> setValue(String value) {
		ListPickList<W, RR, R> wrrrListPickList = super.setValue(value);
		if (row instanceof RowInline<?, ?, ?> pri) {
			pri.setIsEdit(false);
		}
		return wrrrListPickList;
	}

	@Override
	public ListPickList<W, RR, R> setValue(String columnName, String value) {
		ListPickList<W, RR, R> wrrrListPickList = super.setValue(columnName, value);
		if (row instanceof RowInline<?, ?, ?> pri) {
			pri.setIsEdit(false);
		}
		return wrrrListPickList;
	}
}
