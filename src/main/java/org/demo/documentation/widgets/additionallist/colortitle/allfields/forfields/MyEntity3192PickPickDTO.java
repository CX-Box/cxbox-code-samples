package org.demo.documentation.widgets.additionallist.colortitle.allfields.forfields;

import org.cxbox.api.data.dto.DataResponseDTO;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class MyEntity3192PickPickDTO extends DataResponseDTO {

    private String customField;

    public MyEntity3192PickPickDTO(MyEntity3192Pick entity) {
        this.id = entity.getId().toString();
        this.customField = entity.getCustomField();
    }

}
