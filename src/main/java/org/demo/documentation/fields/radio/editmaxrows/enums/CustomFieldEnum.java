package org.demo.documentation.fields.radio.editmaxrows.enums;

import com.fasterxml.jackson.annotation.JsonValue;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;

import java.util.Arrays;
import java.util.Objects;

@Getter
@AllArgsConstructor
public enum CustomFieldEnum {
	SHORT("Short"),
	MEDIUM("Medium value that consists of several words"),
	LONG("Long value that is intentionally written to take more than one line in a narrow radio button list widget, so that it is clamped"),
	VERY_LONG("Very long value: Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum");

	@JsonValue
	private final String value;

	public static CustomFieldEnum getByValue(@NonNull String value) {
		return Arrays.stream(CustomFieldEnum.values())
				.filter(enm -> Objects.equals(enm.getValue(), value))
				.findFirst()
				.orElse(null);
	}
}
