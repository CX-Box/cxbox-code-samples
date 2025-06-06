package org.demo.documentation.widgets.property.pagination.nextandprevioussmart.forpicklist.innersource;

import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.Getter;
import org.cxbox.api.data.dto.DataResponseDTO;
import org.cxbox.core.util.filter.SearchParameter;


@Getter
@Setter
@NoArgsConstructor
public class MyExample3869DTO extends DataResponseDTO {

    @SearchParameter(name = "customField")
    private String customField;

    public MyExample3869DTO(MyEntity3869 entity) {
        this.id = entity.getId().toString();
        this.customField = entity.getCustomField();
    }
}