package core.element.widget.field.type.percent;

import com.codeborne.selenide.SelenideElement;
import core.element.widget.field.type.ParentRow;
import core.element.widget.list.ListWidget;
import core.element.widget.list.rows.PlatformRows;
import core.element.widget.list.rows.row.PlatformRow;

public class ListPercent<
		W extends ListWidget<W, RR, R>,
		RR extends PlatformRows<RR, W, R>,
		R extends PlatformRow<R, RR, W>
		> extends Percent<W, ListPercent<W, RR, R>> implements ParentRow<R> {
	private final R row;

	public ListPercent(W widget, String title, R row) {
		super(widget, title);
		this.row = row;
	}

	@Override
	protected SelenideElement parentElement() {
		return row().element();
	}

	@Override
	public R row() {
		return row;
	}
}
