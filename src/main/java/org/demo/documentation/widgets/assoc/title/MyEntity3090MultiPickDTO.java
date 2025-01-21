package org.demo.documentation.widgets.assoc.title;

import org.cxbox.api.data.dto.DataResponseDTO;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class MyEntity3090MultiPickDTO extends DataResponseDTO {

    private String customField;

    public MyEntity3090MultiPickDTO(MyEntity3090Multi entity) {
        this.id = entity.getId().toString();
        this.customField = entity.getCustomField();
    }

}
