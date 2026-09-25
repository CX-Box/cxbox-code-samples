package org.demo.documentation.widgets.line2d.data;

import com.fasterxml.jackson.annotation.JsonValue;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ProductEnum {
	EQUIPMENT("Equipment"),
	EXPERTISE("Expertise");

	@JsonValue
	private final String value;
}
