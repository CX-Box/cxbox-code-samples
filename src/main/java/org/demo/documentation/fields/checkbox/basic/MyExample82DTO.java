package org.demo.documentation.fields.checkbox.basic;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.api.data.dto.DataResponseDTO;
import org.cxbox.core.util.filter.SearchParameter;
import org.cxbox.core.util.filter.provider.impl.BooleanValueProvider;

@Getter
@Setter
@NoArgsConstructor
public class MyExample82DTO extends DataResponseDTO {

    @SearchParameter(name = "customField", provider = BooleanValueProvider.class)
    private Boolean customField;

    @SearchParameter(name = "customField4", provider = BooleanValueProvider.class)
    private Boolean customField4;

    public MyExample82DTO(MyEntity82 entity) {
        this.id = entity.getId().toString();
        this.customField = entity.getCustomField();
        this.customField4 = entity.getCustomField4();
    }

}