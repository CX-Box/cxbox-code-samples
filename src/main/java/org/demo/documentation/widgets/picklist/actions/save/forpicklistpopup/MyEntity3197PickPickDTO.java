package org.demo.documentation.widgets.picklist.actions.save.forpicklistpopup;

import org.cxbox.api.data.dto.DataResponseDTO;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class MyEntity3197PickPickDTO extends DataResponseDTO {

    private String customField;

    public MyEntity3197PickPickDTO(MyEntity3197Pick entity) {
        this.id = entity.getId().toString();
        this.customField = entity.getCustomField();
    }

}
