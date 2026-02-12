package org.demo.repository.metabuilder.buildrowdependentmeta.isfieldchangenow.forproject.enums;

import com.fasterxml.jackson.annotation.JsonValue;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;

import java.util.Arrays;
import java.util.Objects;

@Getter
@AllArgsConstructor
public enum ObjectTypeEnum {
	OBJECT_TYPE_1("Object type 1"),
	OBJECT_TYPE_2("Object type 2"),
	OBJECT_TYPE_3("Object type 3");

	@JsonValue
	private final String value;

	public static ObjectTypeEnum getByValue(@NonNull String value) {
		return Arrays.stream(ObjectTypeEnum.values())
				.filter(enm -> Objects.equals(enm.getValue(), value))
				.findFirst()
				.orElse(null);
	}
}
