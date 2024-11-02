package org.demo.documentation.widgets.groupinghierarhy.defaultgroupinghierarchy.threelevel.enums;

import java.util.Arrays;
import java.util.Objects;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;
import com.fasterxml.jackson.annotation.JsonValue;

@Getter
@AllArgsConstructor
public enum CustomFieldDictionaryLevelThreeEnum {
	LEVEL_3_HIGH("Level 3 High"),
	LEVEL_3_MIDDLE("Level 3 Middle"),
	LEVEL_3_LOW("Level 3 Low");


    @JsonValue
    private final String value;

    public static CustomFieldDictionaryLevelThreeEnum getByValue(@NonNull String value) {
        return Arrays.stream(CustomFieldDictionaryLevelThreeEnum.values())
                .filter(enm -> Objects.equals(enm.getValue(), value))
                .findFirst()
                .orElse(null);
    }
}
