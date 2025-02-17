package org.demo.documentation.widgets.formpopup.widgetsize;

import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.Getter;
import org.cxbox.api.data.dto.DataResponseDTO;
import org.cxbox.core.util.filter.SearchParameter;


@Getter
@Setter
@NoArgsConstructor
public class MyExample3402DTO extends DataResponseDTO {

    @SearchParameter(name = "customField")
    private String customField;

    public MyExample3402DTO(MyEntity3402 entity) {
        this.id = entity.getId().toString();
        this.customField = entity.getCustomField();
    }
}