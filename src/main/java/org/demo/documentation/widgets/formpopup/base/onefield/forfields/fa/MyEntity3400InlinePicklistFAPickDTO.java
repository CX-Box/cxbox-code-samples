package org.demo.documentation.widgets.formpopup.base.onefield.forfields.fa;

import org.cxbox.api.data.dto.DataResponseDTO;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class MyEntity3400InlinePicklistFAPickDTO extends DataResponseDTO {

    private String customField;

    public MyEntity3400InlinePicklistFAPickDTO(MyEntity3400InlinePicklistFA entity) {
        this.id = entity.getId().toString();
        this.customField = entity.getCustomField();
    }

}
