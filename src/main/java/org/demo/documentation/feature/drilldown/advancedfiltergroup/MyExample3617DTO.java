package org.demo.documentation.feature.drilldown.advancedfiltergroup;

import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.Getter;
import org.cxbox.api.data.dto.DataResponseDTO;
import org.cxbox.core.util.filter.SearchParameter;
import org.cxbox.core.util.filter.provider.impl.DateValueProvider;
import org.cxbox.core.util.filter.provider.impl.StringValueProvider;

@Getter
@Setter
@NoArgsConstructor
public class MyExample3617DTO extends DataResponseDTO {
    @SearchParameter(name = "customField", provider = StringValueProvider.class)
    private String customField;
    @SearchParameter(name = "customFieldNew", provider = StringValueProvider.class)
    private String customFieldNew;
    @SearchParameter(name = "customFieldDrillDown", provider = StringValueProvider.class)
    private String customFieldDrillDown;

    public MyExample3617DTO(MyEntity3617 entity) {
        this.id = entity.getId().toString();
        this.customField = entity.getCustomField();
        this.customFieldNew = entity.getCustomFieldNew();
        this.customFieldDrillDown = entity.getCustomFieldDrillDown();
    }
}