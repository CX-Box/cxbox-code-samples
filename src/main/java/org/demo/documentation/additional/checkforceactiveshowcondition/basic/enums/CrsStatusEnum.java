package org.demo.documentation.additional.checkforceactiveshowcondition.basic.enums;

import com.fasterxml.jackson.annotation.JsonValue;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum CrsStatusEnum {

	FINANCIAL_INSTITUTION("Financial institution"),
	ACTIVE_NFE("Active non-financial entity"),
	PASSIVE_NFE("Passive non-financial entity");

	@JsonValue
	private final String value;

}
