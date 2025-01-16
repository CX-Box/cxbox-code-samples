package org.demo.documentation.widgets.property.filtration.filtergroupsave.forpicklist;

import org.cxbox.api.data.dto.DataResponseDTO;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class MyEntity3618PickPickDTO extends DataResponseDTO {

    private String customField;

    public MyEntity3618PickPickDTO(MyEntity3618Pick entity) {
        this.id = entity.getId().toString();
        this.customField = entity.getCustomField();
    }

}
