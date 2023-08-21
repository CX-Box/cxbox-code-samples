package org.demo.documentation.radio.validationdynamic.enums;

import com.fasterxml.jackson.annotation.JsonValue;
import java.util.Arrays;
import java.util.Objects;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;

@Getter
@AllArgsConstructor
public enum CustomFieldAdditionalEnum {
	HIGH("High"),
	MIDDLE("Middle"),
	LOW("Low");

	@JsonValue
	private final String value;

	public static CustomFieldAdditionalEnum getByValue(@NonNull String value) {
		return Arrays.stream(CustomFieldAdditionalEnum.values())
				.filter(enm -> Objects.equals(enm.getValue(), value))
				.findFirst()
				.orElse(null);
	}
}
