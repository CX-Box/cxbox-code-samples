package org.demo.documentation.fields.suggestion.color.colorconst.forfield;

import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.Getter;
import org.cxbox.api.data.dto.DataResponseDTO;

@Getter
@Setter
@NoArgsConstructor
public class MyExample3094DTO extends DataResponseDTO {

    private String customField;
    private String customFieldDate;

    public MyExample3094DTO(MyEntity3094 entity) {
        this.id = entity.getId().toString();
        this.customField = entity.getCustomField();
        this.customFieldDate = entity.getCustomFieldDate();
    }
}