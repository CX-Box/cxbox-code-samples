package org.demo.documentation.widgets.assoc.colortitle.allfields.forfields;

import org.cxbox.api.data.dto.DataResponseDTO;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class MyEntity3052MultiAssocMultivalueDTO extends DataResponseDTO {

    private String customField;

    public MyEntity3052MultiAssocMultivalueDTO(MyEntity3052MultiAssoc entity) {
        this.id = entity.getId().toString();
        this.customField = entity.getCustomField();
    }

}
