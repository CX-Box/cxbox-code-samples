package core.element.widget.type;

import lombok.Getter;

@Getter
public enum PlatformTypeWidgets implements TypeWidget {
	INFO("Info"),
	FORM("Form"),
	LIST("List"),
	ADDITIONAL_INFO("AdditionalInfo"),
	GROUPING_HIERARCHY("GroupingHierarchy"),
	INLINE_FORM("InlineForm"),
	STATS_BLOCK("StatsBlock"),
	TREE("Tree"),
	ASSOC_TREE_POPUP("AssocTreePopup"),
	PICK_TREE_POPUP("PickTreePopup"),
	ASSOC_LIST_POPUP("AssocListPopup"),
	PICK_LIST_POPUP("PickListPopup"),
	CARD_LIST("CardList");

	private final String type;

	PlatformTypeWidgets(String type) {
		this.type = type;
	}
}
