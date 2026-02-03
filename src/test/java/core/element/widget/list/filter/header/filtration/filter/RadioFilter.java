package core.element.widget.list.filter.header.filtration.filter;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import core.element.widget.list.HeaderColumn;
import core.element.widget.list.ListWidget;
import core.element.widget.list.rows.PlatformRows;
import core.element.widget.list.rows.row.PlatformRow;

public class RadioFilter<
		WIDGET extends ListWidget<WIDGET, ROWS, ROW>,
		ROWS extends PlatformRows<ROWS, WIDGET, ROW>,
		ROW extends PlatformRow<ROW, ROWS, WIDGET>,
		PARENT extends HeaderColumn<WIDGET, ROWS, ROW>,
		SELF extends RadioFilter<WIDGET, ROWS, ROW, PARENT, SELF>
		> extends AbstractFilter<WIDGET, ROWS, ROW, String, PARENT, SELF> {


	public RadioFilter(WIDGET widget, PARENT parent, String value) {
		super(widget, parent, value);
	}

	@Override
	public SELF filter(String value) {
		getParent().element().$(DATA_TEST_WIDGET_LIST_HEADER_COLUM_FILTER)
				.click();
		getRadio(value).click();
		return (SELF) this;
	}

	private SelenideElement getRadio(String nameRadio) {
		return getContainersActions().find(Condition.match("check action name: " + nameRadio, b -> b.getAttribute("value").equals(nameRadio)));
	}

	private ElementsCollection getContainersActions() {
		return formFilter.$("form[class=\"ant-form ant-form-vertical\"]")
				.$$("input")
				.shouldHave(CollectionCondition.sizeGreaterThan(0));
	}
}
