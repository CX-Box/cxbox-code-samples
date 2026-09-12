package core.element.widget.list.realization.inline.tree;

import com.codeborne.selenide.ElementsCollection;
import core.element.widget.list.rows.RowsInline;
import core.element.widget.list.rows.stream.StreamWithPagination;
import core.element.widget.tree.TreeNavigation;
import core.element.widget.tree.TreeRows;

import java.util.stream.Stream;

public class PlatformTreeRowsInline extends
		RowsInline<PlatformTreeRowsInline, PlatformTreeWidgetInline, PlatformTreeRowInline>
		implements TreeRows<PlatformTreeWidgetInline, PlatformTreeRowInline> {

	private final String parentKey;

	public PlatformTreeRowsInline(PlatformTreeWidgetInline widget) {
		this(widget, TreeNavigation.ROOT_KEY);
	}

	public PlatformTreeRowsInline(PlatformTreeWidgetInline widget, String parentKey) {
		super(widget);
		this.parentKey = parentKey;
	}

	@Override
	public String parentKey() {
		return parentKey;
	}

	@Override
	public ElementsCollection element() {
		return ownerRows();
	}

	@Override
	public PlatformTreeRowInline row(int number) {
		return new PlatformTreeRowInline(this, number, rowKey(number));
	}

	@Override
	public PlatformTreeRowInline clickRow(int number) {
		return row(number).editRow();
	}

	@Override
	public Stream<PlatformTreeRowInline> streamCurrentPage() {
		return TreeRows.super.streamCurrentPage();
	}

	@Override
	public StreamWithPagination<PlatformTreeRowInline> streamAllPages() {
		return TreeRows.super.streamAllPages();
	}

}
