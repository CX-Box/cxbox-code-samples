package org.demo.repository.metabuilder.buildrowdependentmeta.isfieldchangenow.enums;

import com.fasterxml.jackson.annotation.JsonValue;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;

import java.util.Arrays;
import java.util.Objects;

@Getter
@AllArgsConstructor
public enum ProductTypeEnum {
	FAMILY("Family"),
	STANDART("Standard");
	@JsonValue
	private final String value;

	public static ProductTypeEnum getByValue(@NonNull String value) {
		return Arrays.stream(ProductTypeEnum.values())
				.filter(enm -> Objects.equals(enm.getValue(), value))
				.findFirst()
				.orElse(null);
	}
}
