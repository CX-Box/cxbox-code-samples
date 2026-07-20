package org.demo.documentation.feature.encryptsign.encrypt.enums;

import java.util.Arrays;
import java.util.Map;
import java.util.Objects;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;
import com.fasterxml.jackson.annotation.JsonValue;

@Getter
@AllArgsConstructor
public enum StatusEncryptEnum {
	NO_ENCRYPT("Not encrypted"),
	ENCRYPT("Encrypted");

	public static final Map<StatusEncryptEnum, String> colors = Map.of(
			NO_ENCRYPT, "#ec3f3f",
			ENCRYPT, "#3fec3f"
	);

	@JsonValue
	private final String value;

	public static StatusEncryptEnum getByValue(@NonNull String value) {
		return Arrays.stream(StatusEncryptEnum.values())
				.filter(enm -> Objects.equals(enm.getValue(), value))
				.findFirst()
				.orElse(null);
	}
}
