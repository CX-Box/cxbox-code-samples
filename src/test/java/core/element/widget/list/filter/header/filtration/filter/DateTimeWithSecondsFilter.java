package core.element.widget.list.filter.header.filtration.filter;


import core.element.widget.list.HeaderColumn;
import core.element.widget.list.ListWidget;
import core.element.widget.list.filter.header.modal.Calendar;
import core.element.widget.list.rows.PlatformRows;
import core.element.widget.list.rows.row.PlatformRow;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDateTime;

@Slf4j
public class DateTimeWithSecondsFilter<
		WIDGET extends ListWidget<WIDGET, ROWS, ROW>,
		ROWS extends PlatformRows<ROWS, WIDGET, ROW>,
		ROW extends PlatformRow<ROW, ROWS, WIDGET>,
		PARENT extends HeaderColumn<WIDGET, ROWS, ROW>,
		SELF extends DateTimeWithSecondsFilter<WIDGET, ROWS, ROW, PARENT, SELF>
		> extends AbstractFilter<WIDGET, ROWS, ROW, LocalDateTime, PARENT, SELF> {


	public DateTimeWithSecondsFilter(WIDGET widget, PARENT parent, LocalDateTime date) {
		super(widget, parent, date);
	}

	@Override
	public SELF filter(LocalDateTime date) {

		getParent().element().$(DATA_TEST_WIDGET_LIST_HEADER_COLUM_FILTER)
				.click();
		Calendar.setDateField(Calendar.formattedDateTimeWithSecond(date));

		return (SELF) this;
	}

}
