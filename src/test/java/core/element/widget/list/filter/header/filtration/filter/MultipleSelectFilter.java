package core.element.widget.list.filter.header.filtration.filter;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import core.element.widget.list.HeaderColumn;
import core.element.widget.list.ListWidget;
import core.element.widget.list.rows.PlatformRows;
import core.element.widget.list.rows.row.PlatformRow;
import org.openqa.selenium.By;

import java.util.Set;

import static com.codeborne.selenide.Selenide.$;

public class MultipleSelectFilter<
		WIDGET extends ListWidget<WIDGET, ROWS, ROW>,
		ROWS extends PlatformRows<ROWS, WIDGET, ROW>,
		ROW extends PlatformRow<ROW, ROWS, WIDGET>,
		PARENT extends HeaderColumn<WIDGET, ROWS, ROW>,
		SELF extends MultipleSelectFilter<WIDGET, ROWS, ROW, PARENT, SELF>
		> extends AbstractFilter<WIDGET, ROWS, ROW, Set<String>, PARENT, SELF> {


	public MultipleSelectFilter(WIDGET widget, PARENT parent, Set<String> values) {
		super(widget, parent, values);
	}

	@Override
	public SELF filter(Set<String> values) {
		getParent().element().$(DATA_TEST_WIDGET_LIST_HEADER_COLUM_FILTER)
				.click();
		values.forEach(value -> {
			if (!isSelected(value)) {
				getOption(value)
						.shouldBe(Condition.enabled, getWidget().getExpectations().getTimeout())
						.$(By.tagName("input"))
						.click();
			}
		});
		return (SELF) this;
	}

	private Boolean isSelected(String option) {
		return Boolean.parseBoolean(getOption(option).getAttribute("aria-selected"));
	}

	private SelenideElement getOption(String nameRadio) {
		return getOptionsMultipleSelect().find(Condition.match("check action name: " + nameRadio, b -> b.getText().equals(nameRadio)));
	}

	private ElementsCollection getOptionsMultipleSelect() {
		return $("div[class=\"ant-popover-inner\"]")
				.$("form[class=\"ant-form ant-form-vertical\"]")
				.$$(By.tagName("li"));
	}
}
