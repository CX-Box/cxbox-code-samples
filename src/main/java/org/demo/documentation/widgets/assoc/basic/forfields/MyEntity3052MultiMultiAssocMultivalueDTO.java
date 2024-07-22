package org.demo.documentation.widgets.assoc.basic.forfields;

import org.cxbox.api.data.dto.DataResponseDTO;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class MyEntity3052MultiMultiAssocMultivalueDTO extends DataResponseDTO {

    private String customField;

    public MyEntity3052MultiMultiAssocMultivalueDTO(org.demo.documentation.widgets.assoc.basic.forfields.MyEntity3052MultiMultiAssoc entity) {
        this.id = entity.getId().toString();
        this.customField = entity.getCustomField();
    }

}
