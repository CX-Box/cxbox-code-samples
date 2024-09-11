package org.demo.documentation.other.savewithparent.example3.relatedobject;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.api.data.dto.DataResponseDTO;

@Getter
@Setter
@NoArgsConstructor
public class MyExample3423DTO extends DataResponseDTO {

    private String customField;

    public MyExample3423DTO(MyEntity3423 entity) {
        this.id = entity.getId().toString();
        this.customField = entity.getCustomField();
    }
}