package core.element.widget.list.filter.header.filtration;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import core.element.widget.list.ListWidget;
import core.element.widget.list.rows.PlatformRows;
import core.element.widget.list.rows.row.PlatformRow;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

/**
 * SC - Sort configuration
 *
 * @param <W>
 */
public class SC<W extends ListWidget<W, ROWS, ROW>, ROWS extends PlatformRows<ROWS, W, ROW>, ROW extends PlatformRow<ROW, ROWS, W>> {

	private static final String LOADING_SPINNER = ".ant-spin-spinning";

	private final W widget;

	@Getter
	private final List<String> container = new ArrayList<>();

	public SC(W widget) {
		this.widget = widget;
	}

	public void executeSort() {
		String columName = container.get(0);
		SelenideElement sort = widget.headers()
				.headerColumn(columName)
				.element()
				.shouldBe(Condition.enabled, widget.getExpectations().getTimeout())
				.$("div[data-test-widget-list-header-column-sort=\"true\"]");
		String sortStateBefore = sort.getAttribute("class");
		sort.parent()
				.hover()
				.$("i.anticon-caret-down")
				.shouldBe(Condition.visible, widget.getExpectations().getTimeout())
				.click();
		// the sort direction class changes in the same render that shows the loading spinner,
		// the rows are sorted when the spinner is gone
		sort.shouldNotHave(Condition.attribute("class", sortStateBefore), widget.getExpectations().getTimeout());
		sort.$x("ancestor::div[@data-test='WIDGET']")
				.$(LOADING_SPINNER)
				.shouldNot(Condition.exist, widget.getExpectations().getOverTimeout());
	}


}
