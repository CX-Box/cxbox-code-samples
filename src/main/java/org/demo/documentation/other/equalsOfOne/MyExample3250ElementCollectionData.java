package org.demo.documentation.other.equalsOfOne;

import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

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