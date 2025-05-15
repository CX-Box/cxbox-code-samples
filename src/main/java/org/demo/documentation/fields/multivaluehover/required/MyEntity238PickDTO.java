package org.demo.documentation.fields.multivaluehover.required;

import org.cxbox.api.data.dto.DataResponseDTO;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class MyEntity238PickDTO extends DataResponseDTO {

    private String customField;

    public MyEntity238PickDTO(MyEntity238 entity) {
        this.id = entity.getId().toString();
        this.customField = entity.getCustomField();
    }

}
