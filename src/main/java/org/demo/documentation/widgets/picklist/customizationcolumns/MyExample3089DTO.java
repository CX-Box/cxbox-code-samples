package org.demo.documentation.widgets.picklist.customizationcolumns;

import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.Getter;
import org.cxbox.api.data.dto.DataResponseDTO;
import org.cxbox.core.util.filter.SearchParameter;
import org.cxbox.core.util.filter.provider.impl.LongValueProvider;


import java.util.Optional;

@Getter
@Setter
@NoArgsConstructor
public class MyExample3089DTO extends DataResponseDTO {

    @SearchParameter(name = "customField")
    private String customField;
    @SearchParameter(name = "customFieldPicklistEntity.customField")
    private String customFieldPicklist;
    @SearchParameter(name = "customFieldPicklistEntity.id", provider = LongValueProvider.class)
    private Long customFieldPicklistId;

    public MyExample3089DTO(MyEntity3089 entity) {
        this.id = entity.getId().toString();
        this.customField = entity.getCustomField();
        this.customFieldPicklistId = Optional.ofNullable(entity.getCustomFieldPicklistEntity())
                .map(e -> e.getId())
                .orElse(null);
        this.customFieldPicklist = Optional.ofNullable(entity.getCustomFieldPicklistEntity())
                .map(e -> e.getCustomField())
                .orElse(null);
    }
}