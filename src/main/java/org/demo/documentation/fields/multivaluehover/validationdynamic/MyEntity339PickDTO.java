package org.demo.documentation.fields.multivaluehover.validationdynamic;

import org.cxbox.api.data.dto.DataResponseDTO;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class MyEntity339PickDTO extends DataResponseDTO {

    private String customField;

    public MyEntity339PickDTO(MyEntity339 entity) {
        this.id = entity.getId().toString();
        this.customField = entity.getCustomField();
    }

}
