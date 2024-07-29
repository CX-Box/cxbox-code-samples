package org.demo.documentation.widgets.picklist.basic;

import org.cxbox.api.data.dto.DataResponseDTO;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class MyEntity3067PickPickDTO extends DataResponseDTO {

    private String customFieldPick;

    public MyEntity3067PickPickDTO(MyEntity3067Pick entity) {
        this.id = entity.getId().toString();
        this.customFieldPick = entity.getCustomFieldPick();
    }

}
