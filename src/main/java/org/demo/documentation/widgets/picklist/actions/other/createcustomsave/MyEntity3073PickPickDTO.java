package org.demo.documentation.widgets.picklist.actions.other.createcustomsave;

import org.cxbox.api.data.dto.DataResponseDTO;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class MyEntity3073PickPickDTO extends DataResponseDTO {

    private String customField;

    public MyEntity3073PickPickDTO(MyEntity3073Pick entity) {
        this.id = entity.getId().toString();
        this.customField = entity.getCustomField();
    }

}
