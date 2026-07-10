package org.demo.documentation.widgets.pie1d.data;

import com.fasterxml.jackson.annotation.JsonValue;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;

import java.util.Arrays;
import java.util.Objects;

@Getter
@AllArgsConstructor
public enum CustomFieldStatusEnum {
	OPEN("Open"),
	CLOSED("Closed");

	@JsonValue
	private final String value;

	public static CustomFieldStatusEnum getByValue(@NonNull String value) {
		return Arrays.stream(CustomFieldStatusEnum.values())
				.filter(enm -> Objects.equals(enm.getValue(), value))
				.findFirst()
				.orElse(null);
	}
}
