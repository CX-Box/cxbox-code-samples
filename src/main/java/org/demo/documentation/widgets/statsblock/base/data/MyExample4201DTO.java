package org.demo.documentation.widgets.statsblock.base.data;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.api.data.dto.DataResponseDTO;

@Getter
@Setter
@NoArgsConstructor
public class MyExample4201DTO extends DataResponseDTO {
    private String customField;
    private Long customFieldNum;
    public MyExample4201DTO(MyEntity4201 entity) {
        this.id = entity.getId().toString();
        this.customField = entity.getCustomField();
        this.customFieldNum = entity.getCustomFieldNum();
    }
}