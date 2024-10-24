package org.demo.documentation.other.widgetEditStyles.colortitle.enums;

import com.fasterxml.jackson.annotation.JsonValue;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;

import java.util.Arrays;
import java.util.Objects;

@Getter
@AllArgsConstructor
public enum WidgetStylesColorRadioEnum {
    HIGH("High"),
    MIDDLE("Middle"),
    LOW("Low");

    @JsonValue
    private final String value;

    public static WidgetStylesColorRadioEnum getByValue(@NonNull String value) {
        return Arrays.stream(WidgetStylesColorRadioEnum.values())
                .filter(enm -> Objects.equals(enm.getValue(), value))
                .findFirst()
                .orElse(null);
    }
}
