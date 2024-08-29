package org.demo.documentation.other.savewithparent.example2.child;

import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.Getter;
import org.cxbox.api.data.dto.DataResponseDTO;

@Getter
@Setter
@NoArgsConstructor
public class MyExample3130DTO extends DataResponseDTO {

    private String customField;

    public MyExample3130DTO(MyEntity3130 entity) {
        this.id = entity.getId().toString();
        this.customField = entity.getCustomField();
    }
}