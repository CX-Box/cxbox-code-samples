package org.demo.documentation.feature.encryptsign.signencrypt.enums;

import java.util.Arrays;
import java.util.Map;
import java.util.Objects;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;
import com.fasterxml.jackson.annotation.JsonValue;

@Getter
@AllArgsConstructor
public enum StatusSignEncryptEnum {
	NO_SIGN_ENCRYPT("Not signed"),
	SIGN_ENCRYPT("Signed");

	@JsonValue
	private final String value;

	public static final Map<StatusSignEncryptEnum, String> colors = Map.of(
			NO_SIGN_ENCRYPT, "#ec3f3f",
			SIGN_ENCRYPT, "#3fec3f"
	);

	public static StatusSignEncryptEnum getByValue(@NonNull String value) {
		return Arrays.stream(StatusSignEncryptEnum.values())
				.filter(enm -> Objects.equals(enm.getValue(), value))
				.findFirst()
				.orElse(null);
	}
}
