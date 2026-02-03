package core.element.widget.list;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import core.common.IterableElement;
import core.element.widget.list.filter.header.filtration.FB;
import core.element.widget.list.filter.header.filtration.FC;
import core.element.widget.list.filter.header.filtration.SB;
import core.element.widget.list.filter.header.filtration.SC;
import core.element.widget.list.rows.PlatformRows;
import core.element.widget.list.rows.row.PlatformRow;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.StaleElementReferenceException;

import java.util.function.Consumer;

// need List widget
@Slf4j
public class ListHeaders<W extends ListWidget<W, ROWS, ROW>, ROWS extends PlatformRows<ROWS, W, ROW>, ROW extends PlatformRow<ROW, ROWS, W>> implements IterableElement {

	private final W widget;

	private final FC<W, ROWS, ROW> FC;

	public ListHeaders(W widget) {
		this.widget = widget;
		this.FC = new FC<>(widget);
	}

	@Override
	public ElementsCollection element() throws StaleElementReferenceException {
		widget().getExpectations().getWaitAllElements(widget().element());
		return this.widget().element()
				.shouldBe(Condition.visible, widget().getExpectations().getTimeout())
				.$("table").shouldBe(Condition.visible, widget().getExpectations().getTimeout())
				.$("thead").shouldBe(Condition.visible, widget().getExpectations().getTimeout())
				.$$("th");
	}

	// ui filtration
	public ListHeaders<W, ROWS, ROW> filter(Consumer<FB<W, ?, ?, ?>> fb) {
		FB<W, ?, ?, ?> FBRInstance = new FB<>(FC.getContainer(), widget, this);
		fb.accept(FBRInstance);
		FC.executeFilters();
		return this;
	}

	// ui sort
	public ListHeaders<W, ROWS, ROW> sort(Consumer<SB<W, ?, ?, ?>> sb) {
		SC<W, ?, ?> FSRC = new SC<>(widget());
		SB<W, ?, ?, ?> sbInstanse = new SB<>(FSRC.getContainer());
		sb.accept(sbInstanse);
		FSRC.executeSort();
		return this;
	}

	// ui filtration and sort
	public W filterAndSort(Consumer<FB<W, ?, ?, ?>> fb, Consumer<SB<W, ?, ?, ?>> sb) {
		sort(sb);
		filter(fb);
		return widget;
	}

	public W widget() {
		return widget;
	}

	public HeaderColumn<W, ROWS, ROW> headerColumn(String name) {
		return new HeaderColumn<>(
				name,
				widget(),
				this
		);
	}
}
