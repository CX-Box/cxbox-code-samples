package org.demo.documentation.fields.suggestion.ro.forfield;

import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.Getter;
import org.cxbox.api.data.dto.DataResponseDTO;

@Getter
@Setter
@NoArgsConstructor
public class MyExample3099DTO extends DataResponseDTO {

    private String customField;

    public MyExample3099DTO(MyEntity3099 entity) {
        this.id = entity.getId().toString();
        this.customField = entity.getCustomField();
    }
}