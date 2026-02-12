package core.element.widget.list.realization.form.list;

import com.codeborne.selenide.Condition;
import core.element.widget.PlatformIdentifier;
import core.element.widget.form.PlatformInlineFormWidget;
import core.element.widget.list.rows.row.RowInlineForm;

import static com.codeborne.selenide.Condition.attribute;

public class PlatformListRowInlineForm extends
		RowInlineForm<PlatformListRowInlineForm, PlatformListRowsInlineForm, PlatformListWidgetInlineForm, PlatformInlineFormWidget> {

	public PlatformListRowInlineForm(PlatformListRowsInlineForm parent, int pageIndex, String rowKey) {
		super(parent, pageIndex, rowKey);
	}

	@Override
	public PlatformInlineFormWidget clickPencil() {
		getParent().element().findBy(attribute("data-row-key", getRowKey()));
		boolean exists = getParent().element()
				.findBy(attribute("data-row-key", getRowKey() + "-extra-row"))
				.is(Condition.visible, widget().getExpectations().getTimeout());
		if (!exists) {
			element().$("i[aria-label='icon: edit']").click();
		}
		return new PlatformInlineFormWidget(PlatformIdentifier.NONE, null, new PlatformListRowInlineForm(getParent(), 0, this.getRowKey() + "-extra-row"), this.getRowKey());
	}
}