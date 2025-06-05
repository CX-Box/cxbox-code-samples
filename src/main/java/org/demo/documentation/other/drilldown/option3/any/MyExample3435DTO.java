package org.demo.documentation.other.drilldown.option3.any;

import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.Getter;
import org.cxbox.api.data.dto.DataResponseDTO;

@Getter
@Setter
@NoArgsConstructor
public class MyExample3435DTO extends DataResponseDTO {
    private String customField;

    public MyExample3435DTO(MyEntity3435OutServiceDTO entity) {
        this.id = entity.getId().toString();

        this.customField = entity.getCustomField();
    }
}