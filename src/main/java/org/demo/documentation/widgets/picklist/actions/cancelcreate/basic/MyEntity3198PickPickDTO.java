package org.demo.documentation.widgets.picklist.actions.cancelcreate.basic;

import org.cxbox.api.data.dto.DataResponseDTO;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class MyEntity3198PickPickDTO extends DataResponseDTO {

    private String customField;

    public MyEntity3198PickPickDTO(MyEntity3198Pick entity) {
        this.id = entity.getId().toString();
        this.customField = entity.getCustomField();
    }

}
