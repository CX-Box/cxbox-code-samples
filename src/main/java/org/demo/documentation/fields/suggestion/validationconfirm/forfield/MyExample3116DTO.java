package org.demo.documentation.fields.suggestion.validationconfirm.forfield;

import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.Getter;
import org.cxbox.api.data.dto.DataResponseDTO;

@Getter
@Setter
@NoArgsConstructor
public class MyExample3116DTO extends DataResponseDTO {

    private String customField;

    public MyExample3116DTO(MyEntity3116 entity) {
        this.id = entity.getId().toString();
        this.customField = entity.getCustomField();
    }
}