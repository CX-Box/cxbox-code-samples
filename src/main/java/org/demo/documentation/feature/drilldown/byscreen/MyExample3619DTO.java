package org.demo.documentation.feature.drilldown.byscreen;

import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.Getter;
import org.cxbox.api.data.dto.DataResponseDTO;

@Getter
@Setter
@NoArgsConstructor
public class MyExample3619DTO extends DataResponseDTO {

    private String customField;

    public MyExample3619DTO(MyEntity3619 entity) {
        this.id = entity.getId().toString();
        this.customField = entity.getCustomField();
    }
}