package core.element.widget.field;

public interface FieldType {

	String getType();

	String getValueTag();

	default String getValueTagFocused() {
		return "";
	}
}
