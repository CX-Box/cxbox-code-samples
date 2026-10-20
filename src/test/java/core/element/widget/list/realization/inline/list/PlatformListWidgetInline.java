package core.element.widget.list.realization.inline.list;

import core.common.Identifier;
import core.element.widget.list.ListHeaders;
import core.element.widget.list.ListWidgetInline;
import core.element.widget.list.Pagination;

import static core.element.PlatformApp.config;

public class PlatformListWidgetInline extends
		ListWidgetInline<PlatformListWidgetInline, PlatformListRowsInline, PlatformListRowInline> {

	public PlatformListWidgetInline(Identifier identifier, String textIdentifier) {
		super(identifier, textIdentifier);
	}

	@Override
	public PlatformListRowsInline rows() {
		return config().parts.list.rows.apply(this);
	}

	@Override
	public ListHeaders<PlatformListWidgetInline, PlatformListRowsInline, PlatformListRowInline> headers() {
		return config().parts.list.headers.apply(this);
	}

	@Override
	public Pagination<?, PlatformListWidgetInline> pagination() {
		return config().parts.list.pagination.apply(this);
	}
}
