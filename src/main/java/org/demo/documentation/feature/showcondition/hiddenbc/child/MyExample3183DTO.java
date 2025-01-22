package org.demo.documentation.feature.showcondition.hiddenbc.child;

import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.Getter;
import org.cxbox.api.data.dto.DataResponseDTO;
import org.cxbox.core.util.filter.SearchParameter;
import org.cxbox.core.util.filter.provider.impl.StringValueProvider;

@Getter
@Setter
@NoArgsConstructor
public class MyExample3183DTO extends DataResponseDTO {

    @SearchParameter(name = "customField")
    private String customField;

    public MyExample3183DTO(MyEntity3183 entity) {
        this.id = entity.getId().toString();
        this.customField = entity.getCustomField();
    }
}