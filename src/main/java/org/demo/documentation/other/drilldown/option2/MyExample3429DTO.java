package org.demo.documentation.other.drilldown.option2;

import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.Getter;
import org.cxbox.api.data.dto.DataResponseDTO;
import org.cxbox.core.util.filter.SearchParameter;

@Getter
@Setter
@NoArgsConstructor
public class MyExample3429DTO extends DataResponseDTO {

    @SearchParameter(name = "customField")
    private String customField;

    public MyExample3429DTO(MyEntity3429 entity) {
        this.id = entity.getId().toString();
        this.customField = entity.getCustomField();
    }
}