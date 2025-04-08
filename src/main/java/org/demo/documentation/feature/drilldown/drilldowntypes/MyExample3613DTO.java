package org.demo.documentation.feature.drilldown.drilldowntypes;

import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.Getter;
import org.cxbox.api.data.dto.DataResponseDTO;
import org.cxbox.core.util.filter.SearchParameter;


@Getter
@Setter
@NoArgsConstructor
public class MyExample3613DTO extends DataResponseDTO {

    private String customField;
    @SearchParameter(name = "customFieldExternal")
    private String customFieldExternal;
    @SearchParameter(name = "customFieldExternalNew")
    private String customFieldExternalNew;
    @SearchParameter(name = "customFieldRelative")
    private String customFieldRelative;
    @SearchParameter(name = "customFieldRelativeNew")
    private String customFieldRelativeNew;

    public MyExample3613DTO(MyEntity3613 entity) {
        this.id = entity.getId().toString();
        this.customField = entity.getCustomField();
        this.customFieldExternal = entity.getCustomFieldExternal();
        this.customFieldExternalNew = entity.getCustomFieldExternalNew();
        this.customFieldRelative = entity.getCustomFieldRelative();
        this.customFieldRelativeNew = entity.getCustomFieldRelativeNew();
    }
}