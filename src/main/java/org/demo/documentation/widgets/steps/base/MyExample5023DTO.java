package org.demo.documentation.widgets.steps.base;

import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.Getter;
import org.cxbox.api.data.dto.DataResponseDTO;
import org.cxbox.core.util.filter.SearchParameter;

@Getter
@Setter
@NoArgsConstructor
public class MyExample5023DTO extends DataResponseDTO {

    @SearchParameter(name = "customField")
    private String customField;

    public MyExample5023DTO(MyEntity5023 entity) {
        this.id = entity.getId().toString();
        this.customField = entity.getCustomField();
    }
}
