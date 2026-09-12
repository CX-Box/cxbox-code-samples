package core.element.widget.list;

import core.common.Identifier;
import core.element.widget.AbstractWidget;
import core.element.widget.list.rows.RowsInlineForm;
import core.element.widget.list.rows.row.RowInlineForm;
import core.element.widget.tree.TreeNavigation;
import core.element.widget.type.PlatformTypeWidgets;
import core.element.widget.type.TypeWidget;
import core.expectation.ExpectationPattern;

/**
 * Tree widget with inline-form editing; the rows are the root rows, each row owning its child rows.
 */
public abstract class TreeWidgetInlineForm<
		SELF extends TreeWidgetInlineForm<SELF, ROWS, ROW, FORMWIDGET>,
		ROWS extends RowsInlineForm<ROWS, SELF, ROW, FORMWIDGET>,
		ROW extends RowInlineForm<ROW, ROWS, SELF, FORMWIDGET>,
		FORMWIDGET extends AbstractWidget<ExpectationPattern, FORMWIDGET>> extends ListWidgetInlineForm<SELF, ROWS, ROW, FORMWIDGET> {

	public TreeWidgetInlineForm(Identifier identifier, String textIdenfier) {
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

	@Override
	public TreePagination<SELF> pagination() {
		return new TreePagination<>(self(), TreeNavigation.ROOT_KEY);
	}

}
