package org.demo.documentation.feature.locale.enums;
import lombok.AllArgsConstructor;
import lombok.Getter;
import com.fasterxml.jackson.annotation.JsonValue;
import org.demo.conf.cxbox.customization.locale.LocaleEnum;

@Getter
@AllArgsConstructor
public enum StatusEnum implements LocaleEnum {

	NEW("New", "Nouvelle"),
	INACTIVE("Inactive", "Inactive"),
	IN_PROGRESS("In progress", "En cours");

	@JsonValue
	private final String value;

	private final String valueFr;
}
