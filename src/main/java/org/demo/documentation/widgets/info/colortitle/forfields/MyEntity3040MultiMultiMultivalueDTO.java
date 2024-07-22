package org.demo.documentation.widgets.info.colortitle.forfields;

import org.cxbox.api.data.dto.DataResponseDTO;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class MyEntity3040MultiMultiMultivalueDTO extends DataResponseDTO {

    private String customField;

    public MyEntity3040MultiMultiMultivalueDTO(org.demo.documentation.widgets.info.colortitle.forfields.MyEntity3040MultiMulti entity) {
        this.id = entity.getId().toString();
        this.customField = entity.getCustomField();
    }

}
