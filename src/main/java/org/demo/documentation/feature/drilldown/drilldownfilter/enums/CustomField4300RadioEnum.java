package org.demo.documentation.feature.drilldown.drilldownfilter.enums;

import com.fasterxml.jackson.annotation.JsonValue;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;

import java.util.Arrays;
import java.util.Objects;

@Getter
@AllArgsConstructor
public enum CustomField4300RadioEnum {
	ONE_RE("OneRE"),
	TWO_RE("TwoRE"),
	THREE_RE("ThreeRE"),
	FOUR_RE("FourRE"),
	FIVE_RE("FiveRE");

	@JsonValue
	private final String value;

	public static CustomField4300RadioEnum getByValue(@NonNull String value) {
		return Arrays.stream(CustomField4300RadioEnum.values())
				.filter(enm -> Objects.equals(enm.getValue(), value))
				.findFirst()
				.orElse(null);
	}
}
