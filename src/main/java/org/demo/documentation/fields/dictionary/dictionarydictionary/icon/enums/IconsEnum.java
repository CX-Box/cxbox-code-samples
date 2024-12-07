package org.demo.documentation.fields.dictionary.dictionarydictionary.icon.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.cxbox.api.data.dto.rowmeta.Icon;


@RequiredArgsConstructor
@Getter
public enum IconsEnum implements Icon {
    ARROW_UP_BLUE("arrow-up #0cbfe9"),
    ARROW_UP("arrow-up"),
    WATERMELON("watermelon"),
    DOWN("down");

    private final String icon;

}

