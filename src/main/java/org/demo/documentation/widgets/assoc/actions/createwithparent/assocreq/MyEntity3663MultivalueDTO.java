package org.demo.documentation.widgets.assoc.actions.createwithparent.assocreq;

import org.cxbox.api.data.dto.DataResponseDTO;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class MyEntity3663MultivalueDTO extends DataResponseDTO {

    private String customField;

    public MyEntity3663MultivalueDTO(MyEntity3663 entity) {
        this.id = entity.getId().toString();
        this.customField = entity.getCustomField();
    }

}
