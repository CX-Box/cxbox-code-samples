package org.demo.documentation.widgets.info.base.forfields;

import org.cxbox.api.data.dto.DataResponseDTO;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class MyEntity4222Multi2MultivalueDTO extends DataResponseDTO {

    private String customField;

    public MyEntity4222Multi2MultivalueDTO(MyEntity4222Multi2 entity) {
        this.id = entity.getId().toString();
        this.customField = entity.getCustomField();
    }

}
