package org.demo.documentation.widgets.assoc.actions.customsave;

import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.Getter;
import org.cxbox.api.data.dto.DataResponseDTO;

@Getter
@Setter
@NoArgsConstructor
public class MyExample3063DTO extends DataResponseDTO {

    private String customField;

    public MyExample3063DTO(MyEntity3063 entity) {
        this.id = entity.getId().toString();
        this.customField = entity.getCustomField();
    }
}