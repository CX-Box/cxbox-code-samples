package org.demo.documentation.widgets.groupinghierarhy.defaultgroupinghierarchy.twolevel.enums;

import java.util.Arrays;
import java.util.Objects;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;
import com.fasterxml.jackson.annotation.JsonValue;

@Getter
@AllArgsConstructor
public enum CustomFieldDictionaryLevelTwoEnum {
    HIGH("High"),
    MIDDLE("Middle"),
    LOW("Low");

    @JsonValue
    private final String value;

    public static CustomFieldDictionaryLevelTwoEnum getByValue(@NonNull String value) {
        return Arrays.stream(CustomFieldDictionaryLevelTwoEnum.values())
                .filter(enm -> Objects.equals(enm.getValue(), value))
                .findFirst()
                .orElse(null);
    }
}
