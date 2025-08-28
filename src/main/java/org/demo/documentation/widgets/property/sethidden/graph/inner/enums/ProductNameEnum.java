package org.demo.documentation.widgets.property.sethidden.graph.inner.enums;

import java.util.Arrays;
import java.util.Objects;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;
import com.fasterxml.jackson.annotation.JsonValue;

@Getter
@AllArgsConstructor
public enum ProductNameEnum {
    EQUIPMENT( "Equipment"),
    EXPERTISE("Expertise");

    @JsonValue
    private final String value;

    public static ProductNameEnum getByValue(@NonNull String value) {
        return Arrays.stream(ProductNameEnum.values())
                .filter(enm -> Objects.equals(enm.getValue(), value))
                .findFirst()
                .orElse(null);
    }
}
