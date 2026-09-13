package core.element.widget.list.realization.form.tree;

import com.codeborne.selenide.ElementsCollection;
import core.element.widget.form.PlatformInlineFormWidget;
import core.element.widget.list.rows.RowsInlineForm;
import core.element.widget.list.rows.stream.StreamWithPagination;
import core.element.widget.tree.TreeNavigation;
import core.element.widget.tree.TreeRows;

import java.util.stream.Stream;

public class PlatformTreeRowsInlineForm extends
		RowsInlineForm<PlatformTreeRowsInlineForm, PlatformTreeWidgetInlineForm, PlatformTreeRowInlineForm, PlatformInlineFormWidget>
		implements TreeRows<PlatformTreeWidgetInlineForm, PlatformTreeRowInlineForm> {

	private final String parentKey;

	public PlatformTreeRowsInlineForm(PlatformTreeWidgetInlineForm widget) {
		this(widget, TreeNavigation.ROOT_KEY);
	}

	public PlatformTreeRowsInlineForm(PlatformTreeWidgetInlineForm widget, String parentKey) {
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
	public PlatformTreeRowInlineForm row(int number) {
		return new PlatformTreeRowInlineForm(this, number, rowKey(number));
	}

	@Override
	public Stream<PlatformTreeRowInlineForm> streamCurrentPage() {
		return TreeRows.super.streamCurrentPage();
	}

	@Override
	public StreamWithPagination<PlatformTreeRowInlineForm> streamAllPages() {
		return TreeRows.super.streamAllPages();
	}

}
