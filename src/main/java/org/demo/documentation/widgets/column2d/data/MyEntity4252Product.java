package org.demo.documentation.widgets.column2d.data;

import com.fasterxml.jackson.annotation.JsonValue;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum MyEntity4252Product {
	EXPERTISE("Expertise"),
	EQUIPMENT("Equipment");

	@JsonValue
	private final String value;
}
