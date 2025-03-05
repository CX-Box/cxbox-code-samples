package org.demo.documentation.other.forceactive2.enums;

import java.util.Arrays;
import java.util.Objects;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;
import com.fasterxml.jackson.annotation.JsonValue;

@Getter
@AllArgsConstructor
public enum CountryEnum {
    BELARUS("Belarus"),
    RUSSIA("Russia");

    @JsonValue
    private final String value;

    public static CountryEnum getByValue(@NonNull String value) {
        return Arrays.stream(CountryEnum.values())
                .filter(enm -> Objects.equals(enm.getValue(), value))
                .findFirst()
                .orElse(null);
    }
}
