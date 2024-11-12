package org.demo.documentation.widgets.list.customizationcolumns.forfields;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.api.data.dto.DataResponseDTO;

@Getter
@Setter
@NoArgsConstructor
public class MultivalueDTO extends DataResponseDTO {

    private String customField;

    public MultivalueDTO(MyEntity3135MultiHover entity) {
        this.id = entity.getId().toString();
        this.customField = entity.getCustomField();
    }

}
