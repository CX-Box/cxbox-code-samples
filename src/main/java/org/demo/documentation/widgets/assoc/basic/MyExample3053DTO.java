package org.demo.documentation.widgets.assoc.basic;

import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.Getter;
import org.cxbox.api.data.dto.DataResponseDTO;

@Getter
@Setter
@NoArgsConstructor
public class MyExample3053DTO extends DataResponseDTO {

    private String customField;

    public MyExample3053DTO(MyEntity3053 entity) {
        this.id = entity.getId().toString();
        this.customField = entity.getCustomField();
    }
}