package org.demo.documentation.feature.drilldown.drilldownfilter.enums;

import com.fasterxml.jackson.annotation.JsonValue;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;

import java.util.Arrays;
import java.util.Objects;

@Getter
@AllArgsConstructor
public enum CustomField4300DictionaryEnum {
	ONE_DE("OneDE"),
	TWO_DE("TwoDE"),
	THREE_DE("ThreeDE"),
	FOUR_DE("FourDE"),
	FIVE_DE("FiveDE");

	@JsonValue
	private final String value;

	public static CustomField4300DictionaryEnum getByValue(@NonNull String value) {
		return Arrays.stream(CustomField4300DictionaryEnum.values())
				.filter(enm -> Objects.equals(enm.getValue(), value))
				.findFirst()
				.orElse(null);
	}
}
