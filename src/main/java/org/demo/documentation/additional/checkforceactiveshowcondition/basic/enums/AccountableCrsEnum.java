package org.demo.documentation.additional.checkforceactiveshowcondition.basic.enums;

import com.fasterxml.jackson.annotation.JsonValue;
import java.util.Arrays;
import java.util.Objects;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum AccountableCrsEnum {

	UNACCOUNTABLE("Not accountable", false),
	ACCOUNTABLE("Accountable", true);

	@JsonValue
	private final String value;

	private final boolean val;

	public static AccountableCrsEnum byBoolean(Boolean value) {
		return Arrays.stream(AccountableCrsEnum.values())
				.filter(enm -> Objects.equals(enm.isVal(), value))
				.findFirst()
				.orElse(null);
	}

}
