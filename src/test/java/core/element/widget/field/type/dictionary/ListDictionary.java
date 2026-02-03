package core.element.widget.field.type.dictionary;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import core.element.widget.field.type.ParentRow;
import core.element.widget.list.ListWidget;
import core.element.widget.list.rows.PlatformRows;
import core.element.widget.list.rows.row.PlatformRow;
import core.element.widget.list.rows.row.RowInline;

import java.util.function.Consumer;

public class ListDictionary<
		W extends ListWidget<W, RR, R>,
		RR extends PlatformRows<RR, W, R>,
		R extends PlatformRow<R, RR, W>
		> extends Dictionary<W, ListDictionary<W, RR, R>> implements ParentRow<R> {

	private final R row;

	public ListDictionary(W widget, String title, R row) {
		super(widget, title);
		this.row = row;
	}


	@Override
	public String valueTag() {
		if (row instanceof RowInline<?, ?, ?> rowInline) {
			if (!rowInline.getIsEdit()) {
				return "div[class*='Dictionary']";
			}
		}
		return "span";
	}

	@Override
	public ListDictionary<W, RR, R> checkReadOnly(Consumer<Boolean> expectedReadOnly) {
		boolean disabled = element().$("input").has(Condition.attribute("disabled"));
		expectedReadOnly.accept(disabled);
		return this;
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
