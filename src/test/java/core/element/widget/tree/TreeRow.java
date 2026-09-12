package core.element.widget.tree;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import core.element.widget.AbstractWidget;
import core.element.widget.list.TreePagination;
import core.expectation.ExpectationPattern;

/**
 * A tree row owns its child rows: {@link #rows()}, {@link #pagination()}, expand and collapse.
 * Reading and editing of the row itself is inherited from the List row classes.
 */
public interface TreeRow<SELF extends TreeRow<SELF, W, ROWS>, W extends AbstractWidget<ExpectationPattern, W>, ROWS> {

	W widget();

	/** key of this row, the owner key of its child rows */
	String rowKey();

	SelenideElement element();

	/** Child rows loaded so far. */
	ROWS rows();

	/** Pages of the child rows: the first {@link TreePagination#nextPage()} expands the row, the next ones load "More". */
	default TreePagination<W> pagination() {
		return new TreePagination<>(widget(), rowKey());
	}

	@SuppressWarnings("unchecked")
	default SELF expandRow() {
		if (pagination().isCollapsed()) {
			pagination().nextPage();
		}
		return (SELF) this;
	}

	/** The row has the expand arrow, i.e. it is not a leaf. */
	default boolean isExpandable() {
		return element().$("i[data-test-widget-tree-row-expand]").exists();
	}

	default boolean isExpanded() {
		return element().$(TreeNavigation.EXPANDED_ROW_ICON).exists();
	}

	/** In the "hide" search mode the arrow is replaced by a dot and the row cannot be expanded. */
	default boolean isExpandDisabled() {
		return element().$(TreeNavigation.EXPAND_DISABLED_ICON).exists();
	}

	/** The path of a found row to the root is not restored yet: the row is shown apart with the ">..." button. */
	default boolean isUnallocated() {
		return element().$(TreeNavigation.RESTORE_PATH_BUTTON).exists();
	}

	/** Clicks ">..." of the row: loads the missing parents and moves the row into the tree. */
	@SuppressWarnings("unchecked")
	default SELF restorePath() {
		element().$(TreeNavigation.RESTORE_PATH_BUTTON).click();
		TreeNavigation.allocatedRow(widget().element(), rowKey()).should(Condition.exist, widget().getExpectations().getTimeout());
		TreeNavigation.waitLoaded(widget().element(), widget().getExpectations());
		return (SELF) this;
	}

	@SuppressWarnings("unchecked")
	default SELF collapseRow() {
		SelenideElement icon = element().$(TreeNavigation.EXPANDED_ROW_ICON);
		if (icon.exists()) {
			icon.click();
		}
		return (SELF) this;
	}

}
