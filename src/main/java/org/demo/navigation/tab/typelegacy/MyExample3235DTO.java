package org.demo.navigation.tab.typelegacy;

import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.Getter;
import org.cxbox.api.data.dto.DataResponseDTO;

@Getter
@Setter
@NoArgsConstructor
public class MyExample3235DTO extends DataResponseDTO {

    private String customField;

    public MyExample3235DTO(MyEntity3235 entity) {
        this.id = entity.getId().toString();
        this.customField = entity.getCustomField();
    }
}