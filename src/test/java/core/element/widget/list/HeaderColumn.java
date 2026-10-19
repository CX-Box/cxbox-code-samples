package core.element.widget.list;

import lombok.Getter;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import core.common.SingleElement;
import core.element.widget.list.rows.PlatformRows;
import core.element.widget.list.rows.row.PlatformRow;
import org.openqa.selenium.StaleElementReferenceException;

public class HeaderColumn<WIDGET extends ListWidget<WIDGET, ROWS, ROW>, ROWS extends PlatformRows<ROWS, WIDGET, ROW>, ROW extends PlatformRow<ROW, ROWS, WIDGET>> implements SingleElement {

	@Getter
	private final String name;

	private final WIDGET widget;

	private final ListHeaders<WIDGET, ROWS, ROW> headers;

	public HeaderColumn(String name, WIDGET widget, ListHeaders<WIDGET, ROWS, ROW> headers) {
		this.name = name;
		this.widget = widget;
		this.headers = headers;
	}

	public String name() {
		return name;
	}

	public WIDGET widget() {
		return widget;
	}

	@Override
	/**
	 * The header of the column, scrolled to the middle of the screen, as a field is: a header scrolled under the fixed
	 * header of the view gives the click to the tabs of the view
	 */
	public SelenideElement element() throws StaleElementReferenceException {
		return headers.element()
				.filter(Condition.attribute(widget.headerTitleAttribute(), name))
				.first()
				.scrollIntoView("{block: \"center\"}");
	}

}
