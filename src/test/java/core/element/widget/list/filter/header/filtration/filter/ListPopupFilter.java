package core.element.widget.list.filter.header.filtration.filter;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import core.element.widget.list.HeaderColumn;
import core.element.widget.list.ListWidget;
import core.element.widget.list.rows.PlatformRows;
import core.element.widget.list.rows.row.PlatformRow;
import core.element.widget.type.PlatformTypeWidgets;

import java.util.List;
import java.util.LinkedHashSet;

import static core.element.PlatformApp.config;

import static com.codeborne.selenide.Selenide.$;

/**
 * Column filter of pickList ("..." button) and multivalue fields: the list popup opens in the filter mode,
 * the chosen records become the filter of the list (equalsOneOf by id). List analogue of {@link TreePopupFilter}.
 */
public class ListPopupFilter<
		WIDGET extends ListWidget<WIDGET, ROWS, ROW>,
		ROWS extends PlatformRows<ROWS, WIDGET, ROW>,
		ROW extends PlatformRow<ROW, ROWS, WIDGET>,
		PARENT extends HeaderColumn<WIDGET, ROWS, ROW>,
		SELF extends ListPopupFilter<WIDGET, ROWS, ROW, PARENT, SELF>
		> extends AbstractFilter<WIDGET, ROWS, ROW, List<String>, PARENT, SELF> {

	private static final String FILTER_POPUP = "div[data-test-filter-popup] div.ant-modal";

	private static final String HEADER_TITLE = "data-test-widget-list-header-column-title";

	public ListPopupFilter(WIDGET widget, PARENT parent, List<String> value) {
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
		getWidget().getExpectations().getWaitAllElements(popup);
		String column = getParent().name();
		List<String> columns = popup.$("table thead").shouldBe(Condition.visible, getWidget().getExpectations().getTimeout())
				.$$("th").stream().map(th -> th.getAttribute(HEADER_TITLE)).toList();
		int number = columns.indexOf(column);
		if (number < 0) {
			throw new IllegalArgumentException("No column with name '" + column + "' found in the filter popup");
		}
		var popupType = popup.closest("[data-test-widget-type]").getAttribute("data-test-widget-type");
		var list = PlatformTypeWidgets.PICK_LIST_POPUP.getType().equals(popupType)
				? config().parts.pickListPopup.create(getWidget()).list()
				: config().parts.multivalueModal.create(getWidget()).list();
		var missing = new LinkedHashSet<>(values);
		while (!missing.isEmpty()) {
			for (String value : List.copyOf(missing)) {
				var row = popup.$$("table tbody tr").shouldBe(CollectionCondition.sizeGreaterThan(0)).stream()
						.filter(r -> r.$$("td").get(number).getText().equals(value))
						.findFirst();
				if (row.isPresent()) {
					SelenideElement checkbox = row.get().$("td.ant-table-selection-column input").shouldBe(Condition.enabled);
					if (!checkbox.isSelected()) {
						checkbox.click();
					}
					missing.remove(value);
				}
			}
			if (!missing.isEmpty()) {
				if (list.pagination().isLastPage()) {
					throw new IllegalStateException("No rows with " + column + " = " + missing);
				}
				list.pagination().nextPage();
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
		getWidget().element();
		return getParent();
	}

}
