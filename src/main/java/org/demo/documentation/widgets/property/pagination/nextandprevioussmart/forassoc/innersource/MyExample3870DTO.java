package org.demo.documentation.widgets.property.pagination.nextandprevioussmart.forassoc.innersource;

import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.Getter;
import org.cxbox.api.data.dto.DataResponseDTO;
import org.cxbox.core.util.filter.SearchParameter;

@Getter
@Setter
@NoArgsConstructor
public class MyExample3870DTO extends DataResponseDTO {

    @SearchParameter(name = "customField")
    private String customField;

    public MyExample3870DTO(MyEntity3870 entity) {
        this.id = entity.getId().toString();
        this.customField = entity.getCustomField();
    }
}