package org.demo.documentation.widgets.relationGraph.enums;

import com.fasterxml.jackson.annotation.JsonValue;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;

import java.util.Arrays;
import java.util.Objects;

@Getter
@AllArgsConstructor
public enum TargetNodeTypeEnum {
	MAIN("main");

	@JsonValue
	private final String value;

	public static TargetNodeTypeEnum getByValue(@NonNull String value) {
		return Arrays.stream(TargetNodeTypeEnum.values())
				.filter(enm -> Objects.equals(enm.getValue(), value))
				.findFirst()
				.orElse(null);
	}
}
