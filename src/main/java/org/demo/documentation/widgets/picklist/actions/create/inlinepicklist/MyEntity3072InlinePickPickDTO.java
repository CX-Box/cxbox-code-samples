package org.demo.documentation.widgets.picklist.actions.create.inlinepicklist;

import org.cxbox.api.data.dto.DataResponseDTO;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class MyEntity3072InlinePickPickDTO extends DataResponseDTO {

    private String customFieldPick;

    public MyEntity3072InlinePickPickDTO(MyEntity3072InlinePick entity) {
        this.id = entity.getId().toString();
        this.customFieldPick = entity.getCustomFieldPick();
    }

}
