package org.demo.documentation.widgets.property.showcondition.hiddenbc.mainbc;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.api.data.dto.DataResponseDTO;
import org.cxbox.core.util.filter.SearchParameter;
import org.cxbox.core.util.filter.provider.impl.BooleanValueProvider;

@Getter
@Setter
@NoArgsConstructor
public class MyExample3184DTO extends DataResponseDTO {

    @SearchParameter(name = "customField")
    private String customField;
    @SearchParameter(name = "customFieldCheckbox", provider = BooleanValueProvider.class)
    private Boolean customFieldCheckbox;

    public MyExample3184DTO(MyEntity3184 entity) {
        this.id = entity.getId().toString();
        this.customField = entity.getCustomField();
        this.customFieldCheckbox = entity.getCustomFieldCheckbox();
    }
}