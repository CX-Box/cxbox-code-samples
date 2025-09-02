package org.demo.documentation.widgets.headerwidget.colortitle;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.Getter;
import org.cxbox.api.data.dto.DataResponseDTO;
import org.cxbox.core.util.filter.SearchParameter;
import org.cxbox.core.util.filter.provider.impl.StringValueProvider;

@Getter
@Setter
@NoArgsConstructor
public class MyExample5024DTO extends DataResponseDTO {

    @SearchParameter(name = "customField", provider = StringValueProvider.class)
    private String customField;

    @SearchParameter(name = "customFieldText", provider = StringValueProvider.class)
    private String customFieldText;

    private String customFieldColor;
    private String customFieldTextColor;

    public MyExample5024DTO(MyEntity5024 entity) {
        this.id = entity.getId().toString();
        this.customField = entity.getCustomField();
        this.customFieldText = entity.getCustomFieldText();
        this.customFieldColor = "#eda6a6";
        this.customFieldTextColor = "#a6eda6";
    }
}
