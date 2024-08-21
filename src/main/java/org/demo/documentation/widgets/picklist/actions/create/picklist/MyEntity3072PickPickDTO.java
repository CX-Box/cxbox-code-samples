package org.demo.documentation.widgets.picklist.actions.create.picklist;

import org.cxbox.api.data.dto.DataResponseDTO;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class MyEntity3072PickPickDTO extends DataResponseDTO {

    private String customFieldPick;

    public MyEntity3072PickPickDTO(MyEntity3072Pick entity) {
        this.id = entity.getId().toString();
        this.customFieldPick = entity.getCustomFieldPick();
    }

}
