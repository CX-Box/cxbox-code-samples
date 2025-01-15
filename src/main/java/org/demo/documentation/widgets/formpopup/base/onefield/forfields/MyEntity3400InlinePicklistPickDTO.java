package org.demo.documentation.widgets.formpopup.base.onefield.forfields;

import org.cxbox.api.data.dto.DataResponseDTO;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class MyEntity3400InlinePicklistPickDTO extends DataResponseDTO {

    private String customField;

    public MyEntity3400InlinePicklistPickDTO(MyEntity3400InlinePicklist entity) {
        this.id = entity.getId().toString();
        this.customField = entity.getCustomField();
    }

}
