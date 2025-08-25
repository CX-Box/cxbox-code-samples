package org.demo.documentation.other.equalsOfOne;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import com.fasterxml.jackson.annotation.JsonValue;

@RequiredArgsConstructor
@Getter
public enum MyExample3250Dictionary {

	FIRST_DICT("firstDict"),
	SECOND_DICT("secondDict"),
	THIRD_DICT("thirdDict"),
	FOURTH_DICT("fourthDict"),
	FIFTH_DICT("fifthDict");

	@JsonValue
	private final String value;

}
