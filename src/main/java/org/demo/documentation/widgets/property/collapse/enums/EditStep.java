package org.demo.documentation.widgets.property.collapse.enums;

import com.fasterxml.jackson.annotation.JsonValue;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum EditStep {
	NEXT_STEP("Next step", "screen/myexample3860/");

	@JsonValue
	private final String value;

	private final String editView;

}
