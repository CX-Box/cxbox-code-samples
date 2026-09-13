package core.element.widget.tree;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import core.element.widget.AbstractWidget;
import core.element.widget.list.TreePagination;
import core.element.widget.list.rows.stream.StreamWithPagination;
import core.expectation.ExpectationPattern;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Rows of one owner in a tree: the root rows of the widget or the children of a row.
 * Shared by every edit style (inline, inline form) of the tree rows.
 */
public interface TreeRows<W extends AbstractWidget<ExpectationPattern, W>, ROW> {

	W widget();

	/** key of the owning row, {@link TreeNavigation#ROOT_KEY} for the root rows */
	String parentKey();

	ROW row(int number);

	/** Loaded rows of the owner; pseudo rows and rows of other owners are excluded. */
	default ElementsCollection ownerRows() {
		widget().getExpectations().getWaitAllElements(widget().element());
		return TreeNavigation.childRows(widget().element()
				.shouldBe(Condition.visible, widget().getExpectations().getTimeout()), parentKey());
	}

	default String rowKey(int number) {
		return ownerRows().get(number).getAttribute(TreeNavigation.ROW_ID_ATTRIBUTE);
	}

	default TreePagination<W> pagination() {
		return new TreePagination<>(widget(), parentKey());
	}

	/** Loaded rows of the owner as they are on the screen, no page is loaded. */
	default Stream<ROW> streamCurrentPage() {
		return IntStream.range(0, ownerRows().size()).mapToObj(this::row);
	}

	/** Expands the owner if needed, then loads its "More" pages lazily while the stream is consumed. */
	default StreamWithPagination<ROW> streamAllPages() {
		TreePagination<W> pagination = pagination();
		if (pagination.isCollapsed()) {
			pagination.nextPage();
		}
		int[] loaded = {0};
		Stream<ROW> stream = Stream
				.iterate(0, i -> i == 0 || !pagination.isLastPage(), i -> i + 1)
				.flatMap(i -> {
					if (i > 0) {
						pagination.nextPage();
					}
					int size = ownerRows().size();
					List<ROW> page = IntStream.range(loaded[0], size)
							.mapToObj(this::row)
							.collect(Collectors.toList());
					loaded[0] = size;
					return page.stream();
				});
		return StreamWithPagination.of(stream);
	}

}
