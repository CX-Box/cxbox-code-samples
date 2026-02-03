package core.element.widget.field.type.multifield;

import com.codeborne.selenide.SelenideElement;
import core.element.widget.field.type.ParentRow;
import core.element.widget.list.ListWidget;
import core.element.widget.list.rows.PlatformRows;
import core.element.widget.list.rows.row.PlatformRow;

public class ListMultifield<
		W extends ListWidget<W, RR, R>,
		RR extends PlatformRows<RR, W, R>,
		R extends PlatformRow<R, RR, W>
		>
		extends Multifield<W, ListMultifield<W, RR, R>> implements ParentRow<R> {

	private final R row;

	public ListMultifield(W widget, String title, R row) {
		super(widget, title);
		this.row = row;
	}

	@Override
	protected SelenideElement parentElement() {
		return row.element();
	}

	@Override
	public String valueTag() {
		return super.valueTag();
	}

	public R row() {
		return row;
	}

}
