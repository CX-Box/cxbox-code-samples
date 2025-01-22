package org.demo.documentation.feature.meta.buildindependentmeta.setdictionarytypewithconcretevaluesfromlist;

import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.Getter;
import org.cxbox.api.data.dto.DataResponseDTO;
import org.cxbox.core.util.filter.SearchParameter;
import org.cxbox.core.util.filter.provider.impl.StringValueProvider;

@Getter
@Setter
@NoArgsConstructor
public class MyExample3154DTO extends DataResponseDTO {

    @SearchParameter(name = "customField")
    private String customField;

    public MyExample3154DTO(MyEntity3154 entity) {
        this.id = entity.getId().toString();
        this.customField = entity.getCustomField();
    }
}