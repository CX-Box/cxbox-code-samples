package core.element.widget.list;

import java.util.function.Consumer;

/**
 * Pagination of a widget: List has one for the whole widget and replaces the page,
 * Tree has one per row (and one for the root rows) and accumulates the pages.
 */
public interface Pagination<SELF extends Pagination<SELF, W>, W> {

	SELF checkPageCount(Consumer<Integer> pageCountChecker);

	/**
	 * Passes the total count of records ("of N" next to the page size) to the check.
	 * The count comes by its own request after the rows, so the check is repeated until it passes or the timeout.
	 * The check gets null when the total count is not shown.
	 */
	default SELF checkTotal(Consumer<Integer> totalChecker) {
		throw new UnsupportedOperationException("This pagination has no total count");
	}

	SELF pages(int number);

	SELF firstPage();

	SELF nextPage();

	SELF previousPage();

	boolean checkNextPage();

	boolean isLastPage();

	W widget();

}
