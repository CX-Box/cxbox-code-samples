package org.demo.documentation.widgets.list.fieldslayoute;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.api.data.dto.DataResponseDTO;
import org.cxbox.core.util.filter.SearchParameter;
import org.cxbox.core.util.filter.provider.impl.StringValueProvider;

@Getter
@Setter
@NoArgsConstructor
public class MyExample3100DTO extends DataResponseDTO {
    public static final String SINGLE_COLUMN_LAYOUT_TEXT = "Shows each field on new row. Each field can have width from 1 to 24";
    public static final String MULTI_COLUMN_LAYOUT_TEXT = "Shows fields in grid.Grid can contain any number of rows. Each row can contain any number of fields, until sum of fields widths in row is less than 24. Each field can have width from 1 to 24.";
    public static final String ONLY_BUTTONS_TEXT = "Only title and actions are shown. Usually used when standard buttons position needs to be changed (for example we want to show buttons under widget). One can hide buttons on widget with data. Create separate widget only with buttons and place it anywhere on view";
    public static final String MULTI_COLUMN_LAYOUT_LONG_TEXT = "If the title text is long.";
    public static final String MULTI_COLUMN_LAYOUT_SUM_SPAN_TEXT = "If the sum span >24 (24+12).";

    public MyExample3100DTO(MyEntity3100 entity) {
        this.id = entity.getId().toString();

    }
}