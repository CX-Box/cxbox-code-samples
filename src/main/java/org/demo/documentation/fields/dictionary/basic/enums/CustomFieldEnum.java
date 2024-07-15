package org.demo.documentation.fields.dictionary.basic.enums;

import com.fasterxml.jackson.annotation.JsonValue;
import java.util.Arrays;
import java.util.Objects;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;

@Getter
@AllArgsConstructor
public enum CustomFieldEnum {
	BELGOROD("Belgorod region"),
	BRYANSK("Bryansk region"),
	VLADIMIR("Vladimir region"),
	VORONEZH("Voronezh region"),
	IVANOVO("Ivanovo region"),
	KALUGA("Kaluga region"),
	KOSTROMA("Kostroma region"),
	KURSK("Kursk region"),
	MOSCOW("Moscow region"),
	ORYOL("Oryol region"),
	RYAZAN("Ryazan region"),
	SMOLENSK("Smolensk region"),
	TAMBOV("Tambov region"),
	TVER("Tver region");

	@JsonValue
	private final String value;

	public static CustomFieldEnum getByValue(@NonNull String value) {
		return Arrays.stream(CustomFieldEnum.values())
				.filter(enm -> Objects.equals(enm.getValue(), value))
				.findFirst()
				.orElse(null);
	}
}
