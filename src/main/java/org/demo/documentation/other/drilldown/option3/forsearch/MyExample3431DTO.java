package org.demo.documentation.other.drilldown.option3.forsearch;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.api.data.dto.DataResponseDTO;
import org.cxbox.core.util.filter.SearchParameter;
import org.cxbox.core.util.filter.provider.impl.StringValueProvider;

@Getter
@Setter
@NoArgsConstructor
public class MyExample3431DTO extends DataResponseDTO {

    @SearchParameter(name = "customField")
    private String customField;

    public MyExample3431DTO(MyEntity3431 entity) {
        this.id = String.valueOf(entity.getId());
        this.customField = entity.getCustomField();
    }
}