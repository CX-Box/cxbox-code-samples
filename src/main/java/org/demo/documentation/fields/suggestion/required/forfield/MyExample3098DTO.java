package org.demo.documentation.fields.suggestion.required.forfield;

import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.Getter;
import org.cxbox.api.data.dto.DataResponseDTO;

@Getter
@Setter
@NoArgsConstructor
public class MyExample3098DTO extends DataResponseDTO {

    private String customField;

    public MyExample3098DTO(MyEntity3098 entity) {
        this.id = entity.getId().toString();
        this.customField = entity.getCustomField();
    }
}