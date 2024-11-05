package org.demo.documentation.fields.dictionary.dictionarylov;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.cxbox.api.data.dto.rowmeta.Icon;


@RequiredArgsConstructor
@Getter
public enum IconsEnum implements Icon {
    ARROW_UP("arrow-up"),
    ARROW_DOWN("arrow-down"),
    ARROW_MIDDLE("arrow-middle");

    private final String icon;
}

