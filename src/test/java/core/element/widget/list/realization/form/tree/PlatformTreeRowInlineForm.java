package core.element.widget.list.realization.form.tree;

import com.codeborne.selenide.Condition;
import core.element.widget.PlatformIdentifier;
import core.element.widget.form.PlatformInlineFormWidget;
import core.element.widget.list.rows.row.RowInlineForm;
import core.element.widget.tree.TreeRow;

import static com.codeborne.selenide.Condition.attribute;

public class PlatformTreeRowInlineForm extends
		RowInlineForm<PlatformTreeRowInlineForm, PlatformTreeRowsInlineForm, PlatformTreeWidgetInlineForm, PlatformInlineFormWidget>
		implements TreeRow<PlatformTreeRowInlineForm, PlatformTreeWidgetInlineForm, PlatformTreeRowsInlineForm> {

	public PlatformTreeRowInlineForm(PlatformTreeRowsInlineForm parent, int pageIndex, String rowKey) {
		super(parent, pageIndex, rowKey);
	}

	@Override
	public PlatformInlineFormWidget clickPencil() {
		boolean exists = getParent().element()
				.findBy(attribute("data-row-key", getRowKey() + "-extra-row"))
				.is(Condition.visible, widget().getExpectations().getTimeout());
		if (!exists) {
			element().$("i[aria-label='icon: edit']").click();
		}
		return new PlatformInlineFormWidget(PlatformIdentifier.NONE, null,
				new PlatformTreeRowInlineForm(getParent(), 0, this.getRowKey() + "-extra-row"), this.getRowKey());
	}

	@Override
	public String rowKey() {
		return getRowKey();
	}

	@Override
	public PlatformTreeRowsInlineForm rows() {
		return new PlatformTreeRowsInlineForm(widget(), getRowKey());
	}

}
