package org.demo.documentation.widgets.picklist.color.forfields;

import org.cxbox.api.data.dto.DataResponseDTO;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class MyEntity3061PickPickPickDTO extends DataResponseDTO {

    private String customField;

    public MyEntity3061PickPickPickDTO(MyEntity3061PickPick entity) {
        this.id = entity.getId().toString();
        this.customField = entity.getCustomField();
    }

}
