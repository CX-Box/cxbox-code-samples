package org.demo.documentation.widgets.picklist.title.withouttitle;

import org.cxbox.api.data.dto.DataResponseDTO;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class MyEntity3069PickPickDTO extends DataResponseDTO {

    private String customFieldPick;

    public MyEntity3069PickPickDTO(MyEntity3069Pick entity) {
        this.id = entity.getId().toString();
        this.customFieldPick = entity.getCustomFieldPick();
    }

}
