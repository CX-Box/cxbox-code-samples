package org.demo.documentation.widgets.property.filtration.filtergroupsave.forassoc;

import org.cxbox.api.data.dto.DataResponseDTO;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class MyEntity3624PickDTO extends DataResponseDTO {

    private String customField;

    public MyEntity3624PickDTO(org.demo.documentation.widgets.property.filtration.filtergroupsave.forassoc.MyEntity3624 entity) {
        this.id = entity.getId().toString();
        this.customField = entity.getCustomField();
    }

}
