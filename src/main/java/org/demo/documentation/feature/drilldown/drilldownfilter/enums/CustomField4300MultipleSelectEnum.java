package org.demo.documentation.feature.drilldown.drilldownfilter.enums;

import java.util.Arrays;
import java.util.Objects;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;

import com.fasterxml.jackson.annotation.JsonValue;

@Getter
@AllArgsConstructor
public enum CustomField4300MultipleSelectEnum {
	ONE_RE("OneRE"),
	TWO_RE("TwoRE"),
	THREE_RE("ThreeRE"),
	FOUR_RE("FourRE"),
	FIVE_RE("FiveRE");

	@JsonValue
	private final String value;

	public static CustomField4300MultipleSelectEnum getByValue(@NonNull String value) {
		return Arrays.stream(CustomField4300MultipleSelectEnum.values())
				.filter(enm -> Objects.equals(enm.getValue(), value))
				.findFirst()
				.orElse(null);
	}
}
