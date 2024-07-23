package org.demo.documentation.widgets.picklist.color.forfields;

import org.cxbox.api.data.dto.DataResponseDTO;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class MyEntity3061MultiMultivalueDTO extends DataResponseDTO {

    private String customField;

    public MyEntity3061MultiMultivalueDTO(org.demo.documentation.widgets.picklist.color.forfields.MyEntity3061Multi entity) {
        this.id = entity.getId().toString();
        this.customField = entity.getCustomField();
    }

}
