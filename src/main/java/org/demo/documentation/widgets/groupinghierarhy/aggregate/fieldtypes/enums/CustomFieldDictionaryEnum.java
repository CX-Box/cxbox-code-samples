package org.demo.documentation.widgets.groupinghierarhy.aggregate.fieldtypes.enums;

import com.fasterxml.jackson.annotation.JsonValue;
import java.util.Arrays;
import java.util.Objects;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;

@Getter
@AllArgsConstructor
public enum CustomFieldDictionaryEnum {
	IMMOVABLE("Immovable property"),
	MOVABLE("Movable property"),
	LAND("Land parcel");

	@JsonValue
	private final String value;

	public static CustomFieldDictionaryEnum getByValue(@NonNull String value) {
		return Arrays.stream(CustomFieldDictionaryEnum.values())
				.filter(enm -> Objects.equals(enm.getValue(), value))
				.findFirst()
				.orElse(null);
	}
}
