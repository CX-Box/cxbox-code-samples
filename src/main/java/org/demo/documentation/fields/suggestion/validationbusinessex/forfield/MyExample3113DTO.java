package org.demo.documentation.fields.suggestion.validationbusinessex.forfield;

import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.Getter;
import org.cxbox.api.data.dto.DataResponseDTO;

@Getter
@Setter
@NoArgsConstructor
public class MyExample3113DTO extends DataResponseDTO {

    private String customField;

    public MyExample3113DTO(MyEntity3113 entity) {
        this.id = entity.getId().toString();
        this.customField = entity.getCustomField();
    }
}