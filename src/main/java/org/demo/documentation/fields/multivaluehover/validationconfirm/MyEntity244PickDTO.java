package org.demo.documentation.fields.multivaluehover.validationconfirm;

import org.cxbox.api.data.dto.DataResponseDTO;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class MyEntity244PickDTO extends DataResponseDTO {

    private String customField;

    public MyEntity244PickDTO(MyEntity244 entity) {
        this.id = entity.getId().toString();
        this.customField = entity.getCustomField();
    }

}
