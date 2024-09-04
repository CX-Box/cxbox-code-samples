package org.demo.navigation.tab.typeother.fourthlevel;

import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.Getter;
import org.cxbox.api.data.dto.DataResponseDTO;

@Getter
@Setter
@NoArgsConstructor
public class MyExample3126DTO extends DataResponseDTO {

    private String customField;

    public MyExample3126DTO(MyEntity3126 entity) {
        this.id = entity.getId().toString();
        this.customField = entity.getCustomField();
    }
}