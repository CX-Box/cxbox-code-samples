package org.demo.documentation.widgets.property.showcondition.hiddenbc.child;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.api.data.dto.DataResponseDTO;
import org.cxbox.core.util.filter.SearchParameter;

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