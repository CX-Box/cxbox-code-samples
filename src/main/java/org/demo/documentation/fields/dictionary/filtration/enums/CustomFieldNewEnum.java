package org.demo.documentation.fields.dictionary.filtration.enums;

import com.fasterxml.jackson.annotation.JsonValue;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;

import java.util.Arrays;
import java.util.Objects;

@Getter
@AllArgsConstructor
public enum CustomFieldNewEnum {
	A("A"),
	B("B"),
	C("C"),
	D("D"),
	E("E"),
	F("F"),
	G("G"),
	H("H"),
	I("I"),
	K("K");

	@JsonValue
	private final String value;

	public static CustomFieldNewEnum getByValue(@NonNull String value) {
		return Arrays.stream(CustomFieldNewEnum.values())
				.filter(enm -> Objects.equals(enm.getValue(), value))
				.findFirst()
				.orElse(null);
	}
}
