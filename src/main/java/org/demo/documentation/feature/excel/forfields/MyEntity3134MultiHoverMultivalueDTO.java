package org.demo.documentation.feature.excel.forfields;

import org.cxbox.api.data.dto.DataResponseDTO;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class MyEntity3134MultiHoverMultivalueDTO extends DataResponseDTO {

    private String customField;

    public MyEntity3134MultiHoverMultivalueDTO(org.demo.documentation.feature.excel.forfields.MyEntity3134MultiHover entity) {
        this.id = entity.getId().toString();
        this.customField = entity.getCustomField();
    }

}
