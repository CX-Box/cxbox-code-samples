package org.demo.documentation.feature.customizationcolumns.forfields;

import org.cxbox.api.data.dto.DataResponseDTO;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
