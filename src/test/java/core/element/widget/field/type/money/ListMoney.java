package core.element.widget.field.type.money;

import com.codeborne.selenide.SelenideElement;
import core.element.widget.field.type.ParentRow;
import core.element.widget.list.ListWidget;
import core.element.widget.list.rows.PlatformRows;
import core.element.widget.list.rows.row.PlatformRow;
import core.element.widget.list.rows.row.RowInline;

public class ListMoney<
		W extends ListWidget<W, RR, R>,
		RR extends PlatformRows<RR, W, R>,
		R extends PlatformRow<R, RR, W>
		> extends Money<W, ListMoney<W, RR, R>> implements ParentRow<R> {

	private final R row;

	public ListMoney(W widget, String title, R row) {
		super(widget, title);
		this.row = row;
	}

	@Override
	protected SelenideElement parentElement() {
		return row().element();
	}

	@Override
	public String valueTag() {
		if (row instanceof RowInline<?, ?, ?> pri && !pri.getIsEdit()) {
			return "span";
		}
		return super.valueTag();
	}

	public R row() {
		return row;
	}

}
