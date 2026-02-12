package org.demo.documentation.widgets.property.sethidden.enums;

import com.fasterxml.jackson.annotation.JsonValue;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;

import java.util.Arrays;
import java.util.Objects;

@Getter
@AllArgsConstructor
public enum CustomFieldDictionaryEnum1 {
	HIGH("High"),
	MIDDLE("Middle"),
	LOW("Low");

	@JsonValue
	private final String value;

	public static CustomFieldDictionaryEnum1 getByValue(@NonNull String value) {
		return Arrays.stream(CustomFieldDictionaryEnum1.values())
				.filter(enm -> Objects.equals(enm.getValue(), value))
				.findFirst()
				.orElse(null);
	}
}
