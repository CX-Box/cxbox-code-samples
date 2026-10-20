package core.element.widget.list;

import static core.element.PlatformApp.config;
import core.util.report.StepReport;
import io.qameta.allure.Allure;
import static core.util.i18n.CoreMessageSource.message;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import core.element.widget.AbstractWidget;
import core.expectation.ExpectationPattern;
import lombok.AccessLevel;
import lombok.Getter;

import java.util.function.Consumer;

public class ListPagination<W extends AbstractWidget<ExpectationPattern, W>> implements Pagination<ListPagination<W>, W> {

	private static final String LOADING_SPINNER = ".ant-spin-spinning";

	private static final String ACTIVE_PAGE = "ant-pagination-item-active";

	/** A row of records or of groups, a card */
	private static final String ROWS = "[data-test-widget-list-row-id]";

	@Getter(value = AccessLevel.PROTECTED)
	private final W widget;

	public ListPagination(W widget) {
		this.widget = widget;
	}

	@Override
	public ListPagination<W> checkPageCount(Consumer<Integer> pageCountChecker) {
		pageCountChecker.accept(getPages());
		return this;
	}

	//ROW
	@Override
	public ListPagination<W> pages(int number) {
		firstPage();
		for (int i = 0; i < number; i++) {
			if (getPages() > 1) {
				nextPage();
			}
		}
		return this;
	}

	// Rows
	@Override
	public ListPagination<W> firstPage() {
		if (!hasPagination()) {
			return this;
		}
		SelenideElement widgetElement = getWidget().element();
		SelenideElement first = widgetElement
				.$(config().selectors.pagination).$("li[title=\"1\"]")
				.shouldBe(Condition.visible, getWidget().getExpectations().getTimeout());
		if (!first.has(Condition.cssClass(ACTIVE_PAGE))) {
			first.click();
			waitPageLoaded(widgetElement, 1);
		}
		return this;
	}

	// cant return ROW   be  chain >> pagination.nextPage().nextPage()
	@Override
	public ListPagination<W> nextPage() {
		return changePage("i[class=\"anticon anticon-right\"]", 1);
	}

	@Override
	public ListPagination<W> previousPage() {
		return changePage("i[class=\"anticon anticon-left\"]", -1);
	}

	private ListPagination<W> changePage(String arrow, int step) {
		return Allure.step(message("list.page"), () -> {
			SelenideElement widgetElement = getWidget().element();
			int target = Integer.parseInt(widgetElement.$("li." + ACTIVE_PAGE).getAttribute("title")) + step;
			StepReport.value(target);
			widgetElement.$(arrow)
					.shouldBe(Condition.visible, getWidget().getExpectations().getTimeout())
					.scrollIntoView("{ block: \"center\", behavior: \"smooth\" }")
					.click();
			waitPageLoaded(widgetElement, target);
			return this;
		});
	}

	/**
	 * The page becomes active in the same render that shows the loading spinner,
	 * and the rows of the page are rendered when the spinner is gone.
	 */
	private void waitPageLoaded(SelenideElement widgetElement, int page) {
		widgetElement.$("li." + ACTIVE_PAGE + "[title=\"" + page + "\"]")
				.should(Condition.exist, getWidget().getExpectations().getTimeout());
		widgetElement.$(LOADING_SPINNER)
				.shouldNot(Condition.exist, getWidget().getExpectations().getOverTimeout());
	}


	private int getPages() {
		if (!hasPagination()) {
			return 1;
		}
		return this.getWidget().element()
				.$(config().selectors.pagination)
				.shouldBe(Condition.visible, getWidget().getExpectations().getTimeout())
				.$$(config().selectors.paginationPage).size();
	}

	@Override
	public boolean checkNextPage() {
		return !isLastPage();
	}

	@Override
	public boolean isLastPage() {
		return !hasPagination() || this.widget.element()
				.$("li.ant-pagination-next[aria-disabled=\"true\"]")
				.is(Condition.anyOf(Condition.visible, Condition.enabled));
	}

	/**
	 * A list without records has no pagination: one page. The pagination of a list with records comes after its rows,
	 * with the count of the records, so it is waited for
	 */
	private boolean hasPagination() {
		var widgetElement = widget.element();
		if (widgetElement.$$(ROWS).isEmpty()) {
			return false;
		}
		widgetElement.$(config().selectors.pagination).shouldBe(Condition.exist, widget.getExpectations().getTimeout());
		return true;
	}

	@Override
	public W widget() {
		return widget;
	}

}
