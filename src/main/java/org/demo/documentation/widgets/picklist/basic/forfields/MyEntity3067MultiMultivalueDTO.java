package org.demo.documentation.widgets.picklist.basic.forfields;

import org.cxbox.api.data.dto.DataResponseDTO;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class MyEntity3067MultiMultivalueDTO extends DataResponseDTO {

    private String customField;

    public MyEntity3067MultiMultivalueDTO(org.demo.documentation.widgets.picklist.basic.forfields.MyEntity3067Multi entity) {
        this.id = entity.getId().toString();
        this.customField = entity.getCustomField();
    }

}
