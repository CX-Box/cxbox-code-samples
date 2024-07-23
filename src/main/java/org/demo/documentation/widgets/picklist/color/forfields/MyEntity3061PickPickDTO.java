package org.demo.documentation.widgets.picklist.color.forfields;

import org.cxbox.api.data.dto.DataResponseDTO;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class MyEntity3061PickPickDTO extends DataResponseDTO {

    private String customField;

    public MyEntity3061PickPickDTO(MyEntity3061Pick entity) {
        this.id = entity.getId().toString();
        this.customField = entity.getCustomField();
    }

}
