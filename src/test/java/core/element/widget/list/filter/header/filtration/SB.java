package core.element.widget.list.filter.header.filtration;

import core.element.widget.list.ListWidget;
import core.element.widget.list.rows.PlatformRows;
import core.element.widget.list.rows.row.PlatformRow;

import java.util.List;

/**
 * SB - Sort Builder
 *
 * @param <W>
 * @param <S>
 */
public class SB<W extends ListWidget<W, ROWS, ROW>, ROWS extends PlatformRows<ROWS, W, ROW>, ROW extends PlatformRow<ROW, ROWS, W>, S extends SB<W, ROWS, ROW, S>> {
	private final List<String> container;

	public SB(List<String> container) {
		this.container = container;
	}

	public S sort(String name) {
		this.container.add(name);
		return (S) this;
	}
}
