package org.demo.documentation.widgets.additionallist.base.allfields.forfields;

import org.cxbox.api.data.dto.DataResponseDTO;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class MyEntity3191MultiHoverPickDTO extends DataResponseDTO {

    private String customField;

    public MyEntity3191MultiHoverPickDTO(MyEntity3191MultiHover entity) {
        this.id = entity.getId().toString();
        this.customField = entity.getCustomField();
    }

}
