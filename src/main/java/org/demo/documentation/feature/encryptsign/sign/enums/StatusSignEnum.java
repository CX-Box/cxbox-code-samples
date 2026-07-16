package org.demo.documentation.feature.encryptsign.sign.enums;

import java.util.Arrays;
import java.util.Map;
import java.util.Objects;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;
import com.fasterxml.jackson.annotation.JsonValue;

@Getter
@AllArgsConstructor
public enum StatusSignEnum {
	NO_SIGNED("Not signed"),
	SIGNED("Signed");

	@JsonValue
	private final String value;

	public static final Map<StatusSignEnum, String> colors = Map.of(
			NO_SIGNED, "#ec3f3f",
			SIGNED, "#3fec3f"
	);
	public static StatusSignEnum getByValue(@NonNull String value) {
		return Arrays.stream(StatusSignEnum.values())
				.filter(enm -> Objects.equals(enm.getValue(), value))
				.findFirst()
				.orElse(null);
	}
}
