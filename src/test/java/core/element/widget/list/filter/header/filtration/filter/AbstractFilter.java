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
import static com.codeborne.selenide.Selenide.$$;

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

	private static final String LOADING_SPINNER = ".ant-spin-spinning";

	@Getter(AccessLevel.PROTECTED)
	private final WIDGET widget;

	@Getter(AccessLevel.PROTECTED)
	private final PARENT parent;

	@Getter()
	private final VALUE value;

	private static final String FILTER_FORM = "form[data-test-filter-popup=\"true\"]";

	/** The opened filter popup: the container of the visible filter form (closed popups stay in the page hidden). */
	SelenideElement formFilter = $$(FILTER_FORM).findBy(Condition.visible).parent();

	public AbstractFilter(WIDGET widget, PARENT parent, VALUE value) {
		this.widget = widget;
		this.parent = parent;
		this.value = value;
	}

	protected SelenideElement getFormFilter() {
		return formFilter;
	}


	public abstract SELF filter(VALUE value);

	/** Selector of the filter form; use {@link #getFormFilter()} for the opened one. */
	public String formFilter() {
		return FILTER_FORM;
	}

	public PARENT apply() {
		SelenideElement button = $("button[data-test-filter-popup-apply=\"true\"]");
		button.shouldBe(Condition.exist).click();
		waitFilterApplied(button);
		return this.parent;
	}

	public PARENT setClear() {
		SelenideElement button = $("button[data-test-filter-popup-clear=\"true\"]");
		button.shouldBe(Condition.exist).click();
		waitFilterApplied(button);
		return this.parent;
	}

	/**
	 * The filter popover closes in the same render that shows the loading spinner,
	 * and the filtered rows are rendered when the spinner is gone.
	 * The column header may be re-rendered meanwhile, so the filter icon is not a reliable signal.
	 */
	private void waitFilterApplied(SelenideElement popupButton) {
		popupButton.shouldNotBe(Condition.visible, widget.getExpectations().getTimeout());
		column().element()
				.$x("ancestor::div[@data-test='WIDGET']")
				.$(LOADING_SPINNER)
				.shouldNot(Condition.exist, widget.getExpectations().getOverTimeout());
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
