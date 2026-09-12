package core.element.widget.list.realization.form.tree;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.StaleElementReferenceException;
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

	private static final String EXTRA_ROW = "-extra-row";

	/** The inline form of a tree row is rendered by antd as a separate expanded row, outside the rows of the node. */
	@Override
	public SelenideElement element() throws StaleElementReferenceException {
		if (getRowKey().endsWith(EXTRA_ROW)) {
			return widget().element().$("tr[data-row-key=\"" + getRowKey() + "\"]");
		}
		return super.element();
	}

	@Override
	public PlatformInlineFormWidget clickPencil() {
		SelenideElement extraRow = widget().element().$("tr[data-row-key=\"" + getRowKey() + EXTRA_ROW + "\"]");
		if (!extraRow.is(Condition.visible, widget().getExpectations().getTimeout())) {
			element().$("i[aria-label='icon: edit']").click();
			extraRow.shouldBe(Condition.visible, widget().getExpectations().getTimeout());
		}
		return new PlatformInlineFormWidget(PlatformIdentifier.NONE, null,
				new PlatformTreeRowInlineForm(getParent(), 0, this.getRowKey() + EXTRA_ROW), this.getRowKey());
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
