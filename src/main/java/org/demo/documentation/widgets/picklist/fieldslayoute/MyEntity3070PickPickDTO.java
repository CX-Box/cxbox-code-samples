package org.demo.documentation.widgets.picklist.fieldslayoute;

import org.cxbox.api.data.dto.DataResponseDTO;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class MyEntity3070PickPickDTO extends DataResponseDTO {

    private String customFieldPick;

    public MyEntity3070PickPickDTO(MyEntity3070Pick entity) {
        this.id = entity.getId().toString();
        this.customFieldPick = entity.getCustomFieldPick();
    }

}
