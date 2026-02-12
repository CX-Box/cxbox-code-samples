package core.element.widget.field;

// TODO >> cxbox >> delete or remake
public enum PlatformFieldType implements FieldType {

	INPUT("input", "input"),
	INPUT_RO("input", "span[class*=\"ReadOnlyField\"]"),
	INPUT_LIST("input", "span", "input"),
	CHECKBOX("checkbox", "input"),
	DATE("date", "input"),
	DATE_TIME("dateTime", "input"),
	DICTIONARY("dictionary", "input"),
	HINT("hint", "span[class=\"ant-form-item-children\"]"),
	INLINE_PICK_LIST("inline-pickList", "input"),
	MONEY("money", "input"),
	MULTIFIELD("multifield", "span div div span"),
	MULTIPLE_SELECT("multipleSelect", "input"),
	MULTIVALUE_HOVER("multivalueHover", "p"),
	NUMBER("number", "input"),
	PICKLIST("pickList", "div[class=\"ant-select-selection-selected-value\"]"),
	PERCENT("percent", "input"),
	TIME("time", "input"),


	DATE_TIME_WITH_SECONDS("dateTimeWithSeconds", "input"),
	DATE_TIME_WITH_SECONDS_RO("dateTimeWithSeconds", "span[class*=\"ReadOnlyField\"]"),
	DATE_TIME_WITH_SECONDS_LIST("dateTimeWithSeconds", "input"),
	MULTIVALUE_RO("multivalue", "div[class*=\"MultiValueListRecord\"]"),
	MULTIVALUE("multivalue", "span[class=\"ant-form-item-children\"]"),
	MULTIVALUE_LIST("multivalue", "span[class=\"ant-form-item-children\"]", ""),
	FILE_UPLOAD_RO("fileUpload", "button[class*=\"FileUpload\""),
	FILE_UPLOAD("fileUpload", "input[type=\"file\"]"),
	FILE_UPLOAD_LIST("fileUpload", "button[class*=\"FileUpload\""),
	RADIO("radio", "input"),
	SUGGESTION_PICK_LIST("suggestionPickList", "input"),
	TEXT("text", "textarea"),
	;

	private final String type;

	private final String valueTag;

	private final String valueTagFocused;

	PlatformFieldType(String type, String valueTag) {
		this.type = type;
		this.valueTag = valueTag;
		this.valueTagFocused = "";
	}

	PlatformFieldType(String type, String valueTag, String valueTagFocused) {
		this.type = type;
		this.valueTag = valueTag;
		this.valueTagFocused = valueTagFocused;
	}

	@Override
	public String getType() {
		return type;
	}

	@Override
	public String getValueTag() {
		return valueTag;
	}

	@Override
	public String getValueTagFocused() {
		return valueTagFocused;
	}
}
