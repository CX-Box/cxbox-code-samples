package org.demo.documentation.widgets.groupinghierarhy.defaultgroupinghierarchy.fivelevel.enums;

import java.util.Arrays;
import java.util.Objects;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;
import com.fasterxml.jackson.annotation.JsonValue;

@Getter
@AllArgsConstructor
public enum CustomFieldDictionaryLevelTwoEnum {
	LEVEL_2_HIGH("Level 2 High"),
	LEVEL_2_MIDDLE("Level 2 Middle"),
	LEVEL_2_LOW("Level 2 Low");

    @JsonValue
    private final String value;

    public static CustomFieldDictionaryLevelTwoEnum getByValue(@NonNull String value) {
        return Arrays.stream(CustomFieldDictionaryLevelTwoEnum.values())
                .filter(enm -> Objects.equals(enm.getValue(), value))
                .findFirst()
                .orElse(null);
    }
}
