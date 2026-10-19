package core.element.widget.list;

import core.util.report.StepReport;
import java.util.List;
import static core.util.i18n.CoreMessageSource.message;

import io.qameta.allure.Allure;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import core.common.IterableElement;
import core.element.widget.action.PageRequests;
import core.element.widget.list.filter.header.filtration.FB;
import core.element.widget.list.filter.header.filtration.FC;
import core.element.widget.list.filter.header.filtration.SB;
import core.element.widget.list.filter.header.filtration.SC;
import core.element.widget.list.rows.PlatformRows;
import core.element.widget.list.rows.row.PlatformRow;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.StaleElementReferenceException;

import java.time.Duration;
import java.util.function.Consumer;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

// need List widget
@Slf4j
public class ListHeaders<W extends ListWidget<W, ROWS, ROW>, ROWS extends PlatformRows<ROWS, W, ROW>, ROW extends PlatformRow<ROW, ROWS, W>> implements IterableElement {

	/**
	 * A filter sends the request of the rows at once after the click
	 */
	private static final Duration REQUEST_START = Duration.ofMillis(500);

	private final W widget;

	private final FC<W, ROWS, ROW> FC;

	public ListHeaders(W widget) {
		this.widget = widget;
		this.FC = new FC<>(widget);
	}

	@Override
	public ElementsCollection element() throws StaleElementReferenceException {
		widget().element();
		return this.widget().element()
				.shouldBe(Condition.visible, widget().getExpectations().getTimeout())
				.$("table").shouldBe(Condition.visible, widget().getExpectations().getTimeout())
				.$("thead").shouldBe(Condition.visible, widget().getExpectations().getTimeout())
				.$$("th");
	}

	// ui filtration
	/** The texts of the headers of the columns */
	public List<String> names() {
		return Allure.step(message("list.headers"), () -> {
			var names = element().texts();
			StepReport.list(names, "columns");
			return names;
		});
	}

	public ListHeaders<W, ROWS, ROW> filter(Consumer<FB<W, ?, ?, ?>> fb) {
		FB<W, ?, ?, ?> FBRInstance = new FB<>(FC.getContainer(), widget, this);
		fb.accept(FBRInstance);
		FC.executeFilters();
		return this;
	}

	// ui sort
	public ListHeaders<W, ROWS, ROW> sort(Consumer<SB<W, ?, ?, ?>> sb) {
		SC<W, ?, ?> FSRC = new SC<>(widget());
		SB<W, ?, ?, ?> sbInstanse = new SB<>(FSRC.getContainer());
		sb.accept(sbInstanse);
		FSRC.executeSort();
		return this;
	}

	// ui filtration and sort
	public W filterAndSort(Consumer<FB<W, ?, ?, ?>> fb, Consumer<SB<W, ?, ?, ?>> sb) {
		sort(sb);
		filter(fb);
		return widget;
	}

	public W widget() {
		return widget;
	}

	/** Clicks "Clear N filter(s)" above the table when filters are applied. */
	public W clearFilters() {
		return Allure.step(message("filters.clearAll"), () -> {
			// the link has a text in the language of the user, "Clear 2 filters"
			SelenideElement clear = widget().element().$("a[data-test-widget-list-clear-filters='true']");
			if (clear.exists()) {
				PageRequests.runAndWaitDelayedRequests(clear::click, REQUEST_START, widget().getExpectations().getOverTimeout());
				widget().element();
			}
			return widget();
		});
	}

	/**
	 * pickList/pickTree column: whether the "..." button of the column filter is highlighted,
	 * i.e. the filter is chosen in the popup. Opens the filter of the column and closes it back.
	 */
	public ListHeaders<W, ROWS, ROW> checkPopupFilterActive(String name, Consumer<Boolean> isActive) {
		SelenideElement filterIcon = headerColumn(name).element().$("div[data-test-widget-list-header-column-filter=\"true\"]");
		filterIcon.click();
		SelenideElement moreButton = $("div.ant-popover:not(.ant-popover-hidden) button[data-test-filter-popup-select]")
				.shouldBe(Condition.visible, widget().getExpectations().getTimeout());
		isActive.accept("true".equals(moreButton.getAttribute("data-test-filter-popup-select-active")));
		filterIcon.click();
		moreButton.shouldNotBe(Condition.visible, widget().getExpectations().getTimeout());
		return this;
	}

	/**
	 * Chooses the filter group in the select above the table (BC_FILTER_GROUPS or a saved personal filter group).
	 * "Show all" is the text of the select without a group, not an item: the group is reset by {@link #clearFilters()}.
	 */
	public W filterGroup(String name) {
		return Allure.step(message("list.filterGroup", name), () -> {
			widget().element()
					.$("div[class*=\"Header__filtersContainer\"] .ant-select")
					.shouldBe(Condition.visible, widget().getExpectations().getTimeout())
					.click();
			var group = $$("div.ant-select-dropdown:not(.ant-select-dropdown-hidden) li.ant-select-dropdown-menu-item")
					.findBy(Condition.exactText(name))
					.shouldBe(Condition.visible, widget().getExpectations().getTimeout());
			// the table shows the old rows until the new ones come: the rows are read after the answer, as fullTextSearch does
			PageRequests.runAndWaitDelayedRequests(group::click, REQUEST_START, widget().getExpectations().getOverTimeout());
			widget().element();
			return widget();
		});
	}

	public HeaderColumn<W, ROWS, ROW> headerColumn(String name) {
		return new HeaderColumn<>(
				name,
				widget(),
				this
		);
	}
}
