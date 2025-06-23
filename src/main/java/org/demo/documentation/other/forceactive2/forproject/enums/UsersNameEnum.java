package org.demo.documentation.other.forceactive2.forproject.enums;

import java.util.Arrays;
import java.util.Objects;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;
import com.fasterxml.jackson.annotation.JsonValue;

@Getter
@AllArgsConstructor
public enum UsersNameEnum {
    USER_1("User 1"),
    USER_2("User 2"),
    USER_3("User 3");

    @JsonValue
    private final String value;

    public static UsersNameEnum getByValue(@NonNull String value) {
        return Arrays.stream(UsersNameEnum.values())
                .filter(enm -> Objects.equals(enm.getValue(), value))
                .findFirst()
                .orElse(null);
    }
}
