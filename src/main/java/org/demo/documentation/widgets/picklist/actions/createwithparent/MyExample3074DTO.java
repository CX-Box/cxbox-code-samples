package org.demo.documentation.widgets.picklist.actions.createwithparent;

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
public class MyExample3074DTO extends DataResponseDTO {


    @SearchParameter(name = "customFieldEntity.customField", provider = StringValueProvider.class)
    private String customField;
    @SearchParameter(name = "customFieldEntity.id", provider = LongValueProvider.class)
    private Long customFieldId;
    @SearchParameter(name = "customFieldText", provider = StringValueProvider.class)
    private String customFieldText;
    @SearchParameter(name = "customFieldRequred", provider = StringValueProvider.class)
    private String customFieldRequred;

    public MyExample3074DTO(MyEntity3074 entity) {
        this.id = entity.getId().toString();

        this.customFieldId = Optional.ofNullable(entity.getCustomFieldEntity())
                .map(e -> e.getId())
                .orElse(null);
        this.customField = Optional.ofNullable(entity.getCustomFieldEntity())
                .map(e -> e.getCustomField())
                .orElse(null);
        this.customFieldText = entity.getCustomFieldText();
        this.customFieldRequred = entity.getCustomFieldRequred();
    }
}