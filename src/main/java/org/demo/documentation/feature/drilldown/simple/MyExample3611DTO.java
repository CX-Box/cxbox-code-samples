package org.demo.documentation.feature.drilldown.simple;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.api.data.dto.DataResponseDTO;
import org.cxbox.core.util.filter.SearchParameter;


@Getter
@Setter
@NoArgsConstructor
public class MyExample3611DTO extends DataResponseDTO {

    private String customField;
    @SearchParameter(name = "customFieldDrillDowm")
    private String customFieldDrillDowm;

    public MyExample3611DTO(MyEntity3611 entity) {
        this.id = entity.getId().toString();
        this.customField = entity.getCustomField();
        this.customFieldDrillDowm = entity.getCustomFieldDrillDowm();
    }
}