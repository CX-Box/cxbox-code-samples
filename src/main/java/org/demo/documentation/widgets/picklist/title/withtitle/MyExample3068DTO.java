package org.demo.documentation.widgets.picklist.title.withtitle;

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
public class MyExample3068DTO extends DataResponseDTO {


    @SearchParameter(name = "customFieldEntity.customFieldPick")
    private String customField;
    @SearchParameter(name = "customFieldEntity.id", provider = LongValueProvider.class)
    private Long customFieldId;

    public MyExample3068DTO(MyEntity3068 entity) {
        this.id = entity.getId().toString();


        this.customFieldId = Optional.ofNullable(entity.getCustomFieldEntity())
                .map(e -> e.getId())
                .orElse(null);
        this.customField = Optional.ofNullable(entity.getCustomFieldEntity())
                .map(e -> e.getCustomFieldPick())
                .orElse(null);
    }
}