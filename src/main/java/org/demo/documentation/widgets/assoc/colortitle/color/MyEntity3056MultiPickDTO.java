package org.demo.documentation.widgets.assoc.colortitle.color;

import org.cxbox.api.data.dto.DataResponseDTO;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.core.util.filter.SearchParameter;

import org.demo.documentation.widgets.assoc.colortitle.MyEntity3056Multi;

@Getter
@Setter
@NoArgsConstructor
public class MyEntity3056MultiPickDTO extends DataResponseDTO {
    @SearchParameter(name = "customField")
    private String customField;
    @SearchParameter(name = "customFieldText")
    private String customFieldText;
    private String customFieldColor;
    private String customFieldColorFieldText;

    public MyEntity3056MultiPickDTO(MyEntity3056Multi entity) {
        this.id = entity.getId().toString();
        this.customField = entity.getCustomField();
        this.customFieldText = entity.getCustomFieldText();
        this.customFieldColor = "#eda6a6";
        this.customFieldColorFieldText = "#a6eda6";
    }

}
