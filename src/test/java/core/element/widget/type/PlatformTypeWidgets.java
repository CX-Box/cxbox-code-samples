package core.element.widget.type;

import lombok.Getter;

@Getter
public enum PlatformTypeWidgets implements TypeWidget {
	INFO("Info"),
	FORM("Form"),
	LIST("List"),
	FORM_POPUP("FormPopup"),
	ADDITIONAL_INFO("AdditionalInfo"),
	GROUPING_HIERARCHY("GroupingHierarchy"),
	INLINE_FORM("InlineForm"),
	STATS_BLOCK("StatsBlock");

	private final String type;

	PlatformTypeWidgets(String type) {
		this.type = type;
	}
}
