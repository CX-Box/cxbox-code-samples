package org.demo.documentation.widgets.picklist.color;

import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.Getter;
import org.cxbox.api.data.dto.DataResponseDTO;
import org.cxbox.core.util.filter.SearchParameter;
import org.cxbox.core.util.filter.provider.impl.DateValueProvider;
import org.cxbox.core.util.filter.provider.impl.LongValueProvider;
import org.cxbox.core.util.filter.provider.impl.StringValueProvider;

import java.util.Optional;

@Getter
@Setter
@NoArgsConstructor
public class MyExample3060DTO extends DataResponseDTO {

    private String customField;
    @SearchParameter(name = "customFieldPicklistEntity.customField", provider = StringValueProvider.class)
    private String customFieldPicklist;
    @SearchParameter(name = "customFieldPicklistEntity.id", provider = LongValueProvider.class)
    private Long customFieldPicklistId;

    public MyExample3060DTO(MyEntity3060 entity) {
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