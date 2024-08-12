package org.demo.documentation.widgets.assoc.basic.forfield;

import org.cxbox.api.data.dto.DataResponseDTO;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class MyEntity3053MultiMultivalueDTO extends DataResponseDTO {

    private String customField;

    public MyEntity3053MultiMultivalueDTO(MyEntity3053Multi entity) {
        this.id = entity.getId().toString();
        this.customField = entity.getCustomField();
    }

}
