package core.element.widget.field.type.pickTree;

import com.codeborne.selenide.SelenideElement;
import core.element.widget.list.ListWidget;
import core.element.widget.list.rows.PlatformRows;
import core.element.widget.list.rows.row.PlatformRow;
import core.element.widget.list.rows.row.RowInline;

public class ListPickTree
		<
				W extends ListWidget<W, RR, R>,
				RR extends PlatformRows<RR, W, R>,
				R extends PlatformRow<R, RR, W>
				>
		extends PickTree<W, ListPickTree<W, RR, R>> {

	private final R row;

	public ListPickTree(W widget, String title, R row) {
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
	public ListPickTree<W, RR, R> setValue(String value) {
		ListPickTree<W, RR, R> result = super.setValue(value);
		if (row instanceof RowInline<?, ?, ?> pri) {
			pri.setIsEdit(false);
		}
		return result;
	}

	@Override
	public ListPickTree<W, RR, R> setValue(String columnName, String value) {
		ListPickTree<W, RR, R> result = super.setValue(columnName, value);
		if (row instanceof RowInline<?, ?, ?> pri) {
			pri.setIsEdit(false);
		}
		return result;
	}

}
