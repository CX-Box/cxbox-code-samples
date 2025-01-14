package org.demo.documentation.widgets.additionallist.base.allfields.forfields;

import org.cxbox.api.data.dto.DataResponseDTO;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class MyEntity3191MultiPickDTO extends DataResponseDTO {

    private String customField;

    public MyEntity3191MultiPickDTO(MyEntity3191Multi entity) {
        this.id = entity.getId().toString();
        this.customField = entity.getCustomField();
    }

}
