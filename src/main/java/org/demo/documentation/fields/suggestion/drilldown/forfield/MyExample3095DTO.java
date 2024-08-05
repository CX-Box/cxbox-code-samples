package org.demo.documentation.fields.suggestion.drilldown.forfield;

import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.Getter;
import org.cxbox.api.data.dto.DataResponseDTO;

@Getter
@Setter
@NoArgsConstructor
public class MyExample3095DTO extends DataResponseDTO {

    private String customField;
    private String customFieldDate;

    public MyExample3095DTO(MyEntity3095 entity) {
        this.id = entity.getId().toString();
        this.customField = entity.getCustomField();
        this.customFieldDate = entity.getCustomFieldDate();
    }
}