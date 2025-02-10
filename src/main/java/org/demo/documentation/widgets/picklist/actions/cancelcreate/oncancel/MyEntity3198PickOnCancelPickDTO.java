package org.demo.documentation.widgets.picklist.actions.cancelcreate.oncancel;

import org.cxbox.api.data.dto.DataResponseDTO;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class MyEntity3198PickOnCancelPickDTO extends DataResponseDTO {

    private String customField;

    public MyEntity3198PickOnCancelPickDTO(MyEntity3198PickOnCancel entity) {
        this.id = entity.getId().toString();
        this.customField = entity.getCustomField();
    }

}
