package org.demo.documentation.other.equalsOfOne;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import com.fasterxml.jackson.annotation.JsonValue;

@Getter
@RequiredArgsConstructor
public enum MyExample3250ElementCollectionData {

	FIRST("first"),
	SECOND("second"),
	THIRD("third"),
	FOURTH("fourth"),
	FIFTH("fifth");

	@JsonValue
	private final String value;

}