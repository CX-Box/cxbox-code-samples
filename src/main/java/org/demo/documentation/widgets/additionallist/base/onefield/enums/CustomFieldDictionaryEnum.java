package org.demo.documentation.widgets.additionallist.base.onefield.enums;

import java.util.Arrays;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;
import com.fasterxml.jackson.annotation.JsonValue;
import org.cxbox.api.data.dto.rowmeta.Icon;

import static org.demo.documentation.widgets.additionallist.base.onefield.enums.IconsEnum.CHECK;
import static org.demo.documentation.widgets.additionallist.base.onefield.enums.IconsEnum.CLOSE;

@Getter
@AllArgsConstructor
public enum CustomFieldDictionaryEnum {
	CHECK_PARAM("Check",CHECK),
	CLOSE_PARAM("Close",CLOSE);

	@JsonValue
	private final String value;

	private final Icon icon;

	public static CustomFieldDictionaryEnum getByValue(@NonNull String value) {
		return Arrays.stream(CustomFieldDictionaryEnum.values())
				.filter(enm -> Objects.equals(enm.getValue(), value))
				.findFirst()
				.orElse(null);
	}

	public static Map<CustomFieldDictionaryEnum, Icon> iconMap() {
		return Arrays.stream(CustomFieldDictionaryEnum.values()).filter(e -> e.icon != null).collect(Collectors.toMap(e -> e, e -> e.icon));
	}

}
