package core.element.widget.field.type.multivalueHover;

import com.codeborne.selenide.SelenideElement;
import core.element.widget.field.type.ParentRow;
import core.element.widget.list.ListWidget;
import core.element.widget.list.rows.PlatformRows;
import core.element.widget.list.rows.row.PlatformRow;

import java.util.function.Consumer;

public class ListMultivalueHover
		<
				W extends ListWidget<W, RR, R>,
				RR extends PlatformRows<RR, W, R>,
				R extends PlatformRow<R, RR, W>
				>
		extends MultivalueHover<W, ListMultivalueHover<W, RR, R>> implements ParentRow<R> {
	private final R row;

	public ListMultivalueHover(W widget, String title, R row) {
		super(widget, title);
		this.row = row;
	}

	public ListMultivalueHover<W, RR, R> checkShortText(Consumer<String> shortText) {
		String text = element().$("p[class*='MultivalueHover__displayedValue']").text();
		shortText.accept(text);
		return this;
	}

	public R row() {
		return row;
	}

	@Override
	protected SelenideElement parentElement() {
		return row.element();
	}
}
