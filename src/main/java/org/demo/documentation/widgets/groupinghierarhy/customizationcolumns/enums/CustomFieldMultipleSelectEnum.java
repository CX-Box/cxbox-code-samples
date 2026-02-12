package org.demo.documentation.widgets.groupinghierarhy.customizationcolumns.enums;

import com.fasterxml.jackson.annotation.JsonValue;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;

import java.util.Arrays;
import java.util.Objects;

@Getter
@AllArgsConstructor
public enum CustomFieldMultipleSelectEnum {
	HIGH("High"),
	MIDDLE("Middle"),
	LOW("Low");

	@JsonValue
	private final String value;

	public static CustomFieldMultipleSelectEnum getByValue(@NonNull String value) {
		return Arrays.stream(CustomFieldMultipleSelectEnum.values())
				.filter(enm -> Objects.equals(enm.getValue(), value))
				.findFirst()
				.orElse(null);
	}
}
