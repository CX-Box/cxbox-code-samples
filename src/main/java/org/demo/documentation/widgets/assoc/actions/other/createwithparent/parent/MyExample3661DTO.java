package org.demo.documentation.widgets.assoc.actions.other.createwithparent.parent;

import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.Getter;
import org.cxbox.api.data.dto.DataResponseDTO;

@Getter
@Setter
@NoArgsConstructor
public class MyExample3661DTO extends DataResponseDTO {

    private String customField;

    public MyExample3661DTO(MyEntity3661 entity) {
        this.id = entity.getId().toString();
        this.customField = entity.getCustomField();
    }
}