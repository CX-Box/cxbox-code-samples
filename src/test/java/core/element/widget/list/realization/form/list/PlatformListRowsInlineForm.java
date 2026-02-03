package core.element.widget.list.realization.form.list;

import core.element.widget.form.PlatformInlineFormWidget;
import core.element.widget.list.rows.RowsInlineForm;

public class PlatformListRowsInlineForm extends
		RowsInlineForm<PlatformListRowsInlineForm, PlatformListWidgetInlineForm, PlatformListRowInlineForm, PlatformInlineFormWidget> {
	public PlatformListRowsInlineForm(PlatformListWidgetInlineForm widget) {
		super(widget);
	}

	@Override
	public PlatformListRowInlineForm row(int number) {
		String cursor = element().get(number).getAttribute(ROW_ID_ATTRIBUTE);
		return new PlatformListRowInlineForm(this, number, cursor);
	}
}