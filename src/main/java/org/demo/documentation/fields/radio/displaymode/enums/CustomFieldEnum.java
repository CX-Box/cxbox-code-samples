package org.demo.documentation.fields.radio.displaymode.enums;

import com.fasterxml.jackson.annotation.JsonValue;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;

import java.util.Arrays;
import java.util.Objects;

@Getter
@AllArgsConstructor
public enum CustomFieldEnum {
	LOW("Low"),
	MIDDLE("Middle"),
	HIGH("High");

	@JsonValue
	private final String value;

	public static CustomFieldEnum getByValue(@NonNull String value) {
		return Arrays.stream(CustomFieldEnum.values())
				.filter(enm -> Objects.equals(enm.getValue(), value))
				.findFirst()
				.orElse(null);
	}
}
