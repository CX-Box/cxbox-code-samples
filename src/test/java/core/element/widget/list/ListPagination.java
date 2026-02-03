package core.element.widget.list;

import com.codeborne.selenide.Condition;
import core.element.widget.AbstractWidget;
import core.expectation.ExpectationPattern;
import lombok.AccessLevel;
import lombok.Getter;

import java.util.function.Consumer;

public class ListPagination<W extends AbstractWidget<ExpectationPattern, W>> {

	@Getter(value = AccessLevel.PROTECTED)
	private final W widget;

	public ListPagination(W widget) {
		this.widget = widget;
	}

	public ListPagination<W> checkPageCount(Consumer<Integer> pageCountChecker) {
		pageCountChecker.accept(getPages());
		return this;
	}

	//ROW
	public ListPagination<W> pages(int number) {
		firstPage();
		for (int i = 0; i < number; i++) {
			if (getPages() > 1) {
				getWidget().getExpectations().getWaitAllElements(getWidget().element());
				this.getWidget().element().$("i[class=\"anticon anticon-right\"]")
						.shouldBe(Condition.visible, getWidget().getExpectations().getTimeout())
						.scrollIntoView("{ block: \"center\", behavior: \"smooth\" }")
						.click();
				getWidget().getExpectations().getWaitAllElements(getWidget().element());
			}
		}
		return this;
	}

	// Rows
	public ListPagination<W> firstPage() {
		this.getWidget().element()
				.$("div[data-test-widget-list-pagination=\"true\"]")
				.shouldBe(Condition.visible, getWidget().getExpectations().getTimeout())
				.$("li[title=\"1\"]")
				.shouldBe(Condition.visible, getWidget().getExpectations().getTimeout())
				.click();
		return this;
	}

	// cant return ROW   be  chain >> pagination.nextPage().nextPage()
	public ListPagination<W> nextPage() {
		this.getWidget().element().$("i[class=\"anticon anticon-right\"]")
				.shouldBe(Condition.visible, getWidget().getExpectations().getTimeout())
				.scrollIntoView("{ block: \"center\", behavior: \"smooth\" }")
				.click();
		return this;
	}

	public ListPagination<W> previousPage() {
		this.getWidget().element().$("i[class=\"anticon anticon-left\"]")
				.shouldBe(Condition.visible, getWidget().getExpectations().getTimeout())
				.scrollIntoView("{ block: \"center\", behavior: \"smooth\" }")
				.click();
		return this;
	}


	private int getPages() {
		return this.getWidget().element()
				.$("div[data-test-widget-list-pagination=\"true\"]")
				.shouldBe(Condition.visible, getWidget().getExpectations().getTimeout())
				.$$("li[tabindex=\"0\"].ant-pagination-item").size();
	}

	public boolean checkNextPage() {
		return !isLastPage();
	}

	public boolean isLastPage() {
		widget.getExpectations().getWaitAllElements(widget.element());
		return this.widget.element()
				.$("li[title=\"Next Page\"][aria-disabled=\"true\"]")
				.is(Condition.anyOf(Condition.visible, Condition.enabled));
	}

	public W widget() {
		return widget;
	}

}
