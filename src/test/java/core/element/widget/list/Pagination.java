package core.element.widget.list;

import java.util.function.Consumer;

/**
 * Pagination of a widget: List has one for the whole widget and replaces the page,
 * Tree has one per row (and one for the root rows) and accumulates the pages.
 */
public interface Pagination<SELF extends Pagination<SELF, W>, W> {

	SELF checkPageCount(Consumer<Integer> pageCountChecker);

	SELF pages(int number);

	SELF firstPage();

	SELF nextPage();

	SELF previousPage();

	boolean checkNextPage();

	boolean isLastPage();

	W widget();

}
