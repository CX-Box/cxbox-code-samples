package org.demo.documentation.fields.dictionary.dictionarylov.icon;

import org.cxbox.api.data.dto.rowmeta.Icon;
import org.cxbox.dictionary.Dictionary;
import org.demo.documentation.fields.dictionary.dictionarylov.icon.enums.IconsEnum;
import org.demo.documentation.fields.dictionary.icon.enums.CustomFieldDictionaryEnum;


import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public record CustomDictionary(String key) implements Dictionary {

    public static final CustomDictionary HIGH = new CustomDictionary("HIGH");
    public static final CustomDictionary MIDDLE = new CustomDictionary("MIDDLE");
    public static final CustomDictionary LOW = new CustomDictionary("LOW");
    public static final CustomDictionary UPPER_MIDDLE = new CustomDictionary("UPPER_MIDDLE");
    public static final Map<CustomDictionary, Icon> icons = Map.of(
            HIGH, IconsEnum.ARROW_UP,
            MIDDLE,  IconsEnum.DOWN,
            UPPER_MIDDLE, IconsEnum.ARROW_UP_BLUE,
            LOW,  IconsEnum.WATERMELON
    );

}
