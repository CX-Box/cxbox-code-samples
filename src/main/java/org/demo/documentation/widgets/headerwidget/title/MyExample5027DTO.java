package org.demo.documentation.widgets.headerwidget.title;

import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.Getter;
import org.cxbox.api.data.dto.DataResponseDTO;
import org.cxbox.core.util.filter.SearchParameter;

@Getter
@Setter
@NoArgsConstructor
public class MyExample5027DTO extends DataResponseDTO {

    @SearchParameter(name = "customField")
    private String customField;

    public MyExample5027DTO(MyEntity5027 entity) {
        this.id = entity.getId().toString();
        this.customField = entity.getCustomField();
    }
}
