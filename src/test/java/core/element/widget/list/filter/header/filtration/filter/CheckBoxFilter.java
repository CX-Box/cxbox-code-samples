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
		getParent().element().$(DATA_TEST_WIDGET_LIST_HEADER_COLUM_FILTER).click();
		var checkbox = formFilter.$("form.ant-form input[type='checkbox']")
				.shouldBe(Condition.interactable, getWidget().getExpectations().getTimeout());
		// A false condition needs an onChange even when the initial control is unchecked (no filter).
		checkbox.click();
		if (checkbox.isSelected() != value) {
			checkbox.click();
		}
		checkbox.shouldBe(value ? Condition.selected : Condition.not(Condition.selected));
		return (SELF) this;
	}
}
