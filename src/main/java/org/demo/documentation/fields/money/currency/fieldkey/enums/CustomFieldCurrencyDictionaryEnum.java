package org.demo.documentation.fields.money.currency.fieldkey.enums;

import com.fasterxml.jackson.annotation.JsonValue;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;

import java.util.Arrays;
import java.util.Objects;

@Getter
@AllArgsConstructor
public enum CustomFieldCurrencyDictionaryEnum {
	DOLLAR("USD"),
	RUBLE("RUB"),
	EURO("EUR"),
	FORINT("HUF"),
	PS("GBP"),
	DK("DKK");

	@JsonValue
	private final String value;

	public static CustomFieldCurrencyDictionaryEnum getByValue(@NonNull String value) {
		return Arrays.stream(CustomFieldCurrencyDictionaryEnum.values())
				.filter(enm -> Objects.equals(enm.getValue(), value))
				.findFirst()
				.orElse(null);
	}
}
