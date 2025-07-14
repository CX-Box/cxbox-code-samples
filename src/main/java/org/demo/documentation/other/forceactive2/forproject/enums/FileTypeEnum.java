package org.demo.documentation.other.forceactive2.forproject.enums;

import java.util.Arrays;
import java.util.Objects;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;
import com.fasterxml.jackson.annotation.JsonValue;

@Getter
@AllArgsConstructor
public enum FileTypeEnum {
    FILE_TYPE_1("File type 1"),
    FILE_TYPE_2("File type 2"),
    FILE_TYPE_3("File type 3");

    @JsonValue
    private final String value;

    public static FileTypeEnum getByValue(@NonNull String value) {
        return Arrays.stream(FileTypeEnum.values())
                .filter(enm -> Objects.equals(enm.getValue(), value))
                .findFirst()
                .orElse(null);
    }
}
