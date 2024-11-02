package org.demo.documentation.widgets.groupinghierarhy.defaultgroupinghierarchy.fourlevel.enums;

import java.util.Arrays;
import java.util.Objects;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;
import com.fasterxml.jackson.annotation.JsonValue;

@Getter
@AllArgsConstructor
public enum CustomFieldDictionaryEnum {
    LEVEL_1_HIGH("Level 1 High"),
	LEVEL_1_MIDDLE("Level 1 Middle"),
	LEVEL_1_LOW("Level 1 Low");

    @JsonValue
    private final String value;

    public static CustomFieldDictionaryEnum getByValue(@NonNull String value) {
        return Arrays.stream(CustomFieldDictionaryEnum.values())
                .filter(enm -> Objects.equals(enm.getValue(), value))
                .findFirst()
                .orElse(null);
    }
}
