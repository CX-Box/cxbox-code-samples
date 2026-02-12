package core.element.widget.list.rows;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import core.element.widget.list.ListWidget;
import core.element.widget.list.Rows;
import core.element.widget.list.rows.row.PlatformRow;
import core.element.widget.list.rows.stream.StreamHelper;
import core.element.widget.list.rows.stream.StreamWithPagination;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;

import java.util.stream.Stream;


@Slf4j
public abstract class PlatformRows<SELF extends PlatformRows<SELF, WIDGET, ROW>, WIDGET extends ListWidget<WIDGET, SELF, ROW>, ROW extends PlatformRow<ROW, SELF, WIDGET>> extends Rows<PlatformRows<SELF, WIDGET, ROW>, WIDGET> {

	protected static final String ROW_ID_ATTRIBUTE = "data-test-widget-list-row-id";

	public PlatformRows(WIDGET widget) {
		super(widget);
	}

	@Override
	public ElementsCollection element() {
		widget().getExpectations().getWaitAllElements(widget().element());
		return widget().element()
				.shouldBe(Condition.visible, widget().getExpectations().getTimeout())
				.$$(By.cssSelector("table > tbody > tr"));
	}

	public abstract ROW row(int number);

	//  can use for filtration ( if not available UI filter)
	// this get all rows ( <tr> ) from table, this get from current page only
	public Stream<ROW> streamCurrentPage() {
		StreamHelper<WIDGET, SELF, ROW> streamHelper = new StreamHelper<>(widget());
		return streamHelper.streamCurrentPage();
	}


	//  can use for filtration ( if not available UI filter)
	// this get all rows ( <tr> ) from table, this get from all page ( iterate all data)
	// TODO deprecated in GH
	public StreamWithPagination<ROW> streamAllPages() {
		widget().pagination().firstPage();
		StreamHelper<WIDGET, SELF, ROW> streamHelper = new StreamHelper<>(widget());
		return StreamWithPagination.of(streamHelper.streamOnAllPages());
	}

}