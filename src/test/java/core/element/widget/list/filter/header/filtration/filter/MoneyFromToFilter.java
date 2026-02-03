package core.element.widget.list.filter.header.filtration.filter;

import com.codeborne.selenide.Condition;
import core.element.widget.list.HeaderColumn;
import core.element.widget.list.ListWidget;
import core.element.widget.list.rows.PlatformRows;
import core.element.widget.list.rows.row.PlatformRow;

import java.math.BigDecimal;
import java.util.List;

import static com.codeborne.selenide.Selenide.$;

public class MoneyFromToFilter<
		WIDGET extends ListWidget<WIDGET, ROWS, ROW>,
		ROWS extends PlatformRows<ROWS, WIDGET, ROW>,
		ROW extends PlatformRow<ROW, ROWS, WIDGET>,
		PARENT extends HeaderColumn<WIDGET, ROWS, ROW>,
		SELF extends MoneyFromToFilter<WIDGET, ROWS, ROW, PARENT, SELF>
		> extends AbstractFilter<WIDGET, ROWS, ROW, List<BigDecimal>, PARENT, SELF> {


	public MoneyFromToFilter(WIDGET widget, PARENT parent, List<BigDecimal> date) {
		super(widget, parent, date);
	}

	@Override
	public SELF filter(List<BigDecimal> value) {
		if (value.size() != 2) {
			throw new IllegalStateException("Count values must be 2");
		}
		String pattern = "^\\d+,\\d+$";
		List<String> values = value.stream().map(BigDecimal::toString).map(s -> s.replace(".", ",")).filter(v -> v.matches(pattern)).toList();
		if (values.size() != value.size()) {
			throw new IllegalArgumentException("The values " + value + " is not a valid " + pattern);
		}
		getParent().element().$(DATA_TEST_WIDGET_LIST_HEADER_COLUM_FILTER)
				.click();
		$("div[class*=\"ant-popover ant-popover-placement\"]").$("input[data-test-filter-popup-start-value=\"true\"]")
				.shouldBe(Condition.editable, getWidget().getExpectations().getTimeout())
				.click();
		$("div[class*=\"ant-popover ant-popover-placement\"]").$("input[data-test-filter-popup-start-value=\"true\"]")
				.shouldBe(Condition.editable, getWidget().getExpectations().getTimeout())
				.setValue(values.get(0));

		$("div[class*=\"ant-popover ant-popover-placement\"]").$("input[data-test-filter-popup-end-value=\"true\"]")
				.shouldBe(Condition.editable, getWidget().getExpectations().getTimeout())
				.click();
		$("div[class*=\"ant-popover ant-popover-placement\"]").$("input[data-test-filter-popup-end-value=\"true\"]")
				.shouldBe(Condition.editable, getWidget().getExpectations().getTimeout())
				.setValue(values.get(1));
		return (SELF) this;
	}

}
