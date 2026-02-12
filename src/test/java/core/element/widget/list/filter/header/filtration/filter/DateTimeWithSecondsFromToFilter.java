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
public class DateTimeWithSecondsFromToFilter<
		WIDGET extends ListWidget<WIDGET, ROWS, ROW>,
		ROWS extends PlatformRows<ROWS, WIDGET, ROW>,
		ROW extends PlatformRow<ROW, ROWS, WIDGET>,
		PARENT extends HeaderColumn<WIDGET, ROWS, ROW>,
		SELF extends DateTimeWithSecondsFromToFilter<WIDGET, ROWS, ROW, PARENT, SELF>
		> extends AbstractFilter<WIDGET, ROWS, ROW, List<LocalDateTime>, PARENT, SELF> {


	public DateTimeWithSecondsFromToFilter(WIDGET widget, PARENT parent, List<LocalDateTime> date) {
		super(widget, parent, date);
	}

	@Override
	public SELF filter(List<LocalDateTime> date) {
		clickFilterIcon();
		var list = date.stream().map(Calendar::formattedDateTimeWithSecond).toList();
		Calendar.setDateField(list);
		return self();
	}

}
