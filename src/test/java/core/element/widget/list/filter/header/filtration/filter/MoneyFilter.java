package core.element.widget.list.filter.header.filtration.filter;

import com.codeborne.selenide.Condition;
import core.element.widget.list.HeaderColumn;
import core.element.widget.list.ListWidget;
import core.element.widget.list.rows.PlatformRows;
import core.element.widget.list.rows.row.PlatformRow;

import java.math.BigDecimal;

import static com.codeborne.selenide.Selenide.$;

public class MoneyFilter<
		WIDGET extends ListWidget<WIDGET, ROWS, ROW>,
		ROWS extends PlatformRows<ROWS, WIDGET, ROW>,
		ROW extends PlatformRow<ROW, ROWS, WIDGET>,
		PARENT extends HeaderColumn<WIDGET, ROWS, ROW>,
		SELF extends MoneyFilter<WIDGET, ROWS, ROW, PARENT, SELF>
		> extends AbstractFilter<WIDGET, ROWS, ROW, BigDecimal, PARENT, SELF> {


	public MoneyFilter(WIDGET widget, PARENT parent, BigDecimal date) {
		super(widget, parent, date);
	}

	@Override
	public SELF filter(BigDecimal value) {
		String str = value.toString();
		String pattern = "^\\d+,\\d+$";
		str = str.replace(".", ",");
		if (!str.matches(pattern)) {
			throw new IllegalArgumentException("The value " + value + " is not a valid " + pattern);
		}
		getParent().element().$(DATA_TEST_WIDGET_LIST_HEADER_COLUM_FILTER)
				.click();
		$("div[class*=\"ant-popover ant-popover-placement\"]").$("input[data-test-filter-popup-value=\"true\"]")
				.shouldBe(Condition.editable, getWidget().getExpectations().getTimeout())
				.click();
		$("div[class*=\"ant-popover ant-popover-placement\"]").$("input[data-test-filter-popup-value=\"true\"]")
				.shouldBe(Condition.editable, getWidget().getExpectations().getTimeout())
				.setValue(str);

		return (SELF) this;
	}

}
