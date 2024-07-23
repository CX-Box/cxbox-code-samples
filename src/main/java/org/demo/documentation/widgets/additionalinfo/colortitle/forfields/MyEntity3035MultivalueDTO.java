package org.demo.documentation.widgets.additionalinfo.colortitle.forfields;

import org.cxbox.api.data.dto.DataResponseDTO;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class MyEntity3035MultivalueDTO extends DataResponseDTO {

    private String customField;

    public MyEntity3035MultivalueDTO(org.demo.documentation.widgets.additionalinfo.colortitle.forfields.MyEntity3035 entity) {
        this.id = entity.getId().toString();
        this.customField = entity.getCustomField();
    }

}
