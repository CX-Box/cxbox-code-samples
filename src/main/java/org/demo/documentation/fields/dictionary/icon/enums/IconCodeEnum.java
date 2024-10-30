package org.demo.documentation.fields.dictionary.icon.enums;

import com.fasterxml.jackson.annotation.JsonValue;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;

import java.util.Arrays;
import java.util.Objects;

@Getter
@AllArgsConstructor
public enum IconCodeEnum {
    CameraTwoTone("CameraTwoTone"),
    CreditCardTwoTone("CreditCardTwoTone"),
    ARROW_UP_RED("arrow-up red");

    @JsonValue
    private final String value;

    public static IconCodeEnum getByValue(@NonNull String value) {
        return Arrays.stream(IconCodeEnum.values())
                .filter(enm -> Objects.equals(enm.getValue(), value))
                .findFirst()
                .orElse(null);
    }
}