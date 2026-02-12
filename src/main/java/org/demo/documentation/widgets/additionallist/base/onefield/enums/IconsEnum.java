package org.demo.documentation.widgets.additionallist.base.onefield.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.cxbox.api.data.dto.rowmeta.Icon;

@RequiredArgsConstructor
@Getter
public enum IconsEnum implements Icon {
	CHECK("check #42f578"),
	CLOSE("close #f54242");

	private final String icon;

}