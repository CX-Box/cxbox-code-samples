package org.demo.documentation.other.drilldown.option;

import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.Getter;
import org.cxbox.api.data.dto.DataResponseDTO;
import org.cxbox.core.util.filter.SearchParameter;

@Getter
@Setter
@NoArgsConstructor
public class MyExample3421DTO extends DataResponseDTO {

    @SearchParameter(name = "customField")
    private String customField;

    public MyExample3421DTO(MyEntity3421 entity) {
        this.id = entity.getId().toString();
        this.customField = entity.getCustomField();
    }
}