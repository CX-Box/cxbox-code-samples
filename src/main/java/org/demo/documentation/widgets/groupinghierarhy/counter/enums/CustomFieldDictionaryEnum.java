package org.demo.documentation.widgets.groupinghierarhy.counter.enums;

import java.util.Arrays;
import java.util.Objects;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;
import com.fasterxml.jackson.annotation.JsonValue;

@Getter
@AllArgsConstructor
public enum CustomFieldDictionaryEnum {
    HIGH("High"),
    MIDDLE("Middle"),
    UPPER_MIDDLE("Upper middle"),
    LOW("Low");

    @JsonValue
    private final String value;

    public static CustomFieldDictionaryEnum getByValue(@NonNull String value) {
        return Arrays.stream(CustomFieldDictionaryEnum.values())
                .filter(enm -> Objects.equals(enm.getValue(), value))
                .findFirst()
                .orElse(null);
    }
}
