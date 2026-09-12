package core.element.widget.list.realization.inline.tree;

import com.codeborne.selenide.SelenideElement;
import core.element.widget.list.rows.row.RowInline;
import core.element.widget.tree.TreeNavigation;
import core.element.widget.tree.TreeRow;
import org.openqa.selenium.StaleElementReferenceException;

import static com.codeborne.selenide.Condition.attribute;

public class PlatformTreeRowInline extends
		RowInline<PlatformTreeRowInline, PlatformTreeRowsInline, PlatformTreeWidgetInline>
		implements TreeRow<PlatformTreeRowInline, PlatformTreeWidgetInline, PlatformTreeRowsInline> {

	public PlatformTreeRowInline(PlatformTreeRowsInline parent, int pageIndex, String rowKey, boolean isEdit) {
		super(parent, pageIndex, rowKey, isEdit);
	}

	public PlatformTreeRowInline(PlatformTreeRowsInline parent, int pageIndex, String rowKey) {
		super(parent, pageIndex, rowKey);
	}

	@Override
	public SelenideElement element() throws StaleElementReferenceException {
		return getParent().element().findBy(attribute(TreeNavigation.ROW_ID_ATTRIBUTE, getRowKey()));
	}

	@Override
	public PlatformTreeRowInline editRow() {
		element().click();
		return new PlatformTreeRowInline(getParent(), getPageIndex(), getRowKey(), true);
	}

	@Override
	public String rowKey() {
		return getRowKey();
	}

	@Override
	public PlatformTreeRowsInline rows() {
		return new PlatformTreeRowsInline(widget(), getRowKey());
	}

}
