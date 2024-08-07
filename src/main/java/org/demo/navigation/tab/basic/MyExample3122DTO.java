package org.demo.navigation.tab.basic;

import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.Getter;
import org.cxbox.api.data.dto.DataResponseDTO;

@Getter
@Setter
@NoArgsConstructor
public class MyExample3122DTO extends DataResponseDTO {

    private String customField;

    public MyExample3122DTO(MyEntity3122 entity) {
        this.id = entity.getId().toString();
        this.customField = entity.getCustomField();
    }
}