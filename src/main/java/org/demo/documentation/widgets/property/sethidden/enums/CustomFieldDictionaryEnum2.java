package org.demo.documentation.widgets.property.sethidden.enums;

import java.util.Arrays;
import java.util.Objects;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;
import com.fasterxml.jackson.annotation.JsonValue;

@Getter
@AllArgsConstructor
public enum CustomFieldDictionaryEnum2 {
    HIGH("High"),
    MIDDLE("Middle"),
    LOW("Low");

    @JsonValue
    private final String value;

    public static CustomFieldDictionaryEnum2 getByValue(@NonNull String value) {
        return Arrays.stream(CustomFieldDictionaryEnum2.values())
                .filter(enm -> Objects.equals(enm.getValue(), value))
                .findFirst()
                .orElse(null);
    }
}
