package org.demo.documentation.widgets.statsblock.drilldown.parentchild.data.enums;

import com.fasterxml.jackson.annotation.JsonValue;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;

import java.util.Arrays;
import java.util.Objects;

@Getter
@AllArgsConstructor
public enum ExampleStatus {
	IN_COMPLETION("In completion"),
	COMPLETED("Completed"),
	IN_PROGRESS("In progress"),
	NOT_STARTED("Not started"),
	CANCELLED("Cancelled");

	@JsonValue
	private final String value;

	public static ExampleStatus getByValue(@NonNull String value) {
		return Arrays.stream(ExampleStatus.values())
				.filter(enm -> Objects.equals(enm.getValue(), value))
				.findFirst()
				.orElse(null);
	}
}