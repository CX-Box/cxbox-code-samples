package org.demo.documentation.widgets.groupinghierarhy.defaultgroupinghierarchy.fivelevel.enums;

import java.util.Arrays;
import java.util.Objects;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;
import com.fasterxml.jackson.annotation.JsonValue;

@Getter
@AllArgsConstructor
public enum CustomFieldDictionaryLevelFiveEnum {
    LEVEL_5_HIGH("Level 5 High"),
    LEVEL_5_MIDDLE("Level 5 Middle"),
    LEVEL_5_LOW("Level 5 Low");

    @JsonValue
    private final String value;

    public static CustomFieldDictionaryLevelFiveEnum getByValue(@NonNull String value) {
        return Arrays.stream(CustomFieldDictionaryLevelFiveEnum.values())
                .filter(enm -> Objects.equals(enm.getValue(), value))
                .findFirst()
                .orElse(null);
    }
}
