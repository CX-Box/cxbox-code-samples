package org.demo.documentation.widgets.groupinghierarhy.actions.edit.withwidget.enums;

import java.util.Arrays;
import java.util.Objects;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;
import com.fasterxml.jackson.annotation.JsonValue;

@Getter
@AllArgsConstructor
public enum DocTypeEnum {
    HIGH("Входящий"),
    MIDDLE("Исходящий"),
    LOW("Low");

    @JsonValue
    private final String value;

    public static DocTypeEnum getByValue(@NonNull String value) {
        return Arrays.stream(DocTypeEnum.values())
                .filter(enm -> Objects.equals(enm.getValue(), value))
                .findFirst()
                .orElse(null);
    }
}
