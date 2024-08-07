package org.demo.navigation.tab.thirdlevel;

import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.Getter;
import org.cxbox.api.data.dto.DataResponseDTO;

@Getter
@Setter
@NoArgsConstructor
public class MyExample3125DTO extends DataResponseDTO {

    private String customField;

    public MyExample3125DTO(MyEntity3125 entity) {
        this.id = entity.getId().toString();
        this.customField = entity.getCustomField();
    }
}