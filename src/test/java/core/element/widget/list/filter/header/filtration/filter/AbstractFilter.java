package core.element.widget.list.filter.header.filtration.filter;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import core.element.widget.list.HeaderColumn;
import core.element.widget.list.ListWidget;
import core.element.widget.list.filter.header.modal.Popup;
import core.element.widget.list.rows.PlatformRows;
import core.element.widget.list.rows.row.PlatformRow;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.Optional;

import static com.codeborne.selenide.Selenide.$;

@Slf4j
public abstract class AbstractFilter<
		WIDGET extends ListWidget<WIDGET, ROWS, ROW>,
		ROWS extends PlatformRows<ROWS, WIDGET, ROW>,
		ROW extends PlatformRow<ROW, ROWS, WIDGET>,
		VALUE extends Object,
		PARENT extends HeaderColumn<WIDGET, ROWS, ROW>,
		SELF extends AbstractFilter<WIDGET, ROWS, ROW, VALUE, PARENT, SELF>
		> {

	protected static final String DATA_TEST_WIDGET_LIST_HEADER_COLUM_FILTER = "div[data-test-widget-list-header-column-filter=\"true\"]";

	@Getter(AccessLevel.PROTECTED)
	private final WIDGET widget;

	@Getter(AccessLevel.PROTECTED)
	private final PARENT parent;

	@Getter()
	private final VALUE value;

	SelenideElement formFilter = $("div[class*=\"ant-popover ant-popover-placement\"]");

	public AbstractFilter(WIDGET widget, PARENT parent, VALUE value) {
		this.widget = widget;
		this.parent = parent;
		this.value = value;
	}

	protected SelenideElement getFormFilter() {
		return formFilter;
	}


	public abstract SELF filter(VALUE value);

	public String formFilter() {
		return "div[class*=\"ant-popover ant-popover-placement\"]";
	}

	public PARENT apply() {
		$("button[data-test-filter-popup-apply=\"true\"]")
				.shouldBe(Condition.exist)
				.click();
		return this.parent;
	}

	public PARENT setClear() {
		$("button[data-test-filter-popup-clear=\"true\"]")
				.shouldBe(Condition.exist)
				.click();
		return this.parent;
	}

	public SelenideElement buttonPopup() {
		return formFilter.$("button[class=\"ant-btn ant-btn-icon-only\"]")
				.shouldBe(Condition.exist, widget.getExpectations().getTimeout());
	}

	protected PARENT column() {
		return parent;
	}

	protected Optional<Popup> findPopup() {
		if (buttonPopup().is(Condition.exist)) {
			buttonPopup().click();
			return Optional.of(new Popup());
		} else {
			return Optional.empty();
		}
	}

	protected void clickFilterIcon() {
		column().element().$(DATA_TEST_WIDGET_LIST_HEADER_COLUM_FILTER).click();
	}

	protected SELF self() {
		return (SELF) this;
	}
}
