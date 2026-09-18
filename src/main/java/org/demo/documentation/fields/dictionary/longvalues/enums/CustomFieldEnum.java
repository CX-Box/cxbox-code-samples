package org.demo.documentation.fields.dictionary.longvalues.enums;

import com.fasterxml.jackson.annotation.JsonValue;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;

import java.util.Arrays;
import java.util.Objects;

@Getter
@AllArgsConstructor
public enum CustomFieldEnum {
	DISPUTE("Delivery is suspended until the parties agree on the terms of the supplementary agreement and the client confirms the new delivery schedule in writing"),
	POSTPONED("Client asked to postpone the delivery until the end of the next quarter"),
	UNSIGNED("Documents are not signed by the authorized person of the counterparty"),
	UNCONFIRMED("Payment is not confirmed by the bank"),
	OTHER("Other");

	@JsonValue
	private final String value;

	public static CustomFieldEnum getByValue(@NonNull String value) {
		return Arrays.stream(CustomFieldEnum.values())
				.filter(enm -> Objects.equals(enm.getValue(), value))
				.findFirst()
				.orElse(null);
	}
}
