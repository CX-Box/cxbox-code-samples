package core.element.widget.list.filter.header.filtration.filter;

import core.element.widget.list.HeaderColumn;
import core.element.widget.list.ListWidget;
import core.element.widget.list.filter.header.modal.Calendar;
import core.element.widget.list.rows.PlatformRows;
import core.element.widget.list.rows.row.PlatformRow;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDateTime;
import java.util.List;

@Slf4j
public class DateTimeFromToFilter<
		WIDGET extends ListWidget<WIDGET, ROWS, ROW>,
		ROWS extends PlatformRows<ROWS, WIDGET, ROW>,
		ROW extends PlatformRow<ROW, ROWS, WIDGET>,
		PARENT extends HeaderColumn<WIDGET, ROWS, ROW>,
		SELF extends DateTimeFromToFilter<WIDGET, ROWS, ROW, PARENT, SELF>
		> extends AbstractFilter<WIDGET, ROWS, ROW, List<LocalDateTime>, PARENT, SELF> {

	public DateTimeFromToFilter(WIDGET widget, PARENT parent, List<LocalDateTime> localDates) {
		super(widget, parent, localDates);
	}

	@Override
	public SELF filter(List<LocalDateTime> localDates) {
		clickFilterIcon();
		var list = localDates.stream().map(Calendar::formattedDateTime).toList();
		Calendar.setDateField(list);
		return self();
	}

}
