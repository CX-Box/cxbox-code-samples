package org.demo.documentation.widgets.picklist.actions.cancelcreate;

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
public class MyExample3198DTO extends DataResponseDTO {

    @SearchParameter(name = "customField")
    private String customField;
    @SearchParameter(name = "customFieldPickListEntity.customField")
    private String customFieldPickList;
    @SearchParameter(name = "customFieldPickListEntity.id", provider = LongValueProvider.class)
    private Long customFieldPickListId;
    @SearchParameter(name = "customFieldPickListOnCancelEntity.customField")
    private String customFieldPickListOnCancel;
    @SearchParameter(name = "customFieldPickListOnCancelEntity.id", provider = LongValueProvider.class)
    private Long customFieldPickListOnCancelId;
    @SearchParameter(name = "customFieldPickListPostActionEntity.customField")
    private String customFieldPickListPostAction;
    @SearchParameter(name = "customFieldPickListPostActionEntity.id", provider = LongValueProvider.class)
    private Long customFieldPickListPostActionId;

    public MyExample3198DTO(MyEntity3198 entity) {
        this.id = entity.getId().toString();
        this.customField = entity.getCustomField();
        this.customFieldPickListId = Optional.ofNullable(entity.getCustomFieldPickListEntity())
                .map(e -> e.getId())
                .orElse(null);
        this.customFieldPickList = Optional.ofNullable(entity.getCustomFieldPickListEntity())
                .map(e -> e.getCustomField())
                .orElse(null);
        this.customFieldPickListOnCancelId = Optional.ofNullable(entity.getCustomFieldPickListOnCancelEntity())
                .map(e -> e.getId())
                .orElse(null);
        this.customFieldPickListOnCancel = Optional.ofNullable(entity.getCustomFieldPickListOnCancelEntity())
                .map(e -> e.getCustomField())
                .orElse(null);
        this.customFieldPickListPostActionId = Optional.ofNullable(entity.getCustomFieldPickListPostActionEntity())
                .map(e -> e.getId())
                .orElse(null);
        this.customFieldPickListPostAction = Optional.ofNullable(entity.getCustomFieldPickListPostActionEntity())
                .map(e -> e.getCustomField())
                .orElse(null);
    }
}