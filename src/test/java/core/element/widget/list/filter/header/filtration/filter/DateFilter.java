package core.element.widget.list.filter.header.filtration.filter;

import core.element.widget.list.HeaderColumn;
import core.element.widget.list.ListWidget;
import core.element.widget.list.filter.header.modal.Calendar;
import core.element.widget.list.rows.PlatformRows;
import core.element.widget.list.rows.row.PlatformRow;

import java.time.LocalDate;

public class DateFilter<
		WIDGET extends ListWidget<WIDGET, ROWS, ROW>,
		ROWS extends PlatformRows<ROWS, WIDGET, ROW>,
		ROW extends PlatformRow<ROW, ROWS, WIDGET>,
		PARENT extends HeaderColumn<WIDGET, ROWS, ROW>,
		SELF extends DateFilter<WIDGET, ROWS, ROW, PARENT, SELF>
		> extends AbstractFilter<WIDGET, ROWS, ROW, LocalDate, PARENT, SELF> {


	public DateFilter(WIDGET widget, PARENT parent, LocalDate date) {
		super(widget, parent, date);
	}

	@Override
	public SELF filter(LocalDate date) {
		getParent().element().$(DATA_TEST_WIDGET_LIST_HEADER_COLUM_FILTER)
				.click();
		Calendar.setDateField(date.toString());
		return (SELF) this;
	}

}
