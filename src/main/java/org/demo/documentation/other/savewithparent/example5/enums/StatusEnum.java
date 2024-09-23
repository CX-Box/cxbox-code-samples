package org.demo.documentation.other.savewithparent.example5.enums;

import com.fasterxml.jackson.annotation.JsonValue;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;
import org.demo.documentation.other.alltypes.enums.DictionaryTypeEnum;

import java.util.Arrays;
import java.util.Objects;

@Getter
@AllArgsConstructor
public enum StatusEnum {
	NEW("New"),
	CANCEL("Cancel");

	@JsonValue
	private final String value;

	public static DictionaryTypeEnum getByValue(@NonNull String value) {
		return Arrays.stream(DictionaryTypeEnum.values())
				.filter(enm -> Objects.equals(enm.getValue(), value))
				.findFirst()
				.orElse(null);
	}
}
