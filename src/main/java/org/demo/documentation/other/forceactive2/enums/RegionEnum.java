package org.demo.documentation.other.forceactive2.enums;

import java.util.Arrays;
import java.util.Objects;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;
import com.fasterxml.jackson.annotation.JsonValue;

@Getter
@AllArgsConstructor
public enum RegionEnum {
    BREST("Brest region"),
    GOMEL("Gomel region"),
    MINSK("Minsk region"),
    VOLGOGRADSKAYA("Volgogradskaya region"),
    KOSTROMSKAYA("Kostromaskaya region"),
    MOSCOWSKAYA("Moscowskaya region");

    @JsonValue
    private final String value;

    public static RegionEnum getByValue(@NonNull String value) {
        return Arrays.stream(RegionEnum.values())
                .filter(enm -> Objects.equals(enm.getValue(), value))
                .findFirst()
                .orElse(null);
    }
}
