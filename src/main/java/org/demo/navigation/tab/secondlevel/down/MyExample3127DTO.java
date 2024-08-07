package org.demo.navigation.tab.secondlevel.down;

import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.Getter;
import org.cxbox.api.data.dto.DataResponseDTO;

@Getter
@Setter
@NoArgsConstructor
public class MyExample3127DTO extends DataResponseDTO {

    private String customField;

    public MyExample3127DTO(MyEntity3127 entity) {
        this.id = entity.getId().toString();
        this.customField = entity.getCustomField();
    }
}