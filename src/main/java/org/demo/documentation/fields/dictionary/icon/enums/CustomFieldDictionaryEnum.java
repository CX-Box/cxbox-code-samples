package org.demo.documentation.fields.dictionary.icon.enums;

import java.util.Arrays;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import lombok.Getter;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.NonNull;
import org.cxbox.api.data.dto.rowmeta.Icon;

@Getter
@AllArgsConstructor
public enum CustomFieldDictionaryEnum {

    HIGH("High", IconsEnum.ARROW_UP),
    MIDDLE("Middle", IconsEnum.DOWN),
    LOW("Low", IconsEnum.WATERMELON);

    @JsonValue
    private final String value;

    private final Icon icon;

    public static Map<CustomFieldDictionaryEnum, Icon> iconMap() {
        return Arrays.stream(CustomFieldDictionaryEnum.values()).filter(e -> e.icon != null).collect(Collectors.toMap(e -> e, e -> e.icon));
    }

    public static CustomFieldDictionaryEnum getByValue(@NonNull String value) {
        return Arrays.stream(CustomFieldDictionaryEnum.values())
                .filter(enm -> Objects.equals(enm.getValue(), value))
                .findFirst()
                .orElse(null);
    }
}
