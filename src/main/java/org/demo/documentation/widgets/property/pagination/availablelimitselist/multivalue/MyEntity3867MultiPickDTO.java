package org.demo.documentation.widgets.property.pagination.availablelimitselist.multivalue;

import org.cxbox.api.data.dto.DataResponseDTO;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class MyEntity3867MultiPickDTO extends DataResponseDTO {

    private String customField;

    public MyEntity3867MultiPickDTO(MyEntity3867Multi entity) {
        this.id = entity.getId().toString();
        this.customField = entity.getCustomField();
    }

}
