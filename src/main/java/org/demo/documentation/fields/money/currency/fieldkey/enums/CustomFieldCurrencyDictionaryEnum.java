package org.demo.documentation.fields.money.currency.fieldkey.enums;

import java.util.Arrays;
import java.util.Objects;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;
import com.fasterxml.jackson.annotation.JsonValue;

@Getter
@AllArgsConstructor
public enum CustomFieldCurrencyDictionaryEnum {
    DOLLAR("Dollar"),
    RUBLE("Ruble"),
    EURO("Euro"),
	FORINT("Forint"),
	PS("Pound sterling"),
	DK("Danish krone");

    @JsonValue
    private final String value;

    public static CustomFieldCurrencyDictionaryEnum getByValue(@NonNull String value) {
        return Arrays.stream(CustomFieldCurrencyDictionaryEnum.values())
                .filter(enm -> Objects.equals(enm.getValue(), value))
                .findFirst()
                .orElse(null);
    }
}
