package core.element.widget.list;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import core.element.widget.AbstractWidget;
import core.expectation.ExpectationPattern;
import lombok.AccessLevel;
import lombok.Getter;
import org.openqa.selenium.TimeoutException;

import java.util.function.Consumer;

public class ListPagination<W extends AbstractWidget<ExpectationPattern, W>> implements Pagination<ListPagination<W>, W> {

	private static final String LOADING_SPINNER = ".ant-spin-spinning";

	private static final String ACTIVE_PAGE = "ant-pagination-item-active";

	private static final String TOTAL = "data-test-widget-list-pagination-total";

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

	@Override
	public ListPagination<W> checkTotal(Consumer<Integer> totalChecker) {
		try {
			Selenide.Wait()
					.withTimeout(getWidget().getExpectations().getTimeout())
					.ignoring(AssertionError.class)
					.until(driver -> {
						totalChecker.accept(getTotal());
						return true;
					});
		} catch (TimeoutException e) {
			// the last try gives the test the message of its own check
			totalChecker.accept(getTotal());
		}
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
		SelenideElement widgetElement = getWidget().element();
		SelenideElement first = widgetElement
				.$("div[data-test-widget-list-pagination=\"true\"] li[title=\"1\"]")
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
		SelenideElement widgetElement = getWidget().element();
		int target = Integer.parseInt(widgetElement.$("li." + ACTIVE_PAGE).getAttribute("title")) + step;
		widgetElement.$(arrow)
				.shouldBe(Condition.visible, getWidget().getExpectations().getTimeout())
				.scrollIntoView("{ block: \"center\", behavior: \"smooth\" }")
				.click();
		waitPageLoaded(widgetElement, target);
		return this;
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


	/** Reads without a wait: the wait is the repeated check of {@link #checkTotal}. */
	private Integer getTotal() {
		SelenideElement total = getWidget().element().$("[" + TOTAL + "]");
		String value = total.exists() ? total.getAttribute(TOTAL) : null;
		return value != null && value.matches("\\d+") ? Integer.valueOf(value) : null;
	}

	private int getPages() {
		return this.getWidget().element()
				.$("div[data-test-widget-list-pagination=\"true\"]")
				.shouldBe(Condition.visible, getWidget().getExpectations().getTimeout())
				.$$("li[tabindex=\"0\"].ant-pagination-item").size();
	}

	@Override
	public boolean checkNextPage() {
		return !isLastPage();
	}

	@Override
	public boolean isLastPage() {
		widget.getExpectations().getWaitAllElements(widget.element());
		return this.widget.element()
				.$("li[title=\"Next Page\"][aria-disabled=\"true\"]")
				.is(Condition.anyOf(Condition.visible, Condition.enabled));
	}

	@Override
	public W widget() {
		return widget;
	}

}
