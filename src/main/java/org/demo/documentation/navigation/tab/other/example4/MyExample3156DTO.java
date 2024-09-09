package org.demo.documentation.navigation.tab.other.example4;

import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.Getter;
import org.cxbox.api.data.dto.DataResponseDTO;

@Getter
@Setter
@NoArgsConstructor
public class MyExample3156DTO extends DataResponseDTO {

    private String customField;

    public MyExample3156DTO(MyEntity3156 entity) {
        this.id = entity.getId().toString();
        this.customField = entity.getCustomField();
    }
}