package org.demo.documentation.widgets.list.customizationcolumns.forfields;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.api.data.dto.DataResponseDTO;

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
