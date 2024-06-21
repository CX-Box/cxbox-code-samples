package org.demo.documentation.widgets.additionalinfo.base.forfields;

import org.cxbox.api.data.dto.DataResponseDTO;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class MyEntity3600MultiMultivalueDTO extends DataResponseDTO {

    private String customField;

    public MyEntity3600MultiMultivalueDTO(org.demo.documentation.widgets.additionalinfo.base.forfields.MyEntity3600Multi entity) {
        this.id = entity.getId().toString();
        this.customField = entity.getCustomField();
    }

}
