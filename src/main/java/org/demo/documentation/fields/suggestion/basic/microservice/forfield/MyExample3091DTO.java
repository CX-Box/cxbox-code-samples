package org.demo.documentation.fields.suggestion.basic.microservice.forfield;

import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.Getter;
import org.cxbox.api.data.dto.DataResponseDTO;
import org.cxbox.core.util.filter.SearchParameter;
import org.cxbox.core.util.filter.provider.impl.StringValueProvider;

@Getter
@Setter
@NoArgsConstructor
public class MyExample3091DTO extends DataResponseDTO {

    private String customField;
    private String customFieldDate;

    @SearchParameter(name = "customFieldNew", provider = StringValueProvider.class)
    private String customFieldNew;

    public MyExample3091DTO(MyEntity3091 entity) {
        this.id = entity.getId().toString();
        this.customField = entity.getCustomField();
        this.customFieldDate = entity.getCustomFieldDate();
        this.customFieldNew = entity.getCustomFieldNew();
    }
}