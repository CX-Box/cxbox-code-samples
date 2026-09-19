package core.element.widget.list;

import core.common.Identifier;
import core.element.widget.PlatformWidget;
import core.element.widget.action.Action;
import core.element.widget.action.FileUploadDnd;
import core.element.widget.list.rows.PlatformRows;
import core.element.widget.list.rows.row.PlatformRow;

public abstract class ListWidget<SELF extends ListWidget<SELF, ROWS, ROW>, ROWS extends PlatformRows<ROWS, SELF, ROW>, ROW extends PlatformRow<ROW, ROWS, SELF>> extends PlatformWidget<SELF> {

	public ListWidget(Identifier identifier, String textIdenfier) {
		super(identifier, textIdenfier);
	}

	public abstract ROWS rows();

	public ListHeaders<SELF, ROWS, ROW> headers() {
		return new ListHeaders<>(self());
	}

	public Pagination<?, SELF> pagination() {
		return new ListPagination<>(self());
	}

	@SuppressWarnings("unchecked")
	public SELF self() {
		return (SELF) this;
	}

	public Action<SELF> actions() {
		return new Action<>(self());
	}

	/** The drag-and-drop zone of the multi-upload. */
	public FileUploadDnd<SELF> fileUploadDnd() {
		return new FileUploadDnd<>(self());
	}

	/** data-test attribute that holds the column title in the table header. */
	public String headerTitleAttribute() {
		return "data-test-widget-list-header-column-title";
	}

	/** The gear menu of the widget. */
	public WidgetSettings<SELF> settings() {
		return new WidgetSettings<>(self());
	}

}