package org.demo.documentation.widgets.cardlist.status.enums;

import com.fasterxml.jackson.annotation.JsonValue;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum StatusEnum {
	NEW("New", "#6aa6ed"),
	APPROVED("Approved", "#6aed8a"),
	REJECTED("Rejected", "#ed6a6a");

	@JsonValue
	private final String value;

	private final String color;
}
