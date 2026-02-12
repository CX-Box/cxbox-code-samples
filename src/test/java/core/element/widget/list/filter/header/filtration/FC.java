package core.element.widget.list.filter.header.filtration;

import core.element.widget.list.ListWidget;
import core.element.widget.list.filter.header.filtration.filter.AbstractFilter;
import core.element.widget.list.rows.PlatformRows;
import core.element.widget.list.rows.row.PlatformRow;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

/**
 * FC - Filter Configuration
 *
 * @param <W>
 */
@SuppressWarnings("unchecked")
@Slf4j
public class FC<W extends ListWidget<W, ROWS, ROW>, ROWS extends PlatformRows<ROWS, W, ROW>, ROW extends PlatformRow<ROW, ROWS, W>> {

	private final W widget;

	@Getter
	private List<AbstractFilter> container;

	public FC(W widget) {
		container = new ArrayList<>();
		this.widget = widget;
	}

	public void executeFilters() {
		container.forEach(fc -> {
			fc
					.filter(fc.getValue())
					.apply();
		});
	}
}
