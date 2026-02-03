package core.element.widget.field.type.time;

import com.codeborne.selenide.SelenideElement;
import core.element.widget.field.type.ParentRow;
import core.element.widget.list.ListWidget;
import core.element.widget.list.realization.inline.list.PlatformListRowInline;
import core.element.widget.list.rows.PlatformRows;
import core.element.widget.list.rows.row.PlatformRow;

public class ListTime<
		W extends ListWidget<W, RR, R>,
		RR extends PlatformRows<RR, W, R>,
		R extends PlatformRow<R, RR, W>
		>
		extends Time<W, ListTime<W, RR, R>> implements ParentRow<R> {

	private final R row;

	public ListTime(W widget, String title, String format, R row) {
		super(widget, title, format);
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

	@Override
	public String valueTag() {
		if (row instanceof PlatformListRowInline ri && !ri.getIsEdit()) {
			return "span[class*=\"ReadOnlyField\"]";
		}
		return super.valueTag();
	}
}
