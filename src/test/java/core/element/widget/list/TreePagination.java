package core.element.widget.list;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import core.element.widget.AbstractWidget;
import core.element.widget.tree.TreeNavigation;
import core.expectation.ExpectationPattern;

import java.util.function.Consumer;

/**
 * Pagination of one tree row (its children) or of the root rows: every page is loaded by "More"
 * and the pages accumulate. A collapsed row shows its first page on the first {@link #nextPage()}.
 */
public class TreePagination<W extends AbstractWidget<ExpectationPattern, W>> implements Pagination<TreePagination<W>, W> {

	private final W widget;

	/** key of the owning row, {@link TreeNavigation#ROOT_KEY} for the root rows */
	private final String parentKey;

	public TreePagination(W widget, String parentKey) {
		this.widget = widget;
		this.parentKey = parentKey;
	}

	@Override
	public TreePagination<W> checkPageCount(Consumer<Integer> pageCountChecker) {
		String text = moreButton().exists() ? moreButton().getText().replaceAll("\\D", "") : "";
		pageCountChecker.accept(text.isEmpty() ? 0 : Integer.parseInt(text));
		return this;
	}

	@Override
	public TreePagination<W> pages(int number) {
		for (int i = 0; i < number; i++) {
			nextPage();
		}
		return this;
	}

	@Override
	public TreePagination<W> firstPage() {
		throw new UnsupportedOperationException("Tree pages accumulate; collapse the row to start over");
	}

	@Override
	public TreePagination<W> nextPage() {
		if (isCollapsed()) {
			collapsedIcon().click();
		} else {
			moreButton()
					.shouldBe(Condition.visible, widget.getExpectations().getTimeout())
					.scrollIntoView("{ block: \"center\", behavior: \"smooth\" }")
					.click();
		}
		waitLoaded();
		return this;
	}

	@Override
	public TreePagination<W> previousPage() {
		throw new UnsupportedOperationException("Tree pages accumulate; collapse the row to start over");
	}

	@Override
	public boolean checkNextPage() {
		return !isLastPage();
	}

	@Override
	public boolean isLastPage() {
		waitLoaded();
		return !isCollapsed() && !moreButton().exists();
	}

	@Override
	public W widget() {
		return widget;
	}

	public boolean isCollapsed() {
		return collapsedIcon().exists();
	}

	private SelenideElement collapsedIcon() {
		return TreeNavigation.ROOT_KEY.equals(parentKey)
				? widget.element().$(TreeNavigation.COLLAPSED_HEADER_ICON)
				: TreeNavigation.row(widget.element(), parentKey).$(TreeNavigation.COLLAPSED_ROW_ICON);
	}

	private SelenideElement moreButton() {
		return TreeNavigation.moreButton(widget.element(), parentKey);
	}

	private void waitLoaded() {
		TreeNavigation.waitLoaded(widget.element(), widget.getExpectations());
	}

}
