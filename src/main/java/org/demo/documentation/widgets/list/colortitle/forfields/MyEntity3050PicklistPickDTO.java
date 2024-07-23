package org.demo.documentation.widgets.list.colortitle.forfields;

import org.cxbox.api.data.dto.DataResponseDTO;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class MyEntity3050PicklistPickDTO extends DataResponseDTO {

    private String customField;

    public MyEntity3050PicklistPickDTO(MyEntity3050Picklist entity) {
        this.id = entity.getId().toString();
        this.customField = entity.getCustomField();
    }

}
