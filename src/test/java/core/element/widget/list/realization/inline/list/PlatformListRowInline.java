package core.element.widget.list.realization.inline.list;

import io.qameta.allure.Allure;
import static core.util.i18n.CoreMessageSource.message;

import core.element.widget.list.rows.row.RowInline;

import static core.element.PlatformApp.config;

public class PlatformListRowInline extends
		RowInline<PlatformListRowInline, PlatformListRowsInline, PlatformListWidgetInline> {

	public PlatformListRowInline(PlatformListRowsInline parent, int pageIndex, String rowKey, boolean isEdit) {
		super(parent, pageIndex, rowKey, isEdit);
	}

	public PlatformListRowInline(PlatformListRowsInline parent, int pageIndex, String rowKey) {
		super(parent, pageIndex, rowKey);
	}

	@Override
	public PlatformListRowInline editRow() {
		return Allure.step(message("row.edit"), () -> {
			element().click();
			return config().parts.list.row.create(getParent(), getPageIndex(), getRowKey(), true);
		});
	}
}