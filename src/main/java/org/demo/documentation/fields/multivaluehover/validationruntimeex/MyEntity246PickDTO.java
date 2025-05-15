package org.demo.documentation.fields.multivaluehover.validationruntimeex;

import org.cxbox.api.data.dto.DataResponseDTO;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class MyEntity246PickDTO extends DataResponseDTO {

    private String customField;

    public MyEntity246PickDTO(MyEntity246 entity) {
        this.id = entity.getId().toString();
        this.customField = entity.getCustomField();
    }

}
