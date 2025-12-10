package org.demo.documentation.widgets.list.showcondition.bycurrententity.enums;

import java.util.Arrays;
import java.util.Objects;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;
import com.fasterxml.jackson.annotation.JsonValue;

@Getter
@AllArgsConstructor
public enum ManagerDecisionEnum {
    HIGH("High"),
    MIDDLE("Middle"),
    LOW("Low");

    @JsonValue
    private final String value;

    public static ManagerDecisionEnum getByValue(@NonNull String value) {
        return Arrays.stream(ManagerDecisionEnum.values())
                .filter(enm -> Objects.equals(enm.getValue(), value))
                .findFirst()
                .orElse(null);
    }
}
