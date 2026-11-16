package org.demo.documentation.feature.file.availability.enums;

import com.fasterxml.jackson.annotation.JsonValue;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum StatusEnum {
	OPEN("Open"),
	CLOSED("Closed");

	@JsonValue
	private final String value;
}
