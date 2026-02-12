package core.element.widget.list.filter.header.filtration.filter;

import core.element.widget.list.HeaderColumn;
import core.element.widget.list.ListWidget;
import core.element.widget.list.rows.PlatformRows;
import core.element.widget.list.rows.row.PlatformRow;

public class FileUploadFilter<
		WIDGET extends ListWidget<WIDGET, ROWS, ROW>,
		ROWS extends PlatformRows<ROWS, WIDGET, ROW>,
		ROW extends PlatformRow<ROW, ROWS, WIDGET>,
		PARENT extends HeaderColumn<WIDGET, ROWS, ROW>,
		SELF extends FileUploadFilter<WIDGET, ROWS, ROW, PARENT, SELF>
		> extends InputFilter<WIDGET, ROWS, ROW, PARENT, SELF> {


	public FileUploadFilter(WIDGET widget, PARENT parent, String value) {
		super(widget, parent, value);
	}
}
