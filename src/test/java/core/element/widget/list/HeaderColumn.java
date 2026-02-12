package core.element.widget.list;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import core.common.SingleElement;
import core.element.widget.list.rows.PlatformRows;
import core.element.widget.list.rows.row.PlatformRow;
import org.openqa.selenium.StaleElementReferenceException;

public class HeaderColumn<WIDGET extends ListWidget<WIDGET, ROWS, ROW>, ROWS extends PlatformRows<ROWS, WIDGET, ROW>, ROW extends PlatformRow<ROW, ROWS, WIDGET>> implements SingleElement {

	private final String name;

	private final WIDGET widget;

	private final ListHeaders<WIDGET, ROWS, ROW> headers;

	public HeaderColumn(String name, WIDGET widget, ListHeaders<WIDGET, ROWS, ROW> headers) {
		this.name = name;
		this.widget = widget;
		this.headers = headers;
	}

	public WIDGET widget() {
		return widget;
	}

	@Override
	public SelenideElement element() throws StaleElementReferenceException {
		return headers.element()
				.filter(Condition.attribute("data-test-widget-list-header-column-title", name))
				.first();
	}

}
