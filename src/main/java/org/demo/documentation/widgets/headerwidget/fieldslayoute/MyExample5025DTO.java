package org.demo.documentation.widgets.headerwidget.fieldslayoute;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.Getter;
import org.cxbox.api.data.dto.DataResponseDTO;
import org.cxbox.core.util.filter.SearchParameter;

@Getter
@Setter
@NoArgsConstructor
public class MyExample5025DTO extends DataResponseDTO {

    @SearchParameter(name = "customField")
    private String customField;

    public MyExample5025DTO(MyEntity5025 entity) {
        this.id = entity.getId().toString();
        this.customField = entity.getCustomField();
    }
}
