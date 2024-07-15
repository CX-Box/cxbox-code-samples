package org.demo.documentation.widgets.list.base.forfields;

import org.cxbox.api.data.dto.DataResponseDTO;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class MyEntity3002MultivalueDTO extends DataResponseDTO {

    private String customField;

    public MyEntity3002MultivalueDTO(MyEntity3002Multi entity) {
        this.id = entity.getId().toString();
        this.customField = entity.getCustomField();
    }

}
