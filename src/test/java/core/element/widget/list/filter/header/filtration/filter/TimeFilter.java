package core.element.widget.list.filter.header.filtration.filter;

import core.element.widget.list.HeaderColumn;
import core.element.widget.list.ListWidget;
import core.element.widget.list.filter.header.modal.Calendar;
import core.element.widget.list.rows.PlatformRows;
import core.element.widget.list.rows.row.PlatformRow;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TimeFilter<
		WIDGET extends ListWidget<WIDGET, ROWS, ROW>,
		ROWS extends PlatformRows<ROWS, WIDGET, ROW>,
		ROW extends PlatformRow<ROW, ROWS, WIDGET>,
		PARENT extends HeaderColumn<WIDGET, ROWS, ROW>,
		SELF extends TimeFilter<WIDGET, ROWS, ROW, PARENT, SELF>
		> extends AbstractFilter<WIDGET, ROWS, ROW, LocalDateTime, PARENT, SELF> {

	private final String pattern;

	public TimeFilter(WIDGET widget, PARENT parent, LocalDateTime date, String pattern) {
		super(widget, parent, date);
		this.pattern = pattern;
	}

	@Override
	public SELF filter(LocalDateTime date) {
		getParent().element().$(DATA_TEST_WIDGET_LIST_HEADER_COLUM_FILTER)
				.click();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
		Calendar.setTimeField(date.format(formatter), true);
		return (SELF) this;
	}

}
