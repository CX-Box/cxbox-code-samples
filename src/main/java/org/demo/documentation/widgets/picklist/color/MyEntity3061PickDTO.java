package org.demo.documentation.widgets.picklist.color;

import org.cxbox.api.data.dto.DataResponseDTO;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class MyEntity3061PickDTO extends DataResponseDTO {

    private String customField;

    public MyEntity3061PickDTO(MyEntity3061 entity) {
        this.id = entity.getId().toString();
        this.customField = entity.getCustomField();
    }

}
