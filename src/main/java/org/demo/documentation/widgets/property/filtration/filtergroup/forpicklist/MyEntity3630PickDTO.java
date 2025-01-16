package org.demo.documentation.widgets.property.filtration.filtergroup.forpicklist;

import org.cxbox.api.data.dto.DataResponseDTO;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class MyEntity3630PickDTO extends DataResponseDTO {

    private String customField;

    public MyEntity3630PickDTO(MyEntity3630 entity) {
        this.id = entity.getId().toString();
        this.customField = entity.getCustomField();
    }

}
