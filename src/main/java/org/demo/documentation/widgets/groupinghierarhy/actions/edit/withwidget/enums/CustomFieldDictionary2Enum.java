package org.demo.documentation.widgets.groupinghierarhy.actions.edit.withwidget.enums;

import java.util.Arrays;
import java.util.Objects;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;
import com.fasterxml.jackson.annotation.JsonValue;

@Getter
@AllArgsConstructor
public enum CustomFieldDictionary2Enum {
    HIGH("Test1"),
    MIDDLE("Test2"),
    LOW("Test3");

    @JsonValue
    private final String value;

    public static CustomFieldDictionary2Enum getByValue(@NonNull String value) {
        return Arrays.stream(CustomFieldDictionary2Enum.values())
                .filter(enm -> Objects.equals(enm.getValue(), value))
                .findFirst()
                .orElse(null);
    }
}
