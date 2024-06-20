package org.demo.documentation.widgets.statsblock.showcondition.data;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.api.data.dto.DataResponseDTO;


@Getter
@Setter
@NoArgsConstructor
public class MyExample4229DTO extends DataResponseDTO {

    private String customField;

    public MyExample4229DTO(MyEntity4229 entity) {
        this.id = entity.getId().toString();
        this.customField = entity.getCustomField();
    }
}
