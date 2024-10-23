package org.demo.documentation.widgets.form.base.allfields.forfields;

import org.cxbox.api.data.dto.DataResponseDTO;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class MyEntity3010PickPick0DTO extends DataResponseDTO {

    private String customField;

    public MyEntity3010PickPick0DTO(MyEntity3010Pick entity) {
        this.id = entity.getId().toString();
        this.customField = entity.getCustomField();
    }

}
