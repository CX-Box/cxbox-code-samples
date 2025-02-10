package org.demo.documentation.widgets.picklist.actions.cancelcreate.postaction;

import org.cxbox.api.data.dto.DataResponseDTO;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class MyEntity3198PickPostActionPickDTO extends DataResponseDTO {

    private String customField;

    public MyEntity3198PickPostActionPickDTO(MyEntity3198PickPostAction entity) {
        this.id = entity.getId().toString();
        this.customField = entity.getCustomField();
    }

}
