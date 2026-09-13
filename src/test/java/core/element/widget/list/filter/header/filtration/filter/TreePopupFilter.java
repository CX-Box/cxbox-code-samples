package core.element.widget.list.filter.header.filtration.filter;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import core.element.widget.list.HeaderColumn;
import core.element.widget.list.ListWidget;
import core.element.widget.list.rows.PlatformRows;
import core.element.widget.list.rows.row.PlatformRow;
import core.element.widget.tree.TreeNavigation;

import java.util.List;

import static com.codeborne.selenide.Selenide.$;

/**
 * Column filter of multivalueTree (filter icon) and pickTree ("..." button) fields: the AssocTreePopup opens
 * in the filter mode, the chosen records become the filter of the list (equalsOneOf by id).
 */
public class TreePopupFilter<
		WIDGET extends ListWidget<WIDGET, ROWS, ROW>,
		ROWS extends PlatformRows<ROWS, WIDGET, ROW>,
		ROW extends PlatformRow<ROW, ROWS, WIDGET>,
		PARENT extends HeaderColumn<WIDGET, ROWS, ROW>,
		SELF extends TreePopupFilter<WIDGET, ROWS, ROW, PARENT, SELF>
		> extends AbstractFilter<WIDGET, ROWS, ROW, List<String>, PARENT, SELF> {

	private static final String FILTER_POPUP = "div[data-test-filter-popup] div.ant-modal";

	public TreePopupFilter(WIDGET widget, PARENT parent, List<String> value) {
		super(widget, parent, value);
	}

	@Override
	public SELF filter(List<String> values) {
		getParent().element().$(DATA_TEST_WIDGET_LIST_HEADER_COLUM_FILTER).click();
		SelenideElement moreButton = $("div.ant-popover:not(.ant-popover-hidden) button i.anticon-ellipsis").parent();
		if (moreButton.exists()) {
			moreButton.click();
		}
		SelenideElement popup = $(FILTER_POPUP).shouldBe(Condition.visible, getWidget().getExpectations().getTimeout());
		TreeNavigation.loadWholeTree(popup, getWidget().getExpectations());
		String column = getParent().name();
		List<String> columns = TreeNavigation.columnNames(popup, getWidget().getExpectations());
		int number = columns.indexOf(column);
		if (number < 0) {
			throw new IllegalArgumentException("No column with name '" + column + "' found in the filter popup");
		}
		for (String value : values) {
			SelenideElement row = TreeNavigation.rows(popup).stream()
					.filter(r -> r.$$("td").get(number).getText().equals(value))
					.findFirst()
					.orElseThrow(() -> new IllegalStateException("No row with " + column + " = " + value));
			if (!row.$(TreeNavigation.ROW_SELECT_SELECTOR).isSelected()) {
				row.$(TreeNavigation.ROW_SELECT_SELECTOR).shouldBe(Condition.enabled).click();
			}
		}
		return (SELF) this;
	}

	/** The popup is applied by its Save button, not by the filter popover. */
	@Override
	public PARENT apply() {
		SelenideElement popup = $(FILTER_POPUP);
		popup.$("button[data-test-widget-list-save]").click();
		popup.shouldNot(Condition.exist, getWidget().getExpectations().getTimeout());
		getWidget().getExpectations().getWaitAllElements(getWidget().element());
		return getParent();
	}

}
