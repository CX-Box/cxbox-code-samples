package org.demo.documentation.feature.encryptsign.encryptsign.enums;

import java.util.Arrays;
import java.util.Map;
import java.util.Objects;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;
import com.fasterxml.jackson.annotation.JsonValue;

@Getter
@AllArgsConstructor
public enum StatusEncryptSignEnum {
	NO_SIGN_ENCRYPT("Not signed"),
	SIGN_ENCRYPT("Signed");

	@JsonValue
	private final String value;

	public static final Map<StatusEncryptSignEnum, String> colors = Map.of(
			NO_SIGN_ENCRYPT, "#ec3f3f",
			SIGN_ENCRYPT, "#3fec3f"
	);
	public static StatusEncryptSignEnum getByValue(@NonNull String value) {
		return Arrays.stream(StatusEncryptSignEnum.values())
				.filter(enm -> Objects.equals(enm.getValue(), value))
				.findFirst()
				.orElse(null);
	}
}
