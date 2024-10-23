package org.demo.documentation.widgets.info.base.allfields.forfields;

import org.cxbox.api.data.dto.DataResponseDTO;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class MyEntity4222MultiMultivalueDTO extends DataResponseDTO {

    private String customField;

    public MyEntity4222MultiMultivalueDTO(MyEntity4222Multi entity) {
        this.id = entity.getId().toString();
        this.customField = entity.getCustomField();
    }

}
