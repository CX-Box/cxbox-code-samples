package org.demo.documentation.feature.drilldown.drilldownviewid;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.api.data.dto.DataResponseDTO;
import org.cxbox.core.util.filter.SearchParameter;


@Getter
@Setter
@NoArgsConstructor
public class MyExample3610DTO extends DataResponseDTO {

    private String customField;
    @SearchParameter(name = "customFieldDrillDown")
    private String customFieldDrillDown;

    public MyExample3610DTO(MyEntity3610 entity) {
        this.id = entity.getId().toString();
        this.customField = entity.getCustomField();
        this.customFieldDrillDown = entity.getCustomFieldDrillDown();
    }
}