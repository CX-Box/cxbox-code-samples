package org.demo.documentation.widgets.statsblock.color.data;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.api.data.dto.DataResponseDTO;

@Getter
@Setter
@NoArgsConstructor
public class MyExample4204DTO extends DataResponseDTO {

    private String customField;
    private Integer customFieldNum;
    public MyExample4204DTO(MyEntity4204 entity) {
        this.id = entity.getId().toString();
        this.customField = entity.getCustomField();
        this.customFieldNum = entity.getCustomFieldNum();
    }
}