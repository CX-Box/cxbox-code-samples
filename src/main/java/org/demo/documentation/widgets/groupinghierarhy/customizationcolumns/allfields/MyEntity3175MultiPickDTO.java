package org.demo.documentation.widgets.groupinghierarhy.customizationcolumns.allfields;

import org.cxbox.api.data.dto.DataResponseDTO;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class MyEntity3175MultiPickDTO extends DataResponseDTO {

    private String customField;

    public MyEntity3175MultiPickDTO(org.demo.documentation.widgets.groupinghierarhy.customizationcolumns.allfields.MyEntity3175Multi entity) {
        this.id = entity.getId().toString();
        this.customField = entity.getCustomField();
    }

}
