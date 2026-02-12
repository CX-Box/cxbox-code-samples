package org.demo.repository.metabuilder.buildrowdependentmeta.isfieldchangenow.forproject.enums;

import com.fasterxml.jackson.annotation.JsonValue;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;

import java.util.Arrays;
import java.util.Objects;

@Getter
@AllArgsConstructor
public enum ChannelEnum {
	EMAIL("Email"),
	ICQ("Isq");

	@JsonValue
	private final String value;

	public static ChannelEnum getByValue(@NonNull String value) {
		return Arrays.stream(ChannelEnum.values())
				.filter(enm -> Objects.equals(enm.getValue(), value))
				.findFirst()
				.orElse(null);
	}
}
