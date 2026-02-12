package core.element.widget.list.filter.header.filtration.filter;

import core.element.widget.list.HeaderColumn;
import core.element.widget.list.ListWidget;
import core.element.widget.list.filter.header.modal.Calendar;
import core.element.widget.list.rows.PlatformRows;
import core.element.widget.list.rows.row.PlatformRow;

import java.time.LocalDate;
import java.util.List;

public class DateFromToFilter<
		WIDGET extends ListWidget<WIDGET, ROWS, ROW>,
		ROWS extends PlatformRows<ROWS, WIDGET, ROW>,
		ROW extends PlatformRow<ROW, ROWS, WIDGET>,
		PARENT extends HeaderColumn<WIDGET, ROWS, ROW>,
		SELF extends DateFromToFilter<WIDGET, ROWS, ROW, PARENT, SELF>
		> extends AbstractFilter<WIDGET, ROWS, ROW, List<LocalDate>, PARENT, SELF> {

	public DateFromToFilter(WIDGET widget, PARENT parent, List<LocalDate> localDates) {
		super(widget, parent, localDates);
	}

	@Override
	public SELF filter(List<LocalDate> localDates) {
		clickFilterIcon();
		Calendar.setDateField(localDates.stream().map(Calendar::formattedDate).toList());
		return self();
	}

}
