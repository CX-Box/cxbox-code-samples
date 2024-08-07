package org.demo.documentation.feature.customizationcolumns.forfields;

import org.cxbox.api.data.dto.DataResponseDTO;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class MyEntity3135PickPickDTO extends DataResponseDTO {

    private String customField;

    public MyEntity3135PickPickDTO(MyEntity3135Pick entity) {
        this.id = entity.getId().toString();
        this.customField = entity.getCustomField();
    }

}
