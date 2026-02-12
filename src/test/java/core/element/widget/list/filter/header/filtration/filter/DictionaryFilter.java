package core.element.widget.list.filter.header.filtration.filter;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import core.element.widget.list.HeaderColumn;
import core.element.widget.list.ListWidget;
import core.element.widget.list.rows.PlatformRows;
import core.element.widget.list.rows.row.PlatformRow;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class DictionaryFilter<
		WIDGET extends ListWidget<WIDGET, ROWS, ROW>,
		ROWS extends PlatformRows<ROWS, WIDGET, ROW>,
		ROW extends PlatformRow<ROW, ROWS, WIDGET>,
		PARENT extends HeaderColumn<WIDGET, ROWS, ROW>,
		SELF extends DictionaryFilter<WIDGET, ROWS, ROW, PARENT, SELF>
		> extends AbstractFilter<WIDGET, ROWS, ROW, String, PARENT, SELF> {


	public DictionaryFilter(WIDGET widget, PARENT parent, String value) {
		super(widget, parent, value);
	}

	@Override
	public SELF filter(String value) {
		getParent().element().$(DATA_TEST_WIDGET_LIST_HEADER_COLUM_FILTER)
				.click();
		getOptionDictionary(value)
				.shouldBe(Condition.enabled, getWidget().getExpectations().getTimeout())
				.$(By.tagName("label"))
				.click();

		return (SELF) this;
	}


	private SelenideElement getOptionDictionary(String value) {
		return getOptionsDictionary()
				.find(Condition.match("check action name: " + value, b -> b.getText().equals(value)))
				.scrollIntoView("{block: \"center\"}");
	}

	private ElementsCollection getOptionsDictionary() {
		return $("form[class=\"ant-form ant-form-vertical\"]")
				.$$(By.tagName("li"));
	}

	public void setApply() {
		$("div[class=\"ant-popover-inner-content\"]")
				.$("button[data-test-filter-popup-apply=\"true\"]")
				.shouldBe(Condition.visible)
				.click();
	}


}
