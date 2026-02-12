package org.demo.documentation.feature.postaction.enums;

import com.fasterxml.jackson.annotation.JsonValue;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;

import java.util.Arrays;
import java.util.Objects;

@Getter
@AllArgsConstructor
public enum StatusEnum {
	IN_PROGRESS("In Progress"),
	ERROR("Error"),
	NEW("New"),
	DONE("Done");
	@JsonValue
	private final String value;

	public static StatusEnum getByValue(@NonNull String value) {
		return Arrays.stream(StatusEnum.values())
				.filter(enm -> Objects.equals(enm.getValue(), value))
				.findFirst()
				.orElse(null);
	}
}
