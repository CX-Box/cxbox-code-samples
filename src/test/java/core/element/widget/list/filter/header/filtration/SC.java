package core.element.widget.list.filter.header.filtration;

import com.codeborne.selenide.Condition;
import core.element.widget.list.ListWidget;
import core.element.widget.list.rows.PlatformRows;
import core.element.widget.list.rows.row.PlatformRow;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

/**
 * SC - Sort configuration
 *
 * @param <W>
 */
public class SC<W extends ListWidget<W, ROWS, ROW>, ROWS extends PlatformRows<ROWS, W, ROW>, ROW extends PlatformRow<ROW, ROWS, W>> {

	private final W widget;

	@Getter
	private final List<String> container = new ArrayList<>();

	public SC(W widget) {
		this.widget = widget;
	}

	public void executeSort() {
		String columName = container.get(0);
		widget.headers()
				.headerColumn(columName)
				.element()
				.shouldBe(Condition.enabled, widget.getExpectations().getTimeout())
				.hover()
				.$("div[data-test-widget-list-header-column-sort=\"true\"] i.anticon-caret-down")
				.shouldBe(Condition.exist, widget.getExpectations().getTimeout())
				.shouldBe(Condition.visible, widget.getExpectations().getTimeout())
				.click();
	}


}
