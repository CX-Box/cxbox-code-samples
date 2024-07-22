package org.demo.documentation.widgets.list.colortitle.forfields;

import org.cxbox.api.data.dto.DataResponseDTO;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class MyEntity3050MultiMultiMultivalueDTO extends DataResponseDTO {

    private String customField;

    public MyEntity3050MultiMultiMultivalueDTO(org.demo.documentation.widgets.list.colortitle.forfields.MyEntity3050MultiMulti entity) {
        this.id = entity.getId().toString();
        this.customField = entity.getCustomField();
    }

}
