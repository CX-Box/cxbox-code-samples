package core.element.widget.list.filter.header.filtration.filter;

import com.codeborne.selenide.Condition;
import core.element.widget.list.HeaderColumn;
import core.element.widget.list.ListWidget;
import core.element.widget.list.rows.PlatformRows;
import core.element.widget.list.rows.row.PlatformRow;

import java.util.List;

public class NumberFromToFilter<
		WIDGET extends ListWidget<WIDGET, ROWS, ROW>,
		ROWS extends PlatformRows<ROWS, WIDGET, ROW>,
		ROW extends PlatformRow<ROW, ROWS, WIDGET>,
		PARENT extends HeaderColumn<WIDGET, ROWS, ROW>,
		SELF extends NumberFromToFilter<WIDGET, ROWS, ROW, PARENT, SELF>
		> extends AbstractFilter<WIDGET, ROWS, ROW, List<Number>, PARENT, SELF> {

	public NumberFromToFilter(WIDGET widget, PARENT parent, List<Number> values) {
		super(widget, parent, values);
	}

	@Override
	public SELF filter(List<Number> values) {
		clickFilterIcon();
		formFilter.$("input[data-test-filter-popup-start-value=\"true\"]")
				.shouldBe(Condition.editable, getWidget().getExpectations().getTimeout())
				.click();
		formFilter.$("input[data-test-filter-popup-start-value=\"true\"]")
				.shouldBe(Condition.enabled, getWidget().getExpectations().getTimeout())
				.clear();
		formFilter.$("input[data-test-filter-popup-start-value=\"true\"]")
				.shouldBe(Condition.enabled, getWidget().getExpectations().getTimeout())
				.setValue(String.valueOf(values.get(0)));

		formFilter.$("input[data-test-filter-popup-end-value=\"true\"]")
				.shouldBe(Condition.editable, getWidget().getExpectations().getTimeout())
				.click();
		formFilter.$("input[data-test-filter-popup-end-value=\"true\"]")
				.shouldBe(Condition.enabled, getWidget().getExpectations().getTimeout())
				.clear();
		formFilter.$("input[data-test-filter-popup-end-value=\"true\"]")
				.shouldBe(Condition.enabled, getWidget().getExpectations().getTimeout())
				.setValue(String.valueOf(values.get(1)));
		return self();
	}

}
