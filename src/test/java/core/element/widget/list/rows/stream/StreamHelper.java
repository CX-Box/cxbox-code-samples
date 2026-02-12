package core.element.widget.list.rows.stream;

import core.element.widget.list.ListWidget;
import core.element.widget.list.rows.PlatformRows;
import core.element.widget.list.rows.row.PlatformRow;
import lombok.AllArgsConstructor;
import lombok.Builder;

import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * This class helper provide logic for creating stream on ListWidget
 *
 * @param <W> widget
 */
@SuppressWarnings("unchecked")
@AllArgsConstructor
@Builder
public class StreamHelper<W extends ListWidget<W, ROWS, ROW>, ROWS extends PlatformRows<ROWS, W, ROW>, ROW extends PlatformRow<ROW, ROWS, W>> {

	private final Supplier<List<ROW>> currentPageProvider;

	private final Supplier<Boolean> hasNextPageProvider;

	private final Runnable nextPageAction;

	private final W widget;

	public StreamHelper(W widget) {
		currentPageProvider = getCurrentPageListDataSupplier(widget);
		hasNextPageProvider = hasNextPageProvider(widget);
		nextPageAction = this::getNextPageAction;
		this.widget = widget;
	}


	public Stream<ROW> streamCurrentPage() {
		return currentPageProvider.get().stream();
	}

	public Stream<ROW> streamOnAllPages() {
		return Stream.iterate(
						0, i -> {
							if (i == 0) {
								return true;
							}
							return hasNextPageProvider.get();
						}, i -> i + 1
				)
				.flatMap(i -> {
					if (i > 0) {
						nextPageAction.run();
					}
					return currentPageProvider.get().stream();
				});
	}

	private Supplier<List<ROW>> getCurrentPageListDataSupplier(W widget) {
		return () -> {
//			ElementsCollection rows = widget.rows().element().filter(attribute("data-test-widget-list-row-type", "Row"));
			ROWS rows = widget.rows();
			return IntStream.range(0, rows.element().size()).mapToObj(rows::row).collect(Collectors.toList());
		};
	}

	private Supplier<Boolean> hasNextPageProvider(W widget) {
		return () -> !widget.pagination().isLastPage();
	}

	private void getNextPageAction() {
		widget.pagination().nextPage();
	}

}


