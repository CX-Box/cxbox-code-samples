package org.demo.documentation.widgets.groupinghierarhy.defaultgroupinghierarchy.fourlevel.enums;

import java.util.Arrays;
import java.util.Objects;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;
import com.fasterxml.jackson.annotation.JsonValue;

@Getter
@AllArgsConstructor
public enum CustomFieldDictionaryLevelFourEnum {
	LEVEL_4_HIGH("Level 4 High"),
	LEVEL_4_MIDDLE("Level 4 Middle"),
	LEVEL_4_LOW("Level 4 Low");

    @JsonValue
    private final String value;

    public static CustomFieldDictionaryLevelFourEnum getByValue(@NonNull String value) {
        return Arrays.stream(CustomFieldDictionaryLevelFourEnum.values())
                .filter(enm -> Objects.equals(enm.getValue(), value))
                .findFirst()
                .orElse(null);
    }
}
