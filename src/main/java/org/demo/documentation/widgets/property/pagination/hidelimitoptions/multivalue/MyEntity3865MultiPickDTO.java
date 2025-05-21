package org.demo.documentation.widgets.property.pagination.hidelimitoptions.multivalue;

import org.cxbox.api.data.dto.DataResponseDTO;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class MyEntity3865MultiPickDTO extends DataResponseDTO {

    private String customField;

    public MyEntity3865MultiPickDTO(org.demo.documentation.widgets.property.pagination.hidelimitoptions.multivalue.MyEntity3865Multi entity) {
        this.id = entity.getId().toString();
        this.customField = entity.getCustomField();
    }

}
