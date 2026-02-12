package core.element.widget.list.realization.form.gh;

import core.element.widget.form.PlatformInlineFormWidget;
import core.element.widget.list.rows.RowsInlineForm;

public class PlatformGHRowsInlineForm extends
		RowsInlineForm<PlatformGHRowsInlineForm, PlatformGHWidgetInlineForm, PlatformGHRowInlineForm, PlatformInlineFormWidget> {
	public PlatformGHRowsInlineForm(PlatformGHWidgetInlineForm widget) {
		super(widget);
	}

	@Override
	public PlatformGHRowInlineForm row(int number) {
		String cursor = element().get(number).getAttribute(ROW_ID_ATTRIBUTE);
		return new PlatformGHRowInlineForm(this, number, cursor);
	}
}