package org.demo.documentation.feature.drilldown.goingforwardafterdrilldown;

import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.Getter;
import org.cxbox.api.data.dto.DataResponseDTO;

@Getter
@Setter
@NoArgsConstructor
public class MyExample3621DTO extends DataResponseDTO {

    private String customField;

    public MyExample3621DTO(MyEntity3621 entity) {
        this.id = entity.getId().toString();
        this.customField = entity.getCustomField();
    }
}