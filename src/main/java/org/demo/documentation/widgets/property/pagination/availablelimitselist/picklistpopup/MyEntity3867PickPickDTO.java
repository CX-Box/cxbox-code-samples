package org.demo.documentation.widgets.property.pagination.availablelimitselist.picklistpopup;

import org.cxbox.api.data.dto.DataResponseDTO;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class MyEntity3867PickPickDTO extends DataResponseDTO {

    private String customField;

    public MyEntity3867PickPickDTO(MyEntity3867Pick entity) {
        this.id = entity.getId().toString();
        this.customField = entity.getCustomField();
    }

}
