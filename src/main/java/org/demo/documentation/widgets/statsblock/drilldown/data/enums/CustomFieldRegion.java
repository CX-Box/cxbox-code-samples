package org.demo.documentation.widgets.statsblock.drilldown.data.enums;

import com.fasterxml.jackson.annotation.JsonValue;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;

import java.util.Arrays;
import java.util.Objects;

@Getter
@AllArgsConstructor
public enum CustomFieldRegion {
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

	public static CustomFieldRegion getByValue(@NonNull String value) {
		return Arrays.stream(CustomFieldRegion.values())
				.filter(enm -> Objects.equals(enm.getValue(), value))
				.findFirst()
				.orElse(null);
	}
}
