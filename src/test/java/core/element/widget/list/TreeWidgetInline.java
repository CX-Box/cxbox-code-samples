package core.element.widget.list;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import core.common.Identifier;
import core.element.widget.list.rows.RowsInline;
import core.element.widget.list.rows.row.RowInline;
import core.element.widget.tree.TreeNavigation;
import core.element.widget.type.PlatformTypeWidgets;
import core.element.widget.type.TypeWidget;

/**
 * Tree widget: a List-like widget whose {@link #rows()} are the root rows, each row owning its child rows.
 */
public abstract class TreeWidgetInline<
		SELF extends TreeWidgetInline<SELF, ROWS, ROW>,
		ROWS extends RowsInline<ROWS, SELF, ROW>,
		ROW extends RowInline<ROW, ROWS, SELF>>
		extends ListWidget<SELF, ROWS, ROW> {

	public TreeWidgetInline(Identifier identifier, String textIdenfier) {
		super(identifier, textIdenfier);
	}

	@Override
	public TypeWidget getType() {
		return PlatformTypeWidgets.TREE;
	}

	@Override
	public String headerTitleAttribute() {
		return TreeNavigation.HEADER_TITLE_ATTRIBUTE;
	}

	/** Rows of one owner: the root rows, the unallocated rows or the children of a row. */
	protected abstract ROWS rowsOf(String ownerKey);

	/** The root rows. */
	@Override
	public ROWS rows() {
		return rowsOf(TreeNavigation.ROOT_KEY);
	}

	/** Rows found by a filter whose path to the root is not restored yet (shown apart with ">..."). */
	public ROWS unallocatedRows() {
		return rowsOf(TreeNavigation.UNALLOCATED_KEY);
	}

	/** Waits until every page of the tree is loaded. */
	public SELF waitLoaded() {
		TreeNavigation.waitLoaded(element(), getExpectations());
		return self();
	}

	/** Waits until the filter panel shows the given number of found rows. */
	public SELF shouldShow(int count) {
		element().$(TreeNavigation.FILTER_SHOWN)
				.shouldHave(Condition.attribute("data-test-widget-tree-filter-shown", String.valueOf(count)), getExpectations().getTimeout());
		TreeNavigation.rows(element()).shouldHave(CollectionCondition.size(count), getExpectations().getTimeout());
		return self();
	}

	/** "shown N" counter of the filter panel; 0 when no filter is applied. */
	public int filterShown() {
		waitLoaded();
		return TreeNavigation.number(element().$(TreeNavigation.FILTER_SHOWN));
	}

	/** The "More N" link of the filter panel above the tree. */
	public boolean hasFilterMore() {
		return element().$(TreeNavigation.FILTER_MORE).exists();
	}

	public int filterMoreCount() {
		return TreeNavigation.number(element().$(TreeNavigation.FILTER_MORE));
	}

	public SELF filterMore() {
		element().$(TreeNavigation.FILTER_MORE).click();
		getExpectations().getWaitAllElements(element());
		return self();
	}

	/** Gear menu item "Restore path -> For all". */
	public SELF restorePathForAll() {
		settings().select("For all");
		return self();
	}

	/** Pages of the root rows, loaded by "More" under the root level. */
	@Override
	public TreePagination<SELF> pagination() {
		return new TreePagination<>(self(), TreeNavigation.ROOT_KEY);
	}

}
