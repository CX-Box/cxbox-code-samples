package org.demo.documentation.feature.synchasyncrequests.enums;

import java.util.Arrays;
import java.util.Objects;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;
import com.fasterxml.jackson.annotation.JsonValue;

@Getter
@AllArgsConstructor
public enum StatusEnum2 {
    IN_PROGRESS("In Progress"),
    ERROR("Error"),
    NEW("New"),
	DONE("Done");

    @JsonValue
    private final String value;

    public static StatusEnum2 getByValue(@NonNull String value) {
        return Arrays.stream(StatusEnum2.values())
                .filter(enm -> Objects.equals(enm.getValue(), value))
                .findFirst()
                .orElse(null);
    }
}
