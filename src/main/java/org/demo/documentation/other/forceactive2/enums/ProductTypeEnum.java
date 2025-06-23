package org.demo.documentation.other.forceactive2.enums;

import java.util.Arrays;
import java.util.Objects;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;
import com.fasterxml.jackson.annotation.JsonValue;

@Getter
@AllArgsConstructor
public enum ProductTypeEnum {
	FAMILY("Family"),
	STANDART("Standard");
    @JsonValue
    private final String value;

    public static ProductTypeEnum getByValue(@NonNull String value) {
        return Arrays.stream(ProductTypeEnum.values())
                .filter(enm -> Objects.equals(enm.getValue(), value))
                .findFirst()
                .orElse(null);
    }
}
