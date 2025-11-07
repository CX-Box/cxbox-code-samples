package org.demo.documentation.other.ingosexample.enums;
import java.util.Arrays;
import java.util.Objects;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;
import com.fasterxml.jackson.annotation.JsonValue;

@Getter
@AllArgsConstructor
public enum AssignedUsers2Enum {
		HIGH("High"),
		MIDDLE("Middle"),
		LOW("Low");

@JsonValue
private final String value;

public static AssignedUsers2Enum getByValue(@NonNull String value){
		return Arrays.stream(AssignedUsers2Enum.values())
		.filter(enm->Objects.equals(enm.getValue(),value))
		.findFirst()
		.orElse(null);
		}
		}
