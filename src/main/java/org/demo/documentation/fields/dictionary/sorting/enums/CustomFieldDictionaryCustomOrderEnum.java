package org.demo.documentation.fields.dictionary.sorting.enums;

import com.fasterxml.jackson.annotation.JsonValue;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;

import java.util.Arrays;
import java.util.Objects;

@Getter
@AllArgsConstructor
public enum CustomFieldDictionaryCustomOrderEnum {
	HIGH("High"),
	MIDDLE("Middle"),
	LOW("Low");

	@JsonValue
	private final String value;

	public static CustomFieldDictionaryCustomOrderEnum getByValue(@NonNull String value) {
		return Arrays.stream(CustomFieldDictionaryCustomOrderEnum.values())
				.filter(enm -> Objects.equals(enm.getValue(), value))
				.findFirst()
				.orElse(null);
	}
}
