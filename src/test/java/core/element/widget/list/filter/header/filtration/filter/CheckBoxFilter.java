package core.element.widget.list.filter.header.filtration.filter;

import com.codeborne.selenide.Condition;
import core.element.widget.list.HeaderColumn;
import core.element.widget.list.ListWidget;
import core.element.widget.list.rows.PlatformRows;
import core.element.widget.list.rows.row.PlatformRow;

public class CheckBoxFilter<
		WIDGET extends ListWidget<WIDGET, ROWS, ROW>,
		ROWS extends PlatformRows<ROWS, WIDGET, ROW>,
		ROW extends PlatformRow<ROW, ROWS, WIDGET>,
		PARENT extends HeaderColumn<WIDGET, ROWS, ROW>,
		SELF extends CheckBoxFilter<WIDGET, ROWS, ROW, PARENT, SELF>
		> extends AbstractFilter<WIDGET, ROWS, ROW, Boolean, PARENT, SELF> {


	public CheckBoxFilter(WIDGET widget, PARENT parent, Boolean value) {
		super(widget, parent, value);
	}

	@Override
	public SELF filter(Boolean value) {
		getParent().element().$(DATA_TEST_WIDGET_LIST_HEADER_COLUM_FILTER)
				.click();
		if (value) {
			setTrue();
		} else {
			setFalse();
		}
		return (SELF) this;
	}

	private void setTrue() {
		set();
		if (!getValue()) {
			set();
		}
	}

	private void setFalse() {
		set();
		if (getValue()) {
			set();
		}
	}

	private void set() {
		formFilter
				.$("form[class=\"ant-form ant-form-vertical\"]")
				.$("input")
				.shouldBe(Condition.exist, getWidget().getExpectations().getTimeout())
				.click();
	}

}
