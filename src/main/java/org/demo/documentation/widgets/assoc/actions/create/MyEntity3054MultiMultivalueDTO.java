package org.demo.documentation.widgets.assoc.actions.create;

import org.cxbox.api.data.dto.DataResponseDTO;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class MyEntity3054MultiMultivalueDTO extends DataResponseDTO {

    private String customField;

    public MyEntity3054MultiMultivalueDTO(MyEntity3054Multi entity) {
        this.id = entity.getId().toString();
        this.customField = entity.getCustomField();
    }

}
