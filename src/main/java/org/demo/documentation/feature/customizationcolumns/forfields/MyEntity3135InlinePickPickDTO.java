package org.demo.documentation.feature.customizationcolumns.forfields;

import org.cxbox.api.data.dto.DataResponseDTO;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class MyEntity3135InlinePickPickDTO extends DataResponseDTO {

    private String customField;

    public MyEntity3135InlinePickPickDTO(MyEntity3135InlinePick entity) {
        this.id = entity.getId().toString();
        this.customField = entity.getCustomField();
    }

}
