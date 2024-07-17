package org.demo.documentation.feature.tab.secondlevel.top;

import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.Getter;
import org.cxbox.api.data.dto.DataResponseDTO;

@Getter
@Setter
@NoArgsConstructor
public class MyExample3124DTO extends DataResponseDTO {

    private String customField;

    public MyExample3124DTO(MyEntity3124 entity) {
        this.id = entity.getId().toString();
        this.customField = entity.getCustomField();
    }
}