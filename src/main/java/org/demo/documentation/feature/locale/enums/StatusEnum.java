package org.demo.documentation.feature.locale.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import lombok.AllArgsConstructor;
import lombok.Getter;
import com.fasterxml.jackson.annotation.JsonValue;
import org.demo.conf.locale.LocalizedEnum;
import org.demo.conf.locale.LocalizedEnumUtil;

@Getter
@AllArgsConstructor
public enum StatusEnum implements LocalizedEnum {

	NEW("New", "Nouvelle"),
	INACTIVE("Inactive", "Inactive"),
	IN_PROGRESS("In progress", "En cours");

	@JsonValue
	private final String value;

	private final String valueFr;

	@JsonValue
	public String toValue() {
		return LocalizedEnumUtil.toValue(this);
	}

	@JsonCreator
	public static StatusEnum fromValue(String value) {
		return LocalizedEnumUtil
				.fromValue(StatusEnum.class, value)
				.orElse(null);
	}
}
