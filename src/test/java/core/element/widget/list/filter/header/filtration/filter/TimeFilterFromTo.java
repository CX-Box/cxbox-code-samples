package core.element.widget.list.filter.header.filtration.filter;

import core.element.widget.list.HeaderColumn;
import core.element.widget.list.ListWidget;
import core.element.widget.list.filter.header.modal.Calendar;
import core.element.widget.list.rows.PlatformRows;
import core.element.widget.list.rows.row.PlatformRow;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

public class TimeFilterFromTo<
		WIDGET extends ListWidget<WIDGET, ROWS, ROW>,
		ROWS extends PlatformRows<ROWS, WIDGET, ROW>,
		ROW extends PlatformRow<ROW, ROWS, WIDGET>,
		PARENT extends HeaderColumn<WIDGET, ROWS, ROW>,
		SELF extends TimeFilterFromTo<WIDGET, ROWS, ROW, PARENT, SELF>
		> extends AbstractFilter<WIDGET, ROWS, ROW, List<LocalDateTime>, PARENT, SELF> {

	private final String pattern;

	public TimeFilterFromTo(WIDGET widget, PARENT parent, List<LocalDateTime> date, String pattern) {
		super(widget, parent, date);
		this.pattern = pattern;
	}

	@Override
	public SELF filter(List<LocalDateTime> date) {
		getParent().element().$(DATA_TEST_WIDGET_LIST_HEADER_COLUM_FILTER)
				.click();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
		Calendar.setTimeField(date.stream().map(formatter::format).collect(Collectors.toList()));
		return (SELF) this;
	}

}
