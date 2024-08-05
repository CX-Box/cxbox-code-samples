package org.demo.documentation.fields.suggestion.color.forfield;

import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.Getter;
import org.cxbox.api.data.dto.DataResponseDTO;
import org.cxbox.core.util.filter.SearchParameter;
import org.cxbox.core.util.filter.provider.impl.DateValueProvider;

@Getter
@Setter
@NoArgsConstructor
public class MyExample3093DTO extends DataResponseDTO {

    private String customField;
    private String customFieldDate;
    private String customFieldColor;

    public MyExample3093DTO(MyEntity3093 entity) {
        this.id = entity.getId().toString();
        this.customField = entity.getCustomField();
        this.customFieldDate = entity.getCustomFieldDate();
        this.customFieldColor = "#eda6a6";
    }
}