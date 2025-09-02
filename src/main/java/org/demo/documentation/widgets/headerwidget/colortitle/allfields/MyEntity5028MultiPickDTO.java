package org.demo.documentation.widgets.headerwidget.colortitle.allfields;

import org.cxbox.api.data.dto.DataResponseDTO;
import org.cxbox.core.util.filter.SearchParameter;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class MyEntity5028MultiPickDTO extends DataResponseDTO {

    @SearchParameter(name = "customField")
    private String customField;

    public MyEntity5028MultiPickDTO(MyEntity5028Multi entity) {
        this.id = entity.getId().toString();
        this.customField = entity.getCustomField();
    }

}
