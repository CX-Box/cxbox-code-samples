package org.demo.documentation.widgets.picklist.base.onefield;

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
public class MyExample3079DTO extends DataResponseDTO {

    @SearchParameter(name = "customField")
    private String customField;
    @SearchParameter(name = "customFieldPickListEntity.customField")
    private String customFieldPickList;
    @SearchParameter(name = "customFieldPickListEntity.id", provider = LongValueProvider.class)
    private Long customFieldPickListId;
    @SearchParameter(name = "customFieldInlinePickListEntity.customField")
    private String customFieldInlinePickList;
    @SearchParameter(name = "customFieldInlinePickListEntity.id", provider = LongValueProvider.class)
    private Long customFieldInlinePickListId;

    public MyExample3079DTO(MyEntity3079 entity) {
        this.id = entity.getId().toString();
        this.customField = entity.getCustomField();
        this.customFieldPickListId = Optional.ofNullable(entity.getCustomFieldPickListEntity())
                .map(e -> e.getId())
                .orElse(null);
        this.customFieldPickList = Optional.ofNullable(entity.getCustomFieldPickListEntity())
                .map(e -> e.getCustomField())
                .orElse(null);
        this.customFieldInlinePickListId = Optional.ofNullable(entity.getCustomFieldInlinePickListEntity())
                .map(e -> e.getId())
                .orElse(null);
        this.customFieldInlinePickList = Optional.ofNullable(entity.getCustomFieldInlinePickListEntity())
                .map(e -> e.getCustomField())
                .orElse(null);
    }
}