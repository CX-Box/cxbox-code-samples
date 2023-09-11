package org.demo.documentation.other.alltypes.enums;

import java.util.Arrays;
import java.util.Objects;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;
import com.fasterxml.jackson.annotation.JsonValue;

@Getter
@AllArgsConstructor
public enum DictionaryTypeLovEnum {
    HIGH("High"),
    MIDDLE("Middle"),
    LOW("Low");

    @JsonValue
    private final String value;

    public static DictionaryTypeLovEnum getByValue(@NonNull String value) {
        return Arrays.stream(DictionaryTypeLovEnum.values())
                .filter(enm -> Objects.equals(enm.getValue(), value))
                .findFirst()
                .orElse(null);
    }
}
