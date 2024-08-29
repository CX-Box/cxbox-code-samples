package org.demo.documentation.other.savewithparent.example2.parent;

import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.Getter;
import org.cxbox.api.data.dto.DataResponseDTO;

@Getter
@Setter
@NoArgsConstructor
public class MyExample3131DTO extends DataResponseDTO {

    private String customField;

    public MyExample3131DTO(MyEntity3131 entity) {
        this.id = entity.getId().toString();
        this.customField = entity.getCustomField();
    }
}