package org.demo.documentation.fields.suggestion.validationruntimeex.forfield;

import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.Getter;
import org.cxbox.api.data.dto.DataResponseDTO;

@Getter
@Setter
@NoArgsConstructor
public class MyExample3120DTO extends DataResponseDTO {

    private String customField;

    public MyExample3120DTO(MyEntity3120 entity) {
        this.id = entity.getId().toString();
        this.customField = entity.getCustomField();
    }
}