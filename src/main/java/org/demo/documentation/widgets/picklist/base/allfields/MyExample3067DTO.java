package org.demo.documentation.widgets.picklist.base.allfields;

import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.Getter;
import org.cxbox.api.data.dto.DataResponseDTO;
import org.cxbox.core.util.filter.SearchParameter;
import org.cxbox.core.util.filter.provider.impl.LongValueProvider;
import org.cxbox.core.util.filter.provider.impl.StringValueProvider;

import java.util.Optional;

@Getter
@Setter
@NoArgsConstructor
public class MyExample3067DTO extends DataResponseDTO {


    @SearchParameter(name = "customFieldEntity.customFieldPick")
    private String customField;
    @SearchParameter(name = "customFieldEntity.id", provider = LongValueProvider.class)
    private Long customFieldId;
    @SearchParameter(name = "customFieldInlinePickListEntity.customField", provider = StringValueProvider.class)
    private String customFieldInlinePickList;
    @SearchParameter(name = "customFieldInlinePickListEntity.id", provider = LongValueProvider.class)
    private Long customFieldInlinePickListId;

    public MyExample3067DTO(MyEntity3067 entity) {
        this.id = entity.getId().toString();

        this.customFieldId = Optional.ofNullable(entity.getCustomFieldEntity())
                .map(e -> e.getId())
                .orElse(null);
        this.customField = Optional.ofNullable(entity.getCustomFieldEntity())
                .map(e -> e.getCustomFieldPick())
                .orElse(null);
        this.customFieldInlinePickListId = Optional.ofNullable(entity.getCustomFieldInlinePickListEntity())
                .map(e -> e.getId())
                .orElse(null);
        this.customFieldInlinePickList = Optional.ofNullable(entity.getCustomFieldInlinePickListEntity())
                .map(e -> e.getCustomField())
                .orElse(null);
    }
}