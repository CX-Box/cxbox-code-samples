package org.demo.documentation.widgets.steps.base;

import com.fasterxml.jackson.annotation.JsonValue;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;

import java.util.Arrays;
import java.util.Optional;

@Getter
@AllArgsConstructor
public enum StepsEnum {
	STEP_1("It's step 1", "screen/myexample5023/view/myexample5023step1/"),
	STEP_2("It's step 2", "screen/myexample5023/view/myexample5023step2/"),
	STEP_3("It's step 3", "screen/myexample5023/view/myexample5023step3/");

	@JsonValue
	private final String value;

	private final String stepView;

	@NonNull
	public static Optional<StepsEnum> getNextEditStep(MyEntity5023 stepEntity) {
		return Arrays.stream(StepsEnum.values())
				.filter(v -> v.ordinal() > stepEntity.getEditStep().ordinal())
				.findFirst();
	}

	@NonNull
	public static Optional<StepsEnum> getPreviousEditStep(MyEntity5023 stepEntity) {
		return Arrays.stream(StepsEnum.values())
				.filter(v -> v.ordinal() < stepEntity.getEditStep().ordinal())
				.min((v1, v2) -> Integer.compare(v2.ordinal(), v1.ordinal()));
	}
}
