package core.element.widget.list.filter.header.filtration.filter;

import com.codeborne.selenide.Condition;
import core.element.widget.list.HeaderColumn;
import core.element.widget.list.ListWidget;
import core.element.widget.list.rows.PlatformRows;
import core.element.widget.list.rows.row.PlatformRow;

public class InlinePickListFilter<
		WIDGET extends ListWidget<WIDGET, ROWS, ROW>,
		ROWS extends PlatformRows<ROWS, WIDGET, ROW>,
		ROW extends PlatformRow<ROW, ROWS, WIDGET>,
		PARENT extends HeaderColumn<WIDGET, ROWS, ROW>,
		SELF extends InlinePickListFilter<WIDGET, ROWS, ROW, PARENT, SELF>
		> extends AbstractFilter<WIDGET, ROWS, ROW, String, PARENT, SELF> {


	public InlinePickListFilter(WIDGET widget, PARENT parent, String date) {
		super(widget, parent, date);
	}

	@Override
	public SELF filter(String value) {
		getParent().element().$(DATA_TEST_WIDGET_LIST_HEADER_COLUM_FILTER)
				.click();
		formFilter
				.$("input[data-test-filter-popup-value=\"true\"]")
				.shouldBe(Condition.editable, getWidget().getExpectations().getTimeout())
				.click();
		formFilter
				.$("input[data-test-filter-popup-value=\"true\"]")
				.shouldBe(Condition.editable, getWidget().getExpectations().getTimeout())
				.setValue(value);
		return (SELF) this;
	}

}
